package com.cdmr.requisition;

import com.cdmr.Data.CDMR;
import com.cdmr.entity.Cdmr;
import com.cdmr.entity.Customer;
import com.cdmr.entity.InvoiceHeader;
import com.cdmr.persistence.CdmrDao;
import com.cdmr.persistence.CustomerDao;
import com.cdmr.persistence.InvoiceHeaderDao;

/**
 * Created by student on 9/26/16.
 */
public class GetRequisition {
    private CDMR cdmr;
    private int requisitionID;
    private int customerNum;
    private int taskID;
    private int invNum;

    public GetRequisition(int requisitionID, int taskID) {
        this.requisitionID = requisitionID;
        this.taskID = taskID;
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
       this.prepareCDMRComments();
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
        InvoiceHeader invHeaderEntity = invHeaderDao.getInvoiceHeader(this.getInvNum());
        com.cdmr.Data.InvoiceHeader  invHeaderData = new com.cdmr.Data.InvoiceHeader();
        invHeaderData.setInvNum(invHeaderEntity.getInvoiceNum());
        invHeaderData.setCustNum(invHeaderEntity.getCustNum());
        invHeaderData.setAllowanceAmnt(invHeaderEntity.getAllowance());
        invHeaderData.setChargesAmnt(invHeaderEntity.getCharges());
        invHeaderData.setGrossAmnt(invHeaderEntity.getGrossAmnt());
        invHeaderData.setTaxAmnt(invHeaderEntity.getTax());
        invHeaderData.setNetAmnt(invHeaderEntity.getNetAmnt());
        invHeaderData.setInvDate(invHeaderEntity.getInvDate());

        cdmr.setInvHeader(invHeaderData);

    }

    public void prepareCDMRAdjs() {

    }

    public void prepareCDMRComments() {

    }



}
