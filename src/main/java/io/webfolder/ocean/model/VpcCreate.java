package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * VpcCreate
 */
@JsonPropertyOrder({ VpcCreate.JSON_PROPERTY_REGION, VpcCreate.JSON_PROPERTY_IP_RANGE })
public class VpcCreate {
    public static final String JSON_PROPERTY_REGION = "region";
    private String region;

    public static final String JSON_PROPERTY_IP_RANGE = "ip_range";
    private String ipRange;

    public VpcCreate() {
    }

    public VpcCreate region(String region) {
        this.region = region;
        return this;
    }

    /**
     * The slug identifier for the region where the VPC will be created.
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(String region) {
        this.region = region;
    }

    public VpcCreate ipRange(String ipRange) {
        this.ipRange = ipRange;
        return this;
    }

    /**
     * The range of IP addresses in the VPC in CIDR notation. Network ranges cannot
     * overlap with other networks in the same account and must be in range of
     * private addresses as defined in RFC1918. It may not be smaller than
     * &#x60;/28&#x60; nor larger than &#x60;/16&#x60;. If no IP range is specified,
     * a &#x60;/20&#x60; network range is generated that won&#39;t conflict with
     * other VPC networks in your account.
     *
     * @return ipRange
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IP_RANGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIpRange() {
        return ipRange;
    }

    @JsonProperty(JSON_PROPERTY_IP_RANGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIpRange(String ipRange) {
        this.ipRange = ipRange;
    }

    /**
     * Return true if this vpc_create object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VpcCreate vpcCreate = (VpcCreate) o;
        return Objects.equals(this.region, vpcCreate.region) && Objects.equals(this.ipRange, vpcCreate.ipRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, ipRange);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VpcCreate {\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    ipRange: ").append(toIndentedString(ipRange)).append("\n");
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
