package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppStaticSiteSpec
 */
@JsonPropertyOrder({ AppStaticSiteSpec.JSON_PROPERTY_NAME, AppStaticSiteSpec.JSON_PROPERTY_GIT,
        AppStaticSiteSpec.JSON_PROPERTY_GITHUB, AppStaticSiteSpec.JSON_PROPERTY_GITLAB,
        AppStaticSiteSpec.JSON_PROPERTY_IMAGE, AppStaticSiteSpec.JSON_PROPERTY_DOCKERFILE_PATH,
        AppStaticSiteSpec.JSON_PROPERTY_BUILD_COMMAND, AppStaticSiteSpec.JSON_PROPERTY_RUN_COMMAND,
        AppStaticSiteSpec.JSON_PROPERTY_SOURCE_DIR, AppStaticSiteSpec.JSON_PROPERTY_ENVS,
        AppStaticSiteSpec.JSON_PROPERTY_ENVIRONMENT_SLUG, AppStaticSiteSpec.JSON_PROPERTY_LOG_DESTINATIONS,
        AppStaticSiteSpec.JSON_PROPERTY_INDEX_DOCUMENT, AppStaticSiteSpec.JSON_PROPERTY_ERROR_DOCUMENT,
        AppStaticSiteSpec.JSON_PROPERTY_CATCHALL_DOCUMENT, AppStaticSiteSpec.JSON_PROPERTY_OUTPUT_DIR,
        AppStaticSiteSpec.JSON_PROPERTY_CORS, AppStaticSiteSpec.JSON_PROPERTY_ROUTES })
public class AppStaticSiteSpec {
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

    public static final String JSON_PROPERTY_INDEX_DOCUMENT = "index_document";
    private String indexDocument = "index.html";

    public static final String JSON_PROPERTY_ERROR_DOCUMENT = "error_document";
    private String errorDocument = "404.html";

    public static final String JSON_PROPERTY_CATCHALL_DOCUMENT = "catchall_document";
    private String catchallDocument;

    public static final String JSON_PROPERTY_OUTPUT_DIR = "output_dir";
    private String outputDir;

    public static final String JSON_PROPERTY_CORS = "cors";
    private AppsCorsPolicy cors;

    public static final String JSON_PROPERTY_ROUTES = "routes";
    private List<AppRouteSpec> routes = null;

    public AppStaticSiteSpec() {
    }

