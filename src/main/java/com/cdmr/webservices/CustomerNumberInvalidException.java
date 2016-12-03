package com.cdmr.webservices;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Customer Lookup web service exceptions
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-03
 */
public class CustomerNumberInvalidException extends WebApplicationException{

    @Override
    public Response getResponse() {
        return Response.status(Response.Status.BAD_REQUEST).entity("Customer number invalid").build();
    }
}
