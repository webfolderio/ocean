package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppsAssignAppAlertDestinationsRequest
 */
@JsonPropertyOrder({ AppsAssignAppAlertDestinationsRequest.JSON_PROPERTY_EMAILS,
        AppsAssignAppAlertDestinationsRequest.JSON_PROPERTY_SLACK_WEBHOOKS })
public class AppsAssignAppAlertDestinationsRequest {
    public static final String JSON_PROPERTY_EMAILS = "emails";
    private List<String> emails = null;

    public static final String JSON_PROPERTY_SLACK_WEBHOOKS = "slack_webhooks";
    private List<AppAlertSlackWebhook> slackWebhooks = null;

    public AppsAssignAppAlertDestinationsRequest() {
    }

    public AppsAssignAppAlertDestinationsRequest emails(List<String> emails) {
        this.emails = emails;
        return this;
    }

    public AppsAssignAppAlertDestinationsRequest addEmailsItem(String emailsItem) {
        if (this.emails == null) {
            this.emails = new ArrayList<>();
        }
        this.emails.add(emailsItem);
        return this;
    }

    /**
     * Get emails
     *
     * @return emails
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EMAILS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<String> getEmails() {
        return emails;
    }

    @JsonProperty(JSON_PROPERTY_EMAILS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public AppsAssignAppAlertDestinationsRequest slackWebhooks(List<AppAlertSlackWebhook> slackWebhooks) {
        this.slackWebhooks = slackWebhooks;
        return this;
    }

    public AppsAssignAppAlertDestinationsRequest addSlackWebhooksItem(AppAlertSlackWebhook slackWebhooksItem) {
        if (this.slackWebhooks == null) {
            this.slackWebhooks = new ArrayList<>();
        }
        this.slackWebhooks.add(slackWebhooksItem);
        return this;
    }

    /**
     * Get slackWebhooks
     *
     * @return slackWebhooks
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SLACK_WEBHOOKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<AppAlertSlackWebhook> getSlackWebhooks() {
        return slackWebhooks;
    }

    @JsonProperty(JSON_PROPERTY_SLACK_WEBHOOKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSlackWebhooks(List<AppAlertSlackWebhook> slackWebhooks) {
        this.slackWebhooks = slackWebhooks;
    }

    /**
     * Return true if this apps_assign_app_alert_destinations_request object is
     * equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppsAssignAppAlertDestinationsRequest appsAssignAppAlertDestinationsRequest = (AppsAssignAppAlertDestinationsRequest) o;
        return Objects.equals(this.emails, appsAssignAppAlertDestinationsRequest.emails)
                && Objects.equals(this.slackWebhooks, appsAssignAppAlertDestinationsRequest.slackWebhooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emails, slackWebhooks);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppsAssignAppAlertDestinationsRequest {\n");
        sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
        sb.append("    slackWebhooks: ").append(toIndentedString(slackWebhooks)).append("\n");
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