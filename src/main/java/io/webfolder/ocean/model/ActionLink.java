package io.webfolder.ocean.model;

import java.net.URI;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The linked actions can be used to check the status of a Droplet&#39;s create
 * event.
 */
@JsonPropertyOrder({ ActionLink.JSON_PROPERTY_ID, ActionLink.JSON_PROPERTY_REL, ActionLink.JSON_PROPERTY_HREF })
public class ActionLink {
    public static final String JSON_PROPERTY_ID = "id";
    private Integer id;

    public static final String JSON_PROPERTY_REL = "rel";
    private String rel;

    public static final String JSON_PROPERTY_HREF = "href";
    private URI href;

    public ActionLink() {
    }

    public ActionLink id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * A unique numeric ID that can be used to identify and reference an action.
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Integer getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(Integer id) {
        this.id = id;
    }

    public ActionLink rel(String rel) {
        this.rel = rel;
        return this;
    }

    /**
     * A string specifying the type of the related action.
     *
     * @return rel
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getRel() {
        return rel;
    }

    @JsonProperty(JSON_PROPERTY_REL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRel(String rel) {
        this.rel = rel;
    }

    public ActionLink href(URI href) {
        this.href = href;
        return this;
    }

    /**
     * A URL that can be used to access the action.
     *
     * @return href
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HREF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public URI getHref() {
        return href;
    }

    @JsonProperty(JSON_PROPERTY_HREF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHref(URI href) {
        this.href = href;
    }

    /**
     * Return true if this action_link object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActionLink actionLink = (ActionLink) o;
        return Objects.equals(this.id, actionLink.id) && Objects.equals(this.rel, actionLink.rel)
                && Objects.equals(this.href, actionLink.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rel, href);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActionLink {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    rel: ").append(toIndentedString(rel)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
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