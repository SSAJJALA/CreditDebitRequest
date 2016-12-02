package com.cdmr.Data;

/**
 * This class is to hold the customer details
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-09-26
 */
public class Customer {

    private int custNum;
    private String custName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;

    /**
     * No arg constructor
     */
    public Customer() {
    }

    /**
     * Constructor with args
     * @param custNum
     * @param custName
     * @param address1
     * @param address2
     * @param city
     * @param state
     * @param zip
     * @param phone
     */
    public Customer(int custNum, String custName, String address1, String address2, String city, String state, String zip, String phone) {
        this.custNum = custNum;
        this.custName = custName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    /**
     * get customer number
     * @return custNum
     */
    public int getCustNum() {
        return custNum;
    }

    /**
     * set customer number
     * @param  custNum  customer number
     */
    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    /**
     * set the customer name
     * @return custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * get the customer name
     * @param custName
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * get the customer address 1
     * @return address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * set the customer address 1
     * @return address2
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * get the customer address 2
     * @return address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * set the customer address 2
     * @param  address2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * get the state
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * set the state
     * @param  state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * get the zip
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * set the zip
     * @param  zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * get the phone number
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * set the phone number
     * @param  phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * get the city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * set the city
     * @param  city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * toString method to display the customer info
     * @return string
     */
    @Override
    public String toString() {
        return "Customer{" +
                "custNum=" + custNum +
                ", custName='" + custName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
