package com.qa.persistance.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	private Customer customer = new Customer(1, "Test First Name", "Test Last Name", "Test Address", "Test City",
			"Test Post Code", "Test Email");

	@Test
	public void getCIdTest() {
		assertEquals(1, customer.getCId());
	}

	@Test
	public void setCIdTest() {
		int cId = 1;
		customer.setCId(cId);
		assertEquals(customer.getCId(), cId);
	}

	@Test
	public void getFirstNameTest() {
		assertEquals("Test First Name", customer.getFirstName());
	}

	@Test
	public void setFirstNameTest() {
		String firstName = "Test First Name";
		customer.setFirstName(firstName);
		assertEquals(customer.getFirstName(), firstName);
	}

	@Test
	public void getLastNameTest() {
		assertEquals("Test Last Name", customer.getLastName());
	}

	@Test
	public void setLastNameTest() {
		String lastName = "Test Last Name";
		customer.setLastName(lastName);
		assertEquals(customer.getLastName(), lastName);
	}

	@Test
	public void getAddressTest() {
		assertEquals("Test Address", customer.getAddress());
	}

	@Test
	public void setAddressTest() {
		String address = "Test Address";
		customer.setAddress(address);
		assertEquals(customer.getAddress(), address);
	}

	@Test
	public void getCityTest() {
		assertEquals("Test City", customer.getCity());
	}

	@Test
	public void setCityTest() {
		String city = "Test City";
		customer.setCity(city);
		assertEquals(customer.getCity(), city);
	}

	@Test
	public void getPostCodeTest() {
		assertEquals("Test Post Code", customer.getPostCode());
	}

	@Test
	public void setPostCodeTest() {
		String postCode = "Test Post Code";
		customer.setPostCode(postCode);
		assertEquals(customer.getPostCode(), postCode);
	}

	@Test
	public void getEmailTest() {
		assertEquals("Test Email", customer.getEmail());
	}

	@Test
	public void setEmailTest() {
		String email = "Test Email";
		customer.setEmail(email);
		assertEquals(customer.getEmail(), email);
	}
}
