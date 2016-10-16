package com.cdmr.webservices;

import com.cdmr.entity.Customer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 10/8/16.
 */
public class CustomerLookupTest {

    CustomerLookup customerLookup = null;

    @Before
    public void setUp() {
        customerLookup = new CustomerLookup();
    }

    @Test
    public void getCustomer() throws Exception {
        //Customer cust = customerLookup.getCustomer(1000);
        //assertEquals("Customer doesn't match", cust.getCustNum(), 1000);
    }

}