package com.cdmr.util;

import com.cdmr.entity.Filter;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Utility class to get the update DB criteria with filter conditions
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-04
 */
public class GetUpdatedCriteria {

    /**
     * Main method to update the criteria
     * @param c Criteria
     * @param filters
     * @return Criteria c
     */
    public Criteria getUpdatedCriteria(Criteria c, List<Filter> filters) {
        AddRestrictions addRestrictions = new AddRestrictions();
        for (Filter filter : filters) {
            String option = filter.getSearchOption();
            String operand = filter.getOperand();
            String value = filter.getSearchValue();

            Object searchValue = null;

            switch (option) {
                case "custNum" :
                    searchValue = Integer.parseInt(value);
                    break;
                case "invNum" :
                    option = "invItem.invNum";
                    searchValue = Integer.parseInt(value);
                    break;
                case "itemNum" :
                    option = "invItem.itemNum";
                    searchValue = Integer.parseInt(value);
                    break;
                default:
                    searchValue = value;
            }
            c = addRestrictions.addRestrictions(c, option, operand, searchValue);

        }
        return c;
    }
}
