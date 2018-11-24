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
import com.forgerock.openbanking.lambda.postman.model.postman.PostmanMonitoringExecutionResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Postman API service.
 */
public class PostmanService {
    private ObjectMapper objectMapper = new ObjectMapper();
    private SlackService slackService = new SlackService();

    /**
     * Run the postman monitoring collection and parse the result.
     * @param config the lambda configuration properties
     * @param context the lambda context
     * @return the postman result
     */
    public PostmanMonitoringExecutionResult getPostmanMonitoringResult(LambdaConfiguration config, Context context) {

        String apiKey = System.getenv("apiKey");
        context.getLogger().log("Call 'https://api.getpostman.com/monitors/" + config.getMonitoringId() + "/run'");
        try {
            URL url = new URL("https://api.getpostman.com/monitors/" + config.getMonitoringId() + "/run");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("X-Api-Key", apiKey);

            if (conn.getResponseCode() != 200) {
                context.getLogger().log("We received an error from the server. Error code=" + conn.getResponseCode());
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getErrorStream())));
                String output;
                context.getLogger().log("Error from Server .... \n");
                while ((output = br.readLine()) != null) {
                    context.getLogger().log(output);
                }

                if (400 <= conn.getResponseCode() && conn.getResponseCode() < 500) {
                    slackService.sendNotification(slackService.error(
                            "Executing the collection '" + config.getMonitoringId() + "' test suits failed, due to a bad request '" + conn.getResponseCode() + "'",
                            "Error! The message received by postman service '" + output + "'" ),
                            context);
                } else if (500 <= conn.getResponseCode() && conn.getResponseCode() < 600) {
                    slackService.sendNotification(slackService.warning(
                            "Executing the collection '" + config.getMonitoringId() + "' test suits failed, due to an error on postman side '" + conn.getResponseCode() + "'",
                            "Error! The message received by postman service '" + output + "'" ),
                            context);
                }
                slackService.sendNotification(slackService.error(
                        "Executing the collection '" + config.getMonitoringId() + "' test suits failed with an unexpected error code '" + conn.getResponseCode() + "'",
                        "Error! The message received by postman service '" + output + "'" ),
                        context);

                conn.disconnect();
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            context.getLogger().log("Successful response from the server, we read the body of the response.");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            StringBuilder result = new StringBuilder();
            String output;
            context.getLogger().log("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                result.append(output);
            }

            context.getLogger().log("The postman result as a json : " + result.toString());
            conn.disconnect();
            return objectMapper.readValue(result.toString(), PostmanMonitoringExecutionResult.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
