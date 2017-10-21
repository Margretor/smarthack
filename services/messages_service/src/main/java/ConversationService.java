import java.util.List;

interface ConversationService {

        Conversation create(Conversation message);

        Conversation delete(String id);

        Conversation appendNewMessage(String id, Message message);

        //List<Message> getAll();

        Conversation findConversationById(String id);

}
