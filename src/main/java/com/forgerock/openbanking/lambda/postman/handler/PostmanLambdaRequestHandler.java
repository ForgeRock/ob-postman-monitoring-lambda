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

package com.forgerock.openbanking.lambda.postman.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forgerock.openbanking.lambda.postman.config.LambdaConfiguration;
import com.forgerock.openbanking.lambda.postman.model.monitoring.multi.OBMonitoringTestsResult;
import com.forgerock.openbanking.lambda.postman.model.postman.PostmanMonitoringExecutionResult;
import com.forgerock.openbanking.lambda.postman.service.MonitoringService;
import com.forgerock.openbanking.lambda.postman.service.PostmanService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The lambda request handler. It's the equivalent of the main
 */
public class PostmanLambdaRequestHandler implements RequestStreamHandler {

    private ObjectMapper objectMapper = new ObjectMapper();
    private PostmanService postmanService = new PostmanService();
    private MonitoringService monitoringService = new MonitoringService();

    /**
     * Handler called by the lambda
     * @param inputStream the input we send to the lambda. We are not using this feature yet
     * @param outputStream the output of the lambda. We don't really have a hook after the lambda. We will just print a
     *                     simple message
     * @param context the lambda context, which contains the debugger
     * @throws IOException
     */
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        LambdaConfiguration config = LambdaConfiguration.getInstance();

        context.getLogger().log("Start the lambda for the monitoringId=" + config.getMonitoringId());

        PostmanMonitoringExecutionResult postmanMonitoringExecResult = postmanService.getPostmanMonitoringResult(config, context);
        context.getLogger().log("We received the following response from postman. postmanMonitoringExecResult: " + postmanMonitoringExecResult);

        OBMonitoringTestsResult monitoringTestsResult = monitoringService.convertPostmanResult(config, postmanMonitoringExecResult);
        context.getLogger().log("We converted the result into the monitoring format : monitoringTestsResult=" + objectMapper.writeValueAsString(monitoringTestsResult));

        monitoringService.sendMonitoringResult(monitoringTestsResult, context);
        context.getLogger().log("Result send successfully to the monitoring service. Lambda will now shut down.");

        //Output of our lambda
        objectMapper.writeValue(outputStream,  "Lambda successfully notify the monitoring status of monitoringId=" + config.getMonitoringId());
    }
}
