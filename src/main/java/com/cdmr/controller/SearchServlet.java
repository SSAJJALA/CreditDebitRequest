package com.cdmr.controller;

import com.cdmr.entity.SearchCDMR;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.cdmr.ui.Search;

/**
 * SearchServlet is the controller servlet for search.jsp. Gets the cdmr details for a requisition id (on click) and directs to details page.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-24
 */


@WebServlet(
        name = "searchServlet",
        urlPatterns = {"/searchServlet"}

)
public class SearchServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Constants for action buttons
     */
    public static final String buttonApprove = "btn_search";
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
        logger.info("In doPost() method");
        response.setContentType("text/html");
        String buttonAction = "";

        if (request.getParameter(buttonApprove) != null) {
            Search searchObj = null;
            String searchFilter = request.getParameter("searchoptions");
            logger.info("searchFilter: " + searchFilter);
            String operand = request.getParameter("operands");
            logger.info("operand: " + operand);
            String term = request.getParameter("searchTerm");
            logger.info("term: " + term);
            searchObj = new Search(searchFilter, operand, term);
            List<SearchCDMR> results = searchObj.search();
            request.setAttribute("results", results);
            buttonAction = "Search";
        } else if (request.getParameter(buttonExit) != null) {
            logger.info("directing to index page");
            request.removeAttribute("results");
            buttonAction = "Exit";
        }

        if (buttonAction.equals("Search")) {
            logger.info("search servlet context:" + request.getContextPath());
            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
        } else if (buttonAction.equals("Exit")){
            logger.info("search servlet context:" + request.getContextPath());
            response.sendRedirect("index.jsp");
        }


    }
}

