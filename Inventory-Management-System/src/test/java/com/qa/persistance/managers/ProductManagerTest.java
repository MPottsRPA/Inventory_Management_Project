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

import com.qa.persistance.models.Product;

public class ProductManagerTest {

	private Product product;

	private ProductManager productManager;

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
		product = new Product("TestName", 10.00, 1);
		productManager = new ProductManager();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Tear down");
	}

	@Test
	public void testCreate() {
		product.setName("Hello");
		product.setPrice(550.55);
		product.setStock(84);
		productManager.create(product);

		Product diffProduct = new Product("Hello", 550.55, 84);

		ArrayList<Object> productList = productManager.readAll();

		assertEquals("The two products should have same name", diffProduct.getName(),
				((Product) productList.get(productList.size() - 1)).getName());
		assertEquals("The two products should have same price", diffProduct.getPrice(),
				((Product) productList.get(productList.size() - 1)).getPrice(), 0);
		assertEquals("The two products should have same stock", diffProduct.getStock(),
				((Product) productList.get(productList.size() - 1)).getStock());
	}

	@Test
	public void testReadRecord() {
		Object product = productManager.readRecord(1);
		assertEquals("These two products should be the same", product.toString(),
				productManager.readRecord(1).toString());
	}

	@Test
	public void testReadAll() {
		ArrayList<Object> productList = productManager.readAll();
		assertEquals("These two products should be the same", productList.toString(),
				productManager.readAll().toString());
	}

	@Test
	public void testUpdateName() {
		product.setName("Hello");
		ArrayList<Object> productList = productManager.readAll();
		int toUpdatePID = ((Product) productList.get(productList.size() - 1)).getPId();
		assertEquals("Should return true if update successful", true,
				productManager.updateName(toUpdatePID, product.getName()));
	}

	@Test
	public void testUpdatePrice() {
		product.setPrice(25.50);
		ArrayList<Object> productList = productManager.readAll();
		int toUpdatePID = ((Product) productList.get(productList.size() - 1)).getPId();
		assertEquals("Should return true if update successful", true,
				productManager.updatePrice(toUpdatePID, product.getPrice()));
	}

	@Test
	public void testUpdateStock() {
		product.setStock(25);
		ArrayList<Object> productList = productManager.readAll();
		int toUpdatePID = ((Product) productList.get(productList.size() - 1)).getPId();
		assertEquals("Should return true if update successful", true,
				productManager.updateStock(toUpdatePID, product.getStock()));
	}

	@Test
	public void testDelete() {
		productManager.create(product);
		ArrayList<Object> productList = productManager.readAll();
		int toDeletePID = ((Product) productList.get(productList.size() - 1)).getPId();
		assertEquals("Should return true if successfully deleted", true, productManager.delete(toDeletePID));
	}
}
