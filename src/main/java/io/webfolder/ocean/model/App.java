package io.webfolder.ocean.model;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An application&#39;s configuration and status.
 */
@ApiModel(description = "An application's configuration and status.")
@JsonPropertyOrder({ App.JSON_PROPERTY_ACTIVE_DEPLOYMENT, App.JSON_PROPERTY_CREATED_AT,
        App.JSON_PROPERTY_DEFAULT_INGRESS, App.JSON_PROPERTY_DOMAINS, App.JSON_PROPERTY_ID,
        App.JSON_PROPERTY_IN_PROGRESS_DEPLOYMENT, App.JSON_PROPERTY_LAST_DEPLOYMENT_CREATED_AT,
        App.JSON_PROPERTY_LIVE_DOMAIN, App.JSON_PROPERTY_LIVE_URL, App.JSON_PROPERTY_LIVE_URL_BASE,
        App.JSON_PROPERTY_OWNER_UUID, App.JSON_PROPERTY_REGION, App.JSON_PROPERTY_SPEC, App.JSON_PROPERTY_TIER_SLUG,
        App.JSON_PROPERTY_UPDATED_AT, App.JSON_PROPERTY_PINNED_DEPLOYMENT })
public class App {
    public static final String JSON_PROPERTY_ACTIVE_DEPLOYMENT = "active_deployment";
    private AppsDeployment activeDeployment;

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    private OffsetDateTime createdAt;

    public static final String JSON_PROPERTY_DEFAULT_INGRESS = "default_ingress";
    private String defaultIngress;

    public static final String JSON_PROPERTY_DOMAINS = "domains";
    private List<AppsDomain> domains = null;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_IN_PROGRESS_DEPLOYMENT = "in_progress_deployment";
    private AppsDeployment inProgressDeployment;

    public static final String JSON_PROPERTY_LAST_DEPLOYMENT_CREATED_AT = "last_deployment_created_at";
    private OffsetDateTime lastDeploymentCreatedAt;

    public static final String JSON_PROPERTY_LIVE_DOMAIN = "live_domain";
    private String liveDomain;

    public static final String JSON_PROPERTY_LIVE_URL = "live_url";
    private String liveUrl;

    public static final String JSON_PROPERTY_LIVE_URL_BASE = "live_url_base";
    private String liveUrlBase;

    public static final String JSON_PROPERTY_OWNER_UUID = "owner_uuid";
    private String ownerUuid;

    public static final String JSON_PROPERTY_REGION = "region";
    private AppsRegion region;

    public static final String JSON_PROPERTY_SPEC = "spec";
    private AppSpec spec;

    public static final String JSON_PROPERTY_TIER_SLUG = "tier_slug";
    private String tierSlug;

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    private OffsetDateTime updatedAt;

    public static final String JSON_PROPERTY_PINNED_DEPLOYMENT = "pinned_deployment";
    private AppPinnedDeployment pinnedDeployment;

    public App() {
    }

    @JsonCreator
    public App(@JsonProperty(JSON_PROPERTY_CREATED_AT) OffsetDateTime createdAt,
            @JsonProperty(JSON_PROPERTY_DEFAULT_INGRESS) String defaultIngress,
            @JsonProperty(JSON_PROPERTY_DOMAINS) List<AppsDomain> domains, @JsonProperty(JSON_PROPERTY_ID) String id,
            @JsonProperty(JSON_PROPERTY_LAST_DEPLOYMENT_CREATED_AT) OffsetDateTime lastDeploymentCreatedAt,
            @JsonProperty(JSON_PROPERTY_LIVE_DOMAIN) String liveDomain,
            @JsonProperty(JSON_PROPERTY_LIVE_URL) String liveUrl,
            @JsonProperty(JSON_PROPERTY_LIVE_URL_BASE) String liveUrlBase,
            @JsonProperty(JSON_PROPERTY_OWNER_UUID) String ownerUuid,
            @JsonProperty(JSON_PROPERTY_TIER_SLUG) String tierSlug,
            @JsonProperty(JSON_PROPERTY_UPDATED_AT) OffsetDateTime updatedAt) {
        this();
        this.createdAt = createdAt;
        this.defaultIngress = defaultIngress;
        this.domains = domains;
        this.id = id;
        this.lastDeploymentCreatedAt = lastDeploymentCreatedAt;
        this.liveDomain = liveDomain;
        this.liveUrl = liveUrl;
        this.liveUrlBase = liveUrlBase;
        this.ownerUuid = ownerUuid;
        this.tierSlug = tierSlug;
        this.updatedAt = updatedAt;
    }

    public App activeDeployment(AppsDeployment activeDeployment) {
        this.activeDeployment = activeDeployment;
        return this;
    }

    /**
     * Get activeDeployment
     *
     * @return activeDeployment
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ACTIVE_DEPLOYMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsDeployment getActiveDeployment() {
        return activeDeployment;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVE_DEPLOYMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActiveDeployment(AppsDeployment activeDeployment) {
        this.activeDeployment = activeDeployment;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2020-11-19T20:27:18Z", value = "")
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Get defaultIngress
     *
     * @return defaultIngress
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "digitalocean.com", value = "")
    @JsonProperty(JSON_PROPERTY_DEFAULT_INGRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDefaultIngress() {
        return defaultIngress;
    }

    /**
     * Get domains
     *
     * @return domains
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_DOMAINS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AppsDomain> getDomains() {
        return domains;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "4f6c71e2-1e90-4762-9fee-6cc4a0a9f2cf", value = "")
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getId() {
        return id;
    }

    public App inProgressDeployment(AppsDeployment inProgressDeployment) {
        this.inProgressDeployment = inProgressDeployment;
        return this;
    }

    /**
     * Get inProgressDeployment
     *
     * @return inProgressDeployment
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_IN_PROGRESS_DEPLOYMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsDeployment getInProgressDeployment() {
        return inProgressDeployment;
    }

    @JsonProperty(JSON_PROPERTY_IN_PROGRESS_DEPLOYMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInProgressDeployment(AppsDeployment inProgressDeployment) {
        this.inProgressDeployment = inProgressDeployment;
    }

    /**
     * Get lastDeploymentCreatedAt
     *
     * @return lastDeploymentCreatedAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2020-11-19T20:27:18Z", value = "")
    @JsonProperty(JSON_PROPERTY_LAST_DEPLOYMENT_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getLastDeploymentCreatedAt() {
        return lastDeploymentCreatedAt;
    }

    /**
     * Get liveDomain
     *
     * @return liveDomain
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "live_domain", value = "")
    @JsonProperty(JSON_PROPERTY_LIVE_DOMAIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLiveDomain() {
        return liveDomain;
    }

    /**
     * Get liveUrl
     *
     * @return liveUrl
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "google.com", value = "")
    @JsonProperty(JSON_PROPERTY_LIVE_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLiveUrl() {
        return liveUrl;
    }

    /**
     * Get liveUrlBase
     *
     * @return liveUrlBase
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "digitalocean.com", value = "")
    @JsonProperty(JSON_PROPERTY_LIVE_URL_BASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLiveUrlBase() {
        return liveUrlBase;
    }

    /**
     * Get ownerUuid
     *
     * @return ownerUuid
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "4f6c71e2-1e90-4762-9fee-6cc4a0a9f2cf", value = "")
    @JsonProperty(JSON_PROPERTY_OWNER_UUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getOwnerUuid() {
        return ownerUuid;
    }

    public App region(AppsRegion region) {
        this.region = region;
        return this;
    }

    /**
     * Get region
     *
     * @return region
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppsRegion getRegion() {
        return region;
    }

    @JsonProperty(JSON_PROPERTY_REGION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegion(AppsRegion region) {
        this.region = region;
    }

    public App spec(AppSpec spec) {
        this.spec = spec;
        return this;
    }

    /**
     * Get spec
     *
     * @return spec
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public AppSpec getSpec() {
        return spec;
    }

    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSpec(AppSpec spec) {
        this.spec = spec;
    }

    /**
     * Get tierSlug
     *
     * @return tierSlug
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "basic", value = "")
    @JsonProperty(JSON_PROPERTY_TIER_SLUG)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTierSlug() {
        return tierSlug;
    }

    /**
     * Get updatedAt
     *
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2020-12-01T00:42:16Z", value = "")
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public App pinnedDeployment(AppPinnedDeployment pinnedDeployment) {
        this.pinnedDeployment = pinnedDeployment;
        return this;
    }

    /**
     * Get pinnedDeployment
     *
     * @return pinnedDeployment
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_PINNED_DEPLOYMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppPinnedDeployment getPinnedDeployment() {
        return pinnedDeployment;
    }

    @JsonProperty(JSON_PROPERTY_PINNED_DEPLOYMENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPinnedDeployment(AppPinnedDeployment pinnedDeployment) {
        this.pinnedDeployment = pinnedDeployment;
    }

    /**
     * Return true if this app object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        App app = (App) o;
        return Objects.equals(this.activeDeployment, app.activeDeployment)
                && Objects.equals(this.createdAt, app.createdAt)
                && Objects.equals(this.defaultIngress, app.defaultIngress) && Objects.equals(this.domains, app.domains)
                && Objects.equals(this.id, app.id)
                && Objects.equals(this.inProgressDeployment, app.inProgressDeployment)
                && Objects.equals(this.lastDeploymentCreatedAt, app.lastDeploymentCreatedAt)
                && Objects.equals(this.liveDomain, app.liveDomain) && Objects.equals(this.liveUrl, app.liveUrl)
                && Objects.equals(this.liveUrlBase, app.liveUrlBase) && Objects.equals(this.ownerUuid, app.ownerUuid)
                && Objects.equals(this.region, app.region) && Objects.equals(this.spec, app.spec)
                && Objects.equals(this.tierSlug, app.tierSlug) && Objects.equals(this.updatedAt, app.updatedAt)
                && Objects.equals(this.pinnedDeployment, app.pinnedDeployment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activeDeployment, createdAt, defaultIngress, domains, id, inProgressDeployment,
                lastDeploymentCreatedAt, liveDomain, liveUrl, liveUrlBase, ownerUuid, region, spec, tierSlug, updatedAt,
                pinnedDeployment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class App {\n");
        sb.append("    activeDeployment: ").append(toIndentedString(activeDeployment)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    defaultIngress: ").append(toIndentedString(defaultIngress)).append("\n");
        sb.append("    domains: ").append(toIndentedString(domains)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    inProgressDeployment: ").append(toIndentedString(inProgressDeployment)).append("\n");
        sb.append("    lastDeploymentCreatedAt: ").append(toIndentedString(lastDeploymentCreatedAt)).append("\n");
        sb.append("    liveDomain: ").append(toIndentedString(liveDomain)).append("\n");
        sb.append("    liveUrl: ").append(toIndentedString(liveUrl)).append("\n");
        sb.append("    liveUrlBase: ").append(toIndentedString(liveUrlBase)).append("\n");
        sb.append("    ownerUuid: ").append(toIndentedString(ownerUuid)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
        sb.append("    tierSlug: ").append(toIndentedString(tierSlug)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    pinnedDeployment: ").append(toIndentedString(pinnedDeployment)).append("\n");
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
