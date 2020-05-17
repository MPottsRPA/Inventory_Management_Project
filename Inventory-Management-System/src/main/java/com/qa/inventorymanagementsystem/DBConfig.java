package com.qa.inventorymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {
	// connection to the database stored on my computer
	public static final String URL = "jdbc:mysql://localhost/caverdb?serverTimezone=UTC";

	// My username and password
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	static Connection conn = null;
	static Statement stmnt = null;
	static PreparedStatement prepstmnt = null;

	public static void connectDB() {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection Successful!");
			stmnt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection Failed.");
			e.printStackTrace();
		}
	}

	// Separates the executeUpdate method
	public static void exUpdate(String query) {
		try {
			stmnt.executeUpdate(query);
			System.out.println("Execution of query successful.");
		} catch (SQLException e) {
			System.out.println("Error executing query.");
			e.printStackTrace();
		}
	}

	public static ResultSet exQuery(String query) {
		ResultSet r = null;
		try {
			r = stmnt.executeQuery(query);
			System.out.println("Execution of query successful.");
		} catch (SQLException e) {
			System.out.println("Error executing query.");
			e.printStackTrace();
		}
		return r;
	}

	public static Connection checkConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				connectDB();
				System.out.println("Connection Successful!");
				return conn;
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed.");
			e.printStackTrace();
		}
		return conn;
	}

	static void closeConnection() {
		try {
			checkConnection().close();
		} catch (SQLException e) {
			System.out.println("Error closing database connection!");
			e.printStackTrace();
		}
	}
}
