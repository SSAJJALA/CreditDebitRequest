package com.cdmr.persistence;

import com.cdmr.entity.Requisition;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
     * @param req
     * @return the reqID of the inserted record
     */
    public int addRequisition(Requisition req) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(req);
        tx.commit();
        session.close();
        int reqID = getLastReqID();
        return reqID;
    }

    public int getLastReqID() {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        String queryString = String.format("SELECT LAST_INSERT_ID() AS LAST_ID FROM REQUISITION");
        int reqID;

        Query query = session.createQuery(queryString);
        reqID = query.getFirstResult();
        return reqID;


    }

    /**
     * delete a requisition by reqID
     * @param reqID the Req ID
     */
    public void deleteRequisition(int reqID) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Requisition req = (Requisition) session.load(Requisition.class,reqID);
        log.info("Requisition" + req.toString());
        session.delete(req);
        tx.commit();
        log.info("Requisition" + reqID + "deleted.");


    }

    /**
     * Update the requisition
     * @param req
     */

    public void updateReq(Requisition req) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(req);
        tx.commit();

    }

    private LocalDate formatDate (String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;

    }

}
