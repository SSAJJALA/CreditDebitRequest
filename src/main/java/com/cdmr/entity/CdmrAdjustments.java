package com.cdmr.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Siva Sajjala on 9/26/16.
 */

@Entity
@Table(name = "CDMR_ADJUSTMENTS")
public class CdmrAdjustments {


    @EmbeddedId
    private CdmrAdjustmentsPK requisitionItem;

    @Column(name = "CUST_NUM")
    private int custNum;

    @Column(name = "REASON_CODE_DESC")
    private String reasonCode;

    @Column(name = "ITEM_DESC")
    private String itemDesc;

    @Column(name = "QTY_ADJ")
    private int adjQty;

    @Column(name = "ALLOW_ADJ")
    private Double allowanceAdj;

    @Column(name = "CHRG_ADJ")
    private Double chargesAdj;

    @Column(name = "TAX_ADJ")
    private Double taxAdj;

    @Column(name = "CD_FLAG")
    private String cdFlag;

    @Column(name = "EXT_PRICE")
    private Double extPrice;

    @Column(name = "NEW_INV_LINE_AMNT")
    private Double newInvLineAmnt;

    public CdmrAdjustments() {
    }

    public CdmrAdjustments(CdmrAdjustmentsPK requisitionItem, int custNum, String reasonCode, String itemDesc, int adjQty, Double allowanceAdj, Double chargesAdj, Double taxAdj, String cdFlag, Double extPrice, Double newInvLineAmnt) {
        this.requisitionItem = requisitionItem;
        this.custNum = custNum;
        this.reasonCode = reasonCode;
        this.itemDesc = itemDesc;
        this.adjQty = adjQty;
        this.allowanceAdj = allowanceAdj;
        this.chargesAdj = chargesAdj;
        this.taxAdj = taxAdj;
        this.cdFlag = cdFlag;
        this.extPrice = extPrice;
        this.newInvLineAmnt = newInvLineAmnt;
    }

    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }


    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getAdjQty() {
        return adjQty;
    }

    public void setAdjQty(int adjQty) {
        this.adjQty = adjQty;
    }

    public Double getAllowanceAdj() {
        return allowanceAdj;
    }

    public void setAllowanceAdj(Double allowanceAdj) {
        this.allowanceAdj = allowanceAdj;
    }

    public Double getChargesAdj() {
        return chargesAdj;
    }

    public void setChargesAdj(Double chargesAdj) {
        this.chargesAdj = chargesAdj;
    }

    public Double getTaxAdj() {
        return taxAdj;
    }

    public void setTaxAdj(Double taxAdj) {
        this.taxAdj = taxAdj;
    }

    public String getCdFlag() {
        return cdFlag;
    }

    public void setCdFlag(String cdFlag) {
        this.cdFlag = cdFlag;
    }

    public Double getExtPrice() {
        return extPrice;
    }

    public void setExtPrice(Double extPrice) {
        this.extPrice = extPrice;
    }

    public Double getNewInvLineAmnt() {
        return newInvLineAmnt;
    }

    public void setNewInvLineAmnt(Double newInvLineAmnt) {
        this.newInvLineAmnt = newInvLineAmnt;
    }

    public CdmrAdjustmentsPK getRequisitionItem() {
        return requisitionItem;
    }

    public void setRequisitionItem(CdmrAdjustmentsPK requisitionItem) {
        this.requisitionItem = requisitionItem;
    }

    @Override
    public String toString() {
        return "CdmrAdjustments{" +
                "requisitionItem=" + requisitionItem +
                ", custNum=" + custNum +
                ", reasonCode='" + reasonCode + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", adjQty=" + adjQty +
                ", allowanceAdj=" + allowanceAdj +
                ", chargesAdj=" + chargesAdj +
                ", taxAdj=" + taxAdj +
                ", cdFlag='" + cdFlag + '\'' +
                ", extPrice=" + extPrice +
                ", newInvLineAmnt=" + newInvLineAmnt +
                '}';
    }
}
