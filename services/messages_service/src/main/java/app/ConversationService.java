package app;

interface ConversationService {

        Conversation create(Conversation message);

        Conversation delete(String id);

        Conversation appendNewMessage(String id, Message message);

        //List<app.Message> getAll();

        Conversation findConversationById(String id);

}
