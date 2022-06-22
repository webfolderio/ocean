package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * FirewallAllOfPendingChanges
 */
@JsonPropertyOrder({ FirewallAllOfPendingChanges.JSON_PROPERTY_DROPLET_ID,
        FirewallAllOfPendingChanges.JSON_PROPERTY_REMOVING, FirewallAllOfPendingChanges.JSON_PROPERTY_STATUS })
public class FirewallAllOfPendingChanges {
    public static final String JSON_PROPERTY_DROPLET_ID = "droplet_id";
    private Integer dropletId;

    public static final String JSON_PROPERTY_REMOVING = "removing";
    private Boolean removing;

    public static final String JSON_PROPERTY_STATUS = "status";
    private String status;

    public FirewallAllOfPendingChanges() {
    }

    public FirewallAllOfPendingChanges dropletId(Integer dropletId) {
        this.dropletId = dropletId;
        return this;
    }

    /**
     * Get dropletId
     *
     * @return dropletId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "8043964", value = "")
    @JsonProperty(JSON_PROPERTY_DROPLET_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getDropletId() {
        return dropletId;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDropletId(Integer dropletId) {
        this.dropletId = dropletId;
    }

    public FirewallAllOfPendingChanges removing(Boolean removing) {
        this.removing = removing;
        return this;
    }

    /**
     * Get removing
     *
     * @return removing
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "false", value = "")
    @JsonProperty(JSON_PROPERTY_REMOVING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getRemoving() {
        return removing;
    }

    @JsonProperty(JSON_PROPERTY_REMOVING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRemoving(Boolean removing) {
        this.removing = removing;
    }

    public FirewallAllOfPendingChanges status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "waiting", value = "")
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Return true if this firewall_allOf_pending_changes object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirewallAllOfPendingChanges firewallAllOfPendingChanges = (FirewallAllOfPendingChanges) o;
        return Objects.equals(this.dropletId, firewallAllOfPendingChanges.dropletId)
                && Objects.equals(this.removing, firewallAllOfPendingChanges.removing)
                && Objects.equals(this.status, firewallAllOfPendingChanges.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dropletId, removing, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FirewallAllOfPendingChanges {\n");
        sb.append("    dropletId: ").append(toIndentedString(dropletId)).append("\n");
        sb.append("    removing: ").append(toIndentedString(removing)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
