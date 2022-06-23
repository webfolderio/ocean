package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppComponentBase
 */
@JsonPropertyOrder({ AppComponentBase.JSON_PROPERTY_NAME, AppComponentBase.JSON_PROPERTY_GIT,
        AppComponentBase.JSON_PROPERTY_GITHUB, AppComponentBase.JSON_PROPERTY_GITLAB,
        AppComponentBase.JSON_PROPERTY_IMAGE, AppComponentBase.JSON_PROPERTY_DOCKERFILE_PATH,
        AppComponentBase.JSON_PROPERTY_BUILD_COMMAND, AppComponentBase.JSON_PROPERTY_RUN_COMMAND,
        AppComponentBase.JSON_PROPERTY_SOURCE_DIR, AppComponentBase.JSON_PROPERTY_ENVS,
        AppComponentBase.JSON_PROPERTY_ENVIRONMENT_SLUG, AppComponentBase.JSON_PROPERTY_LOG_DESTINATIONS })
public class AppComponentBase {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_GIT = "git";
    private AppsGitSourceSpec git;

    public static final String JSON_PROPERTY_GITHUB = "github";
    private AppsGithubSourceSpec github;

    public static final String JSON_PROPERTY_GITLAB = "gitlab";
    private AppsGitlabSourceSpec gitlab;

    public static final String JSON_PROPERTY_IMAGE = "image";
    private AppsImageSourceSpec image;

    public static final String JSON_PROPERTY_DOCKERFILE_PATH = "dockerfile_path";
    private String dockerfilePath;

    public static final String JSON_PROPERTY_BUILD_COMMAND = "build_command";
    private String buildCommand;

    public static final String JSON_PROPERTY_RUN_COMMAND = "run_command";
    private String runCommand;

    public static final String JSON_PROPERTY_SOURCE_DIR = "source_dir";
    private String sourceDir;

    public static final String JSON_PROPERTY_ENVS = "envs";
    private List<AppVariableDefinition> envs = null;

    public static final String JSON_PROPERTY_ENVIRONMENT_SLUG = "environment_slug";
    private String environmentSlug;

    public static final String JSON_PROPERTY_LOG_DESTINATIONS = "log_destinations";
    private AppLogDestinationDefinition logDestinations;

    public AppComponentBase() {
    }

    public AppComponentBase name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name. Must be unique across all components within the same app.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public AppComponentBase git(AppsGitSourceSpec git) {
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

    public AppComponentBase github(AppsGithubSourceSpec github) {
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

    public AppComponentBase gitlab(AppsGitlabSourceSpec gitlab) {
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

    public AppComponentBase image(AppsImageSourceSpec image) {
        this.image = image;
        return this;
    }

    /**
     * Get image
     *
     * @return image
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IMAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsImageSourceSpec getImage() {
        return image;
    }

    @JsonProperty(JSON_PROPERTY_IMAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setImage(AppsImageSourceSpec image) {
        this.image = image;
    }

    public AppComponentBase dockerfilePath(String dockerfilePath) {
        this.dockerfilePath = dockerfilePath;
        return this;
    }

    /**
     * The path to the Dockerfile relative to the root of the repo. If set, it will
     * be used to build this component. Otherwise, App Platform will attempt to
     * build it using buildpacks.
     *
     * @return dockerfilePath
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DOCKERFILE_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDockerfilePath() {
        return dockerfilePath;
    }

    @JsonProperty(JSON_PROPERTY_DOCKERFILE_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDockerfilePath(String dockerfilePath) {
        this.dockerfilePath = dockerfilePath;
    }

    public AppComponentBase buildCommand(String buildCommand) {
        this.buildCommand = buildCommand;
        return this;
    }

    /**
     * An optional build command to run while building this component from source.
     *
     * @return buildCommand
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BUILD_COMMAND)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getBuildCommand() {
        return buildCommand;
    }

    @JsonProperty(JSON_PROPERTY_BUILD_COMMAND)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBuildCommand(String buildCommand) {
        this.buildCommand = buildCommand;
    }

    public AppComponentBase runCommand(String runCommand) {
        this.runCommand = runCommand;
        return this;
    }

    /**
     * An optional run command to override the component&#39;s default.
     *
     * @return runCommand
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RUN_COMMAND)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRunCommand() {
        return runCommand;
    }

    @JsonProperty(JSON_PROPERTY_RUN_COMMAND)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRunCommand(String runCommand) {
        this.runCommand = runCommand;
    }

    public AppComponentBase sourceDir(String sourceDir) {
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

    public AppComponentBase envs(List<AppVariableDefinition> envs) {
        this.envs = envs;
        return this;
    }

    public AppComponentBase addEnvsItem(AppVariableDefinition envsItem) {
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

    public AppComponentBase environmentSlug(String environmentSlug) {
        this.environmentSlug = environmentSlug;
        return this;
    }

    /**
     * An environment slug describing the type of this app. For a full list, please
     * refer to [the product
     * documentation](https://www.digitalocean.com/docs/app-platform/).
     *
     * @return environmentSlug
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENVIRONMENT_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEnvironmentSlug() {
        return environmentSlug;
    }

    @JsonProperty(JSON_PROPERTY_ENVIRONMENT_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEnvironmentSlug(String environmentSlug) {
        this.environmentSlug = environmentSlug;
    }

    public AppComponentBase logDestinations(AppLogDestinationDefinition logDestinations) {
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
     * Return true if this app_component_base object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppComponentBase appComponentBase = (AppComponentBase) o;
        return Objects.equals(this.name, appComponentBase.name) && Objects.equals(this.git, appComponentBase.git)
                && Objects.equals(this.github, appComponentBase.github)
                && Objects.equals(this.gitlab, appComponentBase.gitlab)
                && Objects.equals(this.image, appComponentBase.image)
                && Objects.equals(this.dockerfilePath, appComponentBase.dockerfilePath)
                && Objects.equals(this.buildCommand, appComponentBase.buildCommand)
                && Objects.equals(this.runCommand, appComponentBase.runCommand)
                && Objects.equals(this.sourceDir, appComponentBase.sourceDir)
                && Objects.equals(this.envs, appComponentBase.envs)
                && Objects.equals(this.environmentSlug, appComponentBase.environmentSlug)
                && Objects.equals(this.logDestinations, appComponentBase.logDestinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, git, github, gitlab, image, dockerfilePath, buildCommand, runCommand, sourceDir, envs,
                environmentSlug, logDestinations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppComponentBase {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    git: ").append(toIndentedString(git)).append("\n");
        sb.append("    github: ").append(toIndentedString(github)).append("\n");
        sb.append("    gitlab: ").append(toIndentedString(gitlab)).append("\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
        sb.append("    dockerfilePath: ").append(toIndentedString(dockerfilePath)).append("\n");
        sb.append("    buildCommand: ").append(toIndentedString(buildCommand)).append("\n");
        sb.append("    runCommand: ").append(toIndentedString(runCommand)).append("\n");
        sb.append("    sourceDir: ").append(toIndentedString(sourceDir)).append("\n");
        sb.append("    envs: ").append(toIndentedString(envs)).append("\n");
        sb.append("    environmentSlug: ").append(toIndentedString(environmentSlug)).append("\n");
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