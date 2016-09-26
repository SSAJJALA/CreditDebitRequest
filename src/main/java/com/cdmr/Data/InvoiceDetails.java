package com.cdmr.Data;

/**
 * Created by student on 9/26/16.
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

    public InvoiceDetails() {
    }

    public InvoiceDetails(int itemNum, String itemDesc, int qty, Double unitPrice, Double grossAmnt, Double allowanceAmnt, Double chargesAmnt, Double taxAmnt, Double netAmnt) {
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
