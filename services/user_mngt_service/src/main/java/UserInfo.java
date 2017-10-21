import java.util.HashMap;
import java.util.List;

public class UserInfo {

    private String firstName;
    private String lastName;
    private String user;
    private String team;
    private String jobPosition;
    private HashMap<String, Integer> rights;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public HashMap<String, Integer> getRights() {
        return rights;
    }

    public void setRights(HashMap<String, Integer> rights) {
        this.rights = rights;
    }
}
