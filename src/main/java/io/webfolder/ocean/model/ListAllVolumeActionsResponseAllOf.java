package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllVolumeActionsResponseAllOf
 */
@JsonPropertyOrder({ ListAllVolumeActionsResponseAllOf.JSON_PROPERTY_ACTIONS })
public class ListAllVolumeActionsResponseAllOf {
    public static final String JSON_PROPERTY_ACTIONS = "actions";
    private List<VolumeAction> actions = null;

    public ListAllVolumeActionsResponseAllOf() {
    }

    public ListAllVolumeActionsResponseAllOf actions(List<VolumeAction> actions) {
        this.actions = actions;
        return this;
    }

    public ListAllVolumeActionsResponseAllOf addActionsItem(VolumeAction actionsItem) {
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
    public List<VolumeAction> getActions() {
        return actions;
    }

    @JsonProperty(JSON_PROPERTY_ACTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActions(List<VolumeAction> actions) {
        this.actions = actions;
    }

    /**
     * Return true if this list_all_volume_actions_response_allOf object is equal to
     * o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllVolumeActionsResponseAllOf listAllVolumeActionsResponseAllOf = (ListAllVolumeActionsResponseAllOf) o;
        return Objects.equals(this.actions, listAllVolumeActionsResponseAllOf.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllVolumeActionsResponseAllOf {\n");
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