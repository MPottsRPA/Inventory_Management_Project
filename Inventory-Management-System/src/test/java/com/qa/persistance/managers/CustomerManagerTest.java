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

import com.qa.persistance.models.Customer;

public class CustomerManagerTest {

	private Customer customer;

	private CustomerManager customerManager;

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
		customer = new Customer("TestfName", "TestlName", "TestAddress", "TestCity", "000 000", "TestEmail");
		customerManager = new CustomerManager();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Tear down");
	}

	@Test
	public void testCreate() {
		customer.setFirstName("Hello");
		customer.setLastName("World");
		customer.setAddress("Address");
		customer.setCity("City");
		customer.setPostCode("WF10 1PU");
		customer.setEmail("helloworld@gmail.com");
		customerManager.create(customer);

		Customer diffCustomer = new Customer("Hello", "World", "Address", "City", "WF10 1PU", "helloworld@gmail.com");

		ArrayList<Object> customerList = customerManager.readAll();

		assertEquals("The two customers should have same first name", diffCustomer.getFirstName(),
				((Customer) customerList.get(customerList.size() - 1)).getFirstName());
		assertEquals("The two customers should have same last name", diffCustomer.getLastName(),
				((Customer) customerList.get(customerList.size() - 1)).getLastName());
		assertEquals("The two customers should have same address", diffCustomer.getAddress(),
				((Customer) customerList.get(customerList.size() - 1)).getAddress());
		assertEquals("The two customers should have same city", diffCustomer.getCity(),
				((Customer) customerList.get(customerList.size() - 1)).getCity());
		assertEquals("The two customers should have same post code", diffCustomer.getPostCode(),
				((Customer) customerList.get(customerList.size() - 1)).getPostCode());
		assertEquals("The two customers should same email", diffCustomer.getEmail(),
				((Customer) customerList.get(customerList.size() - 1)).getEmail());
	}

	@Test
	public void testReadRecord() {
		Object customer = customerManager.readRecord(1);
		assertEquals("These two customers should be the same", customer.toString(),
				customerManager.readRecord(1).toString());
	}

	@Test
	public void testReadAll() {
		ArrayList<Object> customerList = customerManager.readAll();
		assertEquals("These should be the same", customerList.toString(), customerManager.readAll().toString());
	}

	@Test
	public void testUpdateFirstName() {
		customer.setFirstName("Hello");
		ArrayList<Object> customerList = customerManager.readAll();
		int toUpdateCID = ((Customer) customerList.get(customerList.size() - 1)).getCId();
		assertEquals("Should return true if update successful", true,
				customerManager.updateFirstName(toUpdateCID, customer.getFirstName()));
	}

	@Test
	public void testUpdateLastName() {
		customer.setLastName("World");
		ArrayList<Object> customerList = customerManager.readAll();
		int toUpdateCID = ((Customer) customerList.get(customerList.size() - 1)).getCId();
		assertEquals("Should return true if update successful", true,
				customerManager.updateLastName(toUpdateCID, customer.getLastName()));
	}

	@Test
	public void testUpdateAddress() {
		customer.setAddress("111 NewStreet");
		customer.setCity("NewCity");
		customer.setPostCode("WF10 1PU");
		ArrayList<Object> customerList = customerManager.readAll();
		int toUpdateCID = ((Customer) customerList.get(customerList.size() - 1)).getCId();
		assertEquals("Should return true if update successful", true, customerManager.updateAddress(toUpdateCID,
				customer.getAddress(), customer.getCity(), customer.getPostCode()));
	}

	@Test
	public void testUpdateEmail() {
		customer.setEmail("testemail@gmail.com");
		ArrayList<Object> customerList = customerManager.readAll();
		int toUpdateCID = ((Customer) customerList.get(customerList.size() - 1)).getCId();
		assertEquals("Should return true if update successful", true,
				customerManager.updateEmail(toUpdateCID, customer.getEmail()));
	}

	@Test
	public void testDelete() {
		customerManager.create(customer);
		ArrayList<Object> customerList = customerManager.readAll();
		int toDeleteCID = ((Customer) customerList.get(customerList.size() - 1)).getCId();
		assertEquals("Should return true if successfully deleted", true, customerManager.delete(toDeleteCID));
	}
}
