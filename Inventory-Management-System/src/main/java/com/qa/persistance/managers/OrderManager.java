package com.qa.persistance.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qa.business.IQuery;
import com.qa.persistance.models.Order;
import com.qa.utils.DBConfig;

public class OrderManager implements IQuery {

	public Object create(Object object) {
		if (object instanceof Order) {
			Order order = (Order) object;
			String query = "INSERT INTO orders VALUES (?,?,?)";
			try {
				PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
				prepstmnt.setInt(1, order.getoId());
				prepstmnt.setInt(2, order.getcId());
				prepstmnt.setDouble(3, order.getValue());
				prepstmnt.executeUpdate();
				System.out.println("Successfully created a new order!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return order;
		}
		return null;
	}

	public ArrayList<Object> readAll() {
		ArrayList<Object> orderList = new ArrayList<Object>();
		String query = "SELECT * FROM orders";
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			ResultSet rs = prepstmnt.executeQuery();
			while (rs.next()) {
				orderList.add(new Order(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return orderList;
	}

	public Object readRecord(int id) {
		String query = "SELECT * FROM orders WHERE OID = " + id;
		int oIdTemp = 0;
		int fkcIdTemp = 0;
		double valueTemp = 0.00;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			ResultSet rs = prepstmnt.executeQuery();
			while (rs.next()) {
				oIdTemp = rs.getInt(1);
				fkcIdTemp = rs.getInt(2);
				valueTemp = rs.getDouble(3);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return new Order(oIdTemp, fkcIdTemp, valueTemp);
	}

	public boolean delete(int id) {
		String query = "DELETE FROM orders WHERE OID = ?";
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			prepstmnt.setInt(1, id);
			prepstmnt.executeUpdate();
			System.out.println("Successfully deleted order!");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
