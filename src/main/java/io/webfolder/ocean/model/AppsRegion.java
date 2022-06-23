package io.webfolder.ocean.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsRegion
 */
@JsonPropertyOrder({ AppsRegion.JSON_PROPERTY_CONTINENT, AppsRegion.JSON_PROPERTY_DATA_CENTERS,
        AppsRegion.JSON_PROPERTY_DEFAULT, AppsRegion.JSON_PROPERTY_DISABLED, AppsRegion.JSON_PROPERTY_FLAG,
        AppsRegion.JSON_PROPERTY_LABEL, AppsRegion.JSON_PROPERTY_REASON, AppsRegion.JSON_PROPERTY_SLUG })
public class AppsRegion {
    public static final String JSON_PROPERTY_CONTINENT = "continent";
    private String continent;

    public static final String JSON_PROPERTY_DATA_CENTERS = "data_centers";
    private List<String> dataCenters = null;

    public static final String JSON_PROPERTY_DEFAULT = "default";
    private Boolean _default;

    public static final String JSON_PROPERTY_DISABLED = "disabled";
    private Boolean disabled;

    public static final String JSON_PROPERTY_FLAG = "flag";
    private String flag;

    public static final String JSON_PROPERTY_LABEL = "label";
    private String label;

    public static final String JSON_PROPERTY_REASON = "reason";
    private String reason;

    public static final String JSON_PROPERTY_SLUG = "slug";
    private String slug;

    public AppsRegion() {
    }

    @JsonCreator
    public AppsRegion(@JsonProperty(JSON_PROPERTY_CONTINENT) String continent,
            @JsonProperty(JSON_PROPERTY_DATA_CENTERS) List<String> dataCenters,
            @JsonProperty(JSON_PROPERTY_DEFAULT) Boolean _default,
            @JsonProperty(JSON_PROPERTY_DISABLED) Boolean disabled, @JsonProperty(JSON_PROPERTY_FLAG) String flag,
            @JsonProperty(JSON_PROPERTY_LABEL) String label, @JsonProperty(JSON_PROPERTY_REASON) String reason,
            @JsonProperty(JSON_PROPERTY_SLUG) String slug) {
        this();
        this.continent = continent;
        this.dataCenters = dataCenters;
        this._default = _default;
        this.disabled = disabled;
        this.flag = flag;
        this.label = label;
        this.reason = reason;
        this.slug = slug;
    }

    /**
     * Get continent
     *
     * @return continent
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTINENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getContinent() {
        return continent;
    }

    /**
     * Get dataCenters
     *
     * @return dataCenters
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DATA_CENTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getDataCenters() {
        return dataCenters;
    }

    /**
     * Whether or not the region is presented as the default.
     *
     * @return _default
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Boolean getDefault() {
        return _default;
    }

    /**
     * Get disabled
     *
     * @return disabled
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISABLED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * Get flag
     *
     * @return flag
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FLAG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFlag() {
        return flag;
    }

    /**
     * Get label
     *
     * @return label
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLabel() {
        return label;
    }

    /**
     * Get reason
     *
     * @return reason
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REASON)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getReason() {
        return reason;
    }

    /**
     * Get slug
     *
     * @return slug
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSlug() {
        return slug;
    }

    /**
     * Return true if this apps_region object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsRegion appsRegion = (AppsRegion) o;
        return Objects.equals(this.continent, appsRegion.continent)
                && Objects.equals(this.dataCenters, appsRegion.dataCenters)
                && Objects.equals(this._default, appsRegion._default)
                && Objects.equals(this.disabled, appsRegion.disabled) && Objects.equals(this.flag, appsRegion.flag)
                && Objects.equals(this.label, appsRegion.label) && Objects.equals(this.reason, appsRegion.reason)
                && Objects.equals(this.slug, appsRegion.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continent, dataCenters, _default, disabled, flag, label, reason, slug);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsRegion {\n");
        sb.append("    continent: ").append(toIndentedString(continent)).append("\n");
        sb.append("    dataCenters: ").append(toIndentedString(dataCenters)).append("\n");
        sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
        sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
        sb.append("    flag: ").append(toIndentedString(flag)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
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