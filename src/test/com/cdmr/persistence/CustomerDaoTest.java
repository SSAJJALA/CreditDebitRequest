package com.cdmr.persistence;

import com.cdmr.entity.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Siva Sajjala on 9/18/16.
 */
public class CustomerDaoTest {

    Customer cust = new Customer();

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void getAllCustomers() throws Exception {

    }

    @Test
    public void getCustomer() throws Exception {

    }

    @Test
    public void addCustomer() throws Exception {

        cust.setCustNum(1000);
        cust.setCustName("Experis");
        cust.setAdd1("100");
        cust.setAdd2("Manpower Place");
        cust.setCity("Milwaukee");
        cust.setState("WI");
        cust.setZip("53212");
        cust.setPhone("414-961-1000");
        CustomerDao custDao = new CustomerDao();
        custDao.addCustomer(cust);
        assertNotNull("addcustomer failed",custDao.getCustomer(1000));

    }

    @Test
    public void deleteCustomer() throws Exception {

    }

    @Test
    public void updateReq() throws Exception {

    }

}