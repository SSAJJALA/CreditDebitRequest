package com.cdmr.requisition;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.CDMRAdjustments;
import com.cdmr.Data.CDMRComment;
import com.cdmr.entity.Comment;
import com.cdmr.entity.Filter;
import com.cdmr.persistence.CommentDao;
import com.cdmr.util.CDMRCommentSeqComparator;
import com.cdmr.util.CommentSeqComparator;
import com.cdmr.util.CreateFilter;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * updateRequisition class updates a CDMR requisition to the database.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-29
 */
public class UpdateRequisition {
    private CDMR cdmr;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * No arg constructor
     */
    public UpdateRequisition() {
    }

    /**
     * constructor with arg
     * @param cdmr cdmr document
     */
    public UpdateRequisition(CDMR cdmr) {
        this();
        this.cdmr = cdmr;
    }

    /**
     * get cdmr
     * @return CDMR
     */
    public CDMR getCdmr() {
        return cdmr;
    }

    /**
     * set CDMR
     * @param cdmr cdmr
     */
    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    /**
     * Main maethod to update the cdmr
     */
    public void updateCDMR() {

        List<CDMRAdjustments> adjs = cdmr.getAdjustments();
        for (CDMRAdjustments adj : adjs) {

            List<CDMRComment> commentsFromUI = adj.getComments();
            int itemNum = adj.getItemNum();
            List<Comment> commentsFromDB = getCommentsFromDB(itemNum);

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


    }

    /**
     * insert comments
     * @param comment comment
     * @param maxSeq maxSeq
     */
    public void insertComment(CDMRComment comment, int maxSeq) {
        maxSeq ++;
        Comment commentEntity = new Comment();
        commentEntity.setUserID(comment.getComment());
        commentEntity.setCreatedDate(comment.getCreatedDate());
        commentEntity.setComment(comment.getComment());
        commentEntity.setRequisitionID(comment.getRequisitionID());
        commentEntity.setSeqID(maxSeq);
        commentEntity.setItemNum(comment.getItemNum());
    }

    /**
     * get comments
     * @param itemNum product number
     * @return list of comments
     */
    public List<Comment> getCommentsFromDB(int itemNum) {
        CommentDao commentsDao = new CommentDao();
        List<Filter> filters = new ArrayList<Filter>();

        //Add first filter
        Filter filter1 = new CreateFilter().getFilter(Integer.toString(cdmr.getRequisitionID()), "=", "requisitionID");
        filters.add(filter1);

        //Add second filter
        Filter filter2 = new CreateFilter().getFilter(Integer.toString(itemNum), "=", "itemNum");
        filters.add(filter2);

        List<Comment> commentsFromDB = commentsDao.getCommentsWithFilter(filters);
        return commentsFromDB;
    }

}
