
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
    "errors",
    "failedTests",
    "passedTests",
    "requestCount",
    "totalLatency",
    "warnings"
})
public class Metrics {

    @JsonProperty("errors")
    private Integer errors;
    @JsonProperty("failedTests")
    private Integer failedTests;
    @JsonProperty("passedTests")
    private Integer passedTests;
    @JsonProperty("requestCount")
    private Integer requestCount;
    @JsonProperty("totalLatency")
    private Integer totalLatency;
    @JsonProperty("warnings")
    private Integer warnings;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metrics() {
    }

    /**
     * 
     * @param errors
     * @param totalLatency
     * @param requestCount
     * @param passedTests
     * @param failedTests
     * @param warnings
     */
    public Metrics(Integer errors, Integer failedTests, Integer passedTests, Integer requestCount, Integer totalLatency, Integer warnings) {
        super();
        this.errors = errors;
        this.failedTests = failedTests;
        this.passedTests = passedTests;
        this.requestCount = requestCount;
        this.totalLatency = totalLatency;
        this.warnings = warnings;
    }

    @JsonProperty("errors")
    public Integer getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(Integer errors) {
        this.errors = errors;
    }

    @JsonProperty("failedTests")
    public Integer getFailedTests() {
        return failedTests;
    }

    @JsonProperty("failedTests")
    public void setFailedTests(Integer failedTests) {
        this.failedTests = failedTests;
    }

    @JsonProperty("passedTests")
    public Integer getPassedTests() {
        return passedTests;
    }

    @JsonProperty("passedTests")
    public void setPassedTests(Integer passedTests) {
        this.passedTests = passedTests;
    }

    @JsonProperty("requestCount")
    public Integer getRequestCount() {
        return requestCount;
    }

    @JsonProperty("requestCount")
    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    @JsonProperty("totalLatency")
    public Integer getTotalLatency() {
        return totalLatency;
    }

    @JsonProperty("totalLatency")
    public void setTotalLatency(Integer totalLatency) {
        this.totalLatency = totalLatency;
    }

    @JsonProperty("warnings")
    public Integer getWarnings() {
        return warnings;
    }

    @JsonProperty("warnings")
    public void setWarnings(Integer warnings) {
        this.warnings = warnings;
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
        return new ToStringBuilder(this).append("errors", errors).append("failedTests", failedTests).append("passedTests", passedTests).append("requestCount", requestCount).append("totalLatency", totalLatency).append("warnings", warnings).append("additionalProperties", additionalProperties).toString();
    }

}
