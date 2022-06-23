package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DockerCredentials
 */
@JsonPropertyOrder({ DockerCredentials.JSON_PROPERTY_AUTHS })
public class DockerCredentials {
    public static final String JSON_PROPERTY_AUTHS = "auths";
    private DockerCredentialsAuths auths;

    public DockerCredentials() {
    }

    public DockerCredentials auths(DockerCredentialsAuths auths) {
        this.auths = auths;
        return this;
    }

    /**
     * Get auths
     *
     * @return auths
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTHS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public DockerCredentialsAuths getAuths() {
        return auths;
    }

    @JsonProperty(JSON_PROPERTY_AUTHS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAuths(DockerCredentialsAuths auths) {
        this.auths = auths;
    }

    /**
     * Return true if this docker_credentials object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DockerCredentials dockerCredentials = (DockerCredentials) o;
        return Objects.equals(this.auths, dockerCredentials.auths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auths);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DockerCredentials {\n");
        sb.append("    auths: ").append(toIndentedString(auths)).append("\n");
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