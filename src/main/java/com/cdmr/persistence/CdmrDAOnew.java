package com.cdmr.persistence;

import com.cdmr.entity.Cdmr;
import com.cdmr.util.AddRestrictions;
import com.cdmr.util.ConvertToLocalDate;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This is abstract implementation for CDMR table DAO. Fetches from the DB table CDMR.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-03
 */
public class CdmrDAOnew extends GenericDAO {
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
     * get all CDMRs
     * @return List of cdmrs
     * @throws HibernateException
     */
    @Override
    public List<?> getAll() throws HibernateException {
        List<Cdmr> cdmrs = new ArrayList<Cdmr>();
        Session session = getSession();
        cdmrs = (List<Cdmr>) session.createCriteria(Cdmr.class).list();
        session.close();
        return cdmrs;
    }

    /**
     * get CDMR
     * @param reqID
     * @return CDMR object
     * @throws HibernateException
     */
    @Override
    public Object getOne(int reqID) throws HibernateException {
        Session session = getSession();
        Cdmr  cdmr = (Cdmr) session.get(Cdmr.class, reqID);
        session.close();
        return cdmr;

    }

    /**
     * Add a CDMR
     * @param obj
     * @return Requisition ID
     * @throws HibernateException
     */
    @Override
    public int add(Object obj) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Cdmr cdmr = (Cdmr) obj;
        session.save(cdmr);
        tx.commit();
        session.close();
        int reqID = cdmr.getRequisitionID();
        return reqID;

    }

    /**
     * Delete a CDMR
     * @param t requisition id
     * @throws HibernateException
     */
    @Override
    public void delete(int t) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Cdmr cdmr = (Cdmr) session.load(Cdmr.class,t);
        log.info("CDMR:" + cdmr.toString());
        session.delete(cdmr);
        tx.commit();
        session.close();
        log.info("CDMR" + t + "deleted.");
    }

    /**
     * Update a CDMR
     * @param obj CDMR
     * @throws HibernateException
     */
    @Override
    public void update(Object obj) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Cdmr cdmr = (Cdmr) obj;
        session.update(cdmr);
        tx.commit();
        session.close();
    }

    /**
     * Search with filters
     * @param searchOption
     * @param operand
     * @param value
     * @return List of CDMRs
     * @throws HibernateException
     */
    @Override
    public List<?> getWithFilters(String searchOption, String operand, String value) throws HibernateException {
        Session session = getSession();
        Criteria c = session.createCriteria(Cdmr.class);
        AddRestrictions addRestrictions = new AddRestrictions();

        Object searchValue = null;

        if (searchOption.equals("requisitionID")) {
            searchValue = Integer.parseInt(value);
        } else if (searchOption.equals("cdmrDate")) {
            searchValue = new ConvertToLocalDate().formatDate(value);
        } else {
            searchValue = value;
        }

        log.info("searchOption: " + searchOption);
        log.info("operand: " + operand);
        log.info("searchValue: " + searchValue);

        if (!searchOption.equals("all")) {
            c= addRestrictions.addRestrictions(c, searchOption, operand, searchValue);
        }

        List<Cdmr> cdmrs = c.list();
        session.close();
        log.info("cdmrs: " + cdmrs.toString());
        return cdmrs;

    }



}
