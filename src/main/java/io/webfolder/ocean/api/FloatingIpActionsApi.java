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
import io.webfolder.ocean.model.ListFloatingIpActionsResponse;
import io.webfolder.ocean.model.PostFloatingIpActionRequest;
import io.webfolder.ocean.model.PostFloatingIpActionResponse;

public class FloatingIpActionsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public FloatingIpActionsApi() {
        this(new ApiClient());
    }

    public FloatingIpActionsApi(ApiClient apiClient) {
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
     * Retrieve an Existing Floating IP Action To retrieve the status of a floating
     * IP action, send a GET request to
     * &#x60;/v2/floating_ips/$FLOATING_IP/actions/$ACTION_ID&#x60;.
     *
     * @param floatingIp A floating IP address. (required)
     * @param actionId   A unique numeric ID that can be used to identify and
     *                   reference an action. (required)
     * @return PostFloatingIpActionResponse
     * @throws ApiException if fails to make API call
     */
    public PostFloatingIpActionResponse getFloatingIpAction(String floatingIp, Integer actionId) {
        ApiResponse<PostFloatingIpActionResponse> localVarResponse = getFloatingIpActionWithHttpInfo(floatingIp,
                actionId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Floating IP Action To retrieve the status of a floating
     * IP action, send a GET request to
     * &#x60;/v2/floating_ips/$FLOATING_IP/actions/$ACTION_ID&#x60;.
     *
     * @param floatingIp A floating IP address. (required)
     * @param actionId   A unique numeric ID that can be used to identify and
     *                   reference an action. (required)
     * @return ApiResponse&lt;PostFloatingIpActionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<PostFloatingIpActionResponse> getFloatingIpActionWithHttpInfo(String floatingIp,
            Integer actionId) {
        HttpRequest.Builder localVarRequestBuilder = getFloatingIpActionRequestBuilder(floatingIp, actionId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getFloatingIpAction", localVarResponse);
                }
                return new ApiResponse<PostFloatingIpActionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<PostFloatingIpActionResponse>() {
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

    private HttpRequest.Builder getFloatingIpActionRequestBuilder(String floatingIp, Integer actionId) {
        // verify the required parameter 'floatingIp' is set
        if (floatingIp == null) {
            throw new ApiException(400, "Missing the required parameter 'floatingIp' when calling getFloatingIpAction");
        }
        // verify the required parameter 'actionId' is set
        if (actionId == null) {
            throw new ApiException(400, "Missing the required parameter 'actionId' when calling getFloatingIpAction");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/floating_ips/{floating_ip}/actions/{action_id}"
                .replace("{floating_ip}", ApiClient.urlEncode(floatingIp.toString()))
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
     * List All Actions for a Floating IP To retrieve all actions that have been
     * executed on a floating IP, send a GET request to
     * &#x60;/v2/floating_ips/$FLOATING_IP/actions&#x60;.
     *
     * @param floatingIp A floating IP address. (required)
     * @return ListFloatingIpActionsResponse
     * @throws ApiException if fails to make API call
     */
    public ListFloatingIpActionsResponse listFloatingIpActions(String floatingIp) {
        ApiResponse<ListFloatingIpActionsResponse> localVarResponse = listFloatingIpActionsWithHttpInfo(floatingIp);
        return localVarResponse.getData();
    }

    /**
     * List All Actions for a Floating IP To retrieve all actions that have been
     * executed on a floating IP, send a GET request to
     * &#x60;/v2/floating_ips/$FLOATING_IP/actions&#x60;.
     *
     * @param floatingIp A floating IP address. (required)
     * @return ApiResponse&lt;ListFloatingIpActionsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListFloatingIpActionsResponse> listFloatingIpActionsWithHttpInfo(String floatingIp) {
        HttpRequest.Builder localVarRequestBuilder = listFloatingIpActionsRequestBuilder(floatingIp);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listFloatingIpActions", localVarResponse);
                }
                return new ApiResponse<ListFloatingIpActionsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListFloatingIpActionsResponse>() {
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

    private HttpRequest.Builder listFloatingIpActionsRequestBuilder(String floatingIp) {
        // verify the required parameter 'floatingIp' is set
        if (floatingIp == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'floatingIp' when calling listFloatingIpActions");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/floating_ips/{floating_ip}/actions".replace("{floating_ip}",
                ApiClient.urlEncode(floatingIp.toString()));

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
     * Initiate a Floating IP Action To initiate an action on a floating IP send a
     * POST request to &#x60;/v2/floating_ips/$FLOATING_IP/actions&#x60;. In the
     * JSON body to the request, set the &#x60;type&#x60; attribute to on of the
     * supported action types: | Action | Details |------------|-------- |
     * &#x60;assign&#x60; | Assigns a floating IP to a Droplet |
     * &#x60;unassign&#x60; | Unassign a floating IP from a Droplet
     *
     * @param floatingIp                  A floating IP address. (required)
     * @param postFloatingIpActionRequest The &#x60;type&#x60; attribute set in the
     *                                    request body will specify the action that
     *                                    will be taken on the floating IP.
     *                                    (optional)
     * @return PostFloatingIpActionResponse
     * @throws ApiException if fails to make API call
     */
    public PostFloatingIpActionResponse postFloatingIpAction(String floatingIp,
            PostFloatingIpActionRequest postFloatingIpActionRequest) {
        ApiResponse<PostFloatingIpActionResponse> localVarResponse = postFloatingIpActionWithHttpInfo(floatingIp,
                postFloatingIpActionRequest);
        return localVarResponse.getData();
    }

    /**
     * Initiate a Floating IP Action To initiate an action on a floating IP send a
     * POST request to &#x60;/v2/floating_ips/$FLOATING_IP/actions&#x60;. In the
     * JSON body to the request, set the &#x60;type&#x60; attribute to on of the
     * supported action types: | Action | Details |------------|-------- |
     * &#x60;assign&#x60; | Assigns a floating IP to a Droplet |
     * &#x60;unassign&#x60; | Unassign a floating IP from a Droplet
     *
     * @param floatingIp                  A floating IP address. (required)
     * @param postFloatingIpActionRequest The &#x60;type&#x60; attribute set in the
     *                                    request body will specify the action that
     *                                    will be taken on the floating IP.
     *                                    (optional)
     * @return ApiResponse&lt;PostFloatingIpActionResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<PostFloatingIpActionResponse> postFloatingIpActionWithHttpInfo(String floatingIp,
            PostFloatingIpActionRequest postFloatingIpActionRequest) {
        HttpRequest.Builder localVarRequestBuilder = postFloatingIpActionRequestBuilder(floatingIp,
                postFloatingIpActionRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("postFloatingIpAction", localVarResponse);
                }
                return new ApiResponse<PostFloatingIpActionResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<PostFloatingIpActionResponse>() {
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

    private HttpRequest.Builder postFloatingIpActionRequestBuilder(String floatingIp,
            PostFloatingIpActionRequest postFloatingIpActionRequest) {
        // verify the required parameter 'floatingIp' is set
        if (floatingIp == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'floatingIp' when calling postFloatingIpAction");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/floating_ips/{floating_ip}/actions".replace("{floating_ip}",
                ApiClient.urlEncode(floatingIp.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(postFloatingIpActionRequest);
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
