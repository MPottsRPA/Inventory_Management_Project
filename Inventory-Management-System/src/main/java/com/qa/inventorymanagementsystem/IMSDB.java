package com.qa.inventorymanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class IMSDB {

	private Connection conn;

	private Statement stmnt;

	public IMSDB() {

	}

	public void cusCreate(String uname, String fname, String lname, String address, String city, String postCode,
			String email, String password) throws SQLException {
		this.stmnt = conn.createStatement();
		String sqlCus = "INSERT INTO customers (`username`, `first_name`, `last_name`, `address`, `city`, `post_code`, `email`, `password`) VALUES ('"
				+ uname + "', '" + fname + "', '" + lname + "', '" + address + "', '" + city + "', '" + postCode
				+ "', '" + email + "', '" + password + "')";
		this.stmnt.execute(sqlCus);
		stmnt.close();
	}

	public void proCreate(String name, double price, int quantity) throws SQLException {
		this.stmnt = conn.createStatement();
		String sqlPro = "INSERT INTO products (`name`, `price`, `quantity`) VALUES ('" + name + "', '" + price + "', '"
				+ quantity + "')";
		this.stmnt.execute(sqlPro);
		stmnt.close();
	}

	public void ordCreate(Date datePlaced) throws SQLException {
		this.stmnt = conn.createStatement();
		String sqlOrd = "INSERT INTO orders (`date_placed`) VALUES ('" + datePlaced + "')";
		this.stmnt.execute(sqlOrd);
		stmnt.close();
	}

	public void cusRead() throws SQLException {
		this.stmnt = conn.createStatement();
		String sql = "SELECT * FROM customers";
		ResultSet results = this.stmnt.executeQuery(sql);
		while (results.next()) {
			System.out.println(results.getInt("CID") + ", " + results.getString("username") + ", "
					+ results.getString("first_name") + ", " + results.getString("last_name") + ", "
					+ results.getString("address") + ", " + results.getString("city") + ", "
					+ results.getString("post_code") + ", " + results.getString("email") + ", "
					+ results.getString("password"));
		}
		stmnt.close();
	}

	public void proRead() throws SQLException {
		this.stmnt = conn.createStatement();
		String sql = "SELECT * FROM products";
		ResultSet results = this.stmnt.executeQuery(sql);
		while (results.next()) {
			System.out.println(results.getInt("PID") + ", " + results.getString("name") + ", "
					+ results.getDouble("price") + ", " + results.getInt("quantity"));
		}
		stmnt.close();
	}

	public void ordRead() throws SQLException {
		this.stmnt = conn.createStatement();
		String sql = "SELECT * FROM orders";
		ResultSet results = this.stmnt.executeQuery(sql);
		while (results.next()) {
			System.out.println(
					results.getInt("OID") + ", " + results.getInt("CID") + ", " + results.getDate("date_placed"));
		}
		stmnt.close();
	}

	public void update(String fname, String lname, int CID) throws SQLException {
		this.stmnt = conn.createStatement();
		String sql = "UPDATE customers SET first_name = '" + fname + "', last_name = '" + lname + "' WHERE CID = "
				+ CID;
		stmnt.executeUpdate(sql);
		stmnt.close();
	}

	public void delete(int CID) throws SQLException {
		this.stmnt = conn.createStatement();
		String sql = "DELETE FROM customers WHERE CID = " + CID;
		stmnt.execute(sql);
		stmnt.close();
	}

}
