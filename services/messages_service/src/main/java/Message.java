import java.sql.Timestamp;

public class Message {
    private User from;
    private User to;
    private Timestamp timestamp;
    private String content;

    public Message(User from, User to, Timestamp timestamp, String content) {
        this.from = from;
        this.to = to;
        this.timestamp = timestamp;
        this.content = content;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
