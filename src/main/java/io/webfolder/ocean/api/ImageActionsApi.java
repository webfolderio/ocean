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
import io.webfolder.ocean.model.Action;
import io.webfolder.ocean.model.ListAllActionsResponse;
import io.webfolder.ocean.model.PostImageActionRequest;

public class ImageActionsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public ImageActionsApi() {
        this(new ApiClient());
    }

    public ImageActionsApi(ApiClient apiClient) {
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
     * Retrieve an Existing Action To retrieve the status of an image action, send a
     * GET request to &#x60;/v2/images/$IMAGE_ID/actions/$IMAGE_ACTION_ID&#x60;.
     *
     * @param imageId  A unique number that can be used to identify and reference a
     *                 specific image. (required)
     * @param actionId A unique numeric ID that can be used to identify and
     *                 reference an action. (required)
     * @return Action
     * @throws ApiException if fails to make API call
     */
    public Action getImageAction(Integer imageId, Integer actionId) {
        ApiResponse<Action> localVarResponse = getImageActionWithHttpInfo(imageId, actionId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Action To retrieve the status of an image action, send a
     * GET request to &#x60;/v2/images/$IMAGE_ID/actions/$IMAGE_ACTION_ID&#x60;.
     *
     * @param imageId  A unique number that can be used to identify and reference a
     *                 specific image. (required)
     * @param actionId A unique numeric ID that can be used to identify and
     *                 reference an action. (required)
     * @return ApiResponse&lt;Action&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Action> getImageActionWithHttpInfo(Integer imageId, Integer actionId) {
        HttpRequest.Builder localVarRequestBuilder = getImageActionRequestBuilder(imageId, actionId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getImageAction", localVarResponse);
                }
                return new ApiResponse<Action>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Action>() {
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

    private HttpRequest.Builder getImageActionRequestBuilder(Integer imageId, Integer actionId) {
        // verify the required parameter 'imageId' is set
        if (imageId == null) {
            throw new ApiException(400, "Missing the required parameter 'imageId' when calling getImageAction");
        }
        // verify the required parameter 'actionId' is set
        if (actionId == null) {
            throw new ApiException(400, "Missing the required parameter 'actionId' when calling getImageAction");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/images/{image_id}/actions/{action_id}"
                .replace("{image_id}", ApiClient.urlEncode(imageId.toString()))
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
     * List All Actions for an Image To retrieve all actions that have been executed
     * on an image, send a GET request to &#x60;/v2/images/$IMAGE_ID/actions&#x60;.
     *
     * @param imageId A unique number that can be used to identify and reference a
     *                specific image. (required)
     * @return ListAllActionsResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllActionsResponse listImageActions(Integer imageId) {
        ApiResponse<ListAllActionsResponse> localVarResponse = listImageActionsWithHttpInfo(imageId);
        return localVarResponse.getData();
    }

    /**
     * List All Actions for an Image To retrieve all actions that have been executed
     * on an image, send a GET request to &#x60;/v2/images/$IMAGE_ID/actions&#x60;.
     *
     * @param imageId A unique number that can be used to identify and reference a
     *                specific image. (required)
     * @return ApiResponse&lt;ListAllActionsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllActionsResponse> listImageActionsWithHttpInfo(Integer imageId) {
        HttpRequest.Builder localVarRequestBuilder = listImageActionsRequestBuilder(imageId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listImageActions", localVarResponse);
                }
                return new ApiResponse<ListAllActionsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllActionsResponse>() {
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

    private HttpRequest.Builder listImageActionsRequestBuilder(Integer imageId) {
        // verify the required parameter 'imageId' is set
        if (imageId == null) {
            throw new ApiException(400, "Missing the required parameter 'imageId' when calling listImageActions");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/images/{image_id}/actions".replace("{image_id}",
                ApiClient.urlEncode(imageId.toString()));

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
     * Initiate an Image Action The following actions are available on an Image. ##
     * Convert an Image to a Snapshot To convert an image, for example, a backup to
     * a snapshot, send a POST request to &#x60;/v2/images/$IMAGE_ID/actions&#x60;.
     * Set the &#x60;type&#x60; attribute to &#x60;convert&#x60;. ## Transfer an
     * Image To transfer an image to another region, send a POST request to
     * &#x60;/v2/images/$IMAGE_ID/actions&#x60;. Set the &#x60;type&#x60; attribute
     * to &#x60;transfer&#x60; and set &#x60;region&#x60; attribute to the slug
     * identifier of the region you wish to transfer to.
     *
     * @param imageId                A unique number that can be used to identify
     *                               and reference a specific image. (required)
     * @param postImageActionRequest (optional)
     * @return Action
     * @throws ApiException if fails to make API call
     */
    public Action postImageAction(Integer imageId, PostImageActionRequest postImageActionRequest) {
        ApiResponse<Action> localVarResponse = postImageActionWithHttpInfo(imageId, postImageActionRequest);
        return localVarResponse.getData();
    }

    /**
     * Initiate an Image Action The following actions are available on an Image. ##
     * Convert an Image to a Snapshot To convert an image, for example, a backup to
     * a snapshot, send a POST request to &#x60;/v2/images/$IMAGE_ID/actions&#x60;.
     * Set the &#x60;type&#x60; attribute to &#x60;convert&#x60;. ## Transfer an
     * Image To transfer an image to another region, send a POST request to
     * &#x60;/v2/images/$IMAGE_ID/actions&#x60;. Set the &#x60;type&#x60; attribute
     * to &#x60;transfer&#x60; and set &#x60;region&#x60; attribute to the slug
     * identifier of the region you wish to transfer to.
     *
     * @param imageId                A unique number that can be used to identify
     *                               and reference a specific image. (required)
     * @param postImageActionRequest (optional)
     * @return ApiResponse&lt;Action&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Action> postImageActionWithHttpInfo(Integer imageId,
            PostImageActionRequest postImageActionRequest) {
        HttpRequest.Builder localVarRequestBuilder = postImageActionRequestBuilder(imageId, postImageActionRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("postImageAction", localVarResponse);
                }
                return new ApiResponse<Action>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Action>() {
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

    private HttpRequest.Builder postImageActionRequestBuilder(Integer imageId,
            PostImageActionRequest postImageActionRequest) {
        // verify the required parameter 'imageId' is set
        if (imageId == null) {
            throw new ApiException(400, "Missing the required parameter 'imageId' when calling postImageAction");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/images/{image_id}/actions".replace("{image_id}",
                ApiClient.urlEncode(imageId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(postImageActionRequest);
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
