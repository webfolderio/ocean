package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * SshKey
 */
@JsonPropertyOrder({ SshKey.JSON_PROPERTY_ID, SshKey.JSON_PROPERTY_FINGERPRINT, SshKey.JSON_PROPERTY_PUBLIC_KEY,
        SshKey.JSON_PROPERTY_NAME })
public class SshKey {
    public static final String JSON_PROPERTY_ID = "id";
    private Integer id;

    public static final String JSON_PROPERTY_FINGERPRINT = "fingerprint";
    private String fingerprint;

    public static final String JSON_PROPERTY_PUBLIC_KEY = "public_key";
    private String publicKey;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public SshKey() {
    }

    @JsonCreator
    public SshKey(@JsonProperty(JSON_PROPERTY_ID) Integer id,
            @JsonProperty(JSON_PROPERTY_FINGERPRINT) String fingerprint) {
        this();
        this.id = id;
        this.fingerprint = fingerprint;
    }

    /**
     * A unique identification number for this key. Can be used to embed a specific
     * SSH key into a Droplet.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getId() {
        return id;
    }

    /**
     * A unique identifier that differentiates this key from other keys using a
     * format that SSH recognizes. The fingerprint is created when the key is added
     * to your account.
     *
     * @return fingerprint
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FINGERPRINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getFingerprint() {
        return fingerprint;
    }

    public SshKey publicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    /**
     * The entire public key string that was uploaded. Embedded into the root
     * user&#39;s &#x60;authorized_keys&#x60; file if you include this key during
     * Droplet creation.
     *
     * @return publicKey
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PUBLIC_KEY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getPublicKey() {
        return publicKey;
    }

    @JsonProperty(JSON_PROPERTY_PUBLIC_KEY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public SshKey name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A human-readable display name for this key, used to easily identify the SSH
     * keys when they are displayed.
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return true if this ssh_key object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SshKey sshKey = (SshKey) o;
        return Objects.equals(this.id, sshKey.id) && Objects.equals(this.fingerprint, sshKey.fingerprint)
                && Objects.equals(this.publicKey, sshKey.publicKey) && Objects.equals(this.name, sshKey.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fingerprint, publicKey, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SshKey {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    fingerprint: ").append(toIndentedString(fingerprint)).append("\n");
        sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
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