package com.cdmr.controller;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.TaskResponse;
import com.cdmr.entity.Task;
import com.cdmr.ui.CompleteTask;
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
@WebServlet(
        name = "cdmrDetailsServlet",
        urlPatterns = {"/cdmrDetailsServlet"}

)
public class CDMRDetailsServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("inside create cdmr details servlet @ post");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("inside create cdmr details servlet @ get");

        String buttonAction = "";
        HttpSession session = request.getSession();


        if (request.getParameter("btn_approve") != null) {
            logger.info("Approving the cdmr request");
            buttonAction = "Approved";
            String message = this.completeTaskAction(request, response, buttonAction, session);
            //request.setAttribute("message", message);
            session.setAttribute("message", message);

        } else if (request.getParameter("btn_reject") != null) {
            logger.info("Rejecting the cdmr request");
            buttonAction = "Rejected";
            String message = this.completeTaskAction(request, response, buttonAction, session);
            //request.setAttribute("message", message);
            session.setAttribute("message", message);

        } else if (request.getParameter("btn_exit") != null) {
            logger.info("Exiting cdmr request");
            session.removeAttribute("cdmr");
            session.removeAttribute("taskDetails");
            session.removeAttribute("message");
            buttonAction = "Exit";
        } else if (request.getParameter("btn_message") != null) {
            logger.info("directing to index page");
            session.removeAttribute("cdmr");
            session.removeAttribute("taskDetails");
            session.removeAttribute("message");
            buttonAction = "Message";
        }

        if (buttonAction.equals("Approved") || buttonAction.equals("Rejected")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/cdmrDetails.jsp");
            dispatcher.forward(request, response);
        } else if (buttonAction.equals("Exit") || buttonAction.equals("Message")){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

    }

    public String completeTaskAction(HttpServletRequest request, HttpServletResponse response, String buttonAction, HttpSession session) {
        logger.info("inside completeTaskAction from cdmr details servlet");
        //CDMR cdmr = (CDMR)request.getAttribute("cdmr");
        //Task task = (Task) request.getAttribute("taskDetails");
        CDMR cdmr = (CDMR)session.getAttribute("cdmr");
        Task task = (Task) session.getAttribute("taskDetails");
        logger.info("Task object from cdmr details servlet:" + task.toString());
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setApprovalDecesion(buttonAction);
        taskResponse.setApproverID(request.getUserPrincipal().getName());
        logger.info("task id from cdmr details servlet:" + task.getTaskID());
        taskResponse.setTaskID(task.getTaskID());
        taskResponse.setTaskName(task.getTaskName());
        CompleteTask completeTask = new CompleteTask(taskResponse, cdmr);
        String message = completeTask.completeTaskAndRouteCDMR();
        return message;
    }
}
