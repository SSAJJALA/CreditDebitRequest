package com.cdmr.persistence;

import com.cdmr.entity.Customer;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Siva Sajjala on 9/18/16.
 */
public class CustomerDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all custs
     *
     * @return All customers
     */
    public List<Customer> getAllCustomers() {
        List<Customer> custs = new ArrayList<Customer>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        custs = session.createCriteria(Customer.class).list();
        return custs;
    }

    /**
     * retrieve a customer given an cust id
     * @param custID the customer id
     * @return cust
     */
    public Customer getCustomer(int custID) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Customer  cust = (Customer) session.get(Customer.class, custID);
        return cust;

    }

    /**
     * add a customer
     *
     * @param cust
     * @return the custID of the customer added
     */
    public int addCustomer(Customer cust) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(cust);
        tx.commit();
        session.close();
        int custID = cust.getCustNum();
        return custID;
    }

    /**
     * delete a customer by custID
     * @param custID the cust id
     */
    public void deleteCustomer(int custID) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Customer cust = (Customer) session.load(Customer.class,custID);
        log.info("Customer" + cust.toString());
        session.delete(cust);
        tx.commit();
        log.info("Customer" + custID + "deleted.");


    }

    /**
     * Update the customer
     * @param cust
     */

    public void updateReq(Customer cust) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(cust);
        tx.commit();

    }

    /**
     * get the max cust number
     * @return cust number
     */
    public int getMaxCustID() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Customer.class);
        c.addOrder(Order.desc("custNum"));
        c.setMaxResults(1);
        Customer cust = (Customer)c.uniqueResult();
        return cust.getCustNum();

    }


}
