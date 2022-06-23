package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAlertPoliciesResponse
 */
@JsonPropertyOrder({ ListAlertPoliciesResponse.JSON_PROPERTY_POLICIES, ListAlertPoliciesResponse.JSON_PROPERTY_LINKS,
        ListAlertPoliciesResponse.JSON_PROPERTY_META })
public class ListAlertPoliciesResponse {
    public static final String JSON_PROPERTY_POLICIES = "policies";
    private List<AlertPolicy> policies = new ArrayList<>();

    public static final String JSON_PROPERTY_LINKS = "links";
    private PageLinks links;

    public static final String JSON_PROPERTY_META = "meta";
    private MetaMeta meta;

    public ListAlertPoliciesResponse() {
    }

    public ListAlertPoliciesResponse policies(List<AlertPolicy> policies) {
        this.policies = policies;
        return this;
    }

    public ListAlertPoliciesResponse addPoliciesItem(AlertPolicy policiesItem) {
        this.policies.add(policiesItem);
        return this;
    }

    /**
     * Get policies
     *
     * @return policies
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_POLICIES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<AlertPolicy> getPolicies() {
        return policies;
    }

    @JsonProperty(JSON_PROPERTY_POLICIES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPolicies(List<AlertPolicy> policies) {
        this.policies = policies;
    }

    public ListAlertPoliciesResponse links(PageLinks links) {
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

    public ListAlertPoliciesResponse meta(MetaMeta meta) {
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
     * Return true if this list_alert_policies_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAlertPoliciesResponse listAlertPoliciesResponse = (ListAlertPoliciesResponse) o;
        return Objects.equals(this.policies, listAlertPoliciesResponse.policies)
                && Objects.equals(this.links, listAlertPoliciesResponse.links)
                && Objects.equals(this.meta, listAlertPoliciesResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policies, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAlertPoliciesResponse {\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
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