package com.cdmr.Task;

import com.cdmr.entity.Task;
import com.cdmr.entity.TaskAssignment;
import com.cdmr.entity.TaskAssignmentPK;
import com.cdmr.persistence.TaskAssignmentDao;
import com.cdmr.persistence.TaskDao;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * QueueTask generates the task ID for approval
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-29
 */
public class QueueTask {

    private String assignToUserID;
    private String taskName;
    private int reqID;

    /**
     * No arg constructor
     */
    public QueueTask() {
    }

    /**
     * Constructor with args
     * @param assignToUserID assignToUserID
     * @param taskName taskName
     * @param reqID reqID
     */
    public QueueTask(String assignToUserID, String taskName, int reqID) {
        this.assignToUserID = assignToUserID;
        this.taskName = taskName;
        this.reqID = reqID;
    }

    /**
     * get assign to user id
     * @return assignToUserID
     */
    public String getAssignToUserID() {
        return assignToUserID;
    }

    /**
     * set assign to user id
     * @param assignToUserID
     */
    public void setAssignToUserID(String assignToUserID) {
        this.assignToUserID = assignToUserID;
    }

    /**
     * get task name
     * @return taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * set the task name
     * @param taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * get requisition ID
     * @return reqID
     */
    public int getReqID() {
        return reqID;
    }

    /**
     * set requisition id
     * @param reqID
     */
    public void setReqID(int reqID) {
        this.reqID = reqID;
    }

    /**
     * creates the task
     * @return task ID
     */
    public int createTask() {

        //create a new task
        TaskDao taskDao = new TaskDao();
        Task taskEntity = new Task();
        taskEntity.setTaskName(this.taskName);
        taskEntity.setTaskStatus("Active");

        taskEntity.setCreatedDate(LocalDateTime.now());
        taskEntity.setUpdatedDate(LocalDateTime.now());
        int taskID = taskDao.addTask(taskEntity);

        //insert task assignments
        TaskAssignmentDao taskAssignDao = new TaskAssignmentDao();
        TaskAssignment taskAssignEnt = new TaskAssignment();
        taskAssignEnt.setRequisitionID(this.reqID);
        TaskAssignmentPK taskAssignmentPK = new TaskAssignmentPK();
        taskAssignmentPK.setTaskID(taskID);
        taskAssignmentPK.setUserID(this.assignToUserID);
        taskAssignEnt.setTaskuser(taskAssignmentPK);
        taskAssignDao.addTask(taskAssignEnt);
        return taskID;

    }
}
