package com.cdmr.webservices;

import com.cdmr.entity.*;
import com.cdmr.persistence.InvoiceDetailDao;
import com.cdmr.persistence.InvoiceHeaderDao;

import java.util.ArrayList;
import java.util.List;

/**
 * InvoiceLookup is the class to fetch invoice details
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-20
 */
public class InvoiceLookup {

    private int invNum;

    private int custNum;

    /**
     * No arg constructor
     */
    public InvoiceLookup() {
    }

    /**
     * Arg constructor
     * @param invNum invoice number
     * @param custNum customer number
     */
    public InvoiceLookup(int invNum, int custNum) {
        this();
        this.invNum = invNum;
        this.custNum = custNum;
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    /**
     * Method to get invoice header details
     * @return InvoiceHeader invoice header
     */
    public InvoiceHeader getInvoiceHeader() {

        InvoiceHeaderPK invCust = new InvoiceHeaderPK();
        invCust.setCustNum(custNum);
        invCust.setInvoiceNum(invNum);
        InvoiceHeaderDao invoiceHeaderDao = new InvoiceHeaderDao();
        InvoiceHeader invoice = invoiceHeaderDao.getInvoiceHeader(invCust);
        return invoice;
    }

    /**
     * Get invoice details
     * @return InvoiceDetail List of invoice details
     */
    public List<InvoiceDetail> getInvoiceDetails() {

        InvoiceDetailDao invoiceDeailDao = new InvoiceDetailDao();
        List<Filter> filters = new ArrayList<Filter>();

        //Set filter1
        Filter filter1 = new Filter();
        filter1.setSearchValue(Integer.toString(this.invNum));
        filter1.setOperand("=");
        filter1.setSearchOption("invNum");
        filters.add(filter1);

        //Set filter2
        Filter filter2 = new Filter();
        filter2.setSearchValue(Integer.toString(this.custNum));
        filter2.setOperand("=");
        filter2.setSearchOption("custNum");
        filters.add(filter2);

        List<InvoiceDetail> invoiceDetails = invoiceDeailDao.getInvoicesWithFilter(filters);
        return invoiceDetails;
    }




}
