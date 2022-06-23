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
    private List<OneClick> oneClicks = null;

    public ListResponse() {
    }

    public ListResponse oneClicks(List<OneClick> oneClicks) {
        this.oneClicks = oneClicks;
        return this;
    }

    public ListResponse addOneClicksItem(OneClick oneClicksItem) {
        if (this.oneClicks == null) {
            this.oneClicks = new ArrayList<>();
        }
        this.oneClicks.add(oneClicksItem);
        return this;
    }

    /**
     * Get getOneclicks
     *
     * @return oneClicks
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_1CLICKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<OneClick> getOneclicks() {
        return oneClicks;
    }

    @JsonProperty(JSON_PROPERTY_1CLICKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void set1clicks(List<OneClick> oneClicks) {
        this.oneClicks = oneClicks;
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
        return Objects.equals(this.oneClicks, listResponse.oneClicks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oneClicks);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListResponse {\n");
        sb.append("    oneClicks: ").append(toIndentedString(oneClicks)).append("\n");
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