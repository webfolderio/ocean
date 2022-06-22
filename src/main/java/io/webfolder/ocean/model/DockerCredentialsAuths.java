package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * DockerCredentialsAuths
 */
@JsonPropertyOrder({ DockerCredentialsAuths.JSON_PROPERTY_REGISTRY_DIGITALOCEAN_COM })
public class DockerCredentialsAuths {
    public static final String JSON_PROPERTY_REGISTRY_DIGITALOCEAN_COM = "registry.digitalocean.com";
    private DockerCredentialsAuthsRegistryDigitaloceanCom registryDigitaloceanCom;

    public DockerCredentialsAuths() {
    }

    public DockerCredentialsAuths registryDigitaloceanCom(
            DockerCredentialsAuthsRegistryDigitaloceanCom registryDigitaloceanCom) {
        this.registryDigitaloceanCom = registryDigitaloceanCom;
        return this;
    }

    /**
     * Get registryDigitaloceanCom
     *
     * @return registryDigitaloceanCom
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_REGISTRY_DIGITALOCEAN_COM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public DockerCredentialsAuthsRegistryDigitaloceanCom getRegistryDigitaloceanCom() {
        return registryDigitaloceanCom;
    }

    @JsonProperty(JSON_PROPERTY_REGISTRY_DIGITALOCEAN_COM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegistryDigitaloceanCom(DockerCredentialsAuthsRegistryDigitaloceanCom registryDigitaloceanCom) {
        this.registryDigitaloceanCom = registryDigitaloceanCom;
    }

    /**
     * Return true if this docker_credentials_auths object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DockerCredentialsAuths dockerCredentialsAuths = (DockerCredentialsAuths) o;
        return Objects.equals(this.registryDigitaloceanCom, dockerCredentialsAuths.registryDigitaloceanCom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registryDigitaloceanCom);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DockerCredentialsAuths {\n");
        sb.append("    registryDigitaloceanCom: ").append(toIndentedString(registryDigitaloceanCom)).append("\n");
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
