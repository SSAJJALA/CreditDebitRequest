package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.CDMRAdjustments;
import com.cdmr.Data.CDMRComment;
import com.cdmr.Data.UiAdjData;
import com.cdmr.entity.InvoiceDetail;
import com.cdmr.entity.InvoiceHeader;
import com.cdmr.webservices.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * CalculateCDMR calculates the cdmr amount based on the adjustment qty and unit price of the item.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-23
 */
public class CalculateCDMR {

    private Customer customer;
    private InvoiceHeader invHeader;
    private List<InvoiceDetail> invDtls;
    private List<UiAdjData> adjs;
    private CDMR cdmr = null;
    private String userID;

    /**
     * No arg constructor
     */
    public CalculateCDMR() {
    }

    /**
     * Constructor with args
     * @param customer
     * @param invHeader
     * @param invDtls
     * @param adjs
     * @param userID
     */
    public CalculateCDMR(Customer customer, InvoiceHeader invHeader, List<InvoiceDetail> invDtls, List<UiAdjData> adjs, String userID) {
        this.customer = customer;
        this.invHeader = invHeader;
        this.invDtls = invDtls;
        this.adjs = adjs;

        this.userID = userID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public InvoiceHeader getInvHeader() {
        return invHeader;
    }

    public void setInvHeader(InvoiceHeader invHeader) {
        this.invHeader = invHeader;
    }

    public List<InvoiceDetail> getInvDtls() {
        return invDtls;
    }

    public void setInvDtls(List<InvoiceDetail> invDtls) {
        this.invDtls = invDtls;
    }

    public List<UiAdjData> getAdjs() {
        return adjs;
    }

    public void setAdjs(List<UiAdjData> adjs) {
        this.adjs = adjs;
    }

    public CDMR getCdmr() {
        return cdmr;
    }

    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * main method to prepare the cdmr details
     * @return CDMR document
     */
    public CDMR prepareCDMR() {
        cdmr = new CDMR();


        cdmr.setCdmrDate(LocalDate.now());

        //prepare customer
        this.prepareCustomer();

        //prepare invoice header
        this.prepareInvHeader();

        //prepare the adjustments
        this.prepareAdjustments();

        //prepare header
        this.prepareHeader();

        cdmr.setStatus("New");

        return cdmr;
    }

    /**
     * method to prepare customer details
     */
    public void prepareCustomer() {
        com.cdmr.Data.Customer cust = new com.cdmr.Data.Customer();
        cust.setAddress1(customer.getAdd1());
        cust.setAddress2(customer.getAdd2());
        cust.setCity(customer.getCity());
        cust.setCustNum(customer.getCustNum());
        cust.setPhone(customer.getPhone());
        cust.setState(customer.getState());
        cust.setZip(customer.getZip());
        cust.setCustName(customer.getCustName());

        cdmr.setCustomer(cust);
    }

    /**
     * method to prepare invoice header
     */
    public void prepareInvHeader() {

        com.cdmr.Data.InvoiceHeader header = new com.cdmr.Data.InvoiceHeader();
        header.setCustNum(invHeader.getInvCustomer().getCustNum());
        header.setInvNum(invHeader.getInvCustomer().getInvoiceNum());
        header.setGrossAmnt(invHeader.getGrossAmnt());
        header.setChargesAmnt(invHeader.getCharges());
        header.setAllowanceAmnt(invHeader.getAllowance());
        header.setTaxAmnt(invHeader.getTax());
        header.setNetAmnt(invHeader.getNetAmnt());
        header.setInvDate(invHeader.getInvDate());


        cdmr.setInvHeader(header);

    }

    /**
     * method to prepare adjustments
     */
    public void prepareAdjustments() {
        List<CDMRAdjustments> requiredAdjs = new ArrayList<CDMRAdjustments>();

        for (UiAdjData adj : adjs) {
            CDMRAdjustments cdmrAdj = new CDMRAdjustments();
            cdmrAdj.setAdjQty(adj.getAdjQty());
            cdmrAdj.setReasonCode(adj.getReasonCode());
            List<CDMRComment> comments = new ArrayList<CDMRComment>();
            CDMRComment comment = new CDMRComment();
            comment.setItemNum(adj.getItemNum());
            comment.setUserID(userID);
            comment.setComment(adj.getComments());
            comment.setCreatedDate(LocalDateTime.now());
            comment.setSeqID(1);
            comments.add(comment);

            cdmrAdj.setComments(comments);

            for (InvoiceDetail invdtl : invDtls) {
                if (adj.getItemNum() == invdtl.getInvItem().getItemNum()) {
                    cdmrAdj.setOriginalInvLineTotal(invdtl.getNetAmnt());
                    cdmrAdj.setOriginalPrice(invdtl.getUnitPrice());
                    cdmrAdj.setItemDesc(invdtl.getItemDesc());
                    cdmrAdj.setOriginalQty(invdtl.getQty());
                }
            }


            cdmrAdj.setAllowanceAdjAmnt(0.00);
            cdmrAdj.setChargeAdjAmnt(0.00);
            cdmrAdj.setTaxAdjAmnt(0.00);
            cdmrAdj.setCreditDebitFlg(adj.getCreditDebit());
            cdmrAdj.setItemNum(adj.getItemNum());
            Double adjGross = 0.00;
            if (cdmrAdj.getCreditDebitFlg().equals("Credit")) {
                adjGross = adj.getAdjQty() * cdmrAdj.getOriginalPrice() * -1;
            } else {
                adjGross = adj.getAdjQty() * cdmrAdj.getOriginalPrice();
            }

            Double adjNet = (adjGross - cdmrAdj.getAllowanceAdjAmnt() - cdmrAdj.getChargeAdjAmnt() - cdmrAdj.getTaxAdjAmnt());
            cdmrAdj.setLineAdjAmnt(adjNet);
            cdmrAdj.setNewInvLineTotal((cdmrAdj.getOriginalInvLineTotal() - cdmrAdj.getLineAdjAmnt()));

            requiredAdjs.add(cdmrAdj);
        }

        cdmr.setAdjustments(requiredAdjs);

    }

    /**
     * method to prepare header
     */
    public void prepareHeader() {

        List<CDMRAdjustments> adjs = cdmr.getAdjustments();

        Double allowance = 0.00;
        Double charges = 0.00;
        Double tax = 0.00;
        Double net = 0.00;
        Double gross = 0.00;
        for (CDMRAdjustments adj : adjs) {

            tax = tax + adj.getTaxAdjAmnt();
            charges = charges + adj.getChargeAdjAmnt();
            allowance = allowance + adj.getAllowanceAdjAmnt();
            gross = gross + adj.getLineAdjAmnt();
            net = net + (gross - allowance - charges - tax);

        }

        cdmr.setAdjAllowance(allowance);
        cdmr.setAdjAmnt(net);
        cdmr.setAdjCharges(charges);
        cdmr.setAdjGross(gross);
        cdmr.setAdjTax(tax);
        if (cdmr.getAdjAmnt() < 0.00 ) {
            cdmr.setType("Credit");
        } else {
            cdmr.setType("Debit");
        }
    }

    @Override
    public String toString() {
        return "CalculateCDMR{" +
                "customer=" + customer +
                ", invHeader=" + invHeader +
                ", invDtls=" + invDtls +
                ", adjs=" + adjs +
                ", cdmr=" + cdmr +
                ", userID='" + userID + '\'' +
                '}';
    }
}
