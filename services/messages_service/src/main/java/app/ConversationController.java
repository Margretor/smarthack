package app;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/conversation")
public final class ConversationController {

    private final ConversationService service;

    @Autowired
    public ConversationController(ConversationService service) {
        this.service = service;
    }

//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    Conversation create(@RequestBody Conversation conversation) {
//        System.out.println("POST");
//        //System.out.println(new Gson().toJson(conversation));
//        //return service.create(conversation);
//        return conversation;
//    }



    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Conversation create(@RequestBody Conversation conversation) {
        System.out.println("POST");
        return service.create(conversation);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    Conversation delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Conversation findById(@PathVariable("id") String id) {
        System.out.println("HEREEEEE");
        return service.findConversationById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Conversation update(@PathVariable("id") String id, @RequestBody @Valid Message message) {
        return service.appendNewMessage(id, message);
    }

    @RequestMapping(method=RequestMethod.GET)
    String hello(){
        return "HELLO WORLD!";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(Exception ex) {
        System.out.println(ex.getMessage());
        System.out.println("Ended up here");
    }
}
