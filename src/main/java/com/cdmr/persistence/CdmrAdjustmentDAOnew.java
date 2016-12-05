package com.cdmr.persistence;

import com.cdmr.entity.CdmrAdjustments;
import com.cdmr.entity.CdmrAdjustmentsPK;
import com.cdmr.entity.Filter;
import com.cdmr.util.AddRestrictions;
import com.cdmr.util.GetUpdatedCriteria;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This is concrete implementation for abstract class GenericDAO. Fetches from the DB table CDMR_ADJUSTMENTS
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-04
 */
public class CdmrAdjustmentDAOnew extends GenericDAO {
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
     * Return a list of all CDMR adjustments
     * @return List<?> All CDMR adjustments
     */
    @Override
    public List<?> getAll() throws HibernateException {
        List<CdmrAdjustments> cdmrAdjs = new ArrayList<CdmrAdjustments>();
        Session session = getSession();
        cdmrAdjs = session.createCriteria(CdmrAdjustments.class).list();
        session.close();
        return cdmrAdjs;
    }

    /**
     * Retrieve all adjustments given an requisition id
     *
     * @param requisitionItem the requisition id and item number
     * @return cdmrAdjs
     */
    public CdmrAdjustments getCdmrAdjs(CdmrAdjustmentsPK requisitionItem) throws HibernateException {
        Session session = getSession();
        CdmrAdjustments  cdmrAdjs = (CdmrAdjustments) session.get(CdmrAdjustments.class, requisitionItem);
        session.close();
        return cdmrAdjs;

    }

    /**
     * add a cdmr adjustment
     *
     * @param adj CdmrAdjustments
     * @return CdmrAdjustmentsPK the reqItem of the inserted adjustment
     */
    public CdmrAdjustmentsPK addCdmrAdj(CdmrAdjustments adj) throws HibernateException {

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(adj);
        tx.commit();
        session.close();
        CdmrAdjustmentsPK reqItem = adj.getRequisitionItem();
        return reqItem;
    }

    /**
     * delete a cdmr adjustment by reqItem
     * @param reqItem the requisition id and item num
     */
    public void deleteCdmrAdjustment(CdmrAdjustmentsPK reqItem) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        CdmrAdjustments cdmrAdjustment = (CdmrAdjustments) session.load(CdmrAdjustments.class, reqItem);
        log.info("CDMR Adjustment:" + reqItem.toString());
        session.delete(cdmrAdjustment);
        tx.commit();
        session.close();
        log.info("CDMR" + reqItem.getRequisitionID() + "with item" + reqItem.getItemNum() + "deleted.");
    }

    /**
     * Update the cdmrAdj
     * @param obj cdmrAdj
     */

    @Override
    public void update(Object obj) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        CdmrAdjustments cdmrAdj = (CdmrAdjustments) obj;
        session.update(cdmrAdj);
        tx.commit();
        session.close();
    }

    /**
     * get all cdmr adjustments based on search filters
     * @param obj list of filters
     * @return List<CdmrAdjustments> list of cdmr adjustments
     */

    @Override
    public List<?> getWithFilterObjects(List<?> obj) throws HibernateException {
        Session session = getSession();
        Criteria c = session.createCriteria(CdmrAdjustments.class);
        List<CdmrAdjustments> cdmrAdjs = null;
        List<Filter> filters = (List<Filter>) obj;
        AddRestrictions addRestrictions = new AddRestrictions();
        c= new GetUpdatedCriteria().getUpdatedCriteria(c, filters, "CDMR_ADJUSTMENTS");
        cdmrAdjs = c.list();
        session.close();
        return cdmrAdjs;
    }
}
