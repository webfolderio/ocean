package io.webfolder.ocean.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.webfolder.ocean.client.ApiClient;
import io.webfolder.ocean.client.ApiException;
import io.webfolder.ocean.client.ApiResponse;
import io.webfolder.ocean.model.ListReservedIpActionsResponse;
import io.webfolder.ocean.model.PostReservedIpActionRequest;
import io.webfolder.ocean.model.PostReservedIpActionResponse;

public class ReservedIpActionsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public ReservedIpActionsApi() {
        this(new ApiClient());
    }

    public ReservedIpActionsApi(ApiClient apiClient) {
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
     * Retrieve an Existing Reserved IP Action To retrieve the status of a reserved
     * IP action, send a GET request to
     * &#x60;/v2/reserved_ips/$RESERVED_IP/actions/$ACTION_ID&#x60;.
     *
     * @param reservedIp A reserved IP address. (required)
     * @param actionId   A unique numeric ID that can be used to identify and
     *                   reference an action. (required)
     * @return PostReservedIpActionResponse
     * @throws ApiException if fails to make API call
     */
    public PostReservedIpActionResponse getReservedIpAction(String reservedIp, Integer actionId) {
        ApiResponse<PostReservedIpActionResponse> localVarResponse = getReservedIpActionWithHttpInfo(reservedIp,
                actionId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Reserved IP Action To retrieve the status of a reserved
     * IP action, send a GET request to
     * &#x60;/v2/reserved_ips/$RESERVED_IP/actions/$ACTION_ID&#x60;.
     *
     * @param reservedIp A reserved IP address. (required)
     * @param actionId   A unique numeric ID that can be used to identify and
     *                   reference an action. (required)
     * @return ApiResponse&lt;PostReservedIpActionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<PostReservedIpActionResponse> getReservedIpActionWithHttpInfo(String reservedIp,
            Integer actionId) {
        HttpRequest.Builder localVarRequestBuilder = getReservedIpActionRequestBuilder(reservedIp, actionId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getReservedIpAction", localVarResponse);
                }
                return new ApiResponse<PostReservedIpActionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<PostReservedIpActionResponse>() {
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

    private HttpRequest.Builder getReservedIpActionRequestBuilder(String reservedIp, Integer actionId) {
        // verify the required parameter 'reservedIp' is set
        if (reservedIp == null) {
            throw new ApiException(400, "Missing the required parameter 'reservedIp' when calling getReservedIpAction");
        }
        // verify the required parameter 'actionId' is set
        if (actionId == null) {
            throw new ApiException(400, "Missing the required parameter 'actionId' when calling getReservedIpAction");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/reserved_ips/{reserved_ip}/actions/{action_id}"
                .replace("{reserved_ip}", ApiClient.urlEncode(reservedIp.toString()))
                .replace("{action_id}", ApiClient.urlEncode(actionId.toString()));

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
     * List All Actions for a Reserved IP To retrieve all actions that have been
     * executed on a reserved IP, send a GET request to
     * &#x60;/v2/reserved_ips/$RESERVED_IP/actions&#x60;.
     *
     * @param reservedIp A reserved IP address. (required)
     * @return ListReservedIpActionsResponse
     * @throws ApiException if fails to make API call
     */
    public ListReservedIpActionsResponse listReservedIpActions(String reservedIp) {
        ApiResponse<ListReservedIpActionsResponse> localVarResponse = listReservedIpActionsWithHttpInfo(reservedIp);
        return localVarResponse.getData();
    }

    /**
     * List All Actions for a Reserved IP To retrieve all actions that have been
     * executed on a reserved IP, send a GET request to
     * &#x60;/v2/reserved_ips/$RESERVED_IP/actions&#x60;.
     *
     * @param reservedIp A reserved IP address. (required)
     * @return ApiResponse&lt;ListReservedIpActionsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListReservedIpActionsResponse> listReservedIpActionsWithHttpInfo(String reservedIp) {
        HttpRequest.Builder localVarRequestBuilder = listReservedIpActionsRequestBuilder(reservedIp);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listReservedIpActions", localVarResponse);
                }
                return new ApiResponse<ListReservedIpActionsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListReservedIpActionsResponse>() {
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

    private HttpRequest.Builder listReservedIpActionsRequestBuilder(String reservedIp) {
        // verify the required parameter 'reservedIp' is set
        if (reservedIp == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'reservedIp' when calling listReservedIpActions");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/reserved_ips/{reserved_ip}/actions".replace("{reserved_ip}",
                ApiClient.urlEncode(reservedIp.toString()));

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
     * Initiate a Reserved IP Action To initiate an action on a reserved IP send a
     * POST request to &#x60;/v2/reserved_ips/$RESERVED_IP/actions&#x60;. In the
     * JSON body to the request, set the &#x60;type&#x60; attribute to on of the
     * supported action types: | Action | Details |------------|-------- |
     * &#x60;assign&#x60; | Assigns a reserved IP to a Droplet |
     * &#x60;unassign&#x60; | Unassign a reserved IP from a Droplet
     *
     * @param reservedIp                  A reserved IP address. (required)
     * @param postReservedIpActionRequest The &#x60;type&#x60; attribute set in the
     *                                    request body will specify the action that
     *                                    will be taken on the reserved IP.
     *                                    (optional)
     * @return PostReservedIpActionResponse
     * @throws ApiException if fails to make API call
     */
    public PostReservedIpActionResponse postReservedIpAction(String reservedIp,
            PostReservedIpActionRequest postReservedIpActionRequest) {
        ApiResponse<PostReservedIpActionResponse> localVarResponse = postReservedIpActionWithHttpInfo(reservedIp,
                postReservedIpActionRequest);
        return localVarResponse.getData();
    }

    /**
     * Initiate a Reserved IP Action To initiate an action on a reserved IP send a
     * POST request to &#x60;/v2/reserved_ips/$RESERVED_IP/actions&#x60;. In the
     * JSON body to the request, set the &#x60;type&#x60; attribute to on of the
     * supported action types: | Action | Details |------------|-------- |
     * &#x60;assign&#x60; | Assigns a reserved IP to a Droplet |
     * &#x60;unassign&#x60; | Unassign a reserved IP from a Droplet
     *
     * @param reservedIp                  A reserved IP address. (required)
     * @param postReservedIpActionRequest The &#x60;type&#x60; attribute set in the
     *                                    request body will specify the action that
     *                                    will be taken on the reserved IP.
     *                                    (optional)
     * @return ApiResponse&lt;PostReservedIpActionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<PostReservedIpActionResponse> postReservedIpActionWithHttpInfo(String reservedIp,
            PostReservedIpActionRequest postReservedIpActionRequest) {
        HttpRequest.Builder localVarRequestBuilder = postReservedIpActionRequestBuilder(reservedIp,
                postReservedIpActionRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("postReservedIpAction", localVarResponse);
                }
                return new ApiResponse<PostReservedIpActionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<PostReservedIpActionResponse>() {
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

    private HttpRequest.Builder postReservedIpActionRequestBuilder(String reservedIp,
            PostReservedIpActionRequest postReservedIpActionRequest) {
        // verify the required parameter 'reservedIp' is set
        if (reservedIp == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'reservedIp' when calling postReservedIpAction");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/reserved_ips/{reserved_ip}/actions".replace("{reserved_ip}",
                ApiClient.urlEncode(reservedIp.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(postReservedIpActionRequest);
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
