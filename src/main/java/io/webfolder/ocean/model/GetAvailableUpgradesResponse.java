package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetAvailableUpgradesResponse
 */
@JsonPropertyOrder({ GetAvailableUpgradesResponse.JSON_PROPERTY_AVAILABLE_UPGRADE_VERSIONS })
public class GetAvailableUpgradesResponse {
    public static final String JSON_PROPERTY_AVAILABLE_UPGRADE_VERSIONS = "available_upgrade_versions";
    private List<KubernetesVersion> availableUpgradeVersions = null;

    public GetAvailableUpgradesResponse() {
    }

    public GetAvailableUpgradesResponse availableUpgradeVersions(List<KubernetesVersion> availableUpgradeVersions) {
        this.availableUpgradeVersions = availableUpgradeVersions;
        return this;
    }

    public GetAvailableUpgradesResponse addAvailableUpgradeVersionsItem(
            KubernetesVersion availableUpgradeVersionsItem) {
        if (this.availableUpgradeVersions == null) {
            this.availableUpgradeVersions = new ArrayList<>();
        }
        this.availableUpgradeVersions.add(availableUpgradeVersionsItem);
        return this;
    }

    /**
     * Get availableUpgradeVersions
     *
     * @return availableUpgradeVersions
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_AVAILABLE_UPGRADE_VERSIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<KubernetesVersion> getAvailableUpgradeVersions() {
        return availableUpgradeVersions;
    }

    @JsonProperty(JSON_PROPERTY_AVAILABLE_UPGRADE_VERSIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAvailableUpgradeVersions(List<KubernetesVersion> availableUpgradeVersions) {
        this.availableUpgradeVersions = availableUpgradeVersions;
    }

    /**
     * Return true if this get_available_upgrades_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetAvailableUpgradesResponse getAvailableUpgradesResponse = (GetAvailableUpgradesResponse) o;
        return Objects.equals(this.availableUpgradeVersions, getAvailableUpgradesResponse.availableUpgradeVersions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableUpgradeVersions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetAvailableUpgradesResponse {\n");
        sb.append("    availableUpgradeVersions: ").append(toIndentedString(availableUpgradeVersions)).append("\n");
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
