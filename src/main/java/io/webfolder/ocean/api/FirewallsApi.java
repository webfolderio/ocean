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
import io.webfolder.ocean.model.AddFirewallDropletsRequest;
import io.webfolder.ocean.model.AddFirewallRulesRequest;
import io.webfolder.ocean.model.AddFirewallTagsRequest;
import io.webfolder.ocean.model.CreateFirewallRequest;
import io.webfolder.ocean.model.CreateFirewallResponse;
import io.webfolder.ocean.model.DeleteFirewallDropletsRequest;
import io.webfolder.ocean.model.DeleteFirewallTagsRequest;
import io.webfolder.ocean.model.ListDropletFirewallsResponse;
import io.webfolder.ocean.model.UpdateFirewallRequest;

public class FirewallsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public FirewallsApi() {
        this(new ApiClient());
    }

    public FirewallsApi(ApiClient apiClient) {
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
     * Add Droplets to a Firewall To assign a Droplet to a firewall, send a POST
     * request to &#x60;/v2/firewalls/$FIREWALL_ID/droplets&#x60;. In the body of
     * the request, there should be a &#x60;droplet_ids&#x60; attribute containing a
     * list of Droplet IDs. No response body will be sent back, but the response
     * code will indicate success. Specifically, the response code will be a 204,
     * which means that the action was successful with no returned body data.
     *
     * @param firewallId                 A unique ID that can be used to identify
     *                                   and reference a firewall. (required)
     * @param addFirewallDropletsRequest (optional)
     * @throws ApiException if fails to make API call
     */
    public void addFirewallDroplets(UUID firewallId, AddFirewallDropletsRequest addFirewallDropletsRequest) {
        addFirewallDropletsWithHttpInfo(firewallId, addFirewallDropletsRequest);
    }

    /**
     * Add Droplets to a Firewall To assign a Droplet to a firewall, send a POST
     * request to &#x60;/v2/firewalls/$FIREWALL_ID/droplets&#x60;. In the body of
     * the request, there should be a &#x60;droplet_ids&#x60; attribute containing a
     * list of Droplet IDs. No response body will be sent back, but the response
     * code will indicate success. Specifically, the response code will be a 204,
     * which means that the action was successful with no returned body data.
     *
     * @param firewallId                 A unique ID that can be used to identify
     *                                   and reference a firewall. (required)
     * @param addFirewallDropletsRequest (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> addFirewallDropletsWithHttpInfo(UUID firewallId,
            AddFirewallDropletsRequest addFirewallDropletsRequest) {
        HttpRequest.Builder localVarRequestBuilder = addFirewallDropletsRequestBuilder(firewallId,
                addFirewallDropletsRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("addFirewallDroplets", localVarResponse);
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

    private HttpRequest.Builder addFirewallDropletsRequestBuilder(UUID firewallId,
            AddFirewallDropletsRequest addFirewallDropletsRequest) {
        // verify the required parameter 'firewallId' is set
        if (firewallId == null) {
            throw new ApiException(400, "Missing the required parameter 'firewallId' when calling addFirewallDroplets");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls/{firewall_id}/droplets".replace("{firewall_id}",
                ApiClient.urlEncode(firewallId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(addFirewallDropletsRequest);
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
     * Add Rules to a Firewall To add additional access rules to a firewall, send a
     * POST request to &#x60;/v2/firewalls/$FIREWALL_ID/rules&#x60;. The body of the
     * request may include an inbound_rules and/or outbound_rules attribute
     * containing an array of rules to be added. No response body will be sent back,
     * but the response code will indicate success. Specifically, the response code
     * will be a 204, which means that the action was successful with no returned
     * body data.
     *
     * @param firewallId              A unique ID that can be used to identify and
     *                                reference a firewall. (required)
     * @param addFirewallRulesRequest (optional)
     * @throws ApiException if fails to make API call
     */
    public void addFirewallRules(UUID firewallId, AddFirewallRulesRequest addFirewallRulesRequest) {
        addFirewallRulesWithHttpInfo(firewallId, addFirewallRulesRequest);
    }

    /**
     * Add Rules to a Firewall To add additional access rules to a firewall, send a
     * POST request to &#x60;/v2/firewalls/$FIREWALL_ID/rules&#x60;. The body of the
     * request may include an inbound_rules and/or outbound_rules attribute
     * containing an array of rules to be added. No response body will be sent back,
     * but the response code will indicate success. Specifically, the response code
     * will be a 204, which means that the action was successful with no returned
     * body data.
     *
     * @param firewallId              A unique ID that can be used to identify and
     *                                reference a firewall. (required)
     * @param addFirewallRulesRequest (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> addFirewallRulesWithHttpInfo(UUID firewallId,
            AddFirewallRulesRequest addFirewallRulesRequest) {
        HttpRequest.Builder localVarRequestBuilder = addFirewallRulesRequestBuilder(firewallId,
                addFirewallRulesRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("addFirewallRules", localVarResponse);
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

    private HttpRequest.Builder addFirewallRulesRequestBuilder(UUID firewallId,
            AddFirewallRulesRequest addFirewallRulesRequest) {
        // verify the required parameter 'firewallId' is set
        if (firewallId == null) {
            throw new ApiException(400, "Missing the required parameter 'firewallId' when calling addFirewallRules");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls/{firewall_id}/rules".replace("{firewall_id}",
                ApiClient.urlEncode(firewallId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(addFirewallRulesRequest);
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
     * Add Tags to a Firewall To assign a tag representing a group of Droplets to a
     * firewall, send a POST request to &#x60;/v2/firewalls/$FIREWALL_ID/tags&#x60;.
     * In the body of the request, there should be a &#x60;tags&#x60; attribute
     * containing a list of tag names. No response body will be sent back, but the
     * response code will indicate success. Specifically, the response code will be
     * a 204, which means that the action was successful with no returned body data.
     *
     * @param firewallId             A unique ID that can be used to identify and
     *                               reference a firewall. (required)
     * @param addFirewallTagsRequest (optional)
     * @throws ApiException if fails to make API call
     */
    public void addFirewallTags(UUID firewallId, AddFirewallTagsRequest addFirewallTagsRequest) {
        addFirewallTagsWithHttpInfo(firewallId, addFirewallTagsRequest);
    }

    /**
     * Add Tags to a Firewall To assign a tag representing a group of Droplets to a
     * firewall, send a POST request to &#x60;/v2/firewalls/$FIREWALL_ID/tags&#x60;.
     * In the body of the request, there should be a &#x60;tags&#x60; attribute
     * containing a list of tag names. No response body will be sent back, but the
     * response code will indicate success. Specifically, the response code will be
     * a 204, which means that the action was successful with no returned body data.
     *
     * @param firewallId             A unique ID that can be used to identify and
     *                               reference a firewall. (required)
     * @param addFirewallTagsRequest (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> addFirewallTagsWithHttpInfo(UUID firewallId,
            AddFirewallTagsRequest addFirewallTagsRequest) {
        HttpRequest.Builder localVarRequestBuilder = addFirewallTagsRequestBuilder(firewallId, addFirewallTagsRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("addFirewallTags", localVarResponse);
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

    private HttpRequest.Builder addFirewallTagsRequestBuilder(UUID firewallId,
            AddFirewallTagsRequest addFirewallTagsRequest) {
        // verify the required parameter 'firewallId' is set
        if (firewallId == null) {
            throw new ApiException(400, "Missing the required parameter 'firewallId' when calling addFirewallTags");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls/{firewall_id}/tags".replace("{firewall_id}",
                ApiClient.urlEncode(firewallId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(addFirewallTagsRequest);
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
     * Create a New Firewall To create a new firewall, send a POST request to
     * &#x60;/v2/firewalls&#x60;. The request must contain at least one inbound or
     * outbound access rule.
     *
     * @param createFirewallRequest (optional)
     * @return CreateFirewallResponse
     * @throws ApiException if fails to make API call
     */
    public CreateFirewallResponse createFirewall(CreateFirewallRequest createFirewallRequest) {
        ApiResponse<CreateFirewallResponse> localVarResponse = createFirewallWithHttpInfo(createFirewallRequest);
        return localVarResponse.getData();
    }

    /**
     * Create a New Firewall To create a new firewall, send a POST request to
     * &#x60;/v2/firewalls&#x60;. The request must contain at least one inbound or
     * outbound access rule.
     *
     * @param createFirewallRequest (optional)
     * @return ApiResponse&lt;CreateFirewallResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateFirewallResponse> createFirewallWithHttpInfo(CreateFirewallRequest createFirewallRequest) {
        HttpRequest.Builder localVarRequestBuilder = createFirewallRequestBuilder(createFirewallRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createFirewall", localVarResponse);
                }
                return new ApiResponse<CreateFirewallResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateFirewallResponse>() {
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

    private HttpRequest.Builder createFirewallRequestBuilder(CreateFirewallRequest createFirewallRequest) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createFirewallRequest);
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
     * Delete a Firewall To delete a firewall send a DELETE request to
     * &#x60;/v2/firewalls/$FIREWALL_ID&#x60;. No response body will be sent back,
     * but the response code will indicate success. Specifically, the response code
     * will be a 204, which means that the action was successful with no returned
     * body data.
     *
     * @param firewallId A unique ID that can be used to identify and reference a
     *                   firewall. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteFirewall(UUID firewallId) {
        deleteFirewallWithHttpInfo(firewallId);
    }

    /**
     * Delete a Firewall To delete a firewall send a DELETE request to
     * &#x60;/v2/firewalls/$FIREWALL_ID&#x60;. No response body will be sent back,
     * but the response code will indicate success. Specifically, the response code
     * will be a 204, which means that the action was successful with no returned
     * body data.
     *
     * @param firewallId A unique ID that can be used to identify and reference a
     *                   firewall. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteFirewallWithHttpInfo(UUID firewallId) {
        HttpRequest.Builder localVarRequestBuilder = deleteFirewallRequestBuilder(firewallId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteFirewall", localVarResponse);
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

    private HttpRequest.Builder deleteFirewallRequestBuilder(UUID firewallId) {
        // verify the required parameter 'firewallId' is set
        if (firewallId == null) {
            throw new ApiException(400, "Missing the required parameter 'firewallId' when calling deleteFirewall");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls/{firewall_id}".replace("{firewall_id}",
                ApiClient.urlEncode(firewallId.toString()));

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
     * Remove Droplets from a Firewall To remove a Droplet from a firewall, send a
     * DELETE request to &#x60;/v2/firewalls/$FIREWALL_ID/droplets&#x60;. In the
     * body of the request, there should be a &#x60;droplet_ids&#x60; attribute
     * containing a list of Droplet IDs. No response body will be sent back, but the
     * response code will indicate success. Specifically, the response code will be
     * a 204, which means that the action was successful with no returned body data.
     *
     * @param firewallId                    A unique ID that can be used to identify
     *                                      and reference a firewall. (required)
     * @param deleteFirewallDropletsRequest (optional)
     * @throws ApiException if fails to make API call
     */
    public void deleteFirewallDroplets(UUID firewallId, DeleteFirewallDropletsRequest deleteFirewallDropletsRequest) {
        deleteFirewallDropletsWithHttpInfo(firewallId, deleteFirewallDropletsRequest);
    }

    /**
     * Remove Droplets from a Firewall To remove a Droplet from a firewall, send a
     * DELETE request to &#x60;/v2/firewalls/$FIREWALL_ID/droplets&#x60;. In the
     * body of the request, there should be a &#x60;droplet_ids&#x60; attribute
     * containing a list of Droplet IDs. No response body will be sent back, but the
     * response code will indicate success. Specifically, the response code will be
     * a 204, which means that the action was successful with no returned body data.
     *
     * @param firewallId                    A unique ID that can be used to identify
     *                                      and reference a firewall. (required)
     * @param deleteFirewallDropletsRequest (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteFirewallDropletsWithHttpInfo(UUID firewallId,
            DeleteFirewallDropletsRequest deleteFirewallDropletsRequest) {
        HttpRequest.Builder localVarRequestBuilder = deleteFirewallDropletsRequestBuilder(firewallId,
                deleteFirewallDropletsRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteFirewallDroplets", localVarResponse);
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

    private HttpRequest.Builder deleteFirewallDropletsRequestBuilder(UUID firewallId,
            DeleteFirewallDropletsRequest deleteFirewallDropletsRequest) {
        // verify the required parameter 'firewallId' is set
        if (firewallId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'firewallId' when calling deleteFirewallDroplets");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls/{firewall_id}/droplets".replace("{firewall_id}",
                ApiClient.urlEncode(firewallId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(deleteFirewallDropletsRequest);
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
     * Remove Rules from a Firewall To remove access rules from a firewall, send a
     * DELETE request to &#x60;/v2/firewalls/$FIREWALL_ID/rules&#x60;. The body of
     * the request may include an &#x60;inbound_rules&#x60; and/or
     * &#x60;outbound_rules&#x60; attribute containing an array of rules to be
     * removed. No response body will be sent back, but the response code will
     * indicate success. Specifically, the response code will be a 204, which means
     * that the action was successful with no returned body data.
     *
     * @param firewallId              A unique ID that can be used to identify and
     *                                reference a firewall. (required)
     * @param addFirewallRulesRequest (optional)
     * @throws ApiException if fails to make API call
     */
    public void deleteFirewallRules(UUID firewallId, AddFirewallRulesRequest addFirewallRulesRequest) {
        deleteFirewallRulesWithHttpInfo(firewallId, addFirewallRulesRequest);
    }

    /**
     * Remove Rules from a Firewall To remove access rules from a firewall, send a
     * DELETE request to &#x60;/v2/firewalls/$FIREWALL_ID/rules&#x60;. The body of
     * the request may include an &#x60;inbound_rules&#x60; and/or
     * &#x60;outbound_rules&#x60; attribute containing an array of rules to be
     * removed. No response body will be sent back, but the response code will
     * indicate success. Specifically, the response code will be a 204, which means
     * that the action was successful with no returned body data.
     *
     * @param firewallId              A unique ID that can be used to identify and
     *                                reference a firewall. (required)
     * @param addFirewallRulesRequest (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteFirewallRulesWithHttpInfo(UUID firewallId,
            AddFirewallRulesRequest addFirewallRulesRequest) {
        HttpRequest.Builder localVarRequestBuilder = deleteFirewallRulesRequestBuilder(firewallId,
                addFirewallRulesRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteFirewallRules", localVarResponse);
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

    private HttpRequest.Builder deleteFirewallRulesRequestBuilder(UUID firewallId,
            AddFirewallRulesRequest addFirewallRulesRequest) {
        // verify the required parameter 'firewallId' is set
        if (firewallId == null) {
            throw new ApiException(400, "Missing the required parameter 'firewallId' when calling deleteFirewallRules");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls/{firewall_id}/rules".replace("{firewall_id}",
                ApiClient.urlEncode(firewallId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(addFirewallRulesRequest);
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
     * Remove Tags from a Firewall To remove a tag representing a group of Droplets
     * from a firewall, send a DELETE request to
     * &#x60;/v2/firewalls/$FIREWALL_ID/tags&#x60;. In the body of the request,
     * there should be a &#x60;tags&#x60; attribute containing a list of tag names.
     * No response body will be sent back, but the response code will indicate
     * success. Specifically, the response code will be a 204, which means that the
     * action was successful with no returned body data.
     *
     * @param firewallId                A unique ID that can be used to identify and
     *                                  reference a firewall. (required)
     * @param deleteFirewallTagsRequest (optional)
     * @throws ApiException if fails to make API call
     */
    public void deleteFirewallTags(UUID firewallId, DeleteFirewallTagsRequest deleteFirewallTagsRequest) {
        deleteFirewallTagsWithHttpInfo(firewallId, deleteFirewallTagsRequest);
    }

    /**
     * Remove Tags from a Firewall To remove a tag representing a group of Droplets
     * from a firewall, send a DELETE request to
     * &#x60;/v2/firewalls/$FIREWALL_ID/tags&#x60;. In the body of the request,
     * there should be a &#x60;tags&#x60; attribute containing a list of tag names.
     * No response body will be sent back, but the response code will indicate
     * success. Specifically, the response code will be a 204, which means that the
     * action was successful with no returned body data.
     *
     * @param firewallId                A unique ID that can be used to identify and
     *                                  reference a firewall. (required)
     * @param deleteFirewallTagsRequest (optional)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteFirewallTagsWithHttpInfo(UUID firewallId,
            DeleteFirewallTagsRequest deleteFirewallTagsRequest) {
        HttpRequest.Builder localVarRequestBuilder = deleteFirewallTagsRequestBuilder(firewallId,
                deleteFirewallTagsRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteFirewallTags", localVarResponse);
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

    private HttpRequest.Builder deleteFirewallTagsRequestBuilder(UUID firewallId,
            DeleteFirewallTagsRequest deleteFirewallTagsRequest) {
        // verify the required parameter 'firewallId' is set
        if (firewallId == null) {
            throw new ApiException(400, "Missing the required parameter 'firewallId' when calling deleteFirewallTags");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls/{firewall_id}/tags".replace("{firewall_id}",
                ApiClient.urlEncode(firewallId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(deleteFirewallTagsRequest);
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
     * Retrieve an Existing Firewall To show information about an existing firewall,
     * send a GET request to &#x60;/v2/firewalls/$FIREWALL_ID&#x60;.
     *
     * @param firewallId A unique ID that can be used to identify and reference a
     *                   firewall. (required)
     * @return CreateFirewallResponse
     * @throws ApiException if fails to make API call
     */
    public CreateFirewallResponse getFirewall(UUID firewallId) {
        ApiResponse<CreateFirewallResponse> localVarResponse = getFirewallWithHttpInfo(firewallId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Firewall To show information about an existing firewall,
     * send a GET request to &#x60;/v2/firewalls/$FIREWALL_ID&#x60;.
     *
     * @param firewallId A unique ID that can be used to identify and reference a
     *                   firewall. (required)
     * @return ApiResponse&lt;CreateFirewallResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateFirewallResponse> getFirewallWithHttpInfo(UUID firewallId) {
        HttpRequest.Builder localVarRequestBuilder = getFirewallRequestBuilder(firewallId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getFirewall", localVarResponse);
                }
                return new ApiResponse<CreateFirewallResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateFirewallResponse>() {
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

    private HttpRequest.Builder getFirewallRequestBuilder(UUID firewallId) {
        // verify the required parameter 'firewallId' is set
        if (firewallId == null) {
            throw new ApiException(400, "Missing the required parameter 'firewallId' when calling getFirewall");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls/{firewall_id}".replace("{firewall_id}",
                ApiClient.urlEncode(firewallId.toString()));

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
     * List All Firewalls To list all of the firewalls available on your account,
     * send a GET request to &#x60;/v2/firewalls&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ListDropletFirewallsResponse
     * @throws ApiException if fails to make API call
     */
    public ListDropletFirewallsResponse listFirewalls(Integer perPage, Integer page) {
        ApiResponse<ListDropletFirewallsResponse> localVarResponse = listFirewallsWithHttpInfo(perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All Firewalls To list all of the firewalls available on your account,
     * send a GET request to &#x60;/v2/firewalls&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ApiResponse&lt;ListDropletFirewallsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListDropletFirewallsResponse> listFirewallsWithHttpInfo(Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listFirewallsRequestBuilder(perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listFirewalls", localVarResponse);
                }
                return new ApiResponse<ListDropletFirewallsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListDropletFirewallsResponse>() {
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

    private HttpRequest.Builder listFirewallsRequestBuilder(Integer perPage, Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls";

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
     * Update a Firewall To update the configuration of an existing firewall, send a
     * PUT request to &#x60;/v2/firewalls/$FIREWALL_ID&#x60;. The request should
     * contain a full representation of the firewall including existing attributes.
     * **Note that any attributes that are not provided will be reset to their
     * default values.**
     *
     * @param firewallId            A unique ID that can be used to identify and
     *                              reference a firewall. (required)
     * @param updateFirewallRequest (optional)
     * @return CreateFirewallResponse
     * @throws ApiException if fails to make API call
     */
    public CreateFirewallResponse updateFirewall(UUID firewallId, UpdateFirewallRequest updateFirewallRequest) {
        ApiResponse<CreateFirewallResponse> localVarResponse = updateFirewallWithHttpInfo(firewallId,
                updateFirewallRequest);
        return localVarResponse.getData();
    }

    /**
     * Update a Firewall To update the configuration of an existing firewall, send a
     * PUT request to &#x60;/v2/firewalls/$FIREWALL_ID&#x60;. The request should
     * contain a full representation of the firewall including existing attributes.
     * **Note that any attributes that are not provided will be reset to their
     * default values.**
     *
     * @param firewallId            A unique ID that can be used to identify and
     *                              reference a firewall. (required)
     * @param updateFirewallRequest (optional)
     * @return ApiResponse&lt;CreateFirewallResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateFirewallResponse> updateFirewallWithHttpInfo(UUID firewallId,
            UpdateFirewallRequest updateFirewallRequest) {
        HttpRequest.Builder localVarRequestBuilder = updateFirewallRequestBuilder(firewallId, updateFirewallRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateFirewall", localVarResponse);
                }
                return new ApiResponse<CreateFirewallResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateFirewallResponse>() {
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

    private HttpRequest.Builder updateFirewallRequestBuilder(UUID firewallId,
            UpdateFirewallRequest updateFirewallRequest) {
        // verify the required parameter 'firewallId' is set
        if (firewallId == null) {
            throw new ApiException(400, "Missing the required parameter 'firewallId' when calling updateFirewall");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/firewalls/{firewall_id}".replace("{firewall_id}",
                ApiClient.urlEncode(firewallId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateFirewallRequest);
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
