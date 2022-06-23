package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * OneClickCreate
 */
@JsonPropertyOrder({ OneClickCreate.JSON_PROPERTY_ADDON_SLUGS, OneClickCreate.JSON_PROPERTY_CLUSTER_UUID })
public class OneClickCreate {
    public static final String JSON_PROPERTY_ADDON_SLUGS = "addon_slugs";
    private List<String> addonSlugs = new ArrayList<>();

    public static final String JSON_PROPERTY_CLUSTER_UUID = "cluster_uuid";
    private String clusterUuid;

    public OneClickCreate() {
    }

    public OneClickCreate addonSlugs(List<String> addonSlugs) {
        this.addonSlugs = addonSlugs;
        return this;
    }

    public OneClickCreate addAddonSlugsItem(String addonSlugsItem) {
        this.addonSlugs.add(addonSlugsItem);
        return this;
    }

    /**
     * An array of 1-Click Application slugs to be installed to the Kubernetes
     * cluster.
     *
     * @return addonSlugs
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ADDON_SLUGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getAddonSlugs() {
        return addonSlugs;
    }

    @JsonProperty(JSON_PROPERTY_ADDON_SLUGS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setAddonSlugs(List<String> addonSlugs) {
        this.addonSlugs = addonSlugs;
    }

    public OneClickCreate clusterUuid(String clusterUuid) {
        this.clusterUuid = clusterUuid;
        return this;
    }

    /**
     * A unique ID for the Kubernetes cluster to which the 1-Click Applications will
     * be installed.
     *
     * @return clusterUuid
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CLUSTER_UUID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getClusterUuid() {
        return clusterUuid;
    }

    @JsonProperty(JSON_PROPERTY_CLUSTER_UUID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setClusterUuid(String clusterUuid) {
        this.clusterUuid = clusterUuid;
    }

    /**
     * Return true if this 1_click_create object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OneClickCreate _1clickCreate = (OneClickCreate) o;
        return Objects.equals(this.addonSlugs, _1clickCreate.addonSlugs)
                && Objects.equals(this.clusterUuid, _1clickCreate.clusterUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addonSlugs, clusterUuid);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OneClickCreate {\n");
        sb.append("    addonSlugs: ").append(toIndentedString(addonSlugs)).append("\n");
        sb.append("    clusterUuid: ").append(toIndentedString(clusterUuid)).append("\n");
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