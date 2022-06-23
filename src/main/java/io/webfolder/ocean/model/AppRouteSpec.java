package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppRouteSpec
 */
@JsonPropertyOrder({ AppRouteSpec.JSON_PROPERTY_PATH, AppRouteSpec.JSON_PROPERTY_PRESERVE_PATH_PREFIX })
public class AppRouteSpec {
    public static final String JSON_PROPERTY_PATH = "path";
    private String path;

    public static final String JSON_PROPERTY_PRESERVE_PATH_PREFIX = "preserve_path_prefix";
    private Boolean preservePathPrefix;

    public AppRouteSpec() {
    }

    public AppRouteSpec path(String path) {
        this.path = path;
        return this;
    }

    /**
     * An HTTP path prefix. Paths must start with / and must be unique across all
     * components within an app.
     *
     * @return path
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getPath() {
        return path;
    }

    @JsonProperty(JSON_PROPERTY_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPath(String path) {
        this.path = path;
    }

    public AppRouteSpec preservePathPrefix(Boolean preservePathPrefix) {
        this.preservePathPrefix = preservePathPrefix;
        return this;
    }

    /**
     * An optional flag to preserve the path that is forwarded to the backend
     * service. By default, the HTTP request path will be trimmed from the left when
     * forwarded to the component. For example, a component with
     * &#x60;path&#x3D;/api&#x60; will have requests to &#x60;/api/list&#x60;
     * trimmed to &#x60;/list&#x60;. If this value is &#x60;true&#x60;, the path
     * will remain &#x60;/api/list&#x60;.
     *
     * @return preservePathPrefix
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRESERVE_PATH_PREFIX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getPreservePathPrefix() {
        return preservePathPrefix;
    }

    @JsonProperty(JSON_PROPERTY_PRESERVE_PATH_PREFIX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPreservePathPrefix(Boolean preservePathPrefix) {
        this.preservePathPrefix = preservePathPrefix;
    }

    /**
     * Return true if this app_route_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppRouteSpec appRouteSpec = (AppRouteSpec) o;
        return Objects.equals(this.path, appRouteSpec.path)
                && Objects.equals(this.preservePathPrefix, appRouteSpec.preservePathPrefix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, preservePathPrefix);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppRouteSpec {\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    preservePathPrefix: ").append(toIndentedString(preservePathPrefix)).append("\n");
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