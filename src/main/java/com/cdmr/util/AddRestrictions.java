package com.cdmr.util;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


/**
 * Utility class to add the hibernate restrictions to sql queries.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-02
 */
public class AddRestrictions {

    /**
     * No arg constructor
     */
    public AddRestrictions() {
    }

    /**
     * Add filters to the search
     * @param tempCriteria
     * @param option
     * @param operand
     * @param value
     * @return Criteria with added restrictions
     */
    public Criteria addRestrictions(Criteria tempCriteria, String option, String operand, Object value) {

        if (operand.equals("="))  {
            tempCriteria.add(Restrictions.eq(option, value));
        } else if (operand.equals(">")) {
            tempCriteria.add(Restrictions.gt(option, value));
        } else if (operand.equals("<")) {
            tempCriteria.add(Restrictions.lt(option, value));
        } else if (operand.equals(">=")) {
            tempCriteria.add(Restrictions.ge(option, value));
        } else if (operand.equals("<=")) {
            tempCriteria.add(Restrictions.le(option, value));
        } else if (operand.equals("LIKE")) {
            value = "%" + value + "%";
            tempCriteria.add(Restrictions.like(option, value));
        } else if (operand.equals("!=")) {
            tempCriteria.add(Restrictions.ne(option, value));
        }

        return tempCriteria;

    }
}
