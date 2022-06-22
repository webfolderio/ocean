package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * CreateSshKeyResponse
 */
@JsonPropertyOrder({ CreateSshKeyResponse.JSON_PROPERTY_SSH_KEY })
public class CreateSshKeyResponse {
    public static final String JSON_PROPERTY_SSH_KEY = "ssh_key";
    private SshKey sshKey;

    public CreateSshKeyResponse() {
    }

    public CreateSshKeyResponse sshKey(SshKey sshKey) {
        this.sshKey = sshKey;
        return this;
    }

    /**
     * Get sshKey
     *
     * @return sshKey
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SSH_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public SshKey getSshKey() {
        return sshKey;
    }

    @JsonProperty(JSON_PROPERTY_SSH_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSshKey(SshKey sshKey) {
        this.sshKey = sshKey;
    }

    /**
     * Return true if this create_ssh_key_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateSshKeyResponse createSshKeyResponse = (CreateSshKeyResponse) o;
        return Objects.equals(this.sshKey, createSshKeyResponse.sshKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sshKey);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateSshKeyResponse {\n");
        sb.append("    sshKey: ").append(toIndentedString(sshKey)).append("\n");
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
