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

import io.webfolder.ocean.ApiClient;
import io.webfolder.ocean.ApiException;
import io.webfolder.ocean.ApiResponse;
import io.webfolder.ocean.model.CreateDomainResponse;
import io.webfolder.ocean.model.Domain;
import io.webfolder.ocean.model.GetDomainResponse;
import io.webfolder.ocean.model.ListAllDomainsResponse;

public class DomainsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public DomainsApi() {
        this(new ApiClient());
    }

    public DomainsApi(ApiClient apiClient) {
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
     * Create a New Domain To create a new domain, send a POST request to
     * &#x60;/v2/domains&#x60;. Set the \&quot;name\&quot; attribute to the domain
     * name you are adding. Optionally, you may set the \&quot;ip_address\&quot;
     * attribute, and an A record will be automatically created pointing to the apex
     * domain.
     *
     * @param domain (optional)
     * @return CreateDomainResponse
     * @throws ApiException if fails to make API call
     */
    public CreateDomainResponse createDomain(Domain domain) {
        ApiResponse<CreateDomainResponse> localVarResponse = createDomainWithHttpInfo(domain);
        return localVarResponse.getData();
    }

    /**
     * Create a New Domain To create a new domain, send a POST request to
     * &#x60;/v2/domains&#x60;. Set the \&quot;name\&quot; attribute to the domain
     * name you are adding. Optionally, you may set the \&quot;ip_address\&quot;
     * attribute, and an A record will be automatically created pointing to the apex
     * domain.
     *
     * @param domain (optional)
     * @return ApiResponse&lt;CreateDomainResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateDomainResponse> createDomainWithHttpInfo(Domain domain) {
        HttpRequest.Builder localVarRequestBuilder = createDomainRequestBuilder(domain);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createDomain", localVarResponse);
                }
                return new ApiResponse<CreateDomainResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateDomainResponse>() {
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

    private HttpRequest.Builder createDomainRequestBuilder(Domain domain) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/domains";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(domain);
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
     * Delete a Domain To delete a domain, send a DELETE request to
     * &#x60;/v2/domains/$DOMAIN_NAME&#x60;.
     *
     * @param domainName The name of the domain itself. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteDomain(String domainName) {
        deleteDomainWithHttpInfo(domainName);
    }

    /**
     * Delete a Domain To delete a domain, send a DELETE request to
     * &#x60;/v2/domains/$DOMAIN_NAME&#x60;.
     *
     * @param domainName The name of the domain itself. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteDomainWithHttpInfo(String domainName) {
        HttpRequest.Builder localVarRequestBuilder = deleteDomainRequestBuilder(domainName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteDomain", localVarResponse);
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

    private HttpRequest.Builder deleteDomainRequestBuilder(String domainName) {
        // verify the required parameter 'domainName' is set
        if (domainName == null) {
            throw new ApiException(400, "Missing the required parameter 'domainName' when calling deleteDomain");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/domains/{domain_name}".replace("{domain_name}",
                ApiClient.urlEncode(domainName.toString()));

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
     * Retrieve an Existing Domain To get details about a specific domain, send a
     * GET request to &#x60;/v2/domains/$DOMAIN_NAME&#x60;.
     *
     * @param domainName The name of the domain itself. (required)
     * @return GetDomainResponse
     * @throws ApiException if fails to make API call
     */
    public GetDomainResponse getDomain(String domainName) {
        ApiResponse<GetDomainResponse> localVarResponse = getDomainWithHttpInfo(domainName);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Domain To get details about a specific domain, send a
     * GET request to &#x60;/v2/domains/$DOMAIN_NAME&#x60;.
     *
     * @param domainName The name of the domain itself. (required)
     * @return ApiResponse&lt;GetDomainResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetDomainResponse> getDomainWithHttpInfo(String domainName) {
        HttpRequest.Builder localVarRequestBuilder = getDomainRequestBuilder(domainName);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDomain", localVarResponse);
                }
                return new ApiResponse<GetDomainResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetDomainResponse>() {
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

    private HttpRequest.Builder getDomainRequestBuilder(String domainName) {
        // verify the required parameter 'domainName' is set
        if (domainName == null) {
            throw new ApiException(400, "Missing the required parameter 'domainName' when calling getDomain");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/domains/{domain_name}".replace("{domain_name}",
                ApiClient.urlEncode(domainName.toString()));

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
     * List All Domains To retrieve a list of all of the domains in your account,
     * send a GET request to &#x60;/v2/domains&#x60;.
     *
     * @return ListAllDomainsResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllDomainsResponse listAllDomains() {
        ApiResponse<ListAllDomainsResponse> localVarResponse = listAllDomainsWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List All Domains To retrieve a list of all of the domains in your account,
     * send a GET request to &#x60;/v2/domains&#x60;.
     *
     * @return ApiResponse&lt;ListAllDomainsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllDomainsResponse> listAllDomainsWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listAllDomainsRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllDomains", localVarResponse);
                }
                return new ApiResponse<ListAllDomainsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllDomainsResponse>() {
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

    private HttpRequest.Builder listAllDomainsRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/domains";

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
