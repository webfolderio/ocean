package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * BackwardLinks
 */
@JsonPropertyOrder({ BackwardLinks.JSON_PROPERTY_FIRST, BackwardLinks.JSON_PROPERTY_PREV })
public class BackwardLinks {
    public static final String JSON_PROPERTY_FIRST = "first";
    private String first;

    public static final String JSON_PROPERTY_PREV = "prev";
    private String prev;

    public BackwardLinks() {
    }

    public BackwardLinks first(String first) {
        this.first = first;
        return this;
    }

    /**
     * URI of the first page of the results.
     *
     * @return first
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FIRST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getFirst() {
        return first;
    }

    @JsonProperty(JSON_PROPERTY_FIRST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFirst(String first) {
        this.first = first;
    }

    public BackwardLinks prev(String prev) {
        this.prev = prev;
        return this;
    }

    /**
     * URI of the previous page of the results.
     *
     * @return prev
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PREV)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPrev() {
        return prev;
    }

    @JsonProperty(JSON_PROPERTY_PREV)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPrev(String prev) {
        this.prev = prev;
    }

    /**
     * Return true if this backward_links object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BackwardLinks backwardLinks = (BackwardLinks) o;
        return Objects.equals(this.first, backwardLinks.first) && Objects.equals(this.prev, backwardLinks.prev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, prev);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BackwardLinks {\n");
        sb.append("    first: ").append(toIndentedString(first)).append("\n");
        sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
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