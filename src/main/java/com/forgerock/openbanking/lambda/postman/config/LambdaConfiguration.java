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

package com.forgerock.openbanking.lambda.postman.config;

/**
 * Lambda configuration. Setup all the properties related to your project.
 */
public class LambdaConfiguration {

    private static LambdaConfiguration lambdaConfiguration = new LambdaConfiguration();

    public static LambdaConfiguration getInstance() {
        return lambdaConfiguration;
    }

    private final String monitoringId;
    private final String applicationId;
    private final String institutionId;
    private final String originRegion;
    private final String slackWebHook;
    private final String monitoringUri;
    private final String applicationSecret;

    public LambdaConfiguration() {
        this.monitoringId = System.getenv("monitoringId");
        this.applicationId = System.getenv("applicationId");
        this.institutionId = System.getenv("institutionId");
        this.originRegion = System.getenv("originRegion");
        this.slackWebHook = System.getenv("slackWebHook");
        this.monitoringUri = System.getenv("monitoringUri");
        this.applicationSecret = System.getenv("applicationSecret");
    }

    /**
     * Get the Postman monitoring ID
     * @return monitoring ID
     */
    public String getMonitoringId() {
        return monitoringId;
    }

    /**
     * Get the monitoring service application ID
     * @return application ID
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Get the monitoring institution ID
     * @return institution ID
     */
    public String getInstitutionId() {
        return institutionId;
    }

    /**
     * Get the monitoring origin region. In our case, it would be the region where we selected the postman to be run from
     * @return origin region
     */
    public String getOriginRegion() {
        return originRegion;
    }

    /**
     * Slack web hook where we will send notification of this lambda execution
     * @return slack web hook
     */
    public String getSlackWebHook() {
        return slackWebHook;
    }

    /**
     * Get Monitoring service URI
     * @return monitoring URI
     */
    public String getMonitoringUri() {
        return monitoringUri;
    }

    /**
     * Get the application secret
     * @return the application secret
     */
    public String getApplicationSecret() {
        return applicationSecret;
    }
}
