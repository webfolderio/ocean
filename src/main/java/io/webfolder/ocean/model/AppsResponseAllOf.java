package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AppsResponseAllOf
 */
@JsonPropertyOrder({ AppsResponseAllOf.JSON_PROPERTY_APPS })
public class AppsResponseAllOf {
    public static final String JSON_PROPERTY_APPS = "apps";
    private List<App> apps = null;

    public AppsResponseAllOf() {
    }

    public AppsResponseAllOf apps(List<App> apps) {
        this.apps = apps;
        return this;
    }

    public AppsResponseAllOf addAppsItem(App appsItem) {
        if (this.apps == null) {
            this.apps = new ArrayList<>();
        }
        this.apps.add(appsItem);
        return this;
    }

    /**
     * Get apps
     *
     * @return apps
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_APPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<App> getApps() {
        return apps;
    }

    @JsonProperty(JSON_PROPERTY_APPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setApps(List<App> apps) {
        this.apps = apps;
    }

    /**
     * Return true if this apps_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsResponseAllOf appsResponseAllOf = (AppsResponseAllOf) o;
        return Objects.equals(this.apps, appsResponseAllOf.apps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apps);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsResponseAllOf {\n");
        sb.append("    apps: ").append(toIndentedString(apps)).append("\n");
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
