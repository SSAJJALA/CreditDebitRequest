package com.cdmr.persistence;

import com.cdmr.entity.*;
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
 * Created by student on 9/26/16.
 */
public class CdmrAdjustmentsDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all tasks
     *
     * @return All tasks
     */
    public List<CdmrAdjustments> getAllCdmrAdjustments() {
        List<CdmrAdjustments> cdmrAdjs = new ArrayList<CdmrAdjustments>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        cdmrAdjs = session.createCriteria(CdmrAdjustments.class).list();
        return cdmrAdjs;
    }

    /**
     * retrieve all adjustments given an requisition id
     *
     * @param requisitionItem the requisition id
     * @return cdmrAdjs
     */
    public CdmrAdjustments getCdmrAdjs(CdmrAdjustmentsPK requisitionItem) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CdmrAdjustments  cdmrAdjs = (CdmrAdjustments) session.get(CdmrAdjustments.class, requisitionItem);
        return cdmrAdjs;

    }

    /**
     * add a task user assignment
     *
     * @param adj
     * @return the reqItem of the inserted adjustment
     */
    public CdmrAdjustmentsPK addCdmrAdj(CdmrAdjustments adj) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
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
    public void deleteCdmrAdjustment(CdmrAdjustmentsPK reqItem) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CdmrAdjustments cdmrAdjustment = (CdmrAdjustments) session.load(CdmrAdjustments.class, reqItem);
        log.info("CDMR Adjustment:" + reqItem.toString());
        session.delete(cdmrAdjustment);
        tx.commit();
        log.info("CDMR" + reqItem.getRequisitionID() + "with item" + reqItem.getItemNum() + "deleted.");


    }

    /**
     * Update the cdmrAdj
     * @param cdmrAdj
     */

    public void updateCdmrAdjustment(CdmrAdjustments cdmrAdj) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(cdmrAdj);
        tx.commit();

    }

    /**
     * get all task assignments based on search filters
     * @param filters filters
     * @return List<TaskAssignment> list of task assignments
     */

    public List<CdmrAdjustments> getCdmrAdjs(List<Filter> filters) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria c = session.createCriteria(CdmrAdjustments.class);
        List<CdmrAdjustments> cdmrAdjs = null;

        for (Filter filter : filters) {
            String option = filter.getSearchOption();
            String operand = filter.getOperand();
            String value = filter.getSearchValue();

            Object searchValue = null;

            if (option.equals("custNum") ) {
                searchValue = Integer.parseInt(value);
            } else if (option.equals("requisitionID") ) {
                searchValue = Integer.parseInt(value);
                option = "requisitionItem.requisitionID";
            } else if (option.equals("itemNum")) {
                searchValue = Integer.parseInt(value);
                option = "requisitionItem.itemNum";
            } else {
                searchValue = value;
            }

            c = this.addRestrictions(c, option, operand, searchValue);

        }

        cdmrAdjs = c.list();
        return cdmrAdjs;
    }

    /**
     * Add filters to the search
     * @param tempCriteria
     * @param option
     * @param operand
     * @param value
     * @return Criteria with added restrictions
     */

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
        } else if (operand.equals("LIKE")) {
            tempCriteria.add(Restrictions.like(option, value));
        } else if (operand.equals("!=")) {
            tempCriteria.add(Restrictions.ne(option, value));
        }

        return tempCriteria;

    }

    /**
     * get date in local date format
     * @param dob
     * @return date in local date
     */

    private LocalDate formatDate (String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;

    }
}
