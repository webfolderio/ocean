package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsDeploymentsResponseAllOf
 */
@JsonPropertyOrder({ AppsDeploymentsResponseAllOf.JSON_PROPERTY_DEPLOYMENTS })
public class AppsDeploymentsResponseAllOf {
    public static final String JSON_PROPERTY_DEPLOYMENTS = "deployments";
    private List<AppsDeployment> deployments = null;

    public AppsDeploymentsResponseAllOf() {
    }

    public AppsDeploymentsResponseAllOf deployments(List<AppsDeployment> deployments) {
        this.deployments = deployments;
        return this;
    }

    public AppsDeploymentsResponseAllOf addDeploymentsItem(AppsDeployment deploymentsItem) {
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

    /**
     * Return true if this apps_deployments_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsDeploymentsResponseAllOf appsDeploymentsResponseAllOf = (AppsDeploymentsResponseAllOf) o;
        return Objects.equals(this.deployments, appsDeploymentsResponseAllOf.deployments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deployments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsDeploymentsResponseAllOf {\n");
        sb.append("    deployments: ").append(toIndentedString(deployments)).append("\n");
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
