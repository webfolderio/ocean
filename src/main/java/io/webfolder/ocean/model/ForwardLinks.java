package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ForwardLinks
 */
@JsonPropertyOrder({ ForwardLinks.JSON_PROPERTY_LAST, ForwardLinks.JSON_PROPERTY_NEXT })
public class ForwardLinks {
    public static final String JSON_PROPERTY_LAST = "last";
    private String last;

    public static final String JSON_PROPERTY_NEXT = "next";
    private String next;

    public ForwardLinks() {
    }

    public ForwardLinks last(String last) {
        this.last = last;
        return this;
    }

    /**
     * URI of the last page of the results.
     *
     * @return last
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLast() {
        return last;
    }

    @JsonProperty(JSON_PROPERTY_LAST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLast(String last) {
        this.last = last;
    }

    public ForwardLinks next(String next) {
        this.next = next;
        return this;
    }

    /**
     * URI of the next page of the results.
     *
     * @return next
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NEXT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getNext() {
        return next;
    }

    @JsonProperty(JSON_PROPERTY_NEXT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * Return true if this forward_links object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ForwardLinks forwardLinks = (ForwardLinks) o;
        return Objects.equals(this.last, forwardLinks.last) && Objects.equals(this.next, forwardLinks.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(last, next);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ForwardLinks {\n");
        sb.append("    last: ").append(toIndentedString(last)).append("\n");
        sb.append("    next: ").append(toIndentedString(next)).append("\n");
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
