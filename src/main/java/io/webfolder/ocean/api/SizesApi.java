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
import io.webfolder.ocean.model.ListAllSizesResponse;

public class SizesApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public SizesApi() {
        this(new ApiClient());
    }

    public SizesApi(ApiClient apiClient) {
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
     * List All Droplet Sizes To list all of available Droplet sizes, send a GET
     * request to &#x60;/v2/sizes&#x60;. The response will be a JSON object with a
     * key called &#x60;sizes&#x60;. The value of this will be an array of
     * &#x60;size&#x60; objects each of which contain the standard size attributes.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ListAllSizesResponse
     * @throws ApiException if fails to make API call
     */
    public ListAllSizesResponse listAllSizes(Integer perPage, Integer page) {
        ApiResponse<ListAllSizesResponse> localVarResponse = listAllSizesWithHttpInfo(perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List All Droplet Sizes To list all of available Droplet sizes, send a GET
     * request to &#x60;/v2/sizes&#x60;. The response will be a JSON object with a
     * key called &#x60;sizes&#x60;. The value of this will be an array of
     * &#x60;size&#x60; objects each of which contain the standard size attributes.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ApiResponse&lt;ListAllSizesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAllSizesResponse> listAllSizesWithHttpInfo(Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listAllSizesRequestBuilder(perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAllSizes", localVarResponse);
                }
                return new ApiResponse<ListAllSizesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAllSizesResponse>() {
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

    private HttpRequest.Builder listAllSizesRequestBuilder(Integer perPage, Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/sizes";

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
