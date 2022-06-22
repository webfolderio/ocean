package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ConnectionPool
 */
@JsonPropertyOrder({ ConnectionPool.JSON_PROPERTY_NAME, ConnectionPool.JSON_PROPERTY_MODE,
        ConnectionPool.JSON_PROPERTY_SIZE, ConnectionPool.JSON_PROPERTY_DB, ConnectionPool.JSON_PROPERTY_USER,
        ConnectionPool.JSON_PROPERTY_CONNECTION, ConnectionPool.JSON_PROPERTY_PRIVATE_CONNECTION })
public class ConnectionPool {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_MODE = "mode";
    private String mode;

    public static final String JSON_PROPERTY_SIZE = "size";
    private Integer size;

    public static final String JSON_PROPERTY_DB = "db";
    private String db;

    public static final String JSON_PROPERTY_USER = "user";
    private String user;

    public static final String JSON_PROPERTY_CONNECTION = "connection";
    private DatabaseClusterConnection connection;

    public static final String JSON_PROPERTY_PRIVATE_CONNECTION = "private_connection";
    private DatabaseClusterConnection privateConnection;

    public ConnectionPool() {
    }

    public ConnectionPool name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A unique name for the connection pool. Must be between 3 and 60 characters.
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

    public ConnectionPool mode(String mode) {
        this.mode = mode;
        return this;
    }

    /**
     * The PGBouncer transaction mode for the connection pool. The allowed values
     * are session, transaction, and statement.
     *
     * @return mode
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_MODE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getMode() {
        return mode;
    }

    @JsonProperty(JSON_PROPERTY_MODE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMode(String mode) {
        this.mode = mode;
    }

    public ConnectionPool size(Integer size) {
        this.size = size;
        return this;
    }

    /**
     * The desired size of the PGBouncer connection pool. The maximum allowed size
     * is determined by the size of the cluster&#39;s primary node. 25 backend
     * server connections are allowed for every 1GB of RAM. Three are reserved for
     * maintenance. For example, a primary node with 1 GB of RAM allows for a
     * maximum of 22 backend server connections while one with 4 GB would allow for
     * 97. Note that these are shared across all connection pools in a cluster.
     *
     * @return size
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getSize() {
        return size;
    }

    @JsonProperty(JSON_PROPERTY_SIZE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSize(Integer size) {
        this.size = size;
    }

    public ConnectionPool db(String db) {
        this.db = db;
        return this;
    }

    /**
     * The database for use with the connection pool.
     *
     * @return db
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DB)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDb() {
        return db;
    }

    @JsonProperty(JSON_PROPERTY_DB)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDb(String db) {
        this.db = db;
    }

    public ConnectionPool user(String user) {
        this.user = user;
        return this;
    }

    /**
     * The name of the user for use with the connection pool.
     *
     * @return user
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_USER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getUser() {
        return user;
    }

    @JsonProperty(JSON_PROPERTY_USER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setUser(String user) {
        this.user = user;
    }

    public ConnectionPool connection(DatabaseClusterConnection connection) {
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

    public ConnectionPool privateConnection(DatabaseClusterConnection privateConnection) {
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
     * Return true if this connection_pool object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectionPool connectionPool = (ConnectionPool) o;
        return Objects.equals(this.name, connectionPool.name) && Objects.equals(this.mode, connectionPool.mode)
                && Objects.equals(this.size, connectionPool.size) && Objects.equals(this.db, connectionPool.db)
                && Objects.equals(this.user, connectionPool.user)
                && Objects.equals(this.connection, connectionPool.connection)
                && Objects.equals(this.privateConnection, connectionPool.privateConnection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mode, size, db, user, connection, privateConnection);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectionPool {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    db: ").append(toIndentedString(db)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
