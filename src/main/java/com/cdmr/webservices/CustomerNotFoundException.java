package com.cdmr.webservices;

import com.cdmr.util.LoadProperties;
import org.apache.log4j.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Properties;

/**
 * Customer Lookup web service exceptions
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-03
 */
public class CustomerNotFoundException extends WebApplicationException {
    private Properties properties;
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public Response getResponse() {
        try {
            LoadProperties loadProperties = new LoadProperties();
            properties = loadProperties.loadProperties();
        } catch (Exception e) {
            logger.info("Unable to load CDMR properties");
        }
        //HTTP response code 404
        return Response.status(Response.Status.NOT_FOUND).entity(properties.getProperty("customerLookupError_02")).build();
    }
}
