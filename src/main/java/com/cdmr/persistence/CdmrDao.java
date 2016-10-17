package com.cdmr.persistence;

import com.cdmr.entity.Cdmr;
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
 * Created by student on 9/16/16.
 */
public class CdmrDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all cdmrs
     *
     * @return All cdmrs
     */
    public List<Cdmr> getAllCdmrs() {
        List<Cdmr> cdmrs = new ArrayList<Cdmr>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        cdmrs = session.createCriteria(Cdmr.class).list();
        return cdmrs;
    }

    /**
     * retrieve a cdmr given an req id
     *
     * @param reqID the requisition id
     * @return cdmr
     */
    public Cdmr getCdmr(int reqID) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Cdmr  cdmr = (Cdmr) session.get(Cdmr.class, reqID);
        return cdmr;

    }

    /**
     * add a cdmr
     *
     * @param cdmr
     * @return the reqID of the inserted cdmr
     */
    public int addCdmr(Cdmr cdmr) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(cdmr);
        tx.commit();
        session.close();
        int reqID = cdmr.getRequisitionID();
        return reqID;
    }

    /**
     * delete a cdmr by reqID
     * @param reqID the Req ID
     */
    public void deleteCdmr(int reqID) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Cdmr cdmr = (Cdmr) session.load(Cdmr.class,reqID);
        log.info("CDMR:" + cdmr.toString());
        session.delete(cdmr);
        tx.commit();
        log.info("CDMR" + reqID + "deleted.");


    }

    /**
     * Update the cdmr
     * @param cdmr
     */

    public void updateCdmr(Cdmr cdmr) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(cdmr);
        tx.commit();

    }

    public List<Cdmr> getCdmrs(String searchOption, String operand, String value) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Cdmr.class);

        Object searchValue = null;

        if (searchOption.equals("requisitionID")) {
            searchValue = Integer.parseInt(value);
        } else if (searchOption.equals("cdmrDate")) {
            searchValue = formatDate(value);
        } else {
            searchValue = value;
        }

        log.info("searchOption: " + searchOption);
        log.info("operand: " + operand);
        log.info("searchValue: " + searchValue);

        if (!searchOption.equals("all")) {
            c = this.addRestrictions(c, searchOption, operand, searchValue);
        }

        List<Cdmr> cdmrs = c.list();
        log.info("cdmrs: " + cdmrs.toString());
        return cdmrs;
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
