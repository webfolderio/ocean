package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * FloatingIp
 */
@JsonPropertyOrder({ FloatingIp.JSON_PROPERTY_IP, FloatingIp.JSON_PROPERTY_REGION, FloatingIp.JSON_PROPERTY_DROPLET,
        FloatingIp.JSON_PROPERTY_LOCKED })
public class FloatingIp {
    public static final String JSON_PROPERTY_IP = "ip";
    private String ip;

    public static final String JSON_PROPERTY_REGION = "region";
    private FloatingIpRegion region;

    public static final String JSON_PROPERTY_DROPLET = "droplet";
    private FloatingIpDroplet droplet;

    public static final String JSON_PROPERTY_LOCKED = "locked";
    private Boolean locked;

    public FloatingIp() {
    }

    public FloatingIp ip(String ip) {
        this.ip = ip;
        return this;
    }

    /**
     * The public IP address of the floating IP. It also serves as its identifier.
     *
     * @return ip
     **/
    @javax.annotation.Nullable
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

    public FloatingIp region(FloatingIpRegion region) {
        this.region = region;
        return this;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public FloatingIpRegion getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(FloatingIpRegion region) {
        this.region = region;
    }

    public FloatingIp droplet(FloatingIpDroplet droplet) {
        this.droplet = droplet;
        return this;
    }

    /**
     * Get droplet
     *
     * @return droplet
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DROPLET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public FloatingIpDroplet getDroplet() {
        return droplet;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDroplet(FloatingIpDroplet droplet) {
        this.droplet = droplet;
    }

    public FloatingIp locked(Boolean locked) {
        this.locked = locked;
        return this;
    }

    /**
     * A boolean value indicating whether or not the floating IP has pending actions
     * preventing new ones from being submitted.
     *
     * @return locked
     **/
    @javax.annotation.Nullable
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
     * Return true if this floating_ip object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FloatingIp floatingIp = (FloatingIp) o;
        return Objects.equals(this.ip, floatingIp.ip) && Objects.equals(this.region, floatingIp.region)
                && Objects.equals(this.droplet, floatingIp.droplet) && Objects.equals(this.locked, floatingIp.locked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, region, droplet, locked);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FloatingIp {\n");
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