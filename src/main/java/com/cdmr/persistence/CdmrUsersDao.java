package com.cdmr.persistence;

import com.cdmr.entity.Cdmr;
import com.cdmr.entity.CdmrUsers;
import com.cdmr.entity.Requisition;
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
 * Created by student on 9/22/16.
 */
public class CdmrUsersDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all cdmrs
     *
     * @return All users
     */
    public List<CdmrUsers> getAllUsers() {
        List<CdmrUsers> users = new ArrayList<CdmrUsers>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(CdmrUsers.class).list();
        return users;
    }

    /**
     * retrieve a user given an user id
     *
     * @param userID the user id
     * @return user
     */
    public CdmrUsers getUser(String userID) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CdmrUsers  user = (CdmrUsers) session.get(CdmrUsers.class, userID);
        log.info("User:" + user.getUserID() + "fetched from the database");
        return user;

    }

    /**
     * add an user
     *
     * @param user
     * @return the userID of the inserted user
     */
    public String addUser(CdmrUsers user) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
        String userID = user.getUserID();
        return userID;
    }

    /**
     * delete a user by userID
     * @param userID the User ID
     */
    public void deleteUser(int userID) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CdmrUsers user = (CdmrUsers) session.load(CdmrUsers.class,userID);
        log.info("User:" + user.toString());
        session.delete(user);
        tx.commit();
        log.info("User" + userID + "deleted.");


    }

    /**
     * Update the user
     * @param user
     */

    public void updateUser(CdmrUsers user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();

    }


    public List<CdmrUsers> getCdmrUsersWithFilters(String searchOption, String operand, String value) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Cdmr.class);

        if (!searchOption.equals("all")) {
            c = this.addRestrictions(c, searchOption, operand, value);
        }

        List<CdmrUsers> cdmrUsers = c.list();
        return cdmrUsers;
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
