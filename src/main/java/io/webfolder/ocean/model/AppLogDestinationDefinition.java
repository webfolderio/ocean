package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppLogDestinationDefinition
 */
@JsonPropertyOrder({ AppLogDestinationDefinition.JSON_PROPERTY_NAME,
        AppLogDestinationDefinition.JSON_PROPERTY_PAPERTRAIL, AppLogDestinationDefinition.JSON_PROPERTY_DATADOG,
        AppLogDestinationDefinition.JSON_PROPERTY_LOGTAIL })
public class AppLogDestinationDefinition {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_PAPERTRAIL = "papertrail";
    private AppLogDestinationPapertrailSpec papertrail;

    public static final String JSON_PROPERTY_DATADOG = "datadog";
    private AppLogDestinationDatadogSpec datadog;

    public static final String JSON_PROPERTY_LOGTAIL = "logtail";
    private AppLogDestinationLogtailSpec logtail;

    public AppLogDestinationDefinition() {
    }

    public AppLogDestinationDefinition name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
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

    public AppLogDestinationDefinition papertrail(AppLogDestinationPapertrailSpec papertrail) {
        this.papertrail = papertrail;
        return this;
    }

    /**
     * Get papertrail
     *
     * @return papertrail
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PAPERTRAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AppLogDestinationPapertrailSpec getPapertrail() {
        return papertrail;
    }

    @JsonProperty(JSON_PROPERTY_PAPERTRAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPapertrail(AppLogDestinationPapertrailSpec papertrail) {
        this.papertrail = papertrail;
    }

    public AppLogDestinationDefinition datadog(AppLogDestinationDatadogSpec datadog) {
        this.datadog = datadog;
        return this;
    }

    /**
     * Get datadog
     *
     * @return datadog
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DATADOG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AppLogDestinationDatadogSpec getDatadog() {
        return datadog;
    }

    @JsonProperty(JSON_PROPERTY_DATADOG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDatadog(AppLogDestinationDatadogSpec datadog) {
        this.datadog = datadog;
    }

    public AppLogDestinationDefinition logtail(AppLogDestinationLogtailSpec logtail) {
        this.logtail = logtail;
        return this;
    }

    /**
     * Get logtail
     *
     * @return logtail
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOGTAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AppLogDestinationLogtailSpec getLogtail() {
        return logtail;
    }

    @JsonProperty(JSON_PROPERTY_LOGTAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLogtail(AppLogDestinationLogtailSpec logtail) {
        this.logtail = logtail;
    }

    /**
     * Return true if this app_log_destination_definition object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppLogDestinationDefinition appLogDestinationDefinition = (AppLogDestinationDefinition) o;
        return Objects.equals(this.name, appLogDestinationDefinition.name)
                && Objects.equals(this.papertrail, appLogDestinationDefinition.papertrail)
                && Objects.equals(this.datadog, appLogDestinationDefinition.datadog)
                && Objects.equals(this.logtail, appLogDestinationDefinition.logtail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, papertrail, datadog, logtail);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppLogDestinationDefinition {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    papertrail: ").append(toIndentedString(papertrail)).append("\n");
        sb.append("    datadog: ").append(toIndentedString(datadog)).append("\n");
        sb.append("    logtail: ").append(toIndentedString(logtail)).append("\n");
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