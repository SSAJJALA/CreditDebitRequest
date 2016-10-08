package com.cdmr.webservices;

import com.cdmr.entity.InvoiceDetail;
import com.cdmr.entity.InvoiceHeader;
import com.cdmr.entity.InvoiceHeaderPK;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Siva Sajjala on 10/8/16.
 */
public class InvoiceLookupTest {

    InvoiceLookup invoiceLookup = null;

    @Before
    public void setUp() {
        invoiceLookup = new InvoiceLookup();
    }
    @Test
    public void getInvoiceHeader() throws Exception {

        invoiceLookup.setCustNum(1000);
        invoiceLookup.setInvNum(2345);
        InvoiceHeader invHeader = invoiceLookup.getInvoiceHeader();
        assertEquals("Invoice header doesn't match", invHeader.getInvCustomer().getInvoiceNum(), 2345);
    }


}