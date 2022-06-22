package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * SourceDatabaseSource
 */
@JsonPropertyOrder({ SourceDatabaseSource.JSON_PROPERTY_URI, SourceDatabaseSource.JSON_PROPERTY_DATABASE,
        SourceDatabaseSource.JSON_PROPERTY_HOST, SourceDatabaseSource.JSON_PROPERTY_PORT,
        SourceDatabaseSource.JSON_PROPERTY_USER, SourceDatabaseSource.JSON_PROPERTY_PASSWORD,
        SourceDatabaseSource.JSON_PROPERTY_SSL })
public class SourceDatabaseSource {
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

    public SourceDatabaseSource() {
    }

    @JsonCreator
    public SourceDatabaseSource(@JsonProperty(JSON_PROPERTY_URI) String uri,
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
    @ApiModelProperty(example = "postgres://doadmin:wv78n3zpz42xezdk@backend-do-user-19081923-0.db.ondigitalocean.com:25060/defaultdb?sslmode=require", value = "A connection string in the format accepted by the `psql` command. This is provided as a convenience and should be able to be constructed by the other attributes.")
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
    @ApiModelProperty(example = "defaultdb", value = "The name of the default database.")
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
    @ApiModelProperty(example = "backend-do-user-19081923-0.db.ondigitalocean.com", value = "The FQDN pointing to the database cluster's current primary node.")
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
    @ApiModelProperty(example = "25060", value = "The port on which the database cluster is listening.")
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
    @ApiModelProperty(example = "doadmin", value = "The default user for the database.")
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
    @ApiModelProperty(example = "wv78n3zpz42xezdk", value = "The randomly generated password for the default user.")
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
    @ApiModelProperty(example = "true", value = "A boolean value indicating if the connection should be made over SSL.")
    @JsonProperty(JSON_PROPERTY_SSL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getSsl() {
        return ssl;
    }

    /**
     * Return true if this source_database_source object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SourceDatabaseSource sourceDatabaseSource = (SourceDatabaseSource) o;
        return Objects.equals(this.uri, sourceDatabaseSource.uri)
                && Objects.equals(this.database, sourceDatabaseSource.database)
                && Objects.equals(this.host, sourceDatabaseSource.host)
                && Objects.equals(this.port, sourceDatabaseSource.port)
                && Objects.equals(this.user, sourceDatabaseSource.user)
                && Objects.equals(this.password, sourceDatabaseSource.password)
                && Objects.equals(this.ssl, sourceDatabaseSource.ssl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, database, host, port, user, password, ssl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SourceDatabaseSource {\n");
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