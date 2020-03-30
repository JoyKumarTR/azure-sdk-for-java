// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.management.sql.models;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.management.CloudException;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in
 * ElasticPoolActivities.
 */
public final class ElasticPoolActivitiesInner {
    /**
     * The proxy service used to perform REST calls.
     */
    private ElasticPoolActivitiesService service;

    /**
     * The service client containing this operation class.
     */
    private SqlManagementClientImpl client;

    /**
     * Initializes an instance of ElasticPoolActivitiesInner.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ElasticPoolActivitiesInner(SqlManagementClientImpl client) {
        this.service = RestProxy.create(ElasticPoolActivitiesService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for
     * SqlManagementClientElasticPoolActivities to be used by the proxy service
     * to perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "SqlManagementClientElasticPoolActivities")
    private interface ElasticPoolActivitiesService {
        @Headers({ "Accept: application/json", "Content-Type: application/json" })
        @Get("/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/elasticPools/{elasticPoolName}/elasticPoolActivity")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(CloudException.class)
        Mono<SimpleResponse<ElasticPoolActivityListResultInner>> listByElasticPool(@HostParam("$host") String host, @QueryParam("api-version") String apiVersion, @PathParam("subscriptionId") String subscriptionId, @PathParam("resourceGroupName") String resourceGroupName, @PathParam("serverName") String serverName, @PathParam("elasticPoolName") String elasticPoolName);
    }

    /**
     * Returns elastic pool activities.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param elasticPoolName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<ElasticPoolActivityInner>> listByElasticPoolSinglePageAsync(String resourceGroupName, String serverName, String elasticPoolName) {
        final String apiVersion = "2014-04-01";
        return service.listByElasticPool(this.client.getHost(), apiVersion, this.client.getSubscriptionId(), resourceGroupName, serverName, elasticPoolName)
            .map(res -> new PagedResponseBase<>(
                res.getRequest(),
                res.getStatusCode(),
                res.getHeaders(),
                res.getValue().value(),
                null,
                null));
    }

    /**
     * Returns elastic pool activities.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param elasticPoolName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<ElasticPoolActivityInner> listByElasticPoolAsync(String resourceGroupName, String serverName, String elasticPoolName) {
        return new PagedFlux<>(
            () -> listByElasticPoolSinglePageAsync(resourceGroupName, serverName, elasticPoolName));
    }

    /**
     * Returns elastic pool activities.
     * 
     * @param resourceGroupName 
     * @param serverName 
     * @param elasticPoolName 
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws CloudException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<ElasticPoolActivityInner> listByElasticPool(String resourceGroupName, String serverName, String elasticPoolName) {
        return new PagedIterable<>(listByElasticPoolAsync(resourceGroupName, serverName, elasticPoolName));
    }
}