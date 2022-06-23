package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * LinkToPrevPage
 */
@JsonPropertyOrder({ LinkToPrevPage.JSON_PROPERTY_PREV })
public class LinkToPrevPage {
    public static final String JSON_PROPERTY_PREV = "prev";
    private String prev;

    public LinkToPrevPage() {
    }

    public LinkToPrevPage prev(String prev) {
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
     * Return true if this link_to_prev_page object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkToPrevPage linkToPrevPage = (LinkToPrevPage) o;
        return Objects.equals(this.prev, linkToPrevPage.prev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prev);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LinkToPrevPage {\n");
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