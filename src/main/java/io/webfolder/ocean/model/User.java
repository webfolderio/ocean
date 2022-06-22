package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * User
 */
@JsonPropertyOrder({ User.JSON_PROPERTY_KUBERNETES_CLUSTER_USER })
public class User {
    public static final String JSON_PROPERTY_KUBERNETES_CLUSTER_USER = "kubernetes_cluster_user";
    private UserKubernetesClusterUser kubernetesClusterUser;

    public User() {
    }

    public User kubernetesClusterUser(UserKubernetesClusterUser kubernetesClusterUser) {
        this.kubernetesClusterUser = kubernetesClusterUser;
        return this;
    }

    /**
     * Get kubernetesClusterUser
     *
     * @return kubernetesClusterUser
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_KUBERNETES_CLUSTER_USER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public UserKubernetesClusterUser getKubernetesClusterUser() {
        return kubernetesClusterUser;
    }

    @JsonProperty(JSON_PROPERTY_KUBERNETES_CLUSTER_USER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKubernetesClusterUser(UserKubernetesClusterUser kubernetesClusterUser) {
        this.kubernetesClusterUser = kubernetesClusterUser;
    }

    /**
     * Return true if this user object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.kubernetesClusterUser, user.kubernetesClusterUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kubernetesClusterUser);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");
        sb.append("    kubernetesClusterUser: ").append(toIndentedString(kubernetesClusterUser)).append("\n");
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
