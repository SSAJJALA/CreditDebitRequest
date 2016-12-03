package com.cdmr.controller;

import com.cdmr.Data.CDMR;
import com.cdmr.entity.Task;
import com.cdmr.ui.GetCDMRDetails;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * DirectToDetails controller servlet fto direct to to cdmr details page
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-20
 */
@WebServlet(name = "directToDetails",
        urlPatterns = {"/directToDetails"}
)
public class DirectToDetails extends HttpServlet {
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
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String userID = request.getUserPrincipal().getName();
        String taskIDString = request.getParameter("taskID");
        String reqIDString = request.getParameter("reqID");
        int taskID = 0;
        int ReqID = 0;
        if (taskIDString != null) {
            taskID = Integer.parseInt(request.getParameter("taskID"));
        } else if (reqIDString != null) {
            ReqID = Integer.parseInt(request.getParameter("reqID"));
        }

        GetCDMRDetails details = new GetCDMRDetails(ReqID, taskID, userID);
        if (taskID != 0) {
            CDMR cdmr = details.getCDMR();
            Task task = details.getTaskDetails();
            session.setAttribute("cdmr", cdmr);
            session.setAttribute("taskDetails", task);
        } else if (ReqID != 0) {
            CDMR cdmr = details.getCDMR();
            session.setAttribute("cdmr", cdmr);
        }
        logger.info("direct to details servlet context:" + request.getContextPath());
        RequestDispatcher dispatcher = request.getRequestDispatcher("cdmrDetails.jsp");
        dispatcher.forward(request, response);
    }
}
