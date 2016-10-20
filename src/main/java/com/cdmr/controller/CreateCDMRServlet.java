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
import javax.servlet.http.HttpSession;
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
        logger.info("inside create cdmr servlet @ post");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("inside create cdmr servlet @ get");
        logger.info("btn_retCust:" + request.getParameter("btn_retCust"));
        logger.info("btn_retInv:" + request.getParameter("btn_retInv"));
        logger.info("btn_calculate:" + request.getParameter("btn_calculate"));
        logger.info("btn_submit:" + request.getParameter("btn_submit"));
        logger.info("btn_cancel:" + request.getParameter("btn_cancel"));

        HttpSession session = request.getSession();
        if (request.getParameter("btn_retCust") != null) {
            logger.info("gettting customer details.");

            Customer customerDtls = null;
            CustomerLookupConsumer customerWebService = new CustomerLookupConsumer();
            try {
                customerDtls = customerWebService.getCustomerApiJSON(Integer.parseInt(request.getParameter("customer")));
            } catch (Exception e) {
                e.printStackTrace();
            }

            //request.setAttribute("customerResults", customerDtls);
            session.setAttribute("customerResults", customerDtls);
            logger.info("customr number:" + customerDtls.getCustNum());

        } else if (request.getParameter("btn_retInv") != null) {
            logger.info("gettting invoice details.");

            InvoiceLookup invoiceLookup = new InvoiceLookup();
            InvoiceHeader header = null;
            List<InvoiceDetail> details = new ArrayList<InvoiceDetail>();

            invoiceLookup.setInvNum(Integer.parseInt(request.getParameter("Invoice")));

            Customer cust1 = (Customer) session.getAttribute("customerResults");
            logger.info("customer details inside cdmr create servlet:" + cust1.getCustNum());
            //invoiceLookup.setCustNum(Integer.parseInt(request.getParameter("customer")));
            invoiceLookup.setCustNum(cust1.getCustNum());
            header = invoiceLookup.getInvoiceHeader();
            details = invoiceLookup.getInvoiceDetails();

            //request.setAttribute("invoiceResults", header);
            //request.setAttribute("invoiceDetails", details);
            session.setAttribute("invoiceResults", header);
            session.setAttribute("invoiceDetails", details);
            logger.info("invoice header:" + header.toString());
            logger.info("invoice details:" + details.toString());

        } else if (request.getParameter("btn_calculate") != null) {

        } else if (request.getParameter("btn_submit") != null) {

        } else if (request.getParameter("btn_cancel") != null) {

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/createCdmr.jsp");
        dispatcher.forward(request, response);
    }
}
