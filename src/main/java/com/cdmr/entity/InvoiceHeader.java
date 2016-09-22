package com.cdmr.entity;

import com.cdmr.util.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Siva Sajjala on 9/18/16.
 */

@Entity
@Table(name = "INVOICE_HEADER")
public class InvoiceHeader {

    @Id
    @Column(name="INV_NUM")
    private int invoiceNum;

    @ManyToOne
    @JoinColumn(name="CUST_NUM")
    private Customer cust;

    @Column(name = "INV_DATE")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate invDate;

    @Column(name = "GROSS_AMNT")
    private Double grossAmnt;

    @Column(name = "ALLOWANCE")
    private Double allowance;

    @Column(name = "CHARGES")
    private Double charges;

    @Column(name = "TAX")
    private Double tax;

    @Column(name = "NET_AMNT")
    private Double netAmnt;

    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceDetail> invoiceDetails;

    public InvoiceHeader() {
    }

    public InvoiceHeader(int invoiceNum, LocalDate invDate, Double grossAmnt, Double allowance, Double charges, Double tax, Double netAmnt) {
        this.invoiceNum = invoiceNum;
        this.invDate = invDate;
        this.grossAmnt = grossAmnt;
        this.allowance = allowance;
        this.charges = charges;
        this.tax = tax;
        this.netAmnt = netAmnt;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public LocalDate getInvDate() {
        return invDate;
    }

    public void setInvDate(LocalDate invDate) {
        this.invDate = invDate;
    }

    public Double getGrossAmnt() {
        return grossAmnt;
    }

    public void setGrossAmnt(Double grossAmnt) {
        this.grossAmnt = grossAmnt;
    }

    public Double getAllowance() {
        return allowance;
    }

    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getNetAmnt() {
        return netAmnt;
    }

    public void setNetAmnt(Double netAmnt) {
        this.netAmnt = netAmnt;
    }

    public Set<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(Set<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" +
                "invoiceNum=" + invoiceNum +
                ", cust=" + cust +
                ", invDate=" + invDate +
                ", grossAmnt=" + grossAmnt +
                ", allowance=" + allowance +
                ", charges=" + charges +
                ", tax=" + tax +
                ", netAmnt=" + netAmnt +
                '}';
    }
}
