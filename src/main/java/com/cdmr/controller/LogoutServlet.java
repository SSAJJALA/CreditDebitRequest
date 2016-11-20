package com.cdmr.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LogoutServlet controller servlet. Session invalidates and logs out.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-25
 */
@WebServlet(
        name = "logoutServlet",
        urlPatterns = {"/logoutServlet"}

)
public class LogoutServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Method for post
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException servlet exception
     * @throws IOException IO Exception
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * Method for get
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException servlet exception
     * @throws IOException IO Exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        logger.info("logout servlet context:" + request.getContextPath());
        response.sendRedirect("index.jsp");
    }
}
