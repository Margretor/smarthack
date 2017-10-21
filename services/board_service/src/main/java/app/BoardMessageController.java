package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/board")
public final class BoardMessageController {

    private final BoardMessageService service;

    @Autowired
    public BoardMessageController(BoardMessageService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    BoardMessage create(@RequestBody BoardMessage message) {
        System.out.println("POST");
        return service.create(message);
    }

    @RequestMapping(method=RequestMethod.GET)
    List<BoardMessage> ListBoardMessages(){
        return service.getAllBoardMessages();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(Exception ex) {
        System.out.println(ex.getMessage());
        System.out.println("Ended up here");
    }
}
