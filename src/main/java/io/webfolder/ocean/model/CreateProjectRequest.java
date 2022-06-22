package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateProjectRequest
 */
@JsonPropertyOrder({ CreateProjectRequest.JSON_PROPERTY_ID, CreateProjectRequest.JSON_PROPERTY_OWNER_UUID,
        CreateProjectRequest.JSON_PROPERTY_OWNER_ID, CreateProjectRequest.JSON_PROPERTY_NAME,
        CreateProjectRequest.JSON_PROPERTY_DESCRIPTION, CreateProjectRequest.JSON_PROPERTY_PURPOSE,
        CreateProjectRequest.JSON_PROPERTY_ENVIRONMENT, CreateProjectRequest.JSON_PROPERTY_CREATED_AT,
        CreateProjectRequest.JSON_PROPERTY_UPDATED_AT })
public class CreateProjectRequest {
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

    public CreateProjectRequest() {
    }

    @JsonCreator
    public CreateProjectRequest(@JsonProperty(JSON_PROPERTY_ID) UUID id,
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
    @ApiModelProperty(example = "4e1bfbc3-dc3e-41f2-a18f-1b4d7ba71679", value = "The unique universal identifier of this project.")
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
    @ApiModelProperty(example = "99525febec065ca37b2ffe4f852fd2b2581895e7", value = "The unique universal identifier of the project owner.")
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
    @ApiModelProperty(example = "258992", value = "The integer id of the project owner.")
    @JsonProperty(JSON_PROPERTY_OWNER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getOwnerId() {
        return ownerId;
    }

    public CreateProjectRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The human-readable name for the project. The maximum length is 175 characters
     * and the name must be unique.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "my-web-api", required = true, value = "The human-readable name for the project. The maximum length is 175 characters and the name must be unique.")
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

    public CreateProjectRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the project. The maximum length is 255 characters.
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "My website API", value = "The description of the project. The maximum length is 255 characters.")
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

    public CreateProjectRequest purpose(String purpose) {
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
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "Service or API", required = true, value = "The purpose of the project. The maximum length is 255 characters. It can have one of the following values:  - Just trying out DigitalOcean - Class project / Educational purposes - Website or blog - Web Application - Service or API - Mobile Application - Machine learning / AI / Data processing - IoT - Operational / Developer tooling  If another value for purpose is specified, for example, \"your custom purpose\", your purpose will be stored as `Other: your custom purpose`. ")
    @JsonProperty(JSON_PROPERTY_PURPOSE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getPurpose() {
        return purpose;
    }

    @JsonProperty(JSON_PROPERTY_PURPOSE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public CreateProjectRequest environment(EnvironmentEnum environment) {
        this.environment = environment;
        return this;
    }

    /**
     * The environment of the project&#39;s resources.
     *
     * @return environment
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "Production", value = "The environment of the project's resources.")
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
    @ApiModelProperty(example = "2018-09-27T20:10:35Z", value = "A time value given in ISO8601 combined date and time format that represents when the project was created.")
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
    @ApiModelProperty(example = "2018-09-27T20:10:35Z", value = "A time value given in ISO8601 combined date and time format that represents when the project was updated.")
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Return true if this create_project_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateProjectRequest createProjectRequest = (CreateProjectRequest) o;
        return Objects.equals(this.id, createProjectRequest.id)
                && Objects.equals(this.ownerUuid, createProjectRequest.ownerUuid)
                && Objects.equals(this.ownerId, createProjectRequest.ownerId)
                && Objects.equals(this.name, createProjectRequest.name)
                && Objects.equals(this.description, createProjectRequest.description)
                && Objects.equals(this.purpose, createProjectRequest.purpose)
                && Objects.equals(this.environment, createProjectRequest.environment)
                && Objects.equals(this.createdAt, createProjectRequest.createdAt)
                && Objects.equals(this.updatedAt, createProjectRequest.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerUuid, ownerId, name, description, purpose, environment, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateProjectRequest {\n");
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
