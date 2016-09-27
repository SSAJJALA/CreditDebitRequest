package com.cdmr.requisition;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.CDMRAdjustments;
import com.cdmr.Data.Customer;
import com.cdmr.Data.InvoiceHeader;
import com.cdmr.entity.Cdmr;
import com.cdmr.entity.CdmrAdjustments;
import com.cdmr.entity.CdmrAdjustmentsPK;
import com.cdmr.persistence.CdmrAdjustmentsDao;
import com.cdmr.persistence.CdmrDao;

import java.util.List;

/**
 * Created by student on 9/26/16.
 */
public class SaveRequisition {

    private CDMR cdmr;
    private int requisitionID;

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
        this.insertCDMRDetails();

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
        int reqID = cdmrDao.addCdmr(cdmrHeader);
        cdmr.setRequisitionID(reqID);

    }

    public void insertCDMRDetails() {

        List<CDMRAdjustments> adjs = cdmr.getAdjustments();

        for (CDMRAdjustments adj : adjs) {
            CdmrAdjustmentsPK cdmrAdjpk = new CdmrAdjustmentsPK();
            cdmrAdjpk.setRequisitionID(cdmr.getRequisitionID());
            cdmrAdjpk.setItemNum(adj.getItemNum());
            CdmrAdjustments cdmrAdj = new CdmrAdjustments();
            cdmrAdj.setRequisitionItem(cdmrAdjpk);
            cdmrAdj.setAdjQty(adj.getAdjQty());
            cdmrAdj.setAllowanceAdj(adj.getAllowanceAdjAmnt());
            cdmrAdj.setCdFlag(adj.getCreditDebitFlg());
            cdmrAdj.setChargesAdj(adj.getChargeAdjAmnt());
            cdmrAdj.setCustNum(cdmr.getCustomer().getCustNum());
            cdmrAdj.setExtPrice(adj.getLineAdjAmnt());
            cdmrAdj.setItemDesc(adj.getItemDesc());
            cdmrAdj.setNewInvLineAmnt(adj.getNewInvLineTotal());
            cdmrAdj.setReasonCode(adj.getReasonCode());
            cdmrAdj.setTaxAdj(adj.getTaxAdjAmnt());

            CdmrAdjustmentsDao adjDao = new CdmrAdjustmentsDao();
            adjDao.addCdmrAdj(cdmrAdj);

        }



    }


}
