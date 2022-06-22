package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * DatabaseUser
 */
@JsonPropertyOrder({ DatabaseUser.JSON_PROPERTY_NAME, DatabaseUser.JSON_PROPERTY_ROLE,
        DatabaseUser.JSON_PROPERTY_PASSWORD, DatabaseUser.JSON_PROPERTY_MYSQL_SETTINGS })
public class DatabaseUser {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    /**
     * A string representing the database user&#39;s role. The value will be either
     * \&quot;primary\&quot; or \&quot;normal\&quot;.
     */
    public enum RoleEnum {
        PRIMARY("primary"),

        NORMAL("normal");

        private String value;

        RoleEnum(String value) {
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
        public static RoleEnum fromValue(String value) {
            for (RoleEnum b : RoleEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_ROLE = "role";
    private RoleEnum role;

    public static final String JSON_PROPERTY_PASSWORD = "password";
    private String password;

    public static final String JSON_PROPERTY_MYSQL_SETTINGS = "mysql_settings";
    private MysqlSettings mysqlSettings;

    public DatabaseUser() {
    }

    @JsonCreator
    public DatabaseUser(@JsonProperty(JSON_PROPERTY_ROLE) RoleEnum role,
            @JsonProperty(JSON_PROPERTY_PASSWORD) String password) {
        this();
        this.role = role;
        this.password = password;
    }

    public DatabaseUser name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of a database user.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "app-01", required = true, value = "The name of a database user.")
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

    /**
     * A string representing the database user&#39;s role. The value will be either
     * \&quot;primary\&quot; or \&quot;normal\&quot;.
     *
     * @return role
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "normal", value = "A string representing the database user's role. The value will be either \"primary\" or \"normal\". ")
    @JsonProperty(JSON_PROPERTY_ROLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public RoleEnum getRole() {
        return role;
    }

    /**
     * A randomly generated password for the database user.
     *
     * @return password
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "jge5lfxtzhx42iff", value = "A randomly generated password for the database user.")
    @JsonProperty(JSON_PROPERTY_PASSWORD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPassword() {
        return password;
    }

    public DatabaseUser mysqlSettings(MysqlSettings mysqlSettings) {
        this.mysqlSettings = mysqlSettings;
        return this;
    }

    /**
     * Get mysqlSettings
     *
     * @return mysqlSettings
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_MYSQL_SETTINGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public MysqlSettings getMysqlSettings() {
        return mysqlSettings;
    }

    @JsonProperty(JSON_PROPERTY_MYSQL_SETTINGS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMysqlSettings(MysqlSettings mysqlSettings) {
        this.mysqlSettings = mysqlSettings;
    }

    /**
     * Return true if this database_user object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DatabaseUser databaseUser = (DatabaseUser) o;
        return Objects.equals(this.name, databaseUser.name) && Objects.equals(this.role, databaseUser.role)
                && Objects.equals(this.password, databaseUser.password)
                && Objects.equals(this.mysqlSettings, databaseUser.mysqlSettings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role, password, mysqlSettings);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatabaseUser {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    mysqlSettings: ").append(toIndentedString(mysqlSettings)).append("\n");
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
