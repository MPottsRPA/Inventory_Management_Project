package com.qa.persistance.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.inventorymanagementsystem.DBConfig;

public class Product {
	private int pId;
	private String name;
	private double price;
	private int stock;

	public Product() {
		this.pId = 0;
		this.name = "";
		this.price = 0.0;
		this.stock = 0;
	}

	public Product(int pId, String name, double price, int stock) {
		super();
		this.pId = pId;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	// Create part of the CRUD functionality
	public void createProduct(int pId, String name, double price, int stock) {
		String query = "INSERT INTO products (`name`, `price`, `stock`) VALUES ('" + name + "', '" + price + "', '"
				+ stock + "')";
		DBConfig.exUpdate(query);
	}

	// Reads all the data and returns the results in a product object
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

	// Add update method

	// Delete part of CRUD functionality
	public void deleteProduct(int pId) {
		String query = "DELETE FROM products WHERE PID = " + pId;
		DBConfig.exUpdate(query);
	}

	public int getPId() {
		return pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int quantity) {
		this.stock = quantity;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}

}
