package com.cdmr.persistence;

import com.cdmr.entity.Filter;
import com.cdmr.entity.Task;
import com.cdmr.util.AddRestrictions;
import com.cdmr.util.ConvertToLocalDate;
import com.cdmr.util.GetUpdatedCriteria;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This is concrete implementation for abstract class GenericDAO. This class take care of all CRUD operations for the the DB table TASK
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-04
 */
public class TaskDAOnew extends GenericDAO{
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
     * Return a list of all tasks
     * @return All tasks
     */
    @Override
    public List<?> getAll() throws HibernateException {
        List<Task> tasks = new ArrayList<Task>();
        Session session = getSession();
        tasks = (List<Task>) session.createCriteria(Task.class).list();
        session.close();
        return tasks;
    }

    /**
     * retrieve a task given an task id
     *
     * @param t the task id
     * @return task
     */
    @Override
    public Object getOne(int t) throws HibernateException {
        Session session = getSession();
        Task  task = (Task) session.get(Task.class, t);
        session.close();
        return task;

    }

    /**
     * add a task
     *
     * @param obj Task object
     * @return the taskID of the inserted task
     */
    @Override
    public int add(Object obj) throws HibernateException {

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Task task = (Task) obj;
        int taskID = -1;
        try {
            Serializable ser = session.save(task);
            if (ser != null) {
                taskID = (Integer) ser;
            }
            tx.commit();
        } catch (Exception e) {
            throw e;
        }

        session.close();
        return taskID;
    }

    /**
     * delete a task by taskID
     * @param t the Task ID
     */
    @Override
    public void delete(int t) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Task task = (Task) session.load(Task.class,t);
        log.info("Task:" + task.toString());
        session.delete(task);
        tx.commit();
        session.close();
        log.info("Task" + t + "deleted.");
    }

    /**
     * Update the task
     * @param obj Task
     */
    @Override
    public void update(Object obj) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Task task = (Task) obj;
        session.update(task);
        tx.commit();
        session.close();
    }

    @Override
    public List<?> getWithFilterObjects(List<?> obj) throws HibernateException {
        Session session = getSession();
        Criteria c = session.createCriteria(Task.class);
        List<Task> tasks = null;
        List<Filter> filters = (List<Filter>) obj;
        AddRestrictions addRestrictions = new AddRestrictions();
        c= new GetUpdatedCriteria().getUpdatedCriteria(c, filters, "TASK");
        tasks = c.list();
        session.close();
        return tasks;
    }
}
