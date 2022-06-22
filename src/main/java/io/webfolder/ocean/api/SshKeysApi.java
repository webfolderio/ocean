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
import io.webfolder.ocean.model.CreateSshKeyResponse;
import io.webfolder.ocean.model.GetSshKeySshKeyIdentifierParameter;
import io.webfolder.ocean.model.ListAllKeysResponse;
import io.webfolder.ocean.model.SshKey;
import io.webfolder.ocean.model.UpdateSshKeyRequest;

public class SshKeysApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public SshKeysApi() {
        this(new ApiClient());
    }

    public SshKeysApi(ApiClient apiClient) {
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
     * Create a New SSH Key To add a new SSH public key to your DigitalOcean
     * account, send a POST request to &#x60;/v2/account/keys&#x60;. Set the
     * &#x60;name&#x60; attribute to the name you wish to use and the
     * &#x60;public_key&#x60; attribute to the full public key you are adding.
     *
     * @param sshKey (required)
     * @return CreateSshKeyResponse
     * @throws ApiException if fails to make API call
     */
    public CreateSshKeyResponse createSshKey(SshKey sshKey) {
        ApiResponse<CreateSshKeyResponse> localVarResponse = createSshKeyWithHttpInfo(sshKey);
        return localVarResponse.getData();
    }

    /**
     * Create a New SSH Key To add a new SSH public key to your DigitalOcean
     * account, send a POST request to &#x60;/v2/account/keys&#x60;. Set the
     * &#x60;name&#x60; attribute to the name you wish to use and the
     * &#x60;public_key&#x60; attribute to the full public key you are adding.
     *
     * @param sshKey (required)
     * @return ApiResponse&lt;CreateSshKeyResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateSshKeyResponse> createSshKeyWithHttpInfo(SshKey sshKey) {
        HttpRequest.Builder localVarRequestBuilder = createSshKeyRequestBuilder(sshKey);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createSshKey", localVarResponse);
                }
                return new ApiResponse<CreateSshKeyResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateSshKeyResponse>() {
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

    private HttpRequest.Builder createSshKeyRequestBuilder(SshKey sshKey) {
        // verify the required parameter 'sshKey' is set
        if (sshKey == null) {
            throw new ApiException(400, "Missing the required parameter 'sshKey' when calling createSshKey");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/account/keys";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(sshKey);
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
     * Delete an SSH Key To destroy a public SSH key that you have in your account,
     * send a DELETE request to &#x60;/v2/account/keys/$KEY_ID&#x60; or
     * &#x60;/v2/account/keys/$KEY_FINGERPRINT&#x60;. A 204 status will be returned,
     * indicating that the action was successful and that the response body is
     * empty.
     *
     * @param sshKeyIdentifier Either the ID or the fingerprint of an existing SSH
     *                         key. (required)
     * @throws ApiException if fails to make API call
     */
    public void destroySshKey(GetSshKeySshKeyIdentifierParameter sshKeyIdentifier) {
        destroySshKeyWithHttpInfo(sshKeyIdentifier);
    }

    /**
     * Delete an SSH Key To destroy a public SSH key that you have in your account,
     * send a DELETE request to &#x60;/v2/account/keys/$KEY_ID&#x60; or
     * &#x60;/v2/account/keys/$KEY_FINGERPRINT&#x60;. A 204 status will be returned,
     * indicating that the action was successful and that the response body is
     * empty.
     *
     * @param sshKeyIdentifier Either the ID or the fingerprint of an existing SSH
     *                         key. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> destroySshKeyWithHttpInfo(GetSshKeySshKeyIdentifierParameter sshKeyIdentifier) {
        HttpRequest.Builder localVarRequestBuilder = destroySshKeyRequestBuilder(sshKeyIdentifier);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("destroySshKey", localVarResponse);
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

    private HttpRequest.Builder destroySshKeyRequestBuilder(GetSshKeySshKeyIdentifierParameter sshKeyIdentifier) {
        // verify the required parameter 'sshKeyIdentifier' is set
        if (sshKeyIdentifier == null) {
            throw new ApiException(400, "Missing the required parameter 'sshKeyIdentifier' when calling destroySshKey");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/account/keys/{ssh_key_identifier}".replace("{ssh_key_identifier}",
                ApiClient.urlEncode(sshKeyIdentifier.toString()));

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
     * Retrieve an Existing SSH Key To get information about a key, send a GET
     * request to &#x60;/v2/account/keys/$KEY_ID&#x60; or
     * &#x60;/v2/account/keys/$KEY_FINGERPRINT&#x60;. The response will be a JSON
     * object with the key &#x60;ssh_key&#x60; and value an ssh_key object which
     * contains the standard ssh_key attributes.
     *
     * @param sshKeyIdentifier Either the ID or the fingerprint of an existing SSH
     *                         key. (required)
     * @return CreateSshKeyResponse
     * @throws ApiException if fails to make API call
     */
    public CreateSshKeyResponse getSshKey(GetSshKeySshKeyIdentifierParameter sshKeyIdentifier) {
        ApiResponse<CreateSshKeyResponse> localVarResponse = getSshKeyWithHttpInfo(sshKeyIdentifier);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing SSH Key To get information about a key, send a GET
     * request to &#x60;/v2/account/keys/$KEY_ID&#x60; or
     * &#x60;/v2/account/keys/$KEY_FINGERPRINT&#x60;. The response will be a JSON
     * object with the key &#x60;ssh_key&#x60; and value an ssh_key object which
     * contains the standard ssh_key attributes.
     *
     * @param sshKeyIdentifier Either the ID or the fingerprint of an existing SSH
     *                         key. (required)
     * @return ApiResponse&lt;CreateSshKeyResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateSshKeyResponse> getSshKeyWithHttpInfo(
            GetSshKeySshKeyIdentifierParameter sshKeyIdentifier) {
        HttpRequest.Builder localVarRequestBuilder = getSshKeyRequestBuilder(sshKeyIdentifier);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getSshKey", localVarResponse);
                }
                return new ApiResponse<CreateSshKeyResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateSshKeyResponse>() {
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

    private HttpRequest.Builder getSshKeyRequestBuilder(GetSshKeySshKeyIdentifierParameter sshKeyIdentifier) {
        // verify the required parameter 'sshKeyIdentifier' is set
        if (sshKeyIdentifier == null) {
            throw new ApiException(400, "Missing the required parameter 'sshKeyIdentifier' when calling getSshKey");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/account/keys/{ssh_key_identifier}".replace("{ssh_key_identifier}",
                ApiClient.urlEncode(sshKeyIdentifier.toString()));

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
     * List All SSH Keys To list all of the keys in your account, send a GET request
     * to &#x60;/v2/account/keys&#x60;. The response will be a JSON object with a
     * key set to &#x60;ssh_keys&#x60;. The value of this will be an array of
     * ssh_key objects, each of which contains the standard ssh_key attributes.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ListAllKeysResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllKeysResponse listAllKeys(Integer perPage, Integer page) {
        ApiResponse<ListAllKeysResponse> localVarResponse = listAllKeysWithHttpInfo(perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All SSH Keys To list all of the keys in your account, send a GET request
     * to &#x60;/v2/account/keys&#x60;. The response will be a JSON object with a
     * key set to &#x60;ssh_keys&#x60;. The value of this will be an array of
     * ssh_key objects, each of which contains the standard ssh_key attributes.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ApiResponse&lt;ListAllKeysResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllKeysResponse> listAllKeysWithHttpInfo(Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listAllKeysRequestBuilder(perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllKeys", localVarResponse);
                }
                return new ApiResponse<ListAllKeysResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllKeysResponse>() {
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

    private HttpRequest.Builder listAllKeysRequestBuilder(Integer perPage, Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/account/keys";

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
     * Update an SSH Key&#39;s Name To update the name of an SSH key, send a PUT
     * request to either &#x60;/v2/account/keys/$SSH_KEY_ID&#x60; or
     * &#x60;/v2/account/keys/$SSH_KEY_FINGERPRINT&#x60;. Set the &#x60;name&#x60;
     * attribute to the new name you want to use.
     *
     * @param sshKeyIdentifier    Either the ID or the fingerprint of an existing
     *                            SSH key. (required)
     * @param updateSshKeyRequest Set the &#x60;name&#x60; attribute to the new name
     *                            you want to use. (required)
     * @return CreateSshKeyResponse
     * @throws ApiException if fails to make API call
     */
    public CreateSshKeyResponse updateSshKey(GetSshKeySshKeyIdentifierParameter sshKeyIdentifier,
            UpdateSshKeyRequest updateSshKeyRequest) {
        ApiResponse<CreateSshKeyResponse> localVarResponse = updateSshKeyWithHttpInfo(sshKeyIdentifier,
                updateSshKeyRequest);
        return localVarResponse.getData();
    }

    /**
     * Update an SSH Key&#39;s Name To update the name of an SSH key, send a PUT
     * request to either &#x60;/v2/account/keys/$SSH_KEY_ID&#x60; or
     * &#x60;/v2/account/keys/$SSH_KEY_FINGERPRINT&#x60;. Set the &#x60;name&#x60;
     * attribute to the new name you want to use.
     *
     * @param sshKeyIdentifier    Either the ID or the fingerprint of an existing
     *                            SSH key. (required)
     * @param updateSshKeyRequest Set the &#x60;name&#x60; attribute to the new name
     *                            you want to use. (required)
     * @return ApiResponse&lt;CreateSshKeyResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateSshKeyResponse> updateSshKeyWithHttpInfo(
            GetSshKeySshKeyIdentifierParameter sshKeyIdentifier, UpdateSshKeyRequest updateSshKeyRequest) {
        HttpRequest.Builder localVarRequestBuilder = updateSshKeyRequestBuilder(sshKeyIdentifier, updateSshKeyRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateSshKey", localVarResponse);
                }
                return new ApiResponse<CreateSshKeyResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateSshKeyResponse>() {
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

    private HttpRequest.Builder updateSshKeyRequestBuilder(GetSshKeySshKeyIdentifierParameter sshKeyIdentifier,
            UpdateSshKeyRequest updateSshKeyRequest) {
        // verify the required parameter 'sshKeyIdentifier' is set
        if (sshKeyIdentifier == null) {
            throw new ApiException(400, "Missing the required parameter 'sshKeyIdentifier' when calling updateSshKey");
        }
        // verify the required parameter 'updateSshKeyRequest' is set
        if (updateSshKeyRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'updateSshKeyRequest' when calling updateSshKey");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/account/keys/{ssh_key_identifier}".replace("{ssh_key_identifier}",
                ApiClient.urlEncode(sshKeyIdentifier.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateSshKeyRequest);
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
