package com.qa.persistance.models;

public class Customer {
	private int cId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String postCode;
	private String email;

	// default customer constructor
	public Customer() {
		this.cId = 0;
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.city = "";
		this.postCode = "";
		this.email = "";
	}

	// customer constructor
	public Customer(int cId, String firstName, String lastName, String address, String city, String postCode,
			String email) {
		super();
		this.cId = cId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.postCode = postCode;
		this.email = email;
	}

	public int getCId() {
		return cId;
	}

	public void setCId(int cId) {
		this.cId = cId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		// "^.+@.+(\\.[^\\.]+)+$" <-validate the email somehow?
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", postCode=" + postCode + ", email=" + email + "]";
	}

}
