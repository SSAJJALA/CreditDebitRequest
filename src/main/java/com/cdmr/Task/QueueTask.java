package com.cdmr.Task;

import com.cdmr.entity.Task;
import com.cdmr.persistence.TaskDao;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by student on 9/29/16.
 */
public class QueueTask {

    private String userID;
    private String taskName;
    private int reqID;


    public QueueTask() {
    }

    public QueueTask(String userID, String taskName, int reqID) {
        this.userID = userID;
        this.taskName = taskName;
        this.reqID = reqID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getReqID() {
        return reqID;
    }

    public void setReqID(int reqID) {
        this.reqID = reqID;
    }

    public int createTask() {
        TaskDao taskDao = new TaskDao();
        Task taskEntity = new Task();
        taskEntity.setTaskName(this.taskName);
        taskEntity.setTaskStatus("Active");

        taskEntity.setCreatedDate(LocalDateTime.now());
        taskEntity.setUpdatedDate(LocalDateTime.now());
        int taskID = taskDao.addTask(taskEntity);
        return taskID;

    }
}
