package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDBBoardMessageService implements BoardMessageService {

    private final MessageRepository repository;

    @Autowired
    public MongoDBBoardMessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public BoardMessage create(BoardMessage postedBoardMessage){
        BoardMessage persisted = repository.save(postedBoardMessage);
        return persisted;
    }

    @Override
    public List<BoardMessage> getAllBoardMessages() {
        return repository.findAll();
    }

}