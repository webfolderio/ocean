package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * SqlMode
 */
@JsonPropertyOrder({ SqlMode.JSON_PROPERTY_SQL_MODE })
public class SqlMode {
    public static final String JSON_PROPERTY_SQL_MODE = "sql_mode";
    private String sqlMode;

    public SqlMode() {
    }

    public SqlMode sqlMode(String sqlMode) {
        this.sqlMode = sqlMode;
        return this;
    }

    /**
     * A string specifying the configured SQL modes for the MySQL cluster.
     *
     * @return sqlMode
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(example = "ANSI,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION,NO_ZERO_DATE,NO_ZERO_IN_DATE,STRICT_ALL_TABLES", required = true, value = "A string specifying the configured SQL modes for the MySQL cluster.")
    @JsonProperty(JSON_PROPERTY_SQL_MODE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getSqlMode() {
        return sqlMode;
    }

    @JsonProperty(JSON_PROPERTY_SQL_MODE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSqlMode(String sqlMode) {
        this.sqlMode = sqlMode;
    }

    /**
     * Return true if this sql_mode object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SqlMode sqlMode = (SqlMode) o;
        return Objects.equals(this.sqlMode, sqlMode.sqlMode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sqlMode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SqlMode {\n");
        sb.append("    sqlMode: ").append(toIndentedString(sqlMode)).append("\n");
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
