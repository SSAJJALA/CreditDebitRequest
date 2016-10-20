package com.cdmr.controller;

import com.cdmr.webservices.Customer;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by student on 10/19/16.
 */
public class CreateCDMRServletTest {

    private  CreateCDMRServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception{
        servlet = new CreateCDMRServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
    @Test
    public void doGet() throws Exception {


        request.addParameter("btn_retCust", "Search");
        request.addParameter("customer", "1000");

        servlet.doGet(request, response);

        Customer cust = (Customer) request.getAttribute("customerResults");
        assertEquals("Customer ID doesn't match", 1000, cust.getCustNum());



    }

}