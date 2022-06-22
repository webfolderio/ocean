package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AppJobSpecAllOf
 */
@JsonPropertyOrder({ AppJobSpecAllOf.JSON_PROPERTY_KIND })
public class AppJobSpecAllOf {
    /**
     * - UNSPECIFIED: Default job type, will auto-complete to POST_DEPLOY kind. -
     * PRE_DEPLOY: Indicates a job that runs before an app deployment. -
     * POST_DEPLOY: Indicates a job that runs after an app deployment. -
     * FAILED_DEPLOY: Indicates a job that runs after a component fails to deploy.
     */
    public enum KindEnum {
        UNSPECIFIED("UNSPECIFIED"),

        PRE_DEPLOY("PRE_DEPLOY"),

        POST_DEPLOY("POST_DEPLOY"),

        FAILED_DEPLOY("FAILED_DEPLOY");

        private String value;

        KindEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static KindEnum fromValue(String value) {
            for (KindEnum b : KindEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_KIND = "kind";
    private KindEnum kind = KindEnum.UNSPECIFIED;

    public AppJobSpecAllOf() {
    }

    public AppJobSpecAllOf kind(KindEnum kind) {
        this.kind = kind;
        return this;
    }

    /**
     * - UNSPECIFIED: Default job type, will auto-complete to POST_DEPLOY kind. -
     * PRE_DEPLOY: Indicates a job that runs before an app deployment. -
     * POST_DEPLOY: Indicates a job that runs after an app deployment. -
     * FAILED_DEPLOY: Indicates a job that runs after a component fails to deploy.
     *
     * @return kind
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KIND)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public KindEnum getKind() {
        return kind;
    }

    @JsonProperty(JSON_PROPERTY_KIND)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKind(KindEnum kind) {
        this.kind = kind;
    }

    /**
     * Return true if this app_job_spec_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppJobSpecAllOf appJobSpecAllOf = (AppJobSpecAllOf) o;
        return Objects.equals(this.kind, appJobSpecAllOf.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppJobSpecAllOf {\n");
        sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
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
