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
import io.webfolder.ocean.model.InstallKubernetesResponse;
import io.webfolder.ocean.model.ListResponse;
import io.webfolder.ocean.model.OneClickCreate;

public class OneClickApplicationsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public OneClickApplicationsApi() {
        this(new ApiClient());
    }

    public OneClickApplicationsApi(ApiClient apiClient) {
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
     * List 1-Click Applications To list all available 1-Click applications, send a
     * GET request to &#x60;/v2/1-clicks&#x60;. The &#x60;type&#x60; may be provided
     * as query paramater in order to restrict results to a certain type of 1-Click,
     * for example: &#x60;/v2/1-clicks?type&#x3D;droplet&#x60;. Current supported
     * types are &#x60;kubernetes&#x60; and &#x60;droplet&#x60;. The response will
     * be a JSON object with a key called &#x60;1_clicks&#x60;. This will be set to
     * an array of 1-Click application data, each of which will contain the the slug
     * and type for the 1-Click.
     *
     * @param type Restrict results to a certain type of 1-Click. (optional)
     * @return ListResponse
     * @throws ApiException if fails to make API call
     */
    public ListResponse callList(String type) {
        ApiResponse<ListResponse> localVarResponse = callListWithHttpInfo(type);
        return localVarResponse.getData();
    }

    /**
     * List 1-Click Applications To list all available 1-Click applications, send a
     * GET request to &#x60;/v2/1-clicks&#x60;. The &#x60;type&#x60; may be provided
     * as query paramater in order to restrict results to a certain type of 1-Click,
     * for example: &#x60;/v2/1-clicks?type&#x3D;droplet&#x60;. Current supported
     * types are &#x60;kubernetes&#x60; and &#x60;droplet&#x60;. The response will
     * be a JSON object with a key called &#x60;1_clicks&#x60;. This will be set to
     * an array of 1-Click application data, each of which will contain the the slug
     * and type for the 1-Click.
     *
     * @param type Restrict results to a certain type of 1-Click. (optional)
     * @return ApiResponse&lt;ListResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListResponse> callListWithHttpInfo(String type) {
        HttpRequest.Builder localVarRequestBuilder = callListRequestBuilder(type);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("callList", localVarResponse);
                }
                return new ApiResponse<ListResponse>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ListResponse>() {
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

    private HttpRequest.Builder callListRequestBuilder(String type) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/1-clicks";

        List<Pair> localVarQueryParams = new ArrayList<>();
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
     * Install Kubernetes 1-Click Applications To install a Kubernetes 1-Click
     * application on a cluster, send a POST request to
     * &#x60;/v2/1-clicks/kubernetes&#x60;. The &#x60;addon_slugs&#x60; and
     * &#x60;cluster_uuid&#x60; must be provided as body parameter in order to
     * specify which 1-Click application(s) to install. To list all available
     * 1-Click Kubernetes applications, send a request to
     * &#x60;/v2/1-clicks?type&#x3D;kubernetes&#x60;.
     *
     * @param OneClickCreate (required)
     * @return InstallKubernetesResponse
     * @throws ApiException if fails to make API call
     */
    public InstallKubernetesResponse installKubernetes(OneClickCreate OneClickCreate) {
        ApiResponse<InstallKubernetesResponse> localVarResponse = installKubernetesWithHttpInfo(OneClickCreate);
        return localVarResponse.getData();
    }

    /**
     * Install Kubernetes 1-Click Applications To install a Kubernetes 1-Click
     * application on a cluster, send a POST request to
     * &#x60;/v2/1-clicks/kubernetes&#x60;. The &#x60;addon_slugs&#x60; and
     * &#x60;cluster_uuid&#x60; must be provided as body parameter in order to
     * specify which 1-Click application(s) to install. To list all available
     * 1-Click Kubernetes applications, send a request to
     * &#x60;/v2/1-clicks?type&#x3D;kubernetes&#x60;.
     *
     * @param OneClickCreate (required)
     * @return ApiResponse&lt;InstallKubernetesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<InstallKubernetesResponse> installKubernetesWithHttpInfo(OneClickCreate OneClickCreate) {
        HttpRequest.Builder localVarRequestBuilder = installKubernetesRequestBuilder(OneClickCreate);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("installKubernetes", localVarResponse);
                }
                return new ApiResponse<InstallKubernetesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<InstallKubernetesResponse>() {
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

    private HttpRequest.Builder installKubernetesRequestBuilder(OneClickCreate OneClickCreate) {
        // verify the required parameter 'OneClickCreate' is set
        if (OneClickCreate == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'OneClickCreate' when calling installKubernetes");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/1-clicks/kubernetes";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(OneClickCreate);
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
}
