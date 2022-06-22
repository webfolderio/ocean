package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ReservedIpActionAssignAllOf
 */
@JsonPropertyOrder({ ReservedIpActionAssignAllOf.JSON_PROPERTY_DROPLET_ID })
public class ReservedIpActionAssignAllOf {
    public static final String JSON_PROPERTY_DROPLET_ID = "droplet_id";
    private Integer dropletId;

    public ReservedIpActionAssignAllOf() {
    }

    public ReservedIpActionAssignAllOf dropletId(Integer dropletId) {
        this.dropletId = dropletId;
        return this;
    }

    /**
     * The ID of the Droplet that the reserved IP will be assigned to.
     *
     * @return dropletId
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DROPLET_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getDropletId() {
        return dropletId;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDropletId(Integer dropletId) {
        this.dropletId = dropletId;
    }

    /**
     * Return true if this reserved_ip_action_assign_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReservedIpActionAssignAllOf reservedIpActionAssignAllOf = (ReservedIpActionAssignAllOf) o;
        return Objects.equals(this.dropletId, reservedIpActionAssignAllOf.dropletId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dropletId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ReservedIpActionAssignAllOf {\n");
        sb.append("    dropletId: ").append(toIndentedString(dropletId)).append("\n");
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
