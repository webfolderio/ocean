package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * PageLinks
 */
@JsonPropertyOrder({ PageLinks.JSON_PROPERTY_PAGES })
public class PageLinks {
    public static final String JSON_PROPERTY_PAGES = "pages";
    private PageLinksPages pages;

    public PageLinks() {
    }

    public PageLinks pages(PageLinksPages pages) {
        this.pages = pages;
        return this;
    }

    /**
     * Get pages
     *
     * @return pages
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_PAGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public PageLinksPages getPages() {
        return pages;
    }

    @JsonProperty(JSON_PROPERTY_PAGES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPages(PageLinksPages pages) {
        this.pages = pages;
    }

    /**
     * Return true if this page_links object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PageLinks pageLinks = (PageLinks) o;
        return Objects.equals(this.pages, pageLinks.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pages);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PageLinks {\n");
        sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
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
