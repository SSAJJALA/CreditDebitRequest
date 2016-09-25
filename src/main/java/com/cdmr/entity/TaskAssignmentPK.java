package com.cdmr.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 9/24/16.
 */

@Embeddable
public class TaskAssignmentPK implements Serializable {

    @Column(name="TASK_ID")
    private int taskID;

    @Column(name="USER_ID")
    private String userID;

    public TaskAssignmentPK() {
    }

    public TaskAssignmentPK(int taskID, String userID) {
        this.taskID = taskID;
        this.userID = userID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "TaskAssignmentPK{" +
                "taskID=" + taskID +
                ", userID='" + userID + '\'' +
                '}';
    }
}
