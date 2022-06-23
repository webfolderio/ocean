package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppServiceSpecHealthCheck
 */
@JsonPropertyOrder({ AppServiceSpecHealthCheck.JSON_PROPERTY_FAILURE_THRESHOLD,
        AppServiceSpecHealthCheck.JSON_PROPERTY_PORT, AppServiceSpecHealthCheck.JSON_PROPERTY_HTTP_PATH,
        AppServiceSpecHealthCheck.JSON_PROPERTY_INITIAL_DELAY_SECONDS,
        AppServiceSpecHealthCheck.JSON_PROPERTY_PERIOD_SECONDS,
        AppServiceSpecHealthCheck.JSON_PROPERTY_SUCCESS_THRESHOLD,
        AppServiceSpecHealthCheck.JSON_PROPERTY_TIMEOUT_SECONDS })
public class AppServiceSpecHealthCheck {
    public static final String JSON_PROPERTY_FAILURE_THRESHOLD = "failure_threshold";
    private Integer failureThreshold;

    public static final String JSON_PROPERTY_PORT = "port";
    private Long port;

    public static final String JSON_PROPERTY_HTTP_PATH = "http_path";
    private String httpPath;

    public static final String JSON_PROPERTY_INITIAL_DELAY_SECONDS = "initial_delay_seconds";
    private Integer initialDelaySeconds;

    public static final String JSON_PROPERTY_PERIOD_SECONDS = "period_seconds";
    private Integer periodSeconds;

    public static final String JSON_PROPERTY_SUCCESS_THRESHOLD = "success_threshold";
    private Integer successThreshold;

    public static final String JSON_PROPERTY_TIMEOUT_SECONDS = "timeout_seconds";
    private Integer timeoutSeconds;

    public AppServiceSpecHealthCheck() {
    }

    public AppServiceSpecHealthCheck failureThreshold(Integer failureThreshold) {
        this.failureThreshold = failureThreshold;
        return this;
    }

    /**
     * The number of failed health checks before considered unhealthy.
     *
     * @return failureThreshold
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FAILURE_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getFailureThreshold() {
        return failureThreshold;
    }

    @JsonProperty(JSON_PROPERTY_FAILURE_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFailureThreshold(Integer failureThreshold) {
        this.failureThreshold = failureThreshold;
    }

    public AppServiceSpecHealthCheck port(Long port) {
        this.port = port;
        return this;
    }

    /**
     * The port on which the health check will be performed. If not set, the health
     * check will be performed on the component&#39;s http_port. minimum: 1 maximum:
     * 65535
     *
     * @return port
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PORT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Long getPort() {
        return port;
    }

    @JsonProperty(JSON_PROPERTY_PORT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPort(Long port) {
        this.port = port;
    }

    public AppServiceSpecHealthCheck httpPath(String httpPath) {
        this.httpPath = httpPath;
        return this;
    }

    /**
     * The route path used for the HTTP health check ping. If not set, the HTTP
     * health check will be disabled and a TCP health check used instead.
     *
     * @return httpPath
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HTTP_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getHttpPath() {
        return httpPath;
    }

    @JsonProperty(JSON_PROPERTY_HTTP_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHttpPath(String httpPath) {
        this.httpPath = httpPath;
    }

    public AppServiceSpecHealthCheck initialDelaySeconds(Integer initialDelaySeconds) {
        this.initialDelaySeconds = initialDelaySeconds;
        return this;
    }

    /**
     * The number of seconds to wait before beginning health checks.
     *
     * @return initialDelaySeconds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INITIAL_DELAY_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getInitialDelaySeconds() {
        return initialDelaySeconds;
    }

    @JsonProperty(JSON_PROPERTY_INITIAL_DELAY_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInitialDelaySeconds(Integer initialDelaySeconds) {
        this.initialDelaySeconds = initialDelaySeconds;
    }

    public AppServiceSpecHealthCheck periodSeconds(Integer periodSeconds) {
        this.periodSeconds = periodSeconds;
        return this;
    }

    /**
     * The number of seconds to wait between health checks.
     *
     * @return periodSeconds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PERIOD_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getPeriodSeconds() {
        return periodSeconds;
    }

    @JsonProperty(JSON_PROPERTY_PERIOD_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPeriodSeconds(Integer periodSeconds) {
        this.periodSeconds = periodSeconds;
    }

    public AppServiceSpecHealthCheck successThreshold(Integer successThreshold) {
        this.successThreshold = successThreshold;
        return this;
    }

    /**
     * The number of successful health checks before considered healthy.
     *
     * @return successThreshold
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUCCESS_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getSuccessThreshold() {
        return successThreshold;
    }

    @JsonProperty(JSON_PROPERTY_SUCCESS_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSuccessThreshold(Integer successThreshold) {
        this.successThreshold = successThreshold;
    }

    public AppServiceSpecHealthCheck timeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
        return this;
    }

    /**
     * The number of seconds after which the check times out.
     *
     * @return timeoutSeconds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TIMEOUT_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    @JsonProperty(JSON_PROPERTY_TIMEOUT_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * Return true if this app_service_spec_health_check object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppServiceSpecHealthCheck appServiceSpecHealthCheck = (AppServiceSpecHealthCheck) o;
        return Objects.equals(this.failureThreshold, appServiceSpecHealthCheck.failureThreshold)
                && Objects.equals(this.port, appServiceSpecHealthCheck.port)
                && Objects.equals(this.httpPath, appServiceSpecHealthCheck.httpPath)
                && Objects.equals(this.initialDelaySeconds, appServiceSpecHealthCheck.initialDelaySeconds)
                && Objects.equals(this.periodSeconds, appServiceSpecHealthCheck.periodSeconds)
                && Objects.equals(this.successThreshold, appServiceSpecHealthCheck.successThreshold)
                && Objects.equals(this.timeoutSeconds, appServiceSpecHealthCheck.timeoutSeconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(failureThreshold, port, httpPath, initialDelaySeconds, periodSeconds, successThreshold,
                timeoutSeconds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppServiceSpecHealthCheck {\n");
        sb.append("    failureThreshold: ").append(toIndentedString(failureThreshold)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    httpPath: ").append(toIndentedString(httpPath)).append("\n");
        sb.append("    initialDelaySeconds: ").append(toIndentedString(initialDelaySeconds)).append("\n");
        sb.append("    periodSeconds: ").append(toIndentedString(periodSeconds)).append("\n");
        sb.append("    successThreshold: ").append(toIndentedString(successThreshold)).append("\n");
        sb.append("    timeoutSeconds: ").append(toIndentedString(timeoutSeconds)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}