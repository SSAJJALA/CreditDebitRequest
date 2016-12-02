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
 * SubmitCDMR service to file a new CDMR for approval. This saves all details of the requisition to database and also routes the request first approver.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-29
 */
public class SubmitCDMR {
    private CDMR cdmr;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * No arg constructor
     */
    public SubmitCDMR() {
    }

    /**
     * arg constructor
     * @param cdmr
     */
    public SubmitCDMR(CDMR cdmr) {
        this();
        this.cdmr = cdmr;
    }

    /**
     * get cdmr details
     * @return CDMR
     */
    public CDMR getCdmr() {
        return cdmr;
    }

    /**
     * set cdmr
     * @param cdmr
     */
    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    /**
     * save cdmr to database
     * @return string message
     */
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

    /**
     * create task for the approver
     * @return task id
     */
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

    /**
     * update status
     */
    public void updateStatus() {
        CdmrDao cdmrDao = new CdmrDao();
        Cdmr tempCDMR = cdmrDao.getCdmr(cdmr.getRequisitionID());
        tempCDMR.setStatus("In Progress");
        cdmrDao.updateCdmr(tempCDMR);
    }

    /**
     * Update invoice
     */
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
