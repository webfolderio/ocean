package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DatabaseReplicaConnection
 */
@JsonPropertyOrder({ DatabaseReplicaConnection.JSON_PROPERTY_URI, DatabaseReplicaConnection.JSON_PROPERTY_DATABASE,
        DatabaseReplicaConnection.JSON_PROPERTY_HOST, DatabaseReplicaConnection.JSON_PROPERTY_PORT,
        DatabaseReplicaConnection.JSON_PROPERTY_USER, DatabaseReplicaConnection.JSON_PROPERTY_PASSWORD,
        DatabaseReplicaConnection.JSON_PROPERTY_SSL })
public class DatabaseReplicaConnection {
    public static final String JSON_PROPERTY_URI = "uri";
    private String uri;

    public static final String JSON_PROPERTY_DATABASE = "database";
    private String database;

    public static final String JSON_PROPERTY_HOST = "host";
    private String host;

    public static final String JSON_PROPERTY_PORT = "port";
    private Integer port;

    public static final String JSON_PROPERTY_USER = "user";
    private String user;

    public static final String JSON_PROPERTY_PASSWORD = "password";
    private String password;

    public static final String JSON_PROPERTY_SSL = "ssl";
    private Boolean ssl;

    public DatabaseReplicaConnection() {
    }

    @JsonCreator
    public DatabaseReplicaConnection(@JsonProperty(JSON_PROPERTY_URI) String uri,
            @JsonProperty(JSON_PROPERTY_DATABASE) String database, @JsonProperty(JSON_PROPERTY_HOST) String host,
            @JsonProperty(JSON_PROPERTY_PORT) Integer port, @JsonProperty(JSON_PROPERTY_USER) String user,
            @JsonProperty(JSON_PROPERTY_PASSWORD) String password, @JsonProperty(JSON_PROPERTY_SSL) Boolean ssl) {
        this();
        this.uri = uri;
        this.database = database;
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.ssl = ssl;
    }

    /**
     * A connection string in the format accepted by the &#x60;psql&#x60; command.
     * This is provided as a convenience and should be able to be constructed by the
     * other attributes.
     *
     * @return uri
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_URI)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getUri() {
        return uri;
    }

    /**
     * The name of the default database.
     *
     * @return database
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DATABASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getDatabase() {
        return database;
    }

    /**
     * The FQDN pointing to the database cluster&#39;s current primary node.
     *
     * @return host
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HOST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getHost() {
        return host;
    }

    /**
     * The port on which the database cluster is listening.
     *
     * @return port
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PORT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getPort() {
        return port;
    }

    /**
     * The default user for the database.
     *
     * @return user
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUser() {
        return user;
    }

    /**
     * The randomly generated password for the default user.
     *
     * @return password
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PASSWORD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPassword() {
        return password;
    }

    /**
     * A boolean value indicating if the connection should be made over SSL.
     *
     * @return ssl
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SSL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getSsl() {
        return ssl;
    }

    /**
     * Return true if this database_replica_connection object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DatabaseReplicaConnection databaseReplicaConnection = (DatabaseReplicaConnection) o;
        return Objects.equals(this.uri, databaseReplicaConnection.uri)
                && Objects.equals(this.database, databaseReplicaConnection.database)
                && Objects.equals(this.host, databaseReplicaConnection.host)
                && Objects.equals(this.port, databaseReplicaConnection.port)
                && Objects.equals(this.user, databaseReplicaConnection.user)
                && Objects.equals(this.password, databaseReplicaConnection.password)
                && Objects.equals(this.ssl, databaseReplicaConnection.ssl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, database, host, port, user, password, ssl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatabaseReplicaConnection {\n");
        sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
        sb.append("    database: ").append(toIndentedString(database)).append("\n");
        sb.append("    host: ").append(toIndentedString(host)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    ssl: ").append(toIndentedString(ssl)).append("\n");
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