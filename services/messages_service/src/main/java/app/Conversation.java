package app;

import org.springframework.data.annotation.Id;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Conversation {

    @Id
    private String cid;
    private User firstUser;
    private User secondUser;

    public void setId(String cid) {
        this.cid = cid;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    List<Message> messages;

    public Conversation(String cid, User firstUser, User secondUser, List<Message> messages) {
        this.cid = cid;
        this.firstUser = firstUser;
        this.secondUser = secondUser;
        this.messages = messages;
    }

    public Conversation() {
    }

    private Conversation(Builder builder) {
        this.cid = builder.cid;
        this.firstUser = builder.firstUser;
        this.secondUser = builder.secondUser;
        this.messages = builder.messages;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void update(List<Message> messages) {
        this.messages = messages;
    }


    public String getCid() {
        return cid;
    }

    public void append(Message message) {
        messages.add(message);
        Collections.sort(messages, Comparator.comparing(Message::getTimestamp).reversed());
    }

    /**
     * We don't have to use the builder pattern here because the constructed
     * class has only two String fields. However, I use the builder pattern
     * in this example because it makes the code a bit easier to read.
     */
    static class Builder {

        private String cid;
        private User firstUser;
        private User secondUser;
        private List<Message> messages;

        private Builder() {
        }

        public Builder cid(String cid) {
            this.cid = cid;
            return this;
        }

        public Builder firstUser(User firstUser) {
            this.firstUser = firstUser;
            return this;
        }

        public Builder secondUser(User secondUser) {
            this.secondUser = secondUser;
            return this;
        }

        public Builder messages(List<Message> messages) {
            this.messages = messages;
            return this;
        }

        public Conversation build() {
            return  new Conversation(this);
        }
    }
}