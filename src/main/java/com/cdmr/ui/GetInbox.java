package com.cdmr.ui;

import com.cdmr.entity.SearchInbox;
import com.cdmr.persistence.SessionFactoryProvider;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by student on 9/24/16.
 */
public class GetInbox {
    private String userID;
    private final Logger log = Logger.getLogger(this.getClass());

    public GetInbox() {
    }

    public GetInbox(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<SearchInbox> getTasks() {

        List<SearchInbox> inboxResults = null;
        String query = "SELECT A.TASK_ID, A.TASK_NAME, A.TASK_STATUS, A.CREATED_DATE, A.UPDATED_DATE, B.REQUISITION_ID, B.USER_ID"
                        + " FROM TASK A, TASK_ASSIGNMENT B"
                        + " WHERE"
                        + " A.TASK_ID = B.TASK_ID AND";

        String userID = this.getUserID();

        query = query + " B.USER_ID =" + " '" + userID + "'";

        inboxResults = this.executeQuery(query);

        return inboxResults;

    }

    public List<SearchInbox> executeQuery(String sql) {
        List<SearchInbox> userInbox = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        SQLQuery query = session.createSQLQuery(sql);
        //query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<Object[]> rows = query.list();



        for(Object[] row : rows) {

            SearchInbox tempInbox = new SearchInbox();
            tempInbox.setTaskID(Integer.parseInt(row[0].toString()));
            tempInbox.setTaskName(row[1].toString());
            tempInbox.setTaskStatus(row[2].toString());
            tempInbox.setCreatedDate(formatDate(row[3].toString()));
            tempInbox.setUpdatedDate(formatDate(row[4].toString()));
            tempInbox.setRequisitionID(Integer.parseInt(row[5].toString()));
            tempInbox.setUserID(row[6].toString());

            userInbox.add(tempInbox);

        }

        return userInbox;

    }

    private LocalDate formatDate (String dob) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;

    }

}