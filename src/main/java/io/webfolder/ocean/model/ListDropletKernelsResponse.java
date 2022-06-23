package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListDropletKernelsResponse
 */
@JsonPropertyOrder({ ListDropletKernelsResponse.JSON_PROPERTY_KERNELS, ListDropletKernelsResponse.JSON_PROPERTY_LINKS,
        ListDropletKernelsResponse.JSON_PROPERTY_META })
public class ListDropletKernelsResponse {
    public static final String JSON_PROPERTY_KERNELS = "kernels";
    private List<Kernel> kernels = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListDropletKernelsResponse() {
    }

    public ListDropletKernelsResponse kernels(List<Kernel> kernels) {
        this.kernels = kernels;
        return this;
    }

    public ListDropletKernelsResponse addKernelsItem(Kernel kernelsItem) {
        if (this.kernels == null) {
            this.kernels = new ArrayList<>();
        }
        this.kernels.add(kernelsItem);
        return this;
    }

    /**
     * Get kernels
     *
     * @return kernels
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KERNELS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<Kernel> getKernels() {
        return kernels;
    }

    @JsonProperty(JSON_PROPERTY_KERNELS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKernels(List<Kernel> kernels) {
        this.kernels = kernels;
    }

    public ListDropletKernelsResponse links(PageLinks links) {
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

    public ListDropletKernelsResponse meta(MetaMeta meta) {
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
     * Return true if this list_droplet_kernels_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListDropletKernelsResponse listDropletKernelsResponse = (ListDropletKernelsResponse) o;
        return Objects.equals(this.kernels, listDropletKernelsResponse.kernels)
                && Objects.equals(this.links, listDropletKernelsResponse.links)
                && Objects.equals(this.meta, listDropletKernelsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kernels, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListDropletKernelsResponse {\n");
        sb.append("    kernels: ").append(toIndentedString(kernels)).append("\n");
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