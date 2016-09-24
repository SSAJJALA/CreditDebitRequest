package com.cdmr.entity;

import com.cdmr.util.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Siva Sajjala on 9/16/16.
 */

@Entity
@Table(name = "CDMR")
public class Cdmr {

    @Id
    @Column(name = "REQUISITION_ID")
    private int requisitionID;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CUST_NUM")
    private int custNum;

    @Column(name = "CUST_NAME")
    private String custName;

    @Column(name = "INV_NUM")
    private int invNum;

    @Column(name = "INV_DATE")
    private LocalDate invDate;

    @Column(name = "INV_AMNT")
    private double invAmount;

    @Column(name = "SALESREP_ID")
    private String salesRepID;

    @Column(name = "SALESREP_NAME")
    private String salesRepName;

    @Column(name = "ADJ_AMNT")
    private double adjAmnt;

    @Column(name = "CDMR_DATE")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate cdmrDate;

    @Column(name="TYPE")
    private String type;

    /**
     * No arg constructor
     * Instantiates a new cdmr object
     */
    public Cdmr() {
    }


    public Cdmr(int requisitionID, String status, int custNum, String custName, int invNum, LocalDate invDate, double invAmount, String salesRepID, String salesRepName, double adjAmnt, LocalDate cdmrDate, String type) {
        this.requisitionID = requisitionID;
        this.status = status;
        this.custNum = custNum;
        this.custName = custName;
        this.invNum = invNum;
        this.invDate = invDate;
        this.invAmount = invAmount;
        this.salesRepID = salesRepID;
        this.salesRepName = salesRepName;
        this.adjAmnt = adjAmnt;
        this.cdmrDate = cdmrDate;
        this.type = type;
    }

    /**
     * get requisition ID
     * @return int requisition ID
     */
    public int getRequisitionID() {
        return requisitionID;
    }

    /**
     * Set requisition ID
     * @param requisitionID the requisition ID
     */

    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    /**
     * get status
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * set status
     * @param status the stattus of the requisition
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public LocalDate getInvDate() {
        return invDate;
    }

    public void setInvDate(LocalDate invDate) {
        this.invDate = invDate;
    }

    public double getInvAmount() {
        return invAmount;
    }

    public void setInvAmount(double invAmount) {
        this.invAmount = invAmount;
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

    public double getAdjAmnt() {
        return adjAmnt;
    }

    public void setAdjAmnt(double adjAmnt) {
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

    @Override
    public String toString() {
        return "Cdmr{" +
                "requisitionID=" + requisitionID +
                ", status='" + status + '\'' +
                ", custNum=" + custNum +
                ", custName='" + custName + '\'' +
                ", invNum=" + invNum +
                ", invDate=" + invDate +
                ", invAmount=" + invAmount +
                ", salesRepID='" + salesRepID + '\'' +
                ", salesRepName='" + salesRepName + '\'' +
                ", adjAmnt=" + adjAmnt +
                ", cdmrDate=" + cdmrDate +
                ", type='" + type + '\'' +
                '}';
    }
}
