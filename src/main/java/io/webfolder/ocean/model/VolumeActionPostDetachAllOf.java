package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * VolumeActionPostDetachAllOf
 */
@JsonPropertyOrder({ VolumeActionPostDetachAllOf.JSON_PROPERTY_DROPLET_ID })
public class VolumeActionPostDetachAllOf {
    public static final String JSON_PROPERTY_DROPLET_ID = "droplet_id";
    private Integer dropletId;

    public VolumeActionPostDetachAllOf() {
    }

    public VolumeActionPostDetachAllOf dropletId(Integer dropletId) {
        this.dropletId = dropletId;
        return this;
    }

    /**
     * The unique identifier for the Droplet the volume will be attached or detached
     * from.
     *
     * @return dropletId
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "11612190", required = true, value = "The unique identifier for the Droplet the volume will be attached or detached from.")
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
     * Return true if this volume_action_post_detach_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VolumeActionPostDetachAllOf volumeActionPostDetachAllOf = (VolumeActionPostDetachAllOf) o;
        return Objects.equals(this.dropletId, volumeActionPostDetachAllOf.dropletId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dropletId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VolumeActionPostDetachAllOf {\n");
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
