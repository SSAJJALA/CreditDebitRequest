package com.cdmr.util;

import com.cdmr.entity.Filter;

/**
 * Generate filter object based on search fields
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-02
 */
public class CreateFilter {

    /**
     * Create filter object
     * @param searchValue
     * @param operand
     * @param option
     * @return
     */
    public Filter getFilter(String searchValue, String operand, String option) {
        Filter filter = new Filter();
        filter.setSearchValue(searchValue);
        filter.setOperand(operand);
        filter.setSearchOption(option);

        return filter;
    }
}
