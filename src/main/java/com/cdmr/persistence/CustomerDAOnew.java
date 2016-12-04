package com.cdmr.persistence;

import com.cdmr.entity.Customer;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * This is concrete implementation for Customer table DAO. Fetches from the DB table CUSTOMER.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-04
 */
public class CustomerDAOnew extends GenericDAO{
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * get session
     * @return session
     */
    @Override
    protected Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * get all customers
     * @return List of customers
     * @throws HibernateException
     */
    @Override
    public List<?> getAll() {
        List<Customer> custs = new ArrayList<Customer>();
        Session session = getSession();
        custs = (List<Customer>) session.createCriteria(Customer.class).list();
        session.close();
        return custs;
    }

    /**
     * Retrieve a customer given an cust id
     * @param custID the customer id
     * @return cust
     */
    @Override
    public Object getOne(int custID) throws HibernateException  {
        Session session = getSession();
        Customer  cust = (Customer) session.get(Customer.class, custID);
        session.close();
        return cust;

    }

    /**
     * add a customer
     *
     * @param obj customer object
     * @return the custID of the customer added
     */
    @Override
    public int add(Object obj) throws HibernateException {

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Customer cust = (Customer) obj;
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
    @Override
    public void delete(int custID) throws HibernateException {

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Customer cust = (Customer) session.load(Customer.class,custID);
        log.info("Customer" + cust.toString());
        session.delete(cust);
        tx.commit();
        session.close();
        log.info("Customer" + custID + "deleted.");


    }

    /**
     * Update the customer
     * @param obj
     */

    @Override
    public void update(Object obj) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Customer cust = (Customer) obj;
        session.update(cust);
        tx.commit();
        session.close();

    }

    /**
     * get the max cust number
     * @return cust number
     */
    @Override
    public int getMaxID() {
        Session session = getSession();
        Criteria c = session.createCriteria(Customer.class);
        c.addOrder(Order.desc("custNum"));
        c.setMaxResults(1);
        Customer cust = (Customer)c.uniqueResult();
        session.close();
        return cust.getCustNum();

    }

}
