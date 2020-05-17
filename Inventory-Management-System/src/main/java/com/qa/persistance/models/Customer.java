package com.qa.persistance.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.inventorymanagementsystem.DBConfig;

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

	// Create part of the CRUD functionality
	public void createCustomer(int cId, String firstName, String lastName, String address, String city, String postCode,
			String email) {
		String query = "INSERT INTO customers (`first_name`, `last_name`, `address`, `city`, `post_code`, `email`) VALUES ('"
				+ firstName + "', '" + lastName + "', '" + address + "', '" + city + "', '" + postCode + "', '" + email
				+ "')";
		DBConfig.exUpdate(query);
	}

	// Will probably replace the create statements with prepared statements. This
	// method will be to test that
//	public void createCustomer(int cId, String firstName, String lastName, String address, String city, String postCode,
//			String email) {
//		String query = "INSERT INTO customers (`first_name`, `last_name`, `address`, `city`, `post_code`, `email`) VALUES (?, ?, ?, ?, ?, ?)";
//		DBConfig.exUpdate(query);
//
//	}

	// reads all the customer data
	public Customer readAll() {
		String query = "SELECT * FROM customers";
		ResultSet rs = DBConfig.exQuery(query);
		int cIdTemp = 0;
		String firstNameTemp = null;
		String lastNameTemp = null;
		String addressTemp = null;
		String cityTemp = null;
		String postCodeTemp = null;
		String emailTemp = null;
		try {
			while (rs.next()) {
				// This Sout is only temporary just to check the method works. Need to implement
				// some sort of toString method
				System.out.println(rs.getInt("CID") + ", " + rs.getString("first_name") + ", "
						+ rs.getString("last_name") + ", " + rs.getString("address") + ", " + rs.getString("city")
						+ ", " + rs.getString("post_code") + ", " + rs.getString("email"));
				cIdTemp = rs.getInt("CID");
				firstNameTemp = rs.getString("first_name");
				lastNameTemp = rs.getString("last_name");
				addressTemp = rs.getString("address");
				cityTemp = rs.getString("city");
				postCodeTemp = rs.getString("post_code");
				emailTemp = rs.getString("email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Customer(cIdTemp, firstNameTemp, lastNameTemp, addressTemp, cityTemp, postCodeTemp, emailTemp);
	}

	// Returns only one customer specified by the CID. Need to implement this
	public Customer readCustomer(int cId) {
		String query = "SELECT * FROM customers WHERE CID = " + cId;
		ResultSet rs = DBConfig.exQuery(query);
		int cIdTemp = 0;
		String firstNameTemp = null;
		String lastNameTemp = null;
		String addressTemp = null;
		String cityTemp = null;
		String postCodeTemp = null;
		String emailTemp = null;
		try {
			while (rs.next()) {
				cIdTemp = rs.getInt("CID");
				firstNameTemp = rs.getString("first_name");
				lastNameTemp = rs.getString("last_name");
				addressTemp = rs.getString("address");
				cityTemp = rs.getString("city");
				postCodeTemp = rs.getString("post_code");
				emailTemp = rs.getString("email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Customer(cIdTemp, firstNameTemp, lastNameTemp, addressTemp, cityTemp, postCodeTemp, emailTemp);
	}

	// Add update method

	// Delete part of CRUD functionality
	public void deleteCustomer(int cId) {
		String query = "DELETE FROM customers WHERE CID = " + cId;
		DBConfig.exUpdate(query);
	}

	public int getCId() {
		return cId;
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
