package io.webfolder.ocean.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * LoadBalancerAllOf
 */
@JsonPropertyOrder({ LoadBalancerAllOf.JSON_PROPERTY_REGION })
public class LoadBalancerAllOf {
    public static final String JSON_PROPERTY_REGION = "region";
    private Map<String, Object> region;

    public LoadBalancerAllOf() {
    }

    public LoadBalancerAllOf region(Map<String, Object> region) {
        this.region = region;
        return this;
    }

    public LoadBalancerAllOf putRegionItem(String key, Object regionItem) {
        if (this.region == null) {
            this.region = new LinkedHashMap<>();
        }
        this.region.put(key, regionItem);
        return this;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(Map<String, Object> region) {
        this.region = region;
    }

    /**
     * Return true if this load_balancer_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoadBalancerAllOf loadBalancerAllOf = (LoadBalancerAllOf) o;
        return Objects.equals(this.region, loadBalancerAllOf.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoadBalancerAllOf {\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
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
