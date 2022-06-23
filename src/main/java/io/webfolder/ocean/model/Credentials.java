package io.webfolder.ocean.model;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Credentials
 */
@JsonPropertyOrder({ Credentials.JSON_PROPERTY_SERVER, Credentials.JSON_PROPERTY_CERTIFICATE_AUTHORITY_DATA,
        Credentials.JSON_PROPERTY_CLIENT_CERTIFICATE_DATA, Credentials.JSON_PROPERTY_CLIENT_KEY_DATA,
        Credentials.JSON_PROPERTY_TOKEN, Credentials.JSON_PROPERTY_EXPIRES_AT })
public class Credentials {
    public static final String JSON_PROPERTY_SERVER = "server";
    private URI server;

    public static final String JSON_PROPERTY_CERTIFICATE_AUTHORITY_DATA = "certificate_authority_data";
    private byte[] certificateAuthorityData;

    public static final String JSON_PROPERTY_CLIENT_CERTIFICATE_DATA = "client_certificate_data";
    private byte[] clientCertificateData;

    public static final String JSON_PROPERTY_CLIENT_KEY_DATA = "client_key_data";
    private byte[] clientKeyData;

    public static final String JSON_PROPERTY_TOKEN = "token";
    private String token;

    public static final String JSON_PROPERTY_EXPIRES_AT = "expires_at";
    private OffsetDateTime expiresAt;

    public Credentials() {
    }

    public Credentials server(URI server) {
        this.server = server;
        return this;
    }

    /**
     * The URL used to access the cluster API server.
     *
     * @return server
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SERVER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public URI getServer() {
        return server;
    }

    @JsonProperty(JSON_PROPERTY_SERVER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setServer(URI server) {
        this.server = server;
    }

    public Credentials certificateAuthorityData(byte[] certificateAuthorityData) {
        this.certificateAuthorityData = certificateAuthorityData;
        return this;
    }

    /**
     * A base64 encoding of bytes representing the certificate authority data for
     * accessing the cluster.
     *
     * @return certificateAuthorityData
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CERTIFICATE_AUTHORITY_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public byte[] getCertificateAuthorityData() {
        return certificateAuthorityData;
    }

    @JsonProperty(JSON_PROPERTY_CERTIFICATE_AUTHORITY_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCertificateAuthorityData(byte[] certificateAuthorityData) {
        this.certificateAuthorityData = certificateAuthorityData;
    }

    public Credentials clientCertificateData(byte[] clientCertificateData) {
        this.clientCertificateData = clientCertificateData;
        return this;
    }

    /**
     * A base64 encoding of bytes representing the x509 client certificate data for
     * access the cluster. This is only returned for clusters without support for
     * token-based authentication. Newly created Kubernetes clusters do not return
     * credentials using certificate-based authentication. For additional
     * information, [see
     * here](https://www.digitalocean.com/docs/kubernetes/how-to/connect-to-cluster/#authenticate).
     *
     * @return clientCertificateData
     * @deprecated
     **/
    @Deprecated
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CLIENT_CERTIFICATE_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public byte[] getClientCertificateData() {
        return clientCertificateData;
    }

    @JsonProperty(JSON_PROPERTY_CLIENT_CERTIFICATE_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setClientCertificateData(byte[] clientCertificateData) {
        this.clientCertificateData = clientCertificateData;
    }

    public Credentials clientKeyData(byte[] clientKeyData) {
        this.clientKeyData = clientKeyData;
        return this;
    }

    /**
     * A base64 encoding of bytes representing the x509 client key data for access
     * the cluster. This is only returned for clusters without support for
     * token-based authentication. Newly created Kubernetes clusters do not return
     * credentials using certificate-based authentication. For additional
     * information, [see
     * here](https://www.digitalocean.com/docs/kubernetes/how-to/connect-to-cluster/#authenticate).
     *
     * @return clientKeyData
     * @deprecated
     **/
    @Deprecated
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CLIENT_KEY_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public byte[] getClientKeyData() {
        return clientKeyData;
    }

    @JsonProperty(JSON_PROPERTY_CLIENT_KEY_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setClientKeyData(byte[] clientKeyData) {
        this.clientKeyData = clientKeyData;
    }

    public Credentials token(String token) {
        this.token = token;
        return this;
    }

    /**
     * An access token used to authenticate with the cluster. This is only returned
     * for clusters with support for token-based authentication.
     *
     * @return token
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TOKEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getToken() {
        return token;
    }

    @JsonProperty(JSON_PROPERTY_TOKEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setToken(String token) {
        this.token = token;
    }

    public Credentials expiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * A time value given in ISO8601 combined date and time format that represents
     * when the access token expires.
     *
     * @return expiresAt
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getExpiresAt() {
        return expiresAt;
    }

    @JsonProperty(JSON_PROPERTY_EXPIRES_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExpiresAt(OffsetDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    /**
     * Return true if this credentials object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Credentials credentials = (Credentials) o;
        return Objects.equals(this.server, credentials.server)
                && Arrays.equals(this.certificateAuthorityData, credentials.certificateAuthorityData)
                && Arrays.equals(this.clientCertificateData, credentials.clientCertificateData)
                && Arrays.equals(this.clientKeyData, credentials.clientKeyData)
                && Objects.equals(this.token, credentials.token)
                && Objects.equals(this.expiresAt, credentials.expiresAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, Arrays.hashCode(certificateAuthorityData), Arrays.hashCode(clientCertificateData),
                Arrays.hashCode(clientKeyData), token, expiresAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Credentials {\n");
        sb.append("    server: ").append(toIndentedString(server)).append("\n");
        sb.append("    certificateAuthorityData: ").append(toIndentedString(certificateAuthorityData)).append("\n");
        sb.append("    clientCertificateData: ").append(toIndentedString(clientCertificateData)).append("\n");
        sb.append("    clientKeyData: ").append(toIndentedString(clientKeyData)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
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