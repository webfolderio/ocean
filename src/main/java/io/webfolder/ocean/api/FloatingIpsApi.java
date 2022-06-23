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
import io.webfolder.ocean.model.CreateFloatingIpResponse;
import io.webfolder.ocean.model.FloatingIpCreate;
import io.webfolder.ocean.model.GetFloatingIpResponse;
import io.webfolder.ocean.model.ListFloatingIpsResponse;

public class FloatingIpsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public FloatingIpsApi() {
        this(new ApiClient());
    }

    public FloatingIpsApi(ApiClient apiClient) {
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
     * Create a New Floating IP On creation, a floating IP must be either assigned
     * to a Droplet or reserved to a region. * To create a new floating IP assigned
     * to a Droplet, send a POST request to &#x60;/v2/floating_ips&#x60; with the
     * &#x60;droplet_id&#x60; attribute. * To create a new floating IP reserved to a
     * region, send a POST request to &#x60;/v2/floating_ips&#x60; with the
     * &#x60;region&#x60; attribute. **Note**: In addition to the standard rate
     * limiting, only 12 floating IPs may be created per 60 seconds.
     *
     * @param floatingIpCreate (required)
     * @return CreateFloatingIpResponse
     * @throws ApiException if fails to make API call
     */
    public CreateFloatingIpResponse createFloatingIp(FloatingIpCreate floatingIpCreate) {
        ApiResponse<CreateFloatingIpResponse> localVarResponse = createFloatingIpWithHttpInfo(floatingIpCreate);
        return localVarResponse.getData();
    }

    /**
     * Create a New Floating IP On creation, a floating IP must be either assigned
     * to a Droplet or reserved to a region. * To create a new floating IP assigned
     * to a Droplet, send a POST request to &#x60;/v2/floating_ips&#x60; with the
     * &#x60;droplet_id&#x60; attribute. * To create a new floating IP reserved to a
     * region, send a POST request to &#x60;/v2/floating_ips&#x60; with the
     * &#x60;region&#x60; attribute. **Note**: In addition to the standard rate
     * limiting, only 12 floating IPs may be created per 60 seconds.
     *
     * @param floatingIpCreate (required)
     * @return ApiResponse&lt;CreateFloatingIpResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateFloatingIpResponse> createFloatingIpWithHttpInfo(FloatingIpCreate floatingIpCreate) {
        HttpRequest.Builder localVarRequestBuilder = createFloatingIpRequestBuilder(floatingIpCreate);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createFloatingIp", localVarResponse);
                }
                return new ApiResponse<CreateFloatingIpResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateFloatingIpResponse>() {
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

    private HttpRequest.Builder createFloatingIpRequestBuilder(FloatingIpCreate floatingIpCreate) {
        // verify the required parameter 'floatingIpCreate' is set
        if (floatingIpCreate == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'floatingIpCreate' when calling createFloatingIp");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/floating_ips";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(floatingIpCreate);
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
     * Delete a Floating IPs To delete a floating IP and remove it from your
     * account, send a DELETE request to
     * &#x60;/v2/floating_ips/$FLOATING_IP_ADDR&#x60;. A successful request will
     * receive a 204 status code with no body in response. This indicates that the
     * request was processed successfully.
     *
     * @param floatingIp A floating IP address. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteFloatingIp(String floatingIp) {
        deleteFloatingIpWithHttpInfo(floatingIp);
    }

    /**
     * Delete a Floating IPs To delete a floating IP and remove it from your
     * account, send a DELETE request to
     * &#x60;/v2/floating_ips/$FLOATING_IP_ADDR&#x60;. A successful request will
     * receive a 204 status code with no body in response. This indicates that the
     * request was processed successfully.
     *
     * @param floatingIp A floating IP address. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteFloatingIpWithHttpInfo(String floatingIp) {
        HttpRequest.Builder localVarRequestBuilder = deleteFloatingIpRequestBuilder(floatingIp);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteFloatingIp", localVarResponse);
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

    private HttpRequest.Builder deleteFloatingIpRequestBuilder(String floatingIp) {
        // verify the required parameter 'floatingIp' is set
        if (floatingIp == null) {
            throw new ApiException(400, "Missing the required parameter 'floatingIp' when calling deleteFloatingIp");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/floating_ips/{floating_ip}".replace("{floating_ip}",
                ApiClient.urlEncode(floatingIp.toString()));

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
     * Retrieve an Existing Floating IP To show information about a floating IP,
     * send a GET request to &#x60;/v2/floating_ips/$FLOATING_IP_ADDR&#x60;.
     *
     * @param floatingIp A floating IP address. (required)
     * @return GetFloatingIpResponse
     * @throws ApiException if fails to make API call
     */
    public GetFloatingIpResponse getFloatingIp(String floatingIp) {
        ApiResponse<GetFloatingIpResponse> localVarResponse = getFloatingIpWithHttpInfo(floatingIp);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Floating IP To show information about a floating IP,
     * send a GET request to &#x60;/v2/floating_ips/$FLOATING_IP_ADDR&#x60;.
     *
     * @param floatingIp A floating IP address. (required)
     * @return ApiResponse&lt;GetFloatingIpResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetFloatingIpResponse> getFloatingIpWithHttpInfo(String floatingIp) {
        HttpRequest.Builder localVarRequestBuilder = getFloatingIpRequestBuilder(floatingIp);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getFloatingIp", localVarResponse);
                }
                return new ApiResponse<GetFloatingIpResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetFloatingIpResponse>() {
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

    private HttpRequest.Builder getFloatingIpRequestBuilder(String floatingIp) {
        // verify the required parameter 'floatingIp' is set
        if (floatingIp == null) {
            throw new ApiException(400, "Missing the required parameter 'floatingIp' when calling getFloatingIp");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/floating_ips/{floating_ip}".replace("{floating_ip}",
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
     * List All Floating IPs To list all of the floating IPs available on your
     * account, send a GET request to &#x60;/v2/floating_ips&#x60;.
     *
     * @return ListFloatingIpsResponse
     * @throws ApiException if fails to make API call
     */
    public ListFloatingIpsResponse listFloatingIps() {
        ApiResponse<ListFloatingIpsResponse> localVarResponse = listFloatingIpsWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List All Floating IPs To list all of the floating IPs available on your
     * account, send a GET request to &#x60;/v2/floating_ips&#x60;.
     *
     * @return ApiResponse&lt;ListFloatingIpsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListFloatingIpsResponse> listFloatingIpsWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listFloatingIpsRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listFloatingIps", localVarResponse);
                }
                return new ApiResponse<ListFloatingIpsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListFloatingIpsResponse>() {
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

    private HttpRequest.Builder listFloatingIpsRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/floating_ips";

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
