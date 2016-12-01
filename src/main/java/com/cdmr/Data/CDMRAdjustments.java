package com.cdmr.Data;

import java.util.List;

/**
 * This class is to hold the CDMR Adjustment details data.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-26
 */
public class CDMRAdjustments {
    private int itemNum;
    private String itemDesc;
    private String reasonCode;
    private Double originalPrice;
    private int originalQty;
    private int adjQty;
    private Double originalInvLineTotal;
    private String creditDebitFlg;
    private Double allowanceAdjAmnt;
    private Double chargeAdjAmnt;
    private Double taxAdjAmnt;
    private Double lineAdjAmnt;
    private Double newInvLineTotal;
    private List<CDMRComment> comments;

    /**
     * No arg constructor
     */
    public CDMRAdjustments() {
    }

    /**
     * Constructor with args
     * @param itemNum item number
     * @param itemDesc item desc
     * @param reasonCode reason code
     * @param originalPrice original price
     * @param originalQty qty
     * @param adjQty adjusted qty
     * @param originalInvLineTotal original invoice amount
     * @param creditDebitFlg credit/debit flag
     * @param allowanceAdjAmnt allowance adjustment amnt
     * @param chargeAdjAmnt charge adjustment amnt
     * @param taxAdjAmnt adjusted tax amnt
     * @param lineAdjAmnt line adjustment amnt
     * @param newInvLineTotal new invoice total
     * @param comments comments
     */
    public CDMRAdjustments(int itemNum, String itemDesc, String reasonCode, Double originalPrice, int originalQty, int adjQty, Double originalInvLineTotal, String creditDebitFlg, Double allowanceAdjAmnt, Double chargeAdjAmnt, Double taxAdjAmnt, Double lineAdjAmnt, Double newInvLineTotal, List<CDMRComment> comments) {
        this.itemNum = itemNum;
        this.itemDesc = itemDesc;
        this.reasonCode = reasonCode;
        this.originalPrice = originalPrice;
        this.originalQty = originalQty;
        this.adjQty = adjQty;
        this.originalInvLineTotal = originalInvLineTotal;
        this.creditDebitFlg = creditDebitFlg;
        this.allowanceAdjAmnt = allowanceAdjAmnt;
        this.chargeAdjAmnt = chargeAdjAmnt;
        this.taxAdjAmnt = taxAdjAmnt;
        this.lineAdjAmnt = lineAdjAmnt;
        this.newInvLineTotal = newInvLineTotal;
        this.comments = comments;
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
     * @param itemNum item
     */
    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    /**
     * get the item description
     * @return itemDesc item description
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * set the item description
     * @param itemDesc itemDesc item description
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    /**
     * get the reason code
     * @return reasonCode
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * set the reason code
     * @param reasonCode reason code
     */
    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    /**
     * get the original price
     * @return originalPrice original price
     */
    public Double getOriginalPrice() {
        return originalPrice;
    }

    /**
     * set the original price
     * @param originalPrice original price
     */
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * get original qty
     * @return originalQty original qty
     */
    public int getOriginalQty() {
        return originalQty;
    }

    /**
     * set original qty
     * @param  originalQty original qty
     */
    public void setOriginalQty(int originalQty) {
        this.originalQty = originalQty;
    }

    /**
     * get the adjusted qty
     * @return adjQty adj qty
     */
    public int getAdjQty() {
        return adjQty;
    }

    /**
     * set the adjusted qty
     * @param  adjQty adj qty
     */
    public void setAdjQty(int adjQty) {
        this.adjQty = adjQty;
    }

    /**
     * get the original line total of the invoice
     * @return originalInvLineTotal original line total of the invoice
     */
    public Double getOriginalInvLineTotal() {
        return originalInvLineTotal;
    }

    /**
     * set the original line total of the invoice
     * @param originalInvLineTotal original line total of the invoice
     */
    public void setOriginalInvLineTotal(Double originalInvLineTotal) {
        this.originalInvLineTotal = originalInvLineTotal;
    }

    /**
     * get the credit/debit flag
     * @return creditDebitFlg credit/debit flag
     */
    public String getCreditDebitFlg() {
        return creditDebitFlg;
    }

    /**
     * set the credit/debit flag
     * @param creditDebitFlg credit/debit flag
     */
    public void setCreditDebitFlg(String creditDebitFlg) {
        this.creditDebitFlg = creditDebitFlg;
    }

    /**
     * get the line adjusted amount
     * @return lineAdjAmnt Line adjusted amount
     */
    public Double getLineAdjAmnt() {
        return lineAdjAmnt;
    }

    /**
     * set the line adjusted amount
     * @param lineAdjAmnt line adjusted amount
     */
    public void setLineAdjAmnt(Double lineAdjAmnt) {
        this.lineAdjAmnt = lineAdjAmnt;
    }

    /**
     * get the new invoice line total
     * @return newInvLineTotal new invoice line total
     */
    public Double getNewInvLineTotal() {
        return newInvLineTotal;
    }

    /**
     * set the new invoice line total
     * @param newInvLineTotal new invoice line total
     */
    public void setNewInvLineTotal(Double newInvLineTotal) {
        this.newInvLineTotal = newInvLineTotal;
    }

    /**
     * get the allowalce amount
      * @return allowanceAdjAmnt allowalce amount
     */
    public Double getAllowanceAdjAmnt() {
        return allowanceAdjAmnt;
    }

    /**
     * set the allowalce amount
     * @param allowanceAdjAmnt allowalce amount
     */
    public void setAllowanceAdjAmnt(Double allowanceAdjAmnt) {
        this.allowanceAdjAmnt = allowanceAdjAmnt;
    }

    /**
     * get the charge amount
     * @return chargeAdjAmnt charge amount
     */
    public Double getChargeAdjAmnt() {
        return chargeAdjAmnt;
    }

    public void setChargeAdjAmnt(Double chargeAdjAmnt) {
        this.chargeAdjAmnt = chargeAdjAmnt;
    }

    public Double getTaxAdjAmnt() {
        return taxAdjAmnt;
    }

    public void setTaxAdjAmnt(Double taxAdjAmnt) {
        this.taxAdjAmnt = taxAdjAmnt;
    }

    public List<CDMRComment> getComments() {
        return comments;
    }

    public void setComments(List<CDMRComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "CDMRAdjustments{" +
                "itemNum=" + itemNum +
                ", itemDesc='" + itemDesc + '\'' +
                ", reasonCode='" + reasonCode + '\'' +
                ", originalPrice=" + originalPrice +
                ", originalQty=" + originalQty +
                ", adjQty=" + adjQty +
                ", originalInvLineTotal=" + originalInvLineTotal +
                ", creditDebitFlg='" + creditDebitFlg + '\'' +
                ", allowanceAdjAmnt=" + allowanceAdjAmnt +
                ", chargeAdjAmnt=" + chargeAdjAmnt +
                ", taxAdjAmnt=" + taxAdjAmnt +
                ", lineAdjAmnt=" + lineAdjAmnt +
                ", newInvLineTotal=" + newInvLineTotal +
                ", comments=" + comments +
                '}';
    }
}
