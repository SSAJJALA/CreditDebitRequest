package com.cdmr.persistence;

import com.cdmr.entity.Filter;
import com.cdmr.entity.TaskAssignment;
import com.cdmr.entity.TaskAssignmentPK;
import com.cdmr.util.AddRestrictions;
import com.cdmr.util.GetUpdatedCriteria;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This is concrete implementation for abstract class GenericDAO. Fetches from the DB table TASK_ASSIGNMENT
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-04
 */
public class TaskAssignmentDAOnew extends GenericDAO {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * get session
     * @return session
     */
    @Override
    protected Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /** Return a list of all tasks
     *
     * @return All tasks
     */
    @Override
    public List<?> getAll() throws HibernateException {
        List<TaskAssignment> tasks = new ArrayList<TaskAssignment>();
        Session session = getSession();
        tasks = (List<TaskAssignment>) session.createCriteria(TaskAssignment.class).list();
        session.close();
        return tasks;
    }

    /**
     * retrieve all tasks given a task id and user
     *
     * @param taskUser the task id, user id
     * @return tasks
     */
    public TaskAssignment getTask(TaskAssignmentPK taskUser) throws HibernateException {
        Session session = getSession();
        TaskAssignment  tasks = (TaskAssignment) session.get(TaskAssignment.class, taskUser);
        session.close();
        return tasks;

    }

    /**
     * add a task user assignment
     *
     * @param task
     * @return the taskUser of the inserted task assignment
     */
    public TaskAssignmentPK addTask(TaskAssignment task) throws HibernateException {

        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(task);
        tx.commit();
        session.close();
        TaskAssignmentPK taskUser = task.getTaskuser();
        return taskUser;
    }

    /**
     * delete a task by taskUser
     * @param taskUser the Task ID, User ID
     */
    public void deleteTask(TaskAssignmentPK taskUser) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        TaskAssignment taskAssignment = (TaskAssignment) session.load(TaskAssignment.class, taskUser);
        log.info("Task Assignment:" + taskUser.toString());
        session.delete(taskAssignment);
        tx.commit();
        session.close();
        log.info("Task" + taskUser.getTaskID() + "with user" + taskUser.getUserID() + "deleted.");
    }

    /**
     * Update the taskAssignment
     * @param obj taskAssignment
     */

    @Override
    public void update(Object obj) throws HibernateException {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        TaskAssignment taskAssignment = (TaskAssignment) obj;
        session.update(taskAssignment);
        tx.commit();
        session.close();

    }

    /**
     * get all task assignments based on search filters
     * @param obj ilters
     * @return TaskAssignment list of task assignments
     */

    @Override
    public List<?> getWithFilterObjects(List<?> obj) throws HibernateException {
        Session session = getSession();
        Criteria c = session.createCriteria(TaskAssignment.class);
        List<TaskAssignment> taskAssignments = null;
        List<Filter> filters = (List<Filter>) obj;
        AddRestrictions addRestrictions = new AddRestrictions();
        c= new GetUpdatedCriteria().getUpdatedCriteria(c, filters, "TASK_ASSIGNMENT");
        taskAssignments = c.list();
        session.close();
        return taskAssignments;
    }

}
