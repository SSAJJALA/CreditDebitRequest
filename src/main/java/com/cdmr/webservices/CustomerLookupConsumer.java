package com.cdmr.webservices;

import com.cdmr.util.LoadProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

/**
 * CustomerLookupConsumer is the web service client to call customer lookup rest web service. This gets the customer details and map it to Customer object.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-16
 */
public class CustomerLookupConsumer {
    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties;

    /**
     * Main method to invoke the REST API CustomerLookup
     * @param customerNo
     * @return Customer data object
     * @throws Exception
     */
    public Customer getCustomerApiJSON(int customerNo) throws Exception {
        properties = new Properties();
        Customer result = null;

        try {
            //this.loadProperties();
            LoadProperties loadProperties = new LoadProperties();
            properties = loadProperties.loadProperties();
        } catch (Exception e) {
            throw e;
        }

        try {
            properties.load (this.getClass().getResourceAsStream("/cdmr.properties"));
        } catch (IOException ioe) {
            System.out.println("cdmr.loadProperties()...Cannot load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("cdmr.loadProperties()..." + e);
            e.printStackTrace();
        }
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(properties.getProperty("customerLookupURL") + customerNo);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        if (!response.equals(null) && !response.equals("")) {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(response, Customer.class);
            log.info("customer number:" + result.getCustNum());
            log.info("customer name:" + result.getCustName());
        } else {
            log.info("customer not found: " + customerNo);
        }

        return result;
    }

    /**
    public void loadProperties() throws Exception {
        try {
            properties.load (this.getClass().getResourceAsStream("/cdmr.properties"));
        } catch (IOException ioe) {
            log.error("cdmr.loadProperties()...Cannot load the properties file");
            throw ioe;
        } catch (Exception e) {
            log.error("cdmr.loadProperties()..." + e);
            throw e;
        }
    }
     **/
}
