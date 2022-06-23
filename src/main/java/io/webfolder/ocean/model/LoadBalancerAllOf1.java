package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * LoadBalancerAllOf1
 */
@JsonPropertyOrder({ LoadBalancerAllOf1.JSON_PROPERTY_DROPLET_IDS })
public class LoadBalancerAllOf1 {
    public static final String JSON_PROPERTY_DROPLET_IDS = "droplet_ids";
    private List<Integer> dropletIds = null;

    public LoadBalancerAllOf1() {
    }

    public LoadBalancerAllOf1 dropletIds(List<Integer> dropletIds) {
        this.dropletIds = dropletIds;
        return this;
    }

    public LoadBalancerAllOf1 addDropletIdsItem(Integer dropletIdsItem) {
        if (this.dropletIds == null) {
            this.dropletIds = new ArrayList<>();
        }
        this.dropletIds.add(dropletIdsItem);
        return this;
    }

    /**
     * An array containing the IDs of the Droplets assigned to the load balancer.
     *
     * @return dropletIds
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DROPLET_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<Integer> getDropletIds() {
        return dropletIds;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDropletIds(List<Integer> dropletIds) {
        this.dropletIds = dropletIds;
    }

    /**
     * Return true if this load_balancer_allOf_1 object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoadBalancerAllOf1 loadBalancerAllOf1 = (LoadBalancerAllOf1) o;
        return Objects.equals(this.dropletIds, loadBalancerAllOf1.dropletIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dropletIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoadBalancerAllOf1 {\n");
        sb.append("    dropletIds: ").append(toIndentedString(dropletIds)).append("\n");
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