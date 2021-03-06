package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListProjectResourcesResponse
 */
@JsonPropertyOrder({ ListProjectResourcesResponse.JSON_PROPERTY_RESOURCES,
        ListProjectResourcesResponse.JSON_PROPERTY_LINKS, ListProjectResourcesResponse.JSON_PROPERTY_META })
public class ListProjectResourcesResponse {
    public static final String JSON_PROPERTY_RESOURCES = "resources";
    private List<Resource> resources = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListProjectResourcesResponse() {
    }

    public ListProjectResourcesResponse resources(List<Resource> resources) {
        this.resources = resources;
        return this;
    }

    public ListProjectResourcesResponse addResourcesItem(Resource resourcesItem) {
        if (this.resources == null) {
            this.resources = new ArrayList<>();
        }
        this.resources.add(resourcesItem);
        return this;
    }

    /**
     * Get resources
     *
     * @return resources
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<Resource> getResources() {
        return resources;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public ListProjectResourcesResponse links(PageLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
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

    public ListProjectResourcesResponse meta(MetaMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
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
     * Return true if this list_project_resources_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListProjectResourcesResponse listProjectResourcesResponse = (ListProjectResourcesResponse) o;
        return Objects.equals(this.resources, listProjectResourcesResponse.resources)
                && Objects.equals(this.links, listProjectResourcesResponse.links)
                && Objects.equals(this.meta, listProjectResourcesResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resources, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListProjectResourcesResponse {\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
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