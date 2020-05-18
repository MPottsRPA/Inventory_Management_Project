package com.qa.persistance.models;

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

	public int getPId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
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
