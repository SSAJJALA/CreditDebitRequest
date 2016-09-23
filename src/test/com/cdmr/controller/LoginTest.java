package com.cdmr.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Siva Sajjala on 9/22/16.
 */
public class LoginTest {
    private Login servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() throws Exception{
        servlet = new Login();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }


    @Test
    public void doPost() throws ServletException, IOException {

        request.addParameter("username", "SSAJJALA");
        request.addParameter("password", "Stoney@2016");
        servlet.doPost(request, response);
        assertEquals("text/html", response.getContentType());
    }

}