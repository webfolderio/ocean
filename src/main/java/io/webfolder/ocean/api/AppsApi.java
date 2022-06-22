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
import io.webfolder.ocean.model.AppPropose;
import io.webfolder.ocean.model.AppProposeResponse;
import io.webfolder.ocean.model.AppResponse;
import io.webfolder.ocean.model.AppsAlertResponse;
import io.webfolder.ocean.model.AppsAssignAppAlertDestinationsRequest;
import io.webfolder.ocean.model.AppsCreateAppRequest;
import io.webfolder.ocean.model.AppsCreateDeploymentRequest;
import io.webfolder.ocean.model.AppsDeleteAppResponse;
import io.webfolder.ocean.model.AppsDeploymentResponse;
import io.webfolder.ocean.model.AppsDeploymentsResponse;
import io.webfolder.ocean.model.AppsGetInstanceSizeResponse;
import io.webfolder.ocean.model.AppsGetLogsResponse;
import io.webfolder.ocean.model.AppsGetTierResponse;
import io.webfolder.ocean.model.AppsListAlertsResponse;
import io.webfolder.ocean.model.AppsListInstanceSizesResponse;
import io.webfolder.ocean.model.AppsListRegionsResponse;
import io.webfolder.ocean.model.AppsListTiersResponse;
import io.webfolder.ocean.model.AppsResponse;
import io.webfolder.ocean.model.AppsRollbackAppRequest;
import io.webfolder.ocean.model.AppsUpdateAppRequest;
import io.webfolder.ocean.model.ValidateAppRollbackResponse;

public class AppsApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public AppsApi() {
        this(new ApiClient());
    }

    public AppsApi(ApiClient apiClient) {
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
     * Update destinations for alerts Updates the emails and slack webhook
     * destinations for app alerts. Emails must be associated to a user with access
     * to the app.
     *
     * @param appId                                 The app ID (required)
     * @param alertId                               The alert ID (required)
     * @param appsAssignAppAlertDestinationsRequest (required)
     * @return AppsAlertResponse
     * @throws ApiException if fails to make API call
     */
    public AppsAlertResponse assignAlertDestinations(String appId, String alertId,
            AppsAssignAppAlertDestinationsRequest appsAssignAppAlertDestinationsRequest) {
        ApiResponse<AppsAlertResponse> localVarResponse = assignAlertDestinationsWithHttpInfo(appId, alertId,
                appsAssignAppAlertDestinationsRequest);
        return localVarResponse.getData();
    }

    /**
     * Update destinations for alerts Updates the emails and slack webhook
     * destinations for app alerts. Emails must be associated to a user with access
     * to the app.
     *
     * @param appId                                 The app ID (required)
     * @param alertId                               The alert ID (required)
     * @param appsAssignAppAlertDestinationsRequest (required)
     * @return ApiResponse&lt;AppsAlertResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsAlertResponse> assignAlertDestinationsWithHttpInfo(String appId, String alertId,
            AppsAssignAppAlertDestinationsRequest appsAssignAppAlertDestinationsRequest) {
        HttpRequest.Builder localVarRequestBuilder = assignAlertDestinationsRequestBuilder(appId, alertId,
                appsAssignAppAlertDestinationsRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("assignAlertDestinations", localVarResponse);
                }
                return new ApiResponse<AppsAlertResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsAlertResponse>() {
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

    private HttpRequest.Builder assignAlertDestinationsRequestBuilder(String appId, String alertId,
            AppsAssignAppAlertDestinationsRequest appsAssignAppAlertDestinationsRequest) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling assignAlertDestinations");
        }
        // verify the required parameter 'alertId' is set
        if (alertId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'alertId' when calling assignAlertDestinations");
        }
        // verify the required parameter 'appsAssignAppAlertDestinationsRequest' is set
        if (appsAssignAppAlertDestinationsRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'appsAssignAppAlertDestinationsRequest' when calling assignAlertDestinations");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/alerts/{alert_id}/destinations"
                .replace("{app_id}", ApiClient.urlEncode(appId.toString()))
                .replace("{alert_id}", ApiClient.urlEncode(alertId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(appsAssignAppAlertDestinationsRequest);
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
     * Create a New App Create a new app by submitting an app specification. For
     * documentation on app specifications (&#x60;AppSpec&#x60; objects), please
     * refer to [the product
     * documentation](https://www.digitalocean.com/docs/app-platform/references/app-specification-reference/).
     *
     * @param appsCreateAppRequest (required)
     * @return AppResponse
     * @throws ApiException if fails to make API call
     */
    public AppResponse createApp(AppsCreateAppRequest appsCreateAppRequest) {
        ApiResponse<AppResponse> localVarResponse = createAppWithHttpInfo(appsCreateAppRequest);
        return localVarResponse.getData();
    }

    /**
     * Create a New App Create a new app by submitting an app specification. For
     * documentation on app specifications (&#x60;AppSpec&#x60; objects), please
     * refer to [the product
     * documentation](https://www.digitalocean.com/docs/app-platform/references/app-specification-reference/).
     *
     * @param appsCreateAppRequest (required)
     * @return ApiResponse&lt;AppResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppResponse> createAppWithHttpInfo(AppsCreateAppRequest appsCreateAppRequest) {
        HttpRequest.Builder localVarRequestBuilder = createAppRequestBuilder(appsCreateAppRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createApp", localVarResponse);
                }
                return new ApiResponse<AppResponse>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AppResponse>() {
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

    private HttpRequest.Builder createAppRequestBuilder(AppsCreateAppRequest appsCreateAppRequest) {
        // verify the required parameter 'appsCreateAppRequest' is set
        if (appsCreateAppRequest == null) {
            throw new ApiException(400, "Missing the required parameter 'appsCreateAppRequest' when calling createApp");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(appsCreateAppRequest);
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
     * Rollback App Rollback an app to a previous deployment. A new deployment will
     * be created to perform the rollback. The app will be pinned to the rollback
     * deployment preventing any new deployments from being created, either manually
     * or through Auto Deploy on Push webhooks. To resume deployments, the rollback
     * must be either committed or reverted. It is recommended to use the Validate
     * App Rollback endpoint to double check if the rollback is valid and if there
     * are any warnings.
     *
     * @param appId                  The app ID (required)
     * @param appsRollbackAppRequest (required)
     * @return AppsDeploymentResponse
     * @throws ApiException if fails to make API call
     */
    public AppsDeploymentResponse createAppRollback(String appId, AppsRollbackAppRequest appsRollbackAppRequest) {
        ApiResponse<AppsDeploymentResponse> localVarResponse = createAppRollbackWithHttpInfo(appId,
                appsRollbackAppRequest);
        return localVarResponse.getData();
    }

    /**
     * Rollback App Rollback an app to a previous deployment. A new deployment will
     * be created to perform the rollback. The app will be pinned to the rollback
     * deployment preventing any new deployments from being created, either manually
     * or through Auto Deploy on Push webhooks. To resume deployments, the rollback
     * must be either committed or reverted. It is recommended to use the Validate
     * App Rollback endpoint to double check if the rollback is valid and if there
     * are any warnings.
     *
     * @param appId                  The app ID (required)
     * @param appsRollbackAppRequest (required)
     * @return ApiResponse&lt;AppsDeploymentResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsDeploymentResponse> createAppRollbackWithHttpInfo(String appId,
            AppsRollbackAppRequest appsRollbackAppRequest) {
        HttpRequest.Builder localVarRequestBuilder = createAppRollbackRequestBuilder(appId, appsRollbackAppRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createAppRollback", localVarResponse);
                }
                return new ApiResponse<AppsDeploymentResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsDeploymentResponse>() {
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

    private HttpRequest.Builder createAppRollbackRequestBuilder(String appId,
            AppsRollbackAppRequest appsRollbackAppRequest) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling createAppRollback");
        }
        // verify the required parameter 'appsRollbackAppRequest' is set
        if (appsRollbackAppRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'appsRollbackAppRequest' when calling createAppRollback");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/rollback".replace("{app_id}", ApiClient.urlEncode(appId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(appsRollbackAppRequest);
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
     * Create an App Deployment Creating an app deployment will pull the latest
     * changes from your repository and schedule a new deployment for your app.
     *
     * @param appId                       The app ID (required)
     * @param appsCreateDeploymentRequest (required)
     * @return AppsDeploymentResponse
     * @throws ApiException if fails to make API call
     */
    public AppsDeploymentResponse createDeployment(String appId,
            AppsCreateDeploymentRequest appsCreateDeploymentRequest) {
        ApiResponse<AppsDeploymentResponse> localVarResponse = createDeploymentWithHttpInfo(appId,
                appsCreateDeploymentRequest);
        return localVarResponse.getData();
    }

    /**
     * Create an App Deployment Creating an app deployment will pull the latest
     * changes from your repository and schedule a new deployment for your app.
     *
     * @param appId                       The app ID (required)
     * @param appsCreateDeploymentRequest (required)
     * @return ApiResponse&lt;AppsDeploymentResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsDeploymentResponse> createDeploymentWithHttpInfo(String appId,
            AppsCreateDeploymentRequest appsCreateDeploymentRequest) {
        HttpRequest.Builder localVarRequestBuilder = createDeploymentRequestBuilder(appId, appsCreateDeploymentRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createDeployment", localVarResponse);
                }
                return new ApiResponse<AppsDeploymentResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsDeploymentResponse>() {
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

    private HttpRequest.Builder createDeploymentRequestBuilder(String appId,
            AppsCreateDeploymentRequest appsCreateDeploymentRequest) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling createDeployment");
        }
        // verify the required parameter 'appsCreateDeploymentRequest' is set
        if (appsCreateDeploymentRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'appsCreateDeploymentRequest' when calling createDeployment");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/deployments".replace("{app_id}",
                ApiClient.urlEncode(appId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(appsCreateDeploymentRequest);
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
     * Delete an App Delete an existing app. Once deleted, all active deployments
     * will be permanently shut down and the app deleted. If needed, be sure to back
     * up your app specification so that you may re-create it at a later time.
     *
     * @param id The ID of the app (required)
     * @return AppsDeleteAppResponse
     * @throws ApiException if fails to make API call
     */
    public AppsDeleteAppResponse deleteApp(String id) {
        ApiResponse<AppsDeleteAppResponse> localVarResponse = deleteAppWithHttpInfo(id);
        return localVarResponse.getData();
    }

    /**
     * Delete an App Delete an existing app. Once deleted, all active deployments
     * will be permanently shut down and the app deleted. If needed, be sure to back
     * up your app specification so that you may re-create it at a later time.
     *
     * @param id The ID of the app (required)
     * @return ApiResponse&lt;AppsDeleteAppResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsDeleteAppResponse> deleteAppWithHttpInfo(String id) {
        HttpRequest.Builder localVarRequestBuilder = deleteAppRequestBuilder(id);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteApp", localVarResponse);
                }
                return new ApiResponse<AppsDeleteAppResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsDeleteAppResponse>() {
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

    private HttpRequest.Builder deleteAppRequestBuilder(String id) {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException(400, "Missing the required parameter 'id' when calling deleteApp");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{id}".replace("{id}", ApiClient.urlEncode(id.toString()));

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
     * Retrieve an Existing App Retrieve details about an existing app by either its
     * ID or name. To retrieve an app by its name, do not include an ID in the
     * request path. Information about the current active deployment as well as any
     * in progress ones will also be included in the response.
     *
     * @param id   The ID of the app (required)
     * @param name The name of the app to retrieve. (optional)
     * @return AppResponse
     * @throws ApiException if fails to make API call
     */
    public AppResponse getApp(String id, String name) {
        ApiResponse<AppResponse> localVarResponse = getAppWithHttpInfo(id, name);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing App Retrieve details about an existing app by either its
     * ID or name. To retrieve an app by its name, do not include an ID in the
     * request path. Information about the current active deployment as well as any
     * in progress ones will also be included in the response.
     *
     * @param id   The ID of the app (required)
     * @param name The name of the app to retrieve. (optional)
     * @return ApiResponse&lt;AppResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppResponse> getAppWithHttpInfo(String id, String name) {
        HttpRequest.Builder localVarRequestBuilder = getAppRequestBuilder(id, name);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getApp", localVarResponse);
                }
                return new ApiResponse<AppResponse>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AppResponse>() {
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

    private HttpRequest.Builder getAppRequestBuilder(String id, String name) {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException(400, "Missing the required parameter 'id' when calling getApp");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{id}".replace("{id}", ApiClient.urlEncode(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("name", name));

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
     * Retrieve an App Deployment Retrieve information about an app deployment.
     *
     * @param appId        The app ID (required)
     * @param deploymentId The deployment ID (required)
     * @return AppsDeploymentResponse
     * @throws ApiException if fails to make API call
     */
    public AppsDeploymentResponse getDeployment(String appId, String deploymentId) {
        ApiResponse<AppsDeploymentResponse> localVarResponse = getDeploymentWithHttpInfo(appId, deploymentId);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an App Deployment Retrieve information about an app deployment.
     *
     * @param appId        The app ID (required)
     * @param deploymentId The deployment ID (required)
     * @return ApiResponse&lt;AppsDeploymentResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsDeploymentResponse> getDeploymentWithHttpInfo(String appId, String deploymentId) {
        HttpRequest.Builder localVarRequestBuilder = getDeploymentRequestBuilder(appId, deploymentId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDeployment", localVarResponse);
                }
                return new ApiResponse<AppsDeploymentResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsDeploymentResponse>() {
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

    private HttpRequest.Builder getDeploymentRequestBuilder(String appId, String deploymentId) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling getDeployment");
        }
        // verify the required parameter 'deploymentId' is set
        if (deploymentId == null) {
            throw new ApiException(400, "Missing the required parameter 'deploymentId' when calling getDeployment");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/deployments/{deployment_id}"
                .replace("{app_id}", ApiClient.urlEncode(appId.toString()))
                .replace("{deployment_id}", ApiClient.urlEncode(deploymentId.toString()));

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
     * Retrieve an Instance Size Retrieve information about a specific instance size
     * for &#x60;service&#x60;, &#x60;worker&#x60;, and &#x60;job&#x60; components.
     *
     * @param slug The slug of the instance size (required)
     * @return AppsGetInstanceSizeResponse
     * @throws ApiException if fails to make API call
     */
    public AppsGetInstanceSizeResponse getInstanceSize(String slug) {
        ApiResponse<AppsGetInstanceSizeResponse> localVarResponse = getInstanceSizeWithHttpInfo(slug);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Instance Size Retrieve information about a specific instance size
     * for &#x60;service&#x60;, &#x60;worker&#x60;, and &#x60;job&#x60; components.
     *
     * @param slug The slug of the instance size (required)
     * @return ApiResponse&lt;AppsGetInstanceSizeResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsGetInstanceSizeResponse> getInstanceSizeWithHttpInfo(String slug) {
        HttpRequest.Builder localVarRequestBuilder = getInstanceSizeRequestBuilder(slug);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getInstanceSize", localVarResponse);
                }
                return new ApiResponse<AppsGetInstanceSizeResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsGetInstanceSizeResponse>() {
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

    private HttpRequest.Builder getInstanceSizeRequestBuilder(String slug) {
        // verify the required parameter 'slug' is set
        if (slug == null) {
            throw new ApiException(400, "Missing the required parameter 'slug' when calling getInstanceSize");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/tiers/instance_sizes/{slug}".replace("{slug}",
                ApiClient.urlEncode(slug.toString()));

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
     * Retrieve Deployment Logs Retrieve the logs of a past, in-progress, or active
     * deployment. If a component name is specified, the logs will be limited to
     * only that component. The response will include links to either real-time logs
     * of an in-progress or active deployment or archived logs of a past deployment.
     *
     * @param appId                The app ID (required)
     * @param deploymentId         The deployment ID (required)
     * @param componentName        An optional component name. If set, logs will be
     *                             limited to this component only. (required)
     * @param type                 The type of logs to retrieve - BUILD: Build-time
     *                             logs - DEPLOY: Deploy-time logs - RUN: Live
     *                             run-time logs (required)
     * @param follow               Whether the logs should follow live updates.
     *                             (optional)
     * @param podConnectionTimeout An optional time duration to wait if the
     *                             underlying component instance is not immediately
     *                             available. Default: &#x60;3m&#x60;. (optional)
     * @return AppsGetLogsResponse
     * @throws ApiException if fails to make API call
     */
    public AppsGetLogsResponse getLogs(String appId, String deploymentId, String componentName, String type,
            Boolean follow, String podConnectionTimeout) {
        ApiResponse<AppsGetLogsResponse> localVarResponse = getLogsWithHttpInfo(appId, deploymentId, componentName,
                type, follow, podConnectionTimeout);
        return localVarResponse.getData();
    }

    /**
     * Retrieve Deployment Logs Retrieve the logs of a past, in-progress, or active
     * deployment. If a component name is specified, the logs will be limited to
     * only that component. The response will include links to either real-time logs
     * of an in-progress or active deployment or archived logs of a past deployment.
     *
     * @param appId                The app ID (required)
     * @param deploymentId         The deployment ID (required)
     * @param componentName        An optional component name. If set, logs will be
     *                             limited to this component only. (required)
     * @param type                 The type of logs to retrieve - BUILD: Build-time
     *                             logs - DEPLOY: Deploy-time logs - RUN: Live
     *                             run-time logs (required)
     * @param follow               Whether the logs should follow live updates.
     *                             (optional)
     * @param podConnectionTimeout An optional time duration to wait if the
     *                             underlying component instance is not immediately
     *                             available. Default: &#x60;3m&#x60;. (optional)
     * @return ApiResponse&lt;AppsGetLogsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsGetLogsResponse> getLogsWithHttpInfo(String appId, String deploymentId, String componentName,
            String type, Boolean follow, String podConnectionTimeout) {
        HttpRequest.Builder localVarRequestBuilder = getLogsRequestBuilder(appId, deploymentId, componentName, type,
                follow, podConnectionTimeout);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getLogs", localVarResponse);
                }
                return new ApiResponse<AppsGetLogsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsGetLogsResponse>() {
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

    private HttpRequest.Builder getLogsRequestBuilder(String appId, String deploymentId, String componentName,
            String type, Boolean follow, String podConnectionTimeout) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling getLogs");
        }
        // verify the required parameter 'deploymentId' is set
        if (deploymentId == null) {
            throw new ApiException(400, "Missing the required parameter 'deploymentId' when calling getLogs");
        }
        // verify the required parameter 'componentName' is set
        if (componentName == null) {
            throw new ApiException(400, "Missing the required parameter 'componentName' when calling getLogs");
        }
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new ApiException(400, "Missing the required parameter 'type' when calling getLogs");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/deployments/{deployment_id}/components/{component_name}/logs"
                .replace("{app_id}", ApiClient.urlEncode(appId.toString()))
                .replace("{deployment_id}", ApiClient.urlEncode(deploymentId.toString()))
                .replace("{component_name}", ApiClient.urlEncode(componentName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("follow", follow));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("type", type));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("pod_connection_timeout", podConnectionTimeout));

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
     * Retrieve Aggregate Deployment Logs Retrieve the logs of a past, in-progress,
     * or active deployment. If a component name is specified, the logs will be
     * limited to only that component. The response will include links to either
     * real-time logs of an in-progress or active deployment or archived logs of a
     * past deployment.
     *
     * @param appId                The app ID (required)
     * @param deploymentId         The deployment ID (required)
     * @param type                 The type of logs to retrieve - BUILD: Build-time
     *                             logs - DEPLOY: Deploy-time logs - RUN: Live
     *                             run-time logs (required)
     * @param follow               Whether the logs should follow live updates.
     *                             (optional)
     * @param podConnectionTimeout An optional time duration to wait if the
     *                             underlying component instance is not immediately
     *                             available. Default: &#x60;3m&#x60;. (optional)
     * @return AppsGetLogsResponse
     * @throws ApiException if fails to make API call
     */
    public AppsGetLogsResponse getLogsAggregate(String appId, String deploymentId, String type, Boolean follow,
            String podConnectionTimeout) {
        ApiResponse<AppsGetLogsResponse> localVarResponse = getLogsAggregateWithHttpInfo(appId, deploymentId, type,
                follow, podConnectionTimeout);
        return localVarResponse.getData();
    }

    /**
     * Retrieve Aggregate Deployment Logs Retrieve the logs of a past, in-progress,
     * or active deployment. If a component name is specified, the logs will be
     * limited to only that component. The response will include links to either
     * real-time logs of an in-progress or active deployment or archived logs of a
     * past deployment.
     *
     * @param appId                The app ID (required)
     * @param deploymentId         The deployment ID (required)
     * @param type                 The type of logs to retrieve - BUILD: Build-time
     *                             logs - DEPLOY: Deploy-time logs - RUN: Live
     *                             run-time logs (required)
     * @param follow               Whether the logs should follow live updates.
     *                             (optional)
     * @param podConnectionTimeout An optional time duration to wait if the
     *                             underlying component instance is not immediately
     *                             available. Default: &#x60;3m&#x60;. (optional)
     * @return ApiResponse&lt;AppsGetLogsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsGetLogsResponse> getLogsAggregateWithHttpInfo(String appId, String deploymentId, String type,
            Boolean follow, String podConnectionTimeout) {
        HttpRequest.Builder localVarRequestBuilder = getLogsAggregateRequestBuilder(appId, deploymentId, type, follow,
                podConnectionTimeout);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getLogsAggregate", localVarResponse);
                }
                return new ApiResponse<AppsGetLogsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsGetLogsResponse>() {
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

    private HttpRequest.Builder getLogsAggregateRequestBuilder(String appId, String deploymentId, String type,
            Boolean follow, String podConnectionTimeout) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling getLogsAggregate");
        }
        // verify the required parameter 'deploymentId' is set
        if (deploymentId == null) {
            throw new ApiException(400, "Missing the required parameter 'deploymentId' when calling getLogsAggregate");
        }
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new ApiException(400, "Missing the required parameter 'type' when calling getLogsAggregate");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/deployments/{deployment_id}/logs"
                .replace("{app_id}", ApiClient.urlEncode(appId.toString()))
                .replace("{deployment_id}", ApiClient.urlEncode(deploymentId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("follow", follow));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("type", type));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("pod_connection_timeout", podConnectionTimeout));

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
     * Retrieve an App Tier Retrieve information about a specific app tier.
     *
     * @param slug The slug of the tier (required)
     * @return AppsGetTierResponse
     * @throws ApiException if fails to make API call
     */
    public AppsGetTierResponse getTier(String slug) {
        ApiResponse<AppsGetTierResponse> localVarResponse = getTierWithHttpInfo(slug);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an App Tier Retrieve information about a specific app tier.
     *
     * @param slug The slug of the tier (required)
     * @return ApiResponse&lt;AppsGetTierResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsGetTierResponse> getTierWithHttpInfo(String slug) {
        HttpRequest.Builder localVarRequestBuilder = getTierRequestBuilder(slug);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getTier", localVarResponse);
                }
                return new ApiResponse<AppsGetTierResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsGetTierResponse>() {
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

    private HttpRequest.Builder getTierRequestBuilder(String slug) {
        // verify the required parameter 'slug' is set
        if (slug == null) {
            throw new ApiException(400, "Missing the required parameter 'slug' when calling getTier");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/tiers/{slug}".replace("{slug}", ApiClient.urlEncode(slug.toString()));

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
     * List all app alerts List alerts associated to the app and any components.
     * This includes configuration information about the alerts including emails,
     * slack webhooks, and triggering events or conditions.
     *
     * @param appId The app ID (required)
     * @return AppsListAlertsResponse
     * @throws ApiException if fails to make API call
     */
    public AppsListAlertsResponse listAlerts(String appId) {
        ApiResponse<AppsListAlertsResponse> localVarResponse = listAlertsWithHttpInfo(appId);
        return localVarResponse.getData();
    }

    /**
     * List all app alerts List alerts associated to the app and any components.
     * This includes configuration information about the alerts including emails,
     * slack webhooks, and triggering events or conditions.
     *
     * @param appId The app ID (required)
     * @return ApiResponse&lt;AppsListAlertsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsListAlertsResponse> listAlertsWithHttpInfo(String appId) {
        HttpRequest.Builder localVarRequestBuilder = listAlertsRequestBuilder(appId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAlerts", localVarResponse);
                }
                return new ApiResponse<AppsListAlertsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsListAlertsResponse>() {
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

    private HttpRequest.Builder listAlertsRequestBuilder(String appId) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling listAlerts");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/alerts".replace("{app_id}", ApiClient.urlEncode(appId.toString()));

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
     * List All Apps List all apps on your account. Information about the current
     * active deployment as well as any in progress ones will also be included for
     * each app.
     *
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @param perPage Number of items returned per page (optional, default to 20)
     * @return AppsResponse
     * @throws ApiException if fails to make API call
     */
    public AppsResponse listApps(Integer page, Integer perPage) {
        ApiResponse<AppsResponse> localVarResponse = listAppsWithHttpInfo(page, perPage);
        return localVarResponse.getData();
    }

    /**
     * List All Apps List all apps on your account. Information about the current
     * active deployment as well as any in progress ones will also be included for
     * each app.
     *
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @param perPage Number of items returned per page (optional, default to 20)
     * @return ApiResponse&lt;AppsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsResponse> listAppsWithHttpInfo(Integer page, Integer perPage) {
        HttpRequest.Builder localVarRequestBuilder = listAppsRequestBuilder(page, perPage);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listApps", localVarResponse);
                }
                return new ApiResponse<AppsResponse>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AppsResponse>() {
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

    private HttpRequest.Builder listAppsRequestBuilder(Integer page, Integer perPage) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("page", page));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("per_page", perPage));

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
     * List App Deployments List all deployments of an app.
     *
     * @param appId   The app ID (required)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @param perPage Number of items returned per page (optional, default to 20)
     * @return AppsDeploymentsResponse
     * @throws ApiException if fails to make API call
     */
    public AppsDeploymentsResponse listDeployments(String appId, Integer page, Integer perPage) {
        ApiResponse<AppsDeploymentsResponse> localVarResponse = listDeploymentsWithHttpInfo(appId, page, perPage);
        return localVarResponse.getData();
    }

    /**
     * List App Deployments List all deployments of an app.
     *
     * @param appId   The app ID (required)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @param perPage Number of items returned per page (optional, default to 20)
     * @return ApiResponse&lt;AppsDeploymentsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsDeploymentsResponse> listDeploymentsWithHttpInfo(String appId, Integer page,
            Integer perPage) {
        HttpRequest.Builder localVarRequestBuilder = listDeploymentsRequestBuilder(appId, page, perPage);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listDeployments", localVarResponse);
                }
                return new ApiResponse<AppsDeploymentsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsDeploymentsResponse>() {
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

    private HttpRequest.Builder listDeploymentsRequestBuilder(String appId, Integer page, Integer perPage) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling listDeployments");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/deployments".replace("{app_id}",
                ApiClient.urlEncode(appId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("page", page));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("per_page", perPage));

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
     * List Instance Sizes List all instance sizes for &#x60;service&#x60;,
     * &#x60;worker&#x60;, and &#x60;job&#x60; components.
     *
     * @return AppsListInstanceSizesResponse
     * @throws ApiException if fails to make API call
     */
    public AppsListInstanceSizesResponse listInstanceSizes() {
        ApiResponse<AppsListInstanceSizesResponse> localVarResponse = listInstanceSizesWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List Instance Sizes List all instance sizes for &#x60;service&#x60;,
     * &#x60;worker&#x60;, and &#x60;job&#x60; components.
     *
     * @return ApiResponse&lt;AppsListInstanceSizesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsListInstanceSizesResponse> listInstanceSizesWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listInstanceSizesRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listInstanceSizes", localVarResponse);
                }
                return new ApiResponse<AppsListInstanceSizesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsListInstanceSizesResponse>() {
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

    private HttpRequest.Builder listInstanceSizesRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/tiers/instance_sizes";

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
     * List App Regions List all regions supported by App Platform.
     *
     * @return AppsListRegionsResponse
     * @throws ApiException if fails to make API call
     */
    public AppsListRegionsResponse listRegions() {
        ApiResponse<AppsListRegionsResponse> localVarResponse = listRegionsWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List App Regions List all regions supported by App Platform.
     *
     * @return ApiResponse&lt;AppsListRegionsResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsListRegionsResponse> listRegionsWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listRegionsRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listRegions", localVarResponse);
                }
                return new ApiResponse<AppsListRegionsResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsListRegionsResponse>() {
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

    private HttpRequest.Builder listRegionsRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/regions";

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
     * List App Tiers List all app tiers.
     *
     * @return AppsListTiersResponse
     * @throws ApiException if fails to make API call
     */
    public AppsListTiersResponse listTiers() {
        ApiResponse<AppsListTiersResponse> localVarResponse = listTiersWithHttpInfo();
        return localVarResponse.getData();
    }

    /**
     * List App Tiers List all app tiers.
     *
     * @return ApiResponse&lt;AppsListTiersResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsListTiersResponse> listTiersWithHttpInfo() {
        HttpRequest.Builder localVarRequestBuilder = listTiersRequestBuilder();
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listTiers", localVarResponse);
                }
                return new ApiResponse<AppsListTiersResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsListTiersResponse>() {
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

    private HttpRequest.Builder listTiersRequestBuilder() {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/tiers";

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
     * Cancel a Deployment Immediately cancel an in-progress deployment.
     *
     * @param appId        The app ID (required)
     * @param deploymentId The deployment ID (required)
     * @return AppsDeploymentResponse
     * @throws ApiException if fails to make API call
     */
    public AppsDeploymentResponse postCancelDeployment(String appId, String deploymentId) {
        ApiResponse<AppsDeploymentResponse> localVarResponse = postCancelDeploymentWithHttpInfo(appId, deploymentId);
        return localVarResponse.getData();
    }

    /**
     * Cancel a Deployment Immediately cancel an in-progress deployment.
     *
     * @param appId        The app ID (required)
     * @param deploymentId The deployment ID (required)
     * @return ApiResponse&lt;AppsDeploymentResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsDeploymentResponse> postCancelDeploymentWithHttpInfo(String appId, String deploymentId) {
        HttpRequest.Builder localVarRequestBuilder = postCancelDeploymentRequestBuilder(appId, deploymentId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("postCancelDeployment", localVarResponse);
                }
                return new ApiResponse<AppsDeploymentResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsDeploymentResponse>() {
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

    private HttpRequest.Builder postCancelDeploymentRequestBuilder(String appId, String deploymentId) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling postCancelDeployment");
        }
        // verify the required parameter 'deploymentId' is set
        if (deploymentId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'deploymentId' when calling postCancelDeployment");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/deployments/{deployment_id}/cancel"
                .replace("{app_id}", ApiClient.urlEncode(appId.toString()))
                .replace("{deployment_id}", ApiClient.urlEncode(deploymentId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Commit App Rollback Commit an app rollback. This action permanently applies
     * the rollback and unpins the app to resume new deployments.
     *
     * @param appId The app ID (required)
     * @throws ApiException if fails to make API call
     */
    public void runCommitAppRollback(String appId) {
        runCommitAppRollbackWithHttpInfo(appId);
    }

    /**
     * Commit App Rollback Commit an app rollback. This action permanently applies
     * the rollback and unpins the app to resume new deployments.
     *
     * @param appId The app ID (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> runCommitAppRollbackWithHttpInfo(String appId) {
        HttpRequest.Builder localVarRequestBuilder = runCommitAppRollbackRequestBuilder(appId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("runCommitAppRollback", localVarResponse);
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

    private HttpRequest.Builder runCommitAppRollbackRequestBuilder(String appId) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling runCommitAppRollback");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/rollback/commit".replace("{app_id}",
                ApiClient.urlEncode(appId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Revert App Rollback Revert an app rollback. This action reverts the active
     * rollback by creating a new deployment from the latest app spec prior to the
     * rollback and unpins the app to resume new deployments.
     *
     * @param appId The app ID (required)
     * @return AppsDeploymentResponse
     * @throws ApiException if fails to make API call
     */
    public AppsDeploymentResponse runRevertAppRollback(String appId) {
        ApiResponse<AppsDeploymentResponse> localVarResponse = runRevertAppRollbackWithHttpInfo(appId);
        return localVarResponse.getData();
    }

    /**
     * Revert App Rollback Revert an app rollback. This action reverts the active
     * rollback by creating a new deployment from the latest app spec prior to the
     * rollback and unpins the app to resume new deployments.
     *
     * @param appId The app ID (required)
     * @return ApiResponse&lt;AppsDeploymentResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppsDeploymentResponse> runRevertAppRollbackWithHttpInfo(String appId) {
        HttpRequest.Builder localVarRequestBuilder = runRevertAppRollbackRequestBuilder(appId);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("runRevertAppRollback", localVarResponse);
                }
                return new ApiResponse<AppsDeploymentResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppsDeploymentResponse>() {
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

    private HttpRequest.Builder runRevertAppRollbackRequestBuilder(String appId) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling runRevertAppRollback");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/rollback/revert".replace("{app_id}",
                ApiClient.urlEncode(appId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Accept", "application/json");

        localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.noBody());
        if (memberVarReadTimeout != null) {
            localVarRequestBuilder.timeout(memberVarReadTimeout);
        }
        if (memberVarInterceptor != null) {
            memberVarInterceptor.accept(localVarRequestBuilder);
        }
        return localVarRequestBuilder;
    }

    /**
     * Update an App Update an existing app by submitting a new app specification.
     * For documentation on app specifications (&#x60;AppSpec&#x60; objects), please
     * refer to [the product
     * documentation](https://www.digitalocean.com/docs/app-platform/references/app-specification-reference/).
     *
     * @param id                   The ID of the app (required)
     * @param appsUpdateAppRequest (required)
     * @return AppResponse
     * @throws ApiException if fails to make API call
     */
    public AppResponse updateApp(String id, AppsUpdateAppRequest appsUpdateAppRequest) {
        ApiResponse<AppResponse> localVarResponse = updateAppWithHttpInfo(id, appsUpdateAppRequest);
        return localVarResponse.getData();
    }

    /**
     * Update an App Update an existing app by submitting a new app specification.
     * For documentation on app specifications (&#x60;AppSpec&#x60; objects), please
     * refer to [the product
     * documentation](https://www.digitalocean.com/docs/app-platform/references/app-specification-reference/).
     *
     * @param id                   The ID of the app (required)
     * @param appsUpdateAppRequest (required)
     * @return ApiResponse&lt;AppResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppResponse> updateAppWithHttpInfo(String id, AppsUpdateAppRequest appsUpdateAppRequest) {
        HttpRequest.Builder localVarRequestBuilder = updateAppRequestBuilder(id, appsUpdateAppRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateApp", localVarResponse);
                }
                return new ApiResponse<AppResponse>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AppResponse>() {
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

    private HttpRequest.Builder updateAppRequestBuilder(String id, AppsUpdateAppRequest appsUpdateAppRequest) {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException(400, "Missing the required parameter 'id' when calling updateApp");
        }
        // verify the required parameter 'appsUpdateAppRequest' is set
        if (appsUpdateAppRequest == null) {
            throw new ApiException(400, "Missing the required parameter 'appsUpdateAppRequest' when calling updateApp");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{id}".replace("{id}", ApiClient.urlEncode(id.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(appsUpdateAppRequest);
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
     * Validate App Rollback Check whether an app can be rolled back to a specific
     * deployment. This endpoint can also be used to check if there are any warnings
     * or validation conditions that will cause the rollback to proceed under
     * unideal circumstances. For example, if a component must be rebuilt as part of
     * the rollback causing it to take longer than usual.
     *
     * @param appId                  The app ID (required)
     * @param appsRollbackAppRequest (required)
     * @return ValidateAppRollbackResponse
     * @throws ApiException if fails to make API call
     */
    public ValidateAppRollbackResponse validateAppRollback(String appId,
            AppsRollbackAppRequest appsRollbackAppRequest) {
        ApiResponse<ValidateAppRollbackResponse> localVarResponse = validateAppRollbackWithHttpInfo(appId,
                appsRollbackAppRequest);
        return localVarResponse.getData();
    }

    /**
     * Validate App Rollback Check whether an app can be rolled back to a specific
     * deployment. This endpoint can also be used to check if there are any warnings
     * or validation conditions that will cause the rollback to proceed under
     * unideal circumstances. For example, if a component must be rebuilt as part of
     * the rollback causing it to take longer than usual.
     *
     * @param appId                  The app ID (required)
     * @param appsRollbackAppRequest (required)
     * @return ApiResponse&lt;ValidateAppRollbackResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ValidateAppRollbackResponse> validateAppRollbackWithHttpInfo(String appId,
            AppsRollbackAppRequest appsRollbackAppRequest) {
        HttpRequest.Builder localVarRequestBuilder = validateAppRollbackRequestBuilder(appId, appsRollbackAppRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("validateAppRollback", localVarResponse);
                }
                return new ApiResponse<ValidateAppRollbackResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ValidateAppRollbackResponse>() {
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

    private HttpRequest.Builder validateAppRollbackRequestBuilder(String appId,
            AppsRollbackAppRequest appsRollbackAppRequest) {
        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new ApiException(400, "Missing the required parameter 'appId' when calling validateAppRollback");
        }
        // verify the required parameter 'appsRollbackAppRequest' is set
        if (appsRollbackAppRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'appsRollbackAppRequest' when calling validateAppRollback");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/{app_id}/rollback/validate".replace("{app_id}",
                ApiClient.urlEncode(appId.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(appsRollbackAppRequest);
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
     * Propose an App Spec To propose and validate a spec for a new or existing app,
     * send a PUT request to the &#x60;/v2/apps/propose&#x60; endpoint. The request
     * returns some information about the proposed app, including app cost and
     * upgrade cost. If an existing app ID is specified, the app spec is treated as
     * a proposed update to the existing app.
     *
     * @param appPropose (required)
     * @return AppProposeResponse
     * @throws ApiException if fails to make API call
     */
    public AppProposeResponse validateAppSpec(AppPropose appPropose) {
        ApiResponse<AppProposeResponse> localVarResponse = validateAppSpecWithHttpInfo(appPropose);
        return localVarResponse.getData();
    }

    /**
     * Propose an App Spec To propose and validate a spec for a new or existing app,
     * send a PUT request to the &#x60;/v2/apps/propose&#x60; endpoint. The request
     * returns some information about the proposed app, including app cost and
     * upgrade cost. If an existing app ID is specified, the app spec is treated as
     * a proposed update to the existing app.
     *
     * @param appPropose (required)
     * @return ApiResponse&lt;AppProposeResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AppProposeResponse> validateAppSpecWithHttpInfo(AppPropose appPropose) {
        HttpRequest.Builder localVarRequestBuilder = validateAppSpecRequestBuilder(appPropose);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("validateAppSpec", localVarResponse);
                }
                return new ApiResponse<AppProposeResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<AppProposeResponse>() {
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

    private HttpRequest.Builder validateAppSpecRequestBuilder(AppPropose appPropose) {
        // verify the required parameter 'appPropose' is set
        if (appPropose == null) {
            throw new ApiException(400, "Missing the required parameter 'appPropose' when calling validateAppSpec");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/apps/propose";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(appPropose);
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
