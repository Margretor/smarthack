package app;

import java.util.Date;

public class Message {
    private User from;
    private User to;
    private long timestamp;
    private String content;

    public Message(){

    }

    public Message(User from, User to, long timestamp, String content) {
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
