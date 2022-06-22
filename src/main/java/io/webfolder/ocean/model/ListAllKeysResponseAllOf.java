package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * ListAllKeysResponseAllOf
 */
@JsonPropertyOrder({ ListAllKeysResponseAllOf.JSON_PROPERTY_SSH_KEYS })
public class ListAllKeysResponseAllOf {
    public static final String JSON_PROPERTY_SSH_KEYS = "ssh_keys";
    private List<SshKey> sshKeys = null;

    public ListAllKeysResponseAllOf() {
    }

    public ListAllKeysResponseAllOf sshKeys(List<SshKey> sshKeys) {
        this.sshKeys = sshKeys;
        return this;
    }

    public ListAllKeysResponseAllOf addSshKeysItem(SshKey sshKeysItem) {
        if (this.sshKeys == null) {
            this.sshKeys = new ArrayList<>();
        }
        this.sshKeys.add(sshKeysItem);
        return this;
    }

    /**
     * Get sshKeys
     *
     * @return sshKeys
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_SSH_KEYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<SshKey> getSshKeys() {
        return sshKeys;
    }

    @JsonProperty(JSON_PROPERTY_SSH_KEYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSshKeys(List<SshKey> sshKeys) {
        this.sshKeys = sshKeys;
    }

    /**
     * Return true if this list_all_keys_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllKeysResponseAllOf listAllKeysResponseAllOf = (ListAllKeysResponseAllOf) o;
        return Objects.equals(this.sshKeys, listAllKeysResponseAllOf.sshKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sshKeys);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllKeysResponseAllOf {\n");
        sb.append("    sshKeys: ").append(toIndentedString(sshKeys)).append("\n");
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
