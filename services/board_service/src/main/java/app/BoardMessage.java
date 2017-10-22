package app;

public class BoardMessage {
    private User postedBy;
    private long timestamp;
    private String content;

    public BoardMessage(){

    }

    public BoardMessage(User postedBy, long timestamp, String content) {
        this.postedBy = postedBy;
        this.timestamp = timestamp;
        this.content = content;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
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
