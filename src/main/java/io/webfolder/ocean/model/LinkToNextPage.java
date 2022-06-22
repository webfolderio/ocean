package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * LinkToNextPage
 */
@JsonPropertyOrder({ LinkToNextPage.JSON_PROPERTY_NEXT })
public class LinkToNextPage {
    public static final String JSON_PROPERTY_NEXT = "next";
    private String next;

    public LinkToNextPage() {
    }

    public LinkToNextPage next(String next) {
        this.next = next;
        return this;
    }

    /**
     * URI of the next page of the results.
     *
     * @return next
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "https://api.digitalocean.com/v2/images?page=2", value = "URI of the next page of the results.")
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
     * Return true if this link_to_next_page object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkToNextPage linkToNextPage = (LinkToNextPage) o;
        return Objects.equals(this.next, linkToNextPage.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LinkToNextPage {\n");
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
