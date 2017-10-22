package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class MongoDBConversationService implements ConversationService {

    private final ConversationRepository repository;

    @Autowired
    public MongoDBConversationService(ConversationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Conversation create(Conversation conversation){
        System.out.println(conversation.getCid());
        System.out.println(conversation.getMessages().get(0).getContent());
        Conversation persisted = Conversation.getBuilder()
                .cid(conversation.getCid())
                .firstUser(conversation.getFirstUser())
                .secondUser(conversation.getSecondUser())
                .messages(conversation.getMessages())
                .build();
        persisted = repository.save(persisted);
        return persisted;
    }

    @Override
    public Conversation delete(String id) {
        Conversation deleted = findConversationById(id);
        repository.delete(deleted);
        return deleted;
    }

    @Override
    public Conversation appendNewMessage(String id, Message message) {
        Conversation toBeUpdated = findConversationById(id);
        toBeUpdated.append(message);
        repository.save(toBeUpdated);
        return toBeUpdated;
    }

    @Override
    public Conversation findConversationById(String cid) {
        System.out.println("id = " + cid);
        Conversation conv = repository.findOne(cid);
        System.out.println(conv);
        return conv;
    }
}