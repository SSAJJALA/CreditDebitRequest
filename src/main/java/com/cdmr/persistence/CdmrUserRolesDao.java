package com.cdmr.persistence;

import com.cdmr.entity.*;
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
 * Created by Siva Sajjala on 10/8/16.
 */
public class CdmrUserRolesDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all cdmr user roles
     *
     * @return All cdmr user roles
     */
    public List<CdmrUserRoles> getAllCdmrUserRoles() {
        List<CdmrUserRoles> userRoles = new ArrayList<CdmrUserRoles>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        userRoles = session.createCriteria(CdmrUserRoles.class).list();
        return userRoles;
    }

    /**
     * retrieve all user role by user
     *
     * @param userRole the user and role
     * @return cdmrUserRoles
     */
    public List<CdmrUserRoles> getCdmrUserRoles(CdmrUserRolesPK userRole) {
        List<CdmrUserRoles> userRoles = new ArrayList<CdmrUserRoles>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(CdmrUserRoles.class);
        criteria.add(Restrictions.eq("userRoles.userID", userRole.getUserID()));
        userRoles = criteria.list();
        return userRoles;
    }

    /**
     * add a user role
     *
     * @param userRoles
     * @return the user role of the inserted tcdmr user role
     */
    public CdmrUserRolesPK addUserRole(CdmrUserRoles userRoles) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(userRoles);
        tx.commit();
        session.close();
        CdmrUserRolesPK userRolePK = userRoles.getUserRoles();
        return userRolePK;
    }

    /**
     * delete a userrole by userRole
     * @param userRole the user ID, role
     */
    public void deleteUserRole(CdmrUserRolesPK userRole) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        CdmrUserRoles cdmrUserRoles = (CdmrUserRoles) session.load(CdmrUserRoles.class, userRole);
        log.info("CDMR user roles:" + cdmrUserRoles.toString());
        session.delete(cdmrUserRoles);
        tx.commit();
        log.info("User" + cdmrUserRoles.getUserRoles().getUserID() + "with role " + cdmrUserRoles.getUserRoles().getRole() + " deleted.");


    }

    /**
     * Update the cdmrUserRoles
     * @param cdmrUserRoles
     */

    public void updateUserRole(CdmrUserRoles cdmrUserRoles) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(cdmrUserRoles);
        tx.commit();

    }

    /**
     * get all task assignments based on search filters
     * @param filters filters
     * @return List<TaskAssignment> list of task assignments
     */

    public List<CdmrUserRoles> getUserRoles(List<Filter> filters) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria c = session.createCriteria(CdmrUserRoles.class);
        List<CdmrUserRoles> userRoles = null;

        for (Filter filter : filters) {
            String option = filter.getSearchOption();
            String operand = filter.getOperand();
            String value = filter.getSearchValue();

            Object searchValue = null;

            if (option.equals("userID") ) {
                option = "userRoles.userID";
            } else if (option.equals("role") ) {
                option = "userRoles.role";
            } else {
                searchValue = value;
            }

            c = this.addRestrictions(c, option, operand, searchValue);

        }

        userRoles = c.list();
        return userRoles;
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
