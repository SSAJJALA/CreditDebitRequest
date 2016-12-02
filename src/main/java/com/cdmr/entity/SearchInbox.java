package com.cdmr.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by student on 9/24/16.
 */
public class SearchInbox {
    private int taskID;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String application;
    private String taskName;
    private String taskStatus;
    private int requisitionID;
    private String userID;
    private String customerName;
    private Double adjAmnt;

    public SearchInbox() {
    }

    public SearchInbox(int taskID, LocalDateTime createdDate, LocalDateTime updatedDate, String application, String taskName, String taskStatus, int requisitionID, String userID, String customerName, Double adjAmnt) {
        this();
        this.taskID = taskID;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.application = application;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.requisitionID = requisitionID;
        this.userID = userID;
        this.customerName = customerName;
        this.adjAmnt = adjAmnt;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getAdjAmnt() {
        return adjAmnt;
    }

    public void setAdjAmnt(Double adjAmnt) {
        this.adjAmnt = adjAmnt;
    }

    @Override
    public String toString() {
        return "SearchInbox{" +
                "taskID=" + taskID +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", application='" + application + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", requisitionID=" + requisitionID +
                ", userID='" + userID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", adjAmnt=" + adjAmnt +
                '}';
    }
}
