package com.cdmr.Data;

import java.time.LocalDate;

/**
 * This class is to hold the invoice header
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-26
 */
public class InvoiceHeader {
    private int invNum;
    private int custNum;
    private LocalDate invDate;
    private Double grossAmnt;
    private Double allowanceAmnt;
    private Double chargesAmnt;
    private Double taxAmnt;
    private Double netAmnt;

    /**
     * No arg constructor
     */
    public InvoiceHeader() {
    }

    /**
     * constructor with args
     * @param invNum
     * @param custNum
     * @param invDate
     * @param grossAmnt
     * @param allowanceAmnt
     * @param chargesAmnt
     * @param taxAmnt
     * @param netAmnt
     */
    public InvoiceHeader(int invNum, int custNum, LocalDate invDate, Double grossAmnt, Double allowanceAmnt, Double chargesAmnt, Double taxAmnt, Double netAmnt) {
        this();
        this.invNum = invNum;
        this.custNum = custNum;
        this.invDate = invDate;
        this.grossAmnt = grossAmnt;
        this.allowanceAmnt = allowanceAmnt;
        this.chargesAmnt = chargesAmnt;
        this.taxAmnt = taxAmnt;
        this.netAmnt = netAmnt;
    }

    /**
     * get invoice number
     * @return invNum
     */
    public int getInvNum() {
        return invNum;
    }

    /**
     * set invoice number
     * @param invNum
     */
    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    /**
     * get the customer number
     * @return custNum
     */
    public int getCustNum() {
        return custNum;
    }

    /**
     * set the customer number
     * @param custNum
     */
    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    /**
     * get the invoice date
     * @return invDate
     */
    public LocalDate getInvDate() {
        return invDate;
    }

    /**
     * set the invoice date
     * @param invDate
     */
    public void setInvDate(LocalDate invDate) {
        this.invDate = invDate;
    }

    /**
     * get the gross amount
     * @return grossAmnt
     */
    public Double getGrossAmnt() {
        return grossAmnt;
    }

    /**
     * set the gross amount
     * @param  grossAmnt
     */
    public void setGrossAmnt(Double grossAmnt) {
        this.grossAmnt = grossAmnt;
    }

    /**
     * get the allowance amount
     * @return allowanceAmnt
     */
    public Double getAllowanceAmnt() {
        return allowanceAmnt;
    }

    /**
     * set the allowance amount
     * @return allowanceAmnt
     */
    public void setAllowanceAmnt(Double allowanceAmnt) {
        this.allowanceAmnt = allowanceAmnt;
    }

    /**
     * get the charge amount
     * @return chargesAmnt
     */
    public Double getChargesAmnt() {
        return chargesAmnt;
    }

    /**
     * set the charge amount
     * @param chargesAmnt
     */
    public void setChargesAmnt(Double chargesAmnt) {
        this.chargesAmnt = chargesAmnt;
    }

    /**
     * get the tax amount
     * @return taxAmnt
     */
    public Double getTaxAmnt() {
        return taxAmnt;
    }

    /**
     * set the tax amount
     * @param  taxAmnt
     */
    public void setTaxAmnt(Double taxAmnt) {
        this.taxAmnt = taxAmnt;
    }

    /**
     * get the net amount
     * @return netAmnt
     */
    public Double getNetAmnt() {
        return netAmnt;
    }

    /**
     * set the net amount
     * @param  netAmnt
     */
    public void setNetAmnt(Double netAmnt) {
        this.netAmnt = netAmnt;
    }

    /**
     * toString method to display the invoice header info
     * @return string
     */
    @Override
    public String toString() {
        return "InvoiceHeader{" +
                "invNum=" + invNum +
                ", custNum=" + custNum +
                ", invDate=" + invDate +
                ", grossAmnt=" + grossAmnt +
                ", allowanceAmnt=" + allowanceAmnt +
                ", chargesAmnt=" + chargesAmnt +
                ", taxAmnt=" + taxAmnt +
                ", netAmnt=" + netAmnt +
                '}';
    }
}
