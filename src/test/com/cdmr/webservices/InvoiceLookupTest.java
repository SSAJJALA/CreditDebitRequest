package com.cdmr.webservices;

import com.cdmr.entity.InvoiceDetail;
import com.cdmr.entity.InvoiceHeader;
import com.cdmr.entity.InvoiceHeaderPK;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Siva Sajjala on 10/8/16.
 */
public class InvoiceLookupTest {

    InvoiceLookup invoiceLookup = null;
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp() {
        invoiceLookup = new InvoiceLookup();
    }
    @Test
    public void getInvoiceHeader() throws Exception {
        InvoiceHeader invHeader = null;
        invoiceLookup.setCustNum(1000);
        invoiceLookup.setInvNum(1);
        invHeader = invoiceLookup.getInvoiceHeader();
        if (invHeader == null) {
            log.info("Invoice not found");
            assertNull("Invoice fetch failed", invHeader);
        } else {
            assertEquals("Invoice header doesn't match", invHeader.getInvCustomer().getInvoiceNum(), 1);
        }

    }

    @Test
    public void getInvoiceDetails() throws Exception {
        List<InvoiceDetail> invDetails = null;
        invoiceLookup.setCustNum(1000);
        invoiceLookup.setInvNum(2345);
        invDetails = invoiceLookup.getInvoiceDetails();

        if (invDetails == null) {
            log.info("Invoice details not found");
            assertNull("Invoice fetch failed", invDetails);
        } else {
            for (InvoiceDetail invoiceDetail : invDetails) {
                System.out.println("Item NUm:" + invoiceDetail.getInvItem().getItemNum());
                log.info("Item Num:" + invoiceDetail.getInvItem().getItemNum());
                System.out.println("Item Desc:" + invoiceDetail.getItemDesc());
                log.info("Item desc:" + invoiceDetail.getItemDesc());
            }

            assertNotNull("Invoice details doesn't exist", invDetails);

        }

    }

}