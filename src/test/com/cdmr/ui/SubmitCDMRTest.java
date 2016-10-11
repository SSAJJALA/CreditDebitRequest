package com.cdmr.ui;

import com.cdmr.Data.*;
import com.cdmr.util.ConvertToLocalDate;
import org.apache.log4j.Logger;
import org.hamcrest.core.StringContains;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 10/9/16.
 */
public class SubmitCDMRTest {

    private SubmitCDMR submit = null;
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp() {
        submit = new SubmitCDMR();
    }

    @Test
    public void saveCDMR() throws Exception {

        // set cdmr customer
        CDMR cdmr = new CDMR();
        Customer customer = new Customer();
        customer.setZip("53212");
        customer.setState("WI");
        customer.setPhone("414-961-1000");
        customer.setCustNum(1000);
        customer.setAddress1("100");
        customer.setAddress2("Manpower Place");
        customer.setCustName("Experis");

        cdmr.setCustomer(customer);

        cdmr.setStatus("In Progress");
        cdmr.setType("C");
        cdmr.setAdjAmnt(100.00);
        cdmr.setCdmrDate(LocalDate.now());
        cdmr.setSalesRepName("Mike Helman");
        cdmr.setSalesRepID("FD31103");

        // set invoice header
        InvoiceHeader invHeader = new InvoiceHeader();
        invHeader.setInvDate(new ConvertToLocalDate().formatDate("2016-10-01"));
        invHeader.setInvNum(2345);
        invHeader.setNetAmnt(700.00);
        invHeader.setTaxAmnt(0.00);
        invHeader.setAllowanceAmnt(0.00);
        invHeader.setChargesAmnt(0.00);
        invHeader.setGrossAmnt(700.00);
        invHeader.setCustNum(1000);
        cdmr.setInvHeader(invHeader);

        // set adjustments
        List<CDMRAdjustments> adjs = new ArrayList<CDMRAdjustments>();
        CDMRAdjustments adj = new CDMRAdjustments();
        adj.setReasonCode("3-Damaged");
        adj.setTaxAdjAmnt(0.00);
        adj.setOriginalQty(4);
        adj.setOriginalPrice(100.00);
        adj.setAdjQty(1);
        adj.setAllowanceAdjAmnt(0.00);
        adj.setChargeAdjAmnt(0.00);
        adj.setTaxAdjAmnt(0.00);
        adj.setCreditDebitFlg("C");
        adj.setItemDesc("COAT STAND");
        adj.setItemNum(2350);
        adj.setLineAdjAmnt(100.00);
        adj.setNewInvLineTotal(300.00);
        adj.setOriginalInvLineTotal(400.00);

        List<CDMRComment> comments = new ArrayList<CDMRComment>();
        CDMRComment comment = new CDMRComment();
        comment.setSeqID(1);
        comment.setCreatedDate(LocalDateTime.now());
        comment.setComment("This is a defact item. Returned by the customer");
        comment.setUserID("FD31103");
        comment.setItemNum(2350);
        comments.add(comment);
        adj.setComments(comments);
        adjs.add(adj);
        cdmr.setAdjustments(adjs);

        //create CDMR

        submit.setCdmr(cdmr);
        String message = submit.saveCDMR();
        log.info (message);

        assertThat("Submit CDMR failed", message, containsString("successfully"));


    }

}