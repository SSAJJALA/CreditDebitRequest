package com.cdmr.controller;

import com.cdmr.Data.CDMR;
import com.cdmr.entity.Task;
import com.cdmr.ui.GetCDMRDetails;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.*;

/**
 * Created by student on 11/6/16.
 */
public class CDMRDetailsServletTest {

    private  CDMRDetailsServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception{
        servlet = new CDMRDetailsServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
    @Test
    public void doGet() throws Exception {
        GetCDMRDetails details = new GetCDMRDetails(0, 47, "VYU6026");
        CDMR cdmr = details.getCDMR();
        Task task = details.getTaskDetails();
        request.setAttribute("cdmr", cdmr);
        request.setAttribute("taskDetails", task);
        request.setParameter("btn_approve", "btn_approve");

        servlet.doGet(request, response);

        String message = (String) request.getAttribute("message");
        assertEquals("CDMR Routing failed", "CDMR routed to FM", message);

    }

}