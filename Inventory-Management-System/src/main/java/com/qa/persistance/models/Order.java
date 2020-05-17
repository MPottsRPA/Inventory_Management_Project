package com.qa.persistance.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.inventorymanagementsystem.DBConfig;

public class Order {
	private int oId;
	private int cId;
	private double value;

	public Order() {
		super();
		this.oId = 0;
		this.cId = 0;
		this.value = 0.0;
	}

	public Order(int oId, int cId, double value) {
		super();
		this.oId = oId;
		this.cId = cId;
		this.value = value;
	}

	// need to change value to a call to the calculate value method
	public void createOrder(int oId, int cId, double value) {
		String query = "INSERT INTO orders (`fk_CID`, `value`) VALUES ('" + cId + "', '" + value + "')";
		DBConfig.exUpdate(query);
	}

	// Read part of CRUD functionality
	public Order readAll() {
		String query = "SELECT * FROM orders";
		ResultSet rs = DBConfig.exQuery(query);
		int oIdTemp = 0;
		int cIdTemp = 0;
		double valueTemp = 0.0;
		try {
			while (rs.next()) {
				// temp sout to check method works
				System.out.println(rs.getInt("OID") + ", " + rs.getInt("fk_CID") + ", " + rs.getDouble("value"));
				oIdTemp = rs.getInt("OID");
				cIdTemp = rs.getInt("fk_CID");
				valueTemp = rs.getDouble("value");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Order(oIdTemp, cIdTemp, valueTemp);
	}

	// Delete part of CRUD functionality
	public void deleteOrder(int OID) {
		String query = "DELETE FROM orders WHERE OID = " + OID;
		DBConfig.exUpdate(query);
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double calcValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Order [oId=" + oId + ", cId=" + cId + "]";
	}

}
