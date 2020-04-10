/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2019_12_01;

import rx.Observable;
import com.microsoft.azure.management.apimanagement.v2019_12_01.implementation.IssuesInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing Issues.
 */
public interface Issues extends HasInner<IssuesInner> {
    /**
     * Lists a collection of issues in the specified service instance.
     *
     * @param resourceGroupName The name of the resource group.
     * @param serviceName The name of the API Management service.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<IssueContract> listByServiceAsync(final String resourceGroupName, final String serviceName);

    /**
     * Gets API Management issue details.
     *
     * @param resourceGroupName The name of the resource group.
     * @param serviceName The name of the API Management service.
     * @param issueId Issue identifier. Must be unique in the current API Management service instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<IssueContract> getAsync(String resourceGroupName, String serviceName, String issueId);

}