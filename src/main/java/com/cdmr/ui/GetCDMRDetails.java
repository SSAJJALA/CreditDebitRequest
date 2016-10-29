package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.entity.Task;
import com.cdmr.entity.TaskAssignment;
import com.cdmr.persistence.TaskAssignmentDao;
import com.cdmr.persistence.TaskDao;
import com.cdmr.requisition.GetRequisition;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by student on 9/30/16.
 */
public class GetCDMRDetails {

    private int reqID;
    private int taskID;
    private final Logger log = Logger.getLogger(this.getClass());

    public GetCDMRDetails() {
    }

    public GetCDMRDetails(int reqID, int taskID) {
        this.reqID = reqID;
        this.taskID = taskID;
    }

    public int getReqID() {
        return reqID;
    }

    public void setReqID(int reqID) {
        this.reqID = reqID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public CDMR getCDMR() {

        CDMR cdmr = null;

        if (reqID != 0) {

            cdmr = this.getCDMRUsingReqID(reqID);

        } else if (taskID != 0) {

            TaskAssignmentDao taskAssignmentDao = new TaskAssignmentDao();
            List<TaskAssignment> taskAssignments = taskAssignmentDao.getTask(taskID);
            this.reqID = taskAssignments.get(0).getRequisitionID();
            cdmr = this.getCDMRUsingReqID(reqID);

        } else {
            log.info("Unable to fetch CDMR details. Either req id or task id required");
        }

        return cdmr;
    }


    public CDMR getCDMRUsingReqID(int reqID) {

        CDMR cdmr = null;
        GetRequisition getRequisition = new GetRequisition(reqID);
        getRequisition.getRequisition();
        cdmr = getRequisition.getCdmr();
        return cdmr;

    }

    public Task getTaskDetails(int taskID) {
        Task task = null;
        TaskDao taskdao = new TaskDao();
        task = taskdao.getTask(taskID);
        return task;
    }
}
