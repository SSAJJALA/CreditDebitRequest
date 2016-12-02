package com.cdmr.controller;

import com.cdmr.ui.ValidateUser;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Login controller servlet. Authenticates user name and password.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-22
 */

@WebServlet(
        name = "login",
        urlPatterns = {"/login"}

)
public class Login extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Method for post
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException servlet exception
     * @throws IOException IO Exception
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    /**
     * Method for get
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException servlet exception
     * @throws IOException IO Exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("In doPost() method");
        response.setContentType("text/html");
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        logger.info("User:" + userName);
        ValidateUser login = new ValidateUser();
        String message = login.validate(userName, passWord);
        if (!message.equals("User authenticated")) {
            logger.error("Login failed for the user:" + userName);
            request.setAttribute("message", message);
            logger.info("login servlet context:" + request.getContextPath());
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);

        } else {
            logger.info("User authenticated. Forwarding to CDMR application");
            logger.info("login servlet context:" + request.getContextPath());
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        }
    }
}
