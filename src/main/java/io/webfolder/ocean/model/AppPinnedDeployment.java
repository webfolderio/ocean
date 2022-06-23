package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppPinnedDeployment
 */
@JsonPropertyOrder({ AppPinnedDeployment.JSON_PROPERTY_CAUSE, AppPinnedDeployment.JSON_PROPERTY_CLONED_FROM,
        AppPinnedDeployment.JSON_PROPERTY_CREATED_AT, AppPinnedDeployment.JSON_PROPERTY_ID,
        AppPinnedDeployment.JSON_PROPERTY_JOBS, AppPinnedDeployment.JSON_PROPERTY_FUNCTIONS,
        AppPinnedDeployment.JSON_PROPERTY_PHASE, AppPinnedDeployment.JSON_PROPERTY_PHASE_LAST_UPDATED_AT,
        AppPinnedDeployment.JSON_PROPERTY_PROGRESS, AppPinnedDeployment.JSON_PROPERTY_SERVICES,
        AppPinnedDeployment.JSON_PROPERTY_SPEC, AppPinnedDeployment.JSON_PROPERTY_STATIC_SITES,
        AppPinnedDeployment.JSON_PROPERTY_TIER_SLUG, AppPinnedDeployment.JSON_PROPERTY_UPDATED_AT,
        AppPinnedDeployment.JSON_PROPERTY_WORKERS })
public class AppPinnedDeployment {
    public static final String JSON_PROPERTY_CAUSE = "cause";
    private String cause;

    public static final String JSON_PROPERTY_CLONED_FROM = "cloned_from";
    private String clonedFrom;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_JOBS = "jobs";
    private List<AppsDeploymentJob> jobs = null;

    public static final String JSON_PROPERTY_FUNCTIONS = "functions";
    private List<AppsDeploymentFunctions> functions = null;

    public static final String JSON_PROPERTY_PHASE = "phase";
    private AppsDeploymentPhase phase = AppsDeploymentPhase.UNKNOWN;

    public static final String JSON_PROPERTY_PHASE_LAST_UPDATED_AT = "phase_last_updated_at";
    private OffsetDateTime phaseLastUpdatedAt;

    public static final String JSON_PROPERTY_PROGRESS = "progress";
    private AppsDeploymentProgress progress;

    public static final String JSON_PROPERTY_SERVICES = "services";
    private List<AppsDeploymentService> services = null;

    public static final String JSON_PROPERTY_SPEC = "spec";
    private AppSpec spec;

    public static final String JSON_PROPERTY_STATIC_SITES = "static_sites";
    private List<AppsDeploymentStaticSite> staticSites = null;

    public static final String JSON_PROPERTY_TIER_SLUG = "tier_slug";
    private String tierSlug;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private OffsetDateTime updatedAt;

    public static final String JSON_PROPERTY_WORKERS = "workers";
    private List<AppsDeploymentWorker> workers = null;

    public AppPinnedDeployment() {
    }

    @JsonCreator
    public AppPinnedDeployment(@JsonProperty(JSON_PROPERTY_TIER_SLUG) String tierSlug) {
        this();
        this.tierSlug = tierSlug;
    }

    public AppPinnedDeployment cause(String cause) {
        this.cause = cause;
        return this;
    }

