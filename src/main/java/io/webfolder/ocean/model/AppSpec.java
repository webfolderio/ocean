package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The desired configuration of an application.
 */
@JsonPropertyOrder({ AppSpec.JSON_PROPERTY_NAME, AppSpec.JSON_PROPERTY_REGION, AppSpec.JSON_PROPERTY_DOMAINS,
        AppSpec.JSON_PROPERTY_SERVICES, AppSpec.JSON_PROPERTY_STATIC_SITES, AppSpec.JSON_PROPERTY_JOBS,
        AppSpec.JSON_PROPERTY_WORKERS, AppSpec.JSON_PROPERTY_FUNCTIONS, AppSpec.JSON_PROPERTY_DATABASES })
public class AppSpec {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    /**
     * The slug form of the geographical origin of the app. Default: &#x60;nearest
     * available&#x60;
     */
    public enum RegionEnum {
        AMS("ams"),

        NYC("nyc"),

        FRA("fra");

        private String value;

        RegionEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static RegionEnum fromValue(String value) {
            for (RegionEnum b : RegionEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_REGION = "region";
    private RegionEnum region;

    public static final String JSON_PROPERTY_DOMAINS = "domains";
    private List<AppDomainSpec> domains = null;

    public static final String JSON_PROPERTY_SERVICES = "services";
    private List<AppServiceSpec> services = null;

    public static final String JSON_PROPERTY_STATIC_SITES = "static_sites";
    private List<AppStaticSiteSpec> staticSites = null;

    public static final String JSON_PROPERTY_JOBS = "jobs";
    private List<AppJobSpec> jobs = null;

    public static final String JSON_PROPERTY_WORKERS = "workers";
    private List<AppWorkerSpec> workers = null;

    public static final String JSON_PROPERTY_FUNCTIONS = "functions";
    private List<AppFunctionsSpec> functions = null;

    public static final String JSON_PROPERTY_DATABASES = "databases";
    private List<AppDatabaseSpec> databases = null;

    public AppSpec() {
    }

    public AppSpec name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the app. Must be unique across all apps in the same account.
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

    public AppSpec region(RegionEnum region) {
        this.region = region;
        return this;
    }

    /**
     * The slug form of the geographical origin of the app. Default: &#x60;nearest
     * available&#x60;
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public RegionEnum getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(RegionEnum region) {
        this.region = region;
    }

    public AppSpec domains(List<AppDomainSpec> domains) {
        this.domains = domains;
        return this;
    }

    public AppSpec addDomainsItem(AppDomainSpec domainsItem) {
        if (this.domains == null) {
            this.domains = new ArrayList<>();
        }
        this.domains.add(domainsItem);
        return this;
    }

    /**
     * A set of hostnames where the application will be available.
     *
     * @return domains
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DOMAINS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<AppDomainSpec> getDomains() {
        return domains;
    }

    @JsonProperty(JSON_PROPERTY_DOMAINS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDomains(List<AppDomainSpec> domains) {
        this.domains = domains;
    }

    public AppSpec services(List<AppServiceSpec> services) {
        this.services = services;
        return this;
    }

    public AppSpec addServicesItem(AppServiceSpec servicesItem) {
        if (this.services == null) {
            this.services = new ArrayList<>();
        }
        this.services.add(servicesItem);
        return this;
    }

    /**
     * Workloads which expose publicly-accessible HTTP services.
     *
     * @return services
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SERVICES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppServiceSpec> getServices() {
        return services;
    }

    @JsonProperty(JSON_PROPERTY_SERVICES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setServices(List<AppServiceSpec> services) {
        this.services = services;
    }

    public AppSpec staticSites(List<AppStaticSiteSpec> staticSites) {
        this.staticSites = staticSites;
        return this;
    }

    public AppSpec addStaticSitesItem(AppStaticSiteSpec staticSitesItem) {
        if (this.staticSites == null) {
            this.staticSites = new ArrayList<>();
        }
        this.staticSites.add(staticSitesItem);
        return this;
    }

    /**
     * Content which can be rendered to static web assets.
     *
     * @return staticSites
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATIC_SITES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppStaticSiteSpec> getStaticSites() {
        return staticSites;
    }

    @JsonProperty(JSON_PROPERTY_STATIC_SITES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStaticSites(List<AppStaticSiteSpec> staticSites) {
        this.staticSites = staticSites;
    }

    public AppSpec jobs(List<AppJobSpec> jobs) {
        this.jobs = jobs;
        return this;
    }

    public AppSpec addJobsItem(AppJobSpec jobsItem) {
        if (this.jobs == null) {
            this.jobs = new ArrayList<>();
        }
        this.jobs.add(jobsItem);
        return this;
    }

    /**
     * Pre and post deployment workloads which do not expose publicly-accessible
     * HTTP routes.
     *
     * @return jobs
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_JOBS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppJobSpec> getJobs() {
        return jobs;
    }

    @JsonProperty(JSON_PROPERTY_JOBS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setJobs(List<AppJobSpec> jobs) {
        this.jobs = jobs;
    }

    public AppSpec workers(List<AppWorkerSpec> workers) {
        this.workers = workers;
        return this;
    }

    public AppSpec addWorkersItem(AppWorkerSpec workersItem) {
        if (this.workers == null) {
            this.workers = new ArrayList<>();
        }
        this.workers.add(workersItem);
        return this;
    }

    /**
     * Workloads which do not expose publicly-accessible HTTP services.
     *
     * @return workers
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WORKERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppWorkerSpec> getWorkers() {
        return workers;
    }

    @JsonProperty(JSON_PROPERTY_WORKERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWorkers(List<AppWorkerSpec> workers) {
        this.workers = workers;
    }

    public AppSpec functions(List<AppFunctionsSpec> functions) {
        this.functions = functions;
        return this;
    }

    public AppSpec addFunctionsItem(AppFunctionsSpec functionsItem) {
        if (this.functions == null) {
            this.functions = new ArrayList<>();
        }
        this.functions.add(functionsItem);
        return this;
    }

    /**
     * Workloads which expose publicly-accessible HTTP services via Functions
     * Components.
     *
     * @return functions
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FUNCTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppFunctionsSpec> getFunctions() {
        return functions;
    }

    @JsonProperty(JSON_PROPERTY_FUNCTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFunctions(List<AppFunctionsSpec> functions) {
        this.functions = functions;
    }

    public AppSpec databases(List<AppDatabaseSpec> databases) {
        this.databases = databases;
        return this;
    }

    public AppSpec addDatabasesItem(AppDatabaseSpec databasesItem) {
        if (this.databases == null) {
            this.databases = new ArrayList<>();
        }
        this.databases.add(databasesItem);
        return this;
    }

    /**
     * Database instances which can provide persistence to workloads within the
     * application.
     *
     * @return databases
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DATABASES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppDatabaseSpec> getDatabases() {
        return databases;
    }

    @JsonProperty(JSON_PROPERTY_DATABASES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDatabases(List<AppDatabaseSpec> databases) {
        this.databases = databases;
    }

    /**
     * Return true if this app_spec object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppSpec appSpec = (AppSpec) o;
        return Objects.equals(this.name, appSpec.name) && Objects.equals(this.region, appSpec.region)
                && Objects.equals(this.domains, appSpec.domains) && Objects.equals(this.services, appSpec.services)
                && Objects.equals(this.staticSites, appSpec.staticSites) && Objects.equals(this.jobs, appSpec.jobs)
                && Objects.equals(this.workers, appSpec.workers) && Objects.equals(this.functions, appSpec.functions)
                && Objects.equals(this.databases, appSpec.databases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, domains, services, staticSites, jobs, workers, functions, databases);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppSpec {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    domains: ").append(toIndentedString(domains)).append("\n");
        sb.append("    services: ").append(toIndentedString(services)).append("\n");
        sb.append("    staticSites: ").append(toIndentedString(staticSites)).append("\n");
        sb.append("    jobs: ").append(toIndentedString(jobs)).append("\n");
        sb.append("    workers: ").append(toIndentedString(workers)).append("\n");
        sb.append("    functions: ").append(toIndentedString(functions)).append("\n");
        sb.append("    databases: ").append(toIndentedString(databases)).append("\n");
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