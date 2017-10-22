package services;

import dao.UserRepository;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.PasswordHandler;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/rest/users")
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User TMPcreateUser(String uname, String pass, String mail, String job, String team) {
        User u = new User();
        u.setUsername(uname);
        u.setPassword(PasswordHandler.encryptPass(pass));
        u.setMail(mail);
        u.setJob(job);
        u.setTeam(team);

        return u;
    }

    public void createUser(User u) {
        userRepo.save(u);
    }

    public User getUserById(String userId) {
        return userRepo.findOne(userId);
    }

    public void deleteUserById(String userId) {
        userRepo.delete(userId);
    }

    public UUID login(String userId, String password) {
        User user = userRepo.findOne(userId);

        if (user != null && PasswordHandler.compare(password, user.getPassword())) {
            return UUID.randomUUID();
        } else {
            return null;
        }
    }

    public boolean updateRoles(String userId, String position) {
        User u = userRepo.findOne(userId);

        if (u != null) {
            u.setJob(position);
            userRepo.save(u);

            return true;
        } else {
            return false;
        }
    }

    public boolean changePassword(String userId, String newPass) {
        User u = userRepo.findOne(userId);

        if (u != null) {
            u.setPassword(PasswordHandler.encryptPass(newPass));
            userRepo.save(u);

            return true;
        } else {
            return false;
        }
    }



}
