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

import io.webfolder.ocean.client.ApiClient;
import io.webfolder.ocean.client.ApiException;
import io.webfolder.ocean.client.ApiResponse;
import io.webfolder.ocean.client.internal.Pair;
import io.webfolder.ocean.model.CdnEndpoint;
import io.webfolder.ocean.model.CreateCdnEndpointResponse;
import io.webfolder.ocean.model.ListCdnEndpointsResponse;
import io.webfolder.ocean.model.PurgeCache;
import io.webfolder.ocean.model.UpdateEndpoint;

public class CdnEndpointsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public CdnEndpointsApi() {
        this(new ApiClient());
    }

    public CdnEndpointsApi(ApiClient apiClient) {
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
     * Create a New CDN Endpoint To create a new CDN endpoint, send a POST request
     * to &#x60;/v2/cdn/endpoints&#x60;. The origin attribute must be set to the
     * fully qualified domain name (FQDN) of a DigitalOcean Space. Optionally, the
     * TTL may be configured by setting the &#x60;ttl&#x60; attribute. A custom
     * subdomain may be configured by specifying the &#x60;custom_domain&#x60; and
     * &#x60;certificate_id&#x60; attributes.
     *
     * @param cdnEndpoint (required)
     * @return CreateCdnEndpointResponse
     * @throws ApiException if fails to make API call
     */
    public CreateCdnEndpointResponse createCdnEndpoint(CdnEndpoint cdnEndpoint) {
        ApiResponse<CreateCdnEndpointResponse> localVarResponse = createCdnEndpointWithHttpInfo(cdnEndpoint);
        return localVarResponse.getData();
    }

    /**
     * Create a New CDN Endpoint To create a new CDN endpoint, send a POST request
     * to &#x60;/v2/cdn/endpoints&#x60;. The origin attribute must be set to the
     * fully qualified domain name (FQDN) of a DigitalOcean Space. Optionally, the
     * TTL may be configured by setting the &#x60;ttl&#x60; attribute. A custom
     * subdomain may be configured by specifying the &#x60;custom_domain&#x60; and
     * &#x60;certificate_id&#x60; attributes.
     *
     * @param cdnEndpoint (required)
     * @return ApiResponse&lt;CreateCdnEndpointResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateCdnEndpointResponse> createCdnEndpointWithHttpInfo(CdnEndpoint cdnEndpoint) {
        HttpRequest.Builder localVarRequestBuilder = createCdnEndpointRequestBuilder(cdnEndpoint);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createCdnEndpoint", localVarResponse);
                }
                return new ApiResponse<CreateCdnEndpointResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateCdnEndpointResponse>() {
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

    private HttpRequest.Builder createCdnEndpointRequestBuilder(CdnEndpoint cdnEndpoint) {
        // verify the required parameter 'cdnEndpoint' is set
        if (cdnEndpoint == null) {
            throw new ApiException(400, "Missing the required parameter 'cdnEndpoint' when calling createCdnEndpoint");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/cdn/endpoints";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(cdnEndpoint);
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
     * Delete a CDN Endpoint To delete a specific CDN endpoint, send a DELETE
     * request to &#x60;/v2/cdn/endpoints/$ENDPOINT_ID&#x60;. A status of 204 will
     * be given. This indicates that the request was processed successfully, but
     * that no response body is needed.
     *
     * @param cdnId A unique identifier for a CDN endpoint. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteCdnEndpoint(UUID cdnId) {
        deleteCdnEndpointWithHttpInfo(cdnId);
    }

    /**
     * Delete a CDN Endpoint To delete a specific CDN endpoint, send a DELETE
     * request to &#x60;/v2/cdn/endpoints/$ENDPOINT_ID&#x60;. A status of 204 will
     * be given. This indicates that the request was processed successfully, but
     * that no response body is needed.
     *
     * @param cdnId A unique identifier for a CDN endpoint. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteCdnEndpointWithHttpInfo(UUID cdnId) {
        HttpRequest.Builder localVarRequestBuilder = deleteCdnEndpointRequestBuilder(cdnId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteCdnEndpoint", localVarResponse);
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

    private HttpRequest.Builder deleteCdnEndpointRequestBuilder(UUID cdnId) {
        // verify the required parameter 'cdnId' is set
        if (cdnId == null) {
            throw new ApiException(400, "Missing the required parameter 'cdnId' when calling deleteCdnEndpoint");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/cdn/endpoints/{cdn_id}".replace("{cdn_id}", ApiClient.urlEncode(cdnId.toString()));

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
     * Retrieve an Existing CDN Endpoint To show information about an existing CDN
     * endpoint, send a GET request to &#x60;/v2/cdn/endpoints/$ENDPOINT_ID&#x60;.
     *
     * @param cdnId A unique identifier for a CDN endpoint. (required)
     * @return CreateCdnEndpointResponse
     * @throws ApiException if fails to make API call
     */
    public CreateCdnEndpointResponse getCdnEndpoint(UUID cdnId) {
        ApiResponse<CreateCdnEndpointResponse> localVarResponse = getCdnEndpointWithHttpInfo(cdnId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing CDN Endpoint To show information about an existing CDN
     * endpoint, send a GET request to &#x60;/v2/cdn/endpoints/$ENDPOINT_ID&#x60;.
     *
     * @param cdnId A unique identifier for a CDN endpoint. (required)
     * @return ApiResponse&lt;CreateCdnEndpointResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateCdnEndpointResponse> getCdnEndpointWithHttpInfo(UUID cdnId) {
        HttpRequest.Builder localVarRequestBuilder = getCdnEndpointRequestBuilder(cdnId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getCdnEndpoint", localVarResponse);
                }
                return new ApiResponse<CreateCdnEndpointResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateCdnEndpointResponse>() {
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

    private HttpRequest.Builder getCdnEndpointRequestBuilder(UUID cdnId) {
        // verify the required parameter 'cdnId' is set
        if (cdnId == null) {
            throw new ApiException(400, "Missing the required parameter 'cdnId' when calling getCdnEndpoint");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/cdn/endpoints/{cdn_id}".replace("{cdn_id}", ApiClient.urlEncode(cdnId.toString()));

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
     * List All CDN Endpoints To list all of the CDN endpoints available on your
     * account, send a GET request to &#x60;/v2/cdn/endpoints&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ListCdnEndpointsResponse
     * @throws ApiException if fails to make API call
     */
    public ListCdnEndpointsResponse listCdnEndpoints(Integer perPage, Integer page) {
        ApiResponse<ListCdnEndpointsResponse> localVarResponse = listCdnEndpointsWithHttpInfo(perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All CDN Endpoints To list all of the CDN endpoints available on your
     * account, send a GET request to &#x60;/v2/cdn/endpoints&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ApiResponse&lt;ListCdnEndpointsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListCdnEndpointsResponse> listCdnEndpointsWithHttpInfo(Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listCdnEndpointsRequestBuilder(perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listCdnEndpoints", localVarResponse);
                }
                return new ApiResponse<ListCdnEndpointsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListCdnEndpointsResponse>() {
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

    private HttpRequest.Builder listCdnEndpointsRequestBuilder(Integer perPage, Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/cdn/endpoints";

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
     * Purge the Cache for an Existing CDN Endpoint To purge cached content from a
     * CDN endpoint, send a DELETE request to
     * &#x60;/v2/cdn/endpoints/$ENDPOINT_ID/cache&#x60;. The body of the request
     * should include a &#x60;files&#x60; attribute containing a list of cached file
     * paths to be purged. A path may be for a single file or may contain a wildcard
     * (&#x60;*&#x60;) to recursively purge all files under a directory. When only a
     * wildcard is provided, all cached files will be purged.
     *
     * @param cdnId      A unique identifier for a CDN endpoint. (required)
     * @param purgeCache (required)
     * @throws ApiException if fails to make API call
     */
    public void purgeCdnCache(UUID cdnId, PurgeCache purgeCache) {
        purgeCdnCacheWithHttpInfo(cdnId, purgeCache);
    }

    /**
     * Purge the Cache for an Existing CDN Endpoint To purge cached content from a
     * CDN endpoint, send a DELETE request to
     * &#x60;/v2/cdn/endpoints/$ENDPOINT_ID/cache&#x60;. The body of the request
     * should include a &#x60;files&#x60; attribute containing a list of cached file
     * paths to be purged. A path may be for a single file or may contain a wildcard
     * (&#x60;*&#x60;) to recursively purge all files under a directory. When only a
     * wildcard is provided, all cached files will be purged.
     *
     * @param cdnId      A unique identifier for a CDN endpoint. (required)
     * @param purgeCache (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> purgeCdnCacheWithHttpInfo(UUID cdnId, PurgeCache purgeCache) {
        HttpRequest.Builder localVarRequestBuilder = purgeCdnCacheRequestBuilder(cdnId, purgeCache);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("purgeCdnCache", localVarResponse);
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

    private HttpRequest.Builder purgeCdnCacheRequestBuilder(UUID cdnId, PurgeCache purgeCache) {
        // verify the required parameter 'cdnId' is set
        if (cdnId == null) {
            throw new ApiException(400, "Missing the required parameter 'cdnId' when calling purgeCdnCache");
        }
        // verify the required parameter 'purgeCache' is set
        if (purgeCache == null) {
            throw new ApiException(400, "Missing the required parameter 'purgeCache' when calling purgeCdnCache");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/cdn/endpoints/{cdn_id}/cache".replace("{cdn_id}",
                ApiClient.urlEncode(cdnId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(purgeCache);
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
     * Update a CDN Endpoint To update the TTL, certificate ID, or the FQDN of the
     * custom subdomain for an existing CDN endpoint, send a PUT request to
     * &#x60;/v2/cdn/endpoints/$ENDPOINT_ID&#x60;.
     *
     * @param cdnId          A unique identifier for a CDN endpoint. (required)
     * @param updateEndpoint (required)
     * @return CreateCdnEndpointResponse
     * @throws ApiException if fails to make API call
     */
    public CreateCdnEndpointResponse updateCdnEndpoint(UUID cdnId, UpdateEndpoint updateEndpoint) {
        ApiResponse<CreateCdnEndpointResponse> localVarResponse = updateCdnEndpointWithHttpInfo(cdnId, updateEndpoint);
        return localVarResponse.getData();
    }

    /**
     * Update a CDN Endpoint To update the TTL, certificate ID, or the FQDN of the
     * custom subdomain for an existing CDN endpoint, send a PUT request to
     * &#x60;/v2/cdn/endpoints/$ENDPOINT_ID&#x60;.
     *
     * @param cdnId          A unique identifier for a CDN endpoint. (required)
     * @param updateEndpoint (required)
     * @return ApiResponse&lt;CreateCdnEndpointResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateCdnEndpointResponse> updateCdnEndpointWithHttpInfo(UUID cdnId,
            UpdateEndpoint updateEndpoint) {
        HttpRequest.Builder localVarRequestBuilder = updateCdnEndpointRequestBuilder(cdnId, updateEndpoint);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateCdnEndpoint", localVarResponse);
                }
                return new ApiResponse<CreateCdnEndpointResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateCdnEndpointResponse>() {
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

    private HttpRequest.Builder updateCdnEndpointRequestBuilder(UUID cdnId, UpdateEndpoint updateEndpoint) {
        // verify the required parameter 'cdnId' is set
        if (cdnId == null) {
            throw new ApiException(400, "Missing the required parameter 'cdnId' when calling updateCdnEndpoint");
        }
        // verify the required parameter 'updateEndpoint' is set
        if (updateEndpoint == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'updateEndpoint' when calling updateCdnEndpoint");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/cdn/endpoints/{cdn_id}".replace("{cdn_id}", ApiClient.urlEncode(cdnId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateEndpoint);
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
}
