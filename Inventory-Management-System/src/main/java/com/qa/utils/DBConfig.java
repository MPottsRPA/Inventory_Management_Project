package com.qa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
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

	public static void closeConnection() {
		try {
			checkConnection().close();
			System.out.println("Thankyou for visiting the Cavers Shop!");
		} catch (SQLException e) {
			System.out.println("Error closing database connection!");
			e.printStackTrace();
		}
	}
}
