package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateLoadBalancerResponse
 */
@JsonPropertyOrder({ CreateLoadBalancerResponse.JSON_PROPERTY_LOAD_BALANCER })
public class CreateLoadBalancerResponse {
    public static final String JSON_PROPERTY_LOAD_BALANCER = "load_balancer";
    private LoadBalancer loadBalancer;

    public CreateLoadBalancerResponse() {
    }

    public CreateLoadBalancerResponse loadBalancer(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
        return this;
    }

    /**
     * Get loadBalancer
     *
     * @return loadBalancer
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOAD_BALANCER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public LoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    @JsonProperty(JSON_PROPERTY_LOAD_BALANCER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLoadBalancer(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * Return true if this create_load_balancer_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateLoadBalancerResponse createLoadBalancerResponse = (CreateLoadBalancerResponse) o;
        return Objects.equals(this.loadBalancer, createLoadBalancerResponse.loadBalancer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loadBalancer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateLoadBalancerResponse {\n");
        sb.append("    loadBalancer: ").append(toIndentedString(loadBalancer)).append("\n");
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
