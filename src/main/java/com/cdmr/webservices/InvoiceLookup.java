package com.cdmr.webservices;

import com.cdmr.entity.InvoiceHeader;
import com.cdmr.entity.InvoiceDetail;
import com.cdmr.persistence.InvoiceDetailDao;
import com.cdmr.persistence.InvoiceHeaderDao;

import java.util.List;

/**
 * Created by Siva Sajjala on 9/20/16.
 */
public class InvoiceLookup {

    public InvoiceHeader getInvoiceHeader(int invNum) {

        InvoiceHeaderDao invoiceDao = new InvoiceHeaderDao();
        InvoiceHeader invoice = invoiceDao.getInvoiceHeader(invNum);
        return invoice;
    }

    public List<InvoiceDetail> getInvoiceDetails(int invNum) {

        InvoiceDetailDao invoiceDeailDao = new InvoiceDetailDao();
        List<InvoiceDetail> invoiceDetails = invoiceDeailDao.getInvoiceDetail(invNum);
        return invoiceDetails;
    }




}
