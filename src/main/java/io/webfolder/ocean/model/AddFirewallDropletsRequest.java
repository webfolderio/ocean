package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AddFirewallDropletsRequest
 */
@JsonPropertyOrder({ AddFirewallDropletsRequest.JSON_PROPERTY_DROPLET_IDS })
public class AddFirewallDropletsRequest {
    public static final String JSON_PROPERTY_DROPLET_IDS = "droplet_ids";
    private List<Integer> dropletIds = new ArrayList<>();

    public AddFirewallDropletsRequest() {
    }

    public AddFirewallDropletsRequest dropletIds(List<Integer> dropletIds) {
        this.dropletIds = dropletIds;
        return this;
    }

    public AddFirewallDropletsRequest addDropletIdsItem(Integer dropletIdsItem) {
        this.dropletIds.add(dropletIdsItem);
        return this;
    }

    /**
     * An array containing the IDs of the Droplets to be assigned to the firewall.
     *
     * @return dropletIds
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DROPLET_IDS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<Integer> getDropletIds() {
        return dropletIds;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET_IDS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDropletIds(List<Integer> dropletIds) {
        this.dropletIds = dropletIds;
    }

    /**
     * Return true if this add_firewall_droplets_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddFirewallDropletsRequest addFirewallDropletsRequest = (AddFirewallDropletsRequest) o;
        return Objects.equals(this.dropletIds, addFirewallDropletsRequest.dropletIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dropletIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddFirewallDropletsRequest {\n");
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