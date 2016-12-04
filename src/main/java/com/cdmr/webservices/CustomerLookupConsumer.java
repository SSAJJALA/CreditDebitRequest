package com.cdmr.webservices;

import com.cdmr.util.LoadProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
/**
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
 **/
import java.io.IOException;
import java.util.Properties;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

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
        Customer customer = null;
        final Client client = Client.create();
        WebResource webResource = null;
        ClientResponse response = null;

        try {
            //this.loadProperties();
            LoadProperties loadProperties = new LoadProperties();
            properties = loadProperties.loadProperties();

            webResource = client.resource(properties.getProperty("customerLookupURL") + customerNo);
            response = webResource.accept("application/json").get(ClientResponse.class);

            if(response.getStatus() == 400) {
                throw new RuntimeException(properties.getProperty("customerLookupError_01") +":"+ response.getStatus());

            }
            if(response.getStatus() == 404) {
                throw new RuntimeException(properties.getProperty("customerLookupError_02") +":"+ response.getStatus());

            }
            if(response.getStatus() == 500) {
                throw new RuntimeException(properties.getProperty("customerLookupError_03") +":"+ response.getStatus());

            }

            if(response.getStatus() == 200) {
                String customerString = response.getEntity(String.class);
                log.info("JSON output:" + customerString);
                ObjectMapper mapper = new ObjectMapper();
                customer = mapper.readValue(customerString, Customer.class);
            }


        } catch (Exception e) {

            log.error(properties.getProperty("customerLookupError_04") + ":" + e.getMessage());
            throw new RuntimeException(properties.getProperty("customerLookupError_04"));

        } finally {
            if (response != null) {
                response.close();
            }
            if (client != null) {
                client.destroy();
            }

        }

        return customer;



        /**
        try {
            properties.load (this.getClass().getResourceAsStream("/cdmr.properties"));
        } catch (IOException ioe) {
            System.out.println("cdmr.loadProperties()...Cannot load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("cdmr.loadProperties()..." + e);
            e.printStackTrace();
        }
         **/
        /**
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
         **/




    }

}
