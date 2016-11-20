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
     * @param invItem the requisition id
     * @return invoiceHeader
     */
    public InvoiceDetail getInvoiceDetail(InvoiceDetailPK invItem) {
        //List<InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        InvoiceDetail invoiceDetails = (InvoiceDetail) session.get(InvoiceDetail.class, invItem);
        //Criteria criteria = session.createCriteria(InvoiceDetail.class);
        //criteria.add(Restrictions.eq("invoiceNum", invItem.getInvNum()));
        //invoiceDetails = criteria.list();
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
        int invoiceNum = invoiceDetail.getInvItem().getInvNum();
        return invoiceNum;
    }

    /**
     * delete a invoice header by invoiceNum
     * @param invItem the Invoice Num, item num
     * */
    public void deleteInvoiceDetail(InvoiceDetailPK invItem) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        InvoiceDetail invoiceDetail = (InvoiceDetail) session.load(InvoiceDetail.class,invItem);
        log.info("Invoice:" + invoiceDetail.toString());
        session.delete(invoiceDetail);
        tx.commit();
        log.info("Invoice details for " + invoiceDetail.getInvItem().getInvNum() + "and item " + invoiceDetail.getInvItem().getItemNum() + " deleted.");


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

    /**
     * get all invoice details based on search filters
     * @param filters filters
     * @return invoiceDetails list of invoice details
     */

    public List<InvoiceDetail> getInvoicesWithFilter(List<Filter> filters) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria c = session.createCriteria(InvoiceDetail.class);
        List<InvoiceDetail> invoiceDetails = null;

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

            c = this.addRestrictions(c, option, operand, searchValue);

        }

        invoiceDetails = c.list();
        return invoiceDetails;
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
            value = "%"+value+"%";
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
