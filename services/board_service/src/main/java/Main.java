import app.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Helper{

    @Autowired
    static MessageRepository repository;
}

public class Main {


    public static void main(String[] args){
        MongoDBBoardMessageService service = new MongoDBBoardMessageService(Helper.repository);
        User firstUser = new User("gigi", "passwd");
        User secondUser = new User("cornel", "lolo");
        BoardMessage mesaj = new BoardMessage(firstUser, new Date().getTime(),"Hello world");
        List<BoardMessage> lista = new ArrayList<>();
        lista.add(mesaj);
        BoardMessage mesaj2 = new BoardMessage(secondUser, new Date().getTime()+1,"Hello gigel");
        lista.add(mesaj2);
        Gson gson = new Gson();
        String json = gson.toJson(lista);
        System.out.println(json);
        System.out.println(gson.toJson(mesaj));
        System.out.println(gson.toJson(mesaj2));
    }
}