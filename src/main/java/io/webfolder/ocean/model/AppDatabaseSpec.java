package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AppDatabaseSpec
 */
@JsonPropertyOrder({ AppDatabaseSpec.JSON_PROPERTY_CLUSTER_NAME, AppDatabaseSpec.JSON_PROPERTY_DB_NAME,
        AppDatabaseSpec.JSON_PROPERTY_DB_USER, AppDatabaseSpec.JSON_PROPERTY_ENGINE, AppDatabaseSpec.JSON_PROPERTY_NAME,
        AppDatabaseSpec.JSON_PROPERTY_PRODUCTION, AppDatabaseSpec.JSON_PROPERTY_VERSION })
public class AppDatabaseSpec {
    public static final String JSON_PROPERTY_CLUSTER_NAME = "cluster_name";
    private String clusterName;

    public static final String JSON_PROPERTY_DB_NAME = "db_name";
    private String dbName;

    public static final String JSON_PROPERTY_DB_USER = "db_user";
    private String dbUser;

    /**
     * - MYSQL: MySQL - PG: PostgreSQL - REDIS: Redis
     */
    public enum EngineEnum {
        UNSET("UNSET"),

        MYSQL("MYSQL"),

        PG("PG"),

        REDIS("REDIS");

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
    private EngineEnum engine = EngineEnum.UNSET;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_PRODUCTION = "production";
    private Boolean production;

    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    public AppDatabaseSpec() {
    }

    public AppDatabaseSpec clusterName(String clusterName) {
        this.clusterName = clusterName;
        return this;
    }

    /**
     * The name of the underlying DigitalOcean DBaaS cluster. This is required for
     * production databases. For dev databases, if cluster_name is not set, a new
     * cluster will be provisioned.
     *
     * @return clusterName
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CLUSTER_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getClusterName() {
        return clusterName;
    }

    @JsonProperty(JSON_PROPERTY_CLUSTER_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public AppDatabaseSpec dbName(String dbName) {
        this.dbName = dbName;
        return this;
    }

    /**
     * The name of the MySQL or PostgreSQL database to configure.
     *
     * @return dbName
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DB_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getDbName() {
        return dbName;
    }

    @JsonProperty(JSON_PROPERTY_DB_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public AppDatabaseSpec dbUser(String dbUser) {
        this.dbUser = dbUser;
        return this;
    }

    /**
     * The name of the MySQL or PostgreSQL user to configure.
     *
     * @return dbUser
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DB_USER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDbUser() {
        return dbUser;
    }

    @JsonProperty(JSON_PROPERTY_DB_USER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public AppDatabaseSpec engine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    /**
     * - MYSQL: MySQL - PG: PostgreSQL - REDIS: Redis
     *
     * @return engine
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENGINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public EngineEnum getEngine() {
        return engine;
    }

    @JsonProperty(JSON_PROPERTY_ENGINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public AppDatabaseSpec name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name. Must be unique across all components within the same app.
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

    public AppDatabaseSpec production(Boolean production) {
        this.production = production;
        return this;
    }

    /**
     * Whether this is a production or dev database.
     *
     * @return production
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRODUCTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getProduction() {
        return production;
    }

    @JsonProperty(JSON_PROPERTY_PRODUCTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProduction(Boolean production) {
        this.production = production;
    }

    public AppDatabaseSpec version(String version) {
        this.version = version;
        return this;
    }

    /**
     * The version of the database engine
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

    /**
     * Return true if this app_database_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppDatabaseSpec appDatabaseSpec = (AppDatabaseSpec) o;
        return Objects.equals(this.clusterName, appDatabaseSpec.clusterName)
                && Objects.equals(this.dbName, appDatabaseSpec.dbName)
                && Objects.equals(this.dbUser, appDatabaseSpec.dbUser)
                && Objects.equals(this.engine, appDatabaseSpec.engine)
                && Objects.equals(this.name, appDatabaseSpec.name)
                && Objects.equals(this.production, appDatabaseSpec.production)
                && Objects.equals(this.version, appDatabaseSpec.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clusterName, dbName, dbUser, engine, name, production, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppDatabaseSpec {\n");
        sb.append("    clusterName: ").append(toIndentedString(clusterName)).append("\n");
        sb.append("    dbName: ").append(toIndentedString(dbName)).append("\n");
        sb.append("    dbUser: ").append(toIndentedString(dbUser)).append("\n");
        sb.append("    engine: ").append(toIndentedString(engine)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    production: ").append(toIndentedString(production)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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