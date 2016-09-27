package com.cdmr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by student on 9/26/16.
 */
@Entity
@Table(name = "CDMR_COMMENTS")
public class Comment {

    @Column(name = "REQUISITION_ID")
    private int requisitionID;

    @Id
    @Column(name = "COMMENT_ID")
    private int commentID;

    @Column(name = "SEQ_ID")
    private int seqID;

    @Column(name = "COMMENT_TEXT")
    private String comment;

    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @Column(name = "USER_ID")
    private String userID;

    public Comment() {
    }

    public Comment(int requisitionID, int commentID, int seqID, String comment, LocalDate createdDate, String userID) {
        this.requisitionID = requisitionID;
        this.commentID = commentID;
        this.seqID = seqID;
        this.comment = comment;
        this.createdDate = createdDate;
        this.userID = userID;
    }

    public int getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getSeqID() {
        return seqID;
    }

    public void setSeqID(int seqID) {
        this.seqID = seqID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "requisitionID=" + requisitionID +
                ", commentID=" + commentID +
                ", seqID=" + seqID +
                ", comment='" + comment + '\'' +
                ", createdDate=" + createdDate +
                ", userID='" + userID + '\'' +
                '}';
    }
}
