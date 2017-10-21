import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
final class MongoDBConversationService implements ConversationService {

    private final ConversationRepository repository;

    @Autowired
    MongoDBConversationService(ConversationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Conversation create(Conversation conversation){
        Conversation persisted = Conversation.getBuilder()
                .firstUser(conversation.getFirstUser())
                .secondUser(conversation.getSecondUser())
                .messages(conversation.getMessages())
                .build();
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
        return toBeUpdated;
    }

    @Override
    public Conversation findConversationById(String id) {
        Optional<Conversation> result = repository.findOne(id);
        try {
            return result.orElseThrow(() -> new Exception(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}