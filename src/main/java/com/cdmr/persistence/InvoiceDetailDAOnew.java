package com.cdmr.persistence;

import com.cdmr.entity.Filter;
import com.cdmr.entity.InvoiceDetail;
import com.cdmr.entity.InvoiceDetailPK;
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
 * This is concrete implementation for abstract class GenericDAO. Fetches from the DB table INVOICE_DETAIL
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-04
 */
public class InvoiceDetailDAOnew extends GenericDAO{
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Return a list of all invoices
     * @return List<?> All invoices
     */
    @Override
    public List<?> getAll() throws HibernateException {
        List<InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
        Session session = getSession();
        invoiceDetails = (List<InvoiceDetail>) session.createCriteria(InvoiceDetail.class).list();
        session.close();
        return invoiceDetails;
    }

    /**
     * retrieve a invoice details object given invoice details primary key (invoice number and item number)
     *
     * @param invItem the invoice number and item number
     * @return InvoiceDetail invoice details
     */
    public InvoiceDetail getInvoiceDetail(InvoiceDetailPK invItem) throws HibernateException {
        Session session = getSession();
        InvoiceDetail invoiceDetails = (InvoiceDetail) session.get(InvoiceDetail.class, invItem);
        session.close();
        return invoiceDetails;

    }

    /**
     * add invoice details to details table
     *
     * @param obj Invoice details object
     * @return the invoiceNum of the inserted invoice header
     */
    @Override
    public int add(Object obj) throws HibernateException {

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        InvoiceDetail invoiceDetail = (InvoiceDetail) obj;
        session.save(invoiceDetail);
        tx.commit();
        session.close();
        int invoiceNum = invoiceDetail.getInvItem().getInvNum();
        return invoiceNum;
    }

    /**
     * delete a invoice details by invoiceNum
     * @param invItem the Invoice Num, item num
     * */
    public void deleteInvoiceDetail(InvoiceDetailPK invItem) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        InvoiceDetail invoiceDetail = (InvoiceDetail) session.load(InvoiceDetail.class,invItem);
        log.info("Invoice:" + invoiceDetail.toString());
        session.delete(invoiceDetail);
        tx.commit();
        session.close();
        log.info("Invoice details for " + invoiceDetail.getInvItem().getInvNum() + "and item " + invoiceDetail.getInvItem().getItemNum() + " deleted.");
    }

    /**
     * Update the invoice details object
     * @param obj invoice Detail
     */

    @Override
    public void update(Object obj) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        InvoiceDetail invoiceDetail = (InvoiceDetail) obj;
        session.update(invoiceDetail);
        tx.commit();
        session.close();
    }

    /**
     * get all invoice details based on search filters
     * @param obj filters
     * @return invoiceDetails list of invoice details
     */
    @Override
    public List<?> getWithFilterObjects(List<?> obj) throws HibernateException {
        Session session = getSession();
        Criteria c = session.createCriteria(InvoiceDetail.class);
        List<InvoiceDetail> invoiceDetails = null;
        List<Filter> filters = (List<Filter>) obj;
        c= new GetUpdatedCriteria().getUpdatedCriteria(c, filters);
        /**
        AddRestrictions addRestrictions = new AddRestrictions();

        for (Filter filter : filters) {
            String option = filter.getSearchOption();
            String operand = filter.getOperand();
            String value = filter.getSearchValue();

            Object searchValue = null;

            if (option.equals("custNum")) {
                searchValue = Integer.parseInt(value);
            } else if (option.equals("invNum")) {
                option = "invItem.invNum";
                searchValue = Integer.parseInt(value);
            } else if (option.equals("itemNum")) {
                option = "invItem.itemNum";
                searchValue = Integer.parseInt(value);
            } else {
                searchValue = value;
            }

            c= addRestrictions.addRestrictions(c, option, operand, searchValue);

        }
         **/

        invoiceDetails = c.list();
        session.close();
        return invoiceDetails;
    }

}
