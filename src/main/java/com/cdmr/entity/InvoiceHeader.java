package com.cdmr.entity;

import com.cdmr.util.LocalDateAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Siva Sajjala on 9/18/16.
 */

@Entity
@Table(name = "INVOICE_HEADER")
public class InvoiceHeader implements Serializable {

    @EmbeddedId
    private InvoiceHeaderPK invCustomer;

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


    public InvoiceHeader() {
    }

    public InvoiceHeader(InvoiceHeaderPK invCustomer, LocalDate invDate, Double grossAmnt, Double allowance, Double charges, Double tax, Double netAmnt) {
        this.invCustomer = invCustomer;
        this.invDate = invDate;
        this.grossAmnt = grossAmnt;
        this.allowance = allowance;
        this.charges = charges;
        this.tax = tax;
        this.netAmnt = netAmnt;
    }

    public InvoiceHeaderPK getInvCustomer() {
        return invCustomer;
    }

    public void setInvCustomer(InvoiceHeaderPK invCustomer) {
        this.invCustomer = invCustomer;
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

    @Override
    public String toString() {
        return "InvoiceHeader{" +
                "invCustomer=" + invCustomer +
                ", invDate=" + invDate +
                ", grossAmnt=" + grossAmnt +
                ", allowance=" + allowance +
                ", charges=" + charges +
                ", tax=" + tax +
                ", netAmnt=" + netAmnt +
                '}';
    }
}
