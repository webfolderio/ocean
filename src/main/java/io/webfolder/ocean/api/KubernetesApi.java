package io.webfolder.ocean.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.webfolder.ocean.ApiClient;
import io.webfolder.ocean.ApiException;
import io.webfolder.ocean.ApiResponse;
import io.webfolder.ocean.Pair;
import io.webfolder.ocean.model.AddKubernetesNodePoolResponse;
import io.webfolder.ocean.model.AssociatedKubernetesResources;
import io.webfolder.ocean.model.Cluster;
import io.webfolder.ocean.model.ClusterRegistries;
import io.webfolder.ocean.model.ClusterUpdate;
import io.webfolder.ocean.model.ClusterlintRequest;
import io.webfolder.ocean.model.ClusterlintResults;
import io.webfolder.ocean.model.CreateKubernetesClusterResponse;
import io.webfolder.ocean.model.Credentials;
import io.webfolder.ocean.model.DestroyAssociatedKubernetesResources;
import io.webfolder.ocean.model.GetAvailableUpgradesResponse;
import io.webfolder.ocean.model.GetNodePoolResponse;
import io.webfolder.ocean.model.KubernetesNodePool;
import io.webfolder.ocean.model.KubernetesNodePoolUpdate;
import io.webfolder.ocean.model.KubernetesOptions;
import io.webfolder.ocean.model.ListAllKubernetesClustersResponse;
import io.webfolder.ocean.model.ListNodePoolsResponse;
import io.webfolder.ocean.model.RecycleKubernetesNodePoolRequest;
import io.webfolder.ocean.model.RunClusterlintResponse;
import io.webfolder.ocean.model.UpdateKubernetesNodePoolResponse;
import io.webfolder.ocean.model.UpgradeKubernetesClusterRequest;
import io.webfolder.ocean.model.User;

