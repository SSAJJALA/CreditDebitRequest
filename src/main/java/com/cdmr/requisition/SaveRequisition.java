package com.cdmr.requisition;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.Customer;
import com.cdmr.Data.InvoiceHeader;
import com.cdmr.entity.Cdmr;
import com.cdmr.persistence.CdmrDao;

/**
 * Created by student on 9/26/16.
 */
public class SaveRequisition {

    private CDMR cdmr;

    public SaveRequisition() {
    }

    public SaveRequisition(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public CDMR getCdmr() {
        return cdmr;
    }

    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public String save() {
        this.insertCDMRHeader();

        return "CDMR created succesfully";


    }

    public void insertCDMRHeader() {

        //Prepare CDMR header details
        Cdmr cdmrHeader = new Cdmr();

        cdmrHeader.setAdjAmnt(cdmr.getAdjAmnt());
        cdmrHeader.setCdmrDate(cdmr.getCdmrDate());
        Customer cust = cdmr.getCustomer();
        cdmrHeader.setCustNum(cust.getCustNum());
        cdmrHeader.setCustName(cust.getCustName());
        cdmrHeader.setSalesRepID(cdmrHeader.getSalesRepID());
        cdmrHeader.setSalesRepName(cdmrHeader.getSalesRepName());
        cdmrHeader.setStatus("In Progress");
        cdmrHeader.setType(cdmrHeader.getType());

        InvoiceHeader invHeader = new InvoiceHeader();
        cdmrHeader.setInvAmount(invHeader.getNetAmnt());
        cdmrHeader.setInvDate(invHeader.getInvDate());
        cdmrHeader.setInvNum(invHeader.getInvNum());

        //Insert CDMR header table
        CdmrDao cdmrDao = new CdmrDao();
        cdmrDao.addCdmr(cdmrHeader);

    }

    public void insertCDMRDetails() {

    }


}
