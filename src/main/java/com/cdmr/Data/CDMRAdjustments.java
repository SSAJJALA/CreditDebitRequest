package com.cdmr.Data;

import java.util.List;

/**
 * Created by student on 9/26/16.
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


    public CDMRAdjustments() {
    }

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

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getOriginalQty() {
        return originalQty;
    }

    public void setOriginalQty(int originalQty) {
        this.originalQty = originalQty;
    }

    public int getAdjQty() {
        return adjQty;
    }

    public void setAdjQty(int adjQty) {
        this.adjQty = adjQty;
    }

    public Double getOriginalInvLineTotal() {
        return originalInvLineTotal;
    }

    public void setOriginalInvLineTotal(Double originalInvLineTotal) {
        this.originalInvLineTotal = originalInvLineTotal;
    }

    public String getCreditDebitFlg() {
        return creditDebitFlg;
    }

    public void setCreditDebitFlg(String creditDebitFlg) {
        this.creditDebitFlg = creditDebitFlg;
    }

    public Double getLineAdjAmnt() {
        return lineAdjAmnt;
    }

    public void setLineAdjAmnt(Double lineAdjAmnt) {
        this.lineAdjAmnt = lineAdjAmnt;
    }

    public Double getNewInvLineTotal() {
        return newInvLineTotal;
    }

    public void setNewInvLineTotal(Double newInvLineTotal) {
        this.newInvLineTotal = newInvLineTotal;
    }

    public Double getAllowanceAdjAmnt() {
        return allowanceAdjAmnt;
    }

    public void setAllowanceAdjAmnt(Double allowanceAdjAmnt) {
        this.allowanceAdjAmnt = allowanceAdjAmnt;
    }

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
