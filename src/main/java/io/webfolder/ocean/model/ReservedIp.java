package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ReservedIp
 */
@JsonPropertyOrder({ ReservedIp.JSON_PROPERTY_IP, ReservedIp.JSON_PROPERTY_REGION, ReservedIp.JSON_PROPERTY_DROPLET,
        ReservedIp.JSON_PROPERTY_LOCKED })
public class ReservedIp {
    public static final String JSON_PROPERTY_IP = "ip";
    private String ip;

    public static final String JSON_PROPERTY_REGION = "region";
    private ReservedIpRegion region;

    public static final String JSON_PROPERTY_DROPLET = "droplet";
    private ReservedIpDroplet droplet;

    public static final String JSON_PROPERTY_LOCKED = "locked";
    private Boolean locked;

    public ReservedIp() {
    }

    public ReservedIp ip(String ip) {
        this.ip = ip;
        return this;
    }

    /**
     * The public IP address of the reserved IP. It also serves as its identifier.
     *
     * @return ip
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "45.55.96.47", value = "The public IP address of the reserved IP. It also serves as its identifier.")
    @JsonProperty(JSON_PROPERTY_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIp() {
        return ip;
    }

    @JsonProperty(JSON_PROPERTY_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIp(String ip) {
        this.ip = ip;
    }

    public ReservedIp region(ReservedIpRegion region) {
        this.region = region;
        return this;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ReservedIpRegion getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(ReservedIpRegion region) {
        this.region = region;
    }

    public ReservedIp droplet(ReservedIpDroplet droplet) {
        this.droplet = droplet;
        return this;
    }

    /**
     * Get droplet
     *
     * @return droplet
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DROPLET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ReservedIpDroplet getDroplet() {
        return droplet;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDroplet(ReservedIpDroplet droplet) {
        this.droplet = droplet;
    }

    public ReservedIp locked(Boolean locked) {
        this.locked = locked;
        return this;
    }

    /**
     * A boolean value indicating whether or not the reserved IP has pending actions
     * preventing new ones from being submitted.
     *
     * @return locked
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "true", value = "A boolean value indicating whether or not the reserved IP has pending actions preventing new ones from being submitted.")
    @JsonProperty(JSON_PROPERTY_LOCKED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getLocked() {
        return locked;
    }

    @JsonProperty(JSON_PROPERTY_LOCKED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * Return true if this reserved_ip object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReservedIp reservedIp = (ReservedIp) o;
        return Objects.equals(this.ip, reservedIp.ip) && Objects.equals(this.region, reservedIp.region)
                && Objects.equals(this.droplet, reservedIp.droplet) && Objects.equals(this.locked, reservedIp.locked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, region, droplet, locked);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ReservedIp {\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    droplet: ").append(toIndentedString(droplet)).append("\n");
        sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
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
