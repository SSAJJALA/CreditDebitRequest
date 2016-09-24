package com.cdmr.entity;

/**
 * Created by student on 9/23/16.
 */
public class SearchCDMR {

    private int requisitionID = 0;
    private  int invoiceNum = 0;
    private Double invAmnt = 0.00;
    private  int custNo = 0;
    private String custName = null;
    private String reqType = null;
    private Double adjAmnt = 0.00;
    private String status = null;

    public SearchCDMR() {
    }

    public SearchCDMR(int requisitionID, int invoiceNum, Double invAmnt, int custNo, String custName, String reqType, Double adjAmnt, String status) {
        this.requisitionID = requisitionID;
        this.invoiceNum = invoiceNum;
        this.invAmnt = invAmnt;
        this.custNo = custNo;
        this.custName = custName;
        this.reqType = reqType;
        this.adjAmnt = adjAmnt;
        this.status = status;
    }

    public int getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Double getInvAmnt() {
        return invAmnt;
    }

    public void setInvAmnt(Double invAmnt) {
        this.invAmnt = invAmnt;
    }

    public int getCustNo() {
        return custNo;
    }

    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public Double getAdjAmnt() {
        return adjAmnt;
    }

    public void setAdjAmnt(Double adjAmnt) {
        this.adjAmnt = adjAmnt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
