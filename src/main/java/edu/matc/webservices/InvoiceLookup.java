package edu.matc.webservices;

import edu.matc.entity.InvoiceHeader;
import edu.matc.persistence.InvoiceHeaderDao;

/**
 * Created by Siva Sajjala on 9/20/16.
 */
public class InvoiceLookup {

    public InvoiceHeader getInvoiceHeader(int invNum) {

        InvoiceHeaderDao invoiceDao = new InvoiceHeaderDao();
        InvoiceHeader invoice = invoiceDao.getInvoiceHeader(invNum);
        return invoice;
    }
}
