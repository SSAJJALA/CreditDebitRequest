package com.cdmr.Task;

import com.cdmr.entity.Task;
import com.cdmr.persistence.TaskDao;

/**
 * Created by Siva Sajjala on 9/29/16.
 */
public class UpdateTask {

    private int taskID;
    private String taskStatus;

    public UpdateTask() {
    }

    public UpdateTask(int taskID, String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void updateTask() {

        //Update the task status
        TaskDao taskDao = new TaskDao();
        Task task = taskDao.getTask(this.taskID);
        task.setTaskStatus(this.taskStatus);
        taskDao.updateTask(task);
    }
}
