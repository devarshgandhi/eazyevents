package com.eazy.events.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private String userid;
	private String email;
	private String firstname;
	private String lastname;
	private String phone;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	private String type;

	public User() {}
	
	public User(String userid, String email, String firstname, String lastname, String phone,
				String street, String city, String state, int zipcode, String type) {
		this.userid = userid;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.type = type;
	}
	
	public String getUserId() {
		return userid;
	}
	public void setUserId(String userId) {
		this.userid = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
