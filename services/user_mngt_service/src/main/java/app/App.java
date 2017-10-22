package app;

import com.google.gson.Gson;
import entity.User;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        User u1 = new User();
        u1.setUsername("dan");
        u1.setPassword("1234");
        u1.setMail("dan@example.com");

        User u2 = new User();
        u2.setUsername("vlad");
        u2.setPassword("31826");
        u2.setMail("vlad@example.com");


        Gson gson = new Gson();
        String json = gson.toJson(u1);
        System.out.println(json);



    }
}
