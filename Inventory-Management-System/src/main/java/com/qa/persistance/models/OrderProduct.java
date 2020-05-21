package com.qa.persistance.models;

public class OrderProduct {
	private int oId;
	private int pId;
	private int quantity;

	public OrderProduct() {
		super();
		this.oId = 0;
		this.pId = 0;
		this.quantity = 0;

	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
