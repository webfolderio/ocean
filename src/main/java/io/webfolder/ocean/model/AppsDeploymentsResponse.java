package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsDeploymentsResponse
 */
@JsonPropertyOrder({ AppsDeploymentsResponse.JSON_PROPERTY_DEPLOYMENTS, AppsDeploymentsResponse.JSON_PROPERTY_LINKS,
        AppsDeploymentsResponse.JSON_PROPERTY_META })
public class AppsDeploymentsResponse {
    public static final String JSON_PROPERTY_DEPLOYMENTS = "deployments";
    private List<AppsDeployment> deployments = null;

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public AppsDeploymentsResponse() {
    }

    public AppsDeploymentsResponse deployments(List<AppsDeployment> deployments) {
        this.deployments = deployments;
        return this;
    }

    public AppsDeploymentsResponse addDeploymentsItem(AppsDeployment deploymentsItem) {
        if (this.deployments == null) {
            this.deployments = new ArrayList<>();
        }
        this.deployments.add(deploymentsItem);
        return this;
    }

    /**
     * Get deployments
     *
     * @return deployments
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEPLOYMENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<AppsDeployment> getDeployments() {
        return deployments;
    }

    @JsonProperty(JSON_PROPERTY_DEPLOYMENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDeployments(List<AppsDeployment> deployments) {
        this.deployments = deployments;
    }

    public AppsDeploymentsResponse links(PageLinks links) {
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

    public AppsDeploymentsResponse meta(MetaMeta meta) {
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
     * Return true if this apps_deployments_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsDeploymentsResponse appsDeploymentsResponse = (AppsDeploymentsResponse) o;
        return Objects.equals(this.deployments, appsDeploymentsResponse.deployments)
                && Objects.equals(this.links, appsDeploymentsResponse.links)
                && Objects.equals(this.meta, appsDeploymentsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deployments, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsDeploymentsResponse {\n");
        sb.append("    deployments: ").append(toIndentedString(deployments)).append("\n");
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