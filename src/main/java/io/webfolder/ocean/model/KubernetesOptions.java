package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * KubernetesOptions
 */
@JsonPropertyOrder({ KubernetesOptions.JSON_PROPERTY_OPTIONS })
public class KubernetesOptions {
    public static final String JSON_PROPERTY_OPTIONS = "options";
    private KubernetesOptionsOptions options;

    public KubernetesOptions() {
    }

    public KubernetesOptions options(KubernetesOptionsOptions options) {
        this.options = options;
        return this;
    }

    /**
     * Get options
     *
     * @return options
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_OPTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public KubernetesOptionsOptions getOptions() {
        return options;
    }

    @JsonProperty(JSON_PROPERTY_OPTIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOptions(KubernetesOptionsOptions options) {
        this.options = options;
    }

    /**
     * Return true if this kubernetes_options object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KubernetesOptions kubernetesOptions = (KubernetesOptions) o;
        return Objects.equals(this.options, kubernetesOptions.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(options);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KubernetesOptions {\n");
        sb.append("    options: ").append(toIndentedString(options)).append("\n");
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
