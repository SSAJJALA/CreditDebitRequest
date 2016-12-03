package com.cdmr.webservices;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

/**
 * Created by siva sajjala on 10/16/16.
 */
public class CustomerLookupConsumerTest {

    private final Logger log = Logger.getLogger(this.getClass());

    CustomerLookupConsumer customerLookup = null;
    @Before
    public void setUp() throws Exception {
        customerLookup = new CustomerLookupConsumer();
    }

    @Test
    public void getCustomerApiJSON() throws Exception {
        Customer cust = null;
        try {
            cust = customerLookup.getCustomerApiJSON(1000);
            log.info("Customer number: " + cust.getCustNum());
            assertEquals("Customer doesn't match", 1000, cust.getCustNum());
        } catch (Exception e) {
            assertEquals("Customer lookup failed", "Customer lookup webservice not available", e.getMessage());
        }
    }

}