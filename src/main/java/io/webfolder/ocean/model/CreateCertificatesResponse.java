package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * CreateCertificatesResponse
 */
@JsonPropertyOrder({ CreateCertificatesResponse.JSON_PROPERTY_CERTIFICATE })
public class CreateCertificatesResponse {
    public static final String JSON_PROPERTY_CERTIFICATE = "certificate";
    private Certificate certificate;

    public CreateCertificatesResponse() {
    }

    public CreateCertificatesResponse certificate(Certificate certificate) {
        this.certificate = certificate;
        return this;
    }

    /**
     * Get certificate
     *
     * @return certificate
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CERTIFICATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Certificate getCertificate() {
        return certificate;
    }

    @JsonProperty(JSON_PROPERTY_CERTIFICATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    /**
     * Return true if this create_certificates_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateCertificatesResponse createCertificatesResponse = (CreateCertificatesResponse) o;
        return Objects.equals(this.certificate, createCertificatesResponse.certificate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateCertificatesResponse {\n");
        sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
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
