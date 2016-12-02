package com.cdmr.controller;

import com.cdmr.entity.SearchCDMR;
import com.cdmr.entity.SearchInbox;
import com.sun.security.auth.UserPrincipal;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.security.Principal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 10/13/16.
 */
public class InboxServletTest {

    private  InboxServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception{
        servlet = new InboxServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
    @Test
    public void doPost() throws Exception {
        Principal user = new UserPrincipal("VYU6026");
        request.setUserPrincipal(user);

        logger.info("logged in user:" + request.getUserPrincipal().getName());
        servlet.doPost(request, response);
        List<SearchInbox>  inboxResults = (List<SearchInbox>) request.getAttribute("inbox");
        //logger.info("Task ID:" + inboxResults.get(0).getTaskID());
        //assertEquals("Task ID doesn't match", 3, inboxResults.get(0).getTaskID());
        assertNotNull("No tasks existing", inboxResults);


    }

}