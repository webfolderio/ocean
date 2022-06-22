package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * AppsListAlertsResponse
 */
@JsonPropertyOrder({ AppsListAlertsResponse.JSON_PROPERTY_ALERTS })
public class AppsListAlertsResponse {
    public static final String JSON_PROPERTY_ALERTS = "alerts";
    private List<AppAlert> alerts = null;

    public AppsListAlertsResponse() {
    }

    public AppsListAlertsResponse alerts(List<AppAlert> alerts) {
        this.alerts = alerts;
        return this;
    }

    public AppsListAlertsResponse addAlertsItem(AppAlert alertsItem) {
        if (this.alerts == null) {
            this.alerts = new ArrayList<>();
        }
        this.alerts.add(alertsItem);
        return this;
    }

    /**
     * Get alerts
     *
     * @return alerts
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ALERTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppAlert> getAlerts() {
        return alerts;
    }

    @JsonProperty(JSON_PROPERTY_ALERTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAlerts(List<AppAlert> alerts) {
        this.alerts = alerts;
    }

    /**
     * Return true if this apps_list_alerts_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsListAlertsResponse appsListAlertsResponse = (AppsListAlertsResponse) o;
        return Objects.equals(this.alerts, appsListAlertsResponse.alerts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alerts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsListAlertsResponse {\n");
        sb.append("    alerts: ").append(toIndentedString(alerts)).append("\n");
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
