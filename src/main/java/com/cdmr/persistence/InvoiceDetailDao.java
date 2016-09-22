package com.cdmr.persistence;

import com.cdmr.entity.InvoiceDetail;
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
 * Created by Siva Sajjala on 9/21/16.
 */
public class InvoiceDetailDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all invoices
     *
     * @return All invoices
     */
    public List<InvoiceDetail> getAllInvoiceDetails() {
        List<InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        invoiceDetails = session.createCriteria(InvoiceDetail.class).list();
        return invoiceDetails;
    }

    /**
     * retrieve a cdmr given an req id
     *
     * @param invNum the requisition id
     * @return invoiceHeader
     */
    public List<InvoiceDetail> getInvoiceDetail(int invNum) {
        List<InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(InvoiceDetail.class);
        criteria.add(Restrictions.eq("invoiceNum", invNum));
        invoiceDetails = criteria.list();
        return invoiceDetails;

    }

    /**
     * add an invoiceHeader
     *
     * @param invoiceDetail
     * @return the invoiceNum of the inserted invoice header
     */
    public int addInvoiceDetail(InvoiceDetail invoiceDetail) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(invoiceDetail);
        tx.commit();
        session.close();
        int invoiceNum = invoiceDetail.getInvoiceNum();
        return invoiceNum;
    }

    /**
     * delete a invoice header by invoiceNum
     * @param invoiceNum the Invoice Num
     * */
    public void deleteInvoiceDetail(int invoiceNum) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        InvoiceDetail invoiceDetail = (InvoiceDetail) session.load(InvoiceDetail.class,invoiceNum);
        log.info("Invoice:" + invoiceDetail.toString());
        session.delete(invoiceDetail);
        tx.commit();
        log.info("Invoice details for " + invoiceNum + "deleted.");


    }

    /**
     * Update the invoiceHeader
     * @param invoiceDetail
     */

    public void updateInvoiceDetail(InvoiceDetail invoiceDetail) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(invoiceDetail);
        tx.commit();

    }

    private LocalDate formatDate (String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;

    }

}
