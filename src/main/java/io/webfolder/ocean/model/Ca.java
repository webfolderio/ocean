package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Ca
 */
@JsonPropertyOrder({ Ca.JSON_PROPERTY_CERTIFICATE })
public class Ca {
    public static final String JSON_PROPERTY_CERTIFICATE = "certificate";
    private String certificate;

    public Ca() {
    }

    @JsonCreator
    public Ca(@JsonProperty(JSON_PROPERTY_CERTIFICATE) String certificate) {
        this();
        this.certificate = certificate;
    }

    /**
     * base64 encoding of the certificate used to secure database connections
     *
     * @return certificate
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CERTIFICATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getCertificate() {
        return certificate;
    }

    /**
     * Return true if this ca object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ca ca = (Ca) o;
        return Objects.equals(this.certificate, ca.certificate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Ca {\n");
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