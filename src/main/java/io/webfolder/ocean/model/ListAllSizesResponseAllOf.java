package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListAllSizesResponseAllOf
 */
@JsonPropertyOrder({ ListAllSizesResponseAllOf.JSON_PROPERTY_SIZES })
public class ListAllSizesResponseAllOf {
    public static final String JSON_PROPERTY_SIZES = "sizes";
    private List<Size> sizes = new ArrayList<>();

    public ListAllSizesResponseAllOf() {
    }

    public ListAllSizesResponseAllOf sizes(List<Size> sizes) {
        this.sizes = sizes;
        return this;
    }

    public ListAllSizesResponseAllOf addSizesItem(Size sizesItem) {
        this.sizes.add(sizesItem);
        return this;
    }

    /**
     * Get sizes
     *
     * @return sizes
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SIZES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<Size> getSizes() {
        return sizes;
    }

    @JsonProperty(JSON_PROPERTY_SIZES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    /**
     * Return true if this list_all_sizes_response_allOf object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListAllSizesResponseAllOf listAllSizesResponseAllOf = (ListAllSizesResponseAllOf) o;
        return Objects.equals(this.sizes, listAllSizesResponseAllOf.sizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListAllSizesResponseAllOf {\n");
        sb.append("    sizes: ").append(toIndentedString(sizes)).append("\n");
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