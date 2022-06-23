package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsDomain
 */
@JsonPropertyOrder({ AppsDomain.JSON_PROPERTY_ID, AppsDomain.JSON_PROPERTY_PHASE, AppsDomain.JSON_PROPERTY_PROGRESS,
        AppsDomain.JSON_PROPERTY_SPEC })
public class AppsDomain {
    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_PHASE = "phase";
    private AppsDomainPhase phase = AppsDomainPhase.UNKNOWN;

    public static final String JSON_PROPERTY_PROGRESS = "progress";
    private AppsDomainProgress progress;

    public static final String JSON_PROPERTY_SPEC = "spec";
    private AppDomainSpec spec;

    public AppsDomain() {
    }

    public AppsDomain id(String id) {
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

    public AppsDomain phase(AppsDomainPhase phase) {
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

    public AppsDomainPhase getPhase() {
        return phase;
    }

    @JsonProperty(JSON_PROPERTY_PHASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPhase(AppsDomainPhase phase) {
        this.phase = phase;
    }

    public AppsDomain progress(AppsDomainProgress progress) {
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

    public AppsDomainProgress getProgress() {
        return progress;
    }

    @JsonProperty(JSON_PROPERTY_PROGRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProgress(AppsDomainProgress progress) {
        this.progress = progress;
    }

    public AppsDomain spec(AppDomainSpec spec) {
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

    public AppDomainSpec getSpec() {
        return spec;
    }

    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSpec(AppDomainSpec spec) {
        this.spec = spec;
    }

    /**
     * Return true if this apps_domain object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsDomain appsDomain = (AppsDomain) o;
        return Objects.equals(this.id, appsDomain.id) && Objects.equals(this.phase, appsDomain.phase)
                && Objects.equals(this.progress, appsDomain.progress) && Objects.equals(this.spec, appsDomain.spec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phase, progress, spec);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsDomain {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    phase: ").append(toIndentedString(phase)).append("\n");
        sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
        sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
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