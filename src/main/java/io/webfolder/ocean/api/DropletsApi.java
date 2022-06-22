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
import io.webfolder.ocean.model.AssociatedResourceStatus;
import io.webfolder.ocean.model.CreateDropletRequest;
import io.webfolder.ocean.model.CreateDropletResponse;
import io.webfolder.ocean.model.GetDropletResponse;
import io.webfolder.ocean.model.ListAllDropletsResponse;
import io.webfolder.ocean.model.ListDropletAssociatedResourcesResponse;
import io.webfolder.ocean.model.ListDropletBackupsResponse;
import io.webfolder.ocean.model.ListDropletFirewallsResponse;
import io.webfolder.ocean.model.ListDropletKernelsResponse;
import io.webfolder.ocean.model.ListDropletNeighborsResponse;
import io.webfolder.ocean.model.ListDropletSnapshotsResponse;
import io.webfolder.ocean.model.NeighborIds;
import io.webfolder.ocean.model.SelectiveDestroyAssociatedResource;

public class DropletsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public DropletsApi() {
        this(new ApiClient());
    }

    public DropletsApi(ApiClient apiClient) {
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
     * Create a New Droplet To create a new Droplet, send a POST request to
     * &#x60;/v2/droplets&#x60; setting the required attributes. A Droplet will be
     * created using the provided information. The response body will contain a JSON
     * object with a key called &#x60;droplet&#x60;. The value will be an object
     * containing the standard attributes for your new Droplet. The response code,
     * 202 Accepted, does not indicate the success or failure of the operation, just
     * that the request has been accepted for processing. The &#x60;actions&#x60;
     * returned as part of the response&#39;s &#x60;links&#x60; object can be used
     * to check the status of the Droplet create event. ### Create Multiple Droplets
     * Creating multiple Droplets is very similar to creating a single Droplet.
     * Instead of sending &#x60;name&#x60; as a string, send &#x60;names&#x60; as an
     * array of strings. A Droplet will be created for each name you send using the
     * associated information. Up to ten Droplets may be created this way at a time.
     * Rather than returning a single Droplet, the response body will contain a JSON
     * array with a key called &#x60;droplets&#x60;. This will be set to an array of
     * JSON objects, each of which will contain the standard Droplet attributes. The
     * response code, 202 Accepted, does not indicate the success or failure of any
     * operation, just that the request has been accepted for processing. The array
     * of &#x60;actions&#x60; returned as part of the response&#39;s
     * &#x60;links&#x60; object can be used to check the status of each individual
     * Droplet create event.
     *
     * @param createDropletRequest (optional)
     * @return CreateDropletResponse
     * @throws ApiException if fails to make API call
     */
    public CreateDropletResponse createDroplet(CreateDropletRequest createDropletRequest) {
        ApiResponse<CreateDropletResponse> localVarResponse = createDropletWithHttpInfo(createDropletRequest);
        return localVarResponse.getData();
    }

    /**
     * Create a New Droplet To create a new Droplet, send a POST request to
     * &#x60;/v2/droplets&#x60; setting the required attributes. A Droplet will be
     * created using the provided information. The response body will contain a JSON
     * object with a key called &#x60;droplet&#x60;. The value will be an object
     * containing the standard attributes for your new Droplet. The response code,
     * 202 Accepted, does not indicate the success or failure of the operation, just
     * that the request has been accepted for processing. The &#x60;actions&#x60;
     * returned as part of the response&#39;s &#x60;links&#x60; object can be used
     * to check the status of the Droplet create event. ### Create Multiple Droplets
     * Creating multiple Droplets is very similar to creating a single Droplet.
     * Instead of sending &#x60;name&#x60; as a string, send &#x60;names&#x60; as an
     * array of strings. A Droplet will be created for each name you send using the
     * associated information. Up to ten Droplets may be created this way at a time.
     * Rather than returning a single Droplet, the response body will contain a JSON
     * array with a key called &#x60;droplets&#x60;. This will be set to an array of
     * JSON objects, each of which will contain the standard Droplet attributes. The
     * response code, 202 Accepted, does not indicate the success or failure of any
     * operation, just that the request has been accepted for processing. The array
     * of &#x60;actions&#x60; returned as part of the response&#39;s
     * &#x60;links&#x60; object can be used to check the status of each individual
     * Droplet create event.
     *
     * @param createDropletRequest (optional)
     * @return ApiResponse&lt;CreateDropletResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateDropletResponse> createDropletWithHttpInfo(CreateDropletRequest createDropletRequest) {
        HttpRequest.Builder localVarRequestBuilder = createDropletRequestBuilder(createDropletRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createDroplet", localVarResponse);
                }
                return new ApiResponse<CreateDropletResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateDropletResponse>() {
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

    private HttpRequest.Builder createDropletRequestBuilder(CreateDropletRequest createDropletRequest) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createDropletRequest);
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
     * Delete an Existing Droplet To delete a Droplet, send a DELETE request to
     * &#x60;/v2/droplets/$DROPLET_ID&#x60;. A successful request will receive a 204
     * status code with no body in response. This indicates that the request was
     * processed successfully.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @throws ApiException if fails to make API call
     */
    public void destroyDroplet(Integer dropletId) {
        destroyDropletWithHttpInfo(dropletId);
    }

    /**
     * Delete an Existing Droplet To delete a Droplet, send a DELETE request to
     * &#x60;/v2/droplets/$DROPLET_ID&#x60;. A successful request will receive a 204
     * status code with no body in response. This indicates that the request was
     * processed successfully.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> destroyDropletWithHttpInfo(Integer dropletId) {
        HttpRequest.Builder localVarRequestBuilder = destroyDropletRequestBuilder(dropletId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("destroyDroplet", localVarResponse);
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

    private HttpRequest.Builder destroyDropletRequestBuilder(Integer dropletId) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400, "Missing the required parameter 'dropletId' when calling destroyDroplet");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}".replace("{droplet_id}",
                ApiClient.urlEncode(dropletId.toString()));

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
     * Deleting Droplets by Tag To delete **all** Droplets assigned to a specific
     * tag, include the &#x60;tag_name&#x60; query parameter set to the name of the
     * tag in your DELETE request. For example,
     * &#x60;/v2/droplets?tag_name&#x3D;$TAG_NAME&#x60;. A successful request will
     * receive a 204 status code with no body in response. This indicates that the
     * request was processed successfully.
     *
     * @param tagName Specifies Droplets to be deleted by tag. (required)
     * @throws ApiException if fails to make API call
     */
    public void destroyDropletsByTag(String tagName) {
        destroyDropletsByTagWithHttpInfo(tagName);
    }

    /**
     * Deleting Droplets by Tag To delete **all** Droplets assigned to a specific
     * tag, include the &#x60;tag_name&#x60; query parameter set to the name of the
     * tag in your DELETE request. For example,
     * &#x60;/v2/droplets?tag_name&#x3D;$TAG_NAME&#x60;. A successful request will
     * receive a 204 status code with no body in response. This indicates that the
     * request was processed successfully.
     *
     * @param tagName Specifies Droplets to be deleted by tag. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> destroyDropletsByTagWithHttpInfo(String tagName) {
        HttpRequest.Builder localVarRequestBuilder = destroyDropletsByTagRequestBuilder(tagName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("destroyDropletsByTag", localVarResponse);
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

    private HttpRequest.Builder destroyDropletsByTagRequestBuilder(String tagName) {
        // verify the required parameter 'tagName' is set
        if (tagName == null) {
            throw new ApiException(400, "Missing the required parameter 'tagName' when calling destroyDropletsByTag");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("tag_name", tagName));

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
     * Destroy a Droplet and All of its Associated Resources (Dangerous) To destroy
     * a Droplet along with all of its associated resources, send a DELETE request
     * to the
     * &#x60;/v2/droplets/$DROPLET_ID/destroy_with_associated_resources/dangerous&#x60;
     * endpoint. The headers of this request must include an &#x60;X-Dangerous&#x60;
     * key set to &#x60;true&#x60;. To preview which resources will be destroyed,
     * first query the Droplet&#39;s associated resources. This operation _can not_
     * be reverse and should be used with caution. A successful response will
     * include a 202 response code and no content. Use the status endpoint to check
     * on the success or failure of the destruction of the individual resources.
     *
     * @param dropletId  A unique identifier for a Droplet instance. (required)
     * @param xDangerous Acknowledge this action will destroy the Droplet and all
     *                   associated resources and _can not_ be reversed. (required)
     * @throws ApiException if fails to make API call
     */
    public void destroyWithAssociatedResourcesDangerous(Integer dropletId, Boolean xDangerous) {
        destroyWithAssociatedResourcesDangerousWithHttpInfo(dropletId, xDangerous);
    }

    /**
     * Destroy a Droplet and All of its Associated Resources (Dangerous) To destroy
     * a Droplet along with all of its associated resources, send a DELETE request
     * to the
     * &#x60;/v2/droplets/$DROPLET_ID/destroy_with_associated_resources/dangerous&#x60;
     * endpoint. The headers of this request must include an &#x60;X-Dangerous&#x60;
     * key set to &#x60;true&#x60;. To preview which resources will be destroyed,
     * first query the Droplet&#39;s associated resources. This operation _can not_
     * be reverse and should be used with caution. A successful response will
     * include a 202 response code and no content. Use the status endpoint to check
     * on the success or failure of the destruction of the individual resources.
     *
     * @param dropletId  A unique identifier for a Droplet instance. (required)
     * @param xDangerous Acknowledge this action will destroy the Droplet and all
     *                   associated resources and _can not_ be reversed. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> destroyWithAssociatedResourcesDangerousWithHttpInfo(Integer dropletId,
            Boolean xDangerous) {
        HttpRequest.Builder localVarRequestBuilder = destroyWithAssociatedResourcesDangerousRequestBuilder(dropletId,
                xDangerous);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("destroyWithAssociatedResourcesDangerous", localVarResponse);
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

    private HttpRequest.Builder destroyWithAssociatedResourcesDangerousRequestBuilder(Integer dropletId,
            Boolean xDangerous) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'dropletId' when calling destroyWithAssociatedResourcesDangerous");
        }
        // verify the required parameter 'xDangerous' is set
        if (xDangerous == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'xDangerous' when calling destroyWithAssociatedResourcesDangerous");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/destroy_with_associated_resources/dangerous"
                .replace("{droplet_id}", ApiClient.urlEncode(dropletId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        if (xDangerous != null) {
            localVarRequestBuilder.header("X-Dangerous", xDangerous.toString());
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
     * Selectively Destroy a Droplet and its Associated Resources To destroy a
     * Droplet along with a sub-set of its associated resources, send a DELETE
     * request to the
     * &#x60;/v2/droplets/$DROPLET_ID/destroy_with_associated_resources/selective&#x60;
     * endpoint. The JSON body of the request should include
     * &#x60;reserved_ips&#x60;, &#x60;snapshots&#x60;, &#x60;volumes&#x60;, or
     * &#x60;volume_snapshots&#x60; keys each set to an array of IDs for the
     * associated resources to be destroyed. The IDs can be found by querying the
     * Droplet&#39;s associated resources. Any associated resource not included in
     * the request will remain and continue to accrue changes on your account. A
     * successful response will include a 202 response code and no content. Use the
     * status endpoint to check on the success or failure of the destruction of the
     * individual resources.
     *
     * @param dropletId                          A unique identifier for a Droplet
     *                                           instance. (required)
     * @param selectiveDestroyAssociatedResource (optional)
     * @throws ApiException if fails to make API call
     */
    public void destroyWithAssociatedResourcesSelective(Integer dropletId,
            SelectiveDestroyAssociatedResource selectiveDestroyAssociatedResource) {
        destroyWithAssociatedResourcesSelectiveWithHttpInfo(dropletId, selectiveDestroyAssociatedResource);
    }

    /**
     * Selectively Destroy a Droplet and its Associated Resources To destroy a
     * Droplet along with a sub-set of its associated resources, send a DELETE
     * request to the
     * &#x60;/v2/droplets/$DROPLET_ID/destroy_with_associated_resources/selective&#x60;
     * endpoint. The JSON body of the request should include
     * &#x60;reserved_ips&#x60;, &#x60;snapshots&#x60;, &#x60;volumes&#x60;, or
     * &#x60;volume_snapshots&#x60; keys each set to an array of IDs for the
     * associated resources to be destroyed. The IDs can be found by querying the
     * Droplet&#39;s associated resources. Any associated resource not included in
     * the request will remain and continue to accrue changes on your account. A
     * successful response will include a 202 response code and no content. Use the
     * status endpoint to check on the success or failure of the destruction of the
     * individual resources.
     *
     * @param dropletId                          A unique identifier for a Droplet
     *                                           instance. (required)
     * @param selectiveDestroyAssociatedResource (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> destroyWithAssociatedResourcesSelectiveWithHttpInfo(Integer dropletId,
            SelectiveDestroyAssociatedResource selectiveDestroyAssociatedResource) {
        HttpRequest.Builder localVarRequestBuilder = destroyWithAssociatedResourcesSelectiveRequestBuilder(dropletId,
                selectiveDestroyAssociatedResource);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("destroyWithAssociatedResourcesSelective", localVarResponse);
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

    private HttpRequest.Builder destroyWithAssociatedResourcesSelectiveRequestBuilder(Integer dropletId,
            SelectiveDestroyAssociatedResource selectiveDestroyAssociatedResource) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'dropletId' when calling destroyWithAssociatedResourcesSelective");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/destroy_with_associated_resources/selective"
                .replace("{droplet_id}", ApiClient.urlEncode(dropletId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(selectiveDestroyAssociatedResource);
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
     * Check Status of a Droplet Destroy with Associated Resources Request To check
     * on the status of a request to destroy a Droplet with its associated
     * resources, send a GET request to the
     * &#x60;/v2/droplets/$DROPLET_ID/destroy_with_associated_resources/status&#x60;
     * endpoint.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @return AssociatedResourceStatus
     * @throws ApiException if fails to make API call
     */
    public AssociatedResourceStatus getDestroyWithAssociatedResourcesStatus(Integer dropletId) {
        ApiResponse<AssociatedResourceStatus> localVarResponse = getDestroyWithAssociatedResourcesStatusWithHttpInfo(
                dropletId);
        return localVarResponse.getData();
    }

    /**
     * Check Status of a Droplet Destroy with Associated Resources Request To check
     * on the status of a request to destroy a Droplet with its associated
     * resources, send a GET request to the
     * &#x60;/v2/droplets/$DROPLET_ID/destroy_with_associated_resources/status&#x60;
     * endpoint.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @return ApiResponse&lt;AssociatedResourceStatus&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AssociatedResourceStatus> getDestroyWithAssociatedResourcesStatusWithHttpInfo(
            Integer dropletId) {
        HttpRequest.Builder localVarRequestBuilder = getDestroyWithAssociatedResourcesStatusRequestBuilder(dropletId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDestroyWithAssociatedResourcesStatus", localVarResponse);
                }
                return new ApiResponse<AssociatedResourceStatus>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AssociatedResourceStatus>() {
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

    private HttpRequest.Builder getDestroyWithAssociatedResourcesStatusRequestBuilder(Integer dropletId) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'dropletId' when calling getDestroyWithAssociatedResourcesStatus");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/destroy_with_associated_resources/status"
                .replace("{droplet_id}", ApiClient.urlEncode(dropletId.toString()));

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
     * Retrieve an Existing Droplet To show information about an individual Droplet,
     * send a GET request to &#x60;/v2/droplets/$DROPLET_ID&#x60;.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @return GetDropletResponse
     * @throws ApiException if fails to make API call
     */
    public GetDropletResponse getDroplet(Integer dropletId) {
        ApiResponse<GetDropletResponse> localVarResponse = getDropletWithHttpInfo(dropletId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Droplet To show information about an individual Droplet,
     * send a GET request to &#x60;/v2/droplets/$DROPLET_ID&#x60;.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @return ApiResponse&lt;GetDropletResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetDropletResponse> getDropletWithHttpInfo(Integer dropletId) {
        HttpRequest.Builder localVarRequestBuilder = getDropletRequestBuilder(dropletId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDroplet", localVarResponse);
                }
                return new ApiResponse<GetDropletResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetDropletResponse>() {
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

    private HttpRequest.Builder getDropletRequestBuilder(Integer dropletId) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400, "Missing the required parameter 'dropletId' when calling getDroplet");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}".replace("{droplet_id}",
                ApiClient.urlEncode(dropletId.toString()));

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
     * List All Droplet Neighbors To retrieve a list of all Droplets that are
     * co-located on the same physical hardware, send a GET request to
     * &#x60;/v2/reports/droplet_neighbors_ids&#x60;. The results will be returned
     * as a JSON object with a key of &#x60;neighbor_ids&#x60;. This will be set to
     * an array of arrays. Each array will contain a set of Droplet IDs for Droplets
     * that share a physical server. An empty array indicates that all Droplets
     * associated with your account are located on separate physical hardware.
     *
     * @return NeighborIds
     * @throws ApiException if fails to make API call
     */
    public NeighborIds listAllDropletNeighborsIds() {
        ApiResponse<NeighborIds> localVarResponse = listAllDropletNeighborsIdsWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List All Droplet Neighbors To retrieve a list of all Droplets that are
     * co-located on the same physical hardware, send a GET request to
     * &#x60;/v2/reports/droplet_neighbors_ids&#x60;. The results will be returned
     * as a JSON object with a key of &#x60;neighbor_ids&#x60;. This will be set to
     * an array of arrays. Each array will contain a set of Droplet IDs for Droplets
     * that share a physical server. An empty array indicates that all Droplets
     * associated with your account are located on separate physical hardware.
     *
     * @return ApiResponse&lt;NeighborIds&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<NeighborIds> listAllDropletNeighborsIdsWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listAllDropletNeighborsIdsRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllDropletNeighborsIds", localVarResponse);
                }
                return new ApiResponse<NeighborIds>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<NeighborIds>() {
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

    private HttpRequest.Builder listAllDropletNeighborsIdsRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/reports/droplet_neighbors_ids";

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
     * List All Droplets To list all Droplets in your account, send a GET request to
     * &#x60;/v2/droplets&#x60;. The response body will be a JSON object with a key
     * of &#x60;droplets&#x60;. This will be set to an array containing objects each
     * representing a Droplet. These will contain the standard Droplet attributes.
     * ### Filtering Results by Tag It&#39;s possible to request filtered results by
     * including certain query parameters. To only list Droplets assigned to a
     * specific tag, include the &#x60;tag_name&#x60; query parameter set to the
     * name of the tag in your GET request. For example,
     * &#x60;/v2/droplets?tag_name&#x3D;$TAG_NAME&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @param tagName Used to filter Droplets by a specific tag. (optional)
     * @return ListAllDropletsResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllDropletsResponse listAllDroplets(Integer perPage, Integer page, String tagName) {
        ApiResponse<ListAllDropletsResponse> localVarResponse = listAllDropletsWithHttpInfo(perPage, page, tagName);
        return localVarResponse.getData();
    }

    /**
     * List All Droplets To list all Droplets in your account, send a GET request to
     * &#x60;/v2/droplets&#x60;. The response body will be a JSON object with a key
     * of &#x60;droplets&#x60;. This will be set to an array containing objects each
     * representing a Droplet. These will contain the standard Droplet attributes.
     * ### Filtering Results by Tag It&#39;s possible to request filtered results by
     * including certain query parameters. To only list Droplets assigned to a
     * specific tag, include the &#x60;tag_name&#x60; query parameter set to the
     * name of the tag in your GET request. For example,
     * &#x60;/v2/droplets?tag_name&#x3D;$TAG_NAME&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @param tagName Used to filter Droplets by a specific tag. (optional)
     * @return ApiResponse&lt;ListAllDropletsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllDropletsResponse> listAllDropletsWithHttpInfo(Integer perPage, Integer page,
            String tagName) {
        HttpRequest.Builder localVarRequestBuilder = listAllDropletsRequestBuilder(perPage, page, tagName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllDroplets", localVarResponse);
                }
                return new ApiResponse<ListAllDropletsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllDropletsResponse>() {
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

    private HttpRequest.Builder listAllDropletsRequestBuilder(Integer perPage, Integer page, String tagName) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("per_page", perPage));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("page", page));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("tag_name", tagName));

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
     * List Associated Resources for a Droplet To list the associated billable
     * resources that can be destroyed along with a Droplet, send a GET request to
     * the &#x60;/v2/droplets/$DROPLET_ID/destroy_with_associated_resources&#x60;
     * endpoint. The response will be a JSON object containing
     * &#x60;snapshots&#x60;, &#x60;volumes&#x60;, and &#x60;volume_snapshots&#x60;
     * keys. Each will be set to an array of objects containing information about
     * the associated resources.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @return ListDropletAssociatedResourcesResponse
     * @throws ApiException if fails to make API call
     */
    public ListDropletAssociatedResourcesResponse listDropletAssociatedResources(Integer dropletId) {
        ApiResponse<ListDropletAssociatedResourcesResponse> localVarResponse = listDropletAssociatedResourcesWithHttpInfo(
                dropletId);
        return localVarResponse.getData();
    }

    /**
     * List Associated Resources for a Droplet To list the associated billable
     * resources that can be destroyed along with a Droplet, send a GET request to
     * the &#x60;/v2/droplets/$DROPLET_ID/destroy_with_associated_resources&#x60;
     * endpoint. The response will be a JSON object containing
     * &#x60;snapshots&#x60;, &#x60;volumes&#x60;, and &#x60;volume_snapshots&#x60;
     * keys. Each will be set to an array of objects containing information about
     * the associated resources.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @return ApiResponse&lt;ListDropletAssociatedResourcesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDropletAssociatedResourcesResponse> listDropletAssociatedResourcesWithHttpInfo(
            Integer dropletId) {
        HttpRequest.Builder localVarRequestBuilder = listDropletAssociatedResourcesRequestBuilder(dropletId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDropletAssociatedResources", localVarResponse);
                }
                return new ApiResponse<ListDropletAssociatedResourcesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDropletAssociatedResourcesResponse>() {
                                }) // closes the
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

    private HttpRequest.Builder listDropletAssociatedResourcesRequestBuilder(Integer dropletId) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'dropletId' when calling listDropletAssociatedResources");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/destroy_with_associated_resources".replace("{droplet_id}",
                ApiClient.urlEncode(dropletId.toString()));

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
     * List Backups for a Droplet To retrieve any backups associated with a Droplet,
     * send a GET request to &#x60;/v2/droplets/$DROPLET_ID/backups&#x60;. You will
     * get back a JSON object that has a &#x60;backups&#x60; key. This will be set
     * to an array of backup objects, each of which contain the standard Droplet
     * backup attributes.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param perPage   Number of items returned per page (optional, default to 20)
     * @param page      Which &#39;page&#39; of paginated results to return.
     *                  (optional, default to 1)
     * @return ListDropletBackupsResponse
     * @throws ApiException if fails to make API call
     */
    public ListDropletBackupsResponse listDropletBackups(Integer dropletId, Integer perPage, Integer page) {
        ApiResponse<ListDropletBackupsResponse> localVarResponse = listDropletBackupsWithHttpInfo(dropletId, perPage,
                page);
        return localVarResponse.getData();
    }

    /**
     * List Backups for a Droplet To retrieve any backups associated with a Droplet,
     * send a GET request to &#x60;/v2/droplets/$DROPLET_ID/backups&#x60;. You will
     * get back a JSON object that has a &#x60;backups&#x60; key. This will be set
     * to an array of backup objects, each of which contain the standard Droplet
     * backup attributes.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param perPage   Number of items returned per page (optional, default to 20)
     * @param page      Which &#39;page&#39; of paginated results to return.
     *                  (optional, default to 1)
     * @return ApiResponse&lt;ListDropletBackupsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDropletBackupsResponse> listDropletBackupsWithHttpInfo(Integer dropletId, Integer perPage,
            Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listDropletBackupsRequestBuilder(dropletId, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDropletBackups", localVarResponse);
                }
                return new ApiResponse<ListDropletBackupsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDropletBackupsResponse>() {
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

    private HttpRequest.Builder listDropletBackupsRequestBuilder(Integer dropletId, Integer perPage, Integer page) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400, "Missing the required parameter 'dropletId' when calling listDropletBackups");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/backups".replace("{droplet_id}",
                ApiClient.urlEncode(dropletId.toString()));

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
     * List all Firewalls Applied to a Droplet To retrieve a list of all firewalls
     * available to a Droplet, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/firewalls&#x60; The response will be a JSON
     * object that has a key called &#x60;firewalls&#x60;. This will be set to an
     * array of &#x60;firewall&#x60; objects, each of which contain the standard
     * &#x60;firewall&#x60; attributes.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param perPage   Number of items returned per page (optional, default to 20)
     * @param page      Which &#39;page&#39; of paginated results to return.
     *                  (optional, default to 1)
     * @return ListDropletFirewallsResponse
     * @throws ApiException if fails to make API call
     */
    public ListDropletFirewallsResponse listDropletFirewalls(Integer dropletId, Integer perPage, Integer page) {
        ApiResponse<ListDropletFirewallsResponse> localVarResponse = listDropletFirewallsWithHttpInfo(dropletId,
                perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List all Firewalls Applied to a Droplet To retrieve a list of all firewalls
     * available to a Droplet, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/firewalls&#x60; The response will be a JSON
     * object that has a key called &#x60;firewalls&#x60;. This will be set to an
     * array of &#x60;firewall&#x60; objects, each of which contain the standard
     * &#x60;firewall&#x60; attributes.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param perPage   Number of items returned per page (optional, default to 20)
     * @param page      Which &#39;page&#39; of paginated results to return.
     *                  (optional, default to 1)
     * @return ApiResponse&lt;ListDropletFirewallsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDropletFirewallsResponse> listDropletFirewallsWithHttpInfo(Integer dropletId,
            Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listDropletFirewallsRequestBuilder(dropletId, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDropletFirewalls", localVarResponse);
                }
                return new ApiResponse<ListDropletFirewallsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDropletFirewallsResponse>() {
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

    private HttpRequest.Builder listDropletFirewallsRequestBuilder(Integer dropletId, Integer perPage, Integer page) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400, "Missing the required parameter 'dropletId' when calling listDropletFirewalls");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/firewalls".replace("{droplet_id}",
                ApiClient.urlEncode(dropletId.toString()));

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
     * List All Available Kernels for a Droplet To retrieve a list of all kernels
     * available to a Droplet, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/kernels&#x60; The response will be a JSON
     * object that has a key called &#x60;kernels&#x60;. This will be set to an
     * array of &#x60;kernel&#x60; objects, each of which contain the standard
     * &#x60;kernel&#x60; attributes.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param perPage   Number of items returned per page (optional, default to 20)
     * @param page      Which &#39;page&#39; of paginated results to return.
     *                  (optional, default to 1)
     * @return ListDropletKernelsResponse
     * @throws ApiException if fails to make API call
     */
    public ListDropletKernelsResponse listDropletKernels(Integer dropletId, Integer perPage, Integer page) {
        ApiResponse<ListDropletKernelsResponse> localVarResponse = listDropletKernelsWithHttpInfo(dropletId, perPage,
                page);
        return localVarResponse.getData();
    }

    /**
     * List All Available Kernels for a Droplet To retrieve a list of all kernels
     * available to a Droplet, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/kernels&#x60; The response will be a JSON
     * object that has a key called &#x60;kernels&#x60;. This will be set to an
     * array of &#x60;kernel&#x60; objects, each of which contain the standard
     * &#x60;kernel&#x60; attributes.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param perPage   Number of items returned per page (optional, default to 20)
     * @param page      Which &#39;page&#39; of paginated results to return.
     *                  (optional, default to 1)
     * @return ApiResponse&lt;ListDropletKernelsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDropletKernelsResponse> listDropletKernelsWithHttpInfo(Integer dropletId, Integer perPage,
            Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listDropletKernelsRequestBuilder(dropletId, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDropletKernels", localVarResponse);
                }
                return new ApiResponse<ListDropletKernelsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDropletKernelsResponse>() {
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

    private HttpRequest.Builder listDropletKernelsRequestBuilder(Integer dropletId, Integer perPage, Integer page) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400, "Missing the required parameter 'dropletId' when calling listDropletKernels");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/kernels".replace("{droplet_id}",
                ApiClient.urlEncode(dropletId.toString()));

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
     * List Neighbors for a Droplet To retrieve a list of any
     * \&quot;neighbors\&quot; (i.e. Droplets that are co-located on the same
     * physical hardware) for a specific Droplet, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/neighbors&#x60;. The results will be returned
     * as a JSON object with a key of &#x60;droplets&#x60;. This will be set to an
     * array containing objects representing any other Droplets that share the same
     * physical hardware. An empty array indicates that the Droplet is not
     * co-located any other Droplets associated with your account.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @return ListDropletNeighborsResponse
     * @throws ApiException if fails to make API call
     */
    public ListDropletNeighborsResponse listDropletNeighbors(Integer dropletId) {
        ApiResponse<ListDropletNeighborsResponse> localVarResponse = listDropletNeighborsWithHttpInfo(dropletId);
        return localVarResponse.getData();
    }

    /**
     * List Neighbors for a Droplet To retrieve a list of any
     * \&quot;neighbors\&quot; (i.e. Droplets that are co-located on the same
     * physical hardware) for a specific Droplet, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/neighbors&#x60;. The results will be returned
     * as a JSON object with a key of &#x60;droplets&#x60;. This will be set to an
     * array containing objects representing any other Droplets that share the same
     * physical hardware. An empty array indicates that the Droplet is not
     * co-located any other Droplets associated with your account.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @return ApiResponse&lt;ListDropletNeighborsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDropletNeighborsResponse> listDropletNeighborsWithHttpInfo(Integer dropletId) {
        HttpRequest.Builder localVarRequestBuilder = listDropletNeighborsRequestBuilder(dropletId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDropletNeighbors", localVarResponse);
                }
                return new ApiResponse<ListDropletNeighborsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDropletNeighborsResponse>() {
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

    private HttpRequest.Builder listDropletNeighborsRequestBuilder(Integer dropletId) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400, "Missing the required parameter 'dropletId' when calling listDropletNeighbors");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/neighbors".replace("{droplet_id}",
                ApiClient.urlEncode(dropletId.toString()));

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
     * List Snapshots for a Droplet To retrieve the snapshots that have been created
     * from a Droplet, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/snapshots&#x60;. You will get back a JSON
     * object that has a &#x60;snapshots&#x60; key. This will be set to an array of
     * snapshot objects, each of which contain the standard Droplet snapshot
     * attributes.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param perPage   Number of items returned per page (optional, default to 20)
     * @param page      Which &#39;page&#39; of paginated results to return.
     *                  (optional, default to 1)
     * @return ListDropletSnapshotsResponse
     * @throws ApiException if fails to make API call
     */
    public ListDropletSnapshotsResponse listDropletSnapshots(Integer dropletId, Integer perPage, Integer page) {
        ApiResponse<ListDropletSnapshotsResponse> localVarResponse = listDropletSnapshotsWithHttpInfo(dropletId,
                perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List Snapshots for a Droplet To retrieve the snapshots that have been created
     * from a Droplet, send a GET request to
     * &#x60;/v2/droplets/$DROPLET_ID/snapshots&#x60;. You will get back a JSON
     * object that has a &#x60;snapshots&#x60; key. This will be set to an array of
     * snapshot objects, each of which contain the standard Droplet snapshot
     * attributes.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @param perPage   Number of items returned per page (optional, default to 20)
     * @param page      Which &#39;page&#39; of paginated results to return.
     *                  (optional, default to 1)
     * @return ApiResponse&lt;ListDropletSnapshotsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDropletSnapshotsResponse> listDropletSnapshotsWithHttpInfo(Integer dropletId,
            Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listDropletSnapshotsRequestBuilder(dropletId, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDropletSnapshots", localVarResponse);
                }
                return new ApiResponse<ListDropletSnapshotsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDropletSnapshotsResponse>() {
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

    private HttpRequest.Builder listDropletSnapshotsRequestBuilder(Integer dropletId, Integer perPage, Integer page) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400, "Missing the required parameter 'dropletId' when calling listDropletSnapshots");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/snapshots".replace("{droplet_id}",
                ApiClient.urlEncode(dropletId.toString()));

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
     * Retry a Droplet Destroy with Associated Resources Request If the status of a
     * request to destroy a Droplet with its associated resources reported any
     * errors, it can be retried by sending a POST request to the
     * &#x60;/v2/droplets/$DROPLET_ID/destroy_with_associated_resources/retry&#x60;
     * endpoint. Only one destroy can be active at a time per Droplet. If a retry is
     * issued while another destroy is in progress for the Droplet a 409 status code
     * will be returned. A successful response will include a 202 response code and
     * no content.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @throws ApiException if fails to make API call
     */
    public void retryDestroyWithAssociatedResource(Integer dropletId) {
        retryDestroyWithAssociatedResourceWithHttpInfo(dropletId);
    }

    /**
     * Retry a Droplet Destroy with Associated Resources Request If the status of a
     * request to destroy a Droplet with its associated resources reported any
     * errors, it can be retried by sending a POST request to the
     * &#x60;/v2/droplets/$DROPLET_ID/destroy_with_associated_resources/retry&#x60;
     * endpoint. Only one destroy can be active at a time per Droplet. If a retry is
     * issued while another destroy is in progress for the Droplet a 409 status code
     * will be returned. A successful response will include a 202 response code and
     * no content.
     *
     * @param dropletId A unique identifier for a Droplet instance. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> retryDestroyWithAssociatedResourceWithHttpInfo(Integer dropletId) {
        HttpRequest.Builder localVarRequestBuilder = retryDestroyWithAssociatedResourceRequestBuilder(dropletId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("retryDestroyWithAssociatedResource", localVarResponse);
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

    private HttpRequest.Builder retryDestroyWithAssociatedResourceRequestBuilder(Integer dropletId) {
        // verify the required parameter 'dropletId' is set
        if (dropletId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'dropletId' when calling retryDestroyWithAssociatedResource");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/droplets/{droplet_id}/destroy_with_associated_resources/retry"
                .replace("{droplet_id}", ApiClient.urlEncode(dropletId.toString()));

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
}
