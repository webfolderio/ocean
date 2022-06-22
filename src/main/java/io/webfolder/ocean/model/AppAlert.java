package io.webfolder.ocean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppAlert
 */
@JsonPropertyOrder({ AppAlert.JSON_PROPERTY_ID, AppAlert.JSON_PROPERTY_COMPONENT_NAME, AppAlert.JSON_PROPERTY_SPEC,
        AppAlert.JSON_PROPERTY_EMAILS, AppAlert.JSON_PROPERTY_SLACK_WEBHOOKS, AppAlert.JSON_PROPERTY_PHASE,
        AppAlert.JSON_PROPERTY_PROGRESS })
public class AppAlert {
    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_COMPONENT_NAME = "component_name";
    private String componentName;

    public static final String JSON_PROPERTY_SPEC = "spec";
    private AppAlertSpec spec;

    public static final String JSON_PROPERTY_EMAILS = "emails";
    private List<String> emails = null;

    public static final String JSON_PROPERTY_SLACK_WEBHOOKS = "slack_webhooks";
    private List<AppAlertSlackWebhook> slackWebhooks = null;

    public static final String JSON_PROPERTY_PHASE = "phase";
    private AppAlertPhase phase = AppAlertPhase.UNKNOWN;

    public static final String JSON_PROPERTY_PROGRESS = "progress";
    private AppAlertProgress progress;

    public AppAlert() {
    }

    @JsonCreator
    public AppAlert(@JsonProperty(JSON_PROPERTY_ID) String id) {
        this();
        this.id = id;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getId() {
        return id;
    }

    public AppAlert componentName(String componentName) {
        this.componentName = componentName;
        return this;
    }

    /**
     * Get componentName
     *
     * @return componentName
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COMPONENT_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getComponentName() {
        return componentName;
    }

    @JsonProperty(JSON_PROPERTY_COMPONENT_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public AppAlert spec(AppAlertSpec spec) {
        this.spec = spec;
        return this;
    }

    /**
     * Get spec
     *
     * @return spec
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppAlertSpec getSpec() {
        return spec;
    }

    @JsonProperty(JSON_PROPERTY_SPEC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSpec(AppAlertSpec spec) {
        this.spec = spec;
    }

    public AppAlert emails(List<String> emails) {
        this.emails = emails;
        return this;
    }

    public AppAlert addEmailsItem(String emailsItem) {
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

    public AppAlert slackWebhooks(List<AppAlertSlackWebhook> slackWebhooks) {
        this.slackWebhooks = slackWebhooks;
        return this;
    }

    public AppAlert addSlackWebhooksItem(AppAlertSlackWebhook slackWebhooksItem) {
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

    public AppAlert phase(AppAlertPhase phase) {
        this.phase = phase;
        return this;
    }

    /**
     * Get phase
     *
     * @return phase
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PHASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppAlertPhase getPhase() {
        return phase;
    }

    @JsonProperty(JSON_PROPERTY_PHASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPhase(AppAlertPhase phase) {
        this.phase = phase;
    }

    public AppAlert progress(AppAlertProgress progress) {
        this.progress = progress;
        return this;
    }

    /**
     * Get progress
     *
     * @return progress
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROGRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public AppAlertProgress getProgress() {
        return progress;
    }

    @JsonProperty(JSON_PROPERTY_PROGRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProgress(AppAlertProgress progress) {
        this.progress = progress;
    }

    /**
     * Return true if this app_alert object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppAlert appAlert = (AppAlert) o;
        return Objects.equals(this.id, appAlert.id) && Objects.equals(this.componentName, appAlert.componentName)
                && Objects.equals(this.spec, appAlert.spec) && Objects.equals(this.emails, appAlert.emails)
                && Objects.equals(this.slackWebhooks, appAlert.slackWebhooks)
                && Objects.equals(this.phase, appAlert.phase) && Objects.equals(this.progress, appAlert.progress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, componentName, spec, emails, slackWebhooks, phase, progress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppAlert {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    componentName: ").append(toIndentedString(componentName)).append("\n");
        sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
        sb.append("    emails: ").append(toIndentedString(emails)).append("\n");
        sb.append("    slackWebhooks: ").append(toIndentedString(slackWebhooks)).append("\n");
        sb.append("    phase: ").append(toIndentedString(phase)).append("\n");
        sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
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
