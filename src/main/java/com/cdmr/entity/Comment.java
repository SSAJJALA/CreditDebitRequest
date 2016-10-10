package com.cdmr.entity;

import com.cdmr.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "COMMENT_ID")
    private int commentID;

    @Column(name = "ITEM_NUM")
    private int itemNum;

    @Column(name = "SEQ_ID")
    private int seqID;

    @Column(name = "COMMENT_TEXT")
    private String comment;

    @Column(name = "CREATED_DATE")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate createdDate;

    @Column(name = "USER_ID")
    private String userID;

    public Comment() {
    }

    public Comment(int requisitionID, int commentID, int itemNum, int seqID, String comment, LocalDate createdDate, String userID) {
        this.requisitionID = requisitionID;
        this.commentID = commentID;
        this.itemNum = itemNum;
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

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "requisitionID=" + requisitionID +
                ", commentID=" + commentID +
                ", itemNum=" + itemNum +
                ", seqID=" + seqID +
                ", comment='" + comment + '\'' +
                ", createdDate=" + createdDate +
                ", userID='" + userID + '\'' +
                '}';
    }
}
