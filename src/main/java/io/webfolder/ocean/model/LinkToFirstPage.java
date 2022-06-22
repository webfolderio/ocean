package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * LinkToFirstPage
 */
@JsonPropertyOrder({ LinkToFirstPage.JSON_PROPERTY_FIRST })
public class LinkToFirstPage {
    public static final String JSON_PROPERTY_FIRST = "first";
    private String first;

    public LinkToFirstPage() {
    }

    public LinkToFirstPage first(String first) {
        this.first = first;
        return this;
    }

    /**
     * URI of the first page of the results.
     *
     * @return first
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "https://api.digitalocean.com/v2/images?page=1", value = "URI of the first page of the results.")
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

    /**
     * Return true if this link_to_first_page object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkToFirstPage linkToFirstPage = (LinkToFirstPage) o;
        return Objects.equals(this.first, linkToFirstPage.first);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LinkToFirstPage {\n");
        sb.append("    first: ").append(toIndentedString(first)).append("\n");
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
