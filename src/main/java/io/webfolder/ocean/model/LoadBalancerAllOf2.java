package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * LoadBalancerAllOf2
 */
@JsonPropertyOrder({ LoadBalancerAllOf2.JSON_PROPERTY_TAG })
public class LoadBalancerAllOf2 {
    public static final String JSON_PROPERTY_TAG = "tag";
    private String tag;

    public LoadBalancerAllOf2() {
    }

    public LoadBalancerAllOf2 tag(String tag) {
        this.tag = tag;
        return this;
    }

    /**
     * The name of a Droplet tag corresponding to Droplets assigned to the load
     * balancer.
     *
     * @return tag
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "prod:web", value = "The name of a Droplet tag corresponding to Droplets assigned to the load balancer.")
    @JsonProperty(JSON_PROPERTY_TAG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTag() {
        return tag;
    }

    @JsonProperty(JSON_PROPERTY_TAG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Return true if this load_balancer_allOf_2 object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoadBalancerAllOf2 loadBalancerAllOf2 = (LoadBalancerAllOf2) o;
        return Objects.equals(this.tag, loadBalancerAllOf2.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoadBalancerAllOf2 {\n");
        sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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
