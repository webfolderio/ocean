package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllVolumesResponse
 */
@JsonPropertyOrder({ ListAllVolumesResponse.JSON_PROPERTY_VOLUMES, ListAllVolumesResponse.JSON_PROPERTY_LINKS,
        ListAllVolumesResponse.JSON_PROPERTY_META })
public class ListAllVolumesResponse {
    public static final String JSON_PROPERTY_VOLUMES = "volumes";
    private List<VolumeFull> volumes = new ArrayList<>();

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListAllVolumesResponse() {
    }

    public ListAllVolumesResponse volumes(List<VolumeFull> volumes) {
        this.volumes = volumes;
        return this;
    }

    public ListAllVolumesResponse addVolumesItem(VolumeFull volumesItem) {
        this.volumes.add(volumesItem);
        return this;
    }

    /**
     * Array of volumes.
     *
     * @return volumes
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<VolumeFull> getVolumes() {
        return volumes;
    }

    @JsonProperty(JSON_PROPERTY_VOLUMES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setVolumes(List<VolumeFull> volumes) {
        this.volumes = volumes;
    }

    public ListAllVolumesResponse links(PageLinks links) {
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

    public ListAllVolumesResponse meta(MetaMeta meta) {
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
     * Return true if this list_all_volumes_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllVolumesResponse listAllVolumesResponse = (ListAllVolumesResponse) o;
        return Objects.equals(this.volumes, listAllVolumesResponse.volumes)
                && Objects.equals(this.links, listAllVolumesResponse.links)
                && Objects.equals(this.meta, listAllVolumesResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volumes, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllVolumesResponse {\n");
        sb.append("    volumes: ").append(toIndentedString(volumes)).append("\n");
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
