package com.cdmr.persistence;

import com.cdmr.entity.Cdmr;
import com.cdmr.entity.Filter;
import com.cdmr.entity.Task;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Siva Sajjala on 9/24/16.
 */
public class TaskDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all tasks
     *
     * @return All tasks
     */
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<Task>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        tasks = session.createCriteria(Task.class).list();
        return tasks;
    }

    /**
     * retrieve a task given an task id
     *
     * @param taskID the task id
     * @return task
     */
    public Task getTask(int taskID) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Task  task = (Task) session.get(Task.class, taskID);
        return task;

    }

    /**
     * add a task
     *
     * @param task
     * @return the taskID of the inserted task
     */
    public int addTask(Task task) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(task);
        tx.commit();
        session.close();
        int taskID = task.getTaskID();
        return taskID;
    }

    /**
     * delete a task by taskID
     * @param taskID the Task ID
     */
    public void deleteTask(int taskID) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Task task = (Task) session.load(Task.class,taskID);
        log.info("Task:" + task.toString());
        session.delete(task);
        tx.commit();
        log.info("Task" + taskID + "deleted.");


    }

    /**
     * Update the task
     * @param task
     */

    public void updateTask(Task task) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(task);
        tx.commit();

    }

    public List<Task> getTasks(List<Filter> filters) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria c = session.createCriteria(Task.class);
        List<Task> tasks = null;

        for (Filter filter : filters) {
            String option = filter.getSearchOption();
            String operand = filter.getOperand();
            String value = filter.getSearchValue();

            Object searchValue = null;

            if (option.equals("taskID")) {
                searchValue = Integer.parseInt(value);
            } else if (option.equals("createdDate")) {
                searchValue = formatDate(value);
            } else {
                searchValue = value;
            }

            c = this.addRestrictions(c, option, operand, searchValue);

        }

        tasks = c.list();
        return tasks;
    }

    public Criteria addRestrictions(Criteria tempCriteria, String option, String operand, Object value) {

        if (operand.equals("="))  {
            tempCriteria.add(Restrictions.eq(option, value));
        } else if (operand.equals(">")) {
            tempCriteria.add(Restrictions.gt(option, value));
        } else if (operand.equals("<")) {
            tempCriteria.add(Restrictions.lt(option, value));
        } else if (operand.equals(">=")) {
            tempCriteria.add(Restrictions.ge(option, value));
        } else if (operand.equals("<=")) {
            tempCriteria.add(Restrictions.le(option, value));
        } else if (operand.equals("LIKE")) {
            tempCriteria.add(Restrictions.like(option, value));
        } else if (operand.equals("!=")) {
            tempCriteria.add(Restrictions.ne(option, value));
        }

        return tempCriteria;

    }

    private LocalDate formatDate (String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;

    }
}
