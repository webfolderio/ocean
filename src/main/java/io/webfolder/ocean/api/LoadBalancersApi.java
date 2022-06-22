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
import io.webfolder.ocean.model.AddLoadBalancerDropletsRequest;
import io.webfolder.ocean.model.AddLoadBalancerForwardingRulesRequest;
import io.webfolder.ocean.model.CreateLoadBalancerResponse;
import io.webfolder.ocean.model.ListAllLoadBalancersResponse;
import io.webfolder.ocean.model.LoadBalancerCreate;

public class LoadBalancersApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public LoadBalancersApi() {
        this(new ApiClient());
    }

    public LoadBalancersApi(ApiClient apiClient) {
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
     * Add Droplets to a Load Balancer To assign a Droplet to a load balancer
     * instance, send a POST request to
     * &#x60;/v2/load_balancers/$LOAD_BALANCER_ID/droplets&#x60;. In the body of the
     * request, there should be a &#x60;droplet_ids&#x60; attribute containing a
     * list of Droplet IDs. Individual Droplets can not be added to a load balancer
     * configured with a Droplet tag. Attempting to do so will result in a
     * \&quot;422 Unprocessable Entity\&quot; response from the API. No response
     * body will be sent back, but the response code will indicate success.
     * Specifically, the response code will be a 204, which means that the action
     * was successful with no returned body data.
     *
     * @param lbId                           A unique identifier for a load
     *                                       balancer. (required)
     * @param addLoadBalancerDropletsRequest (required)
     * @throws ApiException if fails to make API call
     */
    public void addLoadBalancerDroplets(String lbId, AddLoadBalancerDropletsRequest addLoadBalancerDropletsRequest) {
        addLoadBalancerDropletsWithHttpInfo(lbId, addLoadBalancerDropletsRequest);
    }

    /**
     * Add Droplets to a Load Balancer To assign a Droplet to a load balancer
     * instance, send a POST request to
     * &#x60;/v2/load_balancers/$LOAD_BALANCER_ID/droplets&#x60;. In the body of the
     * request, there should be a &#x60;droplet_ids&#x60; attribute containing a
     * list of Droplet IDs. Individual Droplets can not be added to a load balancer
     * configured with a Droplet tag. Attempting to do so will result in a
     * \&quot;422 Unprocessable Entity\&quot; response from the API. No response
     * body will be sent back, but the response code will indicate success.
     * Specifically, the response code will be a 204, which means that the action
     * was successful with no returned body data.
     *
     * @param lbId                           A unique identifier for a load
     *                                       balancer. (required)
     * @param addLoadBalancerDropletsRequest (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> addLoadBalancerDropletsWithHttpInfo(String lbId,
            AddLoadBalancerDropletsRequest addLoadBalancerDropletsRequest) {
        HttpRequest.Builder localVarRequestBuilder = addLoadBalancerDropletsRequestBuilder(lbId,
                addLoadBalancerDropletsRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("addLoadBalancerDroplets", localVarResponse);
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

    private HttpRequest.Builder addLoadBalancerDropletsRequestBuilder(String lbId,
            AddLoadBalancerDropletsRequest addLoadBalancerDropletsRequest) {
        // verify the required parameter 'lbId' is set
        if (lbId == null) {
            throw new ApiException(400, "Missing the required parameter 'lbId' when calling addLoadBalancerDroplets");
        }
        // verify the required parameter 'addLoadBalancerDropletsRequest' is set
        if (addLoadBalancerDropletsRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'addLoadBalancerDropletsRequest' when calling addLoadBalancerDroplets");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/load_balancers/{lb_id}/droplets".replace("{lb_id}",
                ApiClient.urlEncode(lbId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(addLoadBalancerDropletsRequest);
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
     * Add Forwarding Rules to a Load Balancer To add an additional forwarding rule
     * to a load balancer instance, send a POST request to
     * &#x60;/v2/load_balancers/$LOAD_BALANCER_ID/forwarding_rules&#x60;. In the
     * body of the request, there should be a &#x60;forwarding_rules&#x60; attribute
     * containing an array of rules to be added. No response body will be sent back,
     * but the response code will indicate success. Specifically, the response code
     * will be a 204, which means that the action was successful with no returned
     * body data.
     *
     * @param lbId                                  A unique identifier for a load
     *                                              balancer. (required)
     * @param addLoadBalancerForwardingRulesRequest (required)
     * @throws ApiException if fails to make API call
     */
    public void addLoadBalancerForwardingRules(String lbId,
            AddLoadBalancerForwardingRulesRequest addLoadBalancerForwardingRulesRequest) {
        addLoadBalancerForwardingRulesWithHttpInfo(lbId, addLoadBalancerForwardingRulesRequest);
    }

    /**
     * Add Forwarding Rules to a Load Balancer To add an additional forwarding rule
     * to a load balancer instance, send a POST request to
     * &#x60;/v2/load_balancers/$LOAD_BALANCER_ID/forwarding_rules&#x60;. In the
     * body of the request, there should be a &#x60;forwarding_rules&#x60; attribute
     * containing an array of rules to be added. No response body will be sent back,
     * but the response code will indicate success. Specifically, the response code
     * will be a 204, which means that the action was successful with no returned
     * body data.
     *
     * @param lbId                                  A unique identifier for a load
     *                                              balancer. (required)
     * @param addLoadBalancerForwardingRulesRequest (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> addLoadBalancerForwardingRulesWithHttpInfo(String lbId,
            AddLoadBalancerForwardingRulesRequest addLoadBalancerForwardingRulesRequest) {
        HttpRequest.Builder localVarRequestBuilder = addLoadBalancerForwardingRulesRequestBuilder(lbId,
                addLoadBalancerForwardingRulesRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("addLoadBalancerForwardingRules", localVarResponse);
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

    private HttpRequest.Builder addLoadBalancerForwardingRulesRequestBuilder(String lbId,
            AddLoadBalancerForwardingRulesRequest addLoadBalancerForwardingRulesRequest) {
        // verify the required parameter 'lbId' is set
        if (lbId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'lbId' when calling addLoadBalancerForwardingRules");
        }
        // verify the required parameter 'addLoadBalancerForwardingRulesRequest' is set
        if (addLoadBalancerForwardingRulesRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'addLoadBalancerForwardingRulesRequest' when calling addLoadBalancerForwardingRules");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/load_balancers/{lb_id}/forwarding_rules".replace("{lb_id}",
                ApiClient.urlEncode(lbId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(addLoadBalancerForwardingRulesRequest);
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
     * Create a New Load Balancer To create a new load balancer instance, send a
     * POST request to &#x60;/v2/load_balancers&#x60;. You can specify the Droplets
     * that will sit behind the load balancer using one of two methods: * Set
     * &#x60;droplet_ids&#x60; to a list of specific Droplet IDs. * Set
     * &#x60;tag&#x60; to the name of a tag. All Droplets with this tag applied will
     * be assigned to the load balancer. Additional Droplets will be automatically
     * assigned as they are tagged. These methods are mutually exclusive.
     *
     * @param loadBalancerCreate (required)
     * @return CreateLoadBalancerResponse
     * @throws ApiException if fails to make API call
     */
    public CreateLoadBalancerResponse createLoadBalancer(LoadBalancerCreate loadBalancerCreate) {
        ApiResponse<CreateLoadBalancerResponse> localVarResponse = createLoadBalancerWithHttpInfo(loadBalancerCreate);
        return localVarResponse.getData();
    }

    /**
     * Create a New Load Balancer To create a new load balancer instance, send a
     * POST request to &#x60;/v2/load_balancers&#x60;. You can specify the Droplets
     * that will sit behind the load balancer using one of two methods: * Set
     * &#x60;droplet_ids&#x60; to a list of specific Droplet IDs. * Set
     * &#x60;tag&#x60; to the name of a tag. All Droplets with this tag applied will
     * be assigned to the load balancer. Additional Droplets will be automatically
     * assigned as they are tagged. These methods are mutually exclusive.
     *
     * @param loadBalancerCreate (required)
     * @return ApiResponse&lt;CreateLoadBalancerResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateLoadBalancerResponse> createLoadBalancerWithHttpInfo(
            LoadBalancerCreate loadBalancerCreate) {
        HttpRequest.Builder localVarRequestBuilder = createLoadBalancerRequestBuilder(loadBalancerCreate);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createLoadBalancer", localVarResponse);
                }
                return new ApiResponse<CreateLoadBalancerResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateLoadBalancerResponse>() {
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

    private HttpRequest.Builder createLoadBalancerRequestBuilder(LoadBalancerCreate loadBalancerCreate) {
        // verify the required parameter 'loadBalancerCreate' is set
        if (loadBalancerCreate == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'loadBalancerCreate' when calling createLoadBalancer");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/load_balancers";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(loadBalancerCreate);
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
     * Delete a Load Balancer To delete a load balancer instance, disassociating any
     * Droplets assigned to it and removing it from your account, send a DELETE
     * request to &#x60;/v2/load_balancers/$LOAD_BALANCER_ID&#x60;. A successful
     * request will receive a 204 status code with no body in response. This
     * indicates that the request was processed successfully.
     *
     * @param lbId A unique identifier for a load balancer. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteLoadBalancer(String lbId) {
        deleteLoadBalancerWithHttpInfo(lbId);
    }

    /**
     * Delete a Load Balancer To delete a load balancer instance, disassociating any
     * Droplets assigned to it and removing it from your account, send a DELETE
     * request to &#x60;/v2/load_balancers/$LOAD_BALANCER_ID&#x60;. A successful
     * request will receive a 204 status code with no body in response. This
     * indicates that the request was processed successfully.
     *
     * @param lbId A unique identifier for a load balancer. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteLoadBalancerWithHttpInfo(String lbId) {
        HttpRequest.Builder localVarRequestBuilder = deleteLoadBalancerRequestBuilder(lbId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteLoadBalancer", localVarResponse);
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

    private HttpRequest.Builder deleteLoadBalancerRequestBuilder(String lbId) {
        // verify the required parameter 'lbId' is set
        if (lbId == null) {
            throw new ApiException(400, "Missing the required parameter 'lbId' when calling deleteLoadBalancer");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/load_balancers/{lb_id}".replace("{lb_id}", ApiClient.urlEncode(lbId.toString()));

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
     * Retrieve an Existing Load Balancer To show information about a load balancer
     * instance, send a GET request to
     * &#x60;/v2/load_balancers/$LOAD_BALANCER_ID&#x60;.
     *
     * @param lbId A unique identifier for a load balancer. (required)
     * @return CreateLoadBalancerResponse
     * @throws ApiException if fails to make API call
     */
    public CreateLoadBalancerResponse getLoadBalancer(String lbId) {
        ApiResponse<CreateLoadBalancerResponse> localVarResponse = getLoadBalancerWithHttpInfo(lbId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Load Balancer To show information about a load balancer
     * instance, send a GET request to
     * &#x60;/v2/load_balancers/$LOAD_BALANCER_ID&#x60;.
     *
     * @param lbId A unique identifier for a load balancer. (required)
     * @return ApiResponse&lt;CreateLoadBalancerResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateLoadBalancerResponse> getLoadBalancerWithHttpInfo(String lbId) {
        HttpRequest.Builder localVarRequestBuilder = getLoadBalancerRequestBuilder(lbId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getLoadBalancer", localVarResponse);
                }
                return new ApiResponse<CreateLoadBalancerResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateLoadBalancerResponse>() {
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

    private HttpRequest.Builder getLoadBalancerRequestBuilder(String lbId) {
        // verify the required parameter 'lbId' is set
        if (lbId == null) {
            throw new ApiException(400, "Missing the required parameter 'lbId' when calling getLoadBalancer");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/load_balancers/{lb_id}".replace("{lb_id}", ApiClient.urlEncode(lbId.toString()));

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
     * List All Load Balancers To list all of the load balancer instances on your
     * account, send a GET request to &#x60;/v2/load_balancers&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ListAllLoadBalancersResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllLoadBalancersResponse listAllLoadBalancers(Integer perPage, Integer page) {
        ApiResponse<ListAllLoadBalancersResponse> localVarResponse = listAllLoadBalancersWithHttpInfo(perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All Load Balancers To list all of the load balancer instances on your
     * account, send a GET request to &#x60;/v2/load_balancers&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ApiResponse&lt;ListAllLoadBalancersResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllLoadBalancersResponse> listAllLoadBalancersWithHttpInfo(Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listAllLoadBalancersRequestBuilder(perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllLoadBalancers", localVarResponse);
                }
                return new ApiResponse<ListAllLoadBalancersResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllLoadBalancersResponse>() {
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

    private HttpRequest.Builder listAllLoadBalancersRequestBuilder(Integer perPage, Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/load_balancers";

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
     * Remove Droplets from a Load Balancer To remove a Droplet from a load balancer
     * instance, send a DELETE request to
     * &#x60;/v2/load_balancers/$LOAD_BALANCER_ID/droplets&#x60;. In the body of the
     * request, there should be a &#x60;droplet_ids&#x60; attribute containing a
     * list of Droplet IDs. No response body will be sent back, but the response
     * code will indicate success. Specifically, the response code will be a 204,
     * which means that the action was successful with no returned body data.
     *
     * @param lbId                           A unique identifier for a load
     *                                       balancer. (required)
     * @param addLoadBalancerDropletsRequest (required)
     * @throws ApiException if fails to make API call
     */
    public void removeLoadBalancerDroplets(String lbId, AddLoadBalancerDropletsRequest addLoadBalancerDropletsRequest) {
        removeLoadBalancerDropletsWithHttpInfo(lbId, addLoadBalancerDropletsRequest);
    }

    /**
     * Remove Droplets from a Load Balancer To remove a Droplet from a load balancer
     * instance, send a DELETE request to
     * &#x60;/v2/load_balancers/$LOAD_BALANCER_ID/droplets&#x60;. In the body of the
     * request, there should be a &#x60;droplet_ids&#x60; attribute containing a
     * list of Droplet IDs. No response body will be sent back, but the response
     * code will indicate success. Specifically, the response code will be a 204,
     * which means that the action was successful with no returned body data.
     *
     * @param lbId                           A unique identifier for a load
     *                                       balancer. (required)
     * @param addLoadBalancerDropletsRequest (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> removeLoadBalancerDropletsWithHttpInfo(String lbId,
            AddLoadBalancerDropletsRequest addLoadBalancerDropletsRequest) {
        HttpRequest.Builder localVarRequestBuilder = removeLoadBalancerDropletsRequestBuilder(lbId,
                addLoadBalancerDropletsRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("removeLoadBalancerDroplets", localVarResponse);
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

    private HttpRequest.Builder removeLoadBalancerDropletsRequestBuilder(String lbId,
            AddLoadBalancerDropletsRequest addLoadBalancerDropletsRequest) {
        // verify the required parameter 'lbId' is set
        if (lbId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'lbId' when calling removeLoadBalancerDroplets");
        }
        // verify the required parameter 'addLoadBalancerDropletsRequest' is set
        if (addLoadBalancerDropletsRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'addLoadBalancerDropletsRequest' when calling removeLoadBalancerDroplets");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/load_balancers/{lb_id}/droplets".replace("{lb_id}",
                ApiClient.urlEncode(lbId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(addLoadBalancerDropletsRequest);
            localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
     * Remove Forwarding Rules from a Load Balancer To remove forwarding rules from
     * a load balancer instance, send a DELETE request to
     * &#x60;/v2/load_balancers/$LOAD_BALANCER_ID/forwarding_rules&#x60;. In the
     * body of the request, there should be a &#x60;forwarding_rules&#x60; attribute
     * containing an array of rules to be removed. No response body will be sent
     * back, but the response code will indicate success. Specifically, the response
     * code will be a 204, which means that the action was successful with no
     * returned body data.
     *
     * @param lbId                                  A unique identifier for a load
     *                                              balancer. (required)
     * @param addLoadBalancerForwardingRulesRequest (required)
     * @throws ApiException if fails to make API call
     */
    public void removeLoadBalancerForwardingRules(String lbId,
            AddLoadBalancerForwardingRulesRequest addLoadBalancerForwardingRulesRequest) {
        removeLoadBalancerForwardingRulesWithHttpInfo(lbId, addLoadBalancerForwardingRulesRequest);
    }

    /**
     * Remove Forwarding Rules from a Load Balancer To remove forwarding rules from
     * a load balancer instance, send a DELETE request to
     * &#x60;/v2/load_balancers/$LOAD_BALANCER_ID/forwarding_rules&#x60;. In the
     * body of the request, there should be a &#x60;forwarding_rules&#x60; attribute
     * containing an array of rules to be removed. No response body will be sent
     * back, but the response code will indicate success. Specifically, the response
     * code will be a 204, which means that the action was successful with no
     * returned body data.
     *
     * @param lbId                                  A unique identifier for a load
     *                                              balancer. (required)
     * @param addLoadBalancerForwardingRulesRequest (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> removeLoadBalancerForwardingRulesWithHttpInfo(String lbId,
            AddLoadBalancerForwardingRulesRequest addLoadBalancerForwardingRulesRequest) {
        HttpRequest.Builder localVarRequestBuilder = removeLoadBalancerForwardingRulesRequestBuilder(lbId,
                addLoadBalancerForwardingRulesRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("removeLoadBalancerForwardingRules", localVarResponse);
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

    private HttpRequest.Builder removeLoadBalancerForwardingRulesRequestBuilder(String lbId,
            AddLoadBalancerForwardingRulesRequest addLoadBalancerForwardingRulesRequest) {
        // verify the required parameter 'lbId' is set
        if (lbId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'lbId' when calling removeLoadBalancerForwardingRules");
        }
        // verify the required parameter 'addLoadBalancerForwardingRulesRequest' is set
        if (addLoadBalancerForwardingRulesRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'addLoadBalancerForwardingRulesRequest' when calling removeLoadBalancerForwardingRules");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/load_balancers/{lb_id}/forwarding_rules".replace("{lb_id}",
                ApiClient.urlEncode(lbId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(addLoadBalancerForwardingRulesRequest);
            localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
     * Update a Load Balancer To update a load balancer&#39;s settings, send a PUT
     * request to &#x60;/v2/load_balancers/$LOAD_BALANCER_ID&#x60;. The request
     * should contain a full representation of the load balancer including existing
     * attributes. It may contain _one of_ the &#x60;droplets_ids&#x60; or
     * &#x60;tag&#x60; attributes as they are mutually exclusive. **Note that any
     * attribute that is not provided will be reset to its default value.**
     *
     * @param lbId               A unique identifier for a load balancer. (required)
     * @param loadBalancerCreate (required)
     * @return CreateLoadBalancerResponse
     * @throws ApiException if fails to make API call
     */
    public CreateLoadBalancerResponse updateLoadBalancer(String lbId, LoadBalancerCreate loadBalancerCreate) {
        ApiResponse<CreateLoadBalancerResponse> localVarResponse = updateLoadBalancerWithHttpInfo(lbId,
                loadBalancerCreate);
        return localVarResponse.getData();
    }

    /**
     * Update a Load Balancer To update a load balancer&#39;s settings, send a PUT
     * request to &#x60;/v2/load_balancers/$LOAD_BALANCER_ID&#x60;. The request
     * should contain a full representation of the load balancer including existing
     * attributes. It may contain _one of_ the &#x60;droplets_ids&#x60; or
     * &#x60;tag&#x60; attributes as they are mutually exclusive. **Note that any
     * attribute that is not provided will be reset to its default value.**
     *
     * @param lbId               A unique identifier for a load balancer. (required)
     * @param loadBalancerCreate (required)
     * @return ApiResponse&lt;CreateLoadBalancerResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateLoadBalancerResponse> updateLoadBalancerWithHttpInfo(String lbId,
            LoadBalancerCreate loadBalancerCreate) {
        HttpRequest.Builder localVarRequestBuilder = updateLoadBalancerRequestBuilder(lbId, loadBalancerCreate);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateLoadBalancer", localVarResponse);
                }
                return new ApiResponse<CreateLoadBalancerResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateLoadBalancerResponse>() {
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

    private HttpRequest.Builder updateLoadBalancerRequestBuilder(String lbId, LoadBalancerCreate loadBalancerCreate) {
        // verify the required parameter 'lbId' is set
        if (lbId == null) {
            throw new ApiException(400, "Missing the required parameter 'lbId' when calling updateLoadBalancer");
        }
        // verify the required parameter 'loadBalancerCreate' is set
        if (loadBalancerCreate == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'loadBalancerCreate' when calling updateLoadBalancer");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/load_balancers/{lb_id}".replace("{lb_id}", ApiClient.urlEncode(lbId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(loadBalancerCreate);
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
