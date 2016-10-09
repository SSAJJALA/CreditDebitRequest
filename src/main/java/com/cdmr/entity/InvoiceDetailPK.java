package com.cdmr.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 10/8/16.
 */

@Embeddable
public class InvoiceDetailPK implements Serializable{

    @Column(name="INV_NUM")
    private int invNum;

    @Column(name="ITEM_NUM")
    private int itemNum;

    public InvoiceDetailPK() {
    }

    public InvoiceDetailPK(int invNum, int itemNum) {
        this.invNum = invNum;
        this.itemNum = itemNum;
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    @Override
    public String toString() {
        return "InvoiceDetailPK{" +
                "invNum=" + invNum +
                ", itemNum=" + itemNum +
                '}';
    }
}
