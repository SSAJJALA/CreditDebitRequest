package com.cdmr.ui;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.CDMRAdjustments;
import com.cdmr.Task.QueueTask;
import com.cdmr.entity.*;
import com.cdmr.persistence.*;
import com.cdmr.requisition.SaveRequisition;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siva Sajjala on 9/29/16.
 */
public class SubmitCDMR {
    private CDMR cdmr;
    private final Logger log = Logger.getLogger(this.getClass());

    public SubmitCDMR() {
    }

    public SubmitCDMR(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public CDMR getCdmr() {
        return cdmr;
    }

    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public String saveCDMR() {
        String message = null;
        SaveRequisition save = new SaveRequisition(cdmr);

        try {
            int reqID = save.save();
            cdmr.setRequisitionID(reqID);

            if (reqID != 0 ) {

                message = "Requisition " + reqID + " submitted successfully";
                log.info(message);

                //queue DSM task
                int taskID = this.queueTask();
                log.info("DSM Task: " + taskID + " created successfully");

                //update invoice header and detail
                this.updateInvoice();

                //update the CDMR status to In Progress
                this.updateStatus();

            } else {
                message = "Unable to submit the requisition. Please contact the help desk";
                log.info(message);
            }

        } catch (Exception e) {
            message = "Unable to submit the requisition. Please contact the help desk";
            log.info(message);
        }


        return message;
    }

    public int queueTask() {
        QueueTask createTask = new QueueTask();
        createTask.setTaskName("DSM Approval");
        createTask.setReqID(cdmr.getRequisitionID());

        //Get user for the DSM role
        CdmrUserRolesDao userRolesDao = new CdmrUserRolesDao();
        List<Filter> filters = new ArrayList<Filter>();
        Filter filter = new Filter();
        filter.setSearchOption("role");
        filter.setOperand("=");
        filter.setSearchValue("DSM");
        filters.add(filter);
        List<CdmrUserRoles> roles = userRolesDao.getUserRoles(filters);
        createTask.setAssignToUserID(roles.get(0).getUserRoles().getUserID());

        int taskID = createTask.createTask();
        return taskID;
    }

    public void updateStatus() {
        CdmrDao cdmrDao = new CdmrDao();
        Cdmr tempCDMR = cdmrDao.getCdmr(cdmr.getRequisitionID());
        tempCDMR.setStatus("In Progress");
        cdmrDao.updateCdmr(tempCDMR);
    }

    public void updateInvoice() {

        List<CDMRAdjustments> adjs = cdmr.getAdjustments();

        for (CDMRAdjustments adj : adjs) {
            InvoiceDetail tempInvDtl = new InvoiceDetail();
            InvoiceDetailDao tempInvDtlDao = new InvoiceDetailDao();
            InvoiceDetailPK tempInvDtlPK = new InvoiceDetailPK();
            tempInvDtlPK.setInvNum(cdmr.getInvHeader().getInvNum());
            tempInvDtlPK.setItemNum(adj.getItemNum());

            tempInvDtl = tempInvDtlDao.getInvoiceDetail(tempInvDtlPK);

            tempInvDtl.setAllowance((tempInvDtl.getAllowance() + adj.getAllowanceAdjAmnt()));
            tempInvDtl.setCharges((tempInvDtl.getCharges() + adj.getChargeAdjAmnt()));
            tempInvDtl.setQty((tempInvDtl.getQty() + adj.getAdjQty()));
            tempInvDtl.setGrossAmnt((tempInvDtl.getQty() * tempInvDtl.getUnitPrice()));
            tempInvDtl.setTax((tempInvDtl.getTax() + adj.getTaxAdjAmnt()));
            tempInvDtl.setNetAmnt((tempInvDtl.getGrossAmnt() + tempInvDtl.getAllowance() + tempInvDtl.getCharges() + tempInvDtl.getTax()));

            tempInvDtlDao.updateInvoiceDetail(tempInvDtl);

        }

    }

}
