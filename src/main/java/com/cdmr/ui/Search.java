package com.cdmr.ui;

import com.cdmr.entity.Cdmr;
import com.cdmr.entity.SearchCDMR;
import com.cdmr.persistence.CdmrDAOnew;
import com.cdmr.persistence.CdmrDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Search programs based on filter criteria.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-23
 */
public class Search {
    private String searchFilter;
    private String operand;
    private String searchValue;

    List<SearchCDMR> searchResults = new ArrayList<SearchCDMR>();

    /**
     * No arg constructor
     */
    public Search() {
    }

    /**
     * arg constructor
     * @param searchFilter
     * @param operand
     * @param searchValue
     */
    public Search(String searchFilter, String operand, String searchValue) {
        this();
        this.searchFilter = searchFilter;
        this.operand = operand;
        this.searchValue = searchValue;
    }

    /**
     * get search filter
     * @return searchFilter
     */
    public String getSearchFilter() {
        return searchFilter;
    }

    /**
     * set search filter
     * @param searchFilter
     */
    public void setSearchFilter(String searchFilter) {
        this.searchFilter = searchFilter;
    }

    /**
     * get operand
     * @return operand
     */
    public String getOperand() {
        return operand;
    }

    /**
     * set operand
     * @param operand
     */
    public void setOperand(String operand) {
        this.operand = operand;
    }

    /**
     * get search value
     * @return searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * set search value
     * @param searchValue
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    /**
     * main search method that brings back the cdmrs based on search criteria
     * @return SearchCDMR List of CDMRs
     */
    public List<SearchCDMR> search() {
        /**
        CdmrDao cdmrs = new CdmrDao();
         **/
        CdmrDAOnew cdmrs = new CdmrDAOnew();

        List<SearchCDMR> prepareResults = new ArrayList<SearchCDMR>();
        String column = null;
        if (this.getSearchFilter().equals("requisitionID")) {
            column = "requisitionID";
        } else if (this.getSearchFilter().equals("customerName")) {
            column = "custName";
        } else if (this.getSearchFilter().equals("reqDate")) {
            column = "cdmrDate";
        } else if (this.getSearchFilter().equals("status")) {
            column = "status";
        } else if (this.getSearchFilter().equals("all")) {
            column = "";
        }

        /**
        List<Cdmr> searchResults = cdmrs.getCdmrs(column, this.getOperand(), this.getSearchValue());
         **/
        List<Cdmr> searchResults = (List<Cdmr>) cdmrs.getWithFilters(column, this.getOperand(), this.getSearchValue());


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
