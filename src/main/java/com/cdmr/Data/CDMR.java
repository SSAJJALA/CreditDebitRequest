package com.cdmr.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Siva Sajjala on 9/26/16.
 */
public class CDMR {
    private int requisitionID;
    private Customer customer;
    private String status;
    private InvoiceHeader invHeader;
    private String salesRepID;
    private String salesRepName;
    private Double adjAmnt;
    private LocalDate cdmrDate;
    private String type;
    private List<CDMRAdjustments>  adjustments;



    public CDMR() {
    }

    public CDMR(int requisitionID, Customer customer, String status, InvoiceHeader invHeader, String salesRepID, String salesRepName, Double adjAmnt, LocalDate cdmrDate, String type, List<CDMRAdjustments> adjustments) {
        this.requisitionID = requisitionID;
        this.customer = customer;
        this.status = status;
        this.invHeader = invHeader;
        this.salesRepID = salesRepID;
        this.salesRepName = salesRepName;
        this.adjAmnt = adjAmnt;
        this.cdmrDate = cdmrDate;
        this.type = type;
        this.adjustments = adjustments;
    }

    public int getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public InvoiceHeader getInvHeader() {
        return invHeader;
    }

    public void setInvHeader(InvoiceHeader invHeader) {
        this.invHeader = invHeader;
    }

    public String getSalesRepID() {
        return salesRepID;
    }

    public void setSalesRepID(String salesRepID) {
        this.salesRepID = salesRepID;
    }

    public String getSalesRepName() {
        return salesRepName;
    }

    public void setSalesRepName(String salesRepName) {
        this.salesRepName = salesRepName;
    }

    public Double getAdjAmnt() {
        return adjAmnt;
    }

    public void setAdjAmnt(Double adjAmnt) {
        this.adjAmnt = adjAmnt;
    }

    public LocalDate getCdmrDate() {
        return cdmrDate;
    }

    public void setCdmrDate(LocalDate cdmrDate) {
        this.cdmrDate = cdmrDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CDMRAdjustments> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(List<CDMRAdjustments> adjustments) {
        this.adjustments = adjustments;
    }


    @Override
    public String toString() {
        return "CDMR{" +
                "requisitionID=" + requisitionID +
                ", customer=" + customer +
                ", status='" + status + '\'' +
                ", invHeader=" + invHeader +
                ", salesRepID='" + salesRepID + '\'' +
                ", salesRepName='" + salesRepName + '\'' +
                ", adjAmnt=" + adjAmnt +
                ", cdmrDate=" + cdmrDate +
                ", type='" + type + '\'' +
                ", adjustments=" + adjustments +
                '}';
    }
}
