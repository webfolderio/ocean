package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppServiceSpecAllOf
 */
@JsonPropertyOrder({ AppServiceSpecAllOf.JSON_PROPERTY_CORS, AppServiceSpecAllOf.JSON_PROPERTY_HEALTH_CHECK,
        AppServiceSpecAllOf.JSON_PROPERTY_HTTP_PORT, AppServiceSpecAllOf.JSON_PROPERTY_INTERNAL_PORTS,
        AppServiceSpecAllOf.JSON_PROPERTY_ROUTES })
public class AppServiceSpecAllOf {
    public static final String JSON_PROPERTY_CORS = "cors";
    private AppsCorsPolicy cors;

    public static final String JSON_PROPERTY_HEALTH_CHECK = "health_check";
    private AppServiceSpecHealthCheck healthCheck;

    public static final String JSON_PROPERTY_HTTP_PORT = "http_port";
    private Long httpPort;

    public static final String JSON_PROPERTY_INTERNAL_PORTS = "internal_ports";
    private List<Long> internalPorts = null;

    public static final String JSON_PROPERTY_ROUTES = "routes";
    private List<AppRouteSpec> routes = null;

    public AppServiceSpecAllOf() {
    }

    public AppServiceSpecAllOf cors(AppsCorsPolicy cors) {
        this.cors = cors;
        return this;
    }

    /**
     * Get cors
     *
     * @return cors
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CORS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AppsCorsPolicy getCors() {
        return cors;
    }

    @JsonProperty(JSON_PROPERTY_CORS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCors(AppsCorsPolicy cors) {
        this.cors = cors;
    }

    public AppServiceSpecAllOf healthCheck(AppServiceSpecHealthCheck healthCheck) {
        this.healthCheck = healthCheck;
        return this;
    }

    /**
     * Get healthCheck
     *
     * @return healthCheck
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HEALTH_CHECK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppServiceSpecHealthCheck getHealthCheck() {
        return healthCheck;
    }

    @JsonProperty(JSON_PROPERTY_HEALTH_CHECK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHealthCheck(AppServiceSpecHealthCheck healthCheck) {
        this.healthCheck = healthCheck;
    }

    public AppServiceSpecAllOf httpPort(Long httpPort) {
        this.httpPort = httpPort;
        return this;
    }

    /**
     * The internal port on which this service&#39;s run command will listen.
     * Default: 8080 If there is not an environment variable with the name
     * &#x60;PORT&#x60;, one will be automatically added with its value set to the
     * value of this field. minimum: 1 maximum: 65535
     *
     * @return httpPort
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HTTP_PORT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getHttpPort() {
        return httpPort;
    }

    @JsonProperty(JSON_PROPERTY_HTTP_PORT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHttpPort(Long httpPort) {
        this.httpPort = httpPort;
    }

    public AppServiceSpecAllOf internalPorts(List<Long> internalPorts) {
        this.internalPorts = internalPorts;
        return this;
    }

    public AppServiceSpecAllOf addInternalPortsItem(Long internalPortsItem) {
        if (this.internalPorts == null) {
            this.internalPorts = new ArrayList<>();
        }
        this.internalPorts.add(internalPortsItem);
        return this;
    }

    /**
     * The ports on which this service will listen for internal traffic.
     *
     * @return internalPorts
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INTERNAL_PORTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Long> getInternalPorts() {
        return internalPorts;
    }

    @JsonProperty(JSON_PROPERTY_INTERNAL_PORTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInternalPorts(List<Long> internalPorts) {
        this.internalPorts = internalPorts;
    }

    public AppServiceSpecAllOf routes(List<AppRouteSpec> routes) {
        this.routes = routes;
        return this;
    }

    public AppServiceSpecAllOf addRoutesItem(AppRouteSpec routesItem) {
        if (this.routes == null) {
            this.routes = new ArrayList<>();
        }
        this.routes.add(routesItem);
        return this;
    }

    /**
     * A list of HTTP routes that should be routed to this component.
     *
     * @return routes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ROUTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppRouteSpec> getRoutes() {
        return routes;
    }

    @JsonProperty(JSON_PROPERTY_ROUTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRoutes(List<AppRouteSpec> routes) {
        this.routes = routes;
    }

    /**
     * Return true if this app_service_spec_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppServiceSpecAllOf appServiceSpecAllOf = (AppServiceSpecAllOf) o;
        return Objects.equals(this.cors, appServiceSpecAllOf.cors)
                && Objects.equals(this.healthCheck, appServiceSpecAllOf.healthCheck)
                && Objects.equals(this.httpPort, appServiceSpecAllOf.httpPort)
                && Objects.equals(this.internalPorts, appServiceSpecAllOf.internalPorts)
                && Objects.equals(this.routes, appServiceSpecAllOf.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cors, healthCheck, httpPort, internalPorts, routes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppServiceSpecAllOf {\n");
        sb.append("    cors: ").append(toIndentedString(cors)).append("\n");
        sb.append("    healthCheck: ").append(toIndentedString(healthCheck)).append("\n");
        sb.append("    httpPort: ").append(toIndentedString(httpPort)).append("\n");
        sb.append("    internalPorts: ").append(toIndentedString(internalPorts)).append("\n");
        sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
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