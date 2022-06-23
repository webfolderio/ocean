package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppPropose
 */
@JsonPropertyOrder({ AppPropose.JSON_PROPERTY_SPEC, AppPropose.JSON_PROPERTY_APP_ID })
public class AppPropose {
    public static final String JSON_PROPERTY_SPEC = "spec";
    private AppSpec spec;

    public static final String JSON_PROPERTY_APP_ID = "app_id";
    private String appId;

    public AppPropose() {
    }

    public AppPropose spec(AppSpec spec) {
        this.spec = spec;
        return this;
    }

    /**
     * Get spec
     *
     * @return spec
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public AppSpec getSpec() {
        return spec;
    }

    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSpec(AppSpec spec) {
        this.spec = spec;
    }

    public AppPropose appId(String appId) {
        this.appId = appId;
        return this;
    }

    /**
     * An optional ID of an existing app. If set, the spec will be treated as a
     * proposed update to the specified app. The existing app is not modified using
     * this method.
     *
     * @return appId
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_APP_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getAppId() {
        return appId;
    }

    @JsonProperty(JSON_PROPERTY_APP_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * Return true if this app_propose object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppPropose appPropose = (AppPropose) o;
        return Objects.equals(this.spec, appPropose.spec) && Objects.equals(this.appId, appPropose.appId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spec, appId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppPropose {\n");
        sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
        sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
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