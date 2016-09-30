package com.cdmr.Data;

import java.time.LocalDate;

/**
 * Created by Siva Sajjala on 9/26/16.
 */
public class CDMRComment {
    private String userID;
    private int requisitionID;
    private LocalDate createdDate;
    private String comment;
    private int seqID;

    public CDMRComment() {
    }

    public CDMRComment(String userID, int requisitionID, LocalDate createdDate, String comment, int seqID) {
        this.userID = userID;
        this.requisitionID = requisitionID;
        this.createdDate = createdDate;
        this.comment = comment;
        this.seqID = seqID;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSeqID() {
        return seqID;
    }

    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    @Override
    public String toString() {
        return "CDMRComment{" +
                "userID='" + userID + '\'' +
                ", requisitionID=" + requisitionID +
                ", createdDate=" + createdDate +
                ", comment='" + comment + '\'' +
                ", seqID=" + seqID +
                '}';
    }
}
