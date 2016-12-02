package com.cdmr.Data;

/**
 * This class is to hold the invoice details
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-26
 */
public class InvoiceDetails {
    private int itemNum;
    private String itemDesc;
    private int qty;
    private Double unitPrice;
    private Double grossAmnt;
    private Double allowanceAmnt;
    private Double chargesAmnt;
    private Double taxAmnt;
    private Double netAmnt;

    /**
     * No arg constructor
     */
    public InvoiceDetails() {
    }

    /**
     * arg constructor
     * @param itemNum
     * @param itemDesc
     * @param qty
     * @param unitPrice
     * @param grossAmnt
     * @param allowanceAmnt
     * @param chargesAmnt
     * @param taxAmnt
     * @param netAmnt
     */
    public InvoiceDetails(int itemNum, String itemDesc, int qty, Double unitPrice, Double grossAmnt, Double allowanceAmnt, Double chargesAmnt, Double taxAmnt, Double netAmnt) {
        this();
        this.itemNum = itemNum;
        this.itemDesc = itemDesc;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.grossAmnt = grossAmnt;
        this.allowanceAmnt = allowanceAmnt;
        this.chargesAmnt = chargesAmnt;
        this.taxAmnt = taxAmnt;
        this.netAmnt = netAmnt;
    }

    /**
     * get the item number
     * @return itemNum
     */
    public int getItemNum() {
        return itemNum;
    }

    /**
     * set the item number
     * @param  itemNum
     */
    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    /**
     * get the item description
     * @return itemDesc
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * set the item description
     * @param  itemDesc
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    /**
     * get item qty
     * @return qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * set item qty
     * @param  qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * get the unit price
     * @return unitPrice
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * set the unit price
     * @param  unitPrice
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
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
     * @param grossAmnt
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
     * @param  allowanceAmnt
     */
    public void setAllowanceAmnt(Double allowanceAmnt) {
        this.allowanceAmnt = allowanceAmnt;
    }

    /**
     * get the charges amount
     * @return chargesAmnt
     */
    public Double getChargesAmnt() {
        return chargesAmnt;
    }

    /**
     * set the charges amount
     * @param  chargesAmnt
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
     * toString method to display the invoice details info
     * @return string
     */
    @Override
    public String toString() {
        return "InvoiceDetails{" +
                "itemNum=" + itemNum +
                ", itemDesc='" + itemDesc + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", grossAmnt=" + grossAmnt +
                ", allowanceAmnt=" + allowanceAmnt +
                ", chargesAmnt=" + chargesAmnt +
                ", taxAmnt=" + taxAmnt +
                ", netAmnt=" + netAmnt +
                '}';
    }
}
