package com.cdmr.controller;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.CDMRAdjustments;
import com.cdmr.Data.UiAdjData;
import com.cdmr.entity.InvoiceDetail;
import com.cdmr.entity.InvoiceHeader;
import com.cdmr.ui.CalculateCDMR;
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

            invoiceLookup.setCustNum(cust1.getCustNum());
            header = invoiceLookup.getInvoiceHeader();
            details = invoiceLookup.getInvoiceDetails();

            session.setAttribute("invoiceResults", header);
            session.setAttribute("invoiceDetails", details);
            logger.info("invoice header:" + header.toString());
            logger.info("invoice details:" + details.toString());

        } else if (request.getParameter("btn_calculate") != null) {
            String[] adjItem = request.getParameterValues("adjItem");
            String[] adjQty = request.getParameterValues("adjQty");
            String[] reasonCode = request.getParameterValues("reasonCode");
            String[] creditdebit = request.getParameterValues("creditdebit");
            String[] comments = request.getParameterValues("comments");

            List<UiAdjData> adjs = new ArrayList<UiAdjData>();

            for (int i=0;i<adjItem.length;i++) {
                UiAdjData adj = new UiAdjData();
                adj.setAdjQty(Integer.parseInt(adjQty[i]));
                adj.setReasonCode(reasonCode[i]);
                adj.setComments(comments[i]);
                adj.setCreditDebit(creditdebit[i]);
                adj.setItemNum(Integer.parseInt(adjItem[i]));
                adjs.add(adj);
            }

            Customer customerDtls = (Customer) session.getAttribute("customerResults");
            InvoiceHeader header = (InvoiceHeader) session.getAttribute("invoiceResults");
            List<InvoiceDetail> details = (List<InvoiceDetail>) session.getAttribute("invoiceDetails");
            String user = request.getUserPrincipal().getName();

            CalculateCDMR calculate = new CalculateCDMR(customerDtls, header, details, adjs, user);
            CDMR cdmr = calculate.prepareCDMR();
            session.setAttribute("cdmr", cdmr);



        } else if (request.getParameter("btn_submit") != null) {

        } else if (request.getParameter("btn_cancel") != null) {

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/createCdmr.jsp");
        dispatcher.forward(request, response);
    }
}
