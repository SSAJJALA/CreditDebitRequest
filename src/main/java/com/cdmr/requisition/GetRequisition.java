package com.cdmr.requisition;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.CDMRAdjustments;
import com.cdmr.Data.CDMRComment;
import com.cdmr.entity.*;
import com.cdmr.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/26/16.
 */
public class GetRequisition {
    private CDMR cdmr;
    private int requisitionID;
    private int customerNum;
    private int taskID;
    private int invNum;

    public GetRequisition() {
    }



    public GetRequisition(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    public CDMR getCdmr() {
        return cdmr;
    }

    public void setCdmr(CDMR cdmr) {
        this.cdmr = cdmr;
    }

    public int getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public CDMR getRequisition() {

       this.prepareCDMRHeader();
       this.prepareCustomerInfo();
       this.prepareInvoiceInfo();
       this.prepareCDMRAdjs();
       return this.getCdmr();
    }

    public void prepareCDMRHeader() {
        CdmrDao cdmrHeaderDao = new CdmrDao();
        Cdmr cdmrHeader = cdmrHeaderDao.getCdmr(this.getRequisitionID());
        cdmr = new CDMR();
        cdmr.setRequisitionID(this.getRequisitionID());
        cdmr.setAdjAmnt(cdmrHeader.getAdjAmnt());
        cdmr.setCdmrDate(cdmrHeader.getCdmrDate());
        cdmr.setSalesRepID(cdmrHeader.getSalesRepID());
        cdmr.setSalesRepName(cdmrHeader.getSalesRepName());
        cdmr.setStatus(cdmrHeader.getStatus());
        cdmr.setType(cdmrHeader.getType());
        this.setCustomerNum(cdmrHeader.getCustNum());
        this.setInvNum(cdmrHeader.getInvNum());
    }

    public void prepareCustomerInfo() {
        CustomerDao customerDao = new CustomerDao() ;
        Customer custEntity = customerDao.getCustomer(this.getCustomerNum());
        com.cdmr.Data.Customer custData = new com.cdmr.Data.Customer();
        custData.setAddress1(custEntity.getAdd1());
        custData.setAddress2(custEntity.getAdd2());
        custData.setCustName(custEntity.getCustName());
        custData.setCustNum(custEntity.getCustNum());
        custData.setPhone(custEntity.getPhone());
        custData.setState(custEntity.getState());
        custData.setZip(custEntity.getZip());
        cdmr.setCustomer(custData);

    }

    public void prepareInvoiceInfo() {
        InvoiceHeaderDao invHeaderDao = new InvoiceHeaderDao();
        InvoiceHeaderPK invCust = new InvoiceHeaderPK(invNum, customerNum);
        InvoiceHeader invHeaderEntity = invHeaderDao.getInvoiceHeader(invCust);
        com.cdmr.Data.InvoiceHeader  invHeaderData = new com.cdmr.Data.InvoiceHeader();
        invHeaderData.setInvNum(invHeaderEntity.getInvCustomer().getInvoiceNum());
        invHeaderData.setCustNum(invHeaderEntity.getInvCustomer().getCustNum());
        invHeaderData.setAllowanceAmnt(invHeaderEntity.getAllowance());
        invHeaderData.setChargesAmnt(invHeaderEntity.getCharges());
        invHeaderData.setGrossAmnt(invHeaderEntity.getGrossAmnt());
        invHeaderData.setTaxAmnt(invHeaderEntity.getTax());
        invHeaderData.setNetAmnt(invHeaderEntity.getNetAmnt());
        invHeaderData.setInvDate(invHeaderEntity.getInvDate());

        cdmr.setInvHeader(invHeaderData);

    }


    public void prepareCDMRAdjs() {
        List<CDMRAdjustments> adjsData = new ArrayList<CDMRAdjustments>();
        CdmrAdjustmentsDao adjDao = new CdmrAdjustmentsDao();

        List<Filter> reqFilter = new ArrayList<Filter>();
        Filter reqTempFilter = new Filter();
        reqTempFilter.setSearchOption("requisitionID");
        reqTempFilter.setOperand("=");
        reqTempFilter.setSearchValue(String.valueOf(this.getRequisitionID()));
        reqFilter.add(reqTempFilter);
        List<CdmrAdjustments> adjEntitys = adjDao.getCdmrAdjs(reqFilter);

        for (CdmrAdjustments adjEntity : adjEntitys) {
            CDMRAdjustments adjData = new CDMRAdjustments();
            adjData.setComments(this.prepareCDMRComments(this.requisitionID, adjEntity.getRequisitionItem().getItemNum()));
            adjData.setAdjQty(adjEntity.getAdjQty());
            adjData.setAllowanceAdjAmnt(adjEntity.getAllowanceAdj());
            adjData.setChargeAdjAmnt(adjEntity.getChargesAdj());
            adjData.setCreditDebitFlg(adjEntity.getCdFlag());
            adjData.setItemDesc(adjEntity.getItemDesc());
            adjData.setItemNum(adjEntity.getRequisitionItem().getItemNum());
            adjData.setLineAdjAmnt(adjEntity.getExtPrice());
            adjData.setNewInvLineTotal(adjEntity.getNewInvLineAmnt());

            InvoiceDetailDao invDtlsDao = new InvoiceDetailDao();
            List<Filter> invItemFilter = new ArrayList<Filter>();
            Filter invFilter = new Filter();
            invFilter.setSearchOption("invNum");
            invFilter.setOperand("=");
            invFilter.setSearchValue(Integer.toString(cdmr.getInvHeader().getInvNum()));
            invItemFilter.add(invFilter);
            Filter itemFilter = new Filter();
            itemFilter.setSearchOption("itemNum");
            itemFilter.setOperand("=");
            itemFilter.setSearchValue(Integer.toString(adjEntity.getRequisitionItem().getItemNum()));
            invItemFilter.add(itemFilter);
            List<InvoiceDetail> invDetails = invDtlsDao.getInvoicesWithFilter(invItemFilter);
            adjData.setOriginalInvLineTotal(invDetails.get(0).getNetAmnt());
            adjData.setOriginalPrice(invDetails.get(0).getUnitPrice());
            adjData.setOriginalQty(invDetails.get(0).getQty());
            adjData.setReasonCode(adjEntity.getReasonCode());
            adjData.setTaxAdjAmnt(adjEntity.getTaxAdj());

            //add adjustment to adjsData
            adjsData.add(adjData);
        }

        //set cdmr adjustments
        cdmr.setAdjustments(adjsData);

    }



    public List<CDMRComment> prepareCDMRComments(int reqID, int itemNum) {
        List<CDMRComment> commentsData = new ArrayList<CDMRComment>();
        CommentDao commentDao = new CommentDao();
        List<Filter> filters = new ArrayList<Filter>();

        //Add first filter
        Filter filter1 = new Filter();
        filter1.setSearchValue(Integer.toString(reqID));
        filter1.setOperand("=");
        filter1.setSearchOption("requisitionID");
        filters.add(filter1);

        //Add second filter
        Filter filter2 = new Filter();
        filter2.setSearchValue(Integer.toString(itemNum));
        filter2.setOperand("=");
        filter2.setSearchOption("itemNum");
        filters.add(filter2);

        List<Comment> comments = commentDao.getCommentsWithFilter(filters);

        for (Comment comment : comments) {
            CDMRComment commentData = new CDMRComment();
            commentData.setRequisitionID(this.getRequisitionID());
            commentData.setUserID(comment.getUserID());
            commentData.setComment(comment.getComment());
            commentData.setCreatedDate(comment.getCreatedDate());
            commentData.setSeqID(comment.getSeqID());
            commentsData.add(commentData);

        }

        return commentsData;

    }



}
