package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * SourceDatabase
 */
@JsonPropertyOrder({ SourceDatabase.JSON_PROPERTY_SOURCE, SourceDatabase.JSON_PROPERTY_DISABLE_SSL })
public class SourceDatabase {
    public static final String JSON_PROPERTY_SOURCE = "source";
    private SourceDatabaseSource source;

    public static final String JSON_PROPERTY_DISABLE_SSL = "disable_ssl";
    private Boolean disableSsl;

    public SourceDatabase() {
    }

    public SourceDatabase source(SourceDatabaseSource source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     *
     * @return source
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SOURCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public SourceDatabaseSource getSource() {
        return source;
    }

    @JsonProperty(JSON_PROPERTY_SOURCE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSource(SourceDatabaseSource source) {
        this.source = source;
    }

    public SourceDatabase disableSsl(Boolean disableSsl) {
        this.disableSsl = disableSsl;
        return this;
    }

    /**
     * Enables SSL encryption when connecting to the source database.
     *
     * @return disableSsl
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "false", value = "Enables SSL encryption when connecting to the source database.")
    @JsonProperty(JSON_PROPERTY_DISABLE_SSL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getDisableSsl() {
        return disableSsl;
    }

    @JsonProperty(JSON_PROPERTY_DISABLE_SSL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDisableSsl(Boolean disableSsl) {
        this.disableSsl = disableSsl;
    }

    /**
     * Return true if this source_database object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SourceDatabase sourceDatabase = (SourceDatabase) o;
        return Objects.equals(this.source, sourceDatabase.source)
                && Objects.equals(this.disableSsl, sourceDatabase.disableSsl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, disableSsl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SourceDatabase {\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    disableSsl: ").append(toIndentedString(disableSsl)).append("\n");
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
