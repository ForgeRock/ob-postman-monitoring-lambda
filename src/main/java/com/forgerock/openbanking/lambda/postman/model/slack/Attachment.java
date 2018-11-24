
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

package com.forgerock.openbanking.lambda.postman.model.slack;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "fields",
    "author_name",
    "author_icon",
    "image_url",
    "text",
    "fallback",
    "callback_id",
    "color",
    "attachment_type",
    "actions"
})
public class Attachment {

    @JsonProperty("title")
    private String title;
    @JsonProperty("fields")
    private List<Field> fields = null;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("author_icon")
    private String authorIcon;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("text")
    private String text;
    @JsonProperty("fallback")
    private String fallback;
    @JsonProperty("callback_id")
    private String callbackId;
    @JsonProperty("color")
    private String color;
    @JsonProperty("attachment_type")
    private String attachmentType;
    @JsonProperty("actions")
    private List<Action> actions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @JsonProperty("author_name")
    public String getAuthorName() {
        return authorName;
    }

    @JsonProperty("author_name")
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @JsonProperty("author_icon")
    public String getAuthorIcon() {
        return authorIcon;
    }

    @JsonProperty("author_icon")
    public void setAuthorIcon(String authorIcon) {
        this.authorIcon = authorIcon;
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("image_url")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("fallback")
    public String getFallback() {
        return fallback;
    }

    @JsonProperty("fallback")
    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    @JsonProperty("callback_id")
    public String getCallbackId() {
        return callbackId;
    }

    @JsonProperty("callback_id")
    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("attachment_type")
    public String getAttachmentType() {
        return attachmentType;
    }

    @JsonProperty("attachment_type")
    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    @JsonProperty("actions")
    public List<Action> getActions() {
        return actions;
    }

    @JsonProperty("actions")
    public void setActions(List<Action> actions) {
        this.actions = actions;
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
        return new ToStringBuilder(this).append("title", title).append("fields", fields).append("authorName", authorName).append("authorIcon", authorIcon).append("imageUrl", imageUrl).append("text", text).append("fallback", fallback).append("callbackId", callbackId).append("color", color).append("attachmentType", attachmentType).append("actions", actions).append("additionalProperties", additionalProperties).toString();
    }

}
