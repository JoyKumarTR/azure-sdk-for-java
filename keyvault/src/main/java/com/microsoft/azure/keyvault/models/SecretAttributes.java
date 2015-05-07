/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.microsoft.azure.keyvault.models;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * The attributes of a secret managed by the KeyVault service
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class SecretAttributes {

    /**
     * NotBefore date as the number of seconds since the Unix Epoch (1/1/1970)
     */
    @JsonProperty("nbf")
    private Long notBeforeUnixTime;

    /**
     * Expiry date as the number of seconds since the Unix Epoch (1/1/1970)
     */
    @JsonProperty("exp")
    private Long expiresUnixTime;

    /**
     * Creation time as the number of seconds since the Unix Epoch (1/1/1970)
     */
    @JsonProperty("created")
    private Long createdUnixTime;

    /**
     * Last updated time as the number of seconds since the Unix Epoch
     * (1/1/1970)
     */
    @JsonProperty("updated")
    private Long updatedUnixTime;

    /**
     * Determines whether the secret is enabled
     */
    @JsonProperty("enabled")
    private Boolean enabled;

    /**
     * Optional.
     * 
     * @return The Enabled value.
     */
    public Boolean getEnabled() {
        return this.enabled;
    }

    /**
     * Optional.
     * 
     * @param enabledValue
     *            The Enabled value.
     */
    public void setEnabled(Boolean enabledValue) {
        this.enabled = enabledValue;
    }

    /**
     * Optional.
     * 
     * @return the NotBefore value
     */
    public Date getNotBefore() {
        return fromUnixTime(this.notBeforeUnixTime);
    }

    /**
     * Optional.
     * 
     * @param notBeforeValue
     *            The NotBefore value.
     */
    public void setNotBefore(Date notBeforeValue) {
        this.notBeforeUnixTime = toUnixTime(notBeforeValue);
    }

    /**
     * Optional.
     * 
     * @return the Expires value
     */
    public Date getExpires() {
        return fromUnixTime(this.expiresUnixTime);
    }

    /**
     * Optional.
     * 
     * @param expiresValue
     *            The Expires value.
     */
    public void setExpires(Date expiresValue) {
        this.expiresUnixTime = toUnixTime(expiresValue);
    }

    /**
     * Optional.
     * 
     * @return the Created value
     */
    public Date getCreated() {
        return fromUnixTime(this.createdUnixTime);
    }

    /**
     * Optional.
     * 
     * @return the Updated value
     */
    public Date getUpdated() {
        return fromUnixTime(this.updatedUnixTime);
    }

    /**
     * Default constructor The defaults for the properties are Enabled = null
     * NotBefore = null Expires = null Created = null Updated = null
     */
    public SecretAttributes() {
        this.enabled = null;
        this.notBeforeUnixTime = null;
        this.expiresUnixTime = null;
        this.createdUnixTime = null;
        this.updatedUnixTime = null;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonGenerationException e) {
            throw new IllegalStateException(e);
        } catch (JsonMappingException e) {
            throw new IllegalStateException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static Date fromUnixTime(Long unixTime) {
        if (unixTime == null) {
            return null;
        }
        return new Date(unixTime * 1000);
    }

    private static Long toUnixTime(Date value) {
        if (value == null) {
            return null;
        }
        return value.getTime() / 1000;
    }
}
