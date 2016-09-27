package com.cdmr.Data;

import java.time.LocalDate;

/**
 * Created by Siva Sajjala on 9/26/16.
 */
public class CDMRComment {
    private String userID;
    private int requisitionID;
    private LocalDate createdDate;

    public CDMRComment() {
    }

    public CDMRComment(String userID, int requisitionID, LocalDate createdDate) {
        this.userID = userID;
        this.requisitionID = requisitionID;
        this.createdDate = createdDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "CDMRComment{" +
                "userID='" + userID + '\'' +
                ", requisitionID=" + requisitionID +
                ", createdDate=" + createdDate +
                '}';
    }
}
