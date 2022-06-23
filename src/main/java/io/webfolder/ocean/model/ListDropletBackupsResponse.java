package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListDropletBackupsResponse
 */
@JsonPropertyOrder({ ListDropletBackupsResponse.JSON_PROPERTY_BACKUPS, ListDropletBackupsResponse.JSON_PROPERTY_LINKS,
        ListDropletBackupsResponse.JSON_PROPERTY_META })
public class ListDropletBackupsResponse {
    public static final String JSON_PROPERTY_BACKUPS = "backups";
    private List<DropletSnapshot> backups = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListDropletBackupsResponse() {
    }

    public ListDropletBackupsResponse backups(List<DropletSnapshot> backups) {
        this.backups = backups;
        return this;
    }

    public ListDropletBackupsResponse addBackupsItem(DropletSnapshot backupsItem) {
        if (this.backups == null) {
            this.backups = new ArrayList<>();
        }
        this.backups.add(backupsItem);
        return this;
    }

    /**
     * Get backups
     *
     * @return backups
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BACKUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<DropletSnapshot> getBackups() {
        return backups;
    }

    @JsonProperty(JSON_PROPERTY_BACKUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBackups(List<DropletSnapshot> backups) {
        this.backups = backups;
    }

    public ListDropletBackupsResponse links(PageLinks links) {
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

    public ListDropletBackupsResponse meta(MetaMeta meta) {
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
     * Return true if this list_droplet_backups_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListDropletBackupsResponse listDropletBackupsResponse = (ListDropletBackupsResponse) o;
        return Objects.equals(this.backups, listDropletBackupsResponse.backups)
                && Objects.equals(this.links, listDropletBackupsResponse.links)
                && Objects.equals(this.meta, listDropletBackupsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(backups, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListDropletBackupsResponse {\n");
        sb.append("    backups: ").append(toIndentedString(backups)).append("\n");
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