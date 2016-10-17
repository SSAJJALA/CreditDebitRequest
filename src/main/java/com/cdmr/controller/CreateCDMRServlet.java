package com.cdmr.controller;

import com.cdmr.entity.InvoiceDetail;
import com.cdmr.entity.InvoiceHeader;
import com.cdmr.webservices.Customer;
import com.cdmr.webservices.CustomerLookupConsumer;
import com.cdmr.webservices.InvoiceLookup;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siva Sajjala on 10/17/16.
 */

@WebServlet(
        name = "createCDMRServlet",
        urlPatterns = {"/createCDMRServlet"}

)
public class CreateCDMRServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("btn_retCust") != null) {

            Customer customer = null;
            CustomerLookupConsumer customerWebService = new CustomerLookupConsumer();
            try {
                customer = customerWebService.getCustomerApiJSON(Integer.getInteger(request.getParameter("customer")));
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("customerResults", customer);

        } else if (request.getParameter("btn_retInv") != null) {

            InvoiceLookup invoiceLookup = new InvoiceLookup();
            InvoiceHeader header = null;
            List<InvoiceDetail> details = new ArrayList<InvoiceDetail>();

            invoiceLookup.setInvNum(Integer.getInteger(request.getParameter("Invoice")));
            invoiceLookup.setCustNum(Integer.getInteger(request.getParameter("customer")));
            header = invoiceLookup.getInvoiceHeader();
            details = invoiceLookup.getInvoiceDetails();

            request.setAttribute("invoiceResults", header);
            request.setAttribute("search", details);

        } else if (request.getParameter("btn_calculate") != null) {

        } else if (request.getParameter("btn_submit") != null) {

        } else if (request.getParameter("btn_cancel") != null) {

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/createCdmr.jsp");
        dispatcher.forward(request, response);
    }
}