    public AppStaticSiteSpec name(String name) {
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

    public AppStaticSiteSpec git(AppsGitSourceSpec git) {
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

    public AppStaticSiteSpec github(AppsGithubSourceSpec github) {
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

    public AppStaticSiteSpec gitlab(AppsGitlabSourceSpec gitlab) {
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

    public AppStaticSiteSpec image(AppsImageSourceSpec image) {
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

    public AppStaticSiteSpec dockerfilePath(String dockerfilePath) {
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

    public AppStaticSiteSpec buildCommand(String buildCommand) {
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

    public AppStaticSiteSpec runCommand(String runCommand) {
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

    public AppStaticSiteSpec sourceDir(String sourceDir) {
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

    public AppStaticSiteSpec envs(List<AppVariableDefinition> envs) {
        this.envs = envs;
        return this;
    }

    public AppStaticSiteSpec addEnvsItem(AppVariableDefinition envsItem) {
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

    public AppStaticSiteSpec environmentSlug(String environmentSlug) {
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

    public AppStaticSiteSpec logDestinations(AppLogDestinationDefinition logDestinations) {
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

    public AppStaticSiteSpec indexDocument(String indexDocument) {
        this.indexDocument = indexDocument;
        return this;
    }

    /**
     * The name of the index document to use when serving this static site. Default:
     * index.html
     *
     * @return indexDocument
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INDEX_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIndexDocument() {
        return indexDocument;
    }

    @JsonProperty(JSON_PROPERTY_INDEX_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIndexDocument(String indexDocument) {
        this.indexDocument = indexDocument;
    }

    public AppStaticSiteSpec errorDocument(String errorDocument) {
        this.errorDocument = errorDocument;
        return this;
    }

    /**
     * The name of the error document to use when serving this static site. Default:
     * 404.html. If no such file exists within the built assets, App Platform will
     * supply one.
     *
     * @return errorDocument
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ERROR_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getErrorDocument() {
        return errorDocument;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setErrorDocument(String errorDocument) {
        this.errorDocument = errorDocument;
    }

    public AppStaticSiteSpec catchallDocument(String catchallDocument) {
        this.catchallDocument = catchallDocument;
        return this;
    }

    /**
     * The name of the document to use as the fallback for any requests to documents
     * that are not found when serving this static site. Only 1 of
     * &#x60;catchall_document&#x60; or &#x60;error_document&#x60; can be set.
     *
     * @return catchallDocument
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CATCHALL_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCatchallDocument() {
        return catchallDocument;
    }

    @JsonProperty(JSON_PROPERTY_CATCHALL_DOCUMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCatchallDocument(String catchallDocument) {
        this.catchallDocument = catchallDocument;
    }

    public AppStaticSiteSpec outputDir(String outputDir) {
        this.outputDir = outputDir;
        return this;
    }

    /**
     * An optional path to where the built assets will be located, relative to the
     * build context. If not set, App Platform will automatically scan for these
     * directory names: &#x60;_static&#x60;, &#x60;dist&#x60;, &#x60;public&#x60;,
     * &#x60;build&#x60;.
     *
     * @return outputDir
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OUTPUT_DIR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getOutputDir() {
        return outputDir;
    }

    @JsonProperty(JSON_PROPERTY_OUTPUT_DIR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public AppStaticSiteSpec cors(AppsCorsPolicy cors) {
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

    public AppStaticSiteSpec routes(List<AppRouteSpec> routes) {
        this.routes = routes;
        return this;
    }

    public AppStaticSiteSpec addRoutesItem(AppRouteSpec routesItem) {
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

    /**
     * Return true if this app_static_site_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppStaticSiteSpec appStaticSiteSpec = (AppStaticSiteSpec) o;
        return Objects.equals(this.name, appStaticSiteSpec.name) && Objects.equals(this.git, appStaticSiteSpec.git)
                && Objects.equals(this.github, appStaticSiteSpec.github)
                && Objects.equals(this.gitlab, appStaticSiteSpec.gitlab)
                && Objects.equals(this.image, appStaticSiteSpec.image)
                && Objects.equals(this.dockerfilePath, appStaticSiteSpec.dockerfilePath)
                && Objects.equals(this.buildCommand, appStaticSiteSpec.buildCommand)
                && Objects.equals(this.runCommand, appStaticSiteSpec.runCommand)
                && Objects.equals(this.sourceDir, appStaticSiteSpec.sourceDir)
                && Objects.equals(this.envs, appStaticSiteSpec.envs)
                && Objects.equals(this.environmentSlug, appStaticSiteSpec.environmentSlug)
                && Objects.equals(this.logDestinations, appStaticSiteSpec.logDestinations)
                && Objects.equals(this.indexDocument, appStaticSiteSpec.indexDocument)
                && Objects.equals(this.errorDocument, appStaticSiteSpec.errorDocument)
                && Objects.equals(this.catchallDocument, appStaticSiteSpec.catchallDocument)
                && Objects.equals(this.outputDir, appStaticSiteSpec.outputDir)
                && Objects.equals(this.cors, appStaticSiteSpec.cors)
                && Objects.equals(this.routes, appStaticSiteSpec.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, git, github, gitlab, image, dockerfilePath, buildCommand, runCommand, sourceDir, envs,
                environmentSlug, logDestinations, indexDocument, errorDocument, catchallDocument, outputDir, cors,
                routes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppStaticSiteSpec {\n");
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
        sb.append("    indexDocument: ").append(toIndentedString(indexDocument)).append("\n");
        sb.append("    errorDocument: ").append(toIndentedString(errorDocument)).append("\n");
        sb.append("    catchallDocument: ").append(toIndentedString(catchallDocument)).append("\n");
        sb.append("    outputDir: ").append(toIndentedString(outputDir)).append("\n");
        sb.append("    cors: ").append(toIndentedString(cors)).append("\n");
        sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
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