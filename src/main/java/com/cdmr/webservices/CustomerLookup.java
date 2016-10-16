package com.cdmr.webservices;

import com.cdmr.entity.Customer;
import com.cdmr.persistence.CustomerDao;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Siva Sajjala on 9/18/16.
 */
@Path("/customer")
public class CustomerLookup {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Method to get the customer details
     * @param custNum
     * @return Customer the customer object
     */

    @GET
    @Path("{param1}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({"text/plain,text/html"})
    public Response getCustomer(@PathParam("param1") int custNum) {
        int custNo = custNum;
        Customer cust;
        CustomerDao custDao = new CustomerDao();
        cust = custDao.getCustomer(custNo);
        //return cust;
        return Response.status(200).entity(cust).build();
    }

}
