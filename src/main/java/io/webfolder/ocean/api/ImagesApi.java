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
import io.webfolder.ocean.model.CreateCustomImageResponse;
import io.webfolder.ocean.model.GetImageImageIdParameter;
import io.webfolder.ocean.model.GetImageResponse;
import io.webfolder.ocean.model.GetImagesListResponse;
import io.webfolder.ocean.model.ImageNewCustom;
import io.webfolder.ocean.model.ImageUpdate;

public class ImagesApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public ImagesApi() {
        this(new ApiClient());
    }

    public ImagesApi(ApiClient apiClient) {
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
     * Create a Custom Image To create a new custom image, send a POST request to
     * /v2/images. The body must contain a url attribute pointing to a Linux virtual
     * machine image to be imported into DigitalOcean. The image must be in the raw,
     * qcow2, vhdx, vdi, or vmdk format. It may be compressed using gzip or bzip2
     * and must be smaller than 100 GB after being decompressed.
     *
     * @param imageNewCustom (required)
     * @return CreateCustomImageResponse
     * @throws ApiException if fails to make API call
     */
    public CreateCustomImageResponse createCustomImage(ImageNewCustom imageNewCustom) {
        ApiResponse<CreateCustomImageResponse> localVarResponse = createCustomImageWithHttpInfo(imageNewCustom);
        return localVarResponse.getData();
    }

    /**
     * Create a Custom Image To create a new custom image, send a POST request to
     * /v2/images. The body must contain a url attribute pointing to a Linux virtual
     * machine image to be imported into DigitalOcean. The image must be in the raw,
     * qcow2, vhdx, vdi, or vmdk format. It may be compressed using gzip or bzip2
     * and must be smaller than 100 GB after being decompressed.
     *
     * @param imageNewCustom (required)
     * @return ApiResponse&lt;CreateCustomImageResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateCustomImageResponse> createCustomImageWithHttpInfo(ImageNewCustom imageNewCustom) {
        HttpRequest.Builder localVarRequestBuilder = createCustomImageRequestBuilder(imageNewCustom);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createCustomImage", localVarResponse);
                }
                return new ApiResponse<CreateCustomImageResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateCustomImageResponse>() {
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

    private HttpRequest.Builder createCustomImageRequestBuilder(ImageNewCustom imageNewCustom) {
        // verify the required parameter 'imageNewCustom' is set
        if (imageNewCustom == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'imageNewCustom' when calling createCustomImage");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/images";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(imageNewCustom);
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
     * Delete an Image To delete a snapshot or custom image, send a
     * &#x60;DELETE&#x60; request to &#x60;/v2/images/$IMAGE_ID&#x60;.
     *
     * @param imageId A unique number that can be used to identify and reference a
     *                specific image. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteImage(Integer imageId) {
        deleteImageWithHttpInfo(imageId);
    }

    /**
     * Delete an Image To delete a snapshot or custom image, send a
     * &#x60;DELETE&#x60; request to &#x60;/v2/images/$IMAGE_ID&#x60;.
     *
     * @param imageId A unique number that can be used to identify and reference a
     *                specific image. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteImageWithHttpInfo(Integer imageId) {
        HttpRequest.Builder localVarRequestBuilder = deleteImageRequestBuilder(imageId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteImage", localVarResponse);
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

    private HttpRequest.Builder deleteImageRequestBuilder(Integer imageId) {
        // verify the required parameter 'imageId' is set
        if (imageId == null) {
            throw new ApiException(400, "Missing the required parameter 'imageId' when calling deleteImage");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/images/{image_id}".replace("{image_id}", ApiClient.urlEncode(imageId.toString()));

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
     * Retrieve an Existing Image To retrieve information about an image, send a
     * &#x60;GET&#x60; request to &#x60;/v2/images/$IDENTIFIER&#x60;.
     *
     * @param imageId A unique number (id) or string (slug) used to identify and
     *                reference a specific image. **Public** images can be
     *                identified by image &#x60;id&#x60; or &#x60;slug&#x60;.
     *                **Private** images *must* be identified by image
     *                &#x60;id&#x60;. (required)
     * @return GetImageResponse
     * @throws ApiException if fails to make API call
     */
    public GetImageResponse getImage(GetImageImageIdParameter imageId) {
        ApiResponse<GetImageResponse> localVarResponse = getImageWithHttpInfo(imageId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Image To retrieve information about an image, send a
     * &#x60;GET&#x60; request to &#x60;/v2/images/$IDENTIFIER&#x60;.
     *
     * @param imageId A unique number (id) or string (slug) used to identify and
     *                reference a specific image. **Public** images can be
     *                identified by image &#x60;id&#x60; or &#x60;slug&#x60;.
     *                **Private** images *must* be identified by image
     *                &#x60;id&#x60;. (required)
     * @return ApiResponse&lt;GetImageResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetImageResponse> getImageWithHttpInfo(GetImageImageIdParameter imageId) {
        HttpRequest.Builder localVarRequestBuilder = getImageRequestBuilder(imageId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getImage", localVarResponse);
                }
                return new ApiResponse<GetImageResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetImageResponse>() {
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

    private HttpRequest.Builder getImageRequestBuilder(GetImageImageIdParameter imageId) {
        // verify the required parameter 'imageId' is set
        if (imageId == null) {
            throw new ApiException(400, "Missing the required parameter 'imageId' when calling getImage");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/images/{image_id}".replace("{image_id}", ApiClient.urlEncode(imageId.toString()));

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
     * List All Images To list all of the images available on your account, send a
     * GET request to /v2/images. ## Filtering Results ----- It&#39;s possible to
     * request filtered results by including certain query parameters. **Image
     * Type** Either 1-Click Application or OS Distribution images can be filtered
     * by using the &#x60;type&#x60; query parameter. &gt; Important: The
     * &#x60;type&#x60; query parameter does not directly relate to the
     * &#x60;type&#x60; attribute. To retrieve only ***distribution*** images,
     * include the &#x60;type&#x60; query parameter set to distribution,
     * &#x60;/v2/images?type&#x3D;distribution&#x60;. To retrieve only
     * ***application*** images, include the &#x60;type&#x60; query parameter set to
     * application, &#x60;/v2/images?type&#x3D;application&#x60;. **User Images** To
     * retrieve only the private images of a user, include the &#x60;private&#x60;
     * query parameter set to true, &#x60;/v2/images?private&#x3D;true&#x60;.
     * **Tags** To list all images assigned to a specific tag, include the
     * &#x60;tag_name&#x60; query parameter set to the name of the tag in your GET
     * request. For example, &#x60;/v2/images?tag_name&#x3D;$TAG_NAME&#x60;.
     *
     * @param type     Filters results based on image type which can be either
     *                 &#x60;application&#x60; or &#x60;distribution&#x60;.
     *                 (optional)
     * @param _private Used to filter only user images. (optional)
     * @param tagName  Used to filter images by a specific tag. (optional)
     * @param perPage  Number of items returned per page (optional, default to 20)
     * @param page     Which &#39;page&#39; of paginated results to return.
     *                 (optional, default to 1)
     * @return GetImagesListResponse
     * @throws ApiException if fails to make API call
     */
    public GetImagesListResponse getImagesList(String type, Boolean _private, String tagName, Integer perPage,
            Integer page) {
        ApiResponse<GetImagesListResponse> localVarResponse = getImagesListWithHttpInfo(type, _private, tagName,
                perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All Images To list all of the images available on your account, send a
     * GET request to /v2/images. ## Filtering Results ----- It&#39;s possible to
     * request filtered results by including certain query parameters. **Image
     * Type** Either 1-Click Application or OS Distribution images can be filtered
     * by using the &#x60;type&#x60; query parameter. &gt; Important: The
     * &#x60;type&#x60; query parameter does not directly relate to the
     * &#x60;type&#x60; attribute. To retrieve only ***distribution*** images,
     * include the &#x60;type&#x60; query parameter set to distribution,
     * &#x60;/v2/images?type&#x3D;distribution&#x60;. To retrieve only
     * ***application*** images, include the &#x60;type&#x60; query parameter set to
     * application, &#x60;/v2/images?type&#x3D;application&#x60;. **User Images** To
     * retrieve only the private images of a user, include the &#x60;private&#x60;
     * query parameter set to true, &#x60;/v2/images?private&#x3D;true&#x60;.
     * **Tags** To list all images assigned to a specific tag, include the
     * &#x60;tag_name&#x60; query parameter set to the name of the tag in your GET
     * request. For example, &#x60;/v2/images?tag_name&#x3D;$TAG_NAME&#x60;.
     *
     * @param type     Filters results based on image type which can be either
     *                 &#x60;application&#x60; or &#x60;distribution&#x60;.
     *                 (optional)
     * @param _private Used to filter only user images. (optional)
     * @param tagName  Used to filter images by a specific tag. (optional)
     * @param perPage  Number of items returned per page (optional, default to 20)
     * @param page     Which &#39;page&#39; of paginated results to return.
     *                 (optional, default to 1)
     * @return ApiResponse&lt;GetImagesListResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetImagesListResponse> getImagesListWithHttpInfo(String type, Boolean _private, String tagName,
            Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = getImagesListRequestBuilder(type, _private, tagName, perPage,
                page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getImagesList", localVarResponse);
                }
                return new ApiResponse<GetImagesListResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetImagesListResponse>() {
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

    private HttpRequest.Builder getImagesListRequestBuilder(String type, Boolean _private, String tagName,
            Integer perPage, Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/images";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("type", type));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("private", _private));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("tag_name", tagName));
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
     * Update an Image To update an image, send a &#x60;PUT&#x60; request to
     * &#x60;/v2/images/$IMAGE_ID&#x60;. Set the &#x60;name&#x60; attribute to the
     * new value you would like to use. For custom images, the
     * &#x60;description&#x60; and &#x60;distribution&#x60; attributes may also be
     * updated.
     *
     * @param imageId     A unique number that can be used to identify and reference
     *                    a specific image. (required)
     * @param imageUpdate (required)
     * @return GetImageResponse
     * @throws ApiException if fails to make API call
     */
    public GetImageResponse updateImage(Integer imageId, ImageUpdate imageUpdate) {
        ApiResponse<GetImageResponse> localVarResponse = updateImageWithHttpInfo(imageId, imageUpdate);
        return localVarResponse.getData();
    }

    /**
     * Update an Image To update an image, send a &#x60;PUT&#x60; request to
     * &#x60;/v2/images/$IMAGE_ID&#x60;. Set the &#x60;name&#x60; attribute to the
     * new value you would like to use. For custom images, the
     * &#x60;description&#x60; and &#x60;distribution&#x60; attributes may also be
     * updated.
     *
     * @param imageId     A unique number that can be used to identify and reference
     *                    a specific image. (required)
     * @param imageUpdate (required)
     * @return ApiResponse&lt;GetImageResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetImageResponse> updateImageWithHttpInfo(Integer imageId, ImageUpdate imageUpdate) {
        HttpRequest.Builder localVarRequestBuilder = updateImageRequestBuilder(imageId, imageUpdate);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateImage", localVarResponse);
                }
                return new ApiResponse<GetImageResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetImageResponse>() {
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

    private HttpRequest.Builder updateImageRequestBuilder(Integer imageId, ImageUpdate imageUpdate) {
        // verify the required parameter 'imageId' is set
        if (imageId == null) {
            throw new ApiException(400, "Missing the required parameter 'imageId' when calling updateImage");
        }
        // verify the required parameter 'imageUpdate' is set
        if (imageUpdate == null) {
            throw new ApiException(400, "Missing the required parameter 'imageUpdate' when calling updateImage");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/images/{image_id}".replace("{image_id}", ApiClient.urlEncode(imageId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(imageUpdate);
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
