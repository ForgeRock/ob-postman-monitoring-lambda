
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
    "User-Agent",
    "Accept",
    "Host",
    "accept-encoding",
    "Cache-Control",
    "Pragma",
    "Cookie",
    "x-ob-monitoring"
})
public class Headers {

    @JsonProperty("User-Agent")
    private String userAgent;
    @JsonProperty("Accept")
    private String accept;
    @JsonProperty("Host")
    private String host;
    @JsonProperty("accept-encoding")
    private String acceptEncoding;
    @JsonProperty("Cache-Control")
    private String cacheControl;
    @JsonProperty("Pragma")
    private String pragma;
    @JsonProperty("Cookie")
    private Object cookie;
    @JsonProperty("x-ob-monitoring")
    private Object xObMonitoring;
    @JsonProperty("x-postman-url-template")
    private String postmanUrlTemplate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("User-Agent")
    public String getUserAgent() {
        return userAgent;
    }

    @JsonProperty("User-Agent")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @JsonProperty("Accept")
    public String getAccept() {
        return accept;
    }

    @JsonProperty("Accept")
    public void setAccept(String accept) {
        this.accept = accept;
    }

    @JsonProperty("Host")
    public String getHost() {
        return host;
    }

    @JsonProperty("Host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("accept-encoding")
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    @JsonProperty("accept-encoding")
    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
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

    @JsonProperty("Cookie")
    public Object getCookie() {
        return cookie;
    }

    @JsonProperty("Cookie")
    public void setCookie(Object cookie) {
        this.cookie = cookie;
    }

    @JsonProperty("x-ob-monitoring")
    public Object getXObMonitoring() {
        return xObMonitoring;
    }

    @JsonProperty("x-ob-monitoring")
    public void setXObMonitoring(String xObMonitoring) {
        this.xObMonitoring = xObMonitoring;
    }

    @JsonProperty("x-postman-url-template")
    public String getPostmanUrlTemplate() {
        return postmanUrlTemplate;
    }

    @JsonProperty("x-postman-url-template")
    public void setPostmanUrlTemplate(String postmanUrlTemplate) {
        this.postmanUrlTemplate = postmanUrlTemplate;
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
        return new ToStringBuilder(this).append("userAgent", userAgent).append("accept", accept).append("host", host).append("acceptEncoding", acceptEncoding).append("cacheControl", cacheControl).append("pragma", pragma).append("cookie", cookie).append("xObMonitoring", xObMonitoring).append("additionalProperties", additionalProperties).toString();
    }

}
