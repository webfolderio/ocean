package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsResponse
 */
@JsonPropertyOrder({ AppsResponse.JSON_PROPERTY_APPS, AppsResponse.JSON_PROPERTY_LINKS,
        AppsResponse.JSON_PROPERTY_META })
public class AppsResponse {
    public static final String JSON_PROPERTY_APPS = "apps";
    private List<App> apps = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public AppsResponse() {
    }

    public AppsResponse apps(List<App> apps) {
        this.apps = apps;
        return this;
    }

    public AppsResponse addAppsItem(App appsItem) {
        if (this.apps == null) {
            this.apps = new ArrayList<>();
        }
        this.apps.add(appsItem);
        return this;
    }

    /**
     * Get apps
     *
     * @return apps
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_APPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<App> getApps() {
        return apps;
    }

    @JsonProperty(JSON_PROPERTY_APPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setApps(List<App> apps) {
        this.apps = apps;
    }

    public AppsResponse links(PageLinks links) {
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

    public AppsResponse meta(MetaMeta meta) {
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
     * Return true if this apps_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsResponse appsResponse = (AppsResponse) o;
        return Objects.equals(this.apps, appsResponse.apps) && Objects.equals(this.links, appsResponse.links)
                && Objects.equals(this.meta, appsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apps, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsResponse {\n");
        sb.append("    apps: ").append(toIndentedString(apps)).append("\n");
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
