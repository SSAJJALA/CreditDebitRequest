package com.cdmr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by student on 9/22/16.
 */

@Entity
@Table(name = "CDMR_USERS")
public class CdmrUsers {

    @Id
    @Column(name = "USER_ID")
    private String userID;

    @Column(name = "FIRST_NAME")
    private String firstName;


    @Column(name = "LAST_NAME")
    private String lastName;


    @Column(name = "PASSWORD")
    private String passWord;


    @Column(name = "ROLE")
    private String role;

    public CdmrUsers() {
    }

    public CdmrUsers(String userID, String firstName, String lastName, String passWord, String role) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "CdmrUsers{" +
                "userID='" + userID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
