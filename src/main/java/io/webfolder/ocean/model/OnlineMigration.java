package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * OnlineMigration
 */
@JsonPropertyOrder({ OnlineMigration.JSON_PROPERTY_ID, OnlineMigration.JSON_PROPERTY_STATUS,
        OnlineMigration.JSON_PROPERTY_CREATED_AT })
public class OnlineMigration {
    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_STATUS = "status";
    private String status;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private String createdAt;

    public OnlineMigration() {
    }

    public OnlineMigration id(String id) {
        this.id = id;
        return this;
    }

    /**
     * The ID of the currently running migration.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "77b28fc8-19ff-11eb-8c9c-c68e24557488", value = "The ID of the currently running migration.")
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(String id) {
        this.id = id;
    }

    public OnlineMigration status(String status) {
        this.status = status;
        return this;
    }

    /**
     * The current status of the migration.
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "running", value = "The current status of the migration.")
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStatus(String status) {
        this.status = status;
    }

    public OnlineMigration createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The time the migration was initiated, in ISO 8601 format.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2020-10-29T15:57:38Z", value = "The time the migration was initiated, in ISO 8601 format.")
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
     * Return true if this online_migration object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OnlineMigration onlineMigration = (OnlineMigration) o;
        return Objects.equals(this.id, onlineMigration.id) && Objects.equals(this.status, onlineMigration.status)
                && Objects.equals(this.createdAt, onlineMigration.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, createdAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OnlineMigration {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
