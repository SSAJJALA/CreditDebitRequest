package com.cdmr.entity;

import com.cdmr.util.LocalDateAttributeConverter;
import com.cdmr.util.LocalDateTimeAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * A class to represent a user.
 *
 * @author Siva Sajjala
 */

@Entity
@Table(name = "REQUISITION")
public class Requisition {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "REQUISITION_ID")
    private int requisitionID;

    @Column(name="APP_ID")
    private int appID;

    @Column(name = "APP_NAME")
    private String appName;

    @Column(name = "CREATED_DATE")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime updatedDate;

    /**
     * Instantiates a new Requisition.
     */
    public Requisition() {

    }

    /**
     * Instantiates a new Requisition.
     * @param appID the application id
     * @param appName  the application name
     * @param createdDate    the created date
     * @param updatedDate the updated date

     */

    public Requisition(int appID, String appName, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this();
        this.appID = appID;
        this.appName = appName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }



    public int getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(int requisitionID) {
        this.requisitionID = requisitionID;
    }

    public int getAppID() {
        return appID;
    }

    public void setAppID(int appID) {
        this.appID = appID;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Requisition{" +
                "requisitionID=" + requisitionID +
                ", appID=" + appID +
                ", appName='" + appName + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}

