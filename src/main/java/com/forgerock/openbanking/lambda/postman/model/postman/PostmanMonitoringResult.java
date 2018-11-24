
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

package com.forgerock.openbanking.lambda.postman.model.postman;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "collection_name",
    "collection_uid",
    "environment_name",
    "environment_uid",
    "metrics",
    "monitor_name",
    "monitor_uid",
    "user_id",
    "user_name"
})
public class PostmanMonitoringResult {

    @JsonProperty("collection_name")
    private String collectionName;
    @JsonProperty("collection_uid")
    private String collectionUid;
    @JsonProperty("environment_name")
    private String environmentName;
    @JsonProperty("environment_uid")
    private String environmentUid;
    @JsonProperty("metrics")
    private Metrics metrics;
    @JsonProperty("monitor_name")
    private String monitorName;
    @JsonProperty("monitor_uid")
    private String monitorUid;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PostmanMonitoringResult() {
    }

    /**
     * 
     * @param metrics
     * @param monitorUid
     * @param userId
     * @param userName
     * @param environmentName
     * @param environmentUid
     * @param monitorName
     * @param collectionUid
     * @param collectionName
     */
    public PostmanMonitoringResult(String collectionName, String collectionUid, String environmentName, String environmentUid, Metrics metrics, String monitorName, String monitorUid, String userId, String userName) {
        super();
        this.collectionName = collectionName;
        this.collectionUid = collectionUid;
        this.environmentName = environmentName;
        this.environmentUid = environmentUid;
        this.metrics = metrics;
        this.monitorName = monitorName;
        this.monitorUid = monitorUid;
        this.userId = userId;
        this.userName = userName;
    }

    @JsonProperty("collection_name")
    public String getCollectionName() {
        return collectionName;
    }

    @JsonProperty("collection_name")
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    @JsonProperty("collection_uid")
    public String getCollectionUid() {
        return collectionUid;
    }

    @JsonProperty("collection_uid")
    public void setCollectionUid(String collectionUid) {
        this.collectionUid = collectionUid;
    }

    @JsonProperty("environment_name")
    public String getEnvironmentName() {
        return environmentName;
    }

    @JsonProperty("environment_name")
    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    @JsonProperty("environment_uid")
    public String getEnvironmentUid() {
        return environmentUid;
    }

    @JsonProperty("environment_uid")
    public void setEnvironmentUid(String environmentUid) {
        this.environmentUid = environmentUid;
    }

    @JsonProperty("metrics")
    public Metrics getMetrics() {
        return metrics;
    }

    @JsonProperty("metrics")
    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    @JsonProperty("monitor_name")
    public String getMonitorName() {
        return monitorName;
    }

    @JsonProperty("monitor_name")
    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    @JsonProperty("monitor_uid")
    public String getMonitorUid() {
        return monitorUid;
    }

    @JsonProperty("monitor_uid")
    public void setMonitorUid(String monitorUid) {
        this.monitorUid = monitorUid;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("user_name")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("user_name")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("collectionName", collectionName).append("collectionUid", collectionUid).append("environmentName", environmentName).append("environmentUid", environmentUid).append("metrics", metrics).append("monitorName", monitorName).append("monitorUid", monitorUid).append("userId", userId).append("userName", userName).append("additionalProperties", additionalProperties).toString();
    }

}
