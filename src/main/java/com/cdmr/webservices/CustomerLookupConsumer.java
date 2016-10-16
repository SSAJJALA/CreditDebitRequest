package com.cdmr.webservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Created by student on 10/16/16.
 */
public class CustomerLookupConsumer {
    private final Logger log = Logger.getLogger(this.getClass());


    public Customer getCustomerApiJSON(int customerNo) throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://localhost:8080/rest/customer/" + customerNo);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Customer result = mapper.readValue(response, Customer.class);
        log.info("customer number:" + result.getCustNum());
        log.info("customer name:" + result.getCustName());
        return result;
    }
}
