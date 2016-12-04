package com.cdmr.persistence;

import com.cdmr.entity.Requisition;
import com.cdmr.entity.Task;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This is concrete implementation for abstract class GenericDAO. This class take care of all CRUD operations for the the DB table REQUISITION
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-04
 */
public class RequisitionDAOnew extends GenericDAO{
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * get session
     * @return session
     */
    @Override
    protected Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Return a list of all requisitions
     * @return All requisitions
     */
    @Override
    public List<?> getAll() throws HibernateException {
        List<Requisition> reqs = new ArrayList<Requisition>();
        Session session = getSession();
        reqs = (List<Requisition>) session.createCriteria(Requisition.class).list();
        session.close();
        return reqs;
    }

    /**
     * retrieve a requisition given an req id
     *
     * @param t the requisition id
     * @return req
     */
    @Override
    public Object getOne(int t) throws HibernateException {
        Session session = getSession();
        Requisition  req = (Requisition) session.get(Requisition.class, t);
        session.close();
        return req;

    }

    /**
     * add a task
     *
     * @param obj Task object
     * @return the reqID of the inserted task
     */
    @Override
    public int add(Object obj) throws HibernateException {

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Requisition req = (Requisition) obj;
        int reqID = -1;
        try {
            Serializable ser = session.save(req);
            if (ser != null) {
                reqID = (Integer) ser;
            }
            tx.commit();
        } catch (Exception e) {
            throw e;
        }

        session.close();
        return reqID;
    }

    /**
     * Get last inserted requisition id
     * @return reqID
     * @throws HibernateException
     */
    public int getLastReqID() throws HibernateException {
        Session session = getSession();
        String queryString = String.format("SELECT LAST_INSERT_ID() AS LAST_ID FROM REQUISITION");
        int reqID;

        Query query = session.createQuery(queryString);
        reqID = query.getFirstResult();
        session.close();
        return reqID;
    }

    /**
     * delete a requisition by reqID
     * @param t the Req ID
     */
    @Override
    public void delete(int t) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Requisition req = (Requisition) session.load(Requisition.class,t);
        log.info("Requisition" + req.toString());
        session.delete(req);
        tx.commit();
        session.close();
        log.info("Requisition" + t + "deleted.");
    }

    /**
     * Update the requisition
     * @param obj
     */

    @Override
    public void update(Object obj) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Requisition req = (Requisition) obj;
        session.update(req);
        tx.commit();
        session.close();
    }
}
