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
import java.util.function.Consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.webfolder.ocean.ApiClient;
import io.webfolder.ocean.ApiException;
import io.webfolder.ocean.ApiResponse;
import io.webfolder.ocean.Pair;
import io.webfolder.ocean.model.DockerCredentials;
import io.webfolder.ocean.model.GetGarbageCollectionResponse;
import io.webfolder.ocean.model.GetRegistryOptionsResponse;
import io.webfolder.ocean.model.GetRegistryResponse;
import io.webfolder.ocean.model.GetRegistrySubscriptionResponse;
import io.webfolder.ocean.model.ListGarbageCollectionsResponse;
import io.webfolder.ocean.model.ListRegistryRepositoriesResponse;
import io.webfolder.ocean.model.ListRegistryRepositoriesV2Response;
import io.webfolder.ocean.model.ListRepositoryDigestsResponse;
import io.webfolder.ocean.model.ListRepositoryTagsResponse;
import io.webfolder.ocean.model.PostRegistrySubscriptionRequest;
import io.webfolder.ocean.model.RegistryCreate;
import io.webfolder.ocean.model.UpdateRegistry;
import io.webfolder.ocean.model.ValidateRegistry;

public class ContainerRegistryApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public ContainerRegistryApi() {
        this(new ApiClient());
    }

    public ContainerRegistryApi(ApiClient apiClient) {
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
     * Create Container Registry To create your container registry, send a POST
     * request to &#x60;/v2/registry&#x60;. The &#x60;name&#x60; becomes part of the
     * URL for images stored in the registry. For example, if your registry is
     * called &#x60;example&#x60;, an image in it will have the URL
     * &#x60;registry.digitalocean.com/example/image:tag&#x60;.
     *
     * @param registryCreate (required)
     * @return GetRegistryResponse
     * @throws ApiException if fails to make API call
     */
    public GetRegistryResponse createRegistry(RegistryCreate registryCreate) {
        ApiResponse<GetRegistryResponse> localVarResponse = createRegistryWithHttpInfo(registryCreate);
        return localVarResponse.getData();
    }

    /**
     * Create Container Registry To create your container registry, send a POST
     * request to &#x60;/v2/registry&#x60;. The &#x60;name&#x60; becomes part of the
     * URL for images stored in the registry. For example, if your registry is
     * called &#x60;example&#x60;, an image in it will have the URL
     * &#x60;registry.digitalocean.com/example/image:tag&#x60;.
     *
     * @param registryCreate (required)
     * @return ApiResponse&lt;GetRegistryResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetRegistryResponse> createRegistryWithHttpInfo(RegistryCreate registryCreate) {
        HttpRequest.Builder localVarRequestBuilder = createRegistryRequestBuilder(registryCreate);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createRegistry", localVarResponse);
                }
                return new ApiResponse<GetRegistryResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetRegistryResponse>() {
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

    private HttpRequest.Builder createRegistryRequestBuilder(RegistryCreate registryCreate) {
        // verify the required parameter 'registryCreate' is set
        if (registryCreate == null) {
            throw new ApiException(400, "Missing the required parameter 'registryCreate' when calling createRegistry");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(registryCreate);
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
     * Delete Container Registry To delete your container registry, destroying all
     * container image data stored in it, send a DELETE request to
     * &#x60;/v2/registry&#x60;.
     *
     * @throws ApiException if fails to make API call
     */
    public void deleteRegistry() {
        deleteRegistryWithHttpInfo();
    }

    /**
     * Delete Container Registry To delete your container registry, destroying all
     * container image data stored in it, send a DELETE request to
     * &#x60;/v2/registry&#x60;.
     *
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteRegistryWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = deleteRegistryRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteRegistry", localVarResponse);
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

    private HttpRequest.Builder deleteRegistryRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry";

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
     * Delete Container Registry Repository Manifest To delete a container
     * repository manifest by digest, send a DELETE request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositories/$REPOSITORY_NAME/digests/$MANIFEST_DIGEST&#x60;.
     * Note that if your repository name contains &#x60;/&#x60; characters, it must
     * be URL-encoded in the request URL. For example, to delete
     * &#x60;registry.digitalocean.com/example/my/repo@sha256:abcd&#x60;, the path
     * would be
     * &#x60;/v2/registry/example/repositories/my%2Frepo/digests/sha256:abcd&#x60;.
     * A successful request will receive a 204 status code with no body in response.
     * This indicates that the request was processed successfully.
     *
     * @param registryName   The name of a container registry. (required)
     * @param repositoryName The name of a container registry repository. If the
     *                       name contains &#x60;/&#x60; characters, they must be
     *                       URL-encoded, e.g. &#x60;%2F&#x60;. (required)
     * @param manifestDigest The manifest digest of a container registry repository
     *                       tag. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteRepositoryManifest(String registryName, String repositoryName, String manifestDigest) {
        deleteRepositoryManifestWithHttpInfo(registryName, repositoryName, manifestDigest);
    }

    /**
     * Delete Container Registry Repository Manifest To delete a container
     * repository manifest by digest, send a DELETE request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositories/$REPOSITORY_NAME/digests/$MANIFEST_DIGEST&#x60;.
     * Note that if your repository name contains &#x60;/&#x60; characters, it must
     * be URL-encoded in the request URL. For example, to delete
     * &#x60;registry.digitalocean.com/example/my/repo@sha256:abcd&#x60;, the path
     * would be
     * &#x60;/v2/registry/example/repositories/my%2Frepo/digests/sha256:abcd&#x60;.
     * A successful request will receive a 204 status code with no body in response.
     * This indicates that the request was processed successfully.
     *
     * @param registryName   The name of a container registry. (required)
     * @param repositoryName The name of a container registry repository. If the
     *                       name contains &#x60;/&#x60; characters, they must be
     *                       URL-encoded, e.g. &#x60;%2F&#x60;. (required)
     * @param manifestDigest The manifest digest of a container registry repository
     *                       tag. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteRepositoryManifestWithHttpInfo(String registryName, String repositoryName,
            String manifestDigest) {
        HttpRequest.Builder localVarRequestBuilder = deleteRepositoryManifestRequestBuilder(registryName,
                repositoryName, manifestDigest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteRepositoryManifest", localVarResponse);
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

    private HttpRequest.Builder deleteRepositoryManifestRequestBuilder(String registryName, String repositoryName,
            String manifestDigest) {
        // verify the required parameter 'registryName' is set
        if (registryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'registryName' when calling deleteRepositoryManifest");
        }
        // verify the required parameter 'repositoryName' is set
        if (repositoryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'repositoryName' when calling deleteRepositoryManifest");
        }
        // verify the required parameter 'manifestDigest' is set
        if (manifestDigest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'manifestDigest' when calling deleteRepositoryManifest");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/{registry_name}/{repository_name}/digests/{manifest_digest}"
                .replace("{registry_name}", ApiClient.urlEncode(registryName.toString()))
                .replace("{repository_name}", ApiClient.urlEncode(repositoryName.toString()))
                .replace("{manifest_digest}", ApiClient.urlEncode(manifestDigest.toString()));

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
     * Delete Container Registry Repository Tag To delete a container repository
     * tag, send a DELETE request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositories/$REPOSITORY_NAME/tags/$TAG&#x60;.
     * Note that if your repository name contains &#x60;/&#x60; characters, it must
     * be URL-encoded in the request URL. For example, to delete
     * &#x60;registry.digitalocean.com/example/my/repo:mytag&#x60;, the path would
     * be &#x60;/v2/registry/example/repositories/my%2Frepo/tags/mytag&#x60;. A
     * successful request will receive a 204 status code with no body in response.
     * This indicates that the request was processed successfully.
     *
     * @param registryName   The name of a container registry. (required)
     * @param repositoryName The name of a container registry repository. If the
     *                       name contains &#x60;/&#x60; characters, they must be
     *                       URL-encoded, e.g. &#x60;%2F&#x60;. (required)
     * @param repositoryTag  The name of a container registry repository tag.
     *                       (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteRepositoryTag(String registryName, String repositoryName, String repositoryTag) {
        deleteRepositoryTagWithHttpInfo(registryName, repositoryName, repositoryTag);
    }

    /**
     * Delete Container Registry Repository Tag To delete a container repository
     * tag, send a DELETE request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositories/$REPOSITORY_NAME/tags/$TAG&#x60;.
     * Note that if your repository name contains &#x60;/&#x60; characters, it must
     * be URL-encoded in the request URL. For example, to delete
     * &#x60;registry.digitalocean.com/example/my/repo:mytag&#x60;, the path would
     * be &#x60;/v2/registry/example/repositories/my%2Frepo/tags/mytag&#x60;. A
     * successful request will receive a 204 status code with no body in response.
     * This indicates that the request was processed successfully.
     *
     * @param registryName   The name of a container registry. (required)
     * @param repositoryName The name of a container registry repository. If the
     *                       name contains &#x60;/&#x60; characters, they must be
     *                       URL-encoded, e.g. &#x60;%2F&#x60;. (required)
     * @param repositoryTag  The name of a container registry repository tag.
     *                       (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteRepositoryTagWithHttpInfo(String registryName, String repositoryName,
            String repositoryTag) {
        HttpRequest.Builder localVarRequestBuilder = deleteRepositoryTagRequestBuilder(registryName, repositoryName,
                repositoryTag);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteRepositoryTag", localVarResponse);
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

    private HttpRequest.Builder deleteRepositoryTagRequestBuilder(String registryName, String repositoryName,
            String repositoryTag) {
        // verify the required parameter 'registryName' is set
        if (registryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'registryName' when calling deleteRepositoryTag");
        }
        // verify the required parameter 'repositoryName' is set
        if (repositoryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'repositoryName' when calling deleteRepositoryTag");
        }
        // verify the required parameter 'repositoryTag' is set
        if (repositoryTag == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'repositoryTag' when calling deleteRepositoryTag");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/{registry_name}/{repository_name}/tags/{repository_tag}"
                .replace("{registry_name}", ApiClient.urlEncode(registryName.toString()))
                .replace("{repository_name}", ApiClient.urlEncode(repositoryName.toString()))
                .replace("{repository_tag}", ApiClient.urlEncode(repositoryTag.toString()));

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
     * Get Docker Credentials for Container Registry In order to access your
     * container registry with the Docker client or from a Kubernetes cluster, you
     * will need to configure authentication. The necessary JSON configuration can
     * be retrieved by sending a GET request to
     * &#x60;/v2/registry/docker-credentials&#x60;. The response will be in the
     * format of a Docker &#x60;config.json&#x60; file. To use the config in your
     * Kubernetes cluster, create a Secret with: kubectl create secret generic docr
     * \\ --from-file&#x3D;.dockerconfigjson&#x3D;config.json \\
     * --type&#x3D;kubernetes.io/dockerconfigjson By default, the returned
     * credentials have read-only access to your registry and cannot be used to push
     * images. This is appropriate for most Kubernetes clusters. To retrieve
     * read/write credentials, suitable for use with the Docker client or in a CI
     * system, read_write may be provided as query parameter. For example:
     * &#x60;/v2/registry/docker-credentials?read_write&#x3D;true&#x60; By default,
     * the returned credentials will not expire. To retrieve credentials with an
     * expiry set, expiry_seconds may be provided as a query parameter. For example:
     * &#x60;/v2/registry/docker-credentials?expiry_seconds&#x3D;3600&#x60; will
     * return credentials that expire after one hour.
     *
     * @param expirySeconds The duration in seconds that the returned registry
     *                      credentials will be valid. If not set or 0, the
     *                      credentials will not expire. (optional, default to 0)
     * @param readWrite     By default, the registry credentials allow for read-only
     *                      access. Set this query parameter to &#x60;true&#x60; to
     *                      obtain read-write credentials. (optional, default to
     *                      false)
     * @return DockerCredentials
     * @throws ApiException if fails to make API call
     */
    public DockerCredentials getDockerCredentials(Integer expirySeconds, Boolean readWrite) {
        ApiResponse<DockerCredentials> localVarResponse = getDockerCredentialsWithHttpInfo(expirySeconds, readWrite);
        return localVarResponse.getData();
    }

    /**
     * Get Docker Credentials for Container Registry In order to access your
     * container registry with the Docker client or from a Kubernetes cluster, you
     * will need to configure authentication. The necessary JSON configuration can
     * be retrieved by sending a GET request to
     * &#x60;/v2/registry/docker-credentials&#x60;. The response will be in the
     * format of a Docker &#x60;config.json&#x60; file. To use the config in your
     * Kubernetes cluster, create a Secret with: kubectl create secret generic docr
     * \\ --from-file&#x3D;.dockerconfigjson&#x3D;config.json \\
     * --type&#x3D;kubernetes.io/dockerconfigjson By default, the returned
     * credentials have read-only access to your registry and cannot be used to push
     * images. This is appropriate for most Kubernetes clusters. To retrieve
     * read/write credentials, suitable for use with the Docker client or in a CI
     * system, read_write may be provided as query parameter. For example:
     * &#x60;/v2/registry/docker-credentials?read_write&#x3D;true&#x60; By default,
     * the returned credentials will not expire. To retrieve credentials with an
     * expiry set, expiry_seconds may be provided as a query parameter. For example:
     * &#x60;/v2/registry/docker-credentials?expiry_seconds&#x3D;3600&#x60; will
     * return credentials that expire after one hour.
     *
     * @param expirySeconds The duration in seconds that the returned registry
     *                      credentials will be valid. If not set or 0, the
     *                      credentials will not expire. (optional, default to 0)
     * @param readWrite     By default, the registry credentials allow for read-only
     *                      access. Set this query parameter to &#x60;true&#x60; to
     *                      obtain read-write credentials. (optional, default to
     *                      false)
     * @return ApiResponse&lt;DockerCredentials&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<DockerCredentials> getDockerCredentialsWithHttpInfo(Integer expirySeconds, Boolean readWrite) {
        HttpRequest.Builder localVarRequestBuilder = getDockerCredentialsRequestBuilder(expirySeconds, readWrite);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDockerCredentials", localVarResponse);
                }
                return new ApiResponse<DockerCredentials>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<DockerCredentials>() {
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

    private HttpRequest.Builder getDockerCredentialsRequestBuilder(Integer expirySeconds, Boolean readWrite) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/docker-credentials";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("expiry_seconds", expirySeconds));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("read_write", readWrite));

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
     * Get Active Garbage Collection To get information about the currently-active
     * garbage collection for a registry, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/garbage-collection&#x60;.
     *
     * @param registryName The name of a container registry. (required)
     * @return GetGarbageCollectionResponse
     * @throws ApiException if fails to make API call
     */
    public GetGarbageCollectionResponse getGarbageCollection(String registryName) {
        ApiResponse<GetGarbageCollectionResponse> localVarResponse = getGarbageCollectionWithHttpInfo(registryName);
        return localVarResponse.getData();
    }

    /**
     * Get Active Garbage Collection To get information about the currently-active
     * garbage collection for a registry, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/garbage-collection&#x60;.
     *
     * @param registryName The name of a container registry. (required)
     * @return ApiResponse&lt;GetGarbageCollectionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetGarbageCollectionResponse> getGarbageCollectionWithHttpInfo(String registryName) {
        HttpRequest.Builder localVarRequestBuilder = getGarbageCollectionRequestBuilder(registryName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getGarbageCollection", localVarResponse);
                }
                return new ApiResponse<GetGarbageCollectionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetGarbageCollectionResponse>() {
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

    private HttpRequest.Builder getGarbageCollectionRequestBuilder(String registryName) {
        // verify the required parameter 'registryName' is set
        if (registryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'registryName' when calling getGarbageCollection");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/{registry_name}/garbage-collection".replace("{registry_name}",
                ApiClient.urlEncode(registryName.toString()));

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
     * Get Container Registry Information To get information about your container
     * registry, send a GET request to &#x60;/v2/registry&#x60;.
     *
     * @return GetRegistryResponse
     * @throws ApiException if fails to make API call
     */
    public GetRegistryResponse getRegistry() {
        ApiResponse<GetRegistryResponse> localVarResponse = getRegistryWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * Get Container Registry Information To get information about your container
     * registry, send a GET request to &#x60;/v2/registry&#x60;.
     *
     * @return ApiResponse&lt;GetRegistryResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetRegistryResponse> getRegistryWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = getRegistryRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getRegistry", localVarResponse);
                }
                return new ApiResponse<GetRegistryResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetRegistryResponse>() {
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

    private HttpRequest.Builder getRegistryRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry";

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
     * List Registry Options (Subscription Tiers and Available Regions) This
     * endpoint serves to provide additional information as to which option values
     * are available when creating a container registry. There are multiple
     * subscription tiers available for container registry. Each tier allows a
     * different number of image repositories to be created in your registry, and
     * has a different amount of storage and transfer included. There are multiple
     * regions available for container registry and controls where your data is
     * stored. To list the available options, send a GET request to
     * &#x60;/v2/registry/options&#x60;.
     *
     * @return GetRegistryOptionsResponse
     * @throws ApiException if fails to make API call
     */
    public GetRegistryOptionsResponse getRegistryOptions() {
        ApiResponse<GetRegistryOptionsResponse> localVarResponse = getRegistryOptionsWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List Registry Options (Subscription Tiers and Available Regions) This
     * endpoint serves to provide additional information as to which option values
     * are available when creating a container registry. There are multiple
     * subscription tiers available for container registry. Each tier allows a
     * different number of image repositories to be created in your registry, and
     * has a different amount of storage and transfer included. There are multiple
     * regions available for container registry and controls where your data is
     * stored. To list the available options, send a GET request to
     * &#x60;/v2/registry/options&#x60;.
     *
     * @return ApiResponse&lt;GetRegistryOptionsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetRegistryOptionsResponse> getRegistryOptionsWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = getRegistryOptionsRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getRegistryOptions", localVarResponse);
                }
                return new ApiResponse<GetRegistryOptionsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetRegistryOptionsResponse>() {
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

    private HttpRequest.Builder getRegistryOptionsRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/options";

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
     * Get Subscription Information A subscription is automatically created when you
     * configure your container registry. To get information about your
     * subscription, send a GET request to &#x60;/v2/registry/subscription&#x60;.
     *
     * @return GetRegistrySubscriptionResponse
     * @throws ApiException if fails to make API call
     */
    public GetRegistrySubscriptionResponse getRegistrySubscription() {
        ApiResponse<GetRegistrySubscriptionResponse> localVarResponse = getRegistrySubscriptionWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * Get Subscription Information A subscription is automatically created when you
     * configure your container registry. To get information about your
     * subscription, send a GET request to &#x60;/v2/registry/subscription&#x60;.
     *
     * @return ApiResponse&lt;GetRegistrySubscriptionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetRegistrySubscriptionResponse> getRegistrySubscriptionWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = getRegistrySubscriptionRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getRegistrySubscription", localVarResponse);
                }
                return new ApiResponse<GetRegistrySubscriptionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetRegistrySubscriptionResponse>() {
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

    private HttpRequest.Builder getRegistrySubscriptionRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/subscription";

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
     * List Garbage Collections To get information about past garbage collections
     * for a registry, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/garbage-collections&#x60;.
     *
     * @param registryName The name of a container registry. (required)
     * @param perPage      Number of items returned per page (optional, default to
     *                     20)
     * @param page         Which &#39;page&#39; of paginated results to return.
     *                     (optional, default to 1)
     * @return ListGarbageCollectionsResponse
     * @throws ApiException if fails to make API call
     */
    public ListGarbageCollectionsResponse listGarbageCollections(String registryName, Integer perPage, Integer page) {
        ApiResponse<ListGarbageCollectionsResponse> localVarResponse = listGarbageCollectionsWithHttpInfo(registryName,
                perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List Garbage Collections To get information about past garbage collections
     * for a registry, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/garbage-collections&#x60;.
     *
     * @param registryName The name of a container registry. (required)
     * @param perPage      Number of items returned per page (optional, default to
     *                     20)
     * @param page         Which &#39;page&#39; of paginated results to return.
     *                     (optional, default to 1)
     * @return ApiResponse&lt;ListGarbageCollectionsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListGarbageCollectionsResponse> listGarbageCollectionsWithHttpInfo(String registryName,
            Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listGarbageCollectionsRequestBuilder(registryName, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listGarbageCollections", localVarResponse);
                }
                return new ApiResponse<ListGarbageCollectionsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListGarbageCollectionsResponse>() {
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

    private HttpRequest.Builder listGarbageCollectionsRequestBuilder(String registryName, Integer perPage,
            Integer page) {
        // verify the required parameter 'registryName' is set
        if (registryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'registryName' when calling listGarbageCollections");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/{registry_name}/garbage-collections".replace("{registry_name}",
                ApiClient.urlEncode(registryName.toString()));

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
     * List All Container Registry Repositories This endpoint has been deprecated in
     * favor of the _List All Container Registry Repositories [V2]_ endpoint. To
     * list all repositories in your container registry, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositories&#x60;.
     *
     * @param registryName The name of a container registry. (required)
     * @param perPage      Number of items returned per page (optional, default to
     *                     20)
     * @param page         Which &#39;page&#39; of paginated results to return.
     *                     (optional, default to 1)
     * @return ListRegistryRepositoriesResponse
     * @throws ApiException if fails to make API call
     * @deprecated
     */
    @Deprecated
    public ListRegistryRepositoriesResponse listRegistryRepositories(String registryName, Integer perPage,
            Integer page) {
        ApiResponse<ListRegistryRepositoriesResponse> localVarResponse = listRegistryRepositoriesWithHttpInfo(
                registryName, perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All Container Registry Repositories This endpoint has been deprecated in
     * favor of the _List All Container Registry Repositories [V2]_ endpoint. To
     * list all repositories in your container registry, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositories&#x60;.
     *
     * @param registryName The name of a container registry. (required)
     * @param perPage      Number of items returned per page (optional, default to
     *                     20)
     * @param page         Which &#39;page&#39; of paginated results to return.
     *                     (optional, default to 1)
     * @return ApiResponse&lt;ListRegistryRepositoriesResponse&gt;
     * @throws ApiException if fails to make API call
     * @deprecated
     */
    @Deprecated
    public ApiResponse<ListRegistryRepositoriesResponse> listRegistryRepositoriesWithHttpInfo(String registryName,
            Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listRegistryRepositoriesRequestBuilder(registryName, perPage,
                page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listRegistryRepositories", localVarResponse);
                }
                return new ApiResponse<ListRegistryRepositoriesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListRegistryRepositoriesResponse>() {
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

    private HttpRequest.Builder listRegistryRepositoriesRequestBuilder(String registryName, Integer perPage,
            Integer page) {
        // verify the required parameter 'registryName' is set
        if (registryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'registryName' when calling listRegistryRepositories");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/{registry_name}/repositories".replace("{registry_name}",
                ApiClient.urlEncode(registryName.toString()));

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
     * List All Container Registry Repositories (V2) To list all repositories in
     * your container registry, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositoriesV2&#x60;.
     *
     * @param registryName The name of a container registry. (required)
     * @param perPage      Number of items returned per page (optional, default to
     *                     20)
     * @param page         Which &#39;page&#39; of paginated results to return.
     *                     Ignored when &#39;page_token&#39; is provided. (optional,
     *                     default to 1)
     * @param pageToken    Token to retrieve of the next or previous set of results
     *                     more quickly than using &#39;page&#39;. (optional)
     * @return ListRegistryRepositoriesV2Response
     * @throws ApiException if fails to make API call
     */
    public ListRegistryRepositoriesV2Response listRegistryRepositoriesV2(String registryName, Integer perPage,
            Integer page, String pageToken) {
        ApiResponse<ListRegistryRepositoriesV2Response> localVarResponse = listRegistryRepositoriesV2WithHttpInfo(
                registryName, perPage, page, pageToken);
        return localVarResponse.getData();
    }

    /**
     * List All Container Registry Repositories (V2) To list all repositories in
     * your container registry, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositoriesV2&#x60;.
     *
     * @param registryName The name of a container registry. (required)
     * @param perPage      Number of items returned per page (optional, default to
     *                     20)
     * @param page         Which &#39;page&#39; of paginated results to return.
     *                     Ignored when &#39;page_token&#39; is provided. (optional,
     *                     default to 1)
     * @param pageToken    Token to retrieve of the next or previous set of results
     *                     more quickly than using &#39;page&#39;. (optional)
     * @return ApiResponse&lt;ListRegistryRepositoriesV2Response&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListRegistryRepositoriesV2Response> listRegistryRepositoriesV2WithHttpInfo(String registryName,
            Integer perPage, Integer page, String pageToken) {
        HttpRequest.Builder localVarRequestBuilder = listRegistryRepositoriesV2RequestBuilder(registryName, perPage,
                page, pageToken);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listRegistryRepositoriesV2", localVarResponse);
                }
                return new ApiResponse<ListRegistryRepositoriesV2Response>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListRegistryRepositoriesV2Response>() {
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

    private HttpRequest.Builder listRegistryRepositoriesV2RequestBuilder(String registryName, Integer perPage,
            Integer page, String pageToken) {
        // verify the required parameter 'registryName' is set
        if (registryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'registryName' when calling listRegistryRepositoriesV2");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/{registry_name}/repositoriesV2".replace("{registry_name}",
                ApiClient.urlEncode(registryName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("per_page", perPage));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("page", page));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("page_token", pageToken));

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
     * List All Container Registry Repository Manifests To list all manifests in
     * your container registry repository, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositories/$REPOSITORY_NAME/digests&#x60;.
     * Note that if your repository name contains &#x60;/&#x60; characters, it must
     * be URL-encoded in the request URL. For example, to list manifests for
     * &#x60;registry.digitalocean.com/example/my/repo&#x60;, the path would be
     * &#x60;/v2/registry/example/repositories/my%2Frepo/digests&#x60;.
     *
     * @param registryName   The name of a container registry. (required)
     * @param repositoryName The name of a container registry repository. If the
     *                       name contains &#x60;/&#x60; characters, they must be
     *                       URL-encoded, e.g. &#x60;%2F&#x60;. (required)
     * @param perPage        Number of items returned per page (optional, default to
     *                       20)
     * @param page           Which &#39;page&#39; of paginated results to return.
     *                       (optional, default to 1)
     * @return ListRepositoryDigestsResponse
     * @throws ApiException if fails to make API call
     */
    public ListRepositoryDigestsResponse listRepositoryDigests(String registryName, String repositoryName,
            Integer perPage, Integer page) {
        ApiResponse<ListRepositoryDigestsResponse> localVarResponse = listRepositoryDigestsWithHttpInfo(registryName,
                repositoryName, perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All Container Registry Repository Manifests To list all manifests in
     * your container registry repository, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositories/$REPOSITORY_NAME/digests&#x60;.
     * Note that if your repository name contains &#x60;/&#x60; characters, it must
     * be URL-encoded in the request URL. For example, to list manifests for
     * &#x60;registry.digitalocean.com/example/my/repo&#x60;, the path would be
     * &#x60;/v2/registry/example/repositories/my%2Frepo/digests&#x60;.
     *
     * @param registryName   The name of a container registry. (required)
     * @param repositoryName The name of a container registry repository. If the
     *                       name contains &#x60;/&#x60; characters, they must be
     *                       URL-encoded, e.g. &#x60;%2F&#x60;. (required)
     * @param perPage        Number of items returned per page (optional, default to
     *                       20)
     * @param page           Which &#39;page&#39; of paginated results to return.
     *                       (optional, default to 1)
     * @return ApiResponse&lt;ListRepositoryDigestsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListRepositoryDigestsResponse> listRepositoryDigestsWithHttpInfo(String registryName,
            String repositoryName, Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listRepositoryDigestsRequestBuilder(registryName, repositoryName,
                perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listRepositoryDigests", localVarResponse);
                }
                return new ApiResponse<ListRepositoryDigestsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListRepositoryDigestsResponse>() {
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

    private HttpRequest.Builder listRepositoryDigestsRequestBuilder(String registryName, String repositoryName,
            Integer perPage, Integer page) {
        // verify the required parameter 'registryName' is set
        if (registryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'registryName' when calling listRepositoryDigests");
        }
        // verify the required parameter 'repositoryName' is set
        if (repositoryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'repositoryName' when calling listRepositoryDigests");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/{registry_name}/{repository_name}/digests"
                .replace("{registry_name}", ApiClient.urlEncode(registryName.toString()))
                .replace("{repository_name}", ApiClient.urlEncode(repositoryName.toString()));

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
     * List All Container Registry Repository Tags To list all tags in your
     * container registry repository, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositories/$REPOSITORY_NAME/tags&#x60;.
     * Note that if your repository name contains &#x60;/&#x60; characters, it must
     * be URL-encoded in the request URL. For example, to list tags for
     * &#x60;registry.digitalocean.com/example/my/repo&#x60;, the path would be
     * &#x60;/v2/registry/example/repositories/my%2Frepo/tags&#x60;.
     *
     * @param registryName   The name of a container registry. (required)
     * @param repositoryName The name of a container registry repository. If the
     *                       name contains &#x60;/&#x60; characters, they must be
     *                       URL-encoded, e.g. &#x60;%2F&#x60;. (required)
     * @param perPage        Number of items returned per page (optional, default to
     *                       20)
     * @param page           Which &#39;page&#39; of paginated results to return.
     *                       (optional, default to 1)
     * @return ListRepositoryTagsResponse
     * @throws ApiException if fails to make API call
     */
    public ListRepositoryTagsResponse listRepositoryTags(String registryName, String repositoryName, Integer perPage,
            Integer page) {
        ApiResponse<ListRepositoryTagsResponse> localVarResponse = listRepositoryTagsWithHttpInfo(registryName,
                repositoryName, perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All Container Registry Repository Tags To list all tags in your
     * container registry repository, send a GET request to
     * &#x60;/v2/registry/$REGISTRY_NAME/repositories/$REPOSITORY_NAME/tags&#x60;.
     * Note that if your repository name contains &#x60;/&#x60; characters, it must
     * be URL-encoded in the request URL. For example, to list tags for
     * &#x60;registry.digitalocean.com/example/my/repo&#x60;, the path would be
     * &#x60;/v2/registry/example/repositories/my%2Frepo/tags&#x60;.
     *
     * @param registryName   The name of a container registry. (required)
     * @param repositoryName The name of a container registry repository. If the
     *                       name contains &#x60;/&#x60; characters, they must be
     *                       URL-encoded, e.g. &#x60;%2F&#x60;. (required)
     * @param perPage        Number of items returned per page (optional, default to
     *                       20)
     * @param page           Which &#39;page&#39; of paginated results to return.
     *                       (optional, default to 1)
     * @return ApiResponse&lt;ListRepositoryTagsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListRepositoryTagsResponse> listRepositoryTagsWithHttpInfo(String registryName,
            String repositoryName, Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listRepositoryTagsRequestBuilder(registryName, repositoryName,
                perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listRepositoryTags", localVarResponse);
                }
                return new ApiResponse<ListRepositoryTagsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListRepositoryTagsResponse>() {
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

    private HttpRequest.Builder listRepositoryTagsRequestBuilder(String registryName, String repositoryName,
            Integer perPage, Integer page) {
        // verify the required parameter 'registryName' is set
        if (registryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'registryName' when calling listRepositoryTags");
        }
        // verify the required parameter 'repositoryName' is set
        if (repositoryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'repositoryName' when calling listRepositoryTags");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/{registry_name}/{repository_name}/tags"
                .replace("{registry_name}", ApiClient.urlEncode(registryName.toString()))
                .replace("{repository_name}", ApiClient.urlEncode(repositoryName.toString()));

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
     * Update Subscription Tier After creating your registry, you can switch to a
     * different subscription tier to better suit your needs. To do this, send a
     * POST request to &#x60;/v2/registry/subscription&#x60;.
     *
     * @param postRegistrySubscriptionRequest (optional)
     * @return GetRegistrySubscriptionResponse
     * @throws ApiException if fails to make API call
     */
    public GetRegistrySubscriptionResponse postRegistrySubscription(
            PostRegistrySubscriptionRequest postRegistrySubscriptionRequest) {
        ApiResponse<GetRegistrySubscriptionResponse> localVarResponse = postRegistrySubscriptionWithHttpInfo(
                postRegistrySubscriptionRequest);
        return localVarResponse.getData();
    }

    /**
     * Update Subscription Tier After creating your registry, you can switch to a
     * different subscription tier to better suit your needs. To do this, send a
     * POST request to &#x60;/v2/registry/subscription&#x60;.
     *
     * @param postRegistrySubscriptionRequest (optional)
     * @return ApiResponse&lt;GetRegistrySubscriptionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetRegistrySubscriptionResponse> postRegistrySubscriptionWithHttpInfo(
            PostRegistrySubscriptionRequest postRegistrySubscriptionRequest) {
        HttpRequest.Builder localVarRequestBuilder = postRegistrySubscriptionRequestBuilder(
                postRegistrySubscriptionRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("postRegistrySubscription", localVarResponse);
                }
                return new ApiResponse<GetRegistrySubscriptionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetRegistrySubscriptionResponse>() {
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

    private HttpRequest.Builder postRegistrySubscriptionRequestBuilder(
            PostRegistrySubscriptionRequest postRegistrySubscriptionRequest) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/subscription";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(postRegistrySubscriptionRequest);
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
     * Start Garbage Collection Garbage collection enables users to clear out
     * unreferenced blobs (layer &amp; manifest data) after deleting one or more
     * manifests from a repository. If there are no unreferenced blobs resulting
     * from the deletion of one or more manifests, garbage collection is effectively
     * a noop. [See here for more
     * information](https://www.digitalocean.com/docs/container-registry/how-to/clean-up-container-registry/)
     * about how and why you should clean up your container registry periodically.
     * To request a garbage collection run on your registry, send a POST request to
     * &#x60;/v2/registry/$REGISTRY_NAME/garbage-collection&#x60;. This will
     * initiate the following sequence of events on your registry. * Set the
     * registry to read-only mode, meaning no further write-scoped JWTs will be
     * issued to registry clients. Existing write-scoped JWTs will continue to work
     * until they expire which can take up to 15 minutes. * Wait until all existing
     * write-scoped JWTs have expired. * Scan all registry manifests to determine
     * which blobs are unreferenced. * Delete all unreferenced blobs from the
     * registry. * Record the number of blobs deleted and bytes freed, mark the
     * garbage collection status as &#x60;success&#x60;. * Remove the read-only mode
     * restriction from the registry, meaning write-scoped JWTs will once again be
     * issued to registry clients.
     *
     * @param registryName The name of a container registry. (required)
     * @return GetGarbageCollectionResponse
     * @throws ApiException if fails to make API call
     */
    public GetGarbageCollectionResponse runGarbageCollection(String registryName) {
        ApiResponse<GetGarbageCollectionResponse> localVarResponse = runGarbageCollectionWithHttpInfo(registryName);
        return localVarResponse.getData();
    }

    /**
     * Start Garbage Collection Garbage collection enables users to clear out
     * unreferenced blobs (layer &amp; manifest data) after deleting one or more
     * manifests from a repository. If there are no unreferenced blobs resulting
     * from the deletion of one or more manifests, garbage collection is effectively
     * a noop. [See here for more
     * information](https://www.digitalocean.com/docs/container-registry/how-to/clean-up-container-registry/)
     * about how and why you should clean up your container registry periodically.
     * To request a garbage collection run on your registry, send a POST request to
     * &#x60;/v2/registry/$REGISTRY_NAME/garbage-collection&#x60;. This will
     * initiate the following sequence of events on your registry. * Set the
     * registry to read-only mode, meaning no further write-scoped JWTs will be
     * issued to registry clients. Existing write-scoped JWTs will continue to work
     * until they expire which can take up to 15 minutes. * Wait until all existing
     * write-scoped JWTs have expired. * Scan all registry manifests to determine
     * which blobs are unreferenced. * Delete all unreferenced blobs from the
     * registry. * Record the number of blobs deleted and bytes freed, mark the
     * garbage collection status as &#x60;success&#x60;. * Remove the read-only mode
     * restriction from the registry, meaning write-scoped JWTs will once again be
     * issued to registry clients.
     *
     * @param registryName The name of a container registry. (required)
     * @return ApiResponse&lt;GetGarbageCollectionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetGarbageCollectionResponse> runGarbageCollectionWithHttpInfo(String registryName) {
        HttpRequest.Builder localVarRequestBuilder = runGarbageCollectionRequestBuilder(registryName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("runGarbageCollection", localVarResponse);
                }
                return new ApiResponse<GetGarbageCollectionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetGarbageCollectionResponse>() {
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

    private HttpRequest.Builder runGarbageCollectionRequestBuilder(String registryName) {
        // verify the required parameter 'registryName' is set
        if (registryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'registryName' when calling runGarbageCollection");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/{registry_name}/garbage-collection".replace("{registry_name}",
                ApiClient.urlEncode(registryName.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Update Garbage Collection To cancel the currently-active garbage collection
     * for a registry, send a PUT request to
     * &#x60;/v2/registry/$REGISTRY_NAME/garbage-collection/$GC_UUID&#x60; and
     * specify one or more of the attributes below.
     *
     * @param registryName          The name of a container registry. (required)
     * @param garbageCollectionUuid The UUID of a garbage collection run. (required)
     * @param updateRegistry        (required)
     * @return GetGarbageCollectionResponse
     * @throws ApiException if fails to make API call
     */
    public GetGarbageCollectionResponse updateGarbageCollection(String registryName, String garbageCollectionUuid,
            UpdateRegistry updateRegistry) {
        ApiResponse<GetGarbageCollectionResponse> localVarResponse = updateGarbageCollectionWithHttpInfo(registryName,
                garbageCollectionUuid, updateRegistry);
        return localVarResponse.getData();
    }

    /**
     * Update Garbage Collection To cancel the currently-active garbage collection
     * for a registry, send a PUT request to
     * &#x60;/v2/registry/$REGISTRY_NAME/garbage-collection/$GC_UUID&#x60; and
     * specify one or more of the attributes below.
     *
     * @param registryName          The name of a container registry. (required)
     * @param garbageCollectionUuid The UUID of a garbage collection run. (required)
     * @param updateRegistry        (required)
     * @return ApiResponse&lt;GetGarbageCollectionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetGarbageCollectionResponse> updateGarbageCollectionWithHttpInfo(String registryName,
            String garbageCollectionUuid, UpdateRegistry updateRegistry) {
        HttpRequest.Builder localVarRequestBuilder = updateGarbageCollectionRequestBuilder(registryName,
                garbageCollectionUuid, updateRegistry);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateGarbageCollection", localVarResponse);
                }
                return new ApiResponse<GetGarbageCollectionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetGarbageCollectionResponse>() {
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

    private HttpRequest.Builder updateGarbageCollectionRequestBuilder(String registryName, String garbageCollectionUuid,
            UpdateRegistry updateRegistry) {
        // verify the required parameter 'registryName' is set
        if (registryName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'registryName' when calling updateGarbageCollection");
        }
        // verify the required parameter 'garbageCollectionUuid' is set
        if (garbageCollectionUuid == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'garbageCollectionUuid' when calling updateGarbageCollection");
        }
        // verify the required parameter 'updateRegistry' is set
        if (updateRegistry == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'updateRegistry' when calling updateGarbageCollection");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/{registry_name}/garbage-collection/{garbage_collection_uuid}"
                .replace("{registry_name}", ApiClient.urlEncode(registryName.toString()))
                .replace("{garbage_collection_uuid}", ApiClient.urlEncode(garbageCollectionUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateRegistry);
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
     * Validate a Container Registry Name To validate that a container registry name
     * is available for use, send a POST request to
     * &#x60;/v2/registry/validate-name&#x60;. If the name is both formatted
     * correctly and available, the response code will be 204 and contain no body.
     * If the name is already in use, the response will be a 409 Conflict.
     *
     * @param validateRegistry (required)
     * @throws ApiException if fails to make API call
     */
    public void validateRegistryName(ValidateRegistry validateRegistry) {
        validateRegistryNameWithHttpInfo(validateRegistry);
    }

    /**
     * Validate a Container Registry Name To validate that a container registry name
     * is available for use, send a POST request to
     * &#x60;/v2/registry/validate-name&#x60;. If the name is both formatted
     * correctly and available, the response code will be 204 and contain no body.
     * If the name is already in use, the response will be a 409 Conflict.
     *
     * @param validateRegistry (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> validateRegistryNameWithHttpInfo(ValidateRegistry validateRegistry) {
        HttpRequest.Builder localVarRequestBuilder = validateRegistryNameRequestBuilder(validateRegistry);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("validateRegistryName", localVarResponse);
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

    private HttpRequest.Builder validateRegistryNameRequestBuilder(ValidateRegistry validateRegistry) {
        // verify the required parameter 'validateRegistry' is set
        if (validateRegistry == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'validateRegistry' when calling validateRegistryName");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/registry/validate-name";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(validateRegistry);
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