public class KubernetesApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public KubernetesApi() {
        this(new ApiClient());
    }

    public KubernetesApi(ApiClient apiClient) {
        memberVarHttpClient = apiClient.getHttpClient();
        memberVarObjectMapper = apiClient.getObjectMapper();
        memberVarBaseUri = apiClient.getBaseUri();
        memberVarInterceptor = apiClient.getRequestInterceptor();
        memberVarReadTimeout = apiClient.getReadTimeout();
        memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    }

    protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
        String body = response.body() == null ? null : new String(response.body().readAllBytes());
        String message = formatExceptionMessage(operationId, response.statusCode(), body);
        return new ApiException(response.statusCode(), message, response.headers(), body);
    }

    private String formatExceptionMessage(String operationId, int statusCode, String body) {
        if (body == null || body.isEmpty()) {
            body = "[no body]";
        }
        return operationId + " call failed with: " + statusCode + " - " + body;
    }

    /**
     * Add a Node Pool to a Kubernetes Cluster To add an additional node pool to a
     * Kubernetes clusters, send a POST request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools&#x60; with the
     * following attributes.
     *
     * @param clusterId          A unique ID that can be used to reference a
     *                           Kubernetes cluster. (required)
     * @param kubernetesNodePool (required)
     * @return AddKubernetesNodePoolResponse
     * @throws ApiException if fails to make API call
     */
    public AddKubernetesNodePoolResponse addKubernetesNodePool(UUID clusterId, KubernetesNodePool kubernetesNodePool) {
        ApiResponse<AddKubernetesNodePoolResponse> localVarResponse = addKubernetesNodePoolWithHttpInfo(clusterId,
                kubernetesNodePool);
        return localVarResponse.getData();
    }

    /**
     * Add a Node Pool to a Kubernetes Cluster To add an additional node pool to a
     * Kubernetes clusters, send a POST request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools&#x60; with the
     * following attributes.
     *
     * @param clusterId          A unique ID that can be used to reference a
     *                           Kubernetes cluster. (required)
     * @param kubernetesNodePool (required)
     * @return ApiResponse&lt;AddKubernetesNodePoolResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AddKubernetesNodePoolResponse> addKubernetesNodePoolWithHttpInfo(UUID clusterId,
            KubernetesNodePool kubernetesNodePool) {
        HttpRequest.Builder localVarRequestBuilder = addKubernetesNodePoolRequestBuilder(clusterId, kubernetesNodePool);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("addKubernetesNodePool", localVarResponse);
                }
                return new ApiResponse<AddKubernetesNodePoolResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AddKubernetesNodePoolResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder addKubernetesNodePoolRequestBuilder(UUID clusterId,
            KubernetesNodePool kubernetesNodePool) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling addKubernetesNodePool");
        }
        // verify the required parameter 'kubernetesNodePool' is set
        if (kubernetesNodePool == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'kubernetesNodePool' when calling addKubernetesNodePool");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/node_pools".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(kubernetesNodePool);
            localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Add Container Registry to Kubernetes Clusters To integrate the container
     * registry with Kubernetes clusters, send a POST request to
     * &#x60;/v2/kubernetes/registry&#x60;.
     *
     * @param clusterRegistries (optional)
     * @throws ApiException if fails to make API call
     */
    public void addRegistry(ClusterRegistries clusterRegistries) {
        addRegistryWithHttpInfo(clusterRegistries);
    }

    /**
     * Add Container Registry to Kubernetes Clusters To integrate the container
     * registry with Kubernetes clusters, send a POST request to
     * &#x60;/v2/kubernetes/registry&#x60;.
     *
     * @param clusterRegistries (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> addRegistryWithHttpInfo(ClusterRegistries clusterRegistries) {
        HttpRequest.Builder localVarRequestBuilder = addRegistryRequestBuilder(clusterRegistries);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("addRegistry", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder addRegistryRequestBuilder(ClusterRegistries clusterRegistries) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/registry";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(clusterRegistries);
            localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Create a New Kubernetes Cluster To create a new Kubernetes cluster, send a
     * POST request to &#x60;/v2/kubernetes/clusters&#x60;. The request must contain
     * at least one node pool with at least one worker. The request may contain a
     * maintenance window policy describing a time period when disruptive
     * maintenance tasks may be carried out. Omitting the policy implies that a
     * window will be chosen automatically. See
     * [here](https://www.digitalocean.com/docs/kubernetes/how-to/upgrade-cluster/)
     * for details.
     *
     * @param cluster (required)
     * @return CreateKubernetesClusterResponse
     * @throws ApiException if fails to make API call
     */
    public CreateKubernetesClusterResponse createKubernetesCluster(Cluster cluster) {
        ApiResponse<CreateKubernetesClusterResponse> localVarResponse = createKubernetesClusterWithHttpInfo(cluster);
        return localVarResponse.getData();
    }

    /**
     * Create a New Kubernetes Cluster To create a new Kubernetes cluster, send a
     * POST request to &#x60;/v2/kubernetes/clusters&#x60;. The request must contain
     * at least one node pool with at least one worker. The request may contain a
     * maintenance window policy describing a time period when disruptive
     * maintenance tasks may be carried out. Omitting the policy implies that a
     * window will be chosen automatically. See
     * [here](https://www.digitalocean.com/docs/kubernetes/how-to/upgrade-cluster/)
     * for details.
     *
     * @param cluster (required)
     * @return ApiResponse&lt;CreateKubernetesClusterResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateKubernetesClusterResponse> createKubernetesClusterWithHttpInfo(Cluster cluster) {
        HttpRequest.Builder localVarRequestBuilder = createKubernetesClusterRequestBuilder(cluster);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createKubernetesCluster", localVarResponse);
                }
                return new ApiResponse<CreateKubernetesClusterResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateKubernetesClusterResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder createKubernetesClusterRequestBuilder(Cluster cluster) {
        // verify the required parameter 'cluster' is set
        if (cluster == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'cluster' when calling createKubernetesCluster");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(cluster);
            localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Delete a Kubernetes Cluster To delete a Kubernetes cluster and all services
     * deployed to it, send a DELETE request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID&#x60;. A 204 status code with
     * no body will be returned in response to a successful request.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteKubernetesCluster(UUID clusterId) {
        deleteKubernetesClusterWithHttpInfo(clusterId);
    }

    /**
     * Delete a Kubernetes Cluster To delete a Kubernetes cluster and all services
     * deployed to it, send a DELETE request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID&#x60;. A 204 status code with
     * no body will be returned in response to a successful request.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteKubernetesClusterWithHttpInfo(UUID clusterId) {
        HttpRequest.Builder localVarRequestBuilder = deleteKubernetesClusterRequestBuilder(clusterId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteKubernetesCluster", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder deleteKubernetesClusterRequestBuilder(UUID clusterId) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling deleteKubernetesCluster");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Delete a Node in a Kubernetes Cluster To delete a single node in a pool, send
     * a DELETE request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools/$NODE_POOL_ID/nodes/$NODE_ID&#x60;.
     * Appending the &#x60;skip_drain&#x3D;1&#x60; query parameter to the request
     * causes node draining to be skipped. Omitting the query parameter or setting
     * its value to &#x60;0&#x60; carries out draining prior to deletion. Appending
     * the &#x60;replace&#x3D;1&#x60; query parameter to the request causes the node
     * to be replaced by a new one after deletion. Omitting the query parameter or
     * setting its value to &#x60;0&#x60; deletes without replacement.
     *
     * @param clusterId  A unique ID that can be used to reference a Kubernetes
     *                   cluster. (required)
     * @param nodePoolId A unique ID that can be used to reference a Kubernetes node
     *                   pool. (required)
     * @param nodeId     A unique ID that can be used to reference a node in a
     *                   Kubernetes node pool. (required)
     * @param skipDrain  Specifies whether or not to drain workloads from a node
     *                   before it is deleted. Setting it to &#x60;1&#x60; causes
     *                   node draining to be skipped. Omitting the query parameter
     *                   or setting its value to &#x60;0&#x60; carries out draining
     *                   prior to deletion. (optional, default to 0)
     * @param replace    Specifies whether or not to replace a node after it has
     *                   been deleted. Setting it to &#x60;1&#x60; causes the node
     *                   to be replaced by a new one after deletion. Omitting the
     *                   query parameter or setting its value to &#x60;0&#x60;
     *                   deletes without replacement. (optional, default to 0)
     * @throws ApiException if fails to make API call
     */
    public void deleteKubernetesNode(UUID clusterId, UUID nodePoolId, UUID nodeId, Integer skipDrain, Integer replace) {
        deleteKubernetesNodeWithHttpInfo(clusterId, nodePoolId, nodeId, skipDrain, replace);
    }

    /**
     * Delete a Node in a Kubernetes Cluster To delete a single node in a pool, send
     * a DELETE request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools/$NODE_POOL_ID/nodes/$NODE_ID&#x60;.
     * Appending the &#x60;skip_drain&#x3D;1&#x60; query parameter to the request
     * causes node draining to be skipped. Omitting the query parameter or setting
     * its value to &#x60;0&#x60; carries out draining prior to deletion. Appending
     * the &#x60;replace&#x3D;1&#x60; query parameter to the request causes the node
     * to be replaced by a new one after deletion. Omitting the query parameter or
     * setting its value to &#x60;0&#x60; deletes without replacement.
     *
     * @param clusterId  A unique ID that can be used to reference a Kubernetes
     *                   cluster. (required)
     * @param nodePoolId A unique ID that can be used to reference a Kubernetes node
     *                   pool. (required)
     * @param nodeId     A unique ID that can be used to reference a node in a
     *                   Kubernetes node pool. (required)
     * @param skipDrain  Specifies whether or not to drain workloads from a node
     *                   before it is deleted. Setting it to &#x60;1&#x60; causes
     *                   node draining to be skipped. Omitting the query parameter
     *                   or setting its value to &#x60;0&#x60; carries out draining
     *                   prior to deletion. (optional, default to 0)
     * @param replace    Specifies whether or not to replace a node after it has
     *                   been deleted. Setting it to &#x60;1&#x60; causes the node
     *                   to be replaced by a new one after deletion. Omitting the
     *                   query parameter or setting its value to &#x60;0&#x60;
     *                   deletes without replacement. (optional, default to 0)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteKubernetesNodeWithHttpInfo(UUID clusterId, UUID nodePoolId, UUID nodeId,
            Integer skipDrain, Integer replace) {
        HttpRequest.Builder localVarRequestBuilder = deleteKubernetesNodeRequestBuilder(clusterId, nodePoolId, nodeId,
                skipDrain, replace);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteKubernetesNode", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder deleteKubernetesNodeRequestBuilder(UUID clusterId, UUID nodePoolId, UUID nodeId,
            Integer skipDrain, Integer replace) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400, "Missing the required parameter 'clusterId' when calling deleteKubernetesNode");
        }
        // verify the required parameter 'nodePoolId' is set
        if (nodePoolId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'nodePoolId' when calling deleteKubernetesNode");
        }
        // verify the required parameter 'nodeId' is set
        if (nodeId == null) {
            throw new ApiException(400, "Missing the required parameter 'nodeId' when calling deleteKubernetesNode");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/node_pools/{node_pool_id}/nodes/{node_id}"
                .replace("{cluster_id}", ApiClient.urlEncode(clusterId.toString()))
                .replace("{node_pool_id}", ApiClient.urlEncode(nodePoolId.toString()))
                .replace("{node_id}", ApiClient.urlEncode(nodeId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("skip_drain", skipDrain));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("replace", replace));

        if (!localVarQueryParams.isEmpty()) {
            StringJoiner queryJoiner = new StringJoiner("&");
            localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
        } else {
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
        }

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Delete a Node Pool in a Kubernetes Cluster To delete a node pool, send a
     * DELETE request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools/$NODE_POOL_ID&#x60;.
     * A 204 status code with no body will be returned in response to a successful
     * request. Nodes in the pool will subsequently be drained and deleted.
     *
     * @param clusterId  A unique ID that can be used to reference a Kubernetes
     *                   cluster. (required)
     * @param nodePoolId A unique ID that can be used to reference a Kubernetes node
     *                   pool. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteKubernetesNodePool(UUID clusterId, UUID nodePoolId) {
        deleteKubernetesNodePoolWithHttpInfo(clusterId, nodePoolId);
    }

    /**
     * Delete a Node Pool in a Kubernetes Cluster To delete a node pool, send a
     * DELETE request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools/$NODE_POOL_ID&#x60;.
     * A 204 status code with no body will be returned in response to a successful
     * request. Nodes in the pool will subsequently be drained and deleted.
     *
     * @param clusterId  A unique ID that can be used to reference a Kubernetes
     *                   cluster. (required)
     * @param nodePoolId A unique ID that can be used to reference a Kubernetes node
     *                   pool. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteKubernetesNodePoolWithHttpInfo(UUID clusterId, UUID nodePoolId) {
        HttpRequest.Builder localVarRequestBuilder = deleteKubernetesNodePoolRequestBuilder(clusterId, nodePoolId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteKubernetesNodePool", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder deleteKubernetesNodePoolRequestBuilder(UUID clusterId, UUID nodePoolId) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling deleteKubernetesNodePool");
        }
        // verify the required parameter 'nodePoolId' is set
        if (nodePoolId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'nodePoolId' when calling deleteKubernetesNodePool");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/node_pools/{node_pool_id}"
                .replace("{cluster_id}", ApiClient.urlEncode(clusterId.toString()))
                .replace("{node_pool_id}", ApiClient.urlEncode(nodePoolId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Delete a Cluster and All of its Associated Resources (Dangerous) To delete a
     * Kubernetes cluster with all of its associated resources, send a DELETE
     * request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/destroy_with_associated_resources/dangerous&#x60;.
     * A 204 status code with no body will be returned in response to a successful
     * request.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @throws ApiException if fails to make API call
     */
    public void destroyKubernetesAssociatedResourcesDangerous(UUID clusterId) {
        destroyKubernetesAssociatedResourcesDangerousWithHttpInfo(clusterId);
    }

    /**
     * Delete a Cluster and All of its Associated Resources (Dangerous) To delete a
     * Kubernetes cluster with all of its associated resources, send a DELETE
     * request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/destroy_with_associated_resources/dangerous&#x60;.
     * A 204 status code with no body will be returned in response to a successful
     * request.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> destroyKubernetesAssociatedResourcesDangerousWithHttpInfo(UUID clusterId) {
        HttpRequest.Builder localVarRequestBuilder = destroyKubernetesAssociatedResourcesDangerousRequestBuilder(
                clusterId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("destroyKubernetesAssociatedResourcesDangerous", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder destroyKubernetesAssociatedResourcesDangerousRequestBuilder(UUID clusterId) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling destroyKubernetesAssociatedResourcesDangerous");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/destroy_with_associated_resources/dangerous"
                .replace("{cluster_id}", ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Selectively Delete a Cluster and its Associated Resources To delete a
     * Kubernetes cluster along with a subset of its associated resources, send a
     * DELETE request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/destroy_with_associated_resources/selective&#x60;.
     * The JSON body of the request should include &#x60;load_balancers&#x60;,
     * &#x60;volumes&#x60;, or &#x60;volume_snapshots&#x60; keys each set to an
     * array of IDs for the associated resources to be destroyed. The IDs can be
     * found by querying the cluster&#39;s associated resources endpoint. Any
     * associated resource not included in the request will remain and continue to
     * accrue changes on your account.
     *
     * @param clusterId                            A unique ID that can be used to
     *                                             reference a Kubernetes cluster.
     *                                             (required)
     * @param destroyAssociatedKubernetesResources (required)
     * @throws ApiException if fails to make API call
     */
    public void destroyKubernetesAssociatedResourcesSelective(UUID clusterId,
            DestroyAssociatedKubernetesResources destroyAssociatedKubernetesResources) {
        destroyKubernetesAssociatedResourcesSelectiveWithHttpInfo(clusterId, destroyAssociatedKubernetesResources);
    }

    /**
     * Selectively Delete a Cluster and its Associated Resources To delete a
     * Kubernetes cluster along with a subset of its associated resources, send a
     * DELETE request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/destroy_with_associated_resources/selective&#x60;.
     * The JSON body of the request should include &#x60;load_balancers&#x60;,
     * &#x60;volumes&#x60;, or &#x60;volume_snapshots&#x60; keys each set to an
     * array of IDs for the associated resources to be destroyed. The IDs can be
     * found by querying the cluster&#39;s associated resources endpoint. Any
     * associated resource not included in the request will remain and continue to
     * accrue changes on your account.
     *
     * @param clusterId                            A unique ID that can be used to
     *                                             reference a Kubernetes cluster.
     *                                             (required)
     * @param destroyAssociatedKubernetesResources (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> destroyKubernetesAssociatedResourcesSelectiveWithHttpInfo(UUID clusterId,
            DestroyAssociatedKubernetesResources destroyAssociatedKubernetesResources) {
        HttpRequest.Builder localVarRequestBuilder = destroyKubernetesAssociatedResourcesSelectiveRequestBuilder(
                clusterId, destroyAssociatedKubernetesResources);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("destroyKubernetesAssociatedResourcesSelective", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder destroyKubernetesAssociatedResourcesSelectiveRequestBuilder(UUID clusterId,
            DestroyAssociatedKubernetesResources destroyAssociatedKubernetesResources) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling destroyKubernetesAssociatedResourcesSelective");
        }
        // verify the required parameter 'destroyAssociatedKubernetesResources' is set
        if (destroyAssociatedKubernetesResources == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'destroyAssociatedKubernetesResources' when calling destroyKubernetesAssociatedResourcesSelective");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/destroy_with_associated_resources/selective"
                .replace("{cluster_id}", ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(destroyAssociatedKubernetesResources);
            localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Retrieve Available Upgrades for an Existing Kubernetes Cluster To determine
     * whether a cluster can be upgraded, and the versions to which it can be
     * upgraded, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/upgrades&#x60;.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return GetAvailableUpgradesResponse
     * @throws ApiException if fails to make API call
     */
    public GetAvailableUpgradesResponse getAvailableUpgrades(UUID clusterId) {
        ApiResponse<GetAvailableUpgradesResponse> localVarResponse = getAvailableUpgradesWithHttpInfo(clusterId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve Available Upgrades for an Existing Kubernetes Cluster To determine
     * whether a cluster can be upgraded, and the versions to which it can be
     * upgraded, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/upgrades&#x60;.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return ApiResponse&lt;GetAvailableUpgradesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetAvailableUpgradesResponse> getAvailableUpgradesWithHttpInfo(UUID clusterId) {
        HttpRequest.Builder localVarRequestBuilder = getAvailableUpgradesRequestBuilder(clusterId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getAvailableUpgrades", localVarResponse);
                }
                return new ApiResponse<GetAvailableUpgradesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetAvailableUpgradesResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder getAvailableUpgradesRequestBuilder(UUID clusterId) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400, "Missing the required parameter 'clusterId' when calling getAvailableUpgrades");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/upgrades".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Retrieve User Information for a Kubernetes Cluster To show information the
     * user associated with a Kubernetes cluster, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/user&#x60;.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return User
     * @throws ApiException if fails to make API call
     */
    public User getClusterUser(UUID clusterId) {
        ApiResponse<User> localVarResponse = getClusterUserWithHttpInfo(clusterId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve User Information for a Kubernetes Cluster To show information the
     * user associated with a Kubernetes cluster, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/user&#x60;.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return ApiResponse&lt;User&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<User> getClusterUserWithHttpInfo(UUID clusterId) {
        HttpRequest.Builder localVarRequestBuilder = getClusterUserRequestBuilder(clusterId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getClusterUser", localVarResponse);
                }
                return new ApiResponse<User>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<User>() {
                        }) // closes
                           // the
                           // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder getClusterUserRequestBuilder(UUID clusterId) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400, "Missing the required parameter 'clusterId' when calling getClusterUser");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/user".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Fetch Clusterlint Diagnostics for a Kubernetes Cluster To request clusterlint
     * diagnostics for your cluster, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/clusterlint&#x60;. If the
     * &#x60;run_id&#x60; query parameter is provided, then the diagnostics for the
     * specific run is fetched. By default, the latest results are shown. To find
     * out how to address clusterlint feedback, please refer to [the clusterlint
     * check
     * documentation](https://github.com/digitalocean/clusterlint/blob/master/checks.md).
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @param runId     Specifies the clusterlint run whose results will be
     *                  retrieved. (optional)
     * @return ClusterlintResults
     * @throws ApiException if fails to make API call
     */
    public ClusterlintResults getClusterlintResults(UUID clusterId, UUID runId) {
        ApiResponse<ClusterlintResults> localVarResponse = getClusterlintResultsWithHttpInfo(clusterId, runId);
        return localVarResponse.getData();
    }

    /**
     * Fetch Clusterlint Diagnostics for a Kubernetes Cluster To request clusterlint
     * diagnostics for your cluster, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/clusterlint&#x60;. If the
     * &#x60;run_id&#x60; query parameter is provided, then the diagnostics for the
     * specific run is fetched. By default, the latest results are shown. To find
     * out how to address clusterlint feedback, please refer to [the clusterlint
     * check
     * documentation](https://github.com/digitalocean/clusterlint/blob/master/checks.md).
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @param runId     Specifies the clusterlint run whose results will be
     *                  retrieved. (optional)
     * @return ApiResponse&lt;ClusterlintResults&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ClusterlintResults> getClusterlintResultsWithHttpInfo(UUID clusterId, UUID runId) {
        HttpRequest.Builder localVarRequestBuilder = getClusterlintResultsRequestBuilder(clusterId, runId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getClusterlintResults", localVarResponse);
                }
                return new ApiResponse<ClusterlintResults>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ClusterlintResults>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder getClusterlintResultsRequestBuilder(UUID clusterId, UUID runId) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling getClusterlintResults");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/clusterlint".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("run_id", runId));

        if (!localVarQueryParams.isEmpty()) {
            StringJoiner queryJoiner = new StringJoiner("&");
            localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
        } else {
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
        }

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Retrieve Credentials for a Kubernetes Cluster This endpoint returns a JSON
     * object . It can be used to programmatically construct Kubernetes clients
     * which cannot parse kubeconfig files. The resulting JSON object contains
     * token-based authentication for clusters supporting it, and certificate-based
     * authentication otherwise. For a list of supported versions and more
     * information, see \&quot;[How to Connect to a DigitalOcean Kubernetes Cluster
     * with
     * kubectl](https://www.digitalocean.com/docs/kubernetes/how-to/connect-with-kubectl/)\&quot;.
     * To retrieve credentials for accessing a Kubernetes cluster, send a GET
     * request to &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/credentials&#x60;.
     * Clusters supporting token-based authentication may define an expiration by
     * passing a duration in seconds as a query parameter to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/kubeconfig?expiry_seconds&#x3D;$DURATION_IN_SECONDS&#x60;.
     * If not set or 0, then the token will have a 7 day expiry. The query parameter
     * has no impact in certificate-based authentication.
     *
     * @param clusterId     A unique ID that can be used to reference a Kubernetes
     *                      cluster. (required)
     * @param expirySeconds The duration in seconds that the returned Kubernetes
     *                      credentials will be valid. If not set or 0, the
     *                      credentials will have a 7 day expiry. (optional, default
     *                      to 0)
     * @return Credentials
     * @throws ApiException if fails to make API call
     */
    public Credentials getCredentials(UUID clusterId, Integer expirySeconds) {
        ApiResponse<Credentials> localVarResponse = getCredentialsWithHttpInfo(clusterId, expirySeconds);
        return localVarResponse.getData();
    }

    /**
     * Retrieve Credentials for a Kubernetes Cluster This endpoint returns a JSON
     * object . It can be used to programmatically construct Kubernetes clients
     * which cannot parse kubeconfig files. The resulting JSON object contains
     * token-based authentication for clusters supporting it, and certificate-based
     * authentication otherwise. For a list of supported versions and more
     * information, see \&quot;[How to Connect to a DigitalOcean Kubernetes Cluster
     * with
     * kubectl](https://www.digitalocean.com/docs/kubernetes/how-to/connect-with-kubectl/)\&quot;.
     * To retrieve credentials for accessing a Kubernetes cluster, send a GET
     * request to &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/credentials&#x60;.
     * Clusters supporting token-based authentication may define an expiration by
     * passing a duration in seconds as a query parameter to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/kubeconfig?expiry_seconds&#x3D;$DURATION_IN_SECONDS&#x60;.
     * If not set or 0, then the token will have a 7 day expiry. The query parameter
     * has no impact in certificate-based authentication.
     *
     * @param clusterId     A unique ID that can be used to reference a Kubernetes
     *                      cluster. (required)
     * @param expirySeconds The duration in seconds that the returned Kubernetes
     *                      credentials will be valid. If not set or 0, the
     *                      credentials will have a 7 day expiry. (optional, default
     *                      to 0)
     * @return ApiResponse&lt;Credentials&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Credentials> getCredentialsWithHttpInfo(UUID clusterId, Integer expirySeconds) {
        HttpRequest.Builder localVarRequestBuilder = getCredentialsRequestBuilder(clusterId, expirySeconds);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getCredentials", localVarResponse);
                }
                return new ApiResponse<Credentials>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Credentials>() {
                        }) // closes
                           // the
                           // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder getCredentialsRequestBuilder(UUID clusterId, Integer expirySeconds) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400, "Missing the required parameter 'clusterId' when calling getCredentials");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/credentials".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("expiry_seconds", expirySeconds));

        if (!localVarQueryParams.isEmpty()) {
            StringJoiner queryJoiner = new StringJoiner("&");
            localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
        } else {
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
        }

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Retrieve the kubeconfig for a Kubernetes Cluster This endpoint returns a
     * kubeconfig file in YAML format. It can be used to connect to and administer
     * the cluster using the Kubernetes command line tool, &#x60;kubectl&#x60;, or
     * other programs supporting kubeconfig files (e.g., client libraries). The
     * resulting kubeconfig file uses token-based authentication for clusters
     * supporting it, and certificate-based authentication otherwise. For a list of
     * supported versions and more information, see \&quot;[How to Connect to a
     * DigitalOcean Kubernetes Cluster with
     * kubectl](https://www.digitalocean.com/docs/kubernetes/how-to/connect-with-kubectl/)\&quot;.
     * To retrieve a kubeconfig file for use with a Kubernetes cluster, send a GET
     * request to &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/kubeconfig&#x60;.
     * Clusters supporting token-based authentication may define an expiration by
     * passing a duration in seconds as a query parameter to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/kubeconfig?expiry_seconds&#x3D;$DURATION_IN_SECONDS&#x60;.
     * If not set or 0, then the token will have a 7 day expiry. The query parameter
     * has no impact in certificate-based authentication.
     *
     * @param clusterId     A unique ID that can be used to reference a Kubernetes
     *                      cluster. (required)
     * @param expirySeconds The duration in seconds that the returned Kubernetes
     *                      credentials will be valid. If not set or 0, the
     *                      credentials will have a 7 day expiry. (optional, default
     *                      to 0)
     * @throws ApiException if fails to make API call
     */
    public void getKubeconfig(UUID clusterId, Integer expirySeconds) {
        getKubeconfigWithHttpInfo(clusterId, expirySeconds);
    }

    /**
     * Retrieve the kubeconfig for a Kubernetes Cluster This endpoint returns a
     * kubeconfig file in YAML format. It can be used to connect to and administer
     * the cluster using the Kubernetes command line tool, &#x60;kubectl&#x60;, or
     * other programs supporting kubeconfig files (e.g., client libraries). The
     * resulting kubeconfig file uses token-based authentication for clusters
     * supporting it, and certificate-based authentication otherwise. For a list of
     * supported versions and more information, see \&quot;[How to Connect to a
     * DigitalOcean Kubernetes Cluster with
     * kubectl](https://www.digitalocean.com/docs/kubernetes/how-to/connect-with-kubectl/)\&quot;.
     * To retrieve a kubeconfig file for use with a Kubernetes cluster, send a GET
     * request to &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/kubeconfig&#x60;.
     * Clusters supporting token-based authentication may define an expiration by
     * passing a duration in seconds as a query parameter to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/kubeconfig?expiry_seconds&#x3D;$DURATION_IN_SECONDS&#x60;.
     * If not set or 0, then the token will have a 7 day expiry. The query parameter
     * has no impact in certificate-based authentication.
     *
     * @param clusterId     A unique ID that can be used to reference a Kubernetes
     *                      cluster. (required)
     * @param expirySeconds The duration in seconds that the returned Kubernetes
     *                      credentials will be valid. If not set or 0, the
     *                      credentials will have a 7 day expiry. (optional, default
     *                      to 0)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> getKubeconfigWithHttpInfo(UUID clusterId, Integer expirySeconds) {
        HttpRequest.Builder localVarRequestBuilder = getKubeconfigRequestBuilder(clusterId, expirySeconds);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getKubeconfig", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder getKubeconfigRequestBuilder(UUID clusterId, Integer expirySeconds) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400, "Missing the required parameter 'clusterId' when calling getKubeconfig");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/kubeconfig".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("expiry_seconds", expirySeconds));

        if (!localVarQueryParams.isEmpty()) {
            StringJoiner queryJoiner = new StringJoiner("&");
            localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
        } else {
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
        }

        localVarRequestBuilder.header("Accept", "application/yaml, application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Retrieve an Existing Kubernetes Cluster To show information about an existing
     * Kubernetes cluster, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID&#x60;.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return CreateKubernetesClusterResponse
     * @throws ApiException if fails to make API call
     */
    public CreateKubernetesClusterResponse getKubernetesCluster(UUID clusterId) {
        ApiResponse<CreateKubernetesClusterResponse> localVarResponse = getKubernetesClusterWithHttpInfo(clusterId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Kubernetes Cluster To show information about an existing
     * Kubernetes cluster, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID&#x60;.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return ApiResponse&lt;CreateKubernetesClusterResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateKubernetesClusterResponse> getKubernetesClusterWithHttpInfo(UUID clusterId) {
        HttpRequest.Builder localVarRequestBuilder = getKubernetesClusterRequestBuilder(clusterId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getKubernetesCluster", localVarResponse);
                }
                return new ApiResponse<CreateKubernetesClusterResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateKubernetesClusterResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder getKubernetesClusterRequestBuilder(UUID clusterId) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400, "Missing the required parameter 'clusterId' when calling getKubernetesCluster");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Retrieve a Node Pool for a Kubernetes Cluster To show information about a
     * specific node pool in a Kubernetes cluster, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools/$NODE_POOL_ID&#x60;.
     *
     * @param clusterId  A unique ID that can be used to reference a Kubernetes
     *                   cluster. (required)
     * @param nodePoolId A unique ID that can be used to reference a Kubernetes node
     *                   pool. (required)
     * @return GetNodePoolResponse
     * @throws ApiException if fails to make API call
     */
    public GetNodePoolResponse getNodePool(UUID clusterId, UUID nodePoolId) {
        ApiResponse<GetNodePoolResponse> localVarResponse = getNodePoolWithHttpInfo(clusterId, nodePoolId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve a Node Pool for a Kubernetes Cluster To show information about a
     * specific node pool in a Kubernetes cluster, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools/$NODE_POOL_ID&#x60;.
     *
     * @param clusterId  A unique ID that can be used to reference a Kubernetes
     *                   cluster. (required)
     * @param nodePoolId A unique ID that can be used to reference a Kubernetes node
     *                   pool. (required)
     * @return ApiResponse&lt;GetNodePoolResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetNodePoolResponse> getNodePoolWithHttpInfo(UUID clusterId, UUID nodePoolId) {
        HttpRequest.Builder localVarRequestBuilder = getNodePoolRequestBuilder(clusterId, nodePoolId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getNodePool", localVarResponse);
                }
                return new ApiResponse<GetNodePoolResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetNodePoolResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder getNodePoolRequestBuilder(UUID clusterId, UUID nodePoolId) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400, "Missing the required parameter 'clusterId' when calling getNodePool");
        }
        // verify the required parameter 'nodePoolId' is set
        if (nodePoolId == null) {
            throw new ApiException(400, "Missing the required parameter 'nodePoolId' when calling getNodePool");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/node_pools/{node_pool_id}"
                .replace("{cluster_id}", ApiClient.urlEncode(clusterId.toString()))
                .replace("{node_pool_id}", ApiClient.urlEncode(nodePoolId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * List All Kubernetes Clusters To list all of the Kubernetes clusters on your
     * account, send a GET request to &#x60;/v2/kubernetes/clusters&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ListAllKubernetesClustersResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllKubernetesClustersResponse listAllKubernetesClusters(Integer perPage, Integer page) {
        ApiResponse<ListAllKubernetesClustersResponse> localVarResponse = listAllKubernetesClustersWithHttpInfo(perPage,
                page);
        return localVarResponse.getData();
    }

    /**
     * List All Kubernetes Clusters To list all of the Kubernetes clusters on your
     * account, send a GET request to &#x60;/v2/kubernetes/clusters&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ApiResponse&lt;ListAllKubernetesClustersResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllKubernetesClustersResponse> listAllKubernetesClustersWithHttpInfo(Integer perPage,
            Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listAllKubernetesClustersRequestBuilder(perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllKubernetesClusters", localVarResponse);
                }
                return new ApiResponse<ListAllKubernetesClustersResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllKubernetesClustersResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder listAllKubernetesClustersRequestBuilder(Integer perPage, Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("per_page", perPage));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("page", page));

        if (!localVarQueryParams.isEmpty()) {
            StringJoiner queryJoiner = new StringJoiner("&");
            localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
        } else {
            localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
        }

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * List Associated Resources for Cluster Deletion To list the associated
     * billable resources that can be destroyed along with a cluster, send a GET
     * request to the
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/destroy_with_associated_resources&#x60;
     * endpoint.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return AssociatedKubernetesResources
     * @throws ApiException if fails to make API call
     */
    public AssociatedKubernetesResources listKubernetesAssociatedResources(UUID clusterId) {
        ApiResponse<AssociatedKubernetesResources> localVarResponse = listKubernetesAssociatedResourcesWithHttpInfo(
                clusterId);
        return localVarResponse.getData();
    }

    /**
     * List Associated Resources for Cluster Deletion To list the associated
     * billable resources that can be destroyed along with a cluster, send a GET
     * request to the
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/destroy_with_associated_resources&#x60;
     * endpoint.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return ApiResponse&lt;AssociatedKubernetesResources&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AssociatedKubernetesResources> listKubernetesAssociatedResourcesWithHttpInfo(UUID clusterId) {
        HttpRequest.Builder localVarRequestBuilder = listKubernetesAssociatedResourcesRequestBuilder(clusterId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listKubernetesAssociatedResources", localVarResponse);
                }
                return new ApiResponse<AssociatedKubernetesResources>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AssociatedKubernetesResources>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder listKubernetesAssociatedResourcesRequestBuilder(UUID clusterId) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling listKubernetesAssociatedResources");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/destroy_with_associated_resources"
                .replace("{cluster_id}", ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * List Available Regions, Node Sizes, and Versions of Kubernetes To list the
     * versions of Kubernetes available for use, the regions that support
     * Kubernetes, and the available node sizes, send a GET request to
     * &#x60;/v2/kubernetes/options&#x60;.
     *
     * @return KubernetesOptions
     * @throws ApiException if fails to make API call
     */
    public KubernetesOptions listKubernetesOptions() {
        ApiResponse<KubernetesOptions> localVarResponse = listKubernetesOptionsWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List Available Regions, Node Sizes, and Versions of Kubernetes To list the
     * versions of Kubernetes available for use, the regions that support
     * Kubernetes, and the available node sizes, send a GET request to
     * &#x60;/v2/kubernetes/options&#x60;.
     *
     * @return ApiResponse&lt;KubernetesOptions&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<KubernetesOptions> listKubernetesOptionsWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listKubernetesOptionsRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listKubernetesOptions", localVarResponse);
                }
                return new ApiResponse<KubernetesOptions>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<KubernetesOptions>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder listKubernetesOptionsRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/options";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * List All Node Pools in a Kubernetes Clusters To list all of the node pools in
     * a Kubernetes clusters, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools&#x60;.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return ListNodePoolsResponse
     * @throws ApiException if fails to make API call
     */
    public ListNodePoolsResponse listNodePools(UUID clusterId) {
        ApiResponse<ListNodePoolsResponse> localVarResponse = listNodePoolsWithHttpInfo(clusterId);
        return localVarResponse.getData();
    }

    /**
     * List All Node Pools in a Kubernetes Clusters To list all of the node pools in
     * a Kubernetes clusters, send a GET request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools&#x60;.
     *
     * @param clusterId A unique ID that can be used to reference a Kubernetes
     *                  cluster. (required)
     * @return ApiResponse&lt;ListNodePoolsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListNodePoolsResponse> listNodePoolsWithHttpInfo(UUID clusterId) {
        HttpRequest.Builder localVarRequestBuilder = listNodePoolsRequestBuilder(clusterId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listNodePools", localVarResponse);
                }
                return new ApiResponse<ListNodePoolsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListNodePoolsResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder listNodePoolsRequestBuilder(UUID clusterId) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400, "Missing the required parameter 'clusterId' when calling listNodePools");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/node_pools".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Recycle a Kubernetes Node Pool The endpoint has been deprecated. Please use
     * the DELETE
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools/$NODE_POOL_ID/nodes/$NODE_ID&#x60;
     * method instead.
     *
     * @param clusterId                        A unique ID that can be used to
     *                                         reference a Kubernetes cluster.
     *                                         (required)
     * @param nodePoolId                       A unique ID that can be used to
     *                                         reference a Kubernetes node pool.
     *                                         (required)
     * @param recycleKubernetesNodePoolRequest (required)
     * @throws ApiException if fails to make API call
     * @deprecated
     */
    @Deprecated
    public void recycleKubernetesNodePool(UUID clusterId, UUID nodePoolId,
            RecycleKubernetesNodePoolRequest recycleKubernetesNodePoolRequest) {
        recycleKubernetesNodePoolWithHttpInfo(clusterId, nodePoolId, recycleKubernetesNodePoolRequest);
    }

    /**
     * Recycle a Kubernetes Node Pool The endpoint has been deprecated. Please use
     * the DELETE
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools/$NODE_POOL_ID/nodes/$NODE_ID&#x60;
     * method instead.
     *
     * @param clusterId                        A unique ID that can be used to
     *                                         reference a Kubernetes cluster.
     *                                         (required)
     * @param nodePoolId                       A unique ID that can be used to
     *                                         reference a Kubernetes node pool.
     *                                         (required)
     * @param recycleKubernetesNodePoolRequest (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     * @deprecated
     */
    @Deprecated
    public ApiResponse<Void> recycleKubernetesNodePoolWithHttpInfo(UUID clusterId, UUID nodePoolId,
            RecycleKubernetesNodePoolRequest recycleKubernetesNodePoolRequest) {
        HttpRequest.Builder localVarRequestBuilder = recycleKubernetesNodePoolRequestBuilder(clusterId, nodePoolId,
                recycleKubernetesNodePoolRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("recycleKubernetesNodePool", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder recycleKubernetesNodePoolRequestBuilder(UUID clusterId, UUID nodePoolId,
            RecycleKubernetesNodePoolRequest recycleKubernetesNodePoolRequest) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling recycleKubernetesNodePool");
        }
        // verify the required parameter 'nodePoolId' is set
        if (nodePoolId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'nodePoolId' when calling recycleKubernetesNodePool");
        }
        // verify the required parameter 'recycleKubernetesNodePoolRequest' is set
        if (recycleKubernetesNodePoolRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'recycleKubernetesNodePoolRequest' when calling recycleKubernetesNodePool");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/node_pools/{node_pool_id}/recycle"
                .replace("{cluster_id}", ApiClient.urlEncode(clusterId.toString()))
                .replace("{node_pool_id}", ApiClient.urlEncode(nodePoolId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(recycleKubernetesNodePoolRequest);
            localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Remove Container Registry from Kubernetes Clusters To remove the container
     * registry from Kubernetes clusters, send a DELETE request to
     * &#x60;/v2/kubernetes/registry&#x60;.
     *
     * @param clusterRegistries (optional)
     * @throws ApiException if fails to make API call
     */
    public void removeRegistry(ClusterRegistries clusterRegistries) {
        removeRegistryWithHttpInfo(clusterRegistries);
    }

    /**
     * Remove Container Registry from Kubernetes Clusters To remove the container
     * registry from Kubernetes clusters, send a DELETE request to
     * &#x60;/v2/kubernetes/registry&#x60;.
     *
     * @param clusterRegistries (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> removeRegistryWithHttpInfo(ClusterRegistries clusterRegistries) {
        HttpRequest.Builder localVarRequestBuilder = removeRegistryRequestBuilder(clusterRegistries);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("removeRegistry", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder removeRegistryRequestBuilder(ClusterRegistries clusterRegistries) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/registry";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(clusterRegistries);
            localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Run Clusterlint Checks on a Kubernetes Cluster Clusterlint helps operators
     * conform to Kubernetes best practices around resources, security and
     * reliability to avoid common problems while operating or upgrading the
     * clusters. To request a clusterlint run on your cluster, send a POST request
     * to &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/clusterlint&#x60;. This will
     * run all checks present in the &#x60;doks&#x60; group by default, if a request
     * body is not specified. Optionally specify the below attributes. For
     * information about the available checks, please refer to [the clusterlint
     * check
     * documentation](https://github.com/digitalocean/clusterlint/blob/master/checks.md).
     *
     * @param clusterId          A unique ID that can be used to reference a
     *                           Kubernetes cluster. (required)
     * @param clusterlintRequest (optional)
     * @return RunClusterlintResponse
     * @throws ApiException if fails to make API call
     */
    public RunClusterlintResponse runClusterlint(UUID clusterId, ClusterlintRequest clusterlintRequest) {
        ApiResponse<RunClusterlintResponse> localVarResponse = runClusterlintWithHttpInfo(clusterId,
                clusterlintRequest);
        return localVarResponse.getData();
    }

    /**
     * Run Clusterlint Checks on a Kubernetes Cluster Clusterlint helps operators
     * conform to Kubernetes best practices around resources, security and
     * reliability to avoid common problems while operating or upgrading the
     * clusters. To request a clusterlint run on your cluster, send a POST request
     * to &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/clusterlint&#x60;. This will
     * run all checks present in the &#x60;doks&#x60; group by default, if a request
     * body is not specified. Optionally specify the below attributes. For
     * information about the available checks, please refer to [the clusterlint
     * check
     * documentation](https://github.com/digitalocean/clusterlint/blob/master/checks.md).
     *
     * @param clusterId          A unique ID that can be used to reference a
     *                           Kubernetes cluster. (required)
     * @param clusterlintRequest (optional)
     * @return ApiResponse&lt;RunClusterlintResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<RunClusterlintResponse> runClusterlintWithHttpInfo(UUID clusterId,
            ClusterlintRequest clusterlintRequest) {
        HttpRequest.Builder localVarRequestBuilder = runClusterlintRequestBuilder(clusterId, clusterlintRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("runClusterlint", localVarResponse);
                }
                return new ApiResponse<RunClusterlintResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<RunClusterlintResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder runClusterlintRequestBuilder(UUID clusterId, ClusterlintRequest clusterlintRequest) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400, "Missing the required parameter 'clusterId' when calling runClusterlint");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/clusterlint".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(clusterlintRequest);
            localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Update a Kubernetes Cluster To update a Kubernetes cluster, send a PUT
     * request to &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID&#x60; and specify
     * one or more of the attributes below.
     *
     * @param clusterId     A unique ID that can be used to reference a Kubernetes
     *                      cluster. (required)
     * @param clusterUpdate (required)
     * @return CreateKubernetesClusterResponse
     * @throws ApiException if fails to make API call
     */
    public CreateKubernetesClusterResponse updateKubernetesCluster(UUID clusterId, ClusterUpdate clusterUpdate) {
        ApiResponse<CreateKubernetesClusterResponse> localVarResponse = updateKubernetesClusterWithHttpInfo(clusterId,
                clusterUpdate);
        return localVarResponse.getData();
    }

    /**
     * Update a Kubernetes Cluster To update a Kubernetes cluster, send a PUT
     * request to &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID&#x60; and specify
     * one or more of the attributes below.
     *
     * @param clusterId     A unique ID that can be used to reference a Kubernetes
     *                      cluster. (required)
     * @param clusterUpdate (required)
     * @return ApiResponse&lt;CreateKubernetesClusterResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateKubernetesClusterResponse> updateKubernetesClusterWithHttpInfo(UUID clusterId,
            ClusterUpdate clusterUpdate) {
        HttpRequest.Builder localVarRequestBuilder = updateKubernetesClusterRequestBuilder(clusterId, clusterUpdate);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateKubernetesCluster", localVarResponse);
                }
                return new ApiResponse<CreateKubernetesClusterResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateKubernetesClusterResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder updateKubernetesClusterRequestBuilder(UUID clusterId, ClusterUpdate clusterUpdate) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling updateKubernetesCluster");
        }
        // verify the required parameter 'clusterUpdate' is set
        if (clusterUpdate == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterUpdate' when calling updateKubernetesCluster");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(clusterUpdate);
            localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Update a Node Pool in a Kubernetes Cluster To update the name of a node pool,
     * edit the tags applied to it, or adjust its number of nodes, send a PUT
     * request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools/$NODE_POOL_ID&#x60;
     * with the following attributes.
     *
     * @param clusterId                A unique ID that can be used to reference a
     *                                 Kubernetes cluster. (required)
     * @param nodePoolId               A unique ID that can be used to reference a
     *                                 Kubernetes node pool. (required)
     * @param kubernetesNodePoolUpdate (required)
     * @return UpdateKubernetesNodePoolResponse
     * @throws ApiException if fails to make API call
     */
    public UpdateKubernetesNodePoolResponse updateKubernetesNodePool(UUID clusterId, UUID nodePoolId,
            KubernetesNodePoolUpdate kubernetesNodePoolUpdate) {
        ApiResponse<UpdateKubernetesNodePoolResponse> localVarResponse = updateKubernetesNodePoolWithHttpInfo(clusterId,
                nodePoolId, kubernetesNodePoolUpdate);
        return localVarResponse.getData();
    }

    /**
     * Update a Node Pool in a Kubernetes Cluster To update the name of a node pool,
     * edit the tags applied to it, or adjust its number of nodes, send a PUT
     * request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/node_pools/$NODE_POOL_ID&#x60;
     * with the following attributes.
     *
     * @param clusterId                A unique ID that can be used to reference a
     *                                 Kubernetes cluster. (required)
     * @param nodePoolId               A unique ID that can be used to reference a
     *                                 Kubernetes node pool. (required)
     * @param kubernetesNodePoolUpdate (required)
     * @return ApiResponse&lt;UpdateKubernetesNodePoolResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<UpdateKubernetesNodePoolResponse> updateKubernetesNodePoolWithHttpInfo(UUID clusterId,
            UUID nodePoolId, KubernetesNodePoolUpdate kubernetesNodePoolUpdate) {
        HttpRequest.Builder localVarRequestBuilder = updateKubernetesNodePoolRequestBuilder(clusterId, nodePoolId,
                kubernetesNodePoolUpdate);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateKubernetesNodePool", localVarResponse);
                }
                return new ApiResponse<UpdateKubernetesNodePoolResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<UpdateKubernetesNodePoolResponse>() {
                                }) // closes
                                   // the
                                   // InputStream

                );
            } finally {
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder updateKubernetesNodePoolRequestBuilder(UUID clusterId, UUID nodePoolId,
            KubernetesNodePoolUpdate kubernetesNodePoolUpdate) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling updateKubernetesNodePool");
        }
        // verify the required parameter 'nodePoolId' is set
        if (nodePoolId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'nodePoolId' when calling updateKubernetesNodePool");
        }
        // verify the required parameter 'kubernetesNodePoolUpdate' is set
        if (kubernetesNodePoolUpdate == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'kubernetesNodePoolUpdate' when calling updateKubernetesNodePool");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/node_pools/{node_pool_id}"
                .replace("{cluster_id}", ApiClient.urlEncode(clusterId.toString()))
                .replace("{node_pool_id}", ApiClient.urlEncode(nodePoolId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(kubernetesNodePoolUpdate);
            localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Upgrade a Kubernetes Cluster To immediately upgrade a Kubernetes cluster to a
     * newer patch release of Kubernetes, send a POST request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/upgrade&#x60;. The body of the
     * request must specify a version attribute. Available upgrade versions for a
     * cluster can be fetched from
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/upgrades&#x60;.
     *
     * @param clusterId                       A unique ID that can be used to
     *                                        reference a Kubernetes cluster.
     *                                        (required)
     * @param upgradeKubernetesClusterRequest (required)
     * @throws ApiException if fails to make API call
     */
    public void upgradeKubernetesCluster(UUID clusterId,
            UpgradeKubernetesClusterRequest upgradeKubernetesClusterRequest) {
        upgradeKubernetesClusterWithHttpInfo(clusterId, upgradeKubernetesClusterRequest);
    }

    /**
     * Upgrade a Kubernetes Cluster To immediately upgrade a Kubernetes cluster to a
     * newer patch release of Kubernetes, send a POST request to
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/upgrade&#x60;. The body of the
     * request must specify a version attribute. Available upgrade versions for a
     * cluster can be fetched from
     * &#x60;/v2/kubernetes/clusters/$K8S_CLUSTER_ID/upgrades&#x60;.
     *
     * @param clusterId                       A unique ID that can be used to
     *                                        reference a Kubernetes cluster.
     *                                        (required)
     * @param upgradeKubernetesClusterRequest (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> upgradeKubernetesClusterWithHttpInfo(UUID clusterId,
            UpgradeKubernetesClusterRequest upgradeKubernetesClusterRequest) {
        HttpRequest.Builder localVarRequestBuilder = upgradeKubernetesClusterRequestBuilder(clusterId,
                upgradeKubernetesClusterRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("upgradeKubernetesCluster", localVarResponse);
                }
                return new ApiResponse<Void>(localVarResponse.statusCode(), localVarResponse.headers().map(),

                        null);
            } finally {
                // Drain the InputStream
                while (localVarResponse.body().read() != -1) {
                    // Ignore
                }
                localVarResponse.body().close();
            }
        } catch (IOException e) {
            throw new ApiException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApiException(e);
        }
    }

    private HttpRequest.Builder upgradeKubernetesClusterRequestBuilder(UUID clusterId,
            UpgradeKubernetesClusterRequest upgradeKubernetesClusterRequest) {
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'clusterId' when calling upgradeKubernetesCluster");
        }
        // verify the required parameter 'upgradeKubernetesClusterRequest' is set
        if (upgradeKubernetesClusterRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'upgradeKubernetesClusterRequest' when calling upgradeKubernetesCluster");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/kubernetes/clusters/{cluster_id}/upgrade".replace("{cluster_id}",
                ApiClient.urlEncode(clusterId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(upgradeKubernetesClusterRequest);
            localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
        } catch (IOException e) {
            throw new ApiException(e);
        }
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }
}
