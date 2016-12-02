package com.cdmr.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * This class is to hold the CDMR comments
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-26
 */
public class CDMRComment {
    private String userID;
    private int requisitionID;
    private int itemNum;
    private LocalDateTime createdDate;
    private String comment;
    private int seqID;

    /**
     * No arg constructor
     */
    public CDMRComment() {
    }

    /**
     * Constructor with args
     * @param userID
     * @param requisitionID
     * @param itemNum
     * @param createdDate
     * @param comment
     * @param seqID
     */
    public CDMRComment(String userID, int requisitionID, int itemNum, LocalDateTime createdDate, String comment, int seqID) {
        this();
        this.userID = userID;
        this.requisitionID = requisitionID;
        this.itemNum = itemNum;
        this.createdDate = createdDate;
        this.comment = comment;
        this.seqID = seqID;
    }

    /**
     * get the user id
     * @return userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * set the user id
     * @param  userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * get the requisition id
     * @return requisitionID
     */
    public int getRequisitionID() {
        return requisitionID;
    }

    /**
     * set the requisition id
     * @param  requisitionID
     */
    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    /**
     * get the created date
     * @return createdDate
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * set the created date
     * @param  createdDate
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * get the comment field
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * set the comment field
     * @param  comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * get the seq id
     * @return seqID
     */
    public int getSeqID() {
        return seqID;
    }

    /**
     * set the seq id
     * @param  seqID
     */
    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    /**
     * get the item number
     * @return itemNum
     */
    public int getItemNum() {
        return itemNum;
    }

    /**
     * set the item number
     * @param  itemNum
     */
    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    /**
     * toString method to display the cdmr comments info
     * @return string
     */
    @Override
    public String toString() {
        return "CDMRComment{" +
                "userID='" + userID + '\'' +
                ", requisitionID=" + requisitionID +
                ", itemNum=" + itemNum +
                ", createdDate=" + createdDate +
                ", comment='" + comment + '\'' +
                ", seqID=" + seqID +
                '}';
    }
}
