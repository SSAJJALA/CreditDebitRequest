package com.cdmr.controller;

import com.cdmr.Data.CDMR;
import com.cdmr.entity.Task;
import com.cdmr.webservices.Customer;
import com.sun.security.auth.UserPrincipal;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.security.Principal;

import static org.junit.Assert.*;

/**
 * Created by student on 11/5/16.
 */
public class DirectToDetailsTest {

    private  DirectToDetails servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception{
        servlet = new DirectToDetails();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
    @Test
    public void doGet() throws Exception {

        request.addParameter("taskID", "47");
        Principal user = new UserPrincipal("VYU6026");
        request.setUserPrincipal(user);

        servlet.doGet(request, response);

        CDMR cdmr = (CDMR) request.getAttribute("cdmr");
        Task task = (Task) request.getAttribute("taskDetails");
        assertNotNull("cdmr is null:", cdmr);
        assertNotNull("task is null:", task);

    }

}