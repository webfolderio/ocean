package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ProjectBase
 */
@JsonPropertyOrder({ ProjectBase.JSON_PROPERTY_ID, ProjectBase.JSON_PROPERTY_OWNER_UUID,
        ProjectBase.JSON_PROPERTY_OWNER_ID, ProjectBase.JSON_PROPERTY_NAME, ProjectBase.JSON_PROPERTY_DESCRIPTION,
        ProjectBase.JSON_PROPERTY_PURPOSE, ProjectBase.JSON_PROPERTY_ENVIRONMENT, ProjectBase.JSON_PROPERTY_CREATED_AT,
        ProjectBase.JSON_PROPERTY_UPDATED_AT })
public class ProjectBase {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_OWNER_UUID = "owner_uuid";
    private String ownerUuid;

    public static final String JSON_PROPERTY_OWNER_ID = "owner_id";
    private Integer ownerId;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_PURPOSE = "purpose";
    private String purpose;

    /**
     * The environment of the project&#39;s resources.
     */
    public enum EnvironmentEnum {
        DEVELOPMENT("Development"),

        STAGING("Staging"),

        PRODUCTION("Production");

        private String value;

        EnvironmentEnum(String value) {
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
        public static EnvironmentEnum fromValue(String value) {
            for (EnvironmentEnum b : EnvironmentEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_ENVIRONMENT = "environment";
    private EnvironmentEnum environment;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private OffsetDateTime updatedAt;

    public ProjectBase() {
    }

    @JsonCreator
    public ProjectBase(@JsonProperty(JSON_PROPERTY_ID) UUID id,
            @JsonProperty(JSON_PROPERTY_OWNER_UUID) String ownerUuid,
            @JsonProperty(JSON_PROPERTY_OWNER_ID) Integer ownerId,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt,
            @JsonProperty(JSON_PROPERTY_UPDATED_AT) OffsetDateTime updatedAt) {
        this();
        this.id = id;
        this.ownerUuid = ownerUuid;
        this.ownerId = ownerId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * The unique universal identifier of this project.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getId() {
        return id;
    }

    /**
     * The unique universal identifier of the project owner.
     *
     * @return ownerUuid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OWNER_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getOwnerUuid() {
        return ownerUuid;
    }

    /**
     * The integer id of the project owner.
     *
     * @return ownerId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OWNER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getOwnerId() {
        return ownerId;
    }

    public ProjectBase name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The human-readable name for the project. The maximum length is 175 characters
     * and the name must be unique.
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

    public ProjectBase description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the project. The maximum length is 255 characters.
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

    public ProjectBase purpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    /**
     * The purpose of the project. The maximum length is 255 characters. It can have
     * one of the following values: - Just trying out DigitalOcean - Class project /
     * Educational purposes - Website or blog - Web Application - Service or API -
     * Mobile Application - Machine learning / AI / Data processing - IoT -
     * Operational / Developer tooling If another value for purpose is specified,
     * for example, \&quot;your custom purpose\&quot;, your purpose will be stored
     * as &#x60;Other: your custom purpose&#x60;.
     *
     * @return purpose
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PURPOSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPurpose() {
        return purpose;
    }

    @JsonProperty(JSON_PROPERTY_PURPOSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public ProjectBase environment(EnvironmentEnum environment) {
        this.environment = environment;
        return this;
    }

    /**
     * The environment of the project&#39;s resources.
     *
     * @return environment
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENVIRONMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public EnvironmentEnum getEnvironment() {
        return environment;
    }

    @JsonProperty(JSON_PROPERTY_ENVIRONMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEnvironment(EnvironmentEnum environment) {
        this.environment = environment;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the project was created.
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
     * A time value given in ISO8601 combined date and time format that represents
     * when the project was updated.
     *
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Return true if this project_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectBase projectBase = (ProjectBase) o;
        return Objects.equals(this.id, projectBase.id) && Objects.equals(this.ownerUuid, projectBase.ownerUuid)
                && Objects.equals(this.ownerId, projectBase.ownerId) && Objects.equals(this.name, projectBase.name)
                && Objects.equals(this.description, projectBase.description)
                && Objects.equals(this.purpose, projectBase.purpose)
                && Objects.equals(this.environment, projectBase.environment)
                && Objects.equals(this.createdAt, projectBase.createdAt)
                && Objects.equals(this.updatedAt, projectBase.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerUuid, ownerId, name, description, purpose, environment, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectBase {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    ownerUuid: ").append(toIndentedString(ownerUuid)).append("\n");
        sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
        sb.append("    environment: ").append(toIndentedString(environment)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
