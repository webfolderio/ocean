package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AppsAlertResponse
 */
@JsonPropertyOrder({ AppsAlertResponse.JSON_PROPERTY_ALERT })
public class AppsAlertResponse {
    public static final String JSON_PROPERTY_ALERT = "alert";
    private AppAlert alert;

    public AppsAlertResponse() {
    }

    public AppsAlertResponse alert(AppAlert alert) {
        this.alert = alert;
        return this;
    }

    /**
     * Get alert
     *
     * @return alert
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ALERT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppAlert getAlert() {
        return alert;
    }

    @JsonProperty(JSON_PROPERTY_ALERT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAlert(AppAlert alert) {
        this.alert = alert;
    }

    /**
     * Return true if this apps_alert_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsAlertResponse appsAlertResponse = (AppsAlertResponse) o;
        return Objects.equals(this.alert, appsAlertResponse.alert);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alert);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsAlertResponse {\n");
        sb.append("    alert: ").append(toIndentedString(alert)).append("\n");
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
