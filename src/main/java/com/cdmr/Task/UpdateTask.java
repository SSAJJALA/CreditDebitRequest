package com.cdmr.Task;

import com.cdmr.entity.Task;
import com.cdmr.persistence.TaskDao;

/**
 * UpdateTask updates the task status
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-29
 */
public class UpdateTask {

    private int taskID;
    private String taskStatus;

    /**
     * No arg constructor
     */
    public UpdateTask() {
    }

    /**
     * Constructor with args
     * @param taskID
     * @param taskStatus
     */
    public UpdateTask(int taskID, String taskStatus) {
        this.taskID = taskID;
        this.taskStatus = taskStatus;
    }

    /**
     * get task id
     * @return taskID
     */
    public int getTaskID() {
        return taskID;
    }

    /**
     * set task id
     * @param taskID
     */
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    /**
     * get task status
     * @return taskStatus
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * set task status
     * @param taskStatus
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * method to update the task status
     */
    public void updateTask() {

        //Update the task status
        TaskDao taskDao = new TaskDao();
        Task task = taskDao.getTask(this.taskID);
        task.setTaskStatus(this.taskStatus);
        taskDao.updateTask(task);
    }
}
