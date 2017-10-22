package app;

import controllers.UserController;
import dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Main {

    @Autowired
    UserRepository userRepository;

    @Bean
    public UserController userController(){
        return new UserController(userRepository);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}