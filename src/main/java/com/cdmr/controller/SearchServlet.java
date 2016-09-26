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
        urlPatterns = {"/searchServlet"}

)
public class SearchServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("In doPost() method");
        response.setContentType("text/html");
        String searchFilter = request.getParameter("searchoptions");
        String operand = request.getParameter("operands");
        String term = request.getParameter("searchTerm");
        Search searchObj = new Search(searchFilter, operand, term);
        List<SearchCDMR> results = searchObj.search();
        request.setAttribute("results", results);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request, response);

    }
}
