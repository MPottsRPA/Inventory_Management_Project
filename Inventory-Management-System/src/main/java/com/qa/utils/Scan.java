package com.qa.utils;

import java.util.Scanner;

public class Scan {

	static Scanner userInput = new Scanner(System.in);

	public String input() {
		String input;
		input = userInput.nextLine();
		return input;
	}

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
