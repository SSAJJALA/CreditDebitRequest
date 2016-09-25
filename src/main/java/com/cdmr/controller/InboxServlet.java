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
 * Created by Siva Sajjala on 9/24/16.
 */

@WebServlet(
        name = "inboxServlet",
        urlPatterns = {"/inboxServlet"}

)
public class InboxServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("In doPost() method on inbox servlet");
        response.setContentType("text/html");
        String user = request.getParameter("userID");
        GetInbox inbox = new GetInbox(user);
        List<SearchInbox> inboxResults = inbox.getTasks();
        request.setAttribute("inbox", inboxResults);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/inbox.jsp");
        dispatcher.forward(request, response);

    }
}
