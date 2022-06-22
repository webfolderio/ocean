package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListFloatingIpActionsResponse
 */
@JsonPropertyOrder({ ListFloatingIpActionsResponse.JSON_PROPERTY_ACTIONS,
        ListFloatingIpActionsResponse.JSON_PROPERTY_LINKS, ListFloatingIpActionsResponse.JSON_PROPERTY_META })
public class ListFloatingIpActionsResponse {
    public static final String JSON_PROPERTY_ACTIONS = "actions";
    private List<Action> actions = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListFloatingIpActionsResponse() {
    }

    public ListFloatingIpActionsResponse actions(List<Action> actions) {
        this.actions = actions;
        return this;
    }

    public ListFloatingIpActionsResponse addActionsItem(Action actionsItem) {
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

    public ListFloatingIpActionsResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PageLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLinks(PageLinks links) {
        this.links = links;
    }

    public ListFloatingIpActionsResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public MetaMeta getMeta() {
        return meta;
    }

    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMeta(MetaMeta meta) {
        this.meta = meta;
    }

    /**
     * Return true if this list_floating_ip_actions_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListFloatingIpActionsResponse listFloatingIpActionsResponse = (ListFloatingIpActionsResponse) o;
        return Objects.equals(this.actions, listFloatingIpActionsResponse.actions)
                && Objects.equals(this.links, listFloatingIpActionsResponse.links)
                && Objects.equals(this.meta, listFloatingIpActionsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actions, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListFloatingIpActionsResponse {\n");
        sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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