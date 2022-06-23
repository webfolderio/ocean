package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * VpcMember
 */
@JsonPropertyOrder({ VpcMember.JSON_PROPERTY_NAME, VpcMember.JSON_PROPERTY_URN, VpcMember.JSON_PROPERTY_CREATED_AT })
public class VpcMember {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_URN = "urn";
    private String urn;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private String createdAt;

    public VpcMember() {
    }

    public VpcMember name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the resource.
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

    public VpcMember urn(String urn) {
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

    public VpcMember createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the resource was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Return true if this vpc_member object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VpcMember vpcMember = (VpcMember) o;
        return Objects.equals(this.name, vpcMember.name) && Objects.equals(this.urn, vpcMember.urn)
                && Objects.equals(this.createdAt, vpcMember.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, urn, createdAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VpcMember {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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