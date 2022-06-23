package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ClusterlintRequest
 */
@JsonPropertyOrder({ ClusterlintRequest.JSON_PROPERTY_INCLUDE_GROUPS, ClusterlintRequest.JSON_PROPERTY_INCLUDE_CHECKS,
        ClusterlintRequest.JSON_PROPERTY_EXCLUDE_GROUPS, ClusterlintRequest.JSON_PROPERTY_EXCLUDE_CHECKS })
public class ClusterlintRequest {
    public static final String JSON_PROPERTY_INCLUDE_GROUPS = "include_groups";
    private List<String> includeGroups = null;

    public static final String JSON_PROPERTY_INCLUDE_CHECKS = "include_checks";
    private List<String> includeChecks = null;

    public static final String JSON_PROPERTY_EXCLUDE_GROUPS = "exclude_groups";
    private List<String> excludeGroups = null;

    public static final String JSON_PROPERTY_EXCLUDE_CHECKS = "exclude_checks";
    private List<String> excludeChecks = null;

    public ClusterlintRequest() {
    }

    public ClusterlintRequest includeGroups(List<String> includeGroups) {
        this.includeGroups = includeGroups;
        return this;
    }

    public ClusterlintRequest addIncludeGroupsItem(String includeGroupsItem) {
        if (this.includeGroups == null) {
            this.includeGroups = new ArrayList<>();
        }
        this.includeGroups.add(includeGroupsItem);
        return this;
    }

    /**
     * An array of check groups that will be run when clusterlint executes checks.
     *
     * @return includeGroups
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INCLUDE_GROUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getIncludeGroups() {
        return includeGroups;
    }

    @JsonProperty(JSON_PROPERTY_INCLUDE_GROUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIncludeGroups(List<String> includeGroups) {
        this.includeGroups = includeGroups;
    }

    public ClusterlintRequest includeChecks(List<String> includeChecks) {
        this.includeChecks = includeChecks;
        return this;
    }

    public ClusterlintRequest addIncludeChecksItem(String includeChecksItem) {
        if (this.includeChecks == null) {
            this.includeChecks = new ArrayList<>();
        }
        this.includeChecks.add(includeChecksItem);
        return this;
    }

    /**
     * An array of checks that will be run when clusterlint executes checks.
     *
     * @return includeChecks
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INCLUDE_CHECKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getIncludeChecks() {
        return includeChecks;
    }

    @JsonProperty(JSON_PROPERTY_INCLUDE_CHECKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIncludeChecks(List<String> includeChecks) {
        this.includeChecks = includeChecks;
    }

    public ClusterlintRequest excludeGroups(List<String> excludeGroups) {
        this.excludeGroups = excludeGroups;
        return this;
    }

    public ClusterlintRequest addExcludeGroupsItem(String excludeGroupsItem) {
        if (this.excludeGroups == null) {
            this.excludeGroups = new ArrayList<>();
        }
        this.excludeGroups.add(excludeGroupsItem);
        return this;
    }

    /**
     * An array of check groups that will be omitted when clusterlint executes
     * checks.
     *
     * @return excludeGroups
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXCLUDE_GROUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getExcludeGroups() {
        return excludeGroups;
    }

    @JsonProperty(JSON_PROPERTY_EXCLUDE_GROUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExcludeGroups(List<String> excludeGroups) {
        this.excludeGroups = excludeGroups;
    }

    public ClusterlintRequest excludeChecks(List<String> excludeChecks) {
        this.excludeChecks = excludeChecks;
        return this;
    }

    public ClusterlintRequest addExcludeChecksItem(String excludeChecksItem) {
        if (this.excludeChecks == null) {
            this.excludeChecks = new ArrayList<>();
        }
        this.excludeChecks.add(excludeChecksItem);
        return this;
    }

    /**
     * An array of checks that will be run when clusterlint executes checks.
     *
     * @return excludeChecks
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXCLUDE_CHECKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getExcludeChecks() {
        return excludeChecks;
    }

    @JsonProperty(JSON_PROPERTY_EXCLUDE_CHECKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExcludeChecks(List<String> excludeChecks) {
        this.excludeChecks = excludeChecks;
    }

    /**
     * Return true if this clusterlint_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClusterlintRequest clusterlintRequest = (ClusterlintRequest) o;
        return Objects.equals(this.includeGroups, clusterlintRequest.includeGroups)
                && Objects.equals(this.includeChecks, clusterlintRequest.includeChecks)
                && Objects.equals(this.excludeGroups, clusterlintRequest.excludeGroups)
                && Objects.equals(this.excludeChecks, clusterlintRequest.excludeChecks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(includeGroups, includeChecks, excludeGroups, excludeChecks);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClusterlintRequest {\n");
        sb.append("    includeGroups: ").append(toIndentedString(includeGroups)).append("\n");
        sb.append("    includeChecks: ").append(toIndentedString(includeChecks)).append("\n");
        sb.append("    excludeGroups: ").append(toIndentedString(excludeGroups)).append("\n");
        sb.append("    excludeChecks: ").append(toIndentedString(excludeChecks)).append("\n");
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