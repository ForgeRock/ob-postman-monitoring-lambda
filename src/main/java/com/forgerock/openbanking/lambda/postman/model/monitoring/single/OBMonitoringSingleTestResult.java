
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

package com.forgerock.openbanking.lambda.postman.model.monitoring.single;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "applicationUuid",
    "time",
    "originRegion",
    "institutionId",
    "method",
    "uriTemplate",
    "response"
})
public class OBMonitoringSingleTestResult {

    @JsonProperty("applicationUuid")
    private String applicationUuid;
    @JsonProperty("time")
    private String time;
    @JsonProperty("originRegion")
    private String originRegion;
    @JsonProperty("institutionId")
    private String institutionId;
    @JsonProperty("method")
    private String method;
    @JsonProperty("uriTemplate")
    private String uriTemplate;
    @JsonProperty("response")
    private Response response;
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

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("uriTemplate")
    public String getUriTemplate() {
        return uriTemplate;
    }

    @JsonProperty("uriTemplate")
    public void setUriTemplate(String uriTemplate) {
        this.uriTemplate = uriTemplate;
    }

    @JsonProperty("response")
    public Response getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(Response response) {
        this.response = response;
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
        return new ToStringBuilder(this).append("applicationUuid", applicationUuid).append("time", time).append("originRegion", originRegion).append("institutionId", institutionId).append("method", method).append("uriTemplate", uriTemplate).append("response", response).append("additionalProperties", additionalProperties).toString();
    }

}
