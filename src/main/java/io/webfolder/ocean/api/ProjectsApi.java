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

import io.webfolder.ocean.client.ApiClient;
import io.webfolder.ocean.client.ApiException;
import io.webfolder.ocean.client.ApiResponse;
import io.webfolder.ocean.model.CreateProjectRequest;
import io.webfolder.ocean.model.CreateProjectResponse;
import io.webfolder.ocean.model.GetDefaultProjectResponse;
import io.webfolder.ocean.model.ListProjectsResponse;
import io.webfolder.ocean.model.Project;
import io.webfolder.ocean.model.UpdateDefaultProjectRequest;

public class ProjectsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public ProjectsApi() {
        this(new ApiClient());
    }

    public ProjectsApi(ApiClient apiClient) {
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
     * Create a Project To create a project, send a POST request to
     * &#x60;/v2/projects&#x60;.
     *
     * @param createProjectRequest (required)
     * @return CreateProjectResponse
     * @throws ApiException if fails to make API call
     */
    public CreateProjectResponse createProject(CreateProjectRequest createProjectRequest) {
        ApiResponse<CreateProjectResponse> localVarResponse = createProjectWithHttpInfo(createProjectRequest);
        return localVarResponse.getData();
    }

    /**
     * Create a Project To create a project, send a POST request to
     * &#x60;/v2/projects&#x60;.
     *
     * @param createProjectRequest (required)
     * @return ApiResponse&lt;CreateProjectResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateProjectResponse> createProjectWithHttpInfo(CreateProjectRequest createProjectRequest) {
        HttpRequest.Builder localVarRequestBuilder = createProjectRequestBuilder(createProjectRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createProject", localVarResponse);
                }
                return new ApiResponse<CreateProjectResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateProjectResponse>() {
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

    private HttpRequest.Builder createProjectRequestBuilder(CreateProjectRequest createProjectRequest) {
        // verify the required parameter 'createProjectRequest' is set
        if (createProjectRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'createProjectRequest' when calling createProject");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createProjectRequest);
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
     * Delete an Existing Project To delete a project, send a DELETE request to
     * &#x60;/v2/projects/$PROJECT_ID&#x60;. To be deleted, a project must not have
     * any resources assigned to it. Any existing resources must first be reassigned
     * or destroyed, or you will receive a 412 error. A successful request will
     * receive a 204 status code with no body in response. This indicates that the
     * request was processed successfully.
     *
     * @param projectId A unique identifier for a project. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteProject(UUID projectId) {
        deleteProjectWithHttpInfo(projectId);
    }

    /**
     * Delete an Existing Project To delete a project, send a DELETE request to
     * &#x60;/v2/projects/$PROJECT_ID&#x60;. To be deleted, a project must not have
     * any resources assigned to it. Any existing resources must first be reassigned
     * or destroyed, or you will receive a 412 error. A successful request will
     * receive a 204 status code with no body in response. This indicates that the
     * request was processed successfully.
     *
     * @param projectId A unique identifier for a project. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteProjectWithHttpInfo(UUID projectId) {
        HttpRequest.Builder localVarRequestBuilder = deleteProjectRequestBuilder(projectId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteProject", localVarResponse);
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

    private HttpRequest.Builder deleteProjectRequestBuilder(UUID projectId) {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteProject");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/{project_id}".replace("{project_id}",
                ApiClient.urlEncode(projectId.toString()));

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
     * Retrieve the Default Project To get your default project, send a GET request
     * to &#x60;/v2/projects/default&#x60;.
     *
     * @return GetDefaultProjectResponse
     * @throws ApiException if fails to make API call
     */
    public GetDefaultProjectResponse getDefaultProject() {
        ApiResponse<GetDefaultProjectResponse> localVarResponse = getDefaultProjectWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * Retrieve the Default Project To get your default project, send a GET request
     * to &#x60;/v2/projects/default&#x60;.
     *
     * @return ApiResponse&lt;GetDefaultProjectResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<GetDefaultProjectResponse> getDefaultProjectWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = getDefaultProjectRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDefaultProject", localVarResponse);
                }
                return new ApiResponse<GetDefaultProjectResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<GetDefaultProjectResponse>() {
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

    private HttpRequest.Builder getDefaultProjectRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/default";

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
     * Retrieve an Existing Project To get a project, send a GET request to
     * &#x60;/v2/projects/$PROJECT_ID&#x60;.
     *
     * @param projectId A unique identifier for a project. (required)
     * @return CreateProjectResponse
     * @throws ApiException if fails to make API call
     */
    public CreateProjectResponse getProject(UUID projectId) {
        ApiResponse<CreateProjectResponse> localVarResponse = getProjectWithHttpInfo(projectId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Project To get a project, send a GET request to
     * &#x60;/v2/projects/$PROJECT_ID&#x60;.
     *
     * @param projectId A unique identifier for a project. (required)
     * @return ApiResponse&lt;CreateProjectResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateProjectResponse> getProjectWithHttpInfo(UUID projectId) {
        HttpRequest.Builder localVarRequestBuilder = getProjectRequestBuilder(projectId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getProject", localVarResponse);
                }
                return new ApiResponse<CreateProjectResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateProjectResponse>() {
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

    private HttpRequest.Builder getProjectRequestBuilder(UUID projectId) {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProject");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/{project_id}".replace("{project_id}",
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

    /**
     * List All Projects To list all your projects, send a GET request to
     * &#x60;/v2/projects&#x60;.
     *
     * @return ListProjectsResponse
     * @throws ApiException if fails to make API call
     */
    public ListProjectsResponse listProjects() {
        ApiResponse<ListProjectsResponse> localVarResponse = listProjectsWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List All Projects To list all your projects, send a GET request to
     * &#x60;/v2/projects&#x60;.
     *
     * @return ApiResponse&lt;ListProjectsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListProjectsResponse> listProjectsWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listProjectsRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listProjects", localVarResponse);
                }
                return new ApiResponse<ListProjectsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListProjectsResponse>() {
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

    private HttpRequest.Builder listProjectsRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects";

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
     * Patch the Default Project To update only specific attributes of a project,
     * send a PATCH request to &#x60;/v2/projects/default&#x60;. At least one of the
     * following attributes needs to be sent.
     *
     * @param project (required)
     * @return CreateProjectResponse
     * @throws ApiException if fails to make API call
     */
    public CreateProjectResponse patchDefaultProject(Project project) {
        ApiResponse<CreateProjectResponse> localVarResponse = patchDefaultProjectWithHttpInfo(project);
        return localVarResponse.getData();
    }

    /**
     * Patch the Default Project To update only specific attributes of a project,
     * send a PATCH request to &#x60;/v2/projects/default&#x60;. At least one of the
     * following attributes needs to be sent.
     *
     * @param project (required)
     * @return ApiResponse&lt;CreateProjectResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateProjectResponse> patchDefaultProjectWithHttpInfo(Project project) {
        HttpRequest.Builder localVarRequestBuilder = patchDefaultProjectRequestBuilder(project);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("patchDefaultProject", localVarResponse);
                }
                return new ApiResponse<CreateProjectResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateProjectResponse>() {
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

    private HttpRequest.Builder patchDefaultProjectRequestBuilder(Project project) {
        // verify the required parameter 'project' is set
        if (project == null) {
            throw new ApiException(400, "Missing the required parameter 'project' when calling patchDefaultProject");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/default";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(project);
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
     * Patch a Project To update only specific attributes of a project, send a PATCH
     * request to &#x60;/v2/projects/$PROJECT_ID&#x60;. At least one of the
     * following attributes needs to be sent.
     *
     * @param projectId A unique identifier for a project. (required)
     * @param project   (required)
     * @return CreateProjectResponse
     * @throws ApiException if fails to make API call
     */
    public CreateProjectResponse patchProject(UUID projectId, Project project) {
        ApiResponse<CreateProjectResponse> localVarResponse = patchProjectWithHttpInfo(projectId, project);
        return localVarResponse.getData();
    }

    /**
     * Patch a Project To update only specific attributes of a project, send a PATCH
     * request to &#x60;/v2/projects/$PROJECT_ID&#x60;. At least one of the
     * following attributes needs to be sent.
     *
     * @param projectId A unique identifier for a project. (required)
     * @param project   (required)
     * @return ApiResponse&lt;CreateProjectResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateProjectResponse> patchProjectWithHttpInfo(UUID projectId, Project project) {
        HttpRequest.Builder localVarRequestBuilder = patchProjectRequestBuilder(projectId, project);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("patchProject", localVarResponse);
                }
                return new ApiResponse<CreateProjectResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateProjectResponse>() {
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

    private HttpRequest.Builder patchProjectRequestBuilder(UUID projectId, Project project) {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException(400, "Missing the required parameter 'projectId' when calling patchProject");
        }
        // verify the required parameter 'project' is set
        if (project == null) {
            throw new ApiException(400, "Missing the required parameter 'project' when calling patchProject");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/{project_id}".replace("{project_id}",
                ApiClient.urlEncode(projectId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(project);
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
     * Update the Default Project To update a project, send a PUT request to
     * &#x60;/v2/projects/default&#x60;. All of the following attributes must be
     * sent.
     *
     * @param updateDefaultProjectRequest (required)
     * @return CreateProjectResponse
     * @throws ApiException if fails to make API call
     */
    public CreateProjectResponse updateDefaultProject(UpdateDefaultProjectRequest updateDefaultProjectRequest) {
        ApiResponse<CreateProjectResponse> localVarResponse = updateDefaultProjectWithHttpInfo(
                updateDefaultProjectRequest);
        return localVarResponse.getData();
    }

    /**
     * Update the Default Project To update a project, send a PUT request to
     * &#x60;/v2/projects/default&#x60;. All of the following attributes must be
     * sent.
     *
     * @param updateDefaultProjectRequest (required)
     * @return ApiResponse&lt;CreateProjectResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateProjectResponse> updateDefaultProjectWithHttpInfo(
            UpdateDefaultProjectRequest updateDefaultProjectRequest) {
        HttpRequest.Builder localVarRequestBuilder = updateDefaultProjectRequestBuilder(updateDefaultProjectRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateDefaultProject", localVarResponse);
                }
                return new ApiResponse<CreateProjectResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateProjectResponse>() {
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

    private HttpRequest.Builder updateDefaultProjectRequestBuilder(
            UpdateDefaultProjectRequest updateDefaultProjectRequest) {
        // verify the required parameter 'updateDefaultProjectRequest' is set
        if (updateDefaultProjectRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'updateDefaultProjectRequest' when calling updateDefaultProject");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/default";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateDefaultProjectRequest);
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

    /**
     * Update a Project To update a project, send a PUT request to
     * &#x60;/v2/projects/$PROJECT_ID&#x60;. All of the following attributes must be
     * sent.
     *
     * @param projectId                   A unique identifier for a project.
     *                                    (required)
     * @param updateDefaultProjectRequest (required)
     * @return CreateProjectResponse
     * @throws ApiException if fails to make API call
     */
    public CreateProjectResponse updateProject(UUID projectId,
            UpdateDefaultProjectRequest updateDefaultProjectRequest) {
        ApiResponse<CreateProjectResponse> localVarResponse = updateProjectWithHttpInfo(projectId,
                updateDefaultProjectRequest);
        return localVarResponse.getData();
    }

    /**
     * Update a Project To update a project, send a PUT request to
     * &#x60;/v2/projects/$PROJECT_ID&#x60;. All of the following attributes must be
     * sent.
     *
     * @param projectId                   A unique identifier for a project.
     *                                    (required)
     * @param updateDefaultProjectRequest (required)
     * @return ApiResponse&lt;CreateProjectResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<CreateProjectResponse> updateProjectWithHttpInfo(UUID projectId,
            UpdateDefaultProjectRequest updateDefaultProjectRequest) {
        HttpRequest.Builder localVarRequestBuilder = updateProjectRequestBuilder(projectId,
                updateDefaultProjectRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateProject", localVarResponse);
                }
                return new ApiResponse<CreateProjectResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<CreateProjectResponse>() {
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

    private HttpRequest.Builder updateProjectRequestBuilder(UUID projectId,
            UpdateDefaultProjectRequest updateDefaultProjectRequest) {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateProject");
        }
        // verify the required parameter 'updateDefaultProjectRequest' is set
        if (updateDefaultProjectRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'updateDefaultProjectRequest' when calling updateProject");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/projects/{project_id}".replace("{project_id}",
                ApiClient.urlEncode(projectId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateDefaultProjectRequest);
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
