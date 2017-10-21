import org.springframework.data.repository.Repository;

import java.util.HashMap;
import java.util.UUID;

public interface UserRepository extends Repository<User, String>{

    UUID login (String username, String password); /* return session id */

    boolean validate_login(UUID userId);

    boolean updateRoles(String userId, String position);

    boolean updateRights(String userId, HashMap<String, Integer> rights);

    UserInfo getUserInfo(UUID userId);

}
