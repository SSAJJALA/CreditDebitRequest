package com.cdmr.Data;

/**
 * Created by Siva Sajjala on 9/29/16.
 */
public class TaskResponse {

    private int taskID;
    private String taskName;
    private String approvalDecesion;
    private String approverID;

    public TaskResponse() {
    }

    public TaskResponse(int taskID, String taskName, String approvalDecesion, String approverID) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.approvalDecesion = approvalDecesion;
        this.approverID = approverID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getApprovalDecesion() {
        return approvalDecesion;
    }

    public void setApprovalDecesion(String approvalDecesion) {
        this.approvalDecesion = approvalDecesion;
    }

    public String getApproverID() {
        return approverID;
    }

    public void setApproverID(String approverID) {
        this.approverID = approverID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

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
