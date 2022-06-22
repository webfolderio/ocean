package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListAllKubernetesClustersResponse
 */
@JsonPropertyOrder({ ListAllKubernetesClustersResponse.JSON_PROPERTY_KUBERNETES_CLUSTERS,
        ListAllKubernetesClustersResponse.JSON_PROPERTY_LINKS, ListAllKubernetesClustersResponse.JSON_PROPERTY_META })
public class ListAllKubernetesClustersResponse {
    public static final String JSON_PROPERTY_KUBERNETES_CLUSTERS = "kubernetes_clusters";
    private List<Cluster> kubernetesClusters = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListAllKubernetesClustersResponse() {
    }

    public ListAllKubernetesClustersResponse kubernetesClusters(List<Cluster> kubernetesClusters) {
        this.kubernetesClusters = kubernetesClusters;
        return this;
    }

    public ListAllKubernetesClustersResponse addKubernetesClustersItem(Cluster kubernetesClustersItem) {
        if (this.kubernetesClusters == null) {
            this.kubernetesClusters = new ArrayList<>();
        }
        this.kubernetesClusters.add(kubernetesClustersItem);
        return this;
    }

    /**
     * Get kubernetesClusters
     *
     * @return kubernetesClusters
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_KUBERNETES_CLUSTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Cluster> getKubernetesClusters() {
        return kubernetesClusters;
    }

    @JsonProperty(JSON_PROPERTY_KUBERNETES_CLUSTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKubernetesClusters(List<Cluster> kubernetesClusters) {
        this.kubernetesClusters = kubernetesClusters;
    }

    public ListAllKubernetesClustersResponse links(PageLinks links) {
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

    public ListAllKubernetesClustersResponse meta(MetaMeta meta) {
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
     * Return true if this list_all_kubernetes_clusters_response object is equal to
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
        ListAllKubernetesClustersResponse listAllKubernetesClustersResponse = (ListAllKubernetesClustersResponse) o;
        return Objects.equals(this.kubernetesClusters, listAllKubernetesClustersResponse.kubernetesClusters)
                && Objects.equals(this.links, listAllKubernetesClustersResponse.links)
                && Objects.equals(this.meta, listAllKubernetesClustersResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kubernetesClusters, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllKubernetesClustersResponse {\n");
        sb.append("    kubernetesClusters: ").append(toIndentedString(kubernetesClusters)).append("\n");
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
