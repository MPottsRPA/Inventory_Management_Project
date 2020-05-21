package com.qa.persistance.managers;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.persistance.models.Order;

public class OrderManagerTest {

	private Order order;

	private OrderManager orderManager;

	private static Connection conn;

	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		System.out.println("Set up before class");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/caverdb?serverTimezone=UTC", "root", "root");
		} catch (SQLException e) {
			System.out.println("Connection Failed.");
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tear down after class");
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error closing database connection!");
			e.printStackTrace();
		}
	}

	@Before
	public void setup() throws Exception {
		System.out.println("Set up");
		order = new Order(1, 100.00);
		orderManager = new OrderManager();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Tear down");
	}

	@Test
	public void testCreate() {
		order.setcId(5);
		order.setValue(150.00);
		orderManager.create(order);

		Order diffOrder = new Order(5, 150.00);

		ArrayList<Object> orderList = orderManager.readAll();

		assertEquals("The two orders should have same CID", diffOrder.getcId(),
				((Order) orderList.get(orderList.size() - 1)).getcId());
		assertEquals("The two orders should have same value", diffOrder.getValue(),
				((Order) orderList.get(orderList.size() - 1)).getValue(), 0);
	}

	@Test
	public void testReadRecord() {
		Object order = orderManager.readRecord(1);
		assertEquals("These two orders should be the same", order.toString(), orderManager.readRecord(1).toString());
	}

	@Test
	public void testReadAll() {
		ArrayList<Object> orderList = orderManager.readAll();
		assertEquals("These should be the same", orderList.toString(), orderManager.readAll().toString());
	}

	@Test
	public void delete() {
		orderManager.create(order);
		ArrayList<Object> orderList = orderManager.readAll();
		int toDeleteOID = ((Order) orderList.get(orderList.size() - 1)).getoId();
		assertEquals("Should return true if successfully deleted", true, orderManager.delete(toDeleteOID));
	}
}
