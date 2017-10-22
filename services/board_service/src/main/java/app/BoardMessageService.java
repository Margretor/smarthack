package app;

import java.util.List;

interface BoardMessageService {
        BoardMessage create(BoardMessage boardMessage);
        List<BoardMessage> getAllBoardMessages();
}
