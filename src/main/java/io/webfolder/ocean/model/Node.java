package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Node
 */
@JsonPropertyOrder({ Node.JSON_PROPERTY_ID, Node.JSON_PROPERTY_NAME, Node.JSON_PROPERTY_STATUS,
        Node.JSON_PROPERTY_DROPLET_ID, Node.JSON_PROPERTY_CREATED_AT, Node.JSON_PROPERTY_UPDATED_AT })
public class Node {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_STATUS = "status";
    private NodeStatus status;

    public static final String JSON_PROPERTY_DROPLET_ID = "droplet_id";
    private String dropletId;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private OffsetDateTime updatedAt;

    public Node() {
    }

    public Node id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * A unique ID that can be used to identify and reference the node.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public UUID getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(UUID id) {
        this.id = id;
    }

    public Node name(String name) {
        this.name = name;
        return this;
    }

    /**
     * An automatically generated, human-readable name for the node.
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

    public Node status(NodeStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public NodeStatus getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStatus(NodeStatus status) {
        this.status = status;
    }

    public Node dropletId(String dropletId) {
        this.dropletId = dropletId;
        return this;
    }

    /**
     * The ID of the Droplet used for the worker node.
     *
     * @return dropletId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DROPLET_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDropletId() {
        return dropletId;
    }

    @JsonProperty(JSON_PROPERTY_DROPLET_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDropletId(String dropletId) {
        this.dropletId = dropletId;
    }

    public Node createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the node was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Node updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the node was last updated.
     *
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Return true if this node object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equals(this.id, node.id) && Objects.equals(this.name, node.name)
                && Objects.equals(this.status, node.status) && Objects.equals(this.dropletId, node.dropletId)
                && Objects.equals(this.createdAt, node.createdAt) && Objects.equals(this.updatedAt, node.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, dropletId, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Node {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    dropletId: ").append(toIndentedString(dropletId)).append("\n");
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