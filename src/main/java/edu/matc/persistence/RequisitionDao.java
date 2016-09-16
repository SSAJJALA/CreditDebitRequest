package edu.matc.persistence;

import edu.matc.entity.Requisition;
import edu.matc.entity.User;
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
 * Created by Siva Sajjala on 9/15/16.
 */
public class RequisitionDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All requisitions
     */
    public List<Requisition> getAllRequisitions() {
        List<Requisition> reqs = new ArrayList<Requisition>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        reqs = session.createCriteria(Requisition.class).list();
        return reqs;
    }

    /**
     * retrieve a requisition given an req id
     *
     * @param reqID the requisition id
     * @return req
     */
    public Requisition getRequisition(int reqID) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Requisition  req = (Requisition) session.get(Requisition.class, reqID);
        return req;

    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
    public int addUser(User user) {
        //TODO add the user and return the id of the inserted user
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("lastName", user.getLastName()));
        User user4 = (User) criteria.uniqueResult();
        int id = user4.getUserid();
        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteUser(int id) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User user2 = (User) session.load(User.class,id);
        log.info("user2:" + user2.toString());
        //user2.setUserid(id);
        session.delete(user2);
        tx.commit();
        log.info("user2 deleted");


    }

    /**
     * Update the user
     * @param user
     */

    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();

    }

    private LocalDate formatDate (String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;

    }

}
