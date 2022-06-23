package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppAlertSlackWebhook
 */
@JsonPropertyOrder({ AppAlertSlackWebhook.JSON_PROPERTY_URL, AppAlertSlackWebhook.JSON_PROPERTY_CHANNEL })
public class AppAlertSlackWebhook {
    public static final String JSON_PROPERTY_URL = "url";
    private String url;

    public static final String JSON_PROPERTY_CHANNEL = "channel";
    private String channel;

    public AppAlertSlackWebhook() {
    }

    public AppAlertSlackWebhook url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get url
     *
     * @return url
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getUrl() {
        return url;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUrl(String url) {
        this.url = url;
    }

    public AppAlertSlackWebhook channel(String channel) {
        this.channel = channel;
        return this;
    }

    /**
     * Get channel
     *
     * @return channel
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CHANNEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getChannel() {
        return channel;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Return true if this app_alert_slack_webhook object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppAlertSlackWebhook appAlertSlackWebhook = (AppAlertSlackWebhook) o;
        return Objects.equals(this.url, appAlertSlackWebhook.url)
                && Objects.equals(this.channel, appAlertSlackWebhook.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, channel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppAlertSlackWebhook {\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
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