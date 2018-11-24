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
import com.forgerock.openbanking.lambda.postman.model.slack.Attachment;
import com.forgerock.openbanking.lambda.postman.model.slack.SlackNotification;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Slack service, for sending notifications.
 */
public class SlackService {
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Create a success notification
     * @param title the notification title
     * @param message the notification message
     * @return the slack notification
     */
    public SlackNotification success(String title, String message) {
        SlackNotification notification = new SlackNotification();
        notification.setText(title);
        Attachment attachment = new Attachment();
        attachment.setText(message);
        attachment.setColor("#0db133");
        notification.addAttachment(attachment);
        return notification;
    }

    /**
     * Create a error notification
     * @param title the notification title
     * @param message the notification message
     * @return the slack notification
     */
    public SlackNotification error(String title, String message) {
        SlackNotification notification = new SlackNotification();
        notification.setText(title);
        Attachment attachment = new Attachment();
        attachment.setText(message);
        attachment.setColor("#f44336");
        notification.addAttachment(attachment);
        return notification;
    }

    /**
     * Create a warning notification
     * @param title the notification title
     * @param message the notification message
     * @return the slack notification
     */
    public SlackNotification warning(String title, String message) {
        SlackNotification notification = new SlackNotification();
        notification.setText(title);
        Attachment attachment = new Attachment();
        attachment.setText(message);
        attachment.setColor("#f4ab36");
        notification.addAttachment(attachment);
        return notification;
    }

    /**
     * Send a notification to slack
     * @param notification the slack notification message
     * @param context the lambda context
     */
    public void sendNotification(SlackNotification notification, Context context) {
        LambdaConfiguration config = LambdaConfiguration.getInstance();

        if (config.getSlackWebHook() == null || "".equals(config.getSlackWebHook())) {
            context.getLogger().log("Slack web hook not setup. Skipping slack notification.");
            return;
        }

        context.getLogger().log("Call '" + config.getSlackWebHook() + "' with content ='" + notification + "'");
        try {
            URL url = new URL( config.getSlackWebHook());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            // Send post request
            conn.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(objectMapper.writeValueAsString(notification));
            wr.flush();
            wr.close();
            context.getLogger().log("Response code " + conn.getResponseCode() + " \n");

            if (!(200 <= conn.getResponseCode() && conn.getResponseCode() < 300)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getErrorStream())));
                String output;
                context.getLogger().log("Error from Server .... \n");
                while ((output = br.readLine()) != null) {
                    context.getLogger().log(output);
                }

                conn.disconnect();
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            StringBuilder result = new StringBuilder();
            String output;
            context.getLogger().log("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                result.append(output);
            }

            context.getLogger().log("Result from slack service : " + result.toString());
            conn.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
