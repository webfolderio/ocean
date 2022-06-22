package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AssignToDroplet1
 */
@JsonPropertyOrder({ AssignToDroplet1.JSON_PROPERTY_DROPLET_ID })
public class AssignToDroplet1 {
    public static final String JSON_PROPERTY_DROPLET_ID = "droplet_id";
    private Integer dropletId;

    public AssignToDroplet1() {
    }

    public AssignToDroplet1 dropletId(Integer dropletId) {
        this.dropletId = dropletId;
        return this;
    }

    /**
     * The ID of the Droplet that the reserved IP will be assigned to.
     *
     * @return dropletId
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "2457247", required = true, value = "The ID of the Droplet that the reserved IP will be assigned to.")
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
     * Return true if this Assign_to_Droplet_1 object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AssignToDroplet1 assignToDroplet1 = (AssignToDroplet1) o;
        return Objects.equals(this.dropletId, assignToDroplet1.dropletId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dropletId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssignToDroplet1 {\n");
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
