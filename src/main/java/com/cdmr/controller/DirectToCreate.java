package com.cdmr.controller;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by student on 10/2/16.
 */
@WebServlet(name = "DirectToCreate",
        urlPatterns = {"/toCreate"}
)
public class DirectToCreate extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        logger.info("direct to create servlet context:" + request.getContextPath());
        RequestDispatcher dispatcher = request.getRequestDispatcher("createCdmr.jsp");
        dispatcher.forward(request, response);
    }
}
