package com.cdmr.approval;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.TaskResponse;
import com.cdmr.Task.QueueTask;
import com.cdmr.Task.UpdateTask;
import com.cdmr.entity.Cdmr;
import com.cdmr.entity.CdmrUsers;
import com.cdmr.persistence.CdmrDAOnew;
//import com.cdmr.persistence.CdmrDao;
import com.cdmr.persistence.CdmrUsersDao;
import com.cdmr.requisition.UpdateRequisition;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * RouteCDMR program is the routing engine for CDMR application. This class identifies the next approver and assigns the task in the approver's inbox.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-26
 */
public class RouteCDMR {
    private CDMR cdmr;
    private TaskResponse taskResponse;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * No arg constructor
     */
    public RouteCDMR() {
    }

    /**
     * constructor with args cdmr, taskResponse
     * @param cdmr object that contains the information of the cdmr details
     * @param taskResponse approvers's task response document
     */
    public RouteCDMR(CDMR cdmr, TaskResponse taskResponse) {
        this();
        this.cdmr = cdmr;
        this.taskResponse = taskResponse;
    }

    /**
     * get the cdmr document
     * @return cdmr
     */
    public CDMR getCdmr() {
        return cdmr;
    }

    /**
     * set the cdmr document
     * @param cdmr cdmr data
     */
    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    /**
     * get the task response
     * @return TaskResponse
     */
    public TaskResponse getTaskResponse() {
        return taskResponse;
    }

    /**
     * set the task response
     * @param taskResponse task response document
     */
    public void setTaskResponse(TaskResponse taskResponse) {
        this.taskResponse = taskResponse;
    }

    /**
     * Main routing logic that takes care of approvals, rejections and next routing.
     * @return message string response
     */
    public String routeCDMR() {


        //Update CDMR comments (if any)
        UpdateRequisition updateReq = new UpdateRequisition(cdmr);
        updateReq.updateCDMR();
        String message = null;

        if (taskResponse == null) {
            message = this.routeToDSM();
        } else {
            message = this.handleRouting();
        }

        /**
        if (taskResponse != null) {
            if (taskResponse.getApprovalDecesion().equals("Approved")) {
                if (taskResponse.getTaskName().equals("DSM Approval")) {

                    this.updateTaskStatus("Complete");

                    //route CDMR to FM
                    int taskID = this.routeToNextApprover("FM");
                    message = "CDMR routed to FM";



                } else if (taskResponse.getTaskName().equals("FM Approval")) {

                    this.updateTaskStatus("Complete");
                    this.updateCdmrStatus("Approved");
                    log.info("CDMR final approval received. No more routing required");
                    message = "CDMR final approval received. No more routing required";

                }


            } else if (taskResponse.getApprovalDecesion().equals("Rejected")) {

                this.updateTaskStatus("Complete");
                this.updateCdmrStatus("Rejected");
                log.info("CDMR Rejected");
                message = "CDMR Rejected";
            }

        } else {

            //New requisition. Route to DSM
            int taskID = this.routeToNextApprover("DSM");
            message = "CDMR routed to DSM";

        }
         **/

        return message;
    }


    /**
     * Method to update te task status to complete
     * @param status task approval status
     */
    public void updateTaskStatus(String status) {

        //complete the task
        UpdateTask updateTask = new UpdateTask(taskResponse.getTaskID(), status);
        updateTask.updateTask();
    }

    /**
     * Update CDMR status to approved, rejected, in progress
     * @param status cdmr status
     */
    public void updateCdmrStatus(String status) {

        //update the CDMR status

        /**
        CdmrDao cdmrDao = new CdmrDao();
        Cdmr cdmrEnt = cdmrDao.getCdmr(cdmr.getRequisitionID());
        cdmrEnt.setStatus(status);
        cdmrDao.updateCdmr(cdmrEnt);
         **/

        CdmrDAOnew cdmrDao = new CdmrDAOnew();
        Cdmr cdmrEnt = (Cdmr) cdmrDao.getOne(cdmr.getRequisitionID());
        cdmrEnt.setStatus(status);
        cdmrDao.update(cdmrEnt);

    }

    /**
     * Method routes to next approver based on the previous approver and approval decesion
     * @param role role of the user
     * @return taskID of the next approver
     */
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


    /**
     * Handle task assignment to DSM
     * @return message
     */
    public String routeToDSM() {
        //New requisition. Route to DSM
        int taskID = this.routeToNextApprover("DSM");
        String message = "CDMR routed to DSM";
        return message;
    }

    /**
     * Handle routing
     * @return message status
     */
    public String handleRouting() {
        String message = null;
        switch (taskResponse.getApprovalDecesion()) {
            case "Approved":
                message = this.handleApproval();
                break;
            case "Rejected":
                message = this.handleRejection();
                break;
        }
        return message;
    }

    /**
     * Handle DSM and FM approvals
     * @return message status
     */
    public String handleApproval() {
        String message = null;
        switch (taskResponse.getTaskName()) {
            case "DSM Approval":
                this.updateTaskStatus("Complete");
                //route CDMR to FM
                int taskID = this.routeToNextApprover("FM");
                message = "CDMR routed to FM";
                break;
            case "FM Approval":
                this.updateTaskStatus("Complete");
                this.updateCdmrStatus("Approved");
                log.info("CDMR final approval received. No more routing required");
                message = "CDMR final approval received. No more routing required";
                break;
        }
        return message;
    }

    /**
     * Handle Rejections
     * @return message status
     */
    public String handleRejection() {
        String message = null;
        this.updateTaskStatus("Complete");
        this.updateCdmrStatus("Rejected");
        log.info("CDMR Rejected");
        message = "CDMR Rejected";
        return message;
    }
}
