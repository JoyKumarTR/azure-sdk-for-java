/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2019_12_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.apimanagement.v2019_12_01.implementation.ApiRevisionContractInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.apimanagement.v2019_12_01.implementation.ApiManagementManager;
import org.joda.time.DateTime;

/**
 * Type representing ApiRevisionContract.
 */
public interface ApiRevisionContract extends HasInner<ApiRevisionContractInner>, HasManager<ApiManagementManager> {
    /**
     * @return the apiId value.
     */
    String apiId();

    /**
     * @return the apiRevision value.
     */
    String apiRevision();

    /**
     * @return the createdDateTime value.
     */
    DateTime createdDateTime();

    /**
     * @return the description value.
     */
    String description();

    /**
     * @return the isCurrent value.
     */
    Boolean isCurrent();

    /**
     * @return the isOnline value.
     */
    Boolean isOnline();

    /**
     * @return the privateUrl value.
     */
    String privateUrl();

    /**
     * @return the updatedDateTime value.
     */
    DateTime updatedDateTime();

}