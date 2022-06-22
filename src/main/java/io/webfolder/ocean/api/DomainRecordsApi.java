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
import io.webfolder.ocean.model.CreateDomainRecordRequest;
import io.webfolder.ocean.model.CreateDomainRecordResponse;
import io.webfolder.ocean.model.DomainRecord;
import io.webfolder.ocean.model.GetDomainRecordResponse;
import io.webfolder.ocean.model.ListAllDomainRecordsResponse;

public class DomainRecordsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public DomainRecordsApi() {
        this(new ApiClient());
    }

    public DomainRecordsApi(ApiClient apiClient) {
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
     * Create a New Domain Record To create a new record to a domain, send a POST
     * request to &#x60;/v2/domains/$DOMAIN_NAME/records&#x60;. The request must
     * include all of the required fields for the domain record type being added.
     * See the [attribute table](#tag/Domain-Records) for details regarding record
     * types and their respective required attributes.
     *
     * @param domainName                The name of the domain itself. (required)
     * @param createDomainRecordRequest (optional)
     * @return CreateDomainRecordResponse
     * @throws ApiException if fails to make API call
     */
    public CreateDomainRecordResponse createDomainRecord(String domainName,
            CreateDomainRecordRequest createDomainRecordRequest) {
        ApiResponse<CreateDomainRecordResponse> localVarResponse = createDomainRecordWithHttpInfo(domainName,
                createDomainRecordRequest);
        return localVarResponse.getData();
    }

    /**
     * Create a New Domain Record To create a new record to a domain, send a POST
     * request to &#x60;/v2/domains/$DOMAIN_NAME/records&#x60;. The request must
     * include all of the required fields for the domain record type being added.
     * See the [attribute table](#tag/Domain-Records) for details regarding record
     * types and their respective required attributes.
     *
     * @param domainName                The name of the domain itself. (required)
     * @param createDomainRecordRequest (optional)
     * @return ApiResponse&lt;CreateDomainRecordResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateDomainRecordResponse> createDomainRecordWithHttpInfo(String domainName,
            CreateDomainRecordRequest createDomainRecordRequest) {
        HttpRequest.Builder localVarRequestBuilder = createDomainRecordRequestBuilder(domainName,
                createDomainRecordRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createDomainRecord", localVarResponse);
                }
                return new ApiResponse<CreateDomainRecordResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateDomainRecordResponse>() {
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

    private HttpRequest.Builder createDomainRecordRequestBuilder(String domainName,
            CreateDomainRecordRequest createDomainRecordRequest) {
        // verify the required parameter 'domainName' is set
        if (domainName == null) {
            throw new ApiException(400, "Missing the required parameter 'domainName' when calling createDomainRecord");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/domains/{domain_name}/records".replace("{domain_name}",
                ApiClient.urlEncode(domainName.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createDomainRecordRequest);
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
     * Delete a Domain Record To delete a record for a domain, send a DELETE request
     * to &#x60;/v2/domains/$DOMAIN_NAME/records/$DOMAIN_RECORD_ID&#x60;. The record
     * will be deleted and the response status will be a 204. This indicates a
     * successful request with no body returned.
     *
     * @param domainName     The name of the domain itself. (required)
     * @param domainRecordId The unique identifier of the domain record. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteDomainRecord(String domainName, Integer domainRecordId) {
        deleteDomainRecordWithHttpInfo(domainName, domainRecordId);
    }

    /**
     * Delete a Domain Record To delete a record for a domain, send a DELETE request
     * to &#x60;/v2/domains/$DOMAIN_NAME/records/$DOMAIN_RECORD_ID&#x60;. The record
     * will be deleted and the response status will be a 204. This indicates a
     * successful request with no body returned.
     *
     * @param domainName     The name of the domain itself. (required)
     * @param domainRecordId The unique identifier of the domain record. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteDomainRecordWithHttpInfo(String domainName, Integer domainRecordId) {
        HttpRequest.Builder localVarRequestBuilder = deleteDomainRecordRequestBuilder(domainName, domainRecordId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteDomainRecord", localVarResponse);
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

    private HttpRequest.Builder deleteDomainRecordRequestBuilder(String domainName, Integer domainRecordId) {
        // verify the required parameter 'domainName' is set
        if (domainName == null) {
            throw new ApiException(400, "Missing the required parameter 'domainName' when calling deleteDomainRecord");
        }
        // verify the required parameter 'domainRecordId' is set
        if (domainRecordId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'domainRecordId' when calling deleteDomainRecord");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/domains/{domain_name}/records/{domain_record_id}"
                .replace("{domain_name}", ApiClient.urlEncode(domainName.toString()))
                .replace("{domain_record_id}", ApiClient.urlEncode(domainRecordId.toString()));

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
     * Retrieve an Existing Domain Record To retrieve a specific domain record, send
     * a GET request to &#x60;/v2/domains/$DOMAIN_NAME/records/$RECORD_ID&#x60;.
     *
     * @param domainName     The name of the domain itself. (required)
     * @param domainRecordId The unique identifier of the domain record. (required)
     * @return GetDomainRecordResponse
     * @throws ApiException if fails to make API call
     */
    public GetDomainRecordResponse getDomainRecord(String domainName, Integer domainRecordId) {
        ApiResponse<GetDomainRecordResponse> localVarResponse = getDomainRecordWithHttpInfo(domainName, domainRecordId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Domain Record To retrieve a specific domain record, send
     * a GET request to &#x60;/v2/domains/$DOMAIN_NAME/records/$RECORD_ID&#x60;.
     *
     * @param domainName     The name of the domain itself. (required)
     * @param domainRecordId The unique identifier of the domain record. (required)
     * @return ApiResponse&lt;GetDomainRecordResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetDomainRecordResponse> getDomainRecordWithHttpInfo(String domainName, Integer domainRecordId) {
        HttpRequest.Builder localVarRequestBuilder = getDomainRecordRequestBuilder(domainName, domainRecordId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDomainRecord", localVarResponse);
                }
                return new ApiResponse<GetDomainRecordResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetDomainRecordResponse>() {
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

    private HttpRequest.Builder getDomainRecordRequestBuilder(String domainName, Integer domainRecordId) {
        // verify the required parameter 'domainName' is set
        if (domainName == null) {
            throw new ApiException(400, "Missing the required parameter 'domainName' when calling getDomainRecord");
        }
        // verify the required parameter 'domainRecordId' is set
        if (domainRecordId == null) {
            throw new ApiException(400, "Missing the required parameter 'domainRecordId' when calling getDomainRecord");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/domains/{domain_name}/records/{domain_record_id}"
                .replace("{domain_name}", ApiClient.urlEncode(domainName.toString()))
                .replace("{domain_record_id}", ApiClient.urlEncode(domainRecordId.toString()));

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
     * List All Domain Records To get a listing of all records configured for a
     * domain, send a GET request to &#x60;/v2/domains/$DOMAIN_NAME/records&#x60;.
     * The list of records returned can be filtered by using the &#x60;name&#x60;
     * and &#x60;type&#x60; query parameters. For example, to only include A records
     * for a domain, send a GET request to
     * &#x60;/v2/domains/$DOMAIN_NAME/records?type&#x3D;A&#x60;. &#x60;name&#x60;
     * must be a fully qualified record name. For example, to only include records
     * matching &#x60;sub.example.com&#x60;, send a GET request to
     * &#x60;/v2/domains/$DOMAIN_NAME/records?name&#x3D;sub.example.com&#x60;. Both
     * name and type may be used together.
     *
     * @param domainName The name of the domain itself. (required)
     * @param name       A fully qualified record name. For example, to only include
     *                   records matching sub.example.com, send a GET request to
     *                   &#x60;/v2/domains/$DOMAIN_NAME/records?name&#x3D;sub.example.com&#x60;.
     *                   (optional)
     * @param type       The type of the DNS record. For example: A, CNAME, TXT, ...
     *                   (optional)
     * @return ListAllDomainRecordsResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllDomainRecordsResponse listAllDomainRecords(String domainName, String name, String type) {
        ApiResponse<ListAllDomainRecordsResponse> localVarResponse = listAllDomainRecordsWithHttpInfo(domainName, name,
                type);
        return localVarResponse.getData();
    }

    /**
     * List All Domain Records To get a listing of all records configured for a
     * domain, send a GET request to &#x60;/v2/domains/$DOMAIN_NAME/records&#x60;.
     * The list of records returned can be filtered by using the &#x60;name&#x60;
     * and &#x60;type&#x60; query parameters. For example, to only include A records
     * for a domain, send a GET request to
     * &#x60;/v2/domains/$DOMAIN_NAME/records?type&#x3D;A&#x60;. &#x60;name&#x60;
     * must be a fully qualified record name. For example, to only include records
     * matching &#x60;sub.example.com&#x60;, send a GET request to
     * &#x60;/v2/domains/$DOMAIN_NAME/records?name&#x3D;sub.example.com&#x60;. Both
     * name and type may be used together.
     *
     * @param domainName The name of the domain itself. (required)
     * @param name       A fully qualified record name. For example, to only include
     *                   records matching sub.example.com, send a GET request to
     *                   &#x60;/v2/domains/$DOMAIN_NAME/records?name&#x3D;sub.example.com&#x60;.
     *                   (optional)
     * @param type       The type of the DNS record. For example: A, CNAME, TXT, ...
     *                   (optional)
     * @return ApiResponse&lt;ListAllDomainRecordsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllDomainRecordsResponse> listAllDomainRecordsWithHttpInfo(String domainName, String name,
            String type) {
        HttpRequest.Builder localVarRequestBuilder = listAllDomainRecordsRequestBuilder(domainName, name, type);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllDomainRecords", localVarResponse);
                }
                return new ApiResponse<ListAllDomainRecordsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllDomainRecordsResponse>() {
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

    private HttpRequest.Builder listAllDomainRecordsRequestBuilder(String domainName, String name, String type) {
        // verify the required parameter 'domainName' is set
        if (domainName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'domainName' when calling listAllDomainRecords");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/domains/{domain_name}/records".replace("{domain_name}",
                ApiClient.urlEncode(domainName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("name", name));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("type", type));

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
     * Update a Domain Record To update an existing record, send a PATCH request to
     * &#x60;/v2/domains/$DOMAIN_NAME/records/$DOMAIN_RECORD_ID&#x60;. Any attribute
     * valid for the record type can be set to a new value for the record. See the
     * [attribute table](#tag/Domain-Records) for details regarding record types and
     * their respective attributes.
     *
     * @param domainName     The name of the domain itself. (required)
     * @param domainRecordId The unique identifier of the domain record. (required)
     * @param domainRecord   (optional)
     * @return GetDomainRecordResponse
     * @throws ApiException if fails to make API call
     */
    public GetDomainRecordResponse patchUpdateDomainRecord(String domainName, Integer domainRecordId,
            DomainRecord domainRecord) {
        ApiResponse<GetDomainRecordResponse> localVarResponse = patchUpdateDomainRecordWithHttpInfo(domainName,
                domainRecordId, domainRecord);
        return localVarResponse.getData();
    }

    /**
     * Update a Domain Record To update an existing record, send a PATCH request to
     * &#x60;/v2/domains/$DOMAIN_NAME/records/$DOMAIN_RECORD_ID&#x60;. Any attribute
     * valid for the record type can be set to a new value for the record. See the
     * [attribute table](#tag/Domain-Records) for details regarding record types and
     * their respective attributes.
     *
     * @param domainName     The name of the domain itself. (required)
     * @param domainRecordId The unique identifier of the domain record. (required)
     * @param domainRecord   (optional)
     * @return ApiResponse&lt;GetDomainRecordResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetDomainRecordResponse> patchUpdateDomainRecordWithHttpInfo(String domainName,
            Integer domainRecordId, DomainRecord domainRecord) {
        HttpRequest.Builder localVarRequestBuilder = patchUpdateDomainRecordRequestBuilder(domainName, domainRecordId,
                domainRecord);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("patchUpdateDomainRecord", localVarResponse);
                }
                return new ApiResponse<GetDomainRecordResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetDomainRecordResponse>() {
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

    private HttpRequest.Builder patchUpdateDomainRecordRequestBuilder(String domainName, Integer domainRecordId,
            DomainRecord domainRecord) {
        // verify the required parameter 'domainName' is set
        if (domainName == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'domainName' when calling patchUpdateDomainRecord");
        }
        // verify the required parameter 'domainRecordId' is set
        if (domainRecordId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'domainRecordId' when calling patchUpdateDomainRecord");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/domains/{domain_name}/records/{domain_record_id}"
                .replace("{domain_name}", ApiClient.urlEncode(domainName.toString()))
                .replace("{domain_record_id}", ApiClient.urlEncode(domainRecordId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(domainRecord);
            localVarRequestBuilder.method("PATCH", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
     * Update a Domain Record To update an existing record, send a PUT request to
     * &#x60;/v2/domains/$DOMAIN_NAME/records/$DOMAIN_RECORD_ID&#x60;. Any attribute
     * valid for the record type can be set to a new value for the record. See the
     * [attribute table](#tag/Domain-Records) for details regarding record types and
     * their respective attributes.
     *
     * @param domainName     The name of the domain itself. (required)
     * @param domainRecordId The unique identifier of the domain record. (required)
     * @param domainRecord   (optional)
     * @return GetDomainRecordResponse
     * @throws ApiException if fails to make API call
     */
    public GetDomainRecordResponse updateDomainRecord(String domainName, Integer domainRecordId,
            DomainRecord domainRecord) {
        ApiResponse<GetDomainRecordResponse> localVarResponse = updateDomainRecordWithHttpInfo(domainName,
                domainRecordId, domainRecord);
        return localVarResponse.getData();
    }

    /**
     * Update a Domain Record To update an existing record, send a PUT request to
     * &#x60;/v2/domains/$DOMAIN_NAME/records/$DOMAIN_RECORD_ID&#x60;. Any attribute
     * valid for the record type can be set to a new value for the record. See the
     * [attribute table](#tag/Domain-Records) for details regarding record types and
     * their respective attributes.
     *
     * @param domainName     The name of the domain itself. (required)
     * @param domainRecordId The unique identifier of the domain record. (required)
     * @param domainRecord   (optional)
     * @return ApiResponse&lt;GetDomainRecordResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetDomainRecordResponse> updateDomainRecordWithHttpInfo(String domainName,
            Integer domainRecordId, DomainRecord domainRecord) {
        HttpRequest.Builder localVarRequestBuilder = updateDomainRecordRequestBuilder(domainName, domainRecordId,
                domainRecord);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateDomainRecord", localVarResponse);
                }
                return new ApiResponse<GetDomainRecordResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetDomainRecordResponse>() {
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

    private HttpRequest.Builder updateDomainRecordRequestBuilder(String domainName, Integer domainRecordId,
            DomainRecord domainRecord) {
        // verify the required parameter 'domainName' is set
        if (domainName == null) {
            throw new ApiException(400, "Missing the required parameter 'domainName' when calling updateDomainRecord");
        }
        // verify the required parameter 'domainRecordId' is set
        if (domainRecordId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'domainRecordId' when calling updateDomainRecord");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/domains/{domain_name}/records/{domain_record_id}"
                .replace("{domain_name}", ApiClient.urlEncode(domainName.toString()))
                .replace("{domain_record_id}", ApiClient.urlEncode(domainRecordId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(domainRecord);
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
