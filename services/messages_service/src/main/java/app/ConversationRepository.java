package app;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversationRepository extends MongoRepository<Conversation, String> {
    void delete(Conversation deleted);
    Conversation save(Conversation saved);
}