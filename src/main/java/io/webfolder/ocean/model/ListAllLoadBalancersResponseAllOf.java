package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllLoadBalancersResponseAllOf
 */
@JsonPropertyOrder({ ListAllLoadBalancersResponseAllOf.JSON_PROPERTY_LOAD_BALANCERS })
public class ListAllLoadBalancersResponseAllOf {
    public static final String JSON_PROPERTY_LOAD_BALANCERS = "load_balancers";
    private List<LoadBalancer> loadBalancers = null;

    public ListAllLoadBalancersResponseAllOf() {
    }

    public ListAllLoadBalancersResponseAllOf loadBalancers(List<LoadBalancer> loadBalancers) {
        this.loadBalancers = loadBalancers;
        return this;
    }

    public ListAllLoadBalancersResponseAllOf addLoadBalancersItem(LoadBalancer loadBalancersItem) {
        if (this.loadBalancers == null) {
            this.loadBalancers = new ArrayList<>();
        }
        this.loadBalancers.add(loadBalancersItem);
        return this;
    }

    /**
     * Get loadBalancers
     *
     * @return loadBalancers
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOAD_BALANCERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<LoadBalancer> getLoadBalancers() {
        return loadBalancers;
    }

    @JsonProperty(JSON_PROPERTY_LOAD_BALANCERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLoadBalancers(List<LoadBalancer> loadBalancers) {
        this.loadBalancers = loadBalancers;
    }

    /**
     * Return true if this list_all_load_balancers_response_allOf object is equal to
     * o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllLoadBalancersResponseAllOf listAllLoadBalancersResponseAllOf = (ListAllLoadBalancersResponseAllOf) o;
        return Objects.equals(this.loadBalancers, listAllLoadBalancersResponseAllOf.loadBalancers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loadBalancers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllLoadBalancersResponseAllOf {\n");
        sb.append("    loadBalancers: ").append(toIndentedString(loadBalancers)).append("\n");
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
