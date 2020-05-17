package com.qa.inventorymanagementsystem;

import com.qa.persistance.models.Customer;
import com.qa.persistance.models.Order;
import com.qa.persistance.models.Product;
import com.qa.utils.Scan;

public class MainSystem {

	public static void main(String[] args) {
		DBConfig.connectDB();
		MainSystem.showMenu();

	}

	public static void showMenu() {
		int option = 0;
		char yesNo;

		Customer cus = new Customer();
		Product pro = new Product();
		Order ord = new Order();

		Scan userInput = new Scan();

		while (option != 10) {
			System.out.println("***********************************************************************************");
			System.out.println("*                           Welcome to the Cavers Shop!                           *");
			System.out.println("***********************************************************************************");
			System.out.println("                                       Menu:                                       ");
			System.out.println("                             1) Create a new customer                              ");
			System.out.println("                             2) Create a new product                               ");
			System.out.println("                             3) Create a new order                                 ");
			System.out.println("                             4) View all customers                                 ");
			System.out.println("                             5) View all products                                  ");
			System.out.println("                             6) View all orders                                    ");
			System.out.println("                             7) Delete an existing customer                        ");
			System.out.println("                             8) Delete an existing product                         ");
			System.out.println("                             9) Delete an existing order                           ");
			System.out.println("                            10) Exit shop                                          ");
			System.out.println("Please select an option from the menu above: ");
			option = userInput.inputInt();
			System.out.println("\n");

			switch (option) {
			case 1:
				// create customer menu
				System.out.println("You have chosen to create a new customer.");
				System.out.println("Please enter the customers first name: ");
				String firstName = userInput.input();
				System.out.println("Please enter the customers last name: ");
				String lastName = userInput.input();
				System.out.println("Please enter the first line of the customers address: ");
				String address = userInput.input();
				System.out.println("Please enter the customers city: ");
				String city = userInput.input();
				System.out.println("Please enter the customers post code: ");
				String postCode = userInput.input();
				System.out.println("Please enter the customers email: ");
				String email = userInput.input();
				cus.createCustomer(0, firstName, lastName, address, city, postCode, email);
				System.out.println("Successfully created a new customer!");
				cus.readAll();
				System.out.println("Do you want to continue? (Y/N): ");
				yesNo = userInput.inputChar();
				if (yesNo == 'Y' || yesNo == 'y') {
					System.out.println("Valid input!");
					break;
				} else if (yesNo == 'N' || yesNo == 'n') {
					System.out.println("Valid input!");
					option = 10;
					break;
				} else {
					System.out.println("Invalid input!");
				}
				break;

			case 2:
				int pId = 0;
				System.out.println("You have chosen to create a new product.");
				System.out.println("Please enter the name of the product: ");
				String name = userInput.input();
				System.out.println("Please enter the price of the product: ");
				double price = userInput.inputDouble();
				System.out.println("Please enter the quantity of this product: ");
				int stock = userInput.inputInt();
				pro.createProduct(pId, name, price, stock);
				pro.readAll();
				System.out.println("Do you want to continue? (Y/N): ");
				yesNo = userInput.inputChar();
				if (yesNo == 'Y' || yesNo == 'y') {
				} else if (yesNo == 'N' || yesNo == 'n') {
					option = 10;
				} else {
					System.out.println("Invalid input!");
				}
				break;

			case 3:
				int oId = 0;
				System.out.println("You have chosen to create a new order");
				System.out.println("Please enter your customer ID: ");
				int ordercId = userInput.inputInt();
				System.out.println("Please enter the value of the product you want to order: ");
				double value = userInput.inputDouble();
				ord.createOrder(oId, ordercId, value);
				ord.readAll();
				System.out.println("Do you want to continue? (Y/N): ");
				yesNo = userInput.inputChar();
				if (yesNo == 'Y' || yesNo == 'y') {
				} else if (yesNo == 'N' || yesNo == 'n') {
					option = 10;
				} else {
					System.out.println("Invalid input!");
				}
				break;

			case 4:
				cus.readAll();
				System.out.println("Do you want to continue? (Y/N): ");
				yesNo = userInput.inputChar();
				if (yesNo == 'Y' || yesNo == 'y') {
				} else if (yesNo == 'N' || yesNo == 'n') {
					option = 10;
				} else {
					System.out.println("Invalid input!");
				}
				break;

			case 5:
				pro.readAll();
				System.out.println("Do you want to continue? (Y/N): ");
				yesNo = userInput.inputChar();
				if (yesNo == 'Y' || yesNo == 'y') {
				} else if (yesNo == 'N' || yesNo == 'n') {
					option = 10;
				} else {
					System.out.println("Invalid input!");
				}
				break;

			case 6:
				ord.readAll();
				System.out.println("Do you want to continue? (Y/N): ");
				yesNo = userInput.inputChar();
				if (yesNo == 'Y' || yesNo == 'y') {
				} else if (yesNo == 'N' || yesNo == 'n') {
					option = 10;
				} else {
					System.out.println("Invalid input!");
				}
				break;

			case 7:
				System.out.println(
						"Please enter the Customer ID for the customer you wish to delete from the database: ");
				cus.deleteCustomer(userInput.inputInt());
				cus.readAll();
				System.out.println("Do you want to continue? (Y/N): ");
				yesNo = userInput.inputChar();
				if (yesNo == 'Y' || yesNo == 'y') {
				} else if (yesNo == 'N' || yesNo == 'n') {
					option = 10;
				} else {
					System.out.println("Invalid input!");
				}
				break;

			case 8:
				System.out.println("Please enter the Product ID of the product you wish to delete from the database: ");
				pro.deleteProduct(userInput.inputInt());
				pro.readAll();
				System.out.println("Do you want to continue? (Y/N): ");
				yesNo = userInput.inputChar();
				if (yesNo == 'Y' || yesNo == 'y') {
				} else if (yesNo == 'N' || yesNo == 'n') {
					option = 10;
				} else {
					System.out.println("Invalid input!");
				}
				break;

			case 9:
				System.out.println("Please enter the Order ID of the order you wish to delete from the database: ");
				ord.deleteOrder(userInput.inputInt());
				ord.readAll();
				System.out.println("Do you want to continue? (Y/N): ");
				yesNo = userInput.inputChar();
				if (yesNo == 'Y' || yesNo == 'y') {
				} else if (yesNo == 'N' || yesNo == 'n') {
					option = 10;
				} else {
					System.out.println("Invalid input!");
				}
				break;

			case 10:
				break;

			default:
				System.out.println("Invalid option!!! Please enter again.");
			}
		}

		System.out.println("Thankyou for visiting the Cavers Shop!");
	}
}
