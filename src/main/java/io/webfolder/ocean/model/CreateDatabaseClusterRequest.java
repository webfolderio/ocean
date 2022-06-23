package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * CreateDatabaseClusterRequest
 */
@JsonPropertyOrder({ CreateDatabaseClusterRequest.JSON_PROPERTY_ID, CreateDatabaseClusterRequest.JSON_PROPERTY_NAME,
        CreateDatabaseClusterRequest.JSON_PROPERTY_ENGINE, CreateDatabaseClusterRequest.JSON_PROPERTY_VERSION,
        CreateDatabaseClusterRequest.JSON_PROPERTY_NUM_NODES, CreateDatabaseClusterRequest.JSON_PROPERTY_SIZE,
        CreateDatabaseClusterRequest.JSON_PROPERTY_REGION, CreateDatabaseClusterRequest.JSON_PROPERTY_STATUS,
        CreateDatabaseClusterRequest.JSON_PROPERTY_CREATED_AT,
        CreateDatabaseClusterRequest.JSON_PROPERTY_PRIVATE_NETWORK_UUID,
        CreateDatabaseClusterRequest.JSON_PROPERTY_TAGS, CreateDatabaseClusterRequest.JSON_PROPERTY_DB_NAMES,
        CreateDatabaseClusterRequest.JSON_PROPERTY_CONNECTION,
        CreateDatabaseClusterRequest.JSON_PROPERTY_PRIVATE_CONNECTION, CreateDatabaseClusterRequest.JSON_PROPERTY_USERS,
        CreateDatabaseClusterRequest.JSON_PROPERTY_MAINTENANCE_WINDOW,
        CreateDatabaseClusterRequest.JSON_PROPERTY_PROJECT_ID,
        CreateDatabaseClusterRequest.JSON_PROPERTY_BACKUP_RESTORE })
public class CreateDatabaseClusterRequest {
    public static final String JSON_PROPERTY_ID = "id";
    private UUID id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    /**
     * A slug representing the database engine used for the cluster. The possible
     * values are: \&quot;pg\&quot; for PostgreSQL, \&quot;mysql\&quot; for MySQL,
     * \&quot;redis\&quot; for Redis, and \&quot;mongodb\&quot; for MongoDB.
     */
    public enum EngineEnum {
        PG("pg"),

        MYSQL("mysql"),

        REDIS("redis"),

        MONGODB("mongodb");

        private String value;

