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
import io.webfolder.ocean.model.CreateNewTagResponse;
import io.webfolder.ocean.model.GetTagResponse;
import io.webfolder.ocean.model.ListAllTagsResponse;
import io.webfolder.ocean.model.Tag;
import io.webfolder.ocean.model.TagResource;

public class TagsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public TagsApi() {
        this(new ApiClient());
    }

    public TagsApi(ApiClient apiClient) {
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
     * Create a New Tag To create a tag you can send a POST request to
     * &#x60;/v2/tags&#x60; with a &#x60;name&#x60; attribute.
     *
     * @param tag (required)
     * @return CreateNewTagResponse
     * @throws ApiException if fails to make API call
     */
    public CreateNewTagResponse createNewTag(Tag tag) {
        ApiResponse<CreateNewTagResponse> localVarResponse = createNewTagWithHttpInfo(tag);
        return localVarResponse.getData();
    }

    /**
     * Create a New Tag To create a tag you can send a POST request to
     * &#x60;/v2/tags&#x60; with a &#x60;name&#x60; attribute.
     *
     * @param tag (required)
     * @return ApiResponse&lt;CreateNewTagResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateNewTagResponse> createNewTagWithHttpInfo(Tag tag) {
        HttpRequest.Builder localVarRequestBuilder = createNewTagRequestBuilder(tag);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createNewTag", localVarResponse);
                }
                return new ApiResponse<CreateNewTagResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateNewTagResponse>() {
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

    private HttpRequest.Builder createNewTagRequestBuilder(Tag tag) {
        // verify the required parameter 'tag' is set
        if (tag == null) {
            throw new ApiException(400, "Missing the required parameter 'tag' when calling createNewTag");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/tags";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(tag);
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
     * Delete a Tag A tag can be deleted by sending a &#x60;DELETE&#x60; request to
     * &#x60;/v2/tags/$TAG_NAME&#x60;. Deleting a tag also untags all the resources
     * that have previously been tagged by the Tag.
     *
     * @param tagId The name of the tag. Tags may contain letters, numbers, colons,
     *              dashes, and underscores. There is a limit of 255 characters per
     *              tag. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteTag(String tagId) {
        deleteTagWithHttpInfo(tagId);
    }

    /**
     * Delete a Tag A tag can be deleted by sending a &#x60;DELETE&#x60; request to
     * &#x60;/v2/tags/$TAG_NAME&#x60;. Deleting a tag also untags all the resources
     * that have previously been tagged by the Tag.
     *
     * @param tagId The name of the tag. Tags may contain letters, numbers, colons,
     *              dashes, and underscores. There is a limit of 255 characters per
     *              tag. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteTagWithHttpInfo(String tagId) {
        HttpRequest.Builder localVarRequestBuilder = deleteTagRequestBuilder(tagId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteTag", localVarResponse);
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

    private HttpRequest.Builder deleteTagRequestBuilder(String tagId) {
        // verify the required parameter 'tagId' is set
        if (tagId == null) {
            throw new ApiException(400, "Missing the required parameter 'tagId' when calling deleteTag");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/tags/{tag_id}".replace("{tag_id}", ApiClient.urlEncode(tagId.toString()));

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
     * Retrieve a Tag To retrieve an individual tag, you can send a &#x60;GET&#x60;
     * request to &#x60;/v2/tags/$TAG_NAME&#x60;.
     *
     * @param tagId The name of the tag. Tags may contain letters, numbers, colons,
     *              dashes, and underscores. There is a limit of 255 characters per
     *              tag. (required)
     * @return GetTagResponse
     * @throws ApiException if fails to make API call
     */
    public GetTagResponse getTag(String tagId) {
        ApiResponse<GetTagResponse> localVarResponse = getTagWithHttpInfo(tagId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve a Tag To retrieve an individual tag, you can send a &#x60;GET&#x60;
     * request to &#x60;/v2/tags/$TAG_NAME&#x60;.
     *
     * @param tagId The name of the tag. Tags may contain letters, numbers, colons,
     *              dashes, and underscores. There is a limit of 255 characters per
     *              tag. (required)
     * @return ApiResponse&lt;GetTagResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetTagResponse> getTagWithHttpInfo(String tagId) {
        HttpRequest.Builder localVarRequestBuilder = getTagRequestBuilder(tagId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getTag", localVarResponse);
                }
                return new ApiResponse<GetTagResponse>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetTagResponse>() {
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

    private HttpRequest.Builder getTagRequestBuilder(String tagId) {
        // verify the required parameter 'tagId' is set
        if (tagId == null) {
            throw new ApiException(400, "Missing the required parameter 'tagId' when calling getTag");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/tags/{tag_id}".replace("{tag_id}", ApiClient.urlEncode(tagId.toString()));

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
     * List All Tags To list all of your tags, you can send a GET request to
     * &#x60;/v2/tags&#x60;.
     *
     * @return ListAllTagsResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllTagsResponse listAllTags() {
        ApiResponse<ListAllTagsResponse> localVarResponse = listAllTagsWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List All Tags To list all of your tags, you can send a GET request to
     * &#x60;/v2/tags&#x60;.
     *
     * @return ApiResponse&lt;ListAllTagsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllTagsResponse> listAllTagsWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listAllTagsRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllTags", localVarResponse);
                }
                return new ApiResponse<ListAllTagsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllTagsResponse>() {
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

    private HttpRequest.Builder listAllTagsRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/tags";

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
     * Tag a Resource Resources can be tagged by sending a POST request to
     * &#x60;/v2/tags/$TAG_NAME/resources&#x60; with an array of json objects
     * containing &#x60;resource_id&#x60; and &#x60;resource_type&#x60; attributes.
     * Currently only tagging of Droplets, Databases, Images, Volumes, and Volume
     * Snapshots is supported. &#x60;resource_type&#x60; is expected to be the
     * string &#x60;droplet&#x60;, &#x60;database&#x60;, &#x60;image&#x60;,
     * &#x60;volume&#x60; or &#x60;volume_snapshot&#x60;. &#x60;resource_id&#x60; is
     * expected to be the ID of the resource as a string.
     *
     * @param tagId       The name of the tag. Tags may contain letters, numbers,
     *                    colons, dashes, and underscores. There is a limit of 255
     *                    characters per tag. (required)
     * @param tagResource (required)
     * @throws ApiException if fails to make API call
     */
    public void tagResource(String tagId, TagResource tagResource) {
        tagResourceWithHttpInfo(tagId, tagResource);
    }

    /**
     * Tag a Resource Resources can be tagged by sending a POST request to
     * &#x60;/v2/tags/$TAG_NAME/resources&#x60; with an array of json objects
     * containing &#x60;resource_id&#x60; and &#x60;resource_type&#x60; attributes.
     * Currently only tagging of Droplets, Databases, Images, Volumes, and Volume
     * Snapshots is supported. &#x60;resource_type&#x60; is expected to be the
     * string &#x60;droplet&#x60;, &#x60;database&#x60;, &#x60;image&#x60;,
     * &#x60;volume&#x60; or &#x60;volume_snapshot&#x60;. &#x60;resource_id&#x60; is
     * expected to be the ID of the resource as a string.
     *
     * @param tagId       The name of the tag. Tags may contain letters, numbers,
     *                    colons, dashes, and underscores. There is a limit of 255
     *                    characters per tag. (required)
     * @param tagResource (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> tagResourceWithHttpInfo(String tagId, TagResource tagResource) {
        HttpRequest.Builder localVarRequestBuilder = tagResourceRequestBuilder(tagId, tagResource);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("tagResource", localVarResponse);
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

    private HttpRequest.Builder tagResourceRequestBuilder(String tagId, TagResource tagResource) {
        // verify the required parameter 'tagId' is set
        if (tagId == null) {
            throw new ApiException(400, "Missing the required parameter 'tagId' when calling tagResource");
        }
        // verify the required parameter 'tagResource' is set
        if (tagResource == null) {
            throw new ApiException(400, "Missing the required parameter 'tagResource' when calling tagResource");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/tags/{tag_id}/resources".replace("{tag_id}", ApiClient.urlEncode(tagId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(tagResource);
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
     * Untag a Resource Resources can be tagged by sending a DELETE request to
     * &#x60;/v2/tags/$TAG_NAME/resources&#x60; with an array of json objects
     * containing &#x60;resource_id&#x60; and &#x60;resource_type&#x60; attributes.
     * Currently only untagging of Droplets, Databases, Images, Volumes, and Volume
     * Snapshots is supported. &#x60;resource_type&#x60; is expected to be the
     * string &#x60;droplet&#x60;, &#x60;database&#x60;, &#x60;image&#x60;,
     * &#x60;volume&#x60; or &#x60;volume_snapshot&#x60;. &#x60;resource_id&#x60; is
     * expected to be the ID of the resource as a string.
     *
     * @param tagId       The name of the tag. Tags may contain letters, numbers,
     *                    colons, dashes, and underscores. There is a limit of 255
     *                    characters per tag. (required)
     * @param tagResource (required)
     * @throws ApiException if fails to make API call
     */
    public void untagResource(String tagId, TagResource tagResource) {
        untagResourceWithHttpInfo(tagId, tagResource);
    }

    /**
     * Untag a Resource Resources can be tagged by sending a DELETE request to
     * &#x60;/v2/tags/$TAG_NAME/resources&#x60; with an array of json objects
     * containing &#x60;resource_id&#x60; and &#x60;resource_type&#x60; attributes.
     * Currently only untagging of Droplets, Databases, Images, Volumes, and Volume
     * Snapshots is supported. &#x60;resource_type&#x60; is expected to be the
     * string &#x60;droplet&#x60;, &#x60;database&#x60;, &#x60;image&#x60;,
     * &#x60;volume&#x60; or &#x60;volume_snapshot&#x60;. &#x60;resource_id&#x60; is
     * expected to be the ID of the resource as a string.
     *
     * @param tagId       The name of the tag. Tags may contain letters, numbers,
     *                    colons, dashes, and underscores. There is a limit of 255
     *                    characters per tag. (required)
     * @param tagResource (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> untagResourceWithHttpInfo(String tagId, TagResource tagResource) {
        HttpRequest.Builder localVarRequestBuilder = untagResourceRequestBuilder(tagId, tagResource);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("untagResource", localVarResponse);
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

    private HttpRequest.Builder untagResourceRequestBuilder(String tagId, TagResource tagResource) {
        // verify the required parameter 'tagId' is set
        if (tagId == null) {
            throw new ApiException(400, "Missing the required parameter 'tagId' when calling untagResource");
        }
        // verify the required parameter 'tagResource' is set
        if (tagResource == null) {
            throw new ApiException(400, "Missing the required parameter 'tagResource' when calling untagResource");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/tags/{tag_id}/resources".replace("{tag_id}", ApiClient.urlEncode(tagId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(tagResource);
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
}
