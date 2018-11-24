
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
    "code",
    "body",
    "responseTime",
    "responseSize",
    "headers"
})
public class Response {

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("body")
    private Body_ body;
    @JsonProperty("responseTime")
    private Integer responseTime;
    @JsonProperty("responseSize")
    private Integer responseSize;
    @JsonProperty("headers")
    private Headers_ headers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty("body")
    public Body_ getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(Body_ body) {
        this.body = body;
    }

    @JsonProperty("responseTime")
    public Integer getResponseTime() {
        return responseTime;
    }

    @JsonProperty("responseTime")
    public void setResponseTime(Integer responseTime) {
        this.responseTime = responseTime;
    }

    @JsonProperty("responseSize")
    public Integer getResponseSize() {
        return responseSize;
    }

    @JsonProperty("responseSize")
    public void setResponseSize(Integer responseSize) {
        this.responseSize = responseSize;
    }

    @JsonProperty("headers")
    public Headers_ getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Headers_ headers) {
        this.headers = headers;
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
        return new ToStringBuilder(this).append("code", code).append("body", body).append("responseTime", responseTime).append("responseSize", responseSize).append("headers", headers).append("additionalProperties", additionalProperties).toString();
    }

}
