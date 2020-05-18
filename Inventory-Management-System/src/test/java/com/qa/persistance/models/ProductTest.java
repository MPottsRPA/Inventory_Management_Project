package com.qa.persistance.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductTest {

	private Product product = new Product(1, "Test Name", 1.00, 1);

	@Test
	public void getPIdTest() {
		assertEquals(1, product.getPId());
	}

	@Test
	public void setPIdTest() {
		int pId = 1;
		product.setpId(pId);
		assertEquals(product.getPId(), pId);
	}

	@Test
	public void getNameTest() {
		assertEquals("Test Name", product.getName());
	}

	@Test
	public void setNameTest() {
		String name = "Test";
		product.setName(name);
		assertEquals(product.getName(), name);
	}

	@Test
	public void getPriceTest() {
		assertEquals(1.00, product.getPrice(), 0);
	}

	@Test
	public void setPriceTest() {
		double price = 1.00;
		product.setPrice(price);
		assertEquals(product.getPrice(), price, 0);
	}

	@Test
	public void getStockTest() {
		assertEquals(1, product.getStock());
	}

	@Test
	public void setStockTest() {
		int stock = 1;
		product.setStock(stock);
		assertEquals(product.getStock(), stock);
	}
}
