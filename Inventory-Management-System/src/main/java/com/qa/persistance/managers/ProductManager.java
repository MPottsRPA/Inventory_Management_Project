package com.qa.persistance.managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qa.business.IQuery;
import com.qa.inventorymanagementsystem.DBConfig;
import com.qa.persistance.models.Product;

public class ProductManager implements IQuery {

	// Create method that takes in a product object
	public void create(Object object) {
		if (object instanceof Product) {
			Product product = (Product) object;
			String query = "INSERT INTO products VALUES ('" + product.getPId() + "', '" + product.getName() + "', '"
					+ product.getPrice() + "', '" + product.getStock() + "')";
			DBConfig.exUpdate(query);
		}
	}

	public ArrayList<Object> readAll() {
		ArrayList<Object> productList = new ArrayList<Object>();
		String query = "SELECT * FROM products";
		ResultSet rs = DBConfig.exQuery(query);
		try {
			while (rs.next()) {
				productList.add(
						new Product(rs.getInt("PID"), rs.getString("name"), rs.getDouble("price"), rs.getInt("stock")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	public Product readRecord(int pId) {
		String query = "SELECT * FROM products WHERE PID = " + pId;
		ResultSet rs1 = DBConfig.exQuery(query);
		int pIdTemp = 0;
		String nameTemp = null;
		double priceTemp = 0.0;
		int stockTemp = 0;
		try {
			while (rs1.next()) {
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
	public void delete(int id) {
		String query = "DELETE FROM products WHERE PID = " + id;
		DBConfig.exUpdate(query);
	}
}
