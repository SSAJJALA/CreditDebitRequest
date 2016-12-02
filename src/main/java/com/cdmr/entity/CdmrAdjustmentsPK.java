package com.cdmr.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Siva Sajjala on 9/26/16.
 */

@Embeddable
public class CdmrAdjustmentsPK implements Serializable {

    @Column(name="REQUISITION_ID")
    private int requisitionID;

    @Column(name="ITEM_NUM")
    private int itemNum;

    public CdmrAdjustmentsPK() {
    }

    public CdmrAdjustmentsPK(int requisitionID, int itemNum) {
        this();
        this.requisitionID = requisitionID;
        this.itemNum = itemNum;
    }

    public int getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    @Override
    public String toString() {
        return "CdmrAdjustmentsPK{" +
                "requisitionID=" + requisitionID +
                ", itemNum=" + itemNum +
                '}';
    }
}

