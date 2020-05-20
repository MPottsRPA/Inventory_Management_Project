package com.qa.persistance.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qa.business.IQuery;
import com.qa.persistance.models.Customer;
import com.qa.utils.DBConfig;

public class CustomerManager implements IQuery {

	public void create(Object object) {
		if (object instanceof Customer) {
			Customer customer = (Customer) object;
			String query = "INSERT INTO customers VALUES (?,?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
				prepstmnt.setInt(1, customer.getCId());
				prepstmnt.setString(2, customer.getFirstName());
				prepstmnt.setString(3, customer.getLastName());
				prepstmnt.setString(4, customer.getAddress());
				prepstmnt.setString(5, customer.getCity());
				prepstmnt.setString(6, customer.getPostCode());
				prepstmnt.setString(7, customer.getEmail());
				prepstmnt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Object> readAll() {
		ArrayList<Object> customerList = new ArrayList<Object>();
		String query = "SELECT * FROM customers";
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			ResultSet rs = prepstmnt.executeQuery();
			while (rs.next()) {
				customerList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	public Object readRecord(int id) {
		String query = "SELECT * FROM customers WHERE CID = " + id;
		int cIdTemp = 0;
		String firstNameTemp = null;
		String lastNameTemp = null;
		String addressTemp = null;
		String cityTemp = null;
		String postCodeTemp = null;
		String emailTemp = null;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			ResultSet rs = prepstmnt.executeQuery();
			while (rs.next()) {
				cIdTemp = rs.getInt(1);
				firstNameTemp = rs.getString(2);
				lastNameTemp = rs.getString(3);
				addressTemp = rs.getString(4);
				cityTemp = rs.getString(5);
				postCodeTemp = rs.getString(6);
				emailTemp = rs.getString(7);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Customer(cIdTemp, firstNameTemp, lastNameTemp, addressTemp, cityTemp, postCodeTemp, emailTemp);
	}

	// Update first name
	public void updateFirstName(int cId, String fname) {
		String query = "UPDATE customers SET first_name = '" + fname + "' WHERE CID = " + cId;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			prepstmnt.executeUpdate();
			System.out.println("Customer " + cId + "'s first name has been updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update last name
	public void updateLastName(int cId, String lname) {
		String query = "UPDATE customers SET last_name = '" + lname + "' WHERE CID = " + cId;

		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			prepstmnt.executeUpdate();
			System.out.println("Customer " + cId + "'s last name has been updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update address details
	public void updateAddress(int cId, String address, String city, String postCode) {
		String query = "UPDATE customers SET address = '" + address + "', city = '" + city + "', post_code = '"
				+ postCode + "' WHERE CID = " + cId;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			prepstmnt.executeUpdate();
			System.out.println("Customer " + cId + "'s address has been updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update email
	public void updateEmail(int cId, String email) {
		String query = "UPDATE customers SET email = '" + email + "' WHERE CID = " + cId;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			prepstmnt.executeUpdate();
			System.out.println("Customer " + cId + "'s email has been updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete part of CRUD functionality
	public void delete(int id) {
		String query = "DELETE FROM customers WHERE CID = " + id;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			prepstmnt.executeUpdate();
			System.out.println("Customer record " + id + " has been deleted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
