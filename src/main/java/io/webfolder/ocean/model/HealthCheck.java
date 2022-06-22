package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An object specifying health check settings for the load balancer.
 */
@JsonPropertyOrder({ HealthCheck.JSON_PROPERTY_PROTOCOL, HealthCheck.JSON_PROPERTY_PORT, HealthCheck.JSON_PROPERTY_PATH,
        HealthCheck.JSON_PROPERTY_CHECK_INTERVAL_SECONDS, HealthCheck.JSON_PROPERTY_RESPONSE_TIMEOUT_SECONDS,
        HealthCheck.JSON_PROPERTY_UNHEALTHY_THRESHOLD, HealthCheck.JSON_PROPERTY_HEALTHY_THRESHOLD })
public class HealthCheck {
    /**
     * The protocol used for health checks sent to the backend Droplets. The
     * possible values are &#x60;http&#x60;, &#x60;https&#x60;, or &#x60;tcp&#x60;.
     */
    public enum ProtocolEnum {
        HTTP("http"),

        HTTPS("https"),

        TCP("tcp");

        private String value;

        ProtocolEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ProtocolEnum fromValue(String value) {
            for (ProtocolEnum b : ProtocolEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_PROTOCOL = "protocol";
    private ProtocolEnum protocol = ProtocolEnum.HTTP;

    public static final String JSON_PROPERTY_PORT = "port";
    private Integer port = 80;

    public static final String JSON_PROPERTY_PATH = "path";
    private String path = "/";

    public static final String JSON_PROPERTY_CHECK_INTERVAL_SECONDS = "check_interval_seconds";
    private Integer checkIntervalSeconds = 10;

    public static final String JSON_PROPERTY_RESPONSE_TIMEOUT_SECONDS = "response_timeout_seconds";
    private Integer responseTimeoutSeconds = 5;

    public static final String JSON_PROPERTY_UNHEALTHY_THRESHOLD = "unhealthy_threshold";
    private Integer unhealthyThreshold = 5;

    public static final String JSON_PROPERTY_HEALTHY_THRESHOLD = "healthy_threshold";
    private Integer healthyThreshold = 3;

    public HealthCheck() {
    }

    public HealthCheck protocol(ProtocolEnum protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * The protocol used for health checks sent to the backend Droplets. The
     * possible values are &#x60;http&#x60;, &#x60;https&#x60;, or &#x60;tcp&#x60;.
     *
     * @return protocol
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROTOCOL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ProtocolEnum getProtocol() {
        return protocol;
    }

    @JsonProperty(JSON_PROPERTY_PROTOCOL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProtocol(ProtocolEnum protocol) {
        this.protocol = protocol;
    }

    public HealthCheck port(Integer port) {
        this.port = port;
        return this;
    }

    /**
     * An integer representing the port on the backend Droplets on which the health
     * check will attempt a connection.
     *
     * @return port
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PORT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getPort() {
        return port;
    }

    @JsonProperty(JSON_PROPERTY_PORT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPort(Integer port) {
        this.port = port;
    }

    public HealthCheck path(String path) {
        this.path = path;
        return this;
    }

    /**
     * The path on the backend Droplets to which the load balancer instance will
     * send a request.
     *
     * @return path
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPath() {
        return path;
    }

    @JsonProperty(JSON_PROPERTY_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPath(String path) {
        this.path = path;
    }

    public HealthCheck checkIntervalSeconds(Integer checkIntervalSeconds) {
        this.checkIntervalSeconds = checkIntervalSeconds;
        return this;
    }

    /**
     * The number of seconds between between two consecutive health checks.
     *
     * @return checkIntervalSeconds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CHECK_INTERVAL_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getCheckIntervalSeconds() {
        return checkIntervalSeconds;
    }

    @JsonProperty(JSON_PROPERTY_CHECK_INTERVAL_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCheckIntervalSeconds(Integer checkIntervalSeconds) {
        this.checkIntervalSeconds = checkIntervalSeconds;
    }

    public HealthCheck responseTimeoutSeconds(Integer responseTimeoutSeconds) {
        this.responseTimeoutSeconds = responseTimeoutSeconds;
        return this;
    }

    /**
     * The number of seconds the load balancer instance will wait for a response
     * until marking a health check as failed.
     *
     * @return responseTimeoutSeconds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESPONSE_TIMEOUT_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getResponseTimeoutSeconds() {
        return responseTimeoutSeconds;
    }

    @JsonProperty(JSON_PROPERTY_RESPONSE_TIMEOUT_SECONDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResponseTimeoutSeconds(Integer responseTimeoutSeconds) {
        this.responseTimeoutSeconds = responseTimeoutSeconds;
    }

    public HealthCheck unhealthyThreshold(Integer unhealthyThreshold) {
        this.unhealthyThreshold = unhealthyThreshold;
        return this;
    }

    /**
     * The number of times a health check must fail for a backend Droplet to be
     * marked \&quot;unhealthy\&quot; and be removed from the pool.
     *
     * @return unhealthyThreshold
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UNHEALTHY_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getUnhealthyThreshold() {
        return unhealthyThreshold;
    }

    @JsonProperty(JSON_PROPERTY_UNHEALTHY_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUnhealthyThreshold(Integer unhealthyThreshold) {
        this.unhealthyThreshold = unhealthyThreshold;
    }

    public HealthCheck healthyThreshold(Integer healthyThreshold) {
        this.healthyThreshold = healthyThreshold;
        return this;
    }

    /**
     * The number of times a health check must pass for a backend Droplet to be
     * marked \&quot;healthy\&quot; and be re-added to the pool.
     *
     * @return healthyThreshold
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HEALTHY_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getHealthyThreshold() {
        return healthyThreshold;
    }

    @JsonProperty(JSON_PROPERTY_HEALTHY_THRESHOLD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHealthyThreshold(Integer healthyThreshold) {
        this.healthyThreshold = healthyThreshold;
    }

    /**
     * Return true if this health_check object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HealthCheck healthCheck = (HealthCheck) o;
        return Objects.equals(this.protocol, healthCheck.protocol) && Objects.equals(this.port, healthCheck.port)
                && Objects.equals(this.path, healthCheck.path)
                && Objects.equals(this.checkIntervalSeconds, healthCheck.checkIntervalSeconds)
                && Objects.equals(this.responseTimeoutSeconds, healthCheck.responseTimeoutSeconds)
                && Objects.equals(this.unhealthyThreshold, healthCheck.unhealthyThreshold)
                && Objects.equals(this.healthyThreshold, healthCheck.healthyThreshold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(protocol, port, path, checkIntervalSeconds, responseTimeoutSeconds, unhealthyThreshold,
                healthyThreshold);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HealthCheck {\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    checkIntervalSeconds: ").append(toIndentedString(checkIntervalSeconds)).append("\n");
        sb.append("    responseTimeoutSeconds: ").append(toIndentedString(responseTimeoutSeconds)).append("\n");
        sb.append("    unhealthyThreshold: ").append(toIndentedString(unhealthyThreshold)).append("\n");
        sb.append("    healthyThreshold: ").append(toIndentedString(healthyThreshold)).append("\n");
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
