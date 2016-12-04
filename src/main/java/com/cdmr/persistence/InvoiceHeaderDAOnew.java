package com.cdmr.persistence;

import com.cdmr.entity.InvoiceHeader;
import com.cdmr.entity.InvoiceHeaderPK;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This is concrete implementation for abstact class GenericDAO. Fetches from the DB table INVOICE_HEADER
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-04
 */
public class InvoiceHeaderDAOnew  extends GenericDAO{
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /** Return a list of all invoices
     *
     * @return All invoices
     */
    @Override
    public List<?> getAll() {
        List<InvoiceHeader> invoices = new ArrayList<InvoiceHeader>();
        Session session = getSession();
        invoices = (List<InvoiceHeader>) session.createCriteria(InvoiceHeader.class).list();
        session.close();
        return invoices;
    }

    /**
     * retrieve invoice header given an invoice and customer
     *
     * @param invCust the invoice and customer
     * @return invoiceHeader
     */
    public InvoiceHeader getInvoiceHeader(InvoiceHeaderPK invCust) throws HibernateException {
        Session session = getSession();
        InvoiceHeader  invoiceHeader = (InvoiceHeader) session.get(InvoiceHeader.class, invCust);
        session.close();
        return invoiceHeader;

    }

    /**
     * add an invoiceHeader
     *
     * @param obj
     * @return the invoiceNum of the inserted invoice header
     */
    @Override
    public int add(Object obj) throws HibernateException {

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        InvoiceHeader invoiceHeader = (InvoiceHeader) obj;
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
    public void deleteInvoiceHeader(InvoiceHeaderPK invCust) throws HibernateException {

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        InvoiceHeader invoiceHeader = (InvoiceHeader) session.load(InvoiceHeader.class,invCust);
        log.info("Invoice:" + invoiceHeader.toString());
        session.delete(invoiceHeader);
        tx.commit();
        session.close();
        log.info("Invoice" + invoiceHeader.getInvCustomer().getInvoiceNum() + "for customer" + invoiceHeader.getInvCustomer().getCustNum() + "deleted.");


    }

    /**
     * Update the invoiceHeader
     * @param obj invoiceHeader object
     */

    @Override
    public void update(Object obj) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        InvoiceHeader invoiceHeader = (InvoiceHeader) obj;
        session.update(invoiceHeader);
        tx.commit();
        session.close();

    }
}
