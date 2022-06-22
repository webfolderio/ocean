package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateFloatingIpResponseLinks
 */
@JsonPropertyOrder({ CreateFloatingIpResponseLinks.JSON_PROPERTY_DROPLETS,
        CreateFloatingIpResponseLinks.JSON_PROPERTY_ACTIONS })
public class CreateFloatingIpResponseLinks {
    public static final String JSON_PROPERTY_DROPLETS = "droplets";
    private List<ActionLink> droplets = null;

    public static final String JSON_PROPERTY_ACTIONS = "actions";
    private List<ActionLink> actions = null;

    public CreateFloatingIpResponseLinks() {
    }

    public CreateFloatingIpResponseLinks droplets(List<ActionLink> droplets) {
        this.droplets = droplets;
        return this;
    }

    public CreateFloatingIpResponseLinks addDropletsItem(ActionLink dropletsItem) {
        if (this.droplets == null) {
            this.droplets = new ArrayList<>();
        }
        this.droplets.add(dropletsItem);
        return this;
    }

    /**
     * Get droplets
     *
     * @return droplets
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DROPLETS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ActionLink> getDroplets() {
        return droplets;
    }

    @JsonProperty(JSON_PROPERTY_DROPLETS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDroplets(List<ActionLink> droplets) {
        this.droplets = droplets;
    }

    public CreateFloatingIpResponseLinks actions(List<ActionLink> actions) {
        this.actions = actions;
        return this;
    }

    public CreateFloatingIpResponseLinks addActionsItem(ActionLink actionsItem) {
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
     * Return true if this create_floating_ip_response_links object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateFloatingIpResponseLinks createFloatingIpResponseLinks = (CreateFloatingIpResponseLinks) o;
        return Objects.equals(this.droplets, createFloatingIpResponseLinks.droplets)
                && Objects.equals(this.actions, createFloatingIpResponseLinks.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(droplets, actions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateFloatingIpResponseLinks {\n");
        sb.append("    droplets: ").append(toIndentedString(droplets)).append("\n");
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
