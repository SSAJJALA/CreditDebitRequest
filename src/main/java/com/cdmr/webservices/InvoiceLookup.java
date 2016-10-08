package com.cdmr.webservices;

import com.cdmr.entity.InvoiceHeader;
import com.cdmr.entity.InvoiceDetail;
import com.cdmr.entity.InvoiceHeaderPK;
import com.cdmr.persistence.InvoiceDetailDao;
import com.cdmr.persistence.InvoiceHeaderDao;

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
        List<InvoiceDetail> invoiceDetails = invoiceDeailDao.getInvoiceDetail(invNum);
        return invoiceDetails;
    }




}
