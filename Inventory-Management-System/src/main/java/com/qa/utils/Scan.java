package com.qa.utils;

import java.util.Scanner;

public class Scan {

	// static so only one exists at a time
	static Scanner userInput = new Scanner(System.in);

	// Import the class and then can use like normal scanner
	// Need to type cast to change it to int, double, etc
	public String input() {
		String input;
		input = userInput.nextLine();
		return input;
	}

	public char inputChar() {
		char input;
		input = userInput.next().charAt(0);
		return input;
	}

	// if don't type cast use this for int and similar for other types
	public int inputInt() {
		int input;
		input = userInput.nextInt();
		userInput.nextLine();
		return input;
	}

	public double inputDouble() {
		double input;
		input = userInput.nextDouble();
		userInput.nextLine();
		return input;
	}
}
