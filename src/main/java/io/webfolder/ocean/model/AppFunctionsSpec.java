package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppFunctionsSpec
 */
@JsonPropertyOrder({ AppFunctionsSpec.JSON_PROPERTY_CORS, AppFunctionsSpec.JSON_PROPERTY_ROUTES,
        AppFunctionsSpec.JSON_PROPERTY_NAME, AppFunctionsSpec.JSON_PROPERTY_SOURCE_DIR,
        AppFunctionsSpec.JSON_PROPERTY_ALERTS, AppFunctionsSpec.JSON_PROPERTY_ENVS, AppFunctionsSpec.JSON_PROPERTY_GIT,
        AppFunctionsSpec.JSON_PROPERTY_GITHUB, AppFunctionsSpec.JSON_PROPERTY_GITLAB,
        AppFunctionsSpec.JSON_PROPERTY_LOG_DESTINATIONS })
public class AppFunctionsSpec {
    public static final String JSON_PROPERTY_CORS = "cors";
    private AppsCorsPolicy cors;

    public static final String JSON_PROPERTY_ROUTES = "routes";
    private List<AppRouteSpec> routes = null;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_SOURCE_DIR = "source_dir";
    private String sourceDir;

    public static final String JSON_PROPERTY_ALERTS = "alerts";
    private List<AppAlertSpec> alerts = null;

    public static final String JSON_PROPERTY_ENVS = "envs";
    private List<AppVariableDefinition> envs = null;

    public static final String JSON_PROPERTY_GIT = "git";
    private AppsGitSourceSpec git;

    public static final String JSON_PROPERTY_GITHUB = "github";
    private AppsGithubSourceSpec github;

    public static final String JSON_PROPERTY_GITLAB = "gitlab";
    private AppsGitlabSourceSpec gitlab;

    public static final String JSON_PROPERTY_LOG_DESTINATIONS = "log_destinations";
    private AppLogDestinationDefinition logDestinations;

    public AppFunctionsSpec() {
    }

    public AppFunctionsSpec cors(AppsCorsPolicy cors) {
        this.cors = cors;
        return this;
    }

