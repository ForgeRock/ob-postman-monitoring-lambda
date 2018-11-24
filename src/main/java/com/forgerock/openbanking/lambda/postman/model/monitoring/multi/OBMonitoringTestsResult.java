
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

package com.forgerock.openbanking.lambda.postman.model.monitoring.multi;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "applicationUuid",
    "time",
    "originRegion",
    "institutionId",
    "requests"
})
public class OBMonitoringTestsResult {

    @JsonProperty("applicationUuid")
    private String applicationUuid;
    @JsonProperty("time")
    private String time;
    @JsonProperty("originRegion")
    private String originRegion;
    @JsonProperty("institutionId")
    private String institutionId;
    @JsonProperty("requests")
    private List<Request> requests = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("applicationUuid")
    public String getApplicationUuid() {
        return applicationUuid;
    }

    @JsonProperty("applicationUuid")
    public void setApplicationUuid(String applicationUuid) {
        this.applicationUuid = applicationUuid;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("originRegion")
    public String getOriginRegion() {
        return originRegion;
    }

    @JsonProperty("originRegion")
    public void setOriginRegion(String originRegion) {
        this.originRegion = originRegion;
    }

    @JsonProperty("institutionId")
    public String getInstitutionId() {
        return institutionId;
    }

    @JsonProperty("institutionId")
    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    @JsonProperty("requests")
    public List<Request> getRequests() {
        return requests;
    }

    @JsonProperty("requests")
    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void addRequest(Request request) {
        this.requests.add(request);
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
        return new ToStringBuilder(this).append("applicationUuid", applicationUuid).append("time", time).append("originRegion", originRegion).append("institutionId", institutionId).append("requests", requests).append("additionalProperties", additionalProperties).toString();
    }

}
