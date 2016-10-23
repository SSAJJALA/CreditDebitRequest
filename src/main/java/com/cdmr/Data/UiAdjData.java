package com.cdmr.Data;

/**
 * Created by student on 10/23/16.
 */
public class UiAdjData {

    private int itemNum;
    private int adjQty;
    private String reasonCode;
    private String creditDebit;
    private String Comments;

    public UiAdjData() {
    }

    public UiAdjData(int itemNum, int adjQty, String reasonCode, String creditDebit, String comments) {
        this.itemNum = itemNum;
        this.adjQty = adjQty;
        this.reasonCode = reasonCode;
        this.creditDebit = creditDebit;
        Comments = comments;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public int getAdjQty() {
        return adjQty;
    }

    public void setAdjQty(int adjQty) {
        this.adjQty = adjQty;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getCreditDebit() {
        return creditDebit;
    }

    public void setCreditDebit(String creditDebit) {
        this.creditDebit = creditDebit;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    @Override
    public String toString() {
        return "UiAdjData{" +
                "itemNum=" + itemNum +
                ", adjQty=" + adjQty +
                ", reasonCode='" + reasonCode + '\'' +
                ", creditDebit='" + creditDebit + '\'' +
                ", Comments='" + Comments + '\'' +
                '}';
    }
}
