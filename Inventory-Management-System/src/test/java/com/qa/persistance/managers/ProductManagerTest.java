package com.qa.persistance.managers;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.qa.utils.DBConfig;

public class ProductManagerTest {
	// attempting testing wit mockito
	// still in progress

	@Mock
	DBConfig databaseMock;

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Test
	public void testReadAll() {

	}
}
