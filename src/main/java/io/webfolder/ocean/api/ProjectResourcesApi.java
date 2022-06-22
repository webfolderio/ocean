package io.webfolder.ocean.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.UUID;
import java.util.function.Consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.webfolder.ocean.ApiClient;
import io.webfolder.ocean.ApiException;
import io.webfolder.ocean.ApiResponse;
import io.webfolder.ocean.model.AssignProjectResourcesResponse;
import io.webfolder.ocean.model.ListProjectResourcesResponse;
import io.webfolder.ocean.model.ProjectAssignment;

public class ProjectResourcesApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public ProjectResourcesApi() {
        this(new ApiClient());
    }

    public ProjectResourcesApi(ApiClient apiClient) {
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
     * Assign Resources to Default Project To assign resources to your default
     * project, send a POST request to &#x60;/v2/projects/default/resources&#x60;.
     *
     * @param projectAssignment (required)
     * @return AssignProjectResourcesResponse
     * @throws ApiException if fails to make API call
     */
    public AssignProjectResourcesResponse assignDefaultProjectResources(ProjectAssignment projectAssignment) {
        ApiResponse<AssignProjectResourcesResponse> localVarResponse = assignDefaultProjectResourcesWithHttpInfo(
                projectAssignment);
        return localVarResponse.getData();
    }

    /**
     * Assign Resources to Default Project To assign resources to your default
     * project, send a POST request to &#x60;/v2/projects/default/resources&#x60;.
     *
     * @param projectAssignment (required)
     * @return ApiResponse&lt;AssignProjectResourcesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AssignProjectResourcesResponse> assignDefaultProjectResourcesWithHttpInfo(
            ProjectAssignment projectAssignment) {
        HttpRequest.Builder localVarRequestBuilder = assignDefaultProjectResourcesRequestBuilder(projectAssignment);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("assignDefaultProjectResources", localVarResponse);
                }
                return new ApiResponse<AssignProjectResourcesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AssignProjectResourcesResponse>() {
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

    private HttpRequest.Builder assignDefaultProjectResourcesRequestBuilder(ProjectAssignment projectAssignment) {
        // verify the required parameter 'projectAssignment' is set
        if (projectAssignment == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'projectAssignment' when calling assignDefaultProjectResources");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/default/resources";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(projectAssignment);
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
     * Assign Resources to a Project To assign resources to a project, send a POST
     * request to &#x60;/v2/projects/$PROJECT_ID/resources&#x60;.
     *
     * @param projectId         A unique identifier for a project. (required)
     * @param projectAssignment (required)
     * @return AssignProjectResourcesResponse
     * @throws ApiException if fails to make API call
     */
    public AssignProjectResourcesResponse assignProjectResources(UUID projectId, ProjectAssignment projectAssignment) {
        ApiResponse<AssignProjectResourcesResponse> localVarResponse = assignProjectResourcesWithHttpInfo(projectId,
                projectAssignment);
        return localVarResponse.getData();
    }

    /**
     * Assign Resources to a Project To assign resources to a project, send a POST
     * request to &#x60;/v2/projects/$PROJECT_ID/resources&#x60;.
     *
     * @param projectId         A unique identifier for a project. (required)
     * @param projectAssignment (required)
     * @return ApiResponse&lt;AssignProjectResourcesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AssignProjectResourcesResponse> assignProjectResourcesWithHttpInfo(UUID projectId,
            ProjectAssignment projectAssignment) {
        HttpRequest.Builder localVarRequestBuilder = assignProjectResourcesRequestBuilder(projectId, projectAssignment);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("assignProjectResources", localVarResponse);
                }
                return new ApiResponse<AssignProjectResourcesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AssignProjectResourcesResponse>() {
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

    private HttpRequest.Builder assignProjectResourcesRequestBuilder(UUID projectId,
            ProjectAssignment projectAssignment) {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'projectId' when calling assignProjectResources");
        }
        // verify the required parameter 'projectAssignment' is set
        if (projectAssignment == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'projectAssignment' when calling assignProjectResources");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/{project_id}/resources".replace("{project_id}",
                ApiClient.urlEncode(projectId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(projectAssignment);
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
     * List Default Project Resources To list all your resources in your default
     * project, send a GET request to &#x60;/v2/projects/default/resources&#x60;.
     *
     * @return ListProjectResourcesResponse
     * @throws ApiException if fails to make API call
     */
    public ListProjectResourcesResponse listDefaultProjectResources() {
        ApiResponse<ListProjectResourcesResponse> localVarResponse = listDefaultProjectResourcesWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List Default Project Resources To list all your resources in your default
     * project, send a GET request to &#x60;/v2/projects/default/resources&#x60;.
     *
     * @return ApiResponse&lt;ListProjectResourcesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListProjectResourcesResponse> listDefaultProjectResourcesWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listDefaultProjectResourcesRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDefaultProjectResources", localVarResponse);
                }
                return new ApiResponse<ListProjectResourcesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListProjectResourcesResponse>() {
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

    private HttpRequest.Builder listDefaultProjectResourcesRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/default/resources";

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
     * List Project Resources To list all your resources in a project, send a GET
     * request to &#x60;/v2/projects/$PROJECT_ID/resources&#x60;.
     *
     * @param projectId A unique identifier for a project. (required)
     * @return ListProjectResourcesResponse
     * @throws ApiException if fails to make API call
     */
    public ListProjectResourcesResponse listProjectResources(UUID projectId) {
        ApiResponse<ListProjectResourcesResponse> localVarResponse = listProjectResourcesWithHttpInfo(projectId);
        return localVarResponse.getData();
    }

    /**
     * List Project Resources To list all your resources in a project, send a GET
     * request to &#x60;/v2/projects/$PROJECT_ID/resources&#x60;.
     *
     * @param projectId A unique identifier for a project. (required)
     * @return ApiResponse&lt;ListProjectResourcesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListProjectResourcesResponse> listProjectResourcesWithHttpInfo(UUID projectId) {
        HttpRequest.Builder localVarRequestBuilder = listProjectResourcesRequestBuilder(projectId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listProjectResources", localVarResponse);
                }
                return new ApiResponse<ListProjectResourcesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListProjectResourcesResponse>() {
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

    private HttpRequest.Builder listProjectResourcesRequestBuilder(UUID projectId) {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException(400, "Missing the required parameter 'projectId' when calling listProjectResources");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/{project_id}/resources".replace("{project_id}",
                ApiClient.urlEncode(projectId.toString()));

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
