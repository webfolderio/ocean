package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * MetaOptionalTotal
 */
@JsonPropertyOrder({ MetaOptionalTotal.JSON_PROPERTY_META })
public class MetaOptionalTotal {
    public static final String JSON_PROPERTY_META = "meta";
    private MetaProperties meta;

    public MetaOptionalTotal() {
    }

    public MetaOptionalTotal meta(MetaProperties meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public MetaProperties getMeta() {
        return meta;
    }

    @JsonProperty(JSON_PROPERTY_META)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMeta(MetaProperties meta) {
        this.meta = meta;
    }

    /**
     * Return true if this meta_optional_total object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MetaOptionalTotal metaOptionalTotal = (MetaOptionalTotal) o;
        return Objects.equals(this.meta, metaOptionalTotal.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetaOptionalTotal {\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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