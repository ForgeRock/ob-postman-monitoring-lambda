/*
 *  The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 *  You can obtain a copy of the License at https://forgerock.org/cddlv1-0/. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 *  information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2018 ForgeRock AS.
 */

package com.forgerock.openbanking.lambda.postman.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forgerock.openbanking.lambda.postman.config.LambdaConfiguration;
import com.forgerock.openbanking.lambda.postman.model.monitoring.multi.OBMonitoringTestsResult;
import com.forgerock.openbanking.lambda.postman.model.monitoring.multi.Request;
import com.forgerock.openbanking.lambda.postman.model.monitoring.multi.Response;
import com.forgerock.openbanking.lambda.postman.model.postman.Execution;
import com.forgerock.openbanking.lambda.postman.model.postman.PostmanMonitoringExecutionResult;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class MonitoringService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private SlackService slackService = new SlackService();

    public String sendMonitoringResult(OBMonitoringTestsResult monitoringTestsResult, Context context) {

        LambdaConfiguration config = LambdaConfiguration.getInstance();

        context.getLogger().log("Call '" + config.getMonitoringUri() + "/api/requests' with app uid='" + config.getApplicationId() + "'");
        try {
            URL url = new URL( config.getMonitoringUri() + "/api/requests");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            String encoding = Base64.getEncoder().encodeToString((config.getApplicationId() + ":" + config.getApplicationSecret()).getBytes());
            conn.setRequestProperty("Authorization", "Basic " + encoding);
            // Send post request
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(objectMapper.writeValueAsString(monitoringTestsResult));
            wr.flush();
            wr.close();
            context.getLogger().log("Response code from the monitoring service: " + conn.getResponseCode() + " \n");

            if (!(200 <= conn.getResponseCode() && conn.getResponseCode() < 300)) {
                context.getLogger().log("The server has returned an error. Read the body of the error.");
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getErrorStream())));
                String output;
                StringBuilder result = new StringBuilder();

                context.getLogger().log("Error from Server .... \n");
                while ((output = br.readLine()) != null) {
                    context.getLogger().log(output);
                    result.append(output);
                }

                if (400 <= conn.getResponseCode() && conn.getResponseCode() < 500) {
                    slackService.sendNotification(slackService.error(
                            "Monitoring stats notification to '" + config.getMonitoringUri() + "' failed due to a bad request '" + conn.getResponseCode() + "'",
                            "Error! The message received by the monitoring service '" + result + "'" ),
                            context);
                } else if (500 <= conn.getResponseCode() && conn.getResponseCode() < 600) {
                    slackService.sendNotification(slackService.warning(
                            "Monitoring stats notification to '" + config.getMonitoringUri() + "' failed due to a server error on the monitoring side: '" + conn.getResponseCode() + "'",
                            "Error! The message received by the monitoring service '" + result + "'" ),
                            context);
                }

                conn.disconnect();
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            context.getLogger().log("Successful response from the server. Reading the response body.");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            StringBuilder result = new StringBuilder();
            String output;
            context.getLogger().log("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                result.append(output);
            }

            context.getLogger().log("Result from monitoring service : " + result.toString());
            conn.disconnect();
            slackService.sendNotification(slackService.success(
                    "Monitoring stats send successfully to '" + config.getMonitoringUri() + "'",
                    "Success! You can see the result here: " + config.getMonitoringUri() + "/#!institution/" + config.getInstitutionId() ), context);

            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert Postman result into the monitoring input format
     * @param config the lambda configuration
     * @param postmanMonitoringExecResult the postman result output
     * @return the monitoring service input
     */
    public OBMonitoringTestsResult convertPostmanResult(LambdaConfiguration config, PostmanMonitoringExecutionResult postmanMonitoringExecResult, Context context) {

        OBMonitoringTestsResult monitoringTestsResult = new OBMonitoringTestsResult();
        monitoringTestsResult.setApplicationUuid(config.getApplicationId());
        monitoringTestsResult.setInstitutionId(config.getInstitutionId());
        monitoringTestsResult.setTime(postmanMonitoringExecResult.getRun().getInfo().getStartedAt());
        monitoringTestsResult.setOriginRegion(config.getOriginRegion());

        for(Execution execution: postmanMonitoringExecResult.getRun().getExecutions()) {
            context.getLogger().log("Convert execution='" + execution + "'");
            Request request = new Request();
            request.setMethod(execution.getRequest().getMethod());
            request.setTime(execution.getRequest().getTimestamp());
            request.setUriTemplate(getUriTemplate(execution, context).toLowerCase());

            Response response = new Response();
            response.setCode(execution.getResponse().getCode());
            response.setDetails(execution.getItem().getName());
            response.setSize(execution.getResponse().getResponseSize());
            response.setType(getType(execution.getResponse().getCode()));
            Double timeInSec = 0.0;
            if (execution.getResponse().getResponseTime() != null) {
                timeInSec = execution.getResponse().getResponseTime() / 1000.0;
            }
            response.setDuration("PT" + timeInSec + "S");
            request.setResponse(response);
            monitoringTestsResult.addRequest(request);
        }

        return monitoringTestsResult;
    }

    private String getUriTemplate(Execution execution, Context context) {

        try {
            URL url = new URL(execution.getRequest().getUrl());

            /**
             * A bit of a hack for getting the uri template. The workaround that seems to work is to use the
             * postman request name and parse it. The format expected here is that everything followed by a - will be the
             * uri template.
             */
            String name = execution.getItem().getName();
            if (name != null) {
                String[] split = name.split("- ");
                if (split.length > 1) {
                    return url.getHost() + split[split.length -1];
                }
            }
            return url.getHost() + url.getPath();
        } catch (MalformedURLException e) {
            context.getLogger().log("Couldn't parse url '" + execution.getRequest().getUrl() + "'");
            throw new RuntimeException(e);
        }
    }

    private String getType(Integer code) {
        if (code != null && 200 <= code && code < 300 ) {
            return "SUCCESS";
        }
        return "ERROR";
    }
}
