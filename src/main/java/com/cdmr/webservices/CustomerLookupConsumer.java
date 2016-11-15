package com.cdmr.webservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by student on 10/16/16.
 */
public class CustomerLookupConsumer {
    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties;


    public Customer getCustomerApiJSON(int customerNo) throws Exception {
        properties = new Properties();

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

        ObjectMapper mapper = new ObjectMapper();
        Customer result = mapper.readValue(response, Customer.class);
        log.info("customer number:" + result.getCustNum());
        log.info("customer name:" + result.getCustName());
        return result;
    }
}
