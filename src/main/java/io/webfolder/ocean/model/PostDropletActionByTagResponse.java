package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * PostDropletActionByTagResponse
 */
@JsonPropertyOrder({ PostDropletActionByTagResponse.JSON_PROPERTY_ACTIONS })
public class PostDropletActionByTagResponse {
    public static final String JSON_PROPERTY_ACTIONS = "actions";
    private List<Action> actions = null;

    public PostDropletActionByTagResponse() {
    }

    public PostDropletActionByTagResponse actions(List<Action> actions) {
        this.actions = actions;
        return this;
    }

    public PostDropletActionByTagResponse addActionsItem(Action actionsItem) {
        if (this.actions == null) {
            this.actions = new ArrayList<>();
        }
        this.actions.add(actionsItem);
        return this;
    }

    /**
     * Get actions
     *
     * @return actions
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ACTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Action> getActions() {
        return actions;
    }

    @JsonProperty(JSON_PROPERTY_ACTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    /**
     * Return true if this post_droplet_action_by_tag_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostDropletActionByTagResponse postDropletActionByTagResponse = (PostDropletActionByTagResponse) o;
        return Objects.equals(this.actions, postDropletActionByTagResponse.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostDropletActionByTagResponse {\n");
        sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
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
