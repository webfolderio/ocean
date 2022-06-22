package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * UpdateSshKeyRequest
 */
@JsonPropertyOrder({ UpdateSshKeyRequest.JSON_PROPERTY_NAME })
public class UpdateSshKeyRequest {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public UpdateSshKeyRequest() {
    }

    public UpdateSshKeyRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A human-readable display name for this key, used to easily identify the SSH
     * keys when they are displayed.
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "My SSH Public Key", value = "A human-readable display name for this key, used to easily identify the SSH keys when they are displayed.")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return true if this update_ssh_key_request object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateSshKeyRequest updateSshKeyRequest = (UpdateSshKeyRequest) o;
        return Objects.equals(this.name, updateSshKeyRequest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateSshKeyRequest {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
