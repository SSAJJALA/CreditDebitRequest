package com.cdmr.controller;

import com.cdmr.Data.CDMR;
import com.cdmr.Data.CDMRAdjustments;
import com.cdmr.Data.UiAdjData;
import com.cdmr.entity.InvoiceDetail;
import com.cdmr.entity.InvoiceHeader;
import com.cdmr.ui.CalculateCDMR;
import com.cdmr.ui.SubmitCDMR;
import com.cdmr.util.LoadProperties;
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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * CreateCDMRServlet controller servlet for createCdmr.jsp page. Takes care of customer lookup, invoice lookup, submit and calculate action buttons from UI.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-17
 */

@WebServlet(
        name = "createCDMRServlet",
        urlPatterns = {"/createCDMRServlet"}

)
public class CreateCDMRServlet extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());
    private Properties properties;

    /**
     * Constants for action buttons
     */
    public static final String buttonCustomer = "btn_retCust";
    public static final String buttonInvoice = "btn_retInv";
    public static final String buttonCalculate = "btn_calculate";
    public static final String buttonSubmit = "btn_submit";
    public static final String buttonCancel = "btn_cancel";
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
        logger.info("inside create cdmr servlet @ post");
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
        logger.info("inside create cdmr servlet @ get");
        /**
        logger.info(buttonCustomer + request.getParameter(buttonCustomer));
        logger.info(buttonInvoice + request.getParameter(buttonInvoice));
        logger.info(buttonCalculate + request.getParameter(buttonCalculate));
        logger.info(buttonSubmit + request.getParameter(buttonSubmit));
        logger.info(buttonCancel + request.getParameter(buttonCancel));
        logger.info(buttonMessage + request.getParameter(buttonMessage));
        logger.info(buttonExit + request.getParameter(buttonExit));
        **/

        String buttonAction = "";
        String gotException = "";

        HttpSession session = request.getSession();

        try {
            //this.loadProperties();
            LoadProperties loadProperties = new LoadProperties();
            properties = loadProperties.loadProperties();
        } catch (Exception e) {
            session.setAttribute("message", "Unable to load CDMR properties");
        }

        if (request.getParameter(buttonCustomer) != null) {
            logger.info("gettting customer details.");

            Customer customerDtls = null;
            CustomerLookupConsumer customerWebService = new CustomerLookupConsumer();
            try {
                customerDtls = customerWebService.getCustomerApiJSON(Integer.parseInt(request.getParameter("customer")));
            } catch (Exception e) {
                logger.error("Customer lookup failed:" +e.getMessage());
                session.setAttribute("message", e.getMessage());

            }
            /**
            try {
                customerDtls = customerWebService.getCustomerApiJSON(Integer.parseInt(request.getParameter("customer")));
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exception = sw.toString();
                logger.error(exception);
                gotException = "true";
            }


            if (gotException.equals("true")) {
                session.setAttribute("message", properties.getProperty("customerWebservice_01"));
            } else if (customerDtls == null){
                session.setAttribute("message", properties.getProperty("customer_02"));
            } else {
                session.setAttribute("customerResults", customerDtls);
                logger.info("customr number:" + customerDtls.getCustNum());
            }
             **/

            buttonAction = "customer";


        } else if (request.getParameter(buttonInvoice) != null) {
            logger.info("gettting invoice details.");

            InvoiceLookup invoiceLookup = new InvoiceLookup();
            InvoiceHeader header = null;
            List<InvoiceDetail> details = new ArrayList<InvoiceDetail>();

            invoiceLookup.setInvNum(Integer.parseInt(request.getParameter("Invoice")));

            Customer cust1 = (Customer) session.getAttribute("customerResults");
            logger.info("customer details inside cdmr create servlet:" + cust1.getCustNum());

            invoiceLookup.setCustNum(cust1.getCustNum());
            header = invoiceLookup.getInvoiceHeader();
            if (header == null) {
                session.setAttribute("message", properties.getProperty("invoice_01"));
            } else {
                details = invoiceLookup.getInvoiceDetails();
                if (details == null) {
                    session.setAttribute("message", properties.getProperty("invoice_02"));
                } else {
                    session.setAttribute("invoiceResults", header);
                    session.setAttribute("invoiceDetails", details);
                    logger.info("invoice header:" + header.toString());
                    logger.info("invoice details:" + details.toString());
                }

            }

            buttonAction = "invoice";

        } else if (request.getParameter(buttonCalculate) != null) {
            String[] adjItem = request.getParameterValues("adjItem");
            String[] adjQty = request.getParameterValues("adjQty");
            String[] reasonCode = request.getParameterValues("reasonCode");
            String[] creditdebit = request.getParameterValues("creditDebit");
            String[] comments = request.getParameterValues("comments");

            logger.info("List of adjustment items: " + adjItem);
            logger.info("List of adjustment qtys: " + adjQty);
            logger.info("List of adjustment reason codes: " + reasonCode);
            logger.info("List of adjustment credit/debit: " + creditdebit);
            logger.info("List of adjustment items: " + comments);

            List<UiAdjData> adjs = new ArrayList<UiAdjData>();
            String validation = "true";


            for (int i=0;i<adjItem.length;i++) {
                UiAdjData adj = new UiAdjData();

                logger.info("Adj Qty:" + adjQty[i]);

                if(adjQty[i] != null && !adjQty[i].isEmpty()) {
                    logger.info("After validation Adj Qty:" + adjQty[i]);
                    adj.setAdjQty(Integer.parseInt(adjQty[i]));
                } else {
                    session.setAttribute("message", properties.getProperty("validation_01"));
                    validation = "false";
                }

                logger.info("Reason Code:" + reasonCode[i]);
                if(reasonCode[i] != null || !reasonCode[i].isEmpty()) {
                    logger.info("After validation Reason Code:" + reasonCode[i]);
                    adj.setReasonCode(reasonCode[i]);
                } else {
                    session.setAttribute("message", properties.getProperty("validation_01"));
                    validation = "false";
                }

                logger.info("Comments:" + comments[i]);
                adj.setComments(comments[i]);

                logger.info("Credit/Debit:" + creditdebit[i]);
                if(creditdebit[i] != null || !creditdebit[i].isEmpty()) {
                    logger.info("After validation Credit/Debit:" + creditdebit[i]);
                    adj.setCreditDebit(creditdebit[i]);

                } else {
                    session.setAttribute("message", properties.getProperty("validation_01"));
                    validation = "false";
                }

                logger.info("Adj Item:" + adjItem[i]);
                adj.setItemNum(Integer.parseInt(adjItem[i]));
                adjs.add(adj);
            }

            if (validation.equals("true")) {
                Customer customerDtls = (Customer) session.getAttribute("customerResults");
                InvoiceHeader header = (InvoiceHeader) session.getAttribute("invoiceResults");
                List<InvoiceDetail> details = (List<InvoiceDetail>) session.getAttribute("invoiceDetails");
                String user = request.getUserPrincipal().getName();
                CalculateCDMR calculate = new CalculateCDMR(customerDtls, header, details, adjs, user);
                CDMR cdmr = calculate.prepareCDMR();
                logger.info("cdmr gross:" + cdmr.getAdjGross());
                logger.info("cdmr allowance:" + cdmr.getAdjAllowance());
                logger.info("cdmr charges:" + cdmr.getAdjCharges());
                logger.info("cdmr taxes:" + cdmr.getAdjTax());
                logger.info("cdmr net:" + cdmr.getAdjAmnt());

                session.setAttribute("cdmr", cdmr);
            }

            buttonAction = "calculate";

        } else if (request.getParameter(buttonSubmit) != null) {

            CDMR cdmr = (CDMR) session.getAttribute("cdmr");
            SubmitCDMR submit = new SubmitCDMR(cdmr);
            String message = submit.saveCDMR();
            session.setAttribute("message", message);
            buttonAction = "submit";

        } else if (request.getParameter(buttonCancel) != null) {
            this.removeAttributes(session);
            buttonAction = "cancel";
        } else if (request.getParameter("logout") != null) {
            request.getSession().invalidate();
            buttonAction = "logout";

        } else if (request.getParameter(buttonMessage) != null) {

            String message = (String) session.getAttribute("message");
            if (message.equals(properties.getProperty("customer_02")) || message.equals(properties.getProperty("invoice_01")) || message.equals(properties.getProperty("invoice_02")) || message.equals(properties.getProperty("validation_01"))) {
                session.removeAttribute("message");
                buttonAction = "Alert";
            } else {
                logger.info("directing to index page");
                this.removeAttributes(session);
                buttonAction = "Message";
            }


        } else if (request.getParameter(buttonExit) != null) {
            logger.info("Exiting the cdmr create page");
            this.removeAttributes(session);
            buttonAction = "Exit";
        }


        if (buttonAction.equals("customer") || buttonAction.equals("invoice") || buttonAction.equals("calculate") || buttonAction.equals("submit")) {
            logger.info("create servlet context:" + request.getContextPath());
            RequestDispatcher dispatcher = request.getRequestDispatcher("createCdmr.jsp");
            dispatcher.forward(request, response);
        } else if (buttonAction.equals("cancel") || buttonAction.equals("Alert")){
            logger.info("create servlet context:" + request.getContextPath());
            RequestDispatcher dispatcher = request.getRequestDispatcher("createCdmr.jsp");
            dispatcher.forward(request, response);
        } else if (buttonAction.equals("logout")) {
            logger.info("create servlet context:" + request.getContextPath());
            response.sendRedirect("login.jsp");
        } else if (buttonAction.equals("Exit") || buttonAction.equals("Message")) {
            logger.info("create servlet context:" + request.getContextPath());
            response.sendRedirect("index.jsp");
        }
    }

    public void removeAttributes(HttpSession session) {
        session.removeAttribute("cdmr");
        session.removeAttribute("customerResults");
        session.removeAttribute("invoiceResults");
        session.removeAttribute("invoiceDetails");
        session.removeAttribute("message");
    }

    /**
    public void loadProperties() throws Exception {
        try {
            properties.load (this.getClass().getResourceAsStream("/cdmr.properties"));
        } catch (IOException ioe) {
            logger.error("cdmr.loadProperties()...Cannot load the properties file");
            throw ioe;
        } catch (Exception e) {
            logger.error("cdmr.loadProperties()..." + e);
            throw e;
        }
    }
     **/

}
