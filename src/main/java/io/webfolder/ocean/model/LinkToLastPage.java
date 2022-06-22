package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * LinkToLastPage
 */
@JsonPropertyOrder({ LinkToLastPage.JSON_PROPERTY_LAST })
public class LinkToLastPage {
    public static final String JSON_PROPERTY_LAST = "last";
    private String last;

    public LinkToLastPage() {
    }

    public LinkToLastPage last(String last) {
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

    /**
     * Return true if this link_to_last_page object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkToLastPage linkToLastPage = (LinkToLastPage) o;
        return Objects.equals(this.last, linkToLastPage.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(last);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LinkToLastPage {\n");
        sb.append("    last: ").append(toIndentedString(last)).append("\n");
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
