package com.cdmr.webservices;

import com.cdmr.entity.*;
import com.cdmr.persistence.InvoiceDetailDao;
import com.cdmr.persistence.InvoiceHeaderDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siva Sajjala on 9/20/16.
 */
public class InvoiceLookup {

    private int invNum;

    private int custNum;


    public InvoiceLookup() {
    }


    public InvoiceLookup(int invNum, int custNum) {
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

    public InvoiceHeader getInvoiceHeader() {

        InvoiceHeaderPK invCust = new InvoiceHeaderPK();
        invCust.setCustNum(custNum);
        invCust.setInvoiceNum(invNum);
        InvoiceHeaderDao invoiceHeaderDao = new InvoiceHeaderDao();
        InvoiceHeader invoice = invoiceHeaderDao.getInvoiceHeader(invCust);
        return invoice;
    }

    public List<InvoiceDetail> getInvoiceDetails() {

        InvoiceDetailDao invoiceDeailDao = new InvoiceDetailDao();
        List<Filter> filters = new ArrayList<Filter>();

        //Set filter1
        Filter filter1 = new Filter();
        filter1.setSearchValue(Integer.toString(this.invNum));
        filter1.setOperand("=");
        filter1.setSearchOption("InvNum");
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
