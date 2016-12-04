package com.cdmr.persistence;

import com.cdmr.entity.Customer;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 12/4/16.
 */
public class CustomerDAOnewTest {
    CustomerDAOnew customerDAOnew = null;
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setUp() throws Exception {
        customerDAOnew = new CustomerDAOnew();
    }

    @Test
    public void getAll() throws Exception {
        List<Customer> custs = (List<Customer>) customerDAOnew.getAll();
        assertNotNull("Unable to get customer list", custs);
    }

    @Test
    public void getOne() throws Exception {
        Customer  cust = (Customer) customerDAOnew.getOne(1000);
        assertNotNull("Unable to get customer", cust);
    }

    @Test
    public void add() throws Exception {
        Customer cust = new Customer();
        int custID = customerDAOnew.getMaxID();
        custID ++;
        cust.setCustNum(custID);
        cust.setCustName("Good Karma Brands");
        cust.setAdd1("100");
        cust.setAdd2("Stoddart Street");
        cust.setCity("Beaver Dam");
        cust.setState("WI");
        cust.setZip("53916");
        cust.setPhone("920-885-4442");
        int custIDnew = customerDAOnew.add(cust);
        assertEquals("Unable to add customer", custIDnew, custID);

    }

    @Test
    public void delete() throws Exception {
        customerDAOnew.delete(1030);
        Customer  cust = (Customer) customerDAOnew.getOne(1030);
        assertNull("Unable to remove customer 1030", cust);

    }

    @Test
    public void update() throws Exception {
        Customer  cust = (Customer) customerDAOnew.getOne(1029);
        customerDAOnew.update(cust);
        cust = (Customer) customerDAOnew.getOne(1029);
        assertNotNull("Unable to update customer", cust);
    }

    @Test
    public void getMaxID() throws Exception {
        int custID = customerDAOnew.getMaxID();
        assertNotNull("Unable to get max cust id", custID);
    }

}