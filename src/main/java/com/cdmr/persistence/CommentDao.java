package com.cdmr.persistence;

import com.cdmr.entity.Cdmr;
import com.cdmr.entity.Comment;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Siva Sajjala on 9/26/16.
 */
public class CommentDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all comments
     *
     * @return All comments
     */
    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<Comment>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        comments = session.createCriteria(Comment.class).list();
        return comments;
    }

    /**
     * retrieve a comment given an comment id
     *
     * @param commentID the comment id
     * @return Comments
     */
    public Comment getComments(int commentID) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Comment comment = (Comment) session.get(Comment.class, commentID);
        return comment;

    }

    /**
     * add a comment
     *
     * @param comment
     * @return the commentID of the inserted comment
     */
    public int addComment(Comment comment) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(comment);
        tx.commit();
        session.close();
        int commentID = comment.getCommentID();
        return commentID;
    }

    /**
     * delete a comment by commentID
     * @param commentID the comment ID
     */
    public void deleteComment(int commentID) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Comment comment = (Comment) session.load(Comment.class,commentID);
        log.info("Comment:" + comment.toString());
        session.delete(comment);
        tx.commit();
        log.info("Comment" + commentID + "deleted.");


    }

    /**
     * Update the comment
     * @param comment
     */

    public void updateComment(Comment comment) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(comment);
        tx.commit();

    }

    public List<Comment> getComments(String searchOption, String operand, String value) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Comment.class);

        Object searchValue = null;

        if (searchOption.equals("requisitionID")) {
            searchValue = Integer.parseInt(value);
        } else if (searchOption.equals("createdDate")) {
            searchValue = formatDate(value);
        } else {
            searchValue = value;
        }

        if (!searchOption.equals("all")) {
            c = this.addRestrictions(c, searchOption, operand, searchValue);
        }

        List<Comment> comments = c.list();
        return comments;
    }

    public Criteria addRestrictions(Criteria tempCriteria, String option, String operand, Object value) {

        if (operand.equals("="))  {
            tempCriteria.add(Restrictions.eq(option, value));
        } else if (operand.equals(">")) {
            tempCriteria.add(Restrictions.gt(option, value));
        } else if (operand.equals("<")) {
            tempCriteria.add(Restrictions.lt(option, value));
        } else if (operand.equals(">=")) {
            tempCriteria.add(Restrictions.ge(option, value));
        } else if (operand.equals("<=")) {
            tempCriteria.add(Restrictions.le(option, value));
        } else if (operand.equals("like")) {
            tempCriteria.add(Restrictions.like(option, value));
        } else if (operand.equals("!=")) {
            tempCriteria.add(Restrictions.ne(option, value));
        }

        return tempCriteria;

    }

    private LocalDate formatDate (String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;

    }
}
