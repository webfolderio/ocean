package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Alerts
 */
@JsonPropertyOrder({ Alerts.JSON_PROPERTY_EMAIL, Alerts.JSON_PROPERTY_SLACK })
public class Alerts {
    public static final String JSON_PROPERTY_EMAIL = "email";
    private List<String> email = new ArrayList<>();

    public static final String JSON_PROPERTY_SLACK = "slack";
    private List<SlackDetails> slack = new ArrayList<>();

    public Alerts() {
    }

    public Alerts email(List<String> email) {
        this.email = email;
        return this;
    }

    public Alerts addEmailItem(String emailItem) {
        this.email.add(emailItem);
        return this;
    }

    /**
     * An email to notify on an alert trigger.
     *
     * @return email
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getEmail() {
        return email;
    }

    @JsonProperty(JSON_PROPERTY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEmail(List<String> email) {
        this.email = email;
    }

    public Alerts slack(List<SlackDetails> slack) {
        this.slack = slack;
        return this;
    }

    public Alerts addSlackItem(SlackDetails slackItem) {
        this.slack.add(slackItem);
        return this;
    }

    /**
     * Slack integration details.
     *
     * @return slack
     **/
    @javax.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_SLACK)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<SlackDetails> getSlack() {
        return slack;
    }

    @JsonProperty(JSON_PROPERTY_SLACK)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSlack(List<SlackDetails> slack) {
        this.slack = slack;
    }

    /**
     * Return true if this alerts object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Alerts alerts = (Alerts) o;
        return Objects.equals(this.email, alerts.email) && Objects.equals(this.slack, alerts.slack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, slack);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Alerts {\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    slack: ").append(toIndentedString(slack)).append("\n");
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
