package com.qa.inventorymanagementsystem;

import com.qa.utils.DBConfig;
import com.qa.utils.Scan;

public class MainSystem {

	public static void main(String[] args) {
		DBConfig.connectDB();
		MainSystem.showMenu();
		DBConfig.closeConnection();
	}

	public static void showMenu() {
		int option = 0;
		Menu menu = new Menu();
		Scan userInput = new Scan();

		while (option != 12) {
			menu.shopMenu();
			option = userInput.inputInt();
			System.out.println("\n");

			switch (option) {
			case 1:
				menu.createCustomerMenu();
				break;

			case 2:
				menu.createProductMenu();
				break;

			case 3:
				menu.createOrderMenu();
				break;

			case 4:
				menu.viewCustomersMenu();
				break;

			case 5:
				menu.viewProductsMenu();
				break;

			case 6:
				menu.viewOrdersMenu();
				break;

			case 7:
				menu.updateCustomerMenu();
				break;

			case 8:
				menu.updateProductMenu();
				break;

			case 9:
				menu.deleteCustomerMenu();
				break;

			case 10:
				menu.deleteProductMenu();
				break;

			case 11:
				menu.deleteOrderMenu();
				break;

			case 12:
				break;

			default:
				System.out.println("Invalid option!!! Please enter again.");
			}
		}
	}
}
