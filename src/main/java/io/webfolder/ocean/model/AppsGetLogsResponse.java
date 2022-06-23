package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsGetLogsResponse
 */
@JsonPropertyOrder({ AppsGetLogsResponse.JSON_PROPERTY_HISTORIC_URLS, AppsGetLogsResponse.JSON_PROPERTY_LIVE_URL })
public class AppsGetLogsResponse {
    public static final String JSON_PROPERTY_HISTORIC_URLS = "historic_urls";
    private List<String> historicUrls = null;

    public static final String JSON_PROPERTY_LIVE_URL = "live_url";
    private String liveUrl;

    public AppsGetLogsResponse() {
    }

    public AppsGetLogsResponse historicUrls(List<String> historicUrls) {
        this.historicUrls = historicUrls;
        return this;
    }

    public AppsGetLogsResponse addHistoricUrlsItem(String historicUrlsItem) {
        if (this.historicUrls == null) {
            this.historicUrls = new ArrayList<>();
        }
        this.historicUrls.add(historicUrlsItem);
        return this;
    }

    /**
     * Get historicUrls
     *
     * @return historicUrls
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HISTORIC_URLS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getHistoricUrls() {
        return historicUrls;
    }

    @JsonProperty(JSON_PROPERTY_HISTORIC_URLS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHistoricUrls(List<String> historicUrls) {
        this.historicUrls = historicUrls;
    }

    public AppsGetLogsResponse liveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
        return this;
    }

    /**
     * A URL of the real-time live logs. This URL may use either the
     * &#x60;https://&#x60; or &#x60;wss://&#x60; protocols and will keep pushing
     * live logs as they become available.
     *
     * @return liveUrl
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LIVE_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getLiveUrl() {
        return liveUrl;
    }

    @JsonProperty(JSON_PROPERTY_LIVE_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    /**
     * Return true if this apps_get_logs_response object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsGetLogsResponse appsGetLogsResponse = (AppsGetLogsResponse) o;
        return Objects.equals(this.historicUrls, appsGetLogsResponse.historicUrls)
                && Objects.equals(this.liveUrl, appsGetLogsResponse.liveUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historicUrls, liveUrl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsGetLogsResponse {\n");
        sb.append("    historicUrls: ").append(toIndentedString(historicUrls)).append("\n");
        sb.append("    liveUrl: ").append(toIndentedString(liveUrl)).append("\n");
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