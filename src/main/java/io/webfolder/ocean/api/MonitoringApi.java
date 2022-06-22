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
import io.webfolder.ocean.model.AlertPolicy;
import io.webfolder.ocean.model.AlertPolicyRequest;
import io.webfolder.ocean.model.ListAlertPoliciesResponse;
import io.webfolder.ocean.model.Metrics;

public class MonitoringApi {
    private final HttpClient memberVarHttpClient;
    private final ObjectMapper memberVarObjectMapper;
    private final String memberVarBaseUri;
    private final Consumer<HttpRequest.Builder> memberVarInterceptor;
    private final Duration memberVarReadTimeout;
    private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;

    public MonitoringApi() {
        this(new ApiClient());
    }

    public MonitoringApi(ApiClient apiClient) {
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
     * Create Alert Policy To create a new alert, send a POST request to
     * &#x60;/v2/monitoring/alerts&#x60;.
     *
     * @param alertPolicyRequest The &#x60;type&#x60; field dictates what type of
     *                           entity that the alert policy applies to and hence
     *                           what type of entity is passed in the
     *                           &#x60;entities&#x60; array. If both the
     *                           &#x60;tags&#x60; array and &#x60;entities&#x60;
     *                           array are empty the alert policy applies to all
     *                           entities of the relevant type that are owned by the
     *                           user account. Otherwise the following table shows
     *                           the valid entity types for each type of alert
     *                           policy: Type | Description | Valid Entity Type
     *                           -----|-------------|--------------------
     *                           &#x60;v1/insights/droplet/memory_utilization_percent&#x60;
     *                           | alert on the percent of memory utilization |
     *                           Droplet ID
     *                           &#x60;v1/insights/droplet/disk_read&#x60; | alert
     *                           on the rate of disk read I/O in MBps | Droplet ID
     *                           &#x60;v1/insights/droplet/load_5&#x60; | alert on
     *                           the 5 minute load average | Droplet ID
     *                           &#x60;v1/insights/droplet/load_15&#x60; | alert on
     *                           the 15 minute load average | Droplet ID
     *                           &#x60;v1/insights/droplet/disk_utilization_percent&#x60;
     *                           | alert on the percent of disk utilization |
     *                           Droplet ID &#x60;v1/insights/droplet/cpu&#x60; |
     *                           alert on the percent of CPU utilization | Droplet
     *                           ID &#x60;v1/insights/droplet/disk_write&#x60; |
     *                           alert on the rate of disk write I/O in MBps |
     *                           Droplet ID
     *                           &#x60;v1/insights/droplet/public_outbound_bandwidth&#x60;
     *                           | alert on the rate of public outbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/public_inbound_bandwidth&#x60;
     *                           | alert on the rate of public inbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/private_outbound_bandwidth&#x60;
     *                           | alert on the rate of private outbound bandwidth
     *                           in Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/private_inbound_bandwidth&#x60;
     *                           | alert on the rate of private inbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/load_1&#x60; | alert on
     *                           the 1 minute load average | Droplet ID
     *                           &#x60;v1/insights/lbaas/avg_cpu_utilization_percent&#x60;|alert
     *                           on the percent of CPU utilization|load balancer ID
     *                           &#x60;v1/insights/lbaas/connection_utilization_percent&#x60;|alert
     *                           on the percent of connection utilization|load
     *                           balancer ID
     *                           &#x60;v1/insights/lbaas/droplet_health&#x60;|alert
     *                           on Droplet health status changes|load balancer ID
     *                           &#x60;v1/insights/lbaas/tls_connections_per_second_utilization_percent&#x60;|alert
     *                           on the percent of TLS connections per second
     *                           utilization|load balancer ID (required)
     * @return AlertPolicy
     * @throws ApiException if fails to make API call
     */
    public AlertPolicy createAlertPolicy(AlertPolicyRequest alertPolicyRequest) {
        ApiResponse<AlertPolicy> localVarResponse = createAlertPolicyWithHttpInfo(alertPolicyRequest);
        return localVarResponse.getData();
    }

    /**
     * Create Alert Policy To create a new alert, send a POST request to
     * &#x60;/v2/monitoring/alerts&#x60;.
     *
     * @param alertPolicyRequest The &#x60;type&#x60; field dictates what type of
     *                           entity that the alert policy applies to and hence
     *                           what type of entity is passed in the
     *                           &#x60;entities&#x60; array. If both the
     *                           &#x60;tags&#x60; array and &#x60;entities&#x60;
     *                           array are empty the alert policy applies to all
     *                           entities of the relevant type that are owned by the
     *                           user account. Otherwise the following table shows
     *                           the valid entity types for each type of alert
     *                           policy: Type | Description | Valid Entity Type
     *                           -----|-------------|--------------------
     *                           &#x60;v1/insights/droplet/memory_utilization_percent&#x60;
     *                           | alert on the percent of memory utilization |
     *                           Droplet ID
     *                           &#x60;v1/insights/droplet/disk_read&#x60; | alert
     *                           on the rate of disk read I/O in MBps | Droplet ID
     *                           &#x60;v1/insights/droplet/load_5&#x60; | alert on
     *                           the 5 minute load average | Droplet ID
     *                           &#x60;v1/insights/droplet/load_15&#x60; | alert on
     *                           the 15 minute load average | Droplet ID
     *                           &#x60;v1/insights/droplet/disk_utilization_percent&#x60;
     *                           | alert on the percent of disk utilization |
     *                           Droplet ID &#x60;v1/insights/droplet/cpu&#x60; |
     *                           alert on the percent of CPU utilization | Droplet
     *                           ID &#x60;v1/insights/droplet/disk_write&#x60; |
     *                           alert on the rate of disk write I/O in MBps |
     *                           Droplet ID
     *                           &#x60;v1/insights/droplet/public_outbound_bandwidth&#x60;
     *                           | alert on the rate of public outbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/public_inbound_bandwidth&#x60;
     *                           | alert on the rate of public inbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/private_outbound_bandwidth&#x60;
     *                           | alert on the rate of private outbound bandwidth
     *                           in Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/private_inbound_bandwidth&#x60;
     *                           | alert on the rate of private inbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/load_1&#x60; | alert on
     *                           the 1 minute load average | Droplet ID
     *                           &#x60;v1/insights/lbaas/avg_cpu_utilization_percent&#x60;|alert
     *                           on the percent of CPU utilization|load balancer ID
     *                           &#x60;v1/insights/lbaas/connection_utilization_percent&#x60;|alert
     *                           on the percent of connection utilization|load
     *                           balancer ID
     *                           &#x60;v1/insights/lbaas/droplet_health&#x60;|alert
     *                           on Droplet health status changes|load balancer ID
     *                           &#x60;v1/insights/lbaas/tls_connections_per_second_utilization_percent&#x60;|alert
     *                           on the percent of TLS connections per second
     *                           utilization|load balancer ID (required)
     * @return ApiResponse&lt;AlertPolicy&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AlertPolicy> createAlertPolicyWithHttpInfo(AlertPolicyRequest alertPolicyRequest) {
        HttpRequest.Builder localVarRequestBuilder = createAlertPolicyRequestBuilder(alertPolicyRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("createAlertPolicy", localVarResponse);
                }
                return new ApiResponse<AlertPolicy>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AlertPolicy>() {
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

    private HttpRequest.Builder createAlertPolicyRequestBuilder(AlertPolicyRequest alertPolicyRequest) {
        // verify the required parameter 'alertPolicyRequest' is set
        if (alertPolicyRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'alertPolicyRequest' when calling createAlertPolicy");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/alerts";

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(alertPolicyRequest);
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
     * Delete an Alert Policy To delete an alert policy, send a DELETE request to
     * &#x60;/v2/monitoring/alerts/{alert_uuid}&#x60;
     *
     * @param alertUuid A unique identifier for an alert policy. (required)
     * @throws ApiException if fails to make API call
     */
    public void deleteAlertPolicy(String alertUuid) {
        deleteAlertPolicyWithHttpInfo(alertUuid);
    }

    /**
     * Delete an Alert Policy To delete an alert policy, send a DELETE request to
     * &#x60;/v2/monitoring/alerts/{alert_uuid}&#x60;
     *
     * @param alertUuid A unique identifier for an alert policy. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Void> deleteAlertPolicyWithHttpInfo(String alertUuid) {
        HttpRequest.Builder localVarRequestBuilder = deleteAlertPolicyRequestBuilder(alertUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("deleteAlertPolicy", localVarResponse);
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

    private HttpRequest.Builder deleteAlertPolicyRequestBuilder(String alertUuid) {
        // verify the required parameter 'alertUuid' is set
        if (alertUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'alertUuid' when calling deleteAlertPolicy");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/alerts/{alert_uuid}".replace("{alert_uuid}",
                ApiClient.urlEncode(alertUuid.toString()));

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
     * Retrieve an Existing Alert Policy To retrieve a given alert policy, send a
     * GET request to &#x60;/v2/monitoring/alerts/{alert_uuid}&#x60;
     *
     * @param alertUuid A unique identifier for an alert policy. (required)
     * @return AlertPolicy
     * @throws ApiException if fails to make API call
     */
    public AlertPolicy getAlertPolicy(String alertUuid) {
        ApiResponse<AlertPolicy> localVarResponse = getAlertPolicyWithHttpInfo(alertUuid);
        return localVarResponse.getData();
    }

    /**
     * Retrieve an Existing Alert Policy To retrieve a given alert policy, send a
     * GET request to &#x60;/v2/monitoring/alerts/{alert_uuid}&#x60;
     *
     * @param alertUuid A unique identifier for an alert policy. (required)
     * @return ApiResponse&lt;AlertPolicy&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AlertPolicy> getAlertPolicyWithHttpInfo(String alertUuid) {
        HttpRequest.Builder localVarRequestBuilder = getAlertPolicyRequestBuilder(alertUuid);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getAlertPolicy", localVarResponse);
                }
                return new ApiResponse<AlertPolicy>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AlertPolicy>() {
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

    private HttpRequest.Builder getAlertPolicyRequestBuilder(String alertUuid) {
        // verify the required parameter 'alertUuid' is set
        if (alertUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'alertUuid' when calling getAlertPolicy");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/alerts/{alert_uuid}".replace("{alert_uuid}",
                ApiClient.urlEncode(alertUuid.toString()));

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
     * Get Droplet Bandwidth Metrics To retrieve bandwidth metrics for a given
     * Droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/bandwidth&#x60;. Use the
     * &#x60;interface&#x60; query parameter to specify if the results should be for
     * the &#x60;private&#x60; or &#x60;public&#x60; interface. Use the
     * &#x60;direction&#x60; query parameter to specify if the results should be for
     * &#x60;inbound&#x60; or &#x60;outbound&#x60; traffic.
     *
     * @param hostId     The droplet ID. (required)
     * @param _interface The network interface. (required)
     * @param direction  The traffic direction. (required)
     * @param start      Timestamp to start metric window. (required)
     * @param end        Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletBandwidthMetrics(String hostId, String _interface, String direction, String start,
            String end) {
        ApiResponse<Metrics> localVarResponse = getDropletBandwidthMetricsWithHttpInfo(hostId, _interface, direction,
                start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet Bandwidth Metrics To retrieve bandwidth metrics for a given
     * Droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/bandwidth&#x60;. Use the
     * &#x60;interface&#x60; query parameter to specify if the results should be for
     * the &#x60;private&#x60; or &#x60;public&#x60; interface. Use the
     * &#x60;direction&#x60; query parameter to specify if the results should be for
     * &#x60;inbound&#x60; or &#x60;outbound&#x60; traffic.
     *
     * @param hostId     The droplet ID. (required)
     * @param _interface The network interface. (required)
     * @param direction  The traffic direction. (required)
     * @param start      Timestamp to start metric window. (required)
     * @param end        Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletBandwidthMetricsWithHttpInfo(String hostId, String _interface,
            String direction, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletBandwidthMetricsRequestBuilder(hostId, _interface,
                direction, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletBandwidthMetrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletBandwidthMetricsRequestBuilder(String hostId, String _interface,
            String direction, String start, String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'hostId' when calling getDropletBandwidthMetrics");
        }
        // verify the required parameter '_interface' is set
        if (_interface == null) {
            throw new ApiException(400,
                    "Missing the required parameter '_interface' when calling getDropletBandwidthMetrics");
        }
        // verify the required parameter 'direction' is set
        if (direction == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'direction' when calling getDropletBandwidthMetrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'start' when calling getDropletBandwidthMetrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400, "Missing the required parameter 'end' when calling getDropletBandwidthMetrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/bandwidth";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("interface", _interface));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("direction", direction));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * Get Droplet CPU Metrics To retrieve CPU metrics for a given droplet, send a
     * GET request to &#x60;/v2/monitoring/metrics/droplet/cpu&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletCpuMetrics(String hostId, String start, String end) {
        ApiResponse<Metrics> localVarResponse = getDropletCpuMetricsWithHttpInfo(hostId, start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet CPU Metrics To retrieve CPU metrics for a given droplet, send a
     * GET request to &#x60;/v2/monitoring/metrics/droplet/cpu&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletCpuMetricsWithHttpInfo(String hostId, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletCpuMetricsRequestBuilder(hostId, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletCpuMetrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletCpuMetricsRequestBuilder(String hostId, String start, String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400, "Missing the required parameter 'hostId' when calling getDropletCpuMetrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400, "Missing the required parameter 'start' when calling getDropletCpuMetrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400, "Missing the required parameter 'end' when calling getDropletCpuMetrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/cpu";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * Get Droplet Filesystem Free Metrics To retrieve filesystem free metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/filesystem_free&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletFilesystemFreeMetrics(String hostId, String start, String end) {
        ApiResponse<Metrics> localVarResponse = getDropletFilesystemFreeMetricsWithHttpInfo(hostId, start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet Filesystem Free Metrics To retrieve filesystem free metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/filesystem_free&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletFilesystemFreeMetricsWithHttpInfo(String hostId, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletFilesystemFreeMetricsRequestBuilder(hostId, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletFilesystemFreeMetrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletFilesystemFreeMetricsRequestBuilder(String hostId, String start, String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'hostId' when calling getDropletFilesystemFreeMetrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'start' when calling getDropletFilesystemFreeMetrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'end' when calling getDropletFilesystemFreeMetrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/filesystem_free";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * Get Droplet Filesystem Size Metrics To retrieve filesystem size metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/filesystem_size&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletFilesystemSizeMetrics(String hostId, String start, String end) {
        ApiResponse<Metrics> localVarResponse = getDropletFilesystemSizeMetricsWithHttpInfo(hostId, start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet Filesystem Size Metrics To retrieve filesystem size metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/filesystem_size&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletFilesystemSizeMetricsWithHttpInfo(String hostId, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletFilesystemSizeMetricsRequestBuilder(hostId, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletFilesystemSizeMetrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletFilesystemSizeMetricsRequestBuilder(String hostId, String start, String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'hostId' when calling getDropletFilesystemSizeMetrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'start' when calling getDropletFilesystemSizeMetrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'end' when calling getDropletFilesystemSizeMetrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/filesystem_size";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * Get Droplet Load15 Metrics To retrieve 15 minute load average metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/load_15&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletLoad15Metrics(String hostId, String start, String end) {
        ApiResponse<Metrics> localVarResponse = getDropletLoad15MetricsWithHttpInfo(hostId, start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet Load15 Metrics To retrieve 15 minute load average metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/load_15&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletLoad15MetricsWithHttpInfo(String hostId, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletLoad15MetricsRequestBuilder(hostId, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletLoad15Metrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletLoad15MetricsRequestBuilder(String hostId, String start, String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400, "Missing the required parameter 'hostId' when calling getDropletLoad15Metrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400, "Missing the required parameter 'start' when calling getDropletLoad15Metrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400, "Missing the required parameter 'end' when calling getDropletLoad15Metrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/load_15";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * Get Droplet Load1 Metrics To retrieve 1 minute load average metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/load_1&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletLoad1Metrics(String hostId, String start, String end) {
        ApiResponse<Metrics> localVarResponse = getDropletLoad1MetricsWithHttpInfo(hostId, start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet Load1 Metrics To retrieve 1 minute load average metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/load_1&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletLoad1MetricsWithHttpInfo(String hostId, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletLoad1MetricsRequestBuilder(hostId, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletLoad1Metrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletLoad1MetricsRequestBuilder(String hostId, String start, String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400, "Missing the required parameter 'hostId' when calling getDropletLoad1Metrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400, "Missing the required parameter 'start' when calling getDropletLoad1Metrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400, "Missing the required parameter 'end' when calling getDropletLoad1Metrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/load_1";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * Get Droplet Load5 Metrics To retrieve 5 minute load average metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/load_5&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletLoad5Metrics(String hostId, String start, String end) {
        ApiResponse<Metrics> localVarResponse = getDropletLoad5MetricsWithHttpInfo(hostId, start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet Load5 Metrics To retrieve 5 minute load average metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/load_5&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletLoad5MetricsWithHttpInfo(String hostId, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletLoad5MetricsRequestBuilder(hostId, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletLoad5Metrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletLoad5MetricsRequestBuilder(String hostId, String start, String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400, "Missing the required parameter 'hostId' when calling getDropletLoad5Metrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400, "Missing the required parameter 'start' when calling getDropletLoad5Metrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400, "Missing the required parameter 'end' when calling getDropletLoad5Metrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/load_5";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * Get Droplet Available Memory Metrics To retrieve available memory metrics for
     * a given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/memory_available&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletMemoryAvailableMetrics(String hostId, String start, String end) {
        ApiResponse<Metrics> localVarResponse = getDropletMemoryAvailableMetricsWithHttpInfo(hostId, start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet Available Memory Metrics To retrieve available memory metrics for
     * a given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/memory_available&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletMemoryAvailableMetricsWithHttpInfo(String hostId, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletMemoryAvailableMetricsRequestBuilder(hostId, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletMemoryAvailableMetrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletMemoryAvailableMetricsRequestBuilder(String hostId, String start,
            String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'hostId' when calling getDropletMemoryAvailableMetrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'start' when calling getDropletMemoryAvailableMetrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'end' when calling getDropletMemoryAvailableMetrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/memory_available";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * Get Droplet Cached Memory Metrics To retrieve cached memory metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/memory_cached&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletMemoryCachedMetrics(String hostId, String start, String end) {
        ApiResponse<Metrics> localVarResponse = getDropletMemoryCachedMetricsWithHttpInfo(hostId, start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet Cached Memory Metrics To retrieve cached memory metrics for a
     * given droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/memory_cached&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletMemoryCachedMetricsWithHttpInfo(String hostId, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletMemoryCachedMetricsRequestBuilder(hostId, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletMemoryCachedMetrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletMemoryCachedMetricsRequestBuilder(String hostId, String start, String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'hostId' when calling getDropletMemoryCachedMetrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'start' when calling getDropletMemoryCachedMetrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'end' when calling getDropletMemoryCachedMetrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/memory_cached";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * Get Droplet Free Memory Metrics To retrieve free memory metrics for a given
     * droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/memory_free&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletMemoryFreeMetrics(String hostId, String start, String end) {
        ApiResponse<Metrics> localVarResponse = getDropletMemoryFreeMetricsWithHttpInfo(hostId, start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet Free Memory Metrics To retrieve free memory metrics for a given
     * droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/memory_free&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletMemoryFreeMetricsWithHttpInfo(String hostId, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletMemoryFreeMetricsRequestBuilder(hostId, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletMemoryFreeMetrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletMemoryFreeMetricsRequestBuilder(String hostId, String start, String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'hostId' when calling getDropletMemoryFreeMetrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'start' when calling getDropletMemoryFreeMetrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'end' when calling getDropletMemoryFreeMetrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/memory_free";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * Get Droplet Total Memory Metrics To retrieve total memory metrics for a given
     * droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/memory_total&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return Metrics
     * @throws ApiException if fails to make API call
     */
    public Metrics getDropletMemoryTotalMetrics(String hostId, String start, String end) {
        ApiResponse<Metrics> localVarResponse = getDropletMemoryTotalMetricsWithHttpInfo(hostId, start, end);
        return localVarResponse.getData();
    }

    /**
     * Get Droplet Total Memory Metrics To retrieve total memory metrics for a given
     * droplet, send a GET request to
     * &#x60;/v2/monitoring/metrics/droplet/memory_total&#x60;.
     *
     * @param hostId The droplet ID. (required)
     * @param start  Timestamp to start metric window. (required)
     * @param end    Timestamp to end metric window. (required)
     * @return ApiResponse&lt;Metrics&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<Metrics> getDropletMemoryTotalMetricsWithHttpInfo(String hostId, String start, String end) {
        HttpRequest.Builder localVarRequestBuilder = getDropletMemoryTotalMetricsRequestBuilder(hostId, start, end);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("getDropletMemoryTotalMetrics", localVarResponse);
                }
                return new ApiResponse<Metrics>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Metrics>() {
                        }) // closes the
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

    private HttpRequest.Builder getDropletMemoryTotalMetricsRequestBuilder(String hostId, String start, String end) {
        // verify the required parameter 'hostId' is set
        if (hostId == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'hostId' when calling getDropletMemoryTotalMetrics");
        }
        // verify the required parameter 'start' is set
        if (start == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'start' when calling getDropletMemoryTotalMetrics");
        }
        // verify the required parameter 'end' is set
        if (end == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'end' when calling getDropletMemoryTotalMetrics");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/metrics/droplet/memory_total";

        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(ApiClient.parameterToPairs("host_id", hostId));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("start", start));
        localVarQueryParams.addAll(ApiClient.parameterToPairs("end", end));

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
     * List Alert Policies Returns all alert policies that are configured for the
     * given account. To List all alert policies, send a GET request to
     * &#x60;/v2/monitoring/alerts&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ListAlertPoliciesResponse
     * @throws ApiException if fails to make API call
     */
    public ListAlertPoliciesResponse listAlertPolicies(Integer perPage, Integer page) {
        ApiResponse<ListAlertPoliciesResponse> localVarResponse = listAlertPoliciesWithHttpInfo(perPage, page);
        return localVarResponse.getData();
    }

    /**
     * List Alert Policies Returns all alert policies that are configured for the
     * given account. To List all alert policies, send a GET request to
     * &#x60;/v2/monitoring/alerts&#x60;.
     *
     * @param perPage Number of items returned per page (optional, default to 20)
     * @param page    Which &#39;page&#39; of paginated results to return.
     *                (optional, default to 1)
     * @return ApiResponse&lt;ListAlertPoliciesResponse&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<ListAlertPoliciesResponse> listAlertPoliciesWithHttpInfo(Integer perPage, Integer page) {
        HttpRequest.Builder localVarRequestBuilder = listAlertPoliciesRequestBuilder(perPage, page);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("listAlertPolicies", localVarResponse);
                }
                return new ApiResponse<ListAlertPoliciesResponse>(localVarResponse.statusCode(),
                        localVarResponse.headers().map(), memberVarObjectMapper.readValue(localVarResponse.body(),
                                new TypeReference<ListAlertPoliciesResponse>() {
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

    private HttpRequest.Builder listAlertPoliciesRequestBuilder(Integer perPage, Integer page) {

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/alerts";

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
     * Update an Alert Policy To update en existing policy, send a PUT request to
     * &#x60;v2/monitoring/alerts/{alert_uuid}&#x60;.
     *
     * @param alertUuid          A unique identifier for an alert policy. (required)
     * @param alertPolicyRequest The &#x60;type&#x60; field dictates what type of
     *                           entity that the alert policy applies to and hence
     *                           what type of entity is passed in the
     *                           &#x60;entities&#x60; array. If both the
     *                           &#x60;tags&#x60; array and &#x60;entities&#x60;
     *                           array are empty the alert policy applies to all
     *                           entities of the relevant type that are owned by the
     *                           user account. Otherwise the following table shows
     *                           the valid entity types for each type of alert
     *                           policy: Type | Description | Valid Entity Type
     *                           -----|-------------|--------------------
     *                           &#x60;v1/insights/droplet/memory_utilization_percent&#x60;
     *                           | alert on the percent of memory utilization |
     *                           Droplet ID
     *                           &#x60;v1/insights/droplet/disk_read&#x60; | alert
     *                           on the rate of disk read I/O in MBps | Droplet ID
     *                           &#x60;v1/insights/droplet/load_5&#x60; | alert on
     *                           the 5 minute load average | Droplet ID
     *                           &#x60;v1/insights/droplet/load_15&#x60; | alert on
     *                           the 15 minute load average | Droplet ID
     *                           &#x60;v1/insights/droplet/disk_utilization_percent&#x60;
     *                           | alert on the percent of disk utilization |
     *                           Droplet ID &#x60;v1/insights/droplet/cpu&#x60; |
     *                           alert on the percent of CPU utilization | Droplet
     *                           ID &#x60;v1/insights/droplet/disk_write&#x60; |
     *                           alert on the rate of disk write I/O in MBps |
     *                           Droplet ID
     *                           &#x60;v1/insights/droplet/public_outbound_bandwidth&#x60;
     *                           | alert on the rate of public outbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/public_inbound_bandwidth&#x60;
     *                           | alert on the rate of public inbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/private_outbound_bandwidth&#x60;
     *                           | alert on the rate of private outbound bandwidth
     *                           in Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/private_inbound_bandwidth&#x60;
     *                           | alert on the rate of private inbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/load_1&#x60; | alert on
     *                           the 1 minute load average | Droplet ID
     *                           &#x60;v1/insights/lbaas/avg_cpu_utilization_percent&#x60;|alert
     *                           on the percent of CPU utilization|load balancer ID
     *                           &#x60;v1/insights/lbaas/connection_utilization_percent&#x60;|alert
     *                           on the percent of connection utilization|load
     *                           balancer ID
     *                           &#x60;v1/insights/lbaas/droplet_health&#x60;|alert
     *                           on Droplet health status changes|load balancer ID
     *                           &#x60;v1/insights/lbaas/tls_connections_per_second_utilization_percent&#x60;|alert
     *                           on the percent of TLS connections per second
     *                           utilization|load balancer ID (required)
     * @return AlertPolicy
     * @throws ApiException if fails to make API call
     */
    public AlertPolicy updateAlertPolicy(String alertUuid, AlertPolicyRequest alertPolicyRequest) {
        ApiResponse<AlertPolicy> localVarResponse = updateAlertPolicyWithHttpInfo(alertUuid, alertPolicyRequest);
        return localVarResponse.getData();
    }

    /**
     * Update an Alert Policy To update en existing policy, send a PUT request to
     * &#x60;v2/monitoring/alerts/{alert_uuid}&#x60;.
     *
     * @param alertUuid          A unique identifier for an alert policy. (required)
     * @param alertPolicyRequest The &#x60;type&#x60; field dictates what type of
     *                           entity that the alert policy applies to and hence
     *                           what type of entity is passed in the
     *                           &#x60;entities&#x60; array. If both the
     *                           &#x60;tags&#x60; array and &#x60;entities&#x60;
     *                           array are empty the alert policy applies to all
     *                           entities of the relevant type that are owned by the
     *                           user account. Otherwise the following table shows
     *                           the valid entity types for each type of alert
     *                           policy: Type | Description | Valid Entity Type
     *                           -----|-------------|--------------------
     *                           &#x60;v1/insights/droplet/memory_utilization_percent&#x60;
     *                           | alert on the percent of memory utilization |
     *                           Droplet ID
     *                           &#x60;v1/insights/droplet/disk_read&#x60; | alert
     *                           on the rate of disk read I/O in MBps | Droplet ID
     *                           &#x60;v1/insights/droplet/load_5&#x60; | alert on
     *                           the 5 minute load average | Droplet ID
     *                           &#x60;v1/insights/droplet/load_15&#x60; | alert on
     *                           the 15 minute load average | Droplet ID
     *                           &#x60;v1/insights/droplet/disk_utilization_percent&#x60;
     *                           | alert on the percent of disk utilization |
     *                           Droplet ID &#x60;v1/insights/droplet/cpu&#x60; |
     *                           alert on the percent of CPU utilization | Droplet
     *                           ID &#x60;v1/insights/droplet/disk_write&#x60; |
     *                           alert on the rate of disk write I/O in MBps |
     *                           Droplet ID
     *                           &#x60;v1/insights/droplet/public_outbound_bandwidth&#x60;
     *                           | alert on the rate of public outbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/public_inbound_bandwidth&#x60;
     *                           | alert on the rate of public inbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/private_outbound_bandwidth&#x60;
     *                           | alert on the rate of private outbound bandwidth
     *                           in Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/private_inbound_bandwidth&#x60;
     *                           | alert on the rate of private inbound bandwidth in
     *                           Mbps | Droplet ID
     *                           &#x60;v1/insights/droplet/load_1&#x60; | alert on
     *                           the 1 minute load average | Droplet ID
     *                           &#x60;v1/insights/lbaas/avg_cpu_utilization_percent&#x60;|alert
     *                           on the percent of CPU utilization|load balancer ID
     *                           &#x60;v1/insights/lbaas/connection_utilization_percent&#x60;|alert
     *                           on the percent of connection utilization|load
     *                           balancer ID
     *                           &#x60;v1/insights/lbaas/droplet_health&#x60;|alert
     *                           on Droplet health status changes|load balancer ID
     *                           &#x60;v1/insights/lbaas/tls_connections_per_second_utilization_percent&#x60;|alert
     *                           on the percent of TLS connections per second
     *                           utilization|load balancer ID (required)
     * @return ApiResponse&lt;AlertPolicy&gt;
     * @throws ApiException if fails to make API call
     */
    public ApiResponse<AlertPolicy> updateAlertPolicyWithHttpInfo(String alertUuid,
            AlertPolicyRequest alertPolicyRequest) {
        HttpRequest.Builder localVarRequestBuilder = updateAlertPolicyRequestBuilder(alertUuid, alertPolicyRequest);
        try {
            HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(localVarRequestBuilder.build(),
                    HttpResponse.BodyHandlers.ofInputStream());
            if (memberVarResponseInterceptor != null) {
                memberVarResponseInterceptor.accept(localVarResponse);
            }
            try {
                if (localVarResponse.statusCode() / 100 != 2) {
                    throw getApiException("updateAlertPolicy", localVarResponse);
                }
                return new ApiResponse<AlertPolicy>(localVarResponse.statusCode(), localVarResponse.headers().map(),
                        memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<AlertPolicy>() {
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

    private HttpRequest.Builder updateAlertPolicyRequestBuilder(String alertUuid,
            AlertPolicyRequest alertPolicyRequest) {
        // verify the required parameter 'alertUuid' is set
        if (alertUuid == null) {
            throw new ApiException(400, "Missing the required parameter 'alertUuid' when calling updateAlertPolicy");
        }
        // verify the required parameter 'alertPolicyRequest' is set
        if (alertPolicyRequest == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'alertPolicyRequest' when calling updateAlertPolicy");
        }

        HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

        String localVarPath = "/v2/monitoring/alerts/{alert_uuid}".replace("{alert_uuid}",
                ApiClient.urlEncode(alertUuid.toString()));

        localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

        localVarRequestBuilder.header("Content-Type", "application/json");
        localVarRequestBuilder.header("Accept", "application/json");

        try {
            byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(alertPolicyRequest);
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