    /**
     * Get cause
     *
     * @return cause
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CAUSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getCause() {
        return cause;
    }

    @JsonProperty(JSON_PROPERTY_CAUSE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCause(String cause) {
        this.cause = cause;
    }

    public AppPinnedDeployment clonedFrom(String clonedFrom) {
        this.clonedFrom = clonedFrom;
        return this;
    }

    /**
     * Get clonedFrom
     *
     * @return clonedFrom
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CLONED_FROM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getClonedFrom() {
        return clonedFrom;
    }

    @JsonProperty(JSON_PROPERTY_CLONED_FROM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setClonedFrom(String clonedFrom) {
        this.clonedFrom = clonedFrom;
    }

    public AppPinnedDeployment createdAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public AppPinnedDeployment id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(String id) {
        this.id = id;
    }

    public AppPinnedDeployment jobs(List<AppsDeploymentJob> jobs) {
        this.jobs = jobs;
        return this;
    }

    public AppPinnedDeployment addJobsItem(AppsDeploymentJob jobsItem) {
        if (this.jobs == null) {
            this.jobs = new ArrayList<>();
        }
        this.jobs.add(jobsItem);
        return this;
    }

    /**
     * Get jobs
     *
     * @return jobs
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_JOBS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppsDeploymentJob> getJobs() {
        return jobs;
    }

    @JsonProperty(JSON_PROPERTY_JOBS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setJobs(List<AppsDeploymentJob> jobs) {
        this.jobs = jobs;
    }

    public AppPinnedDeployment functions(List<AppsDeploymentFunctions> functions) {
        this.functions = functions;
        return this;
    }

    public AppPinnedDeployment addFunctionsItem(AppsDeploymentFunctions functionsItem) {
        if (this.functions == null) {
            this.functions = new ArrayList<>();
        }
        this.functions.add(functionsItem);
        return this;
    }

    /**
     * Get functions
     *
     * @return functions
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FUNCTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppsDeploymentFunctions> getFunctions() {
        return functions;
    }

    @JsonProperty(JSON_PROPERTY_FUNCTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFunctions(List<AppsDeploymentFunctions> functions) {
        this.functions = functions;
    }

    public AppPinnedDeployment phase(AppsDeploymentPhase phase) {
        this.phase = phase;
        return this;
    }

    /**
     * Get phase
     *
     * @return phase
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PHASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsDeploymentPhase getPhase() {
        return phase;
    }

    @JsonProperty(JSON_PROPERTY_PHASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPhase(AppsDeploymentPhase phase) {
        this.phase = phase;
    }

    public AppPinnedDeployment phaseLastUpdatedAt(OffsetDateTime phaseLastUpdatedAt) {
        this.phaseLastUpdatedAt = phaseLastUpdatedAt;
        return this;
    }

    /**
     * Get phaseLastUpdatedAt
     *
     * @return phaseLastUpdatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PHASE_LAST_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getPhaseLastUpdatedAt() {
        return phaseLastUpdatedAt;
    }

    @JsonProperty(JSON_PROPERTY_PHASE_LAST_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPhaseLastUpdatedAt(OffsetDateTime phaseLastUpdatedAt) {
        this.phaseLastUpdatedAt = phaseLastUpdatedAt;
    }

    public AppPinnedDeployment progress(AppsDeploymentProgress progress) {
        this.progress = progress;
        return this;
    }

    /**
     * Get progress
     *
     * @return progress
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROGRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsDeploymentProgress getProgress() {
        return progress;
    }

    @JsonProperty(JSON_PROPERTY_PROGRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProgress(AppsDeploymentProgress progress) {
        this.progress = progress;
    }

    public AppPinnedDeployment services(List<AppsDeploymentService> services) {
        this.services = services;
        return this;
    }

    public AppPinnedDeployment addServicesItem(AppsDeploymentService servicesItem) {
        if (this.services == null) {
            this.services = new ArrayList<>();
        }
        this.services.add(servicesItem);
        return this;
    }

    /**
     * Get services
     *
     * @return services
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SERVICES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppsDeploymentService> getServices() {
        return services;
    }

    @JsonProperty(JSON_PROPERTY_SERVICES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setServices(List<AppsDeploymentService> services) {
        this.services = services;
    }

    public AppPinnedDeployment spec(AppSpec spec) {
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

    public AppPinnedDeployment staticSites(List<AppsDeploymentStaticSite> staticSites) {
        this.staticSites = staticSites;
        return this;
    }

    public AppPinnedDeployment addStaticSitesItem(AppsDeploymentStaticSite staticSitesItem) {
        if (this.staticSites == null) {
            this.staticSites = new ArrayList<>();
        }
        this.staticSites.add(staticSitesItem);
        return this;
    }

    /**
     * Get staticSites
     *
     * @return staticSites
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATIC_SITES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppsDeploymentStaticSite> getStaticSites() {
        return staticSites;
    }

    @JsonProperty(JSON_PROPERTY_STATIC_SITES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStaticSites(List<AppsDeploymentStaticSite> staticSites) {
        this.staticSites = staticSites;
    }

    /**
     * Get tierSlug
     *
     * @return tierSlug
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TIER_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTierSlug() {
        return tierSlug;
    }

    public AppPinnedDeployment updatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get updatedAt
     *
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AppPinnedDeployment workers(List<AppsDeploymentWorker> workers) {
        this.workers = workers;
        return this;
    }

    public AppPinnedDeployment addWorkersItem(AppsDeploymentWorker workersItem) {
        if (this.workers == null) {
            this.workers = new ArrayList<>();
        }
        this.workers.add(workersItem);
        return this;
    }

    /**
     * Get workers
     *
     * @return workers
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WORKERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppsDeploymentWorker> getWorkers() {
        return workers;
    }

    @JsonProperty(JSON_PROPERTY_WORKERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWorkers(List<AppsDeploymentWorker> workers) {
        this.workers = workers;
    }

    /**
     * Return true if this app_pinned_deployment object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppPinnedDeployment appPinnedDeployment = (AppPinnedDeployment) o;
        return Objects.equals(this.cause, appPinnedDeployment.cause)
                && Objects.equals(this.clonedFrom, appPinnedDeployment.clonedFrom)
                && Objects.equals(this.createdAt, appPinnedDeployment.createdAt)
                && Objects.equals(this.id, appPinnedDeployment.id)
                && Objects.equals(this.jobs, appPinnedDeployment.jobs)
                && Objects.equals(this.functions, appPinnedDeployment.functions)
                && Objects.equals(this.phase, appPinnedDeployment.phase)
                && Objects.equals(this.phaseLastUpdatedAt, appPinnedDeployment.phaseLastUpdatedAt)
                && Objects.equals(this.progress, appPinnedDeployment.progress)
                && Objects.equals(this.services, appPinnedDeployment.services)
                && Objects.equals(this.spec, appPinnedDeployment.spec)
                && Objects.equals(this.staticSites, appPinnedDeployment.staticSites)
                && Objects.equals(this.tierSlug, appPinnedDeployment.tierSlug)
                && Objects.equals(this.updatedAt, appPinnedDeployment.updatedAt)
                && Objects.equals(this.workers, appPinnedDeployment.workers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cause, clonedFrom, createdAt, id, jobs, functions, phase, phaseLastUpdatedAt, progress,
                services, spec, staticSites, tierSlug, updatedAt, workers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppPinnedDeployment {\n");
        sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
        sb.append("    clonedFrom: ").append(toIndentedString(clonedFrom)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    jobs: ").append(toIndentedString(jobs)).append("\n");
        sb.append("    functions: ").append(toIndentedString(functions)).append("\n");
        sb.append("    phase: ").append(toIndentedString(phase)).append("\n");
        sb.append("    phaseLastUpdatedAt: ").append(toIndentedString(phaseLastUpdatedAt)).append("\n");
        sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
        sb.append("    services: ").append(toIndentedString(services)).append("\n");
        sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
        sb.append("    staticSites: ").append(toIndentedString(staticSites)).append("\n");
        sb.append("    tierSlug: ").append(toIndentedString(tierSlug)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    workers: ").append(toIndentedString(workers)).append("\n");
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