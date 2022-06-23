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
import io.webfolder.ocean.model.CreateReservedIpResponse;
import io.webfolder.ocean.model.GetReservedIpResponse;
import io.webfolder.ocean.model.ListReservedIpsResponse;
import io.webfolder.ocean.model.ReservedIpCreate;

public class ReservedIpsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public ReservedIpsApi() {
        this(new ApiClient());
    }

    public ReservedIpsApi(ApiClient apiClient) {
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
     * Create a New Reserved IP On creation, a reserved IP must be either assigned
     * to a Droplet or reserved to a region. * To create a new reserved IP assigned
     * to a Droplet, send a POST request to &#x60;/v2/reserved_ips&#x60; with the
     * &#x60;droplet_id&#x60; attribute. * To create a new reserved IP reserved to a
     * region, send a POST request to &#x60;/v2/reserved_ips&#x60; with the
     * &#x60;region&#x60; attribute. **Note**: In addition to the standard rate
     * limiting, only 12 reserved IPs may be created per 60 seconds.
     *
     * @param reservedIpCreate (required)
     * @return CreateReservedIpResponse
     * @throws ApiException if fails to make API call
     */
    public CreateReservedIpResponse createReservedIp(ReservedIpCreate reservedIpCreate) {
        ApiResponse<CreateReservedIpResponse> localVarResponse = createReservedIpWithHttpInfo(reservedIpCreate);
        return localVarResponse.getData();
    }

    /**
     * Create a New Reserved IP On creation, a reserved IP must be either assigned
     * to a Droplet or reserved to a region. * To create a new reserved IP assigned
     * to a Droplet, send a POST request to &#x60;/v2/reserved_ips&#x60; with the
     * &#x60;droplet_id&#x60; attribute. * To create a new reserved IP reserved to a
     * region, send a POST request to &#x60;/v2/reserved_ips&#x60; with the
     * &#x60;region&#x60; attribute. **Note**: In addition to the standard rate
     * limiting, only 12 reserved IPs may be created per 60 seconds.
     *
     * @param reservedIpCreate (required)
     * @return ApiResponse&lt;CreateReservedIpResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateReservedIpResponse> createReservedIpWithHttpInfo(ReservedIpCreate reservedIpCreate) {
        HttpRequest.Builder localVarRequestBuilder = createReservedIpRequestBuilder(reservedIpCreate);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createReservedIp", localVarResponse);
                }
                return new ApiResponse<CreateReservedIpResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateReservedIpResponse>() {
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

    private HttpRequest.Builder createReservedIpRequestBuilder(ReservedIpCreate reservedIpCreate) {
        // verify the required parameter 'reservedIpCreate' is set
        if (reservedIpCreate == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'reservedIpCreate' when calling createReservedIp");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/reserved_ips";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(reservedIpCreate);
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
     * Delete a Reserved IPs To delete a reserved IP and remove it from your
     * account, send a DELETE request to
     * &#x60;/v2/reserved_ips/$RESERVED_IP_ADDR&#x60;. A successful request will
     * receive a 204 status code with no body in response. This indicates that the
     * request was processed successfully.
     *
     * @param reservedIp A reserved IP address. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteReservedIp(String reservedIp) {
        deleteReservedIpWithHttpInfo(reservedIp);
    }

    /**
     * Delete a Reserved IPs To delete a reserved IP and remove it from your
     * account, send a DELETE request to
     * &#x60;/v2/reserved_ips/$RESERVED_IP_ADDR&#x60;. A successful request will
     * receive a 204 status code with no body in response. This indicates that the
     * request was processed successfully.
     *
     * @param reservedIp A reserved IP address. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteReservedIpWithHttpInfo(String reservedIp) {
        HttpRequest.Builder localVarRequestBuilder = deleteReservedIpRequestBuilder(reservedIp);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteReservedIp", localVarResponse);
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

    private HttpRequest.Builder deleteReservedIpRequestBuilder(String reservedIp) {
        // verify the required parameter 'reservedIp' is set
        if (reservedIp == null) {
            throw new ApiException(400, "Missing the required parameter 'reservedIp' when calling deleteReservedIp");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/reserved_ips/{reserved_ip}".replace("{reserved_ip}",
                ApiClient.urlEncode(reservedIp.toString()));

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
     * Retrieve an Existing Reserved IP To show information about a reserved IP,
     * send a GET request to &#x60;/v2/reserved_ips/$RESERVED_IP_ADDR&#x60;.
     *
     * @param reservedIp A reserved IP address. (required)
     * @return GetReservedIpResponse
     * @throws ApiException if fails to make API call
     */
    public GetReservedIpResponse getReservedIp(String reservedIp) {
        ApiResponse<GetReservedIpResponse> localVarResponse = getReservedIpWithHttpInfo(reservedIp);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Reserved IP To show information about a reserved IP,
     * send a GET request to &#x60;/v2/reserved_ips/$RESERVED_IP_ADDR&#x60;.
     *
     * @param reservedIp A reserved IP address. (required)
     * @return ApiResponse&lt;GetReservedIpResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetReservedIpResponse> getReservedIpWithHttpInfo(String reservedIp) {
        HttpRequest.Builder localVarRequestBuilder = getReservedIpRequestBuilder(reservedIp);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getReservedIp", localVarResponse);
                }
                return new ApiResponse<GetReservedIpResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetReservedIpResponse>() {
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

    private HttpRequest.Builder getReservedIpRequestBuilder(String reservedIp) {
        // verify the required parameter 'reservedIp' is set
        if (reservedIp == null) {
            throw new ApiException(400, "Missing the required parameter 'reservedIp' when calling getReservedIp");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/reserved_ips/{reserved_ip}".replace("{reserved_ip}",
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
     * List All Reserved IPs To list all of the reserved IPs available on your
     * account, send a GET request to &#x60;/v2/reserved_ips&#x60;.
     *
     * @return ListReservedIpsResponse
     * @throws ApiException if fails to make API call
     */
    public ListReservedIpsResponse listReservedIps() {
        ApiResponse<ListReservedIpsResponse> localVarResponse = listReservedIpsWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List All Reserved IPs To list all of the reserved IPs available on your
     * account, send a GET request to &#x60;/v2/reserved_ips&#x60;.
     *
     * @return ApiResponse&lt;ListReservedIpsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListReservedIpsResponse> listReservedIpsWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listReservedIpsRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listReservedIps", localVarResponse);
                }
                return new ApiResponse<ListReservedIpsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListReservedIpsResponse>() {
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

    private HttpRequest.Builder listReservedIpsRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/reserved_ips";

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
}
