package com.qa.persistance.models;

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

	public Order(int cId, double value) {
		super();
		this.cId = cId;
		this.value = value;
	}

	public Order(int oId, int cId, double value) {
		super();
		this.oId = oId;
		this.cId = cId;
		this.value = value;
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

	public double calcValue(double price, int quantity) {
		double value = price * quantity;
		return value;
	}

	@Override
	public String toString() {
		return String.format("%d\t%d\t%.2f", oId, cId, value);
	}

}
