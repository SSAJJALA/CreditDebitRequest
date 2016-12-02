package com.cdmr.controller;

import com.cdmr.entity.SearchCDMR;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 10/13/16.
 */
public class SearchServletTest {

    private  SearchServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception{
        servlet = new SearchServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
    @Test
    public void doPost() throws Exception {

        request.addParameter("searchoptions", "requisitionID");
        request.addParameter("operands", "=");
        request.addParameter("searchTerm", "60");
        servlet.doPost(request, response);
        List<SearchCDMR>  searchResults = (List<SearchCDMR>) request.getAttribute("results");
        logger.info("Requisition:" + searchResults.get(0).getRequisitionID());
        assertEquals("Requisition ID doesn't match", 60, searchResults.get(0).getRequisitionID());

    }

}