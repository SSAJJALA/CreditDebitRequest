package com.cdmr.Data;

/**
 * Created by student on 9/26/16.
 */
public class Customer {

    private int custNum;
    private String custName;
    private String address1;
    private String address2;
    private String state;
    private String zip;
    private String phone;

    public Customer() {
    }

    public Customer(int custNum, String custName, String address1, String address2, String state, String zip, String phone) {
        this.custNum = custNum;
        this.custName = custName;
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    @Override
    public String toString() {
        return "Customer{" +
                "custNum=" + custNum +
                ", custName=" + custName +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
