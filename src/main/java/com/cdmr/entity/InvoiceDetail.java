package com.cdmr.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siva Sajjala on 9/19/16.
 */
@Entity
@Table(name = "INVOICE_DETAIL")
public class InvoiceDetail implements Serializable {

    @Id
    @Column(name = "INV_NUM")
    private int invoiceNum;
/**
    @ManyToOne
    @JoinColumn(name="INV_NUM")
    private InvoiceHeader invoice;

    @ManyToOne
    @JoinColumn(name="CUST_NUM")
    private Customer cust;
 **/

    @Id
    @Column(name = "CUST_NUM")
    private int custNum;

    @Column(name="ITEM_NUM")
    private int itemNum;

    @Column(name="ITEM_DESC")
    private String itemDesc;

    @Column(name="QTY")
    private int qty;

    @Column(name="UNIT_PRICE")
    private Double unitPrice;

    @Column(name="GROSS_AMNT")
    private Double grossAmnt;

    @Column(name="ALLOWANCE")
    private Double allowance;

    @Column(name="CHARGES")
    private Double charges;

    @Column(name="TAX")
    private Double tax;

    @Column(name="NET_AMNT")
    private Double netAmnt;

    public InvoiceDetail() {
    }

    public InvoiceDetail(int invoiceNum, int custNum, int itemNum, String itemDesc, int qty, Double unitPrice, Double grossAmnt, Double allowance, Double charges, Double tax, Double netAmnt) {
        this.invoiceNum = invoiceNum;
        this.custNum = custNum;
        this.itemNum = itemNum;
        this.itemDesc = itemDesc;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.grossAmnt = grossAmnt;
        this.allowance = allowance;
        this.charges = charges;
        this.tax = tax;
        this.netAmnt = netAmnt;
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

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getGrossAmnt() {
        return grossAmnt;
    }

    public void setGrossAmnt(Double grossAmnt) {
        this.grossAmnt = grossAmnt;
    }

    public Double getAllowance() {
        return allowance;
    }

    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getNetAmnt() {
        return netAmnt;
    }

    public void setNetAmnt(Double netAmnt) {
        this.netAmnt = netAmnt;
    }
}
