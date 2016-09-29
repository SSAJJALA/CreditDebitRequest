package com.cdmr.approval;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.TaskResponse;
import com.cdmr.Task.QueueTask;
import com.cdmr.Task.UpdateTask;
import com.cdmr.entity.Cdmr;
import com.cdmr.entity.CdmrUsers;
import com.cdmr.persistence.CdmrDao;
import com.cdmr.persistence.CdmrUsersDao;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by student on 9/26/16.
 */
public class RouteCDMR {
    private CDMR cdmr;
    private TaskResponse taskResponse;
    private final Logger log = Logger.getLogger(this.getClass());

    public RouteCDMR() {
    }

    public RouteCDMR(CDMR cdmr, TaskResponse taskResponse) {
        this.cdmr = cdmr;
        this.taskResponse = taskResponse;
    }

    public CDMR getCdmr() {
        return cdmr;
    }

    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public TaskResponse getTaskResponse() {
        return taskResponse;
    }

    public void setTaskResponse(TaskResponse taskResponse) {
        this.taskResponse = taskResponse;
    }

    public void routeCDMR() {

        if (taskResponse != null) {
            if (taskResponse.getApprovalDecesion().equals("Approved")) {
                if (taskResponse.getTaskName().equals("DSM Approval")) {

                    this.updateTaskStatus("Complete");

                    //route CDMR to FM
                    int taskID = this.routeToNextApprover("FM");



                } else if (taskResponse.getTaskName().equals("FM Approval")) {

                    this.updateTaskStatus("Complete");
                    this.updateCdmrStatus("Approved");
                    log.info("CDMR final approval received. No more routing required");

                }


            } else if (taskResponse.getApprovalDecesion().equals("Rejected")) {

                this.updateTaskStatus("Completed");
                this.updateCdmrStatus("Rejected");
                log.info("CDMR Rejected");
            }

        } else {

            //New requisition. Route to DSM
            int taskID = this.routeToNextApprover("DSM");

        }
    }

    public void updateTaskStatus(String status) {

        //complete the task
        UpdateTask updateTask = new UpdateTask(taskResponse.getTaskID(), status);
        updateTask.updateTask();
    }

    public void updateCdmrStatus(String status) {

        //update the CDMR status

        CdmrDao cdmrDao = new CdmrDao();
        Cdmr cdmrEnt = cdmrDao.getCdmr(cdmr.getRequisitionID());
        cdmrEnt.setStatus(status);
        cdmrDao.updateCdmr(cdmrEnt);

    }

    public int routeToNextApprover(String role) {

        //Route the cdmr to next approver
        this.updateCdmrStatus("In Progress");
        QueueTask queueTask = new QueueTask();
        CdmrUsersDao usersDao = new CdmrUsersDao();
        List<CdmrUsers> assignToUsers = usersDao.getCdmrUsersWithFilters("role", "=", role);
        queueTask.setAssignToUserID(assignToUsers.get(0).getUserID());
        queueTask.setReqID(cdmr.getRequisitionID());
        queueTask.setTaskName(role + " Approval");
        int taskID = queueTask.createTask();
        log.info(role + " Task created. Task ID is " + taskID );
        return taskID;
    }
}
