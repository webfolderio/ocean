package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateVpcRequest
 */
@JsonPropertyOrder({ CreateVpcRequest.JSON_PROPERTY_NAME, CreateVpcRequest.JSON_PROPERTY_DESCRIPTION,
        CreateVpcRequest.JSON_PROPERTY_REGION, CreateVpcRequest.JSON_PROPERTY_IP_RANGE })
public class CreateVpcRequest {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_REGION = "region";
    private String region;

    public static final String JSON_PROPERTY_IP_RANGE = "ip_range";
    private String ipRange;

    public CreateVpcRequest() {
    }

    public CreateVpcRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the VPC. Must be unique and may only contain alphanumeric
     * characters, dashes, and periods.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }

    public CreateVpcRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free-form text field for describing the VPC&#39;s purpose. It may be a
     * maximum of 255 characters.
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    public CreateVpcRequest region(String region) {
        this.region = region;
        return this;
    }

    /**
     * The slug identifier for the region where the VPC will be created.
     *
     * @return region
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRegion(String region) {
        this.region = region;
    }

    public CreateVpcRequest ipRange(String ipRange) {
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
     * Return true if this create_vpc_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateVpcRequest createVpcRequest = (CreateVpcRequest) o;
        return Objects.equals(this.name, createVpcRequest.name)
                && Objects.equals(this.description, createVpcRequest.description)
                && Objects.equals(this.region, createVpcRequest.region)
                && Objects.equals(this.ipRange, createVpcRequest.ipRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, region, ipRange);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateVpcRequest {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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