package com.cdmr.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 10/1/16.
 */

@Embeddable
public class CdmrUserRolesPK implements Serializable {

    @Column(name="USER_ID")
    private String userID;

    @Column(name="ROLE")
    private String role;

    public CdmrUserRolesPK() {
    }

    public CdmrUserRolesPK(String userID, String role) {
        this.userID = userID;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "CdmrUserRolesPK{" +
                "userID='" + userID + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
