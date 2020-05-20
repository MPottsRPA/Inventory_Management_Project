package com.qa.persistance.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qa.business.IQuery;
import com.qa.persistance.models.Product;
import com.qa.utils.DBConfig;

public class ProductManager implements IQuery {

	public void create(Object object) {
		if (object instanceof Product) {
			Product product = (Product) object;
			String query = "INSERT INTO products VALUES (?,?,?,?)";
			try {
				PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
				prepstmnt.setInt(1, product.getPId());
				prepstmnt.setString(2, product.getName());
				prepstmnt.setDouble(3, product.getPrice());
				prepstmnt.setInt(4, product.getStock());
				prepstmnt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Object> readAll() {
		ArrayList<Object> productList = new ArrayList<Object>();
		String query = "SELECT * FROM products";
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			ResultSet rs = prepstmnt.executeQuery();
			while (rs.next()) {
				productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return productList;
	}

	public Object readRecord(int id) {
		String query = "SELECT * FROM products WHERE PID = " + id;
		int pIdTemp = 0;
		String nameTemp = null;
		double priceTemp = 0.0;
		int stockTemp = 0;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			ResultSet rs = prepstmnt.executeQuery();
			while (rs.next()) {
				pIdTemp = rs.getInt(1);
				nameTemp = rs.getString(2);
				priceTemp = rs.getDouble(3);
				stockTemp = rs.getInt(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Product(pIdTemp, nameTemp, priceTemp, stockTemp);
	}

	public double findPrice(int pId) {
		String query = "SELECT price FROM products WHERE PID = " + pId;
		double priceTemp = 0.0;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			ResultSet rs = prepstmnt.executeQuery();
			while (rs.next()) {
				priceTemp = rs.getDouble(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return priceTemp;
	}

	// Update product name
	public void updateName(int pId, String name) {
		String query = "UPDATE products SET name = '" + name + "' WHERE PID = " + pId;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			prepstmnt.executeUpdate();
			System.out.println("Product " + pId + "'s name has been updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update product price
	public void updatePrice(int pId, double price) {
		String query = "UPDATE products SET price = '" + price + "' WHERE PID = " + pId;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			prepstmnt.executeUpdate();
			System.out.println("Product " + pId + "'s price has been updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update product stock
	public void updateStock(int pId, int stock) {
		String query = "UPDATE products SET stock = '" + stock + "' WHERE PID = " + pId;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			prepstmnt.executeUpdate();
			System.out.println("Product " + pId + "'s stock has been updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete part of CRUD functionality
	public void delete(int id) {
		String query = "DELETE FROM products WHERE PID = " + id;
		try {
			PreparedStatement prepstmnt = DBConfig.checkConnection().prepareStatement(query);
			prepstmnt.executeUpdate();
			System.out.println("Product record " + id + " has been deleted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
