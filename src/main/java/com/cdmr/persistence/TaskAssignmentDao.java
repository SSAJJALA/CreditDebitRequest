package com.cdmr.persistence;

import com.cdmr.entity.*;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Siva Sajjala on 9/24/16.
 */
public class TaskAssignmentDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all tasks
     *
     * @return All tasks
     */
    public List<TaskAssignment> getAllTaskAssignments() {
        List<TaskAssignment> tasks = new ArrayList<TaskAssignment>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        tasks = session.createCriteria(TaskAssignment.class).list();
        return tasks;
    }

    /**
     * retrieve all tasks given an task id
     *
     * @param taskUser the task id, user id
     * @return tasks
     */
    public TaskAssignment getTask(TaskAssignmentPK taskUser) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        TaskAssignment  tasks = (TaskAssignment) session.get(TaskAssignment.class, taskUser);
        return tasks;

    }

    /**
     * add a task user assignment
     *
     * @param task
     * @return the taskUser of the inserted task assignment
     */
    public TaskAssignmentPK addTask(TaskAssignment task) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
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
    public void deleteTask(TaskAssignmentPK taskUser) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        TaskAssignment taskAssignment = (TaskAssignment) session.load(TaskAssignment.class, taskUser);
        log.info("Task Assignment:" + taskUser.toString());
        session.delete(taskAssignment);
        tx.commit();
        log.info("Task" + taskUser.getTaskID() + "with user" + taskUser.getUserID() + "deleted.");


    }

    /**
     * Update the taskAssignment
     * @param taskAssignment
     */

    public void updateTaskAssignment(TaskAssignment taskAssignment) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(taskAssignment);
        tx.commit();

    }

    /**
     * get all task assignments based on search filters
     * @param filters filters
     * @return TaskAssignment list of task assignments
     */

    public List<TaskAssignment> getTasks(List<Filter> filters) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria c = session.createCriteria(TaskAssignment.class);
        List<TaskAssignment> taskAssignments = null;

        for (Filter filter : filters) {
            String option = filter.getSearchOption();
            String operand = filter.getOperand();
            String value = filter.getSearchValue();

            Object searchValue = null;

            if (option.equals("taskID") || option.equals("requisitionID")) {
                searchValue = Integer.parseInt(value);
            } else if (option.equals("taskID") ) {
                searchValue = Integer.parseInt(value);
                option = "taskuser.taskID";
            } else if (option.equals("userID")) {
                option = "taskuser.userID";
            } else {
                searchValue = value;
            }

            c = this.addRestrictions(c, option, operand, searchValue);

        }

        taskAssignments = c.list();
        return taskAssignments;
    }

    /**
     * Add filters to the search
     * @param tempCriteria
     * @param option
     * @param operand
     * @param value
     * @return Criteria with added restrictions
     */

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
            value = "%"+value+"%";
            tempCriteria.add(Restrictions.like(option, value));
        } else if (operand.equals("!=")) {
            tempCriteria.add(Restrictions.ne(option, value));
        }

        return tempCriteria;

    }

    /**
     * get date in local date format
     * @param dob
     * @return date in local date
     */

    private LocalDate formatDate (String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;

    }
}
