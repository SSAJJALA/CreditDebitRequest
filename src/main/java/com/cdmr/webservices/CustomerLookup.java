package com.cdmr.webservices;

import com.cdmr.entity.Customer;
import com.cdmr.persistence.CustomerDao;

/**
 * Created by Siva Sajjala on 9/18/16.
 */
public class CustomerLookup {

    /**
     * Method to get the customer details
     * @param custNum
     * @return Customer the customer object
     */
    public Customer getCustomer(int custNum) {
        int custNo = custNum;
        Customer cust;
        CustomerDao custDao = new CustomerDao();
        cust = custDao.getCustomer(custNo);
        return cust;
    }

}