package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsStringMatch
 */
@JsonPropertyOrder({ AppsStringMatch.JSON_PROPERTY_EXACT, AppsStringMatch.JSON_PROPERTY_PREFIX,
        AppsStringMatch.JSON_PROPERTY_REGEX })
public class AppsStringMatch {
    public static final String JSON_PROPERTY_EXACT = "exact";
    private String exact;

    public static final String JSON_PROPERTY_PREFIX = "prefix";
    private String prefix;

    public static final String JSON_PROPERTY_REGEX = "regex";
    private String regex;

    public AppsStringMatch() {
    }

    public AppsStringMatch exact(String exact) {
        this.exact = exact;
        return this;
    }

    /**
     * Exact string match. Only 1 of &#x60;exact&#x60;, &#x60;prefix&#x60;, or
     * &#x60;regex&#x60; must be set.
     *
     * @return exact
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXACT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getExact() {
        return exact;
    }

    @JsonProperty(JSON_PROPERTY_EXACT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExact(String exact) {
        this.exact = exact;
    }

    public AppsStringMatch prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * Prefix-based match. Only 1 of &#x60;exact&#x60;, &#x60;prefix&#x60;, or
     * &#x60;regex&#x60; must be set.
     *
     * @return prefix
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PREFIX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPrefix() {
        return prefix;
    }

    @JsonProperty(JSON_PROPERTY_PREFIX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public AppsStringMatch regex(String regex) {
        this.regex = regex;
        return this;
    }

    /**
     * RE2 style regex-based match. Only 1 of &#x60;exact&#x60;, &#x60;prefix&#x60;,
     * or &#x60;regex&#x60; must be set. For more information about RE2 syntax, see:
     * https://github.com/google/re2/wiki/Syntax
     *
     * @return regex
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REGEX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRegex() {
        return regex;
    }

    @JsonProperty(JSON_PROPERTY_REGEX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * Return true if this apps_string_match object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsStringMatch appsStringMatch = (AppsStringMatch) o;
        return Objects.equals(this.exact, appsStringMatch.exact) && Objects.equals(this.prefix, appsStringMatch.prefix)
                && Objects.equals(this.regex, appsStringMatch.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exact, prefix, regex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsStringMatch {\n");
        sb.append("    exact: ").append(toIndentedString(exact)).append("\n");
        sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
        sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
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