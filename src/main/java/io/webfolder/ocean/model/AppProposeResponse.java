package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppProposeResponse
 */
@JsonPropertyOrder({ AppProposeResponse.JSON_PROPERTY_APP_IS_STATIC,
        AppProposeResponse.JSON_PROPERTY_APP_NAME_AVAILABLE, AppProposeResponse.JSON_PROPERTY_APP_NAME_SUGGESTION,
        AppProposeResponse.JSON_PROPERTY_EXISTING_STATIC_APPS, AppProposeResponse.JSON_PROPERTY_SPEC,
        AppProposeResponse.JSON_PROPERTY_APP_COST, AppProposeResponse.JSON_PROPERTY_APP_TIER_DOWNGRADE_COST })
public class AppProposeResponse {
    public static final String JSON_PROPERTY_APP_IS_STATIC = "app_is_static";
    private Boolean appIsStatic;

    public static final String JSON_PROPERTY_APP_NAME_AVAILABLE = "app_name_available";
    private Boolean appNameAvailable;

    public static final String JSON_PROPERTY_APP_NAME_SUGGESTION = "app_name_suggestion";
    private String appNameSuggestion;

    public static final String JSON_PROPERTY_EXISTING_STATIC_APPS = "existing_static_apps";
    private String existingStaticApps;

    public static final String JSON_PROPERTY_SPEC = "spec";
    private AppSpec spec;

    public static final String JSON_PROPERTY_APP_COST = "app_cost";
    private Integer appCost;

    public static final String JSON_PROPERTY_APP_TIER_DOWNGRADE_COST = "app_tier_downgrade_cost";
    private Integer appTierDowngradeCost;

    public AppProposeResponse() {
    }

    public AppProposeResponse appIsStatic(Boolean appIsStatic) {
        this.appIsStatic = appIsStatic;
        return this;
    }

    /**
     * Indicates whether the app is a static app.
     *
     * @return appIsStatic
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_APP_IS_STATIC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Boolean getAppIsStatic() {
        return appIsStatic;
    }

    @JsonProperty(JSON_PROPERTY_APP_IS_STATIC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAppIsStatic(Boolean appIsStatic) {
        this.appIsStatic = appIsStatic;
    }

    public AppProposeResponse appNameAvailable(Boolean appNameAvailable) {
        this.appNameAvailable = appNameAvailable;
        return this;
    }

    /**
     * Indicates whether the app name is available.
     *
     * @return appNameAvailable
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_APP_NAME_AVAILABLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Boolean getAppNameAvailable() {
        return appNameAvailable;
    }

    @JsonProperty(JSON_PROPERTY_APP_NAME_AVAILABLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAppNameAvailable(Boolean appNameAvailable) {
        this.appNameAvailable = appNameAvailable;
    }

    public AppProposeResponse appNameSuggestion(String appNameSuggestion) {
        this.appNameSuggestion = appNameSuggestion;
        return this;
    }

    /**
     * The suggested name if the proposed app name is unavailable.
     *
     * @return appNameSuggestion
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_APP_NAME_SUGGESTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAppNameSuggestion() {
        return appNameSuggestion;
    }

    @JsonProperty(JSON_PROPERTY_APP_NAME_SUGGESTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAppNameSuggestion(String appNameSuggestion) {
        this.appNameSuggestion = appNameSuggestion;
    }

    public AppProposeResponse existingStaticApps(String existingStaticApps) {
        this.existingStaticApps = existingStaticApps;
        return this;
    }

    /**
     * The maximum number of free static apps the account can have. We will charge
     * you for any additional static apps.
     *
     * @return existingStaticApps
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXISTING_STATIC_APPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getExistingStaticApps() {
        return existingStaticApps;
    }

    @JsonProperty(JSON_PROPERTY_EXISTING_STATIC_APPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExistingStaticApps(String existingStaticApps) {
        this.existingStaticApps = existingStaticApps;
    }

    public AppProposeResponse spec(AppSpec spec) {
        this.spec = spec;
        return this;
    }

    /**
     * Get spec
     *
     * @return spec
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppSpec getSpec() {
        return spec;
    }

    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSpec(AppSpec spec) {
        this.spec = spec;
    }

    public AppProposeResponse appCost(Integer appCost) {
        this.appCost = appCost;
        return this;
    }

    /**
     * The monthly cost of the proposed app in USD using the next pricing plan tier.
     * For example, if you propose an app that uses the Basic tier, the
     * &#x60;app_tier_upgrade_cost&#x60; field displays the monthly cost of the app
     * if it were to use the Professional tier. If the proposed app already uses the
     * most expensive tier, the field is empty.
     *
     * @return appCost
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_APP_COST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getAppCost() {
        return appCost;
    }

    @JsonProperty(JSON_PROPERTY_APP_COST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAppCost(Integer appCost) {
        this.appCost = appCost;
    }

    public AppProposeResponse appTierDowngradeCost(Integer appTierDowngradeCost) {
        this.appTierDowngradeCost = appTierDowngradeCost;
        return this;
    }

    /**
     * The monthly cost of the proposed app in USD using the previous pricing plan
     * tier. For example, if you propose an app that uses the Professional tier, the
     * &#x60;app_tier_downgrade_cost&#x60; field displays the monthly cost of the
     * app if it were to use the Basic tier. If the proposed app already uses the
     * lest expensive tier, the field is empty.
     *
     * @return appTierDowngradeCost
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_APP_TIER_DOWNGRADE_COST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Integer getAppTierDowngradeCost() {
        return appTierDowngradeCost;
    }

    @JsonProperty(JSON_PROPERTY_APP_TIER_DOWNGRADE_COST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAppTierDowngradeCost(Integer appTierDowngradeCost) {
        this.appTierDowngradeCost = appTierDowngradeCost;
    }

    /**
     * Return true if this app_propose_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppProposeResponse appProposeResponse = (AppProposeResponse) o;
        return Objects.equals(this.appIsStatic, appProposeResponse.appIsStatic)
                && Objects.equals(this.appNameAvailable, appProposeResponse.appNameAvailable)
                && Objects.equals(this.appNameSuggestion, appProposeResponse.appNameSuggestion)
                && Objects.equals(this.existingStaticApps, appProposeResponse.existingStaticApps)
                && Objects.equals(this.spec, appProposeResponse.spec)
                && Objects.equals(this.appCost, appProposeResponse.appCost)
                && Objects.equals(this.appTierDowngradeCost, appProposeResponse.appTierDowngradeCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appIsStatic, appNameAvailable, appNameSuggestion, existingStaticApps, spec, appCost,
                appTierDowngradeCost);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppProposeResponse {\n");
        sb.append("    appIsStatic: ").append(toIndentedString(appIsStatic)).append("\n");
        sb.append("    appNameAvailable: ").append(toIndentedString(appNameAvailable)).append("\n");
        sb.append("    appNameSuggestion: ").append(toIndentedString(appNameSuggestion)).append("\n");
        sb.append("    existingStaticApps: ").append(toIndentedString(existingStaticApps)).append("\n");
        sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
        sb.append("    appCost: ").append(toIndentedString(appCost)).append("\n");
        sb.append("    appTierDowngradeCost: ").append(toIndentedString(appTierDowngradeCost)).append("\n");
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