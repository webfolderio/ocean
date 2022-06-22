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
import io.webfolder.ocean.model.ListAllVolumeActionsResponse;
import io.webfolder.ocean.model.PostVolumeActionByIdRequest;
import io.webfolder.ocean.model.PostVolumeActionByNameRequest;
import io.webfolder.ocean.model.PostVolumeActionByNameResponse;

public class BlockStorageActionsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public BlockStorageActionsApi() {
        this(new ApiClient());
    }

    public BlockStorageActionsApi(ApiClient apiClient) {
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
     * Retrieve an Existing Volume Action To retrieve the status of a volume action,
     * send a GET request to &#x60;/v2/volumes/$VOLUME_ID/actions/$ACTION_ID&#x60;.
     *
     * @param volumeId The ID of the block storage volume. (required)
     * @param actionId A unique numeric ID that can be used to identify and
     *                 reference an action. (required)
     * @param perPage  Number of items returned per page (optional, default to 20)
     * @param page     Which &#39;page&#39; of paginated results to return.
     *                 (optional, default to 1)
     * @return PostVolumeActionByNameResponse
     * @throws ApiException if fails to make API call
     */
    public PostVolumeActionByNameResponse getVolumeAction(UUID volumeId, Integer actionId, Integer perPage,
            Integer page) {
        ApiResponse<PostVolumeActionByNameResponse> localVarResponse = getVolumeActionWithHttpInfo(volumeId, actionId,
                perPage, page);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Volume Action To retrieve the status of a volume action,
     * send a GET request to &#x60;/v2/volumes/$VOLUME_ID/actions/$ACTION_ID&#x60;.
     *
     * @param volumeId The ID of the block storage volume. (required)
     * @param actionId A unique numeric ID that can be used to identify and
     *                 reference an action. (required)
     * @param perPage  Number of items returned per page (optional, default to 20)
     * @param page     Which &#39;page&#39; of paginated results to return.
     *                 (optional, default to 1)
     * @return ApiResponse&lt;PostVolumeActionByNameResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<PostVolumeActionByNameResponse> getVolumeActionWithHttpInfo(UUID volumeId, Integer actionId,
            Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = getVolumeActionRequestBuilder(volumeId, actionId, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getVolumeAction", localVarResponse);
                }
                return new ApiResponse<PostVolumeActionByNameResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<PostVolumeActionByNameResponse>() {
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

    private HttpRequest.Builder getVolumeActionRequestBuilder(UUID volumeId, Integer actionId, Integer perPage,
            Integer page) {
        // verify the required parameter 'volumeId' is set
        if (volumeId == null) {
            throw new ApiException(400, "Missing the required parameter 'volumeId' when calling getVolumeAction");
        }
        // verify the required parameter 'actionId' is set
        if (actionId == null) {
            throw new ApiException(400, "Missing the required parameter 'actionId' when calling getVolumeAction");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes/{volume_id}/actions/{action_id}"
                .replace("{volume_id}", ApiClient.urlEncode(volumeId.toString()))
                .replace("{action_id}", ApiClient.urlEncode(actionId.toString()));

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
     * List All Actions for a Volume To retrieve all actions that have been executed
     * on a volume, send a GET request to
     * &#x60;/v2/volumes/$VOLUME_ID/actions&#x60;.
     *
     * @param volumeId The ID of the block storage volume. (required)
     * @param perPage  Number of items returned per page (optional, default to 20)
     * @param page     Which &#39;page&#39; of paginated results to return.
     *                 (optional, default to 1)
     * @return ListAllVolumeActionsResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllVolumeActionsResponse listAllVolumeActions(UUID volumeId, Integer perPage, Integer page) {
        ApiResponse<ListAllVolumeActionsResponse> localVarResponse = listAllVolumeActionsWithHttpInfo(volumeId, perPage,
                page);
        return localVarResponse.getData();
    }

    /**
     * List All Actions for a Volume To retrieve all actions that have been executed
     * on a volume, send a GET request to
     * &#x60;/v2/volumes/$VOLUME_ID/actions&#x60;.
     *
     * @param volumeId The ID of the block storage volume. (required)
     * @param perPage  Number of items returned per page (optional, default to 20)
     * @param page     Which &#39;page&#39; of paginated results to return.
     *                 (optional, default to 1)
     * @return ApiResponse&lt;ListAllVolumeActionsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllVolumeActionsResponse> listAllVolumeActionsWithHttpInfo(UUID volumeId, Integer perPage,
            Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listAllVolumeActionsRequestBuilder(volumeId, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllVolumeActions", localVarResponse);
                }
                return new ApiResponse<ListAllVolumeActionsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllVolumeActionsResponse>() {
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

    private HttpRequest.Builder listAllVolumeActionsRequestBuilder(UUID volumeId, Integer perPage, Integer page) {
        // verify the required parameter 'volumeId' is set
        if (volumeId == null) {
            throw new ApiException(400, "Missing the required parameter 'volumeId' when calling listAllVolumeActions");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes/{volume_id}/actions".replace("{volume_id}",
                ApiClient.urlEncode(volumeId.toString()));

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
     * Initiate A Block Storage Action By Volume Id To initiate an action on a block
     * storage volume by Id, send a POST request to
     * &#x60;~/v2/volumes/$VOLUME_ID/actions&#x60;. The body should contain the
     * appropriate attributes for the respective action. ## Attach a Block Storage
     * Volume to a Droplet | Attribute | Details | | ---------- |
     * ------------------------------------------------------------------- | | type
     * | This must be &#x60;attach&#x60; | | droplet_id | Set to the Droplet&#39;s
     * ID | | region | Set to the slug representing the region where the volume is
     * located | Each volume may only be attached to a single Droplet. However, up
     * to seven volumes may be attached to a Droplet at a time. Pre-formatted
     * volumes will be automatically mounted to Ubuntu, Debian, Fedora, Fedora
     * Atomic, and CentOS Droplets created on or after April 26, 2018 when attached.
     * On older Droplets, [additional
     * configuration](https://www.digitalocean.com/community/tutorials/how-to-partition-and-format-digitalocean-block-storage-volumes-in-linux#mounting-the-filesystems)
     * is required. ## Remove a Block Storage Volume from a Droplet | Attribute |
     * Details | | ---------- |
     * ------------------------------------------------------------------- | | type
     * | This must be &#x60;detach&#x60; | | droplet_id | Set to the Droplet&#39;s
     * ID | | region | Set to the slug representing the region where the volume is
     * located | ## Resize a Volume | Attribute | Details | | -------------- |
     * ------------------------------------------------------------------- | | type
     * | This must be &#x60;resize&#x60; | | size_gigabytes | The new size of the
     * block storage volume in GiB (1024^3) | | region | Set to the slug
     * representing the region where the volume is located | Volumes may only be
     * resized upwards. The maximum size for a volume is 16TiB.
     *
     * @param volumeId                    The ID of the block storage volume.
     *                                    (required)
     * @param postVolumeActionByIdRequest (required)
     * @param perPage                     Number of items returned per page
     *                                    (optional, default to 20)
     * @param page                        Which &#39;page&#39; of paginated results
     *                                    to return. (optional, default to 1)
     * @return PostVolumeActionByNameResponse
     * @throws ApiException if fails to make API call
     */
    public PostVolumeActionByNameResponse postVolumeActionById(UUID volumeId,
            PostVolumeActionByIdRequest postVolumeActionByIdRequest, Integer perPage, Integer page) {
        ApiResponse<PostVolumeActionByNameResponse> localVarResponse = postVolumeActionByIdWithHttpInfo(volumeId,
                postVolumeActionByIdRequest, perPage, page);
        return localVarResponse.getData();
    }

    /**
     * Initiate A Block Storage Action By Volume Id To initiate an action on a block
     * storage volume by Id, send a POST request to
     * &#x60;~/v2/volumes/$VOLUME_ID/actions&#x60;. The body should contain the
     * appropriate attributes for the respective action. ## Attach a Block Storage
     * Volume to a Droplet | Attribute | Details | | ---------- |
     * ------------------------------------------------------------------- | | type
     * | This must be &#x60;attach&#x60; | | droplet_id | Set to the Droplet&#39;s
     * ID | | region | Set to the slug representing the region where the volume is
     * located | Each volume may only be attached to a single Droplet. However, up
     * to seven volumes may be attached to a Droplet at a time. Pre-formatted
     * volumes will be automatically mounted to Ubuntu, Debian, Fedora, Fedora
     * Atomic, and CentOS Droplets created on or after April 26, 2018 when attached.
     * On older Droplets, [additional
     * configuration](https://www.digitalocean.com/community/tutorials/how-to-partition-and-format-digitalocean-block-storage-volumes-in-linux#mounting-the-filesystems)
     * is required. ## Remove a Block Storage Volume from a Droplet | Attribute |
     * Details | | ---------- |
     * ------------------------------------------------------------------- | | type
     * | This must be &#x60;detach&#x60; | | droplet_id | Set to the Droplet&#39;s
     * ID | | region | Set to the slug representing the region where the volume is
     * located | ## Resize a Volume | Attribute | Details | | -------------- |
     * ------------------------------------------------------------------- | | type
     * | This must be &#x60;resize&#x60; | | size_gigabytes | The new size of the
     * block storage volume in GiB (1024^3) | | region | Set to the slug
     * representing the region where the volume is located | Volumes may only be
     * resized upwards. The maximum size for a volume is 16TiB.
     *
     * @param volumeId                    The ID of the block storage volume.
     *                                    (required)
     * @param postVolumeActionByIdRequest (required)
     * @param perPage                     Number of items returned per page
     *                                    (optional, default to 20)
     * @param page                        Which &#39;page&#39; of paginated results
     *                                    to return. (optional, default to 1)
     * @return ApiResponse&lt;PostVolumeActionByNameResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<PostVolumeActionByNameResponse> postVolumeActionByIdWithHttpInfo(UUID volumeId,
            PostVolumeActionByIdRequest postVolumeActionByIdRequest, Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = postVolumeActionByIdRequestBuilder(volumeId,
                postVolumeActionByIdRequest, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("postVolumeActionById", localVarResponse);
                }
                return new ApiResponse<PostVolumeActionByNameResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<PostVolumeActionByNameResponse>() {
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

    private HttpRequest.Builder postVolumeActionByIdRequestBuilder(UUID volumeId,
            PostVolumeActionByIdRequest postVolumeActionByIdRequest, Integer perPage, Integer page) {
        // verify the required parameter 'volumeId' is set
        if (volumeId == null) {
            throw new ApiException(400, "Missing the required parameter 'volumeId' when calling postVolumeActionById");
        }
        // verify the required parameter 'postVolumeActionByIdRequest' is set
        if (postVolumeActionByIdRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'postVolumeActionByIdRequest' when calling postVolumeActionById");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes/{volume_id}/actions".replace("{volume_id}",
                ApiClient.urlEncode(volumeId.toString()));

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

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(postVolumeActionByIdRequest);
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
     * Initiate A Block Storage Action By Volume Name To initiate an action on a
     * block storage volume by Name, send a POST request to
     * &#x60;~/v2/volumes/actions&#x60;. The body should contain the appropriate
     * attributes for the respective action. ## Attach a Block Storage Volume to a
     * Droplet | Attribute | Details | | ----------- |
     * ------------------------------------------------------------------- | | type
     * | This must be &#x60;attach&#x60; | | volume_name | The name of the block
     * storage volume | | droplet_id | Set to the Droplet&#39;s ID | | region | Set
     * to the slug representing the region where the volume is located | Each volume
     * may only be attached to a single Droplet. However, up to five volumes may be
     * attached to a Droplet at a time. Pre-formatted volumes will be automatically
     * mounted to Ubuntu, Debian, Fedora, Fedora Atomic, and CentOS Droplets created
     * on or after April 26, 2018 when attached. On older Droplets, [additional
     * configuration](https://www.digitalocean.com/community/tutorials/how-to-partition-and-format-digitalocean-block-storage-volumes-in-linux#mounting-the-filesystems)
     * is required. ## Remove a Block Storage Volume from a Droplet | Attribute |
     * Details | | ----------- |
     * ------------------------------------------------------------------- | | type
     * | This must be &#x60;detach&#x60; | | volume_name | The name of the block
     * storage volume | | droplet_id | Set to the Droplet&#39;s ID | | region | Set
     * to the slug representing the region where the volume is located |
     *
     * @param postVolumeActionByNameRequest (required)
     * @param perPage                       Number of items returned per page
     *                                      (optional, default to 20)
     * @param page                          Which &#39;page&#39; of paginated
     *                                      results to return. (optional, default to
     *                                      1)
     * @return PostVolumeActionByNameResponse
     * @throws ApiException if fails to make API call
     */
    public PostVolumeActionByNameResponse postVolumeActionByName(
            PostVolumeActionByNameRequest postVolumeActionByNameRequest, Integer perPage, Integer page) {
        ApiResponse<PostVolumeActionByNameResponse> localVarResponse = postVolumeActionByNameWithHttpInfo(
                postVolumeActionByNameRequest, perPage, page);
        return localVarResponse.getData();
    }

    /**
     * Initiate A Block Storage Action By Volume Name To initiate an action on a
     * block storage volume by Name, send a POST request to
     * &#x60;~/v2/volumes/actions&#x60;. The body should contain the appropriate
     * attributes for the respective action. ## Attach a Block Storage Volume to a
     * Droplet | Attribute | Details | | ----------- |
     * ------------------------------------------------------------------- | | type
     * | This must be &#x60;attach&#x60; | | volume_name | The name of the block
     * storage volume | | droplet_id | Set to the Droplet&#39;s ID | | region | Set
     * to the slug representing the region where the volume is located | Each volume
     * may only be attached to a single Droplet. However, up to five volumes may be
     * attached to a Droplet at a time. Pre-formatted volumes will be automatically
     * mounted to Ubuntu, Debian, Fedora, Fedora Atomic, and CentOS Droplets created
     * on or after April 26, 2018 when attached. On older Droplets, [additional
     * configuration](https://www.digitalocean.com/community/tutorials/how-to-partition-and-format-digitalocean-block-storage-volumes-in-linux#mounting-the-filesystems)
     * is required. ## Remove a Block Storage Volume from a Droplet | Attribute |
     * Details | | ----------- |
     * ------------------------------------------------------------------- | | type
     * | This must be &#x60;detach&#x60; | | volume_name | The name of the block
     * storage volume | | droplet_id | Set to the Droplet&#39;s ID | | region | Set
     * to the slug representing the region where the volume is located |
     *
     * @param postVolumeActionByNameRequest (required)
     * @param perPage                       Number of items returned per page
     *                                      (optional, default to 20)
     * @param page                          Which &#39;page&#39; of paginated
     *                                      results to return. (optional, default to
     *                                      1)
     * @return ApiResponse&lt;PostVolumeActionByNameResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<PostVolumeActionByNameResponse> postVolumeActionByNameWithHttpInfo(
            PostVolumeActionByNameRequest postVolumeActionByNameRequest, Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = postVolumeActionByNameRequestBuilder(postVolumeActionByNameRequest,
                perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("postVolumeActionByName", localVarResponse);
                }
                return new ApiResponse<PostVolumeActionByNameResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<PostVolumeActionByNameResponse>() {
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

    private HttpRequest.Builder postVolumeActionByNameRequestBuilder(
            PostVolumeActionByNameRequest postVolumeActionByNameRequest, Integer perPage, Integer page) {
        // verify the required parameter 'postVolumeActionByNameRequest' is set
        if (postVolumeActionByNameRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'postVolumeActionByNameRequest' when calling postVolumeActionByName");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes/actions";

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

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(postVolumeActionByNameRequest);
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
