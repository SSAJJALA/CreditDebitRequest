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
 * DirectToSearch controller servlet fto direct to to cdmr search page
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-24
 */
@WebServlet(name = "DirectToSearch",
        urlPatterns = {"/toSearch"}
)
public class DirectToSearch extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Method for post
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException servlet exception
     * @throws IOException IO Exception
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Method for get
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException servlet exception
     * @throws IOException IO Exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        logger.info("direct to search servlet context:" + request.getContextPath());
        RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
        dispatcher.forward(request, response);
    }
}

