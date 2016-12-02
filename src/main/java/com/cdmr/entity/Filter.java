package com.cdmr.entity;

/**
 * Created by Siva Sajjala on 9/24/16.
 */
public class Filter {

    private String searchOption;
    private String operand;
    private String searchValue;

    public Filter() {
    }

    public Filter(String searchOption, String operand, String searchValue) {
        this();
        this.searchOption = searchOption;
        this.operand = operand;
        this.searchValue = searchValue;
    }

    public String getSearchOption() {
        return searchOption;
    }

    public void setSearchOption(String searchOption) {
        this.searchOption = searchOption;
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
}
