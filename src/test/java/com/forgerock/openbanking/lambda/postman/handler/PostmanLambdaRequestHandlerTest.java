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
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forgerock.openbanking.lambda.postman.model.monitoring.multi.OBMonitoringTestsResult;
import com.forgerock.openbanking.lambda.postman.model.postman.PostmanMonitoringResult;
import com.forgerock.openbanking.lambda.postman.service.PostmanService;
import org.hamcrest.core.IsNull;
import org.mockito.Mock;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class PostmanLambdaRequestHandlerTest {

    @Mock
    private Context context;
    @Mock
    private LambdaLogger lambdaLogger;
    private PostmanService postmanService = new PostmanService();

    private ObjectMapper objectMapper = new ObjectMapper();

    //@Test
    public void handleRequest() throws IOException {
        //Given
        final String json = getFile("EndToEndTests.postman_test_run.json");
        final ObjectMapper mapper = new ObjectMapper();
        final PostmanMonitoringResult postmanMonitoringResult = mapper.readValue(json, PostmanMonitoringResult.class);
        final PostmanLambdaRequestHandler postmanLambdaRequestHandler = new PostmanLambdaRequestHandler();
        when(context.getLogger()).thenReturn(lambdaLogger);
        InputStream stream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //When
        postmanLambdaRequestHandler.handleRequest(stream, baos, context);
        InputStream isFromFirstData = new ByteArrayInputStream(baos.toByteArray());

        OBMonitoringTestsResult monitoringTestsResult = objectMapper.readValue(isFromFirstData, OBMonitoringTestsResult.class);
        //Then
        assertThat(monitoringTestsResult, IsNull.notNullValue());
    }

    private String getFile(String fileName) {

        StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

}