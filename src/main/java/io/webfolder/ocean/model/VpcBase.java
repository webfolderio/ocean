package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * VpcBase
 */
@JsonPropertyOrder({ VpcBase.JSON_PROPERTY_ID, VpcBase.JSON_PROPERTY_URN, VpcBase.JSON_PROPERTY_CREATED_AT })
public class VpcBase {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_URN = "urn";
    private String urn;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public VpcBase() {
    }

    @JsonCreator
    public VpcBase(@JsonProperty(JSON_PROPERTY_ID) UUID id,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt) {
        this();
        this.id = id;
        this.createdAt = createdAt;
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

    public VpcBase urn(String urn) {
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
     * Return true if this vpc_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VpcBase vpcBase = (VpcBase) o;
        return Objects.equals(this.id, vpcBase.id) && Objects.equals(this.urn, vpcBase.urn)
                && Objects.equals(this.createdAt, vpcBase.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, urn, createdAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class VpcBase {\n");
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