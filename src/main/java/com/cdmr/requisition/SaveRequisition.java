package com.cdmr.requisition;

import com.cdmr.Data.*;
import com.cdmr.Data.Customer;
import com.cdmr.Data.InvoiceHeader;
import com.cdmr.entity.*;
import com.cdmr.persistence.*;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

/**
 * SaveRequisition class save a CDMR requisition to the database.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-26
 */
public class SaveRequisition {

    private CDMR cdmr;
    private int requisitionID;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * No arg constructor
     */
    public SaveRequisition() {
    }

    /**
     * constructor with arg
     * @param cdmr cdmr document
     */
    public SaveRequisition(CDMR cdmr) {
        this();
        this.cdmr = cdmr;
    }

    /**
     * get cdmr
     * @return cdmr
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
     * Methods to save a requisition
     * @return requisition id
     * @throws Exception
     */
    public int save() throws Exception {
        try {
            requisitionID = this.insertRequisition();
            this.insertCDMRHeader();
            this.insertCDMRDetails();

        } catch (Exception e)   {
            log.error("Save requisition failed for customer " + cdmr.getCustomer().getCustNum() + " - " + cdmr.getCustomer().getCustName() + "error " + e.getMessage()  );
            log.error(e.getStackTrace());
            throw e;
        }

        return this.requisitionID;


    }

    /**
     * inserts requisition table
     * @return requisition id
     */
    public int insertRequisition() {
        Requisition req = new Requisition();
        req.setAppID(1);
        req.setAppName("CDMR");
        req.setCreatedDate(LocalDateTime.now());
        req.setUpdatedDate(LocalDateTime.now());
        //RequisitionDao reqDao = new RequisitionDao();
        RequisitionDAOnew reqDao = new RequisitionDAOnew();
        //int reqID = reqDao.addRequisition(req);
        int reqID = reqDao.add(req);
        cdmr.setRequisitionID(reqID);
        return reqID;
    }

    /**
     * inserts cdmr header details
     */
    public void insertCDMRHeader() {

        //Prepare CDMR header details
        Cdmr cdmrHeader = new Cdmr();
        cdmrHeader.setRequisitionID(cdmr.getRequisitionID());
        cdmrHeader.setAdjAmnt(cdmr.getAdjAmnt());
        cdmrHeader.setCdmrDate(cdmr.getCdmrDate());
        Customer cust = cdmr.getCustomer();
        cdmrHeader.setCustNum(cust.getCustNum());
        cdmrHeader.setCustName(cust.getCustName());
        cdmrHeader.setSalesRepID(cdmr.getSalesRepID());
        cdmrHeader.setSalesRepName(cdmr.getSalesRepName());
        cdmrHeader.setStatus(cdmr.getStatus());

        if (cdmr.getType().equals("Credit")) {
            cdmrHeader.setType("C");
        } else {
            cdmrHeader.setType("D");
        }

        InvoiceHeader invHeader = cdmr.getInvHeader();
        cdmrHeader.setInvAmount(invHeader.getNetAmnt());
        cdmrHeader.setInvDate(invHeader.getInvDate());
        cdmrHeader.setInvNum(invHeader.getInvNum());

        //Insert CDMR header table
        /**
        CdmrDao cdmrDao = new CdmrDao();
        cdmrDao.addCdmr(cdmrHeader);
         **/
        CdmrDAOnew cdmrDao = new CdmrDAOnew();
        cdmrDao.add(cdmrHeader);

    }

    /**
     * inserts cdmr details
     */

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
            if (adj.getCreditDebitFlg().equals("Credit")) {
                cdmrAdj.setCdFlag("C");
            } else {
                cdmrAdj.setCdFlag("D");
            }

            cdmrAdj.setChargesAdj(adj.getChargeAdjAmnt());
            cdmrAdj.setCustNum(cdmr.getCustomer().getCustNum());
            cdmrAdj.setExtPrice(adj.getLineAdjAmnt());
            cdmrAdj.setItemDesc(adj.getItemDesc());
            cdmrAdj.setNewInvLineAmnt(adj.getNewInvLineTotal());
            cdmrAdj.setReasonCode(adj.getReasonCode());
            cdmrAdj.setTaxAdj(adj.getTaxAdjAmnt());


            //CdmrAdjustmentsDao adjDao = new CdmrAdjustmentsDao();
            CdmrAdjustmentDAOnew adjDao = new CdmrAdjustmentDAOnew();
            adjDao.addCdmrAdj(cdmrAdj);
            this.insertComments(adj.getComments());

        }

    }

    /**
     * inserts comments to comment table
     * @param comments
     */
    public void insertComments(List<CDMRComment> comments) {

        int count = 0;

        for (CDMRComment comment : comments) {
            count++;
            Comment tempComment = new Comment();
            tempComment.setRequisitionID(cdmr.getRequisitionID());
            tempComment.setComment(comment.getComment());
            tempComment.setCreatedDate(comment.getCreatedDate());
            tempComment.setSeqID(count);
            tempComment.setUserID(comment.getUserID());
            tempComment.setItemNum(comment.getItemNum());

            CommentDao commentDao = new CommentDao();
            commentDao.addComment(tempComment);


        }

    }


}
