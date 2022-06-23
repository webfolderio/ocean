package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Resource
 */
@JsonPropertyOrder({ Resource.JSON_PROPERTY_URN, Resource.JSON_PROPERTY_ASSIGNED_AT, Resource.JSON_PROPERTY_LINKS,
        Resource.JSON_PROPERTY_STATUS })
public class Resource {
    public static final String JSON_PROPERTY_URN = "urn";
    private String urn;

    public static final String JSON_PROPERTY_ASSIGNED_AT = "assigned_at";
    private OffsetDateTime assignedAt;

    public static final String JSON_PROPERTY_LINKS = "links";
    private ResourceLinks links;

    /**
     * The status of assigning and fetching the resources.
     */
    public enum StatusEnum {
        OK("ok"),

        NOT_FOUND("not_found"),

        ASSIGNED("assigned"),

        ALREADY_ASSIGNED("already_assigned"),

        SERVICE_DOWN("service_down");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_STATUS = "status";
    private StatusEnum status;

    public Resource() {
    }

    public Resource urn(String urn) {
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

    public Resource assignedAt(OffsetDateTime assignedAt) {
        this.assignedAt = assignedAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the project was created.
     *
     * @return assignedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ASSIGNED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public OffsetDateTime getAssignedAt() {
        return assignedAt;
    }

    @JsonProperty(JSON_PROPERTY_ASSIGNED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAssignedAt(OffsetDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public Resource links(ResourceLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public ResourceLinks getLinks() {
        return links;
    }

    @JsonProperty(JSON_PROPERTY_LINKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLinks(ResourceLinks links) {
        this.links = links;
    }

    public Resource status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * The status of assigning and fetching the resources.
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StatusEnum getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    /**
     * Return true if this resource object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Resource resource = (Resource) o;
        return Objects.equals(this.urn, resource.urn) && Objects.equals(this.assignedAt, resource.assignedAt)
                && Objects.equals(this.links, resource.links) && Objects.equals(this.status, resource.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urn, assignedAt, links, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Resource {\n");
        sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
        sb.append("    assignedAt: ").append(toIndentedString(assignedAt)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
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