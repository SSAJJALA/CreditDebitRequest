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
 * Created by student on 10/29/16.
 */
@WebServlet(name = "directToDetails",
        urlPatterns = {"/directToDetails"}
)
public class DirectToDetails extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        int taskID = 0;
        int ReqID = 0;
        if (!request.getParameter("taskID").isEmpty()) {
            taskID = Integer.parseInt(request.getParameter("taskID"));
        } else if (!request.getParameter("reqID").isEmpty()) {
            ReqID = Integer.parseInt(request.getParameter("reqID"));
        }

        GetCDMRDetails details = new GetCDMRDetails(ReqID, taskID);
        if (taskID != 0) {
            CDMR cdmr = details.getCDMR();
            Task tak = details.getTaskDetails(taskID);
            request.setAttribute("cdmr", "cdmr");
            request.setAttribute("taskDetails", "task");
        } else if (ReqID != 0) {
            CDMR cdmr = details.getCDMR();
            request.setAttribute("cdmr", "cdmr");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cdmrDetails.jsp");
        dispatcher.forward(request, response);
    }
}
