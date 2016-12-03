package com.cdmr.controller;

import com.cdmr.entity.SearchCDMR;
import com.cdmr.entity.SearchInbox;
import com.cdmr.ui.GetInbox;
import com.cdmr.ui.Search;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * InboxServlet controller servlet for inbox.jsp page. Gets the cdmr details for a task (on click) and directs to details page.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-24
 */

@WebServlet(
        name = "inboxServlet",
        urlPatterns = {"/inboxServlet"}

)
public class InboxServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Constants for action buttons
     */
    public static final String buttonExit = "btn_exit";

    /**
     * Method for post
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException servlet exception
     * @throws IOException IO Exception
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    /**
     * Method for get
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException servlet exception
     * @throws IOException IO Exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("In doPost() method on inbox servlet");
        response.setContentType("text/html");
        String buttonAction = "";

        if (request.getParameter(buttonExit) != null) {
            logger.info("directing to index page");
            request.removeAttribute("inbox");
            buttonAction = "Exit";

        } else {
            String user = request.getUserPrincipal().getName();
            logger.info("User id:" + user);
            GetInbox inbox = new GetInbox(user.toUpperCase());
            List<SearchInbox> inboxResults = inbox.getTasks();
            request.setAttribute("inbox", inboxResults);
        }

        if (buttonAction.equals("Exit")) {
            logger.info("inbox servlet context:" + request.getContextPath());
            response.sendRedirect("index.jsp");
        } else {
            logger.info("inbox servlet context:" + request.getContextPath());
            RequestDispatcher dispatcher = request.getRequestDispatcher("inbox.jsp");
            dispatcher.forward(request, response);
        }


    }
}
