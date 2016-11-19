package com.cdmr.webservices;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * Customer data object that holds all the customer information. This is used for mapping the JSON response from customer lookup web service.
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-10-15
 */
@Generated("com.robohorse.robopojogenerator")
public class Customer{
	@JsonProperty("zip")
	private String zip;
	@JsonProperty("city")
	private String city;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("custNum")
	private int custNum;
	@JsonProperty("state")
	private String state;
	@JsonProperty("add2")
	private String add2;
	@JsonProperty("custName")
	private String custName;
	@JsonProperty("add1")
	private String add1;

	public void setAdd2(String add2){
		this.add2 = add2; 
	}

	public void setPhone(String phone){
		this.phone = phone; 
	}

	public String getZip(){
		return zip; 
	}

	public String getAdd2(){
		return add2; 
	}

	public void setCustName(String custName){
		this.custName = custName; 
	}

	public String getCustName(){
		return custName; 
	}

	public String getCity(){
		return city; 
	}

	public String getAdd1(){
		return add1; 
	}

	public void setState(String state){
		this.state = state; 
	}

	public void setAdd1(String add1){
		this.add1 = add1; 
	}

	public int getCustNum(){
		return custNum; 
	}

	public void setCity(String city){
		this.city = city; 
	}

	public String getPhone(){
		return phone; 
	}

	public String getState(){
		return state; 
	}

	public void setCustNum(int custNum){
		this.custNum = custNum; 
	}

	public void setZip(String zip){
		this.zip = zip; 
	}

}