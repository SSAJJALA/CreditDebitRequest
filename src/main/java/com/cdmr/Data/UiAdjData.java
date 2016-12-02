package com.cdmr.Data;

/**
 * This class is to hold the UI adjustment data
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-23
 */
public class UiAdjData {


    private int itemNum;
    private int adjQty;
    private String reasonCode;
    private String creditDebit;
    private String Comments;

    /**
     * No arg constructor
     */
    public UiAdjData() {
    }

    /**
     * arg constructor
     * @param itemNum
     * @param adjQty
     * @param reasonCode
     * @param creditDebit
     * @param comments
     */
    public UiAdjData(int itemNum, int adjQty, String reasonCode, String creditDebit, String comments) {
        this.itemNum = itemNum;
        this.adjQty = adjQty;
        this.reasonCode = reasonCode;
        this.creditDebit = creditDebit;
        Comments = comments;
    }

    /**
     * get item number
     * @return itemNum
     */
    public int getItemNum() {
        return itemNum;
    }

    /**
     * set item number
     * @param  itemNum
     */
    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    /**
     * get the adjustment qty
     * @return adjQty
     */
    public int getAdjQty() {
        return adjQty;
    }

    /**
     * set the adjustment qty
     * @param  adjQty
     */
    public void setAdjQty(int adjQty) {
        this.adjQty = adjQty;
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
     * @param  reasonCode
     */
    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    /**
     * get the credit debit flag
     * @return   creditDebit
     */
    public String getCreditDebit() {
        return creditDebit;
    }

    /**
     * set the credit debit flag
     * @param    creditDebit
     */
    public void setCreditDebit(String creditDebit) {
        this.creditDebit = creditDebit;
    }

    /**
     * get comments
     * @return Comments
     */
    public String getComments() {
        return Comments;
    }

    /**
     * set comments
     * @param  Comments
     */
    public void setComments(String comments) {
        Comments = comments;
    }

    /**
     * toString method to display the ui adjustment info
     * @return string
     */
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
