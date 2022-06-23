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

import io.webfolder.ocean.client.ApiClient;
import io.webfolder.ocean.client.ApiException;
import io.webfolder.ocean.client.ApiResponse;
import io.webfolder.ocean.client.internal.Pair;
import io.webfolder.ocean.model.GetSnapshotResponse;
import io.webfolder.ocean.model.GetSnapshotSnapshotIdParameter;
import io.webfolder.ocean.model.ListAllSnapshotsResponse;

public class SnapshotsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public SnapshotsApi() {
        this(new ApiClient());
    }

    public SnapshotsApi(ApiClient apiClient) {
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
     * Delete a Snapshot Both Droplet and volume snapshots are managed through the
     * &#x60;/v2/snapshots/&#x60; endpoint. To delete a snapshot, send a DELETE
     * request to &#x60;/v2/snapshots/$SNAPSHOT_ID&#x60;. A status of 204 will be
     * given. This indicates that the request was processed successfully, but that
     * no response body is needed.
     *
     * @param snapshotId Either the ID of an existing snapshot. This will be an
     *                   integer for a Droplet snapshot or a string for a volume
     *                   snapshot. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteSnapshot(GetSnapshotSnapshotIdParameter snapshotId) {
        deleteSnapshotWithHttpInfo(snapshotId);
    }

    /**
     * Delete a Snapshot Both Droplet and volume snapshots are managed through the
     * &#x60;/v2/snapshots/&#x60; endpoint. To delete a snapshot, send a DELETE
     * request to &#x60;/v2/snapshots/$SNAPSHOT_ID&#x60;. A status of 204 will be
     * given. This indicates that the request was processed successfully, but that
     * no response body is needed.
     *
     * @param snapshotId Either the ID of an existing snapshot. This will be an
     *                   integer for a Droplet snapshot or a string for a volume
     *                   snapshot. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteSnapshotWithHttpInfo(GetSnapshotSnapshotIdParameter snapshotId) {
        HttpRequest.Builder localVarRequestBuilder = deleteSnapshotRequestBuilder(snapshotId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteSnapshot", localVarResponse);
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

    private HttpRequest.Builder deleteSnapshotRequestBuilder(GetSnapshotSnapshotIdParameter snapshotId) {
        // verify the required parameter 'snapshotId' is set
        if (snapshotId == null) {
            throw new ApiException(400, "Missing the required parameter 'snapshotId' when calling deleteSnapshot");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/snapshots/{snapshot_id}".replace("{snapshot_id}",
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
     * Retrieve an Existing Snapshot To retrieve information about a snapshot, send
     * a GET request to &#x60;/v2/snapshots/$SNAPSHOT_ID&#x60;. The response will be
     * a JSON object with a key called &#x60;snapshot&#x60;. The value of this will
     * be an snapshot object containing the standard snapshot attributes.
     *
     * @param snapshotId Either the ID of an existing snapshot. This will be an
     *                   integer for a Droplet snapshot or a string for a volume
     *                   snapshot. (required)
     * @return GetSnapshotResponse
     * @throws ApiException if fails to make API call
     */
    public GetSnapshotResponse getSnapshot(GetSnapshotSnapshotIdParameter snapshotId) {
        ApiResponse<GetSnapshotResponse> localVarResponse = getSnapshotWithHttpInfo(snapshotId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Snapshot To retrieve information about a snapshot, send
     * a GET request to &#x60;/v2/snapshots/$SNAPSHOT_ID&#x60;. The response will be
     * a JSON object with a key called &#x60;snapshot&#x60;. The value of this will
     * be an snapshot object containing the standard snapshot attributes.
     *
     * @param snapshotId Either the ID of an existing snapshot. This will be an
     *                   integer for a Droplet snapshot or a string for a volume
     *                   snapshot. (required)
     * @return ApiResponse&lt;GetSnapshotResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetSnapshotResponse> getSnapshotWithHttpInfo(GetSnapshotSnapshotIdParameter snapshotId) {
        HttpRequest.Builder localVarRequestBuilder = getSnapshotRequestBuilder(snapshotId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getSnapshot", localVarResponse);
                }
                return new ApiResponse<GetSnapshotResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetSnapshotResponse>() {
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

    private HttpRequest.Builder getSnapshotRequestBuilder(GetSnapshotSnapshotIdParameter snapshotId) {
        // verify the required parameter 'snapshotId' is set
        if (snapshotId == null) {
            throw new ApiException(400, "Missing the required parameter 'snapshotId' when calling getSnapshot");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/snapshots/{snapshot_id}".replace("{snapshot_id}",
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
     * List All Snapshots To list all of the snapshots available on your account,
     * send a GET request to &#x60;/v2/snapshots&#x60;. The response will be a JSON
     * object with a key called &#x60;snapshots&#x60;. This will be set to an array
     * of &#x60;snapshot&#x60; objects, each of which will contain the standard
     * snapshot attributes. ### Filtering Results by Resource Type It&#39;s possible
     * to request filtered results by including certain query parameters. #### List
     * Droplet Snapshots To retrieve only snapshots based on Droplets, include the
     * &#x60;resource_type&#x60; query parameter set to &#x60;droplet&#x60;. For
     * example, &#x60;/v2/snapshots?resource_type&#x3D;droplet&#x60;. #### List
     * Volume Snapshots To retrieve only snapshots based on volumes, include the
     * &#x60;resource_type&#x60; query parameter set to &#x60;volume&#x60;. For
     * example, &#x60;/v2/snapshots?resource_type&#x3D;volume&#x60;.
     *
     * @param perPage      Number of items returned per page (optional, default to
     *                     20)
     * @param page         Which &#39;page&#39; of paginated results to return.
     *                     (optional, default to 1)
     * @param resourceType Used to filter snapshots by a resource type. (optional)
     * @return ListAllSnapshotsResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllSnapshotsResponse listAllSnapshots(Integer perPage, Integer page, String resourceType) {
        ApiResponse<ListAllSnapshotsResponse> localVarResponse = listAllSnapshotsWithHttpInfo(perPage, page,
                resourceType);
        return localVarResponse.getData();
    }

    /**
     * List All Snapshots To list all of the snapshots available on your account,
     * send a GET request to &#x60;/v2/snapshots&#x60;. The response will be a JSON
     * object with a key called &#x60;snapshots&#x60;. This will be set to an array
     * of &#x60;snapshot&#x60; objects, each of which will contain the standard
     * snapshot attributes. ### Filtering Results by Resource Type It&#39;s possible
     * to request filtered results by including certain query parameters. #### List
     * Droplet Snapshots To retrieve only snapshots based on Droplets, include the
     * &#x60;resource_type&#x60; query parameter set to &#x60;droplet&#x60;. For
     * example, &#x60;/v2/snapshots?resource_type&#x3D;droplet&#x60;. #### List
     * Volume Snapshots To retrieve only snapshots based on volumes, include the
     * &#x60;resource_type&#x60; query parameter set to &#x60;volume&#x60;. For
     * example, &#x60;/v2/snapshots?resource_type&#x3D;volume&#x60;.
     *
     * @param perPage      Number of items returned per page (optional, default to
     *                     20)
     * @param page         Which &#39;page&#39; of paginated results to return.
     *                     (optional, default to 1)
     * @param resourceType Used to filter snapshots by a resource type. (optional)
     * @return ApiResponse&lt;ListAllSnapshotsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllSnapshotsResponse> listAllSnapshotsWithHttpInfo(Integer perPage, Integer page,
            String resourceType) {
        HttpRequest.Builder localVarRequestBuilder = listAllSnapshotsRequestBuilder(perPage, page, resourceType);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllSnapshots", localVarResponse);
                }
                return new ApiResponse<ListAllSnapshotsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllSnapshotsResponse>() {
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

    private HttpRequest.Builder listAllSnapshotsRequestBuilder(Integer perPage, Integer page, String resourceType) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/snapshots";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("per_page", perPage));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("page", page));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("resource_type", resourceType));

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