        EngineEnum(String value) {
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
        public static EngineEnum fromValue(String value) {
            for (EngineEnum b : EngineEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_ENGINE = "engine";
    private EngineEnum engine;

    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    public static final String JSON_PROPERTY_NUM_NODES = "num_nodes";
    private Integer numNodes;

    public static final String JSON_PROPERTY_SIZE = "size";
    private String size;

    public static final String JSON_PROPERTY_REGION = "region";
    private String region;

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

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_PRIVATE_NETWORK_UUID = "private_network_uuid";
    private String privateNetworkUuid;

    public static final String JSON_PROPERTY_TAGS = "tags";
    private List<String> tags = null;

    public static final String JSON_PROPERTY_DB_NAMES = "db_names";
    private List<String> dbNames = null;

    public static final String JSON_PROPERTY_CONNECTION = "connection";
    private DatabaseClusterConnection connection;

    public static final String JSON_PROPERTY_PRIVATE_CONNECTION = "private_connection";
    private DatabaseClusterConnection privateConnection;

    public static final String JSON_PROPERTY_USERS = "users";
    private List<DatabaseUser> users = null;

    public static final String JSON_PROPERTY_MAINTENANCE_WINDOW = "maintenance_window";
    private DatabaseClusterMaintenanceWindow maintenanceWindow;

    public static final String JSON_PROPERTY_PROJECT_ID = "project_id";
    private UUID projectId;

    public static final String JSON_PROPERTY_BACKUP_RESTORE = "backup_restore";
    private DatabaseBackup backupRestore;

    public CreateDatabaseClusterRequest() {
    }

    @JsonCreator
    public CreateDatabaseClusterRequest(@JsonProperty(JSON_PROPERTY_ID) UUID id,
            @JsonProperty(JSON_PROPERTY_STATUS) StatusEnum status,
            @JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt,
            @JsonProperty(JSON_PROPERTY_DB_NAMES) List<String> dbNames,
            @JsonProperty(JSON_PROPERTY_USERS) List<DatabaseUser> users) {
        this();
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.dbNames = dbNames;
        this.users = users;
    }

    /**
     * A unique ID that can be used to identify and reference a database cluster.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public UUID getId() {
        return id;
    }

    public CreateDatabaseClusterRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A unique, human-readable name referring to a database cluster.
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

    public CreateDatabaseClusterRequest engine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    /**
     * A slug representing the database engine used for the cluster. The possible
     * values are: \&quot;pg\&quot; for PostgreSQL, \&quot;mysql\&quot; for MySQL,
     * \&quot;redis\&quot; for Redis, and \&quot;mongodb\&quot; for MongoDB.
     *
     * @return engine
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ENGINE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public EngineEnum getEngine() {
        return engine;
    }

    @JsonProperty(JSON_PROPERTY_ENGINE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public CreateDatabaseClusterRequest version(String version) {
        this.version = version;
        return this;
    }

    /**
     * A string representing the version of the database engine in use for the
     * cluster.
     *
     * @return version
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVersion(String version) {
        this.version = version;
    }

    public CreateDatabaseClusterRequest numNodes(Integer numNodes) {
        this.numNodes = numNodes;
        return this;
    }

    /**
     * The number of nodes in the database cluster.
     *
     * @return numNodes
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NUM_NODES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getNumNodes() {
        return numNodes;
    }

    @JsonProperty(JSON_PROPERTY_NUM_NODES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setNumNodes(Integer numNodes) {
        this.numNodes = numNodes;
    }

    public CreateDatabaseClusterRequest size(String size) {
        this.size = size;
        return this;
    }

    /**
     * The slug identifier representing the size of the nodes in the database
     * cluster.
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

    public CreateDatabaseClusterRequest region(String region) {
        this.region = region;
        return this;
    }

    /**
     * The slug identifier for the region where the database cluster is located.
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

    public CreateDatabaseClusterRequest privateNetworkUuid(String privateNetworkUuid) {
        this.privateNetworkUuid = privateNetworkUuid;
        return this;
    }

    /**
     * A string specifying the UUID of the VPC to which the database cluster will be
     * assigned. If excluded, the cluster when creating a new database cluster, it
     * will be assigned to your account&#39;s default VPC for the region.
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

    public CreateDatabaseClusterRequest tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public CreateDatabaseClusterRequest addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * An array of tags that have been applied to the database cluster.
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
     * An array of strings containing the names of databases created in the database
     * cluster.
     *
     * @return dbNames
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DB_NAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getDbNames() {
        return dbNames;
    }

    public CreateDatabaseClusterRequest connection(DatabaseClusterConnection connection) {
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

    public DatabaseClusterConnection getConnection() {
        return connection;
    }

    @JsonProperty(JSON_PROPERTY_CONNECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConnection(DatabaseClusterConnection connection) {
        this.connection = connection;
    }

    public CreateDatabaseClusterRequest privateConnection(DatabaseClusterConnection privateConnection) {
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

    public DatabaseClusterConnection getPrivateConnection() {
        return privateConnection;
    }

    @JsonProperty(JSON_PROPERTY_PRIVATE_CONNECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPrivateConnection(DatabaseClusterConnection privateConnection) {
        this.privateConnection = privateConnection;
    }

    /**
     * Get users
     *
     * @return users
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DatabaseUser> getUsers() {
        return users;
    }

    public CreateDatabaseClusterRequest maintenanceWindow(DatabaseClusterMaintenanceWindow maintenanceWindow) {
        this.maintenanceWindow = maintenanceWindow;
        return this;
    }

    /**
     * Get maintenanceWindow
     *
     * @return maintenanceWindow
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAINTENANCE_WINDOW)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DatabaseClusterMaintenanceWindow getMaintenanceWindow() {
        return maintenanceWindow;
    }

    @JsonProperty(JSON_PROPERTY_MAINTENANCE_WINDOW)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaintenanceWindow(DatabaseClusterMaintenanceWindow maintenanceWindow) {
        this.maintenanceWindow = maintenanceWindow;
    }

    public CreateDatabaseClusterRequest projectId(UUID projectId) {
        this.projectId = projectId;
        return this;
    }

    /**
     * The ID of the project that the database cluster is assigned to. If excluded
     * when creating a new database cluster, it will be assigned to your default
     * project.
     *
     * @return projectId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UUID getProjectId() {
        return projectId;
    }

    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public CreateDatabaseClusterRequest backupRestore(DatabaseBackup backupRestore) {
        this.backupRestore = backupRestore;
        return this;
    }

    /**
     * Get backupRestore
     *
     * @return backupRestore
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BACKUP_RESTORE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DatabaseBackup getBackupRestore() {
        return backupRestore;
    }

    @JsonProperty(JSON_PROPERTY_BACKUP_RESTORE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBackupRestore(DatabaseBackup backupRestore) {
        this.backupRestore = backupRestore;
    }

    /**
     * Return true if this create_database_cluster_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateDatabaseClusterRequest createDatabaseClusterRequest = (CreateDatabaseClusterRequest) o;
        return Objects.equals(this.id, createDatabaseClusterRequest.id)
                && Objects.equals(this.name, createDatabaseClusterRequest.name)
                && Objects.equals(this.engine, createDatabaseClusterRequest.engine)
                && Objects.equals(this.version, createDatabaseClusterRequest.version)
                && Objects.equals(this.numNodes, createDatabaseClusterRequest.numNodes)
                && Objects.equals(this.size, createDatabaseClusterRequest.size)
                && Objects.equals(this.region, createDatabaseClusterRequest.region)
                && Objects.equals(this.status, createDatabaseClusterRequest.status)
                && Objects.equals(this.createdAt, createDatabaseClusterRequest.createdAt)
                && Objects.equals(this.privateNetworkUuid, createDatabaseClusterRequest.privateNetworkUuid)
                && Objects.equals(this.tags, createDatabaseClusterRequest.tags)
                && Objects.equals(this.dbNames, createDatabaseClusterRequest.dbNames)
                && Objects.equals(this.connection, createDatabaseClusterRequest.connection)
                && Objects.equals(this.privateConnection, createDatabaseClusterRequest.privateConnection)
                && Objects.equals(this.users, createDatabaseClusterRequest.users)
                && Objects.equals(this.maintenanceWindow, createDatabaseClusterRequest.maintenanceWindow)
                && Objects.equals(this.projectId, createDatabaseClusterRequest.projectId)
                && Objects.equals(this.backupRestore, createDatabaseClusterRequest.backupRestore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, engine, version, numNodes, size, region, status, createdAt, privateNetworkUuid,
                tags, dbNames, connection, privateConnection, users, maintenanceWindow, projectId, backupRestore);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateDatabaseClusterRequest {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    numNodes: ").append(toIndentedString(numNodes)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    privateNetworkUuid: ").append(toIndentedString(privateNetworkUuid)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    dbNames: ").append(toIndentedString(dbNames)).append("\n");
        sb.append("    connection: ").append(toIndentedString(connection)).append("\n");
        sb.append("    privateConnection: ").append(toIndentedString(privateConnection)).append("\n");
        sb.append("    users: ").append(toIndentedString(users)).append("\n");
        sb.append("    maintenanceWindow: ").append(toIndentedString(maintenanceWindow)).append("\n");
        sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
        sb.append("    backupRestore: ").append(toIndentedString(backupRestore)).append("\n");
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