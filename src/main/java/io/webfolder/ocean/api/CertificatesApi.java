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
import io.webfolder.ocean.model.CreateCertificatesRequest;
import io.webfolder.ocean.model.CreateCertificatesResponse;
import io.webfolder.ocean.model.ListCertificatesResponse;

public class CertificatesApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public CertificatesApi() {
        this(new ApiClient());
    }

    public CertificatesApi(ApiClient apiClient) {
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
     * Create a New Certificate To upload new SSL certificate which you have
     * previously generated, send a POST request to &#x60;/v2/certificates&#x60;.
     * When uploading a user-generated certificate, the &#x60;private_key&#x60;,
     * &#x60;leaf_certificate&#x60;, and optionally the
     * &#x60;certificate_chain&#x60; attributes should be provided. The type must be
     * set to &#x60;custom&#x60;. When using Let&#39;s Encrypt to create a
     * certificate, the &#x60;dns_names&#x60; attribute must be provided, and the
     * type must be set to &#x60;lets_encrypt&#x60;.
     *
     * @param createCertificatesRequest (required)
     * @return CreateCertificatesResponse
     * @throws ApiException if fails to make API call
     */
    public CreateCertificatesResponse createCertificates(CreateCertificatesRequest createCertificatesRequest) {
        ApiResponse<CreateCertificatesResponse> localVarResponse = createCertificatesWithHttpInfo(
                createCertificatesRequest);
        return localVarResponse.getData();
    }

    /**
     * Create a New Certificate To upload new SSL certificate which you have
     * previously generated, send a POST request to &#x60;/v2/certificates&#x60;.
     * When uploading a user-generated certificate, the &#x60;private_key&#x60;,
     * &#x60;leaf_certificate&#x60;, and optionally the
     * &#x60;certificate_chain&#x60; attributes should be provided. The type must be
     * set to &#x60;custom&#x60;. When using Let&#39;s Encrypt to create a
     * certificate, the &#x60;dns_names&#x60; attribute must be provided, and the
     * type must be set to &#x60;lets_encrypt&#x60;.
     *
     * @param createCertificatesRequest (required)
     * @return ApiResponse&lt;CreateCertificatesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateCertificatesResponse> createCertificatesWithHttpInfo(
            CreateCertificatesRequest createCertificatesRequest) {
        HttpRequest.Builder localVarRequestBuilder = createCertificatesRequestBuilder(createCertificatesRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createCertificates", localVarResponse);
                }
                return new ApiResponse<CreateCertificatesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateCertificatesResponse>() {
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

    private HttpRequest.Builder createCertificatesRequestBuilder(CreateCertificatesRequest createCertificatesRequest) {
        // verify the required parameter 'createCertificatesRequest' is set
        if (createCertificatesRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'createCertificatesRequest' when calling createCertificates");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/certificates";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createCertificatesRequest);
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
     * Delete a Certificate To delete a specific certificate, send a DELETE request
     * to &#x60;/v2/certificates/$CERTIFICATE_ID&#x60;.
     *
     * @param certificateId A unique identifier for a certificate. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteCertificate(UUID certificateId) {
        deleteCertificateWithHttpInfo(certificateId);
    }

    /**
     * Delete a Certificate To delete a specific certificate, send a DELETE request
     * to &#x60;/v2/certificates/$CERTIFICATE_ID&#x60;.
     *
     * @param certificateId A unique identifier for a certificate. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteCertificateWithHttpInfo(UUID certificateId) {
        HttpRequest.Builder localVarRequestBuilder = deleteCertificateRequestBuilder(certificateId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteCertificate", localVarResponse);
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

    private HttpRequest.Builder deleteCertificateRequestBuilder(UUID certificateId) {
        // verify the required parameter 'certificateId' is set
        if (certificateId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'certificateId' when calling deleteCertificate");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/certificates/{certificate_id}".replace("{certificate_id}",
                ApiClient.urlEncode(certificateId.toString()));

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
     * Retrieve an Existing Certificate To show information about an existing
     * certificate, send a GET request to
     * &#x60;/v2/certificates/$CERTIFICATE_ID&#x60;.
     *
     * @param certificateId A unique identifier for a certificate. (required)
     * @return CreateCertificatesResponse
     * @throws ApiException if fails to make API call
     */
    public CreateCertificatesResponse getCertificate(UUID certificateId) {
        ApiResponse<CreateCertificatesResponse> localVarResponse = getCertificateWithHttpInfo(certificateId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Certificate To show information about an existing
     * certificate, send a GET request to
     * &#x60;/v2/certificates/$CERTIFICATE_ID&#x60;.
     *
     * @param certificateId A unique identifier for a certificate. (required)
     * @return ApiResponse&lt;CreateCertificatesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateCertificatesResponse> getCertificateWithHttpInfo(UUID certificateId) {
        HttpRequest.Builder localVarRequestBuilder = getCertificateRequestBuilder(certificateId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getCertificate", localVarResponse);
                }
                return new ApiResponse<CreateCertificatesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateCertificatesResponse>() {
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

    private HttpRequest.Builder getCertificateRequestBuilder(UUID certificateId) {
        // verify the required parameter 'certificateId' is set
        if (certificateId == null) {
            throw new ApiException(400, "Missing the required parameter 'certificateId' when calling getCertificate");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/certificates/{certificate_id}".replace("{certificate_id}",
                ApiClient.urlEncode(certificateId.toString()));

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
     * List All Certificates To list all of the certificates available on your
     * account, send a GET request to &#x60;/v2/certificates&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ListCertificatesResponse
     * @throws ApiException if fails to make API call
     */
    public ListCertificatesResponse listCertificates(Integer perPage, Integer page) {
        ApiResponse<ListCertificatesResponse> localVarResponse = listCertificatesWithHttpInfo(perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All Certificates To list all of the certificates available on your
     * account, send a GET request to &#x60;/v2/certificates&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ApiResponse&lt;ListCertificatesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListCertificatesResponse> listCertificatesWithHttpInfo(Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listCertificatesRequestBuilder(perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listCertificates", localVarResponse);
                }
                return new ApiResponse<ListCertificatesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListCertificatesResponse>() {
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

    private HttpRequest.Builder listCertificatesRequestBuilder(Integer perPage, Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/certificates";

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
