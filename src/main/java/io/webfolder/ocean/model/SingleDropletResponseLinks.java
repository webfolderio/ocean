package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * SingleDropletResponseLinks
 */
@JsonPropertyOrder({ SingleDropletResponseLinks.JSON_PROPERTY_ACTIONS })
public class SingleDropletResponseLinks {
    public static final String JSON_PROPERTY_ACTIONS = "actions";
    private List<ActionLink> actions = null;

    public SingleDropletResponseLinks() {
    }

    public SingleDropletResponseLinks actions(List<ActionLink> actions) {
        this.actions = actions;
        return this;
    }

    public SingleDropletResponseLinks addActionsItem(ActionLink actionsItem) {
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
    @JsonProperty(JSON_PROPERTY_ACTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<ActionLink> getActions() {
        return actions;
    }

    @JsonProperty(JSON_PROPERTY_ACTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActions(List<ActionLink> actions) {
        this.actions = actions;
    }

    /**
     * Return true if this Single_Droplet_Response_links object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SingleDropletResponseLinks singleDropletResponseLinks = (SingleDropletResponseLinks) o;
        return Objects.equals(this.actions, singleDropletResponseLinks.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SingleDropletResponseLinks {\n");
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