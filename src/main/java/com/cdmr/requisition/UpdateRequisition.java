package com.cdmr.requisition;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.CDMRComment;
import com.cdmr.entity.Comment;
import com.cdmr.persistence.CommentDao;
import com.cdmr.util.CDMRCommentSeqComparator;
import com.cdmr.util.CommentSeqComparator;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;

/**
 * Created by student on 9/29/16.
 */
public class UpdateRequisition {
    private CDMR cdmr;
    private final Logger log = Logger.getLogger(this.getClass());

    public UpdateRequisition() {
    }

    public UpdateRequisition(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public CDMR getCdmr() {
        return cdmr;
    }

    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public void updateCDMR() {
        CommentDao commentsDao = new CommentDao();
        List<Comment> commentsFromDB = commentsDao.getCommentsWithFilter("requisitionID", "=", Integer.toString(cdmr.getRequisitionID()));
        List<CDMRComment> commentsFromUI = cdmr.getComments();

        Collections.sort(commentsFromDB, new CommentSeqComparator());
        Collections.sort(commentsFromUI, new CDMRCommentSeqComparator());

        //get max seq ID from db results
        int maxSeq = 0;
        if (commentsFromDB != null && !commentsFromDB.isEmpty()) {
            maxSeq = commentsFromDB.get(commentsFromDB.size() - 1).getSeqID();
        }

        for (CDMRComment tempCDMRComment : commentsFromUI) {
            int uiseqID = tempCDMRComment.getSeqID();
            boolean commentExists = false;
            for (Comment tempComment : commentsFromDB) {
                if (uiseqID == tempComment.getSeqID()) {
                    commentExists = true;
                }
            }
            if (!commentExists) {
                this.insertComment(tempCDMRComment, maxSeq);
                log.info("New comment added for requisition " + cdmr.getRequisitionID());
            }

        }


    }

    public void insertComment(CDMRComment comment, int maxSeq) {
        maxSeq ++;
        Comment commentEntity = new Comment();
        commentEntity.setUserID(comment.getComment());
        commentEntity.setCreatedDate(comment.getCreatedDate());
        commentEntity.setComment(comment.getComment());
        commentEntity.setRequisitionID(comment.getRequisitionID());
        commentEntity.setSeqID(maxSeq);
    }


}
