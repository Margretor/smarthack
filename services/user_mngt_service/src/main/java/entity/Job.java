package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job {

    @Id
    private int id;

    private String name;
    private int createTask;
    private int assignTask;
    private int changeStatus;
    private int deleteTask;
    private int assignTeam;

    public Job() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreateTask() {
        return createTask;
    }

    public void setCreateTask(int createTask) {
        this.createTask = createTask;
    }

    public int getAssignTask() {
        return assignTask;
    }

    public void setAssignTask(int assignTask) {
        this.assignTask = assignTask;
    }

    public int getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(int changeStatus) {
        this.changeStatus = changeStatus;
    }

    public int getDeleteTask() {
        return deleteTask;
    }

    public void setDeleteTask(int deleteTask) {
        this.deleteTask = deleteTask;
    }

    public int getAssignTeam() {
        return assignTeam;
    }

    public void setAssignTeam(int assignTeam) {
        this.assignTeam = assignTeam;
    }

}
