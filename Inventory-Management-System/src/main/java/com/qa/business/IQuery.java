package com.qa.business;

import java.util.ArrayList;

public interface IQuery {

	// Create method.
	public Object create(Object object);

	// Read method which treats each record as an object and puts them into an array
	// list to return all records in the table.
	public ArrayList<Object> readAll();

	// Read method that returns one record, identified by its unique id (primary
	// key), as an object.
	public Object readRecord(int id);

	// Delete method
	public boolean delete(int id);

}
