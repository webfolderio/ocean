package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * UpdateRegistry
 */
@JsonPropertyOrder({ UpdateRegistry.JSON_PROPERTY_CANCEL })
public class UpdateRegistry {
    public static final String JSON_PROPERTY_CANCEL = "cancel";
    private Boolean cancel;

    public UpdateRegistry() {
    }

    public UpdateRegistry cancel(Boolean cancel) {
        this.cancel = cancel;
        return this;
    }

    /**
     * A boolean value indicating that the garbage collection should be cancelled.
     *
     * @return cancel
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "true", value = "A boolean value indicating that the garbage collection should be cancelled.")
    @JsonProperty(JSON_PROPERTY_CANCEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getCancel() {
        return cancel;
    }

    @JsonProperty(JSON_PROPERTY_CANCEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * Return true if this update_registry object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateRegistry updateRegistry = (UpdateRegistry) o;
        return Objects.equals(this.cancel, updateRegistry.cancel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cancel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateRegistry {\n");
        sb.append("    cancel: ").append(toIndentedString(cancel)).append("\n");
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
