package com.cdmr.ui;

import com.cdmr.entity.Cdmr;
import com.cdmr.entity.SearchCDMR;
import com.cdmr.persistence.CdmrDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 9/23/16.
 */
public class Search {
    private String searchFilter;
    private String operand;
    private String searchValue;

    List<SearchCDMR> searchResults = new ArrayList<SearchCDMR>();

    public Search() {
    }

    public Search(String searchFilter, String operand, String searchValue) {
        this.searchFilter = searchFilter;
        this.operand = operand;
        this.searchValue = searchValue;
    }

    public String getSearchFilter() {
        return searchFilter;
    }

    public void setSearchFilter(String searchFilter) {
        this.searchFilter = searchFilter;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<SearchCDMR> search() {

        CdmrDao cdmrs = new CdmrDao();
        List<SearchCDMR> prepareResults = null;
        String column = null;
        if (this.getSearchFilter().equals("RequisitionID")) {
            column = "requisitionID";
        } else if (this.getSearchFilter().equals("CustomerName")) {
            column = "custName";
        } else if (this.getSearchFilter().equals("ReqDate")) {
            column = "cdmrDate";
        }

        List<Cdmr> searchResults = cdmrs.getCdmrs(column, this.getOperand(), this.getSearchValue());

        for (Cdmr cdmr:searchResults) {
            SearchCDMR tempCDMR = new SearchCDMR();
            tempCDMR.setRequisitionID(cdmr.getRequisitionID());
            tempCDMR.setCustNo(cdmr.getCustNum());
            tempCDMR.setCustName(cdmr.getCustName());
            tempCDMR.setAdjAmnt(cdmr.getAdjAmnt());
            tempCDMR.setInvoiceNum(cdmr.getInvNum());
            tempCDMR.setInvAmnt(cdmr.getInvAmount());
            tempCDMR.setStatus(cdmr.getStatus());
            tempCDMR.setReqType(cdmr.getType());
            prepareResults.add(tempCDMR);
        }

        return prepareResults;
    }


}
