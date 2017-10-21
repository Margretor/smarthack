import app.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Helper{

    @Autowired
    static ConversationRepository repository;
}

public class Main {


    public static void main(String[] args){
        MongoDBConversationService service = new MongoDBConversationService(Helper.repository);
        User firstUser = new User("gigi", "passwd");
        User secondUser = new User("cornel", "lolo");
        Message mesaj = new Message(firstUser, secondUser, new Date().getTime(), "Hello world");
        List<Message> lista = new ArrayList<>();
        lista.add(mesaj);
        Conversation persisted = new Conversation("1", firstUser, secondUser, lista);
        Gson gson = new Gson();
        String json = gson.toJson(persisted);
        System.out.println(json);
    }
}