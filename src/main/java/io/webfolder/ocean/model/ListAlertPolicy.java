package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAlertPolicy
 */
@JsonPropertyOrder({ ListAlertPolicy.JSON_PROPERTY_POLICIES })
public class ListAlertPolicy {
    public static final String JSON_PROPERTY_POLICIES = "policies";
    private List<AlertPolicy> policies = new ArrayList<>();

    public ListAlertPolicy() {
    }

    public ListAlertPolicy policies(List<AlertPolicy> policies) {
        this.policies = policies;
        return this;
    }

    public ListAlertPolicy addPoliciesItem(AlertPolicy policiesItem) {
        this.policies.add(policiesItem);
        return this;
    }

    /**
     * Get policies
     *
     * @return policies
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_POLICIES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<AlertPolicy> getPolicies() {
        return policies;
    }

    @JsonProperty(JSON_PROPERTY_POLICIES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPolicies(List<AlertPolicy> policies) {
        this.policies = policies;
    }

    /**
     * Return true if this list_alert_policy object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAlertPolicy listAlertPolicy = (ListAlertPolicy) o;
        return Objects.equals(this.policies, listAlertPolicy.policies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policies);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAlertPolicy {\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
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
