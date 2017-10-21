import org.springframework.data.annotation.Id;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class Conversation {

    @Id
    private String id;
    private User firstUser;
    private User secondUser;

    public void setId(String id) {
        this.id = id;
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


    public Conversation() {
    }

    private Conversation(Builder builder) {
        this.firstUser = builder.firstUser;
        this.secondUser = builder.secondUser;
        this.messages = messages;
    }

    static Builder getBuilder() {
        return new Builder();
    }

    public void update(List<Message> messages) {
        this.messages = messages;
    }


    public String getId() {
        return id;
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

        private User firstUser;
        private User secondUser;
        private List<Message> messages;

        private Builder() {
        }

        Builder firstUser(User firstUser) {
            this.firstUser = firstUser;
            return this;
        }

        Builder secondUser(User secondUser) {
            this.secondUser = secondUser;
            return this;
        }

        Builder messages(List<Message> messages) {
            this.messages = messages;
            return this;
        }

        Conversation build() {
            return  new Conversation(this);
        }
    }
}