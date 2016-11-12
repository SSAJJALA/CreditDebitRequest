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
 * Created by Siva Sajjala on 9/24/16.
 */


@WebServlet(
        name = "searchServlet",
        urlPatterns = {"/cdmr/searchServlet"}

)
public class SearchServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("In doPost() method");
        response.setContentType("text/html");
        String buttonAction = "";

        if (request.getParameter("btn_search") != null) {
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
        } else if (request.getParameter("btn_exit") != null) {
            logger.info("directing to index page");
            request.removeAttribute("results");
            buttonAction = "Exit";
        }

        if (buttonAction.equals("Search")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
            dispatcher.forward(request, response);
        } else if (buttonAction.equals("Exit")){
            response.sendRedirect("/index.jsp");
        }


    }
}

