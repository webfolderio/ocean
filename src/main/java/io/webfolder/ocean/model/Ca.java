package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty(example = "LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUVRVENDQXFtZ0F3SUJBZ0lVRUZZWTdBWFZQS0Raam9jb1lpMk00Y0dvcU0wd0RRWUpLb1pJaHZjTkFRRU0KQlFBd09qRTRNRFlHQTFVRUF3d3ZOek0zT1RaaE1XRXRaamhrTUMwME9HSmpMV0V4Wm1NdFpqbGhNVFZsWXprdwpORGhsSUZCeWIycGxZM1FnUTBFd0hoY05NakF3TnpFM01UVTFNREEyV2hjTk16QXdOekUxTVRVMU1EQTJXakE2Ck1UZ3dOZ1lEVlFRRERDODNNemM1Tm1FeFlTMW1PR1F3TFRRNFltTXRZVEZtWXkxbU9XRXhOV1ZqT1RBME9HVWcKVUhKdmFtVmpkQ0JEUVRDQ0FhSXdEUVlKS29aSWh2Y05BUUVCQlFBRGdnR1BBRENDQVlvQ2dnR0JBTVdScXhycwpMZnpNdHZyUmxKVEw4MldYMVBLZkhKbitvYjNYcmVBY3FZd1dBUUp2Q3IycmhxSXZieVZzMGlaU0NzOHI4c3RGClljQ0R1bkxJNmUwTy9laERZYTBIT2RrMkFFRzE1ckVOVmNha2NSczcyQWlHVHNrdkNXS2VkUjFTUWswVWt0WCsKQUg4S1ExS3F5bzNtZ2Y2cVV1WUpzc3JNTXFselk3YTN1RVpEb2ZqTjN5Q3MvM21pTVJKcVcyNm1JV0IrUUlEbAo5YzdLRVF5MTZvdCtjeHVnd0lLMm9oZHMzaFY1bjBKMFVBM0I3QWRBdXY5aUl5L3JHaHlTNm5CNTdaWm9JZnAyCnFybXdOY0UrVjlIdXhQSGtRVjFOQjUwOFFudWZ4Z0E5VCtqU2VrdGVUbWFORkxqNjFXL3BtcndrTytOaWFXUTIKaGgzVXBKOEozY1BoNkErbHRnUmpSV2NEb2lsYVNwRVVpU09WemNNYVFvalZKYVJlNk9NbnZYc29NaSs3ZzdneApWcittQ0lUcGcvck9DaXpBWWQ2UFAxLzdYTjk1ZXNmU2tBQnM5c3hJakpjTUFqbDBYTEFzRmtGZVdyeHNIajlVCmJnaDNWYXdtcnpUeXhZT0RQcXV1cS9JcGlwc0RRT3Fpb2ZsUStkWEJJL3NUT0NNbVp6K0pNcG5HYXdJREFRQUIKb3o4d1BUQWRCZ05WSFE0RUZnUVVSekdDRlE3WEtUdHRDN3JzNS8ydFlQcExTZGN3RHdZRFZSMFRCQWd3QmdFQgovd0lCQURBTEJnTlZIUThFQkFNQ0FRWXdEUVlKS29aSWh2Y05BUUVNQlFBRGdnR0JBSWFKQ0dSVVNxUExtcmcvCmk3MW10b0NHUDdzeG1BVXVCek1oOEdrU25uaVdaZnZGMTRwSUtqTlkwbzVkWmpHKzZqK1VjalZtK0RIdGE1RjYKOWJPeEk5S0NFeEI1blBjRXpMWjNZYitNOTcrellxbm9zUm85S21DVFJBb2JrNTZ0WU1FS1h1aVJja2tkMm1yUQo4cGw2N2xxdThjM1V4c0dHZEZVT01wMkk3ZTNpdUdWVm5UR0ZWM3JQZUdaQ0J3WGVyUUQyY0F4UjkzS3BnWVZ2ClhUUzk5dnpSbm1HOHhhUm9EVy9FbEdXZ2xWd0Q5a1JrbXhUUkdoYTdDWVZCcjFQVWY2dVVFVjhmVFIxc1hFZnIKLytMR1JoSVVsSUhWT3l2Yzk3YnZYQURPbWF1MWZDVE5lWGtRdTNyZnZFSlBmaFlLeVIwT0V3eWVvdlhRNzl0LwpTV2ZGTjBreU1Pc1UrNVNIdHJKSEh1eWNWcU0yQlVVK083VjM1UnNwOU9MZGRZMFFVbTZldFpEVEhhSUhYYzRRCnl1Rm1OL1NhSFZtNE0wL3BTVlJQdVd6TmpxMnZyRllvSDRtbGhIZk95TUNJMjc2elE2aWhGNkdDSHlkOUJqajcKUm1UWGEyNHM3NWhmSi9YTDV2bnJSdEtpVHJlVHF6V21EOVhnUmNMQ0gyS1hJaVRtSWc9PQotLS0tLUVORCBDRVJUSUZJQ0FURS0tLS0tCg==", required = true, value = "base64 encoding of the certificate used to secure database connections")
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
