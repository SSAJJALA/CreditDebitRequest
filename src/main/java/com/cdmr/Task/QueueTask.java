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
 * Created by student on 9/29/16.
 */
public class QueueTask {

    private String assignToUserID;
    private String taskName;
    private int reqID;


    public QueueTask() {
    }

    public QueueTask(String assignToUserID, String taskName, int reqID) {
        this.assignToUserID = assignToUserID;
        this.taskName = taskName;
        this.reqID = reqID;
    }

    public String getAssignToUserID() {
        return assignToUserID;
    }

    public void setAssignToUserID(String assignToUserID) {
        this.assignToUserID = assignToUserID;
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
