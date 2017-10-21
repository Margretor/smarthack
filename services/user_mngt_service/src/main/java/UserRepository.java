import org.springframework.data.repository.Repository;

import java.util.HashMap;
import java.util.UUID;

public interface UserRepository extends Repository<User, String>{

    UserInfo createUser(String username, String password, HashMap<String, Integer> rights);

    UUID login (String username, String password); /* return session id */

    boolean validate_login(UUID userId);

    boolean updateRoles(String userId, String position);

    boolean updateRights(String userId, HashMap<String, Integer> rights);

    UserInfo getUserInfo(UUID userId);

    void changePassword(UUID userId, String newPass);
}
