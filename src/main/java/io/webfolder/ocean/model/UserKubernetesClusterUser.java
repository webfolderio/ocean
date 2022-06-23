package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * UserKubernetesClusterUser
 */
@JsonPropertyOrder({ UserKubernetesClusterUser.JSON_PROPERTY_USERNAME, UserKubernetesClusterUser.JSON_PROPERTY_GROUPS })
public class UserKubernetesClusterUser {
    public static final String JSON_PROPERTY_USERNAME = "username";
    private String username;

    public static final String JSON_PROPERTY_GROUPS = "groups";
    private List<String> groups = null;

    public UserKubernetesClusterUser() {
    }

    public UserKubernetesClusterUser username(String username) {
        this.username = username;
        return this;
    }

    /**
     * The username for the cluster admin user.
     *
     * @return username
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USERNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getUsername() {
        return username;
    }

    @JsonProperty(JSON_PROPERTY_USERNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUsername(String username) {
        this.username = username;
    }

    public UserKubernetesClusterUser groups(List<String> groups) {
        this.groups = groups;
        return this;
    }

    public UserKubernetesClusterUser addGroupsItem(String groupsItem) {
        if (this.groups == null) {
            this.groups = new ArrayList<>();
        }
        this.groups.add(groupsItem);
        return this;
    }

    /**
     * A list of in-cluster groups that the user belongs to.
     *
     * @return groups
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GROUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getGroups() {
        return groups;
    }

    @JsonProperty(JSON_PROPERTY_GROUPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * Return true if this user_kubernetes_cluster_user object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserKubernetesClusterUser userKubernetesClusterUser = (UserKubernetesClusterUser) o;
        return Objects.equals(this.username, userKubernetesClusterUser.username)
                && Objects.equals(this.groups, userKubernetesClusterUser.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, groups);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserKubernetesClusterUser {\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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