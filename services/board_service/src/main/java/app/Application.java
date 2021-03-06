package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableMongoRepositories
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    @Autowired
    MessageRepository repository;

    @Bean
    public BoardMessageController boardMessageController(){
        return new BoardMessageController(new MongoDBBoardMessageService(repository));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
