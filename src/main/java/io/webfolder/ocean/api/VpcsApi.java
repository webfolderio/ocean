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

import io.webfolder.ocean.client.ApiClient;
import io.webfolder.ocean.client.ApiException;
import io.webfolder.ocean.client.ApiResponse;
import io.webfolder.ocean.client.internal.Pair;
import io.webfolder.ocean.model.CreateVpcRequest;
import io.webfolder.ocean.model.CreateVpcResponse;
import io.webfolder.ocean.model.ListVpcMembersResponse;
import io.webfolder.ocean.model.ListVpcsResponse;
import io.webfolder.ocean.model.PatchVpcRequest;
import io.webfolder.ocean.model.UpdateVpcRequest;

public class VpcsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public VpcsApi() {
        this(new ApiClient());
    }

    public VpcsApi(ApiClient apiClient) {
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
     * Create a New VPC To create a VPC, send a POST request to &#x60;/v2/vpcs&#x60;
     * specifying the attributes in the table below in the JSON body. **Note:** If
     * you do not currently have a VPC network in a specific datacenter region, the
     * first one that you create will be set as the default for that region. The
     * default VPC for a region cannot be changed or deleted.
     *
     * @param createVpcRequest (required)
     * @return CreateVpcResponse
     * @throws ApiException if fails to make API call
     */
    public CreateVpcResponse createVpc(CreateVpcRequest createVpcRequest) {
        ApiResponse<CreateVpcResponse> localVarResponse = createVpcWithHttpInfo(createVpcRequest);
        return localVarResponse.getData();
    }

    /**
     * Create a New VPC To create a VPC, send a POST request to &#x60;/v2/vpcs&#x60;
     * specifying the attributes in the table below in the JSON body. **Note:** If
     * you do not currently have a VPC network in a specific datacenter region, the
     * first one that you create will be set as the default for that region. The
     * default VPC for a region cannot be changed or deleted.
     *
     * @param createVpcRequest (required)
     * @return ApiResponse&lt;CreateVpcResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateVpcResponse> createVpcWithHttpInfo(CreateVpcRequest createVpcRequest) {
        HttpRequest.Builder localVarRequestBuilder = createVpcRequestBuilder(createVpcRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createVpc", localVarResponse);
                }
                return new ApiResponse<CreateVpcResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateVpcResponse>() {
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

    private HttpRequest.Builder createVpcRequestBuilder(CreateVpcRequest createVpcRequest) {
        // verify the required parameter 'createVpcRequest' is set
        if (createVpcRequest == null) {
            throw new ApiException(400, "Missing the required parameter 'createVpcRequest' when calling createVpc");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/vpcs";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createVpcRequest);
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
     * Delete a VPC To delete a VPC, send a DELETE request to
     * &#x60;/v2/vpcs/$VPC_ID&#x60;. A 204 status code with no body will be returned
     * in response to a successful request. The default VPC for a region can not be
     * deleted. Additionally, a VPC can only be deleted if it does not contain any
     * member resources. Attempting to delete a region&#39;s default VPC or a VPC
     * that still has members will result in a 403 Forbidden error response.
     *
     * @param vpcId A unique identifier for a VPC. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteVpc(UUID vpcId) {
        deleteVpcWithHttpInfo(vpcId);
    }

    /**
     * Delete a VPC To delete a VPC, send a DELETE request to
     * &#x60;/v2/vpcs/$VPC_ID&#x60;. A 204 status code with no body will be returned
     * in response to a successful request. The default VPC for a region can not be
     * deleted. Additionally, a VPC can only be deleted if it does not contain any
     * member resources. Attempting to delete a region&#39;s default VPC or a VPC
     * that still has members will result in a 403 Forbidden error response.
     *
     * @param vpcId A unique identifier for a VPC. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteVpcWithHttpInfo(UUID vpcId) {
        HttpRequest.Builder localVarRequestBuilder = deleteVpcRequestBuilder(vpcId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteVpc", localVarResponse);
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

    private HttpRequest.Builder deleteVpcRequestBuilder(UUID vpcId) {
        // verify the required parameter 'vpcId' is set
        if (vpcId == null) {
            throw new ApiException(400, "Missing the required parameter 'vpcId' when calling deleteVpc");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/vpcs/{vpc_id}".replace("{vpc_id}", ApiClient.urlEncode(vpcId.toString()));

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
     * Retrieve an Existing VPC To show information about an existing VPC, send a
     * GET request to &#x60;/v2/vpcs/$VPC_ID&#x60;.
     *
     * @param vpcId A unique identifier for a VPC. (required)
     * @return CreateVpcResponse
     * @throws ApiException if fails to make API call
     */
    public CreateVpcResponse getVpc(UUID vpcId) {
        ApiResponse<CreateVpcResponse> localVarResponse = getVpcWithHttpInfo(vpcId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing VPC To show information about an existing VPC, send a
     * GET request to &#x60;/v2/vpcs/$VPC_ID&#x60;.
     *
     * @param vpcId A unique identifier for a VPC. (required)
     * @return ApiResponse&lt;CreateVpcResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateVpcResponse> getVpcWithHttpInfo(UUID vpcId) {
        HttpRequest.Builder localVarRequestBuilder = getVpcRequestBuilder(vpcId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getVpc", localVarResponse);
                }
                return new ApiResponse<CreateVpcResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateVpcResponse>() {
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

    private HttpRequest.Builder getVpcRequestBuilder(UUID vpcId) {
        // verify the required parameter 'vpcId' is set
        if (vpcId == null) {
            throw new ApiException(400, "Missing the required parameter 'vpcId' when calling getVpc");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/vpcs/{vpc_id}".replace("{vpc_id}", ApiClient.urlEncode(vpcId.toString()));

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
     * List the Member Resources of a VPC To list all of the resources that are
     * members of a VPC, send a GET request to &#x60;/v2/vpcs/$VPC_ID/members&#x60;.
     * To only list resources of a specific type that are members of the VPC,
     * included a &#x60;resource_type&#x60; query parameter. For example, to only
     * list Droplets in the VPC, send a GET request to
     * &#x60;/v2/vpcs/$VPC_ID/members?resource_type&#x3D;droplet&#x60;.
     *
     * @param vpcId        A unique identifier for a VPC. (required)
     * @param resourceType Used to filter VPC members by a resource type. (optional)
     * @param perPage      Number of items returned per page (optional, default to
     *                     20)
     * @param page         Which &#39;page&#39; of paginated results to return.
     *                     (optional, default to 1)
     * @return ListVpcMembersResponse
     * @throws ApiException if fails to make API call
     */
    public ListVpcMembersResponse listVpcMembers(UUID vpcId, String resourceType, Integer perPage, Integer page) {
        ApiResponse<ListVpcMembersResponse> localVarResponse = listVpcMembersWithHttpInfo(vpcId, resourceType, perPage,
                page);
        return localVarResponse.getData();
    }

    /**
     * List the Member Resources of a VPC To list all of the resources that are
     * members of a VPC, send a GET request to &#x60;/v2/vpcs/$VPC_ID/members&#x60;.
     * To only list resources of a specific type that are members of the VPC,
     * included a &#x60;resource_type&#x60; query parameter. For example, to only
     * list Droplets in the VPC, send a GET request to
     * &#x60;/v2/vpcs/$VPC_ID/members?resource_type&#x3D;droplet&#x60;.
     *
     * @param vpcId        A unique identifier for a VPC. (required)
     * @param resourceType Used to filter VPC members by a resource type. (optional)
     * @param perPage      Number of items returned per page (optional, default to
     *                     20)
     * @param page         Which &#39;page&#39; of paginated results to return.
     *                     (optional, default to 1)
     * @return ApiResponse&lt;ListVpcMembersResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListVpcMembersResponse> listVpcMembersWithHttpInfo(UUID vpcId, String resourceType,
            Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listVpcMembersRequestBuilder(vpcId, resourceType, perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listVpcMembers", localVarResponse);
                }
                return new ApiResponse<ListVpcMembersResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListVpcMembersResponse>() {
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

    private HttpRequest.Builder listVpcMembersRequestBuilder(UUID vpcId, String resourceType, Integer perPage,
            Integer page) {
        // verify the required parameter 'vpcId' is set
        if (vpcId == null) {
            throw new ApiException(400, "Missing the required parameter 'vpcId' when calling listVpcMembers");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/vpcs/{vpc_id}/members".replace("{vpc_id}", ApiClient.urlEncode(vpcId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("resource_type", resourceType));
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
     * List All VPCs To list all of the VPCs on your account, send a GET request to
     * &#x60;/v2/vpcs&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ListVpcsResponse
     * @throws ApiException if fails to make API call
     */
    public ListVpcsResponse listVpcs(Integer perPage, Integer page) {
        ApiResponse<ListVpcsResponse> localVarResponse = listVpcsWithHttpInfo(perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All VPCs To list all of the VPCs on your account, send a GET request to
     * &#x60;/v2/vpcs&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ApiResponse&lt;ListVpcsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListVpcsResponse> listVpcsWithHttpInfo(Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listVpcsRequestBuilder(perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listVpcs", localVarResponse);
                }
                return new ApiResponse<ListVpcsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ListVpcsResponse>() {
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

    private HttpRequest.Builder listVpcsRequestBuilder(Integer perPage, Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/vpcs";

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
     * Partially Update a VPC To update a subset of information about a VPC, send a
     * PATCH request to &#x60;/v2/vpcs/$VPC_ID&#x60;.
     *
     * @param vpcId           A unique identifier for a VPC. (required)
     * @param patchVpcRequest (required)
     * @return CreateVpcResponse
     * @throws ApiException if fails to make API call
     */
    public CreateVpcResponse patchVpc(UUID vpcId, PatchVpcRequest patchVpcRequest) {
        ApiResponse<CreateVpcResponse> localVarResponse = patchVpcWithHttpInfo(vpcId, patchVpcRequest);
        return localVarResponse.getData();
    }

    /**
     * Partially Update a VPC To update a subset of information about a VPC, send a
     * PATCH request to &#x60;/v2/vpcs/$VPC_ID&#x60;.
     *
     * @param vpcId           A unique identifier for a VPC. (required)
     * @param patchVpcRequest (required)
     * @return ApiResponse&lt;CreateVpcResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateVpcResponse> patchVpcWithHttpInfo(UUID vpcId, PatchVpcRequest patchVpcRequest) {
        HttpRequest.Builder localVarRequestBuilder = patchVpcRequestBuilder(vpcId, patchVpcRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("patchVpc", localVarResponse);
                }
                return new ApiResponse<CreateVpcResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateVpcResponse>() {
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

    private HttpRequest.Builder patchVpcRequestBuilder(UUID vpcId, PatchVpcRequest patchVpcRequest) {
        // verify the required parameter 'vpcId' is set
        if (vpcId == null) {
            throw new ApiException(400, "Missing the required parameter 'vpcId' when calling patchVpc");
        }
        // verify the required parameter 'patchVpcRequest' is set
        if (patchVpcRequest == null) {
            throw new ApiException(400, "Missing the required parameter 'patchVpcRequest' when calling patchVpc");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/vpcs/{vpc_id}".replace("{vpc_id}", ApiClient.urlEncode(vpcId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(patchVpcRequest);
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
     * Update a VPC To update information about a VPC, send a PUT request to
     * &#x60;/v2/vpcs/$VPC_ID&#x60;.
     *
     * @param vpcId            A unique identifier for a VPC. (required)
     * @param updateVpcRequest (required)
     * @return CreateVpcResponse
     * @throws ApiException if fails to make API call
     */
    public CreateVpcResponse updateVpc(UUID vpcId, UpdateVpcRequest updateVpcRequest) {
        ApiResponse<CreateVpcResponse> localVarResponse = updateVpcWithHttpInfo(vpcId, updateVpcRequest);
        return localVarResponse.getData();
    }

    /**
     * Update a VPC To update information about a VPC, send a PUT request to
     * &#x60;/v2/vpcs/$VPC_ID&#x60;.
     *
     * @param vpcId            A unique identifier for a VPC. (required)
     * @param updateVpcRequest (required)
     * @return ApiResponse&lt;CreateVpcResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateVpcResponse> updateVpcWithHttpInfo(UUID vpcId, UpdateVpcRequest updateVpcRequest) {
        HttpRequest.Builder localVarRequestBuilder = updateVpcRequestBuilder(vpcId, updateVpcRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateVpc", localVarResponse);
                }
                return new ApiResponse<CreateVpcResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateVpcResponse>() {
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

    private HttpRequest.Builder updateVpcRequestBuilder(UUID vpcId, UpdateVpcRequest updateVpcRequest) {
        // verify the required parameter 'vpcId' is set
        if (vpcId == null) {
            throw new ApiException(400, "Missing the required parameter 'vpcId' when calling updateVpc");
        }
        // verify the required parameter 'updateVpcRequest' is set
        if (updateVpcRequest == null) {
            throw new ApiException(400, "Missing the required parameter 'updateVpcRequest' when calling updateVpc");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/vpcs/{vpc_id}".replace("{vpc_id}", ApiClient.urlEncode(vpcId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateVpcRequest);
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
