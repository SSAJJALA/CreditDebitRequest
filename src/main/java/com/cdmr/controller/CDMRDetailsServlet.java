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
 * CDMRDetailsServlet controller servlet for cdmrDetails.jsp page. Take care of approvals and rejections from UI
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-29
 */
@WebServlet(
        name = "cdmrDetailsServlet",
        urlPatterns = {"/cdmrDetailsServlet"}

)
public class CDMRDetailsServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Constants for action buttons
     */
    public static final String buttonApprove = "btn_approve";
    public static final String buttonReject = "btn_reject";
    public static final String buttonMessage = "btn_message";
    public static final String buttonExit = "btn_exit";

    /**
     * Method for post
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException servlet exception
     * @throws IOException IO Exception
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("inside create cdmr details servlet @ post");
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
        logger.info("inside create cdmr details servlet @ get");

        String buttonAction = "";
        HttpSession session = request.getSession();


        if (request.getParameter(buttonApprove) != null) {
            logger.info("Approving the cdmr request");
            buttonAction = "Approved";
            String message = this.completeTaskAction(request, response, buttonAction, session);
            session.setAttribute("message", message);

        } else if (request.getParameter(buttonReject) != null) {
            logger.info("Rejecting the cdmr request");
            buttonAction = "Rejected";
            String message = this.completeTaskAction(request, response, buttonAction, session);
            session.setAttribute("message", message);

        } else if (request.getParameter(buttonExit) != null) {
            logger.info("Exiting cdmr request");
            this.removeAttributes(session);
            buttonAction = "Exit";
        } else if (request.getParameter(buttonMessage) != null) {
            logger.info("directing to index page");
            this.removeAttributes(session);
            buttonAction = "Message";
        }

        if (buttonAction.equals("Approved") || buttonAction.equals("Rejected")) {
            logger.info("Details servlet context:" + request.getContextPath());
            RequestDispatcher dispatcher = request.getRequestDispatcher( "cdmrDetails.jsp");
            dispatcher.forward(request, response);
        } else if (buttonAction.equals("Exit") || buttonAction.equals("Message")){
            logger.info("Details servlet context:" + request.getContextPath());
            response.sendRedirect("index.jsp");
        }

    }

    public String completeTaskAction(HttpServletRequest request, HttpServletResponse response, String buttonAction, HttpSession session) {
        logger.info("inside completeTaskAction from cdmr details servlet");
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

    public void removeAttributes(HttpSession session) {
        session.removeAttribute("cdmr");
        session.removeAttribute("taskDetails");
        session.removeAttribute("message");
    }
}
