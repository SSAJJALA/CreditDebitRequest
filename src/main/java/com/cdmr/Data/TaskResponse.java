package com.cdmr.Data;

/**
 * This class is to hold the task response details
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-29
 */
public class TaskResponse {

    private int taskID;
    private String taskName;
    private String approvalDecesion;
    private String approverID;

    /**
     * No arg constructor
     */
    public TaskResponse() {
    }

    /**
     * arg constructor
     * @param taskID
     * @param taskName
     * @param approvalDecesion
     * @param approverID
     */
    public TaskResponse(int taskID, String taskName, String approvalDecesion, String approverID) {
        this();
        this.taskID = taskID;
        this.taskName = taskName;
        this.approvalDecesion = approvalDecesion;
        this.approverID = approverID;
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
     * @param  taskID
     */
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    /**
     * get the approvers decesion
     * @return approvalDecesion
     */
    public String getApprovalDecesion() {
        return approvalDecesion;
    }

    /**
     * set the approvers decesion
     * @param  approvalDecesion
     */
    public void setApprovalDecesion(String approvalDecesion) {
        this.approvalDecesion = approvalDecesion;
    }

    /**
     * get the approver id
     * @return approverID
     */
    public String getApproverID() {
        return approverID;
    }

    /**
     * set the approver id
     * @param  approverID
     */
    public void setApproverID(String approverID) {
        this.approverID = approverID;
    }

    /**
     * get the task name
     * @return taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * set the task name
     * @param  taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * toString method to display the task info
     * @return string
     */
    @Override
    public String toString() {
        return "TaskResponse{" +
                "taskID=" + taskID +
                ", taskName='" + taskName + '\'' +
                ", approvalDecesion='" + approvalDecesion + '\'' +
                ", approverID='" + approverID + '\'' +
                '}';
    }
}
