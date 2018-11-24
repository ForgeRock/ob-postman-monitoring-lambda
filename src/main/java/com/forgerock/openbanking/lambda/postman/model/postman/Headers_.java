
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
    "Server",
    "Date",
    "Content-Type",
    "Transfer-Encoding",
    "Connection",
    "Vary",
    "x-fapi-interaction-id",
    "X-Content-Type-Options",
    "X-XSS-Protection",
    "Cache-Control",
    "Pragma",
    "Expires",
    "Strict-Transport-Security",
    "X-Frame-Options",
    "Content-Encoding"
})
public class Headers_ {

    @JsonProperty("Server")
    private Object server;
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Content-Type")
    private String contentType;
    @JsonProperty("Transfer-Encoding")
    private String transferEncoding;
    @JsonProperty("Connection")
    private String connection;
    @JsonProperty("Vary")
    private Object vary;
    @JsonProperty("x-fapi-interaction-id")
    private Object xFapiInteractionId;
    @JsonProperty("X-Content-Type-Options")
    private Object xContentTypeOptions;
    @JsonProperty("X-XSS-Protection")
    private Object xXSSProtection;
    @JsonProperty("Cache-Control")
    private String cacheControl;
    @JsonProperty("Pragma")
    private String pragma;
    @JsonProperty("Expires")
    private Object expires;
    @JsonProperty("Strict-Transport-Security")
    private Object strictTransportSecurity;
    @JsonProperty("X-Frame-Options")
    private Object xFrameOptions;
    @JsonProperty("Content-Encoding")
    private String contentEncoding;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Server")
    public Object getServer() {
        return server;
    }

    @JsonProperty("Server")
    public void setServer(Object server) {
        this.server = server;
    }

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("Content-Type")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("Content-Type")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("Transfer-Encoding")
    public String getTransferEncoding() {
        return transferEncoding;
    }

    @JsonProperty("Transfer-Encoding")
    public void setTransferEncoding(String transferEncoding) {
        this.transferEncoding = transferEncoding;
    }

    @JsonProperty("Connection")
    public String getConnection() {
        return connection;
    }

    @JsonProperty("Connection")
    public void setConnection(String connection) {
        this.connection = connection;
    }

    @JsonProperty("Vary")
    public Object getVary() {
        return vary;
    }

    @JsonProperty("Vary")
    public void setVary(Object vary) {
        this.vary = vary;
    }

    @JsonProperty("x-fapi-interaction-id")
    public Object getXFapiInteractionId() {
        return xFapiInteractionId;
    }

    @JsonProperty("x-fapi-interaction-id")
    public void setXFapiInteractionId(Object xFapiInteractionId) {
        this.xFapiInteractionId = xFapiInteractionId;
    }

    @JsonProperty("X-Content-Type-Options")
    public Object getXContentTypeOptions() {
        return xContentTypeOptions;
    }

    @JsonProperty("X-Content-Type-Options")
    public void setXContentTypeOptions(Object xContentTypeOptions) {
        this.xContentTypeOptions = xContentTypeOptions;
    }

    @JsonProperty("X-XSS-Protection")
    public Object getXXSSProtection() {
        return xXSSProtection;
    }

    @JsonProperty("X-XSS-Protection")
    public void setXXSSProtection(Object xXSSProtection) {
        this.xXSSProtection = xXSSProtection;
    }

    @JsonProperty("Cache-Control")
    public String getCacheControl() {
        return cacheControl;
    }

    @JsonProperty("Cache-Control")
    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    @JsonProperty("Pragma")
    public String getPragma() {
        return pragma;
    }

    @JsonProperty("Pragma")
    public void setPragma(String pragma) {
        this.pragma = pragma;
    }

    @JsonProperty("Expires")
    public Object getExpires() {
        return expires;
    }

    @JsonProperty("Expires")
    public void setExpires(Object expires) {
        this.expires = expires;
    }

    @JsonProperty("Strict-Transport-Security")
    public Object getStrictTransportSecurity() {
        return strictTransportSecurity;
    }

    @JsonProperty("Strict-Transport-Security")
    public void setStrictTransportSecurity(Object strictTransportSecurity) {
        this.strictTransportSecurity = strictTransportSecurity;
    }

    @JsonProperty("X-Frame-Options")
    public Object getXFrameOptions() {
        return xFrameOptions;
    }

    @JsonProperty("X-Frame-Options")
    public void setXFrameOptions(Object xFrameOptions) {
        this.xFrameOptions = xFrameOptions;
    }

    @JsonProperty("Content-Encoding")
    public String getContentEncoding() {
        return contentEncoding;
    }

    @JsonProperty("Content-Encoding")
    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
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
        return new ToStringBuilder(this).append("server", server).append("date", date).append("contentType", contentType).append("transferEncoding", transferEncoding).append("connection", connection).append("vary", vary).append("xFapiInteractionId", xFapiInteractionId).append("xContentTypeOptions", xContentTypeOptions).append("xXSSProtection", xXSSProtection).append("cacheControl", cacheControl).append("pragma", pragma).append("expires", expires).append("strictTransportSecurity", strictTransportSecurity).append("xFrameOptions", xFrameOptions).append("contentEncoding", contentEncoding).append("additionalProperties", additionalProperties).toString();
    }

}
