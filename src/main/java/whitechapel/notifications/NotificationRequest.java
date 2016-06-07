package whitechapel.notifications;

/**
 * Created by sewl on 6/5/16.
 */
public class NotificationRequest {

    protected String to;

    protected NotificationData data;

    public NotificationRequest(String recipient) {
        this.to = recipient;
        this.data = new NotificationData("test");
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public NotificationData getData() {
        return data;
    }

    public void setData(NotificationData data) {
        this.data = data;
    }
}
