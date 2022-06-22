package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * DockerCredentialsAuthsRegistryDigitaloceanCom
 */
@JsonPropertyOrder({ DockerCredentialsAuthsRegistryDigitaloceanCom.JSON_PROPERTY_AUTH })
public class DockerCredentialsAuthsRegistryDigitaloceanCom {
    public static final String JSON_PROPERTY_AUTH = "auth";
    private String auth;

    public DockerCredentialsAuthsRegistryDigitaloceanCom() {
    }

    public DockerCredentialsAuthsRegistryDigitaloceanCom auth(String auth) {
        this.auth = auth;
        return this;
    }

    /**
     * A base64 encoded string containing credentials for the container registry.
     *
     * @return auth
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "YjdkMDNhNjk0N2IyMTdlZmI2ZjNlYzNiZDM1MDQ1ODI6YjdkMDNhNjk0N2IyMTdlZmI2ZjNlYzNiZDM1MDQ1ODIK", value = "A base64 encoded string containing credentials for the container registry.")
    @JsonProperty(JSON_PROPERTY_AUTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAuth() {
        return auth;
    }

    @JsonProperty(JSON_PROPERTY_AUTH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * Return true if this docker_credentials_auths_registry_digitalocean_com object
     * is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DockerCredentialsAuthsRegistryDigitaloceanCom dockerCredentialsAuthsRegistryDigitaloceanCom = (DockerCredentialsAuthsRegistryDigitaloceanCom) o;
        return Objects.equals(this.auth, dockerCredentialsAuthsRegistryDigitaloceanCom.auth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auth);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DockerCredentialsAuthsRegistryDigitaloceanCom {\n");
        sb.append("    auth: ").append(toIndentedString(auth)).append("\n");
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
