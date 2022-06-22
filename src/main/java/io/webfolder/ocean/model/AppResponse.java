package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AppResponse
 */
@JsonPropertyOrder({ AppResponse.JSON_PROPERTY_APP })
public class AppResponse {
    public static final String JSON_PROPERTY_APP = "app";
    private App app;

    public AppResponse() {
    }

    public AppResponse app(App app) {
        this.app = app;
        return this;
    }

    /**
     * Get app
     *
     * @return app
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_APP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public App getApp() {
        return app;
    }

    @JsonProperty(JSON_PROPERTY_APP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Return true if this app_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppResponse appResponse = (AppResponse) o;
        return Objects.equals(this.app, appResponse.app);
    }

    @Override
    public int hashCode() {
        return Objects.hash(app);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppResponse {\n");
        sb.append("    app: ").append(toIndentedString(app)).append("\n");
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
