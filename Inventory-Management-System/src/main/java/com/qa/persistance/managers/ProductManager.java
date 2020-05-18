package com.qa.persistance.managers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.inventorymanagementsystem.DBConfig;
import com.qa.persistance.models.Product;

public class ProductManager {

	// Create part of the CRUD functionality
	public void createProduct(int pId, String name, double price, int stock) {
		String query = "INSERT INTO products (`name`, `price`, `stock`) VALUES ('" + name + "', '" + price + "', '"
				+ stock + "')";
		DBConfig.exUpdate(query);
	}

	// Create method that takes in a customer object
	public void createProduct(Product product) {
		String query = "INSERT INTO products VALUES ('" + product.getPId() + "', '" + product.getName() + "', '"
				+ product.getPrice() + "', '" + product.getStock() + "')";
		DBConfig.exUpdate(query);
	}

	// Reads all the data and returns the results in a product object. Change sout
	// to a better printout, eg put into arraylist or object
	public Product readAll() {
		String query = "SELECT * FROM products";
		ResultSet rs1 = DBConfig.exQuery(query);
		int pIdTemp = 0;
		String nameTemp = null;
		double priceTemp = 0.0;
		int stockTemp = 0;
		try {
			while (rs1.next()) {
				// temporary sout to check method works
				System.out.println(rs1.getInt("PID") + ", " + rs1.getString("name") + ", " + rs1.getDouble("price")
						+ ", " + rs1.getInt("stock"));
				pIdTemp = rs1.getInt("PID");
				nameTemp = rs1.getString("name");
				priceTemp = rs1.getDouble("price");
				stockTemp = rs1.getInt("stock");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Product(pIdTemp, nameTemp, priceTemp, stockTemp);
	}

	public Product readProduct(int pId) {
		String query = "SELECT * FROM products WHERE PID = " + pId;
		ResultSet rs1 = DBConfig.exQuery(query);
		int pIdTemp = 0;
		String nameTemp = null;
		double priceTemp = 0.0;
		int stockTemp = 0;
		try {
			while (rs1.next()) {
				// temporary sout to check method works
				System.out.println(rs1.getInt("PID") + ", " + rs1.getString("name") + ", " + rs1.getDouble("price")
						+ ", " + rs1.getInt("stock"));
				pIdTemp = rs1.getInt("PID");
				nameTemp = rs1.getString("name");
				priceTemp = rs1.getDouble("price");
				stockTemp = rs1.getInt("stock");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Product(pIdTemp, nameTemp, priceTemp, stockTemp);
	}

	// Reads through all the data and returns the data that matches the given name.
	// Need to implement
	public Product findByPID(String name) {
		String query = "SELECT * FROM products WHERE name = " + name;
		ResultSet rs2 = DBConfig.exQuery(query);
		int pIdTemp = 0;
		String nameTemp = null;
		double priceTemp = 0.0;
		int stockTemp = 0;
		try {
			while (rs2.next()) {
				System.out.println(rs2.getInt("PID") + ", " + rs2.getString("name") + ", " + rs2.getDouble("price")
						+ ", " + rs2.getInt("stock"));
				pIdTemp = rs2.getInt("PID");
				nameTemp = rs2.getString("name");
				priceTemp = rs2.getDouble("price");
				stockTemp = rs2.getInt("stock");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Product(pIdTemp, nameTemp, priceTemp, stockTemp);
	}

	// could add a read method that sorts by price lowest to highest and other
	// filters

	// Update product name
	public void updateName(int pId, String name) {
		String query = "UPDATE products SET name = '" + name + "' WHERE PID = " + pId;
		DBConfig.exUpdate(query);
		System.out.println("Product " + pId + "'s name has been updated.");
	}

	// Update product price
	public void updatePrice(int pId, double price) {
		String query = "UPDATE products SET price = '" + price + "' WHERE PID = " + pId;
		DBConfig.exUpdate(query);
		System.out.println("Product " + pId + "'s price has been updated.");
	}

	// Update product stock
	public void updateStock(int pId, int stock) {
		String query = "UPDATE products SET stock = '" + stock + "' WHERE PID = " + pId;
		DBConfig.exUpdate(query);
		System.out.println("Product " + pId + "'s stock has been updated.");
	}

	// Delete part of CRUD functionality
	public void deleteProduct(int pId) {
		String query = "DELETE FROM products WHERE PID = " + pId;
		DBConfig.exUpdate(query);
	}
}
