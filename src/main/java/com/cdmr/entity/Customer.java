package com.cdmr.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * Created by Siva Sajjala on 9/18/16.
 */

@Entity
@Table(name = "CUSTOMER")
@JsonInclude(Include.NON_EMPTY)
@JsonRootName(value="Customer")
@XmlRootElement
public class Customer {

    @Id
    @Column(name = "CUST_NUM")
    private int custNum;

    @Column(name="CUST_NAME")
    private String custName;

    @Column(name="ADDRESS_1")
    private String add1;

    @Column(name="ADDRESS_2")
    private String add2;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @Column(name="ZIP")
    private String zip;

    @Column(name="PHONE")
    private String phone;


    /**
     * No arg constructor
     */
    public Customer() {
    }

    /**
     * Customer contrcutor with args
     * @param custNum
     * @param custName
     * @param add1
     * @param add2
     * @param city
     * @param state
     * @param zip
     * @param phone
     */
    public Customer(int custNum, String custName, String add1, String add2, String city, String state, String zip, String phone) {
        this();
        this.custNum = custNum;
        this.custName = custName;
        this.add1 = add1;
        this.add2 = add2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    /**
     * getter method for custNum
     * @return custNum the Customer number
     */
    public int getCustNum() {
        return custNum;
    }

    /**
     * setter method for custNum
     * @param custNum the Customer number
     */
    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    /**
     * getter method for custName
     * @return custName the Customer name
     */
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * to string method to get the Customer information
     * @return Customer info string
     */
    @Override
    public String toString() {
        return "Customer{" +
                "custNum=" + custNum +
                ", custName='" + custName + '\'' +
                ", add1='" + add1 + '\'' +
                ", add2='" + add2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
