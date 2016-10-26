package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.UiAdjData;
import com.cdmr.entity.Filter;
import com.cdmr.entity.InvoiceDetail;
import com.cdmr.entity.InvoiceHeader;
import com.cdmr.entity.InvoiceHeaderPK;
import com.cdmr.persistence.InvoiceDetailDao;
import com.cdmr.persistence.InvoiceHeaderDao;
import com.cdmr.util.ConvertToLocalDate;
import com.cdmr.webservices.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 10/26/16.
 */
public class CalculateCDMRTest {

    Customer customer = null;
    InvoiceHeader header = null;
    InvoiceHeaderPK headerPK = null;
    List<InvoiceDetail> details = null;
    String userID = "VYU6026";
    List<UiAdjData> adjs = null;
    CalculateCDMR calculate = null;

    @Before
    public void setUp() {
        customer = new Customer();
        header = new InvoiceHeader();
        details = new ArrayList<InvoiceDetail>();
        calculate = new CalculateCDMR();
        headerPK = new InvoiceHeaderPK();
    }


    @Test
    public void prepareCDMR() throws Exception {

        customer.setZip("53212");
        customer.setState("WI");
        customer.setPhone("414-961-1000");
        customer.setCity("Milwaukee");
        customer.setAdd1("100");
        customer.setAdd2("Manpower Place");
        customer.setCustName("Experis");
        customer.setCustNum(1000);

        headerPK.setCustNum(1000);
        headerPK.setInvoiceNum(2345);
        InvoiceHeaderDao invoiceHeaderDao = new InvoiceHeaderDao();
        header = invoiceHeaderDao.getInvoiceHeader(headerPK);

        InvoiceDetailDao invoiceDetailDao = new InvoiceDetailDao();
        List<Filter> filters = new ArrayList<Filter>();
        Filter filter1 = new Filter();
        filter1.setSearchOption("custNum");
        filter1.setOperand("=");
        filter1.setSearchValue("1000");
        filters.add(filter1);

        Filter filter2 = new Filter();
        filter2.setSearchOption("invNum");
        filter2.setOperand("=");
        filter2.setSearchValue("2345");
        filters.add(filter2);

        details = invoiceDetailDao.getInvoicesWithFilter(filters);

        UiAdjData adj = new UiAdjData();
        adj.setItemNum(2350);
        adj.setCreditDebit("Credit");
        adj.setComments("defective");
        adj.setReasonCode("1-Defective");
        adj.setAdjQty(5);

        adjs.add(adj);

        calculate.setAdjs(adjs);
        calculate.setCustomer(customer);
        calculate.setInvDtls(details);
        calculate.setInvHeader(header);
        calculate.setUserID(userID);

        CDMR cdmr = calculate.prepareCDMR();

        assertNotNull("calculate cdmr failed", cdmr);



    }

}