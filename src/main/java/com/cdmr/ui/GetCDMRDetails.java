package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.entity.Task;
import com.cdmr.entity.TaskAssignment;
import com.cdmr.entity.TaskAssignmentPK;
import com.cdmr.persistence.TaskAssignmentDao;
import com.cdmr.persistence.TaskDao;
import com.cdmr.requisition.GetRequisition;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * GetCDMRDetails class gets the cdmr document from database
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-30
 */
public class GetCDMRDetails {

    private int reqID;
    private int taskID;
    private String userID;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * No arg constructor
     */
    public GetCDMRDetails() {
    }

    /**
     * arg constructor
     * @param reqID
     * @param taskID
     * @param userID
     */
    public GetCDMRDetails(int reqID, int taskID, String userID) {
        this.reqID = reqID;
        this.taskID = taskID;
        this.userID = userID;
    }

    /**
     * get user
     * @return userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * set user id
     * @param userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * get requisition id
     * @return reqID
     */
    public int getReqID() {
        return reqID;
    }

    /**
     * set Req id
     * @param reqID
     */
    public void setReqID(int reqID) {
        this.reqID = reqID;
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
     * Main method to prepare the cdmr details
     * @return CDMR
     */
    public CDMR getCDMR() {

        CDMR cdmr = null;

        if (reqID != 0) {

            cdmr = this.getCDMRUsingReqID(reqID);

        } else if (taskID != 0) {

            TaskAssignmentDao taskAssignmentDao = new TaskAssignmentDao();
            TaskAssignmentPK taskAssignmentPK = new TaskAssignmentPK();
            taskAssignmentPK.setUserID(this.getUserID());
            taskAssignmentPK.setTaskID(this.getTaskID());
            TaskAssignment taskAssignments = taskAssignmentDao.getTask(taskAssignmentPK);
            this.reqID = taskAssignments.getRequisitionID();
            cdmr = this.getCDMRUsingReqID(reqID);

        } else {
            log.info("Unable to fetch CDMR details. Either req id or task id required");
        }

        return cdmr;
    }

    /**
     * get requisition using a requisition id
     * @param reqID
     * @return CDMR
     */
    public CDMR getCDMRUsingReqID(int reqID) {

        CDMR cdmr = null;
        GetRequisition getRequisition = new GetRequisition(reqID);
        cdmr = getRequisition.getRequisition();
        return cdmr;

    }

    /**
     * get task details
     * @return Task
     */
    public Task getTaskDetails() {
        Task task = null;
        TaskDao taskdao = new TaskDao();
        task = taskdao.getTask(taskID);
        return task;
    }
}
