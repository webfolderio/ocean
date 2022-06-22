package io.webfolder.ocean.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * SlackDetails
 */
@JsonPropertyOrder({ SlackDetails.JSON_PROPERTY_CHANNEL, SlackDetails.JSON_PROPERTY_URL })
public class SlackDetails {
    public static final String JSON_PROPERTY_CHANNEL = "channel";
    private String channel;

    public static final String JSON_PROPERTY_URL = "url";
    private String url;

    public SlackDetails() {
    }

    public SlackDetails channel(String channel) {
        this.channel = channel;
        return this;
    }

    /**
     * Slack channel to notify of an alert trigger.
     *
     * @return channel
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CHANNEL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getChannel() {
        return channel;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setChannel(String channel) {
        this.channel = channel;
    }

    public SlackDetails url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Slack Webhook URL.
     *
     * @return url
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getUrl() {
        return url;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Return true if this slack_details object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SlackDetails slackDetails = (SlackDetails) o;
        return Objects.equals(this.channel, slackDetails.channel) && Objects.equals(this.url, slackDetails.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channel, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SlackDetails {\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
