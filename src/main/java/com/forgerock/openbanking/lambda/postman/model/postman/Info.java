
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
    "jobId",
    "monitorId",
    "name",
    "collectionUid",
    "environmentUid",
    "status",
    "startedAt",
    "finishedAt"
})
public class Info {

    @JsonProperty("jobId")
    private String jobId;
    @JsonProperty("monitorId")
    private String monitorId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("collectionUid")
    private String collectionUid;
    @JsonProperty("environmentUid")
    private String environmentUid;
    @JsonProperty("status")
    private String status;
    @JsonProperty("startedAt")
    private String startedAt;
    @JsonProperty("finishedAt")
    private String finishedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("jobId")
    public String getJobId() {
        return jobId;
    }

    @JsonProperty("jobId")
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @JsonProperty("monitorId")
    public String getMonitorId() {
        return monitorId;
    }

    @JsonProperty("monitorId")
    public void setMonitorId(String monitorId) {
        this.monitorId = monitorId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("collectionUid")
    public String getCollectionUid() {
        return collectionUid;
    }

    @JsonProperty("collectionUid")
    public void setCollectionUid(String collectionUid) {
        this.collectionUid = collectionUid;
    }

    @JsonProperty("environmentUid")
    public String getEnvironmentUid() {
        return environmentUid;
    }

    @JsonProperty("environmentUid")
    public void setEnvironmentUid(String environmentUid) {
        this.environmentUid = environmentUid;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("startedAt")
    public String getStartedAt() {
        return startedAt;
    }

    @JsonProperty("startedAt")
    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    @JsonProperty("finishedAt")
    public String getFinishedAt() {
        return finishedAt;
    }

    @JsonProperty("finishedAt")
    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
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
        return new ToStringBuilder(this).append("jobId", jobId).append("monitorId", monitorId).append("name", name).append("collectionUid", collectionUid).append("environmentUid", environmentUid).append("status", status).append("startedAt", startedAt).append("finishedAt", finishedAt).append("additionalProperties", additionalProperties).toString();
    }

}
