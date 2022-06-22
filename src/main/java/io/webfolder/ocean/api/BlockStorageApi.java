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
import io.webfolder.ocean.model.CreateNewVolumeRequest;
import io.webfolder.ocean.model.CreateNewVolumeResponse;
import io.webfolder.ocean.model.CreateVolumeSnapshotRequest;
import io.webfolder.ocean.model.GetSnapshotSnapshotIdParameter;
import io.webfolder.ocean.model.GetVolumeSnapshotByIdResponse;
import io.webfolder.ocean.model.ListAllVolumesResponse;
import io.webfolder.ocean.model.ListVolumeSnapshotsResponse;
import io.webfolder.ocean.model.RegionSlug;

public class BlockStorageApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public BlockStorageApi() {
        this(new ApiClient());
    }

    public BlockStorageApi(ApiClient apiClient) {
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
     * Create a New Block Storage Volume To create a new volume, send a POST request
     * to &#x60;/v2/volumes&#x60;. Optionally, a &#x60;filesystem_type&#x60;
     * attribute may be provided in order to automatically format the volume&#39;s
     * filesystem. Pre-formatted volumes are automatically mounted when attached to
     * Ubuntu, Debian, Fedora, Fedora Atomic, and CentOS Droplets created on or
     * after April 26, 2018. Attaching pre-formatted volumes to Droplets without
     * support for auto-mounting is not recommended.
     *
     * @param createNewVolumeRequest (required)
     * @return CreateNewVolumeResponse
     * @throws ApiException if fails to make API call
     */
    public CreateNewVolumeResponse createNewVolume(CreateNewVolumeRequest createNewVolumeRequest) {
        ApiResponse<CreateNewVolumeResponse> localVarResponse = createNewVolumeWithHttpInfo(createNewVolumeRequest);
        return localVarResponse.getData();
    }

    /**
     * Create a New Block Storage Volume To create a new volume, send a POST request
     * to &#x60;/v2/volumes&#x60;. Optionally, a &#x60;filesystem_type&#x60;
     * attribute may be provided in order to automatically format the volume&#39;s
     * filesystem. Pre-formatted volumes are automatically mounted when attached to
     * Ubuntu, Debian, Fedora, Fedora Atomic, and CentOS Droplets created on or
     * after April 26, 2018. Attaching pre-formatted volumes to Droplets without
     * support for auto-mounting is not recommended.
     *
     * @param createNewVolumeRequest (required)
     * @return ApiResponse&lt;CreateNewVolumeResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateNewVolumeResponse> createNewVolumeWithHttpInfo(
            CreateNewVolumeRequest createNewVolumeRequest) {
        HttpRequest.Builder localVarRequestBuilder = createNewVolumeRequestBuilder(createNewVolumeRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createNewVolume", localVarResponse);
                }
                return new ApiResponse<CreateNewVolumeResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateNewVolumeResponse>() {
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

    private HttpRequest.Builder createNewVolumeRequestBuilder(CreateNewVolumeRequest createNewVolumeRequest) {
        // verify the required parameter 'createNewVolumeRequest' is set
        if (createNewVolumeRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'createNewVolumeRequest' when calling createNewVolume");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createNewVolumeRequest);
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
     * Create Snapshot from a Volume To create a snapshot from a volume, sent a POST
     * request to &#x60;/v2/volumes/$VOLUME_ID/snapshots&#x60;.
     *
     * @param volumeId                    The ID of the block storage volume.
     *                                    (required)
     * @param createVolumeSnapshotRequest (required)
     * @return GetVolumeSnapshotByIdResponse
     * @throws ApiException if fails to make API call
     */
    public GetVolumeSnapshotByIdResponse createVolumeSnapshot(UUID volumeId,
            CreateVolumeSnapshotRequest createVolumeSnapshotRequest) {
        ApiResponse<GetVolumeSnapshotByIdResponse> localVarResponse = createVolumeSnapshotWithHttpInfo(volumeId,
                createVolumeSnapshotRequest);
        return localVarResponse.getData();
    }

    /**
     * Create Snapshot from a Volume To create a snapshot from a volume, sent a POST
     * request to &#x60;/v2/volumes/$VOLUME_ID/snapshots&#x60;.
     *
     * @param volumeId                    The ID of the block storage volume.
     *                                    (required)
     * @param createVolumeSnapshotRequest (required)
     * @return ApiResponse&lt;GetVolumeSnapshotByIdResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetVolumeSnapshotByIdResponse> createVolumeSnapshotWithHttpInfo(UUID volumeId,
            CreateVolumeSnapshotRequest createVolumeSnapshotRequest) {
        HttpRequest.Builder localVarRequestBuilder = createVolumeSnapshotRequestBuilder(volumeId,
                createVolumeSnapshotRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createVolumeSnapshot", localVarResponse);
                }
                return new ApiResponse<GetVolumeSnapshotByIdResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetVolumeSnapshotByIdResponse>() {
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

    private HttpRequest.Builder createVolumeSnapshotRequestBuilder(UUID volumeId,
            CreateVolumeSnapshotRequest createVolumeSnapshotRequest) {
        // verify the required parameter 'volumeId' is set
        if (volumeId == null) {
            throw new ApiException(400, "Missing the required parameter 'volumeId' when calling createVolumeSnapshot");
        }
        // verify the required parameter 'createVolumeSnapshotRequest' is set
        if (createVolumeSnapshotRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'createVolumeSnapshotRequest' when calling createVolumeSnapshot");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes/{volume_id}/snapshots".replace("{volume_id}",
                ApiClient.urlEncode(volumeId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createVolumeSnapshotRequest);
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
     * Delete a Block Storage Volume To delete a block storage volume, destroying
     * all data and removing it from your account, send a DELETE request to
     * &#x60;/v2/volumes/$VOLUME_ID&#x60;. No response body will be sent back, but
     * the response code will indicate success. Specifically, the response code will
     * be a 204, which means that the action was successful with no returned body
     * data.
     *
     * @param volumeId The ID of the block storage volume. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteVolume(UUID volumeId) {
        deleteVolumeWithHttpInfo(volumeId);
    }

    /**
     * Delete a Block Storage Volume To delete a block storage volume, destroying
     * all data and removing it from your account, send a DELETE request to
     * &#x60;/v2/volumes/$VOLUME_ID&#x60;. No response body will be sent back, but
     * the response code will indicate success. Specifically, the response code will
     * be a 204, which means that the action was successful with no returned body
     * data.
     *
     * @param volumeId The ID of the block storage volume. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteVolumeWithHttpInfo(UUID volumeId) {
        HttpRequest.Builder localVarRequestBuilder = deleteVolumeRequestBuilder(volumeId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteVolume", localVarResponse);
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

    private HttpRequest.Builder deleteVolumeRequestBuilder(UUID volumeId) {
        // verify the required parameter 'volumeId' is set
        if (volumeId == null) {
            throw new ApiException(400, "Missing the required parameter 'volumeId' when calling deleteVolume");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes/{volume_id}".replace("{volume_id}",
                ApiClient.urlEncode(volumeId.toString()));

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
     * Delete a Block Storage Volume by Name Block storage volumes may also be
     * deleted by name by sending a DELETE request with the volume&#39;s **name**
     * and the **region slug** for the region it is located in as query parameters
     * to &#x60;/v2/volumes?name&#x3D;$VOLUME_NAME&amp;region&#x3D;nyc1&#x60;. No
     * response body will be sent back, but the response code will indicate success.
     * Specifically, the response code will be a 204, which means that the action
     * was successful with no returned body data.
     *
     * @param name   The block storage volume&#39;s name. (optional)
     * @param region The slug identifier for the region where the resource is
     *               available. (optional)
     * @throws ApiException if fails to make API call
     */
    public void deleteVolumeByName(String name, RegionSlug region) {
        deleteVolumeByNameWithHttpInfo(name, region);
    }

    /**
     * Delete a Block Storage Volume by Name Block storage volumes may also be
     * deleted by name by sending a DELETE request with the volume&#39;s **name**
     * and the **region slug** for the region it is located in as query parameters
     * to &#x60;/v2/volumes?name&#x3D;$VOLUME_NAME&amp;region&#x3D;nyc1&#x60;. No
     * response body will be sent back, but the response code will indicate success.
     * Specifically, the response code will be a 204, which means that the action
     * was successful with no returned body data.
     *
     * @param name   The block storage volume&#39;s name. (optional)
     * @param region The slug identifier for the region where the resource is
     *               available. (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteVolumeByNameWithHttpInfo(String name, RegionSlug region) {
        HttpRequest.Builder localVarRequestBuilder = deleteVolumeByNameRequestBuilder(name, region);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteVolumeByName", localVarResponse);
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

    private HttpRequest.Builder deleteVolumeByNameRequestBuilder(String name, RegionSlug region) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("name", name));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("region", region));

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
     * Delete a Volume Snapshot To delete a volume snapshot, send a DELETE request
     * to &#x60;/v2/snapshots/$SNAPSHOT_ID&#x60;. A status of 204 will be given.
     * This indicates that the request was processed successfully, but that no
     * response body is needed.
     *
     * @param snapshotId Either the ID of an existing snapshot. This will be an
     *                   integer for a Droplet snapshot or a string for a volume
     *                   snapshot. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteVolumeSnapshotById(GetSnapshotSnapshotIdParameter snapshotId) {
        deleteVolumeSnapshotByIdWithHttpInfo(snapshotId);
    }

    /**
     * Delete a Volume Snapshot To delete a volume snapshot, send a DELETE request
     * to &#x60;/v2/snapshots/$SNAPSHOT_ID&#x60;. A status of 204 will be given.
     * This indicates that the request was processed successfully, but that no
     * response body is needed.
     *
     * @param snapshotId Either the ID of an existing snapshot. This will be an
     *                   integer for a Droplet snapshot or a string for a volume
     *                   snapshot. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteVolumeSnapshotByIdWithHttpInfo(GetSnapshotSnapshotIdParameter snapshotId) {
        HttpRequest.Builder localVarRequestBuilder = deleteVolumeSnapshotByIdRequestBuilder(snapshotId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteVolumeSnapshotById", localVarResponse);
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

    private HttpRequest.Builder deleteVolumeSnapshotByIdRequestBuilder(GetSnapshotSnapshotIdParameter snapshotId) {
        // verify the required parameter 'snapshotId' is set
        if (snapshotId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'snapshotId' when calling deleteVolumeSnapshotById");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes/snapshot/{snapshot_id}".replace("{snapshot_id}",
                ApiClient.urlEncode(snapshotId.toString()));

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
     * Retrieve an Existing Block Storage Volume To show information about a block
     * storage volume, send a GET request to &#x60;/v2/volumes/$VOLUME_ID&#x60;.
     *
     * @param volumeId The ID of the block storage volume. (required)
     * @return CreateNewVolumeResponse
     * @throws ApiException if fails to make API call
     */
    public CreateNewVolumeResponse getVolume(UUID volumeId) {
        ApiResponse<CreateNewVolumeResponse> localVarResponse = getVolumeWithHttpInfo(volumeId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Block Storage Volume To show information about a block
     * storage volume, send a GET request to &#x60;/v2/volumes/$VOLUME_ID&#x60;.
     *
     * @param volumeId The ID of the block storage volume. (required)
     * @return ApiResponse&lt;CreateNewVolumeResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateNewVolumeResponse> getVolumeWithHttpInfo(UUID volumeId) {
        HttpRequest.Builder localVarRequestBuilder = getVolumeRequestBuilder(volumeId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getVolume", localVarResponse);
                }
                return new ApiResponse<CreateNewVolumeResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateNewVolumeResponse>() {
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

    private HttpRequest.Builder getVolumeRequestBuilder(UUID volumeId) {
        // verify the required parameter 'volumeId' is set
        if (volumeId == null) {
            throw new ApiException(400, "Missing the required parameter 'volumeId' when calling getVolume");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes/{volume_id}".replace("{volume_id}",
                ApiClient.urlEncode(volumeId.toString()));

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
     * Retreive an Existing Volume Snapshot To retrieve the details of a snapshot
     * that has been created from a volume, send a GET request to
     * &#x60;/v2/volumes/snapshots/$SNAPSHOT_ID&#x60;.
     *
     * @param snapshotId Either the ID of an existing snapshot. This will be an
     *                   integer for a Droplet snapshot or a string for a volume
     *                   snapshot. (required)
     * @return GetVolumeSnapshotByIdResponse
     * @throws ApiException if fails to make API call
     */
    public GetVolumeSnapshotByIdResponse getVolumeSnapshotById(GetSnapshotSnapshotIdParameter snapshotId) {
        ApiResponse<GetVolumeSnapshotByIdResponse> localVarResponse = getVolumeSnapshotByIdWithHttpInfo(snapshotId);
        return localVarResponse.getData();
    }

    /**
     * Retreive an Existing Volume Snapshot To retrieve the details of a snapshot
     * that has been created from a volume, send a GET request to
     * &#x60;/v2/volumes/snapshots/$SNAPSHOT_ID&#x60;.
     *
     * @param snapshotId Either the ID of an existing snapshot. This will be an
     *                   integer for a Droplet snapshot or a string for a volume
     *                   snapshot. (required)
     * @return ApiResponse&lt;GetVolumeSnapshotByIdResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetVolumeSnapshotByIdResponse> getVolumeSnapshotByIdWithHttpInfo(
            GetSnapshotSnapshotIdParameter snapshotId) {
        HttpRequest.Builder localVarRequestBuilder = getVolumeSnapshotByIdRequestBuilder(snapshotId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getVolumeSnapshotById", localVarResponse);
                }
                return new ApiResponse<GetVolumeSnapshotByIdResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetVolumeSnapshotByIdResponse>() {
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

    private HttpRequest.Builder getVolumeSnapshotByIdRequestBuilder(GetSnapshotSnapshotIdParameter snapshotId) {
        // verify the required parameter 'snapshotId' is set
        if (snapshotId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'snapshotId' when calling getVolumeSnapshotById");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes/snapshot/{snapshot_id}".replace("{snapshot_id}",
                ApiClient.urlEncode(snapshotId.toString()));

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
     * List All Block Storage Volumes To list all of the block storage volumes
     * available on your account, send a GET request to &#x60;/v2/volumes&#x60;. ##
     * Filtering Results ### By Region The &#x60;region&#x60; may be provided as
     * query paramater in order to restrict results to volumes available in a
     * specific region. For example: &#x60;/v2/volumes?region&#x3D;nyc1&#x60; ### By
     * Name It is also possible to list volumes on your account that match a
     * specified name. To do so, send a GET request with the volume&#39;s name as a
     * query parameter to &#x60;/v2/volumes?name&#x3D;$VOLUME_NAME&#x60;. **Note:**
     * You can only create one volume per region with the same name. ### By Name and
     * Region It is also possible to retrieve information about a block storage
     * volume by name. To do so, send a GET request with the volume&#39;s name and
     * the region slug for the region it is located in as query parameters to
     * &#x60;/v2/volumes?name&#x3D;$VOLUME_NAME&amp;region&#x3D;nyc1&#x60;.
     *
     * @param name    The block storage volume&#39;s name. (optional)
     * @param region  The slug identifier for the region where the resource is
     *                available. (optional)
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ListAllVolumesResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllVolumesResponse listAllVolumes(String name, RegionSlug region, Integer perPage, Integer page) {
        ApiResponse<ListAllVolumesResponse> localVarResponse = listAllVolumesWithHttpInfo(name, region, perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All Block Storage Volumes To list all of the block storage volumes
     * available on your account, send a GET request to &#x60;/v2/volumes&#x60;. ##
     * Filtering Results ### By Region The &#x60;region&#x60; may be provided as
     * query paramater in order to restrict results to volumes available in a
     * specific region. For example: &#x60;/v2/volumes?region&#x3D;nyc1&#x60; ### By
     * Name It is also possible to list volumes on your account that match a
     * specified name. To do so, send a GET request with the volume&#39;s name as a
     * query parameter to &#x60;/v2/volumes?name&#x3D;$VOLUME_NAME&#x60;. **Note:**
     * You can only create one volume per region with the same name. ### By Name and
     * Region It is also possible to retrieve information about a block storage
     * volume by name. To do so, send a GET request with the volume&#39;s name and
     * the region slug for the region it is located in as query parameters to
     * &#x60;/v2/volumes?name&#x3D;$VOLUME_NAME&amp;region&#x3D;nyc1&#x60;.
     *
     * @param name    The block storage volume&#39;s name. (optional)
     * @param region  The slug identifier for the region where the resource is
     *                available. (optional)
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ApiResponse&lt;ListAllVolumesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllVolumesResponse> listAllVolumesWithHttpInfo(String name, RegionSlug region,
            Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listAllVolumesRequestBuilder(name, region, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllVolumes", localVarResponse);
                }
                return new ApiResponse<ListAllVolumesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllVolumesResponse>() {
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

    private HttpRequest.Builder listAllVolumesRequestBuilder(String name, RegionSlug region, Integer perPage,
            Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("name", name));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("region", region));
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
     * List Snapshots for a Volume To retrieve the snapshots that have been created
     * from a volume, send a GET request to
     * &#x60;/v2/volumes/$VOLUME_ID/snapshots&#x60;.
     *
     * @param volumeId The ID of the block storage volume. (required)
     * @param perPage  Number of items returned per page (optional, default to 20)
     * @param page     Which &#39;page&#39; of paginated results to return.
     *                 (optional, default to 1)
     * @return ListVolumeSnapshotsResponse
     * @throws ApiException if fails to make API call
     */
    public ListVolumeSnapshotsResponse listVolumeSnapshots(UUID volumeId, Integer perPage, Integer page) {
        ApiResponse<ListVolumeSnapshotsResponse> localVarResponse = listVolumeSnapshotsWithHttpInfo(volumeId, perPage,
                page);
        return localVarResponse.getData();
    }

    /**
     * List Snapshots for a Volume To retrieve the snapshots that have been created
     * from a volume, send a GET request to
     * &#x60;/v2/volumes/$VOLUME_ID/snapshots&#x60;.
     *
     * @param volumeId The ID of the block storage volume. (required)
     * @param perPage  Number of items returned per page (optional, default to 20)
     * @param page     Which &#39;page&#39; of paginated results to return.
     *                 (optional, default to 1)
     * @return ApiResponse&lt;ListVolumeSnapshotsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListVolumeSnapshotsResponse> listVolumeSnapshotsWithHttpInfo(UUID volumeId, Integer perPage,
            Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listVolumeSnapshotsRequestBuilder(volumeId, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listVolumeSnapshots", localVarResponse);
                }
                return new ApiResponse<ListVolumeSnapshotsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListVolumeSnapshotsResponse>() {
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

    private HttpRequest.Builder listVolumeSnapshotsRequestBuilder(UUID volumeId, Integer perPage, Integer page) {
        // verify the required parameter 'volumeId' is set
        if (volumeId == null) {
            throw new ApiException(400, "Missing the required parameter 'volumeId' when calling listVolumeSnapshots");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/volumes/{volume_id}/snapshots".replace("{volume_id}",
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
}
