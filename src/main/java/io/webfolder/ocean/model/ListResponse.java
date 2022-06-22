package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ListResponse
 */
@JsonPropertyOrder({ ListResponse.JSON_PROPERTY_1CLICKS })
public class ListResponse {
    public static final String JSON_PROPERTY_1CLICKS = "1_clicks";
    private List<OneClick> _1clicks = null;

    public ListResponse() {
    }

    public ListResponse _1clicks(List<OneClick> _1clicks) {
        this._1clicks = _1clicks;
        return this;
    }

    public ListResponse add1clicksItem(OneClick _1clicksItem) {
        if (this._1clicks == null) {
            this._1clicks = new ArrayList<>();
        }
        this._1clicks.add(_1clicksItem);
        return this;
    }

    /**
     * Get _1clicks
     *
     * @return _1clicks
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_1CLICKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<OneClick> get1clicks() {
        return _1clicks;
    }

    @JsonProperty(JSON_PROPERTY_1CLICKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void set1clicks(List<OneClick> _1clicks) {
        this._1clicks = _1clicks;
    }

    /**
     * Return true if this list_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListResponse listResponse = (ListResponse) o;
        return Objects.equals(this._1clicks, listResponse._1clicks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1clicks);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListResponse {\n");
        sb.append("    _1clicks: ").append(toIndentedString(_1clicks)).append("\n");
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
