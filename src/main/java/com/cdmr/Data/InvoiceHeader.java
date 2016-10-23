package com.cdmr.Data;

import java.time.LocalDate;

/**
 * Created by student on 9/26/16.
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


    public InvoiceHeader() {
    }

    public InvoiceHeader(int invNum, int custNum, LocalDate invDate, Double grossAmnt, Double allowanceAmnt, Double chargesAmnt, Double taxAmnt, Double netAmnt) {
        this.invNum = invNum;
        this.custNum = custNum;
        this.invDate = invDate;
        this.grossAmnt = grossAmnt;
        this.allowanceAmnt = allowanceAmnt;
        this.chargesAmnt = chargesAmnt;
        this.taxAmnt = taxAmnt;
        this.netAmnt = netAmnt;
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

    public LocalDate getInvDate() {
        return invDate;
    }

    public void setInvDate(LocalDate invDate) {
        this.invDate = invDate;
    }

    public Double getGrossAmnt() {
        return grossAmnt;
    }

    public void setGrossAmnt(Double grossAmnt) {
        this.grossAmnt = grossAmnt;
    }

    public Double getAllowanceAmnt() {
        return allowanceAmnt;
    }

    public void setAllowanceAmnt(Double allowanceAmnt) {
        this.allowanceAmnt = allowanceAmnt;
    }

    public Double getChargesAmnt() {
        return chargesAmnt;
    }

    public void setChargesAmnt(Double chargesAmnt) {
        this.chargesAmnt = chargesAmnt;
    }

    public Double getTaxAmnt() {
        return taxAmnt;
    }

    public void setTaxAmnt(Double taxAmnt) {
        this.taxAmnt = taxAmnt;
    }

    public Double getNetAmnt() {
        return netAmnt;
    }

    public void setNetAmnt(Double netAmnt) {
        this.netAmnt = netAmnt;
    }

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
