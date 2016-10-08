package com.cdmr.persistence;

import com.cdmr.entity.InvoiceHeader;
import com.cdmr.entity.InvoiceHeaderPK;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by student on 9/19/16.
 */
public class InvoiceHeaderDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all invoices
     *
     * @return All invoices
     */
    public List<InvoiceHeader> getAllInvoices() {
        List<InvoiceHeader> invoices = new ArrayList<InvoiceHeader>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        invoices = session.createCriteria(InvoiceHeader.class).list();
        return invoices;
    }

    /**
     * retrieve a cdmr given an req id
     *
     * @param invCust the requisition id
     * @return invoiceHeader
     */
    public InvoiceHeader getInvoiceHeader(InvoiceHeaderPK invCust) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        InvoiceHeader  invoiceHeader = (InvoiceHeader) session.get(InvoiceHeader.class, invCust);
        return invoiceHeader;

    }

    /**
     * add an invoiceHeader
     *
     * @param invoiceHeader
     * @return the invoiceNum of the inserted invoice header
     */
    public int addInvoiceHeader(InvoiceHeader invoiceHeader) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(invoiceHeader);
        tx.commit();
        session.close();
        InvoiceHeaderPK invCust = invoiceHeader.getInvCustomer();
        int invoiceNum = invCust.getCustNum();
        return invoiceNum;
    }

    /**
     * delete a invoice header by invoiceNum
     * @param invCust
     * */
    public void deleteInvoiceHeader(InvoiceHeaderPK invCust) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        InvoiceHeader invoiceHeader = (InvoiceHeader) session.load(InvoiceHeader.class,invCust);
        log.info("Invoice:" + invoiceHeader.toString());
        session.delete(invoiceHeader);
        tx.commit();
        log.info("Invoice" + invoiceHeader.getInvCustomer().getInvoiceNum() + "for customer" + invoiceHeader.getInvCustomer().getCustNum() + "deleted.");


    }

    /**
     * Update the invoiceHeader
     * @param invoiceHeader
     */

    public void updateInvoiceHeader(InvoiceHeader invoiceHeader) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(invoiceHeader);
        tx.commit();

    }

    private LocalDate formatDate (String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;

    }

}
