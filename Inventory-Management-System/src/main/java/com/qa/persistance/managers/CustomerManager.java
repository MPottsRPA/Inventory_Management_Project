package com.qa.persistance.managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qa.business.IQuery;
import com.qa.inventorymanagementsystem.DBConfig;
import com.qa.persistance.models.Customer;

public class CustomerManager implements IQuery {

	// Will probably replace the create statements with prepared statements. This
	// method will be to test that
//	public void createCustomer(int cId, String firstName, String lastName, String address, String city, String postCode,
//			String email) {
//		String query = "INSERT INTO customers (`first_name`, `last_name`, `address`, `city`, `post_code`, `email`) VALUES (?, ?, ?, ?, ?, ?)";
//		DBConfig.exUpdate(query);
//	}

	public void create(Object object) {
		if (object instanceof Customer) {
			Customer customer = (Customer) object;
			String query = "INSERT INTO customers VALUES ('" + customer.getCId() + "', '" + customer.getFirstName()
					+ "', '" + customer.getLastName() + "', '" + customer.getAddress() + "', '" + customer.getCity()
					+ "', '" + customer.getPostCode() + "', '" + customer.getEmail() + "')";
			DBConfig.exUpdate(query);
		}
	}

	public ArrayList<Object> readAll() {
		ArrayList<Object> customerList = new ArrayList<Object>();
		String query = "SELECT * FROM customers";
		ResultSet rs = DBConfig.exQuery(query);
		try {
			while (rs.next()) {
				customerList.add(new Customer(rs.getInt("CID"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("address"), rs.getString("city"), rs.getString("post_code"),
						rs.getString("email")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return customerList;
	}

	public Object readRecord(int id) {
		String query = "SELECT * FROM customers WHERE CID = " + id;
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

	// Update first name
	public void updateFirstName(int cId, String fname) {
		String query = "UPDATE customers SET first_name = '" + fname + "' WHERE CID = " + cId;
		DBConfig.exUpdate(query);
		System.out.println("Customer " + cId + "'s first name has been updated.");
	}

	// update last name
	public void updateLastName(int cId, String lname) {
		String query = "UPDATE customers SET last_name = '" + lname + "' WHERE CID = " + cId;
		DBConfig.exUpdate(query);
		System.out.println("Customer " + cId + "'s last name has been updated.");
	}

	// update address details
	public void updateAddress(int cId, String address, String city, String postCode) {
		String query = "UPDATE customers SET address = '" + address + "', city = '" + city + "', post_code = '"
				+ postCode + "' WHERE CID = " + cId;
		DBConfig.exUpdate(query);
		System.out.println("Customer " + cId + "'s address has been updated.");
	}

	// update email
	public void updateEmail(int cId, String email) {
		String query = "UPDATE customers SET email = '" + email + "' WHERE CID = " + cId;
		DBConfig.exUpdate(query);
		System.out.println("Customer " + cId + "'s email has been updated.");
	}

	// Delete part of CRUD functionality
	public void delete(int cId) {
		String query = "DELETE FROM customers WHERE CID = " + cId;
		DBConfig.exUpdate(query);
		System.out.println("Customer record " + cId + " has been deleted.");
	}

}
