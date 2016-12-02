package com.cdmr.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Siva Sajjala on 10/8/16.
 */
@Embeddable
public class InvoiceHeaderPK implements Serializable {

    @Column(name="INV_NUM")
    private int invoiceNum;

    @Column(name="CUST_NUM")
    private int custNum;

    public InvoiceHeaderPK() {
    }

    public InvoiceHeaderPK(int invoiceNum, int custNum) {
        this();
        this.invoiceNum = invoiceNum;
        this.custNum = custNum;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    @Override
    public String toString() {
        return "InvoiceHeaderPK{" +
                "invoiceNum=" + invoiceNum +
                ", custNum=" + custNum +
                '}';
    }
}
