package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * PostVolumeActionByNameResponse
 */
@JsonPropertyOrder({ PostVolumeActionByNameResponse.JSON_PROPERTY_ACTION })
public class PostVolumeActionByNameResponse {
    public static final String JSON_PROPERTY_ACTION = "action";
    private VolumeAction action;

    public PostVolumeActionByNameResponse() {
    }

    public PostVolumeActionByNameResponse action(VolumeAction action) {
        this.action = action;
        return this;
    }

    /**
     * Get action
     *
     * @return action
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public VolumeAction getAction() {
        return action;
    }

    @JsonProperty(JSON_PROPERTY_ACTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAction(VolumeAction action) {
        this.action = action;
    }

    /**
     * Return true if this post_volume_action_by_name_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostVolumeActionByNameResponse postVolumeActionByNameResponse = (PostVolumeActionByNameResponse) o;
        return Objects.equals(this.action, postVolumeActionByNameResponse.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostVolumeActionByNameResponse {\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
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