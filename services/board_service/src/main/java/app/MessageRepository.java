package app;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<BoardMessage, String> {
    void delete(BoardMessage deleted);
    BoardMessage save(BoardMessage saved);
}