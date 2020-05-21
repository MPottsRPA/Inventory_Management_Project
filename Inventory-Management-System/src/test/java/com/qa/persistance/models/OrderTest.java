package com.qa.persistance.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderTest {

	private Order order = new Order(1, 1, 1.00);

	@Test
	public void testCalcValue() {
		assertEquals(25, order.calcValue(5, 5), 0);
	}

	@Test
	public void getOIdTest() {
		assertEquals(1, order.getoId());
	}

	@Test
	public void setOIdTest() {
		int oId = 1;
		order.setoId(oId);
		assertEquals(order.getoId(), oId);
	}

	@Test
	public void getCIdTest() {
		assertEquals(1, order.getcId());
	}

	@Test
	public void setCIdTest() {
		int cId = 1;
		order.setcId(cId);
		assertEquals(order.getcId(), cId);
	}

	@Test
	public void getValueTest() {
		assertEquals(1.00, order.getValue(), 0);
	}

	@Test
	public void setValueTest() {
		double value = 1.00;
		order.setValue(value);
		assertEquals(order.getValue(), value, 0);
	}
}