    /**
     * Get cors
     *
     * @return cors
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CORS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public AppsCorsPolicy getCors() {
        return cors;
    }

    @JsonProperty(JSON_PROPERTY_CORS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCors(AppsCorsPolicy cors) {
        this.cors = cors;
    }

    public AppFunctionsSpec routes(List<AppRouteSpec> routes) {
        this.routes = routes;
        return this;
    }

    public AppFunctionsSpec addRoutesItem(AppRouteSpec routesItem) {
        if (this.routes == null) {
            this.routes = new ArrayList<>();
        }
        this.routes.add(routesItem);
        return this;
    }

    /**
     * A list of HTTP routes that should be routed to this component.
     *
     * @return routes
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ROUTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<AppRouteSpec> getRoutes() {
        return routes;
    }

    @JsonProperty(JSON_PROPERTY_ROUTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRoutes(List<AppRouteSpec> routes) {
        this.routes = routes;
    }

    public AppFunctionsSpec name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name. Must be unique across all components within the same app.
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

    public AppFunctionsSpec sourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
        return this;
    }

    /**
     * An optional path to the working directory to use for the build. For
     * Dockerfile builds, this will be used as the build context. Must be relative
     * to the root of the repo.
     *
     * @return sourceDir
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_DIR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSourceDir() {
        return sourceDir;
    }

    @JsonProperty(JSON_PROPERTY_SOURCE_DIR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public AppFunctionsSpec alerts(List<AppAlertSpec> alerts) {
        this.alerts = alerts;
        return this;
    }

    public AppFunctionsSpec addAlertsItem(AppAlertSpec alertsItem) {
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
    @JsonProperty(JSON_PROPERTY_ALERTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppAlertSpec> getAlerts() {
        return alerts;
    }

    @JsonProperty(JSON_PROPERTY_ALERTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAlerts(List<AppAlertSpec> alerts) {
        this.alerts = alerts;
    }

    public AppFunctionsSpec envs(List<AppVariableDefinition> envs) {
        this.envs = envs;
        return this;
    }

    public AppFunctionsSpec addEnvsItem(AppVariableDefinition envsItem) {
        if (this.envs == null) {
            this.envs = new ArrayList<>();
        }
        this.envs.add(envsItem);
        return this;
    }

    /**
     * A list of environment variables made available to the component.
     *
     * @return envs
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENVS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppVariableDefinition> getEnvs() {
        return envs;
    }

    @JsonProperty(JSON_PROPERTY_ENVS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEnvs(List<AppVariableDefinition> envs) {
        this.envs = envs;
    }

    public AppFunctionsSpec git(AppsGitSourceSpec git) {
        this.git = git;
        return this;
    }

    /**
     * Get git
     *
     * @return git
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsGitSourceSpec getGit() {
        return git;
    }

    @JsonProperty(JSON_PROPERTY_GIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGit(AppsGitSourceSpec git) {
        this.git = git;
    }

    public AppFunctionsSpec github(AppsGithubSourceSpec github) {
        this.github = github;
        return this;
    }

    /**
     * Get github
     *
     * @return github
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GITHUB)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsGithubSourceSpec getGithub() {
        return github;
    }

    @JsonProperty(JSON_PROPERTY_GITHUB)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGithub(AppsGithubSourceSpec github) {
        this.github = github;
    }

    public AppFunctionsSpec gitlab(AppsGitlabSourceSpec gitlab) {
        this.gitlab = gitlab;
        return this;
    }

    /**
     * Get gitlab
     *
     * @return gitlab
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GITLAB)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsGitlabSourceSpec getGitlab() {
        return gitlab;
    }

    @JsonProperty(JSON_PROPERTY_GITLAB)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGitlab(AppsGitlabSourceSpec gitlab) {
        this.gitlab = gitlab;
    }

    public AppFunctionsSpec logDestinations(AppLogDestinationDefinition logDestinations) {
        this.logDestinations = logDestinations;
        return this;
    }

    /**
     * Get logDestinations
     *
     * @return logDestinations
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOG_DESTINATIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppLogDestinationDefinition getLogDestinations() {
        return logDestinations;
    }

    @JsonProperty(JSON_PROPERTY_LOG_DESTINATIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLogDestinations(AppLogDestinationDefinition logDestinations) {
        this.logDestinations = logDestinations;
    }

    /**
     * Return true if this app_functions_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppFunctionsSpec appFunctionsSpec = (AppFunctionsSpec) o;
        return Objects.equals(this.cors, appFunctionsSpec.cors) && Objects.equals(this.routes, appFunctionsSpec.routes)
                && Objects.equals(this.name, appFunctionsSpec.name)
                && Objects.equals(this.sourceDir, appFunctionsSpec.sourceDir)
                && Objects.equals(this.alerts, appFunctionsSpec.alerts)
                && Objects.equals(this.envs, appFunctionsSpec.envs) && Objects.equals(this.git, appFunctionsSpec.git)
                && Objects.equals(this.github, appFunctionsSpec.github)
                && Objects.equals(this.gitlab, appFunctionsSpec.gitlab)
                && Objects.equals(this.logDestinations, appFunctionsSpec.logDestinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cors, routes, name, sourceDir, alerts, envs, git, github, gitlab, logDestinations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppFunctionsSpec {\n");
        sb.append("    cors: ").append(toIndentedString(cors)).append("\n");
        sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    sourceDir: ").append(toIndentedString(sourceDir)).append("\n");
        sb.append("    alerts: ").append(toIndentedString(alerts)).append("\n");
        sb.append("    envs: ").append(toIndentedString(envs)).append("\n");
        sb.append("    git: ").append(toIndentedString(git)).append("\n");
        sb.append("    github: ").append(toIndentedString(github)).append("\n");
        sb.append("    gitlab: ").append(toIndentedString(gitlab)).append("\n");
        sb.append("    logDestinations: ").append(toIndentedString(logDestinations)).append("\n");
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