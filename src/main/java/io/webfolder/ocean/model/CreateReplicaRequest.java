package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * CreateReplicaRequest
 */
@JsonPropertyOrder({ CreateReplicaRequest.JSON_PROPERTY_NAME, CreateReplicaRequest.JSON_PROPERTY_REGION,
        CreateReplicaRequest.JSON_PROPERTY_SIZE, CreateReplicaRequest.JSON_PROPERTY_STATUS,
        CreateReplicaRequest.JSON_PROPERTY_TAGS, CreateReplicaRequest.JSON_PROPERTY_CREATED_AT,
        CreateReplicaRequest.JSON_PROPERTY_PRIVATE_NETWORK_UUID, CreateReplicaRequest.JSON_PROPERTY_CONNECTION,
        CreateReplicaRequest.JSON_PROPERTY_PRIVATE_CONNECTION })
public class CreateReplicaRequest {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_REGION = "region";
    private String region;

    public static final String JSON_PROPERTY_SIZE = "size";
    private String size;

    /**
     * A string representing the current status of the database cluster.
     */
    public enum StatusEnum {
        CREATING("creating"),

        ONLINE("online"),

        RESIZING("resizing"),

        MIGRATING("migrating"),

        FORKING("forking");

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

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_PRIVATE_NETWORK_UUID = "private_network_uuid";
    private String privateNetworkUuid;

    public static final String JSON_PROPERTY_CONNECTION = "connection";
    private DatabaseReplicaConnection connection;

    public static final String JSON_PROPERTY_PRIVATE_CONNECTION = "private_connection";
    private DatabaseReplicaConnection privateConnection;

    public CreateReplicaRequest() {
    }

    @JsonCreator
    public CreateReplicaRequest(@JsonProperty(JSON_PROPERTY_STATUS) StatusEnum status,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt) {
        this();
        this.status = status;
        this.createdAt = createdAt;
    }

    public CreateReplicaRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name to give the read-only replicating
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

    public CreateReplicaRequest region(String region) {
        this.region = region;
        return this;
    }

    /**
     * A slug identifier for the region where the read-only replica will be located.
     * If excluded, the replica will be placed in the same region as the cluster.
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

    public CreateReplicaRequest size(String size) {
        this.size = size;
        return this;
    }

    /**
     * A slug identifier representing the size of the node for the read-only
     * replica. The size of the replica must be at least as large as the node size
     * for the database cluster from which it is replicating.
     *
     * @return size
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getSize() {
        return size;
    }

    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * A string representing the current status of the database cluster.
     *
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public StatusEnum getStatus() {
        return status;
    }

    public CreateReplicaRequest tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public CreateReplicaRequest addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * A flat array of tag names as strings to apply to the read-only replica after
     * it is created. Tag names can either be existing or new tags.
     *
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getTags() {
        return tags;
    }

    @JsonProperty(JSON_PROPERTY_TAGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the database cluster was created.
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public CreateReplicaRequest privateNetworkUuid(String privateNetworkUuid) {
        this.privateNetworkUuid = privateNetworkUuid;
        return this;
    }

    /**
     * A string specifying the UUID of the VPC to which the read-only replica will
     * be assigned. If excluded, the replica will be assigned to your account&#39;s
     * default VPC for the region.
     *
     * @return privateNetworkUuid
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRIVATE_NETWORK_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPrivateNetworkUuid() {
        return privateNetworkUuid;
    }

    @JsonProperty(JSON_PROPERTY_PRIVATE_NETWORK_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPrivateNetworkUuid(String privateNetworkUuid) {
        this.privateNetworkUuid = privateNetworkUuid;
    }

    public CreateReplicaRequest connection(DatabaseReplicaConnection connection) {
        this.connection = connection;
        return this;
    }

    /**
     * Get connection
     *
     * @return connection
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONNECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DatabaseReplicaConnection getConnection() {
        return connection;
    }

    @JsonProperty(JSON_PROPERTY_CONNECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConnection(DatabaseReplicaConnection connection) {
        this.connection = connection;
    }

    public CreateReplicaRequest privateConnection(DatabaseReplicaConnection privateConnection) {
        this.privateConnection = privateConnection;
        return this;
    }

    /**
     * Get privateConnection
     *
     * @return privateConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRIVATE_CONNECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DatabaseReplicaConnection getPrivateConnection() {
        return privateConnection;
    }

    @JsonProperty(JSON_PROPERTY_PRIVATE_CONNECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPrivateConnection(DatabaseReplicaConnection privateConnection) {
        this.privateConnection = privateConnection;
    }

    /**
     * Return true if this create_replica_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateReplicaRequest createReplicaRequest = (CreateReplicaRequest) o;
        return Objects.equals(this.name, createReplicaRequest.name)
                && Objects.equals(this.region, createReplicaRequest.region)
                && Objects.equals(this.size, createReplicaRequest.size)
                && Objects.equals(this.status, createReplicaRequest.status)
                && Objects.equals(this.tags, createReplicaRequest.tags)
                && Objects.equals(this.createdAt, createReplicaRequest.createdAt)
                && Objects.equals(this.privateNetworkUuid, createReplicaRequest.privateNetworkUuid)
                && Objects.equals(this.connection, createReplicaRequest.connection)
                && Objects.equals(this.privateConnection, createReplicaRequest.privateConnection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, size, status, tags, createdAt, privateNetworkUuid, connection,
                privateConnection);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateReplicaRequest {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    privateNetworkUuid: ").append(toIndentedString(privateNetworkUuid)).append("\n");
        sb.append("    connection: ").append(toIndentedString(connection)).append("\n");
        sb.append("    privateConnection: ").append(toIndentedString(privateConnection)).append("\n");
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