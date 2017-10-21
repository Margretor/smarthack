import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface ConversationRepository extends Repository<Conversation, String> {

    void delete(Conversation deleted);

    List<Conversation> findAll();

    Optional<Conversation> findOne(String id);

    Conversation save(Conversation saved);
}