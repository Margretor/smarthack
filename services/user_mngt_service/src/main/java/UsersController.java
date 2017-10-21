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
@RequestMapping("/api/user")
final class UsersController {

    private final UserService service;

    @Autowired
    UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    UserInfo create(@RequestBody @Valid Conversation conversation) {
        return service.create(conversation);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Conversation findById(@PathVariable("id") String id) {
        return service.findConversationById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Conversation update(@PathVariable("id") String id, @RequestBody @Valid Message message) {
        return service.appendNewMessage(id, message);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(Exception ex) {
    }
}