package com.cdmr.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * This class is to hold the CDMR Requisition data. It includes CDMR header and adjustment details
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-26
 */
public class CDMR {
    private int requisitionID;
    private Customer customer;
    private String status;
    private InvoiceHeader invHeader;
    private String salesRepID;
    private String salesRepName;
    private Double adjAmnt;
    private Double adjGross;
    private Double adjAllowance;
    private Double adjCharges;
    private Double adjTax;
    private LocalDate cdmrDate;
    private String type;
    private List<CDMRAdjustments>  adjustments;


    /**
     * No arg constructor
     */
    public CDMR() {
    }

    /**
     * constructor with args
     * @param requisitionID
     * @param customer
     * @param status
     * @param invHeader
     * @param salesRepID
     * @param salesRepName
     * @param adjAmnt
     * @param adjGross
     * @param adjAllowance
     * @param adjCharges
     * @param adjTax
     * @param cdmrDate
     * @param type
     * @param adjustments
     */
    public CDMR(int requisitionID, Customer customer, String status, InvoiceHeader invHeader, String salesRepID, String salesRepName, Double adjAmnt, Double adjGross, Double adjAllowance, Double adjCharges, Double adjTax, LocalDate cdmrDate, String type, List<CDMRAdjustments> adjustments) {
        this.requisitionID = requisitionID;
        this.customer = customer;
        this.status = status;
        this.invHeader = invHeader;
        this.salesRepID = salesRepID;
        this.salesRepName = salesRepName;
        this.adjAmnt = adjAmnt;
        this.adjGross = adjGross;
        this.adjAllowance = adjAllowance;
        this.adjCharges = adjCharges;
        this.adjTax = adjTax;
        this.cdmrDate = cdmrDate;
        this.type = type;
        this.adjustments = adjustments;
    }

    /**
     * get the requisitionID
     * @return requisitionID
     */
    public int getRequisitionID() {
        return requisitionID;
    }

    /**
     * set the requisitionID
     * @param requisitionID requisition id
     */
    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    /**
     * get the customer details
     * @return customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * set the customer details
     * @param customer customer details
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * get the status
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * set the status
     * @param  status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the invoice header
     * @return invHeader
     */
    public InvoiceHeader getInvHeader() {
        return invHeader;
    }

    /**
     * set the invoice header
     * @param  invHeader invoice header info
     */
    public void setInvHeader(InvoiceHeader invHeader) {
        this.invHeader = invHeader;
    }

    /**
     * get the sales rep (TM) name
     * @return salesRepID
     */
    public String getSalesRepID() {
        return salesRepID;
    }

    /**
     * set the sales rep (TM) name
     * @param  salesRepID sales rep (TM) name
     */
    public void setSalesRepID(String salesRepID) {
        this.salesRepID = salesRepID;
    }

    /**
     * get the sales rep (TM) name
     * @return salesRepName
     */
    public String getSalesRepName() {
        return salesRepName;
    }

    /**
     * set the sales rep (TM) name
     * @param salesRepName sales rep (TM) name
     */
    public void setSalesRepName(String salesRepName) {
        this.salesRepName = salesRepName;
    }

    /**
     * get the adj amount
     * @return adjAmnt
     */
    public Double getAdjAmnt() {
        return adjAmnt;
    }

    /**
     * set the adj amount
     * @param adjAmnt adj amount
     */
    public void setAdjAmnt(Double adjAmnt) {
        this.adjAmnt = adjAmnt;
    }

    /**
     * get the cdmr date
     * @return cdmrDate
     */
    public LocalDate getCdmrDate() {
        return cdmrDate;
    }

    /**
     * set the cdmr date
     * @param cdmrDate
     */
    public void setCdmrDate(LocalDate cdmrDate) {
        this.cdmrDate = cdmrDate;
    }

    /**
     * get the type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * set the type of requisition
     * @param type of the requisition
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * get the list of adjustments
     * @return adjustments
     */
    public List<CDMRAdjustments> getAdjustments() {
        return adjustments;
    }

    /**
     * get the adjustment details
      * @param adjustments
     */
    public void setAdjustments(List<CDMRAdjustments> adjustments) {
        this.adjustments = adjustments;
    }

    /**
     * get the Adjusted gross
     * @return adjGross
     */
    public Double getAdjGross() {
        return adjGross;
    }

    /**
     * set the Adjusted gross
     * @param adjGross
     */
    public void setAdjGross(Double adjGross) {
        this.adjGross = adjGross;
    }

    /**
     * get the Adj allowance
     * @return adjAllowance
     */
    public Double getAdjAllowance() {
        return adjAllowance;
    }

    /**
     * set the Adj allowance
     * @param adjAllowance
     */
    public void setAdjAllowance(Double adjAllowance) {
        this.adjAllowance = adjAllowance;
    }

    /**
     * get the Adjustement charges
     * @return adjCharges
     */
    public Double getAdjCharges() {
        return adjCharges;
    }

    /**
     * set the Adjustement charges
     * @param adjCharges
     */
    public void setAdjCharges(Double adjCharges) {
        this.adjCharges = adjCharges;
    }

    /**
     * get the adjTax
     * @return adjTax
     */
    public Double getAdjTax() {
        return adjTax;
    }

    /**
     * set the adjTax
     * @param adjTax
     */
    public void setAdjTax(Double adjTax) {
        this.adjTax = adjTax;
    }

    /**
     * toString methods to display the cdmr information.
     * @return String
     */
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
                ", adjGross=" + adjGross +
                ", adjAllowance=" + adjAllowance +
                ", adjCharges=" + adjCharges +
                ", adjTax=" + adjTax +
                ", cdmrDate=" + cdmrDate +
                ", type='" + type + '\'' +
                ", adjustments=" + adjustments +
                '}';
    }
}
