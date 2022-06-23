package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Vpc
 */
@JsonPropertyOrder({ Vpc.JSON_PROPERTY_NAME, Vpc.JSON_PROPERTY_DESCRIPTION, Vpc.JSON_PROPERTY_REGION,
        Vpc.JSON_PROPERTY_IP_RANGE, Vpc.JSON_PROPERTY_DEFAULT, Vpc.JSON_PROPERTY_ID, Vpc.JSON_PROPERTY_URN,
        Vpc.JSON_PROPERTY_CREATED_AT })
public class Vpc {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_REGION = "region";
    private String region;

    public static final String JSON_PROPERTY_IP_RANGE = "ip_range";
    private String ipRange;

    public static final String JSON_PROPERTY_DEFAULT = "default";
    private Boolean _default;

    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_URN = "urn";
    private String urn;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public Vpc() {
    }

    @JsonCreator
    public Vpc(@JsonProperty(JSON_PROPERTY_ID) UUID id,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt) {
        this();
        this.id = id;
        this.createdAt = createdAt;
    }

    public Vpc name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the VPC. Must be unique and may only contain alphanumeric
     * characters, dashes, and periods.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public Vpc description(String description) {
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

    public Vpc region(String region) {
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

    public Vpc ipRange(String ipRange) {
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

    public Vpc _default(Boolean _default) {
        this._default = _default;
        return this;
    }

    /**
     * A boolean value indicating whether or not the VPC is the default network for
     * the region. All applicable resources are placed into the default VPC network
     * unless otherwise specified during their creation. The &#x60;default&#x60;
     * field cannot be unset from &#x60;true&#x60;. If you want to set a new default
     * VPC network, update the &#x60;default&#x60; field of another VPC network in
     * the same region. The previous network&#39;s &#x60;default&#x60; field will be
     * set to &#x60;false&#x60; when a new default VPC has been defined.
     *
     * @return _default
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getDefault() {
        return _default;
    }

    @JsonProperty(JSON_PROPERTY_DEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDefault(Boolean _default) {
        this._default = _default;
    }

    /**
     * A unique ID that can be used to identify and reference the VPC.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getId() {
        return id;
    }

    public Vpc urn(String urn) {
        this.urn = urn;
        return this;
    }

    /**
     * The uniform resource name (URN) for the resource in the format
     * do:resource_type:resource_id.
     *
     * @return urn
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_URN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUrn() {
        return urn;
    }

    @JsonProperty(JSON_PROPERTY_URN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUrn(String urn) {
        this.urn = urn;
    }

    /**
     * A time value given in ISO8601 combined date and time format.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Return true if this vpc object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vpc vpc = (Vpc) o;
        return Objects.equals(this.name, vpc.name) && Objects.equals(this.description, vpc.description)
                && Objects.equals(this.region, vpc.region) && Objects.equals(this.ipRange, vpc.ipRange)
                && Objects.equals(this._default, vpc._default) && Objects.equals(this.id, vpc.id)
                && Objects.equals(this.urn, vpc.urn) && Objects.equals(this.createdAt, vpc.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, region, ipRange, _default, id, urn, createdAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Vpc {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    ipRange: ").append(toIndentedString(ipRange)).append("\n");
        sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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