package com.qa.inventorymanagementsystem;

import java.util.ArrayList;

import com.qa.persistance.managers.CustomerManager;
import com.qa.persistance.managers.OrderManager;
import com.qa.persistance.managers.ProductManager;
import com.qa.persistance.models.Customer;
import com.qa.persistance.models.Order;
import com.qa.persistance.models.Product;
import com.qa.utils.Scan;

public class Menu {

	private CustomerManager customerManager = new CustomerManager();
	private ProductManager productManager = new ProductManager();
	private OrderManager orderManager = new OrderManager();
	private Order order = new Order();
	private Scan userInput = new Scan();

	public void shopMenu() {
		System.out.println("***********************************************************************************\n"
				+ "*                           Welcome to the Cavers Shop!                           *\n"
				+ "***********************************************************************************\n"
				+ "                                       Menu:                                       \n"
				+ "                             1) Create a new customer                              \n"
				+ "                             2) Create a new product                               \n"
				+ "                             3) Create a new order                                 \n"
				+ "                             4) View all customers                                 \n"
				+ "                             5) View all products                                  \n"
				+ "                             6) View all orders                                    \n"
				+ "                             7) Update a customer record                           \n"
				+ "                             8) Update a product record                            \n"
				+ "                             9) Delete an existing customer                        \n"
				+ "                            10) Delete an existing product                         \n"
				+ "                            11) Delete an existing order                           \n"
				+ "                            12) Exit shop                                          \n");
		System.out.println("Please select an option from the menu above: ");
	}

	public void createCustomerMenu() {
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
		System.out.println("The customer record you wish to create is as follows: \n" + "First Name = " + firstName
				+ "\nLast Name = " + lastName + "\nAddress = " + address + "\nCity = " + city + "\nPost Code = "
				+ postCode + "\nEmail = " + email);
		System.out.println("Do you wish to create this customer? (Y/N)");
		String check = userInput.input();
		if (check.equalsIgnoreCase("Y")) {
			customerManager.create(new Customer(0, firstName, lastName, address, city, postCode, email));
			System.out.println("Successfully created a new customer!");
			viewCustomersMenu();
		} else if (check.equalsIgnoreCase("N")) {
			System.out.println(
					"Do you want to: \n1) Reinput values? \n2) Exit create customer menu and go back to the main menu?");
			int check2 = userInput.inputInt();
			if (check2 == 1) {
				createCustomerMenu();
			} else if (check2 == 2) {
				shopMenu();
			} else {
				System.out.println("Invalid input! Please enter again.");
				check2 = userInput.inputInt();
			}
		} else {
			System.out.println("Invalid input! Please enter again.");
			check = userInput.input();
		}
	}

	public void createProductMenu() {
		System.out.println("You have chosen to create a new product.");
		System.out.println("Please enter the name of the product: ");
		String name = userInput.input();
		System.out.println("Please enter the price of the product: ");
		double price = userInput.inputDouble();
		System.out.println("Please enter the quantity of this product: ");
		int stock = userInput.inputInt();
		System.out.println("The product record you wish to create is as follows: \n" + "Name = " + name + "\nPrice = "
				+ price + "\nStock = " + stock);
		System.out.println("Do you wish to create this product? (Y/N)");
		String check = userInput.input();
		if (check.equalsIgnoreCase("Y")) {
			productManager.create(new Product(0, name, price, stock));
			System.out.println("Successfully created a new product!");
			viewProductsMenu();
		} else if (check.equalsIgnoreCase("N")) {
			System.out.println(
					"Do you want to: \n1) Reinput values? \n2) Exit create product menu and go back to the main menu?");
			int check2 = userInput.inputInt();
			if (check2 == 1) {
				createProductMenu();
			} else if (check2 == 2) {
				shopMenu();
			} else {
				System.out.println("Invalid input! Please enter again.");
				check2 = userInput.inputInt();
			}
		} else {
			System.out.println("Invalid input! Please enter again.");
			check = userInput.input();
		}
	}

	public void createOrderMenu() {
		System.out.println("You have chosen to create a new order");
		System.out.println("Please enter your customer ID: ");
		int ordercId = userInput.inputInt();
		double value = 0;
		// String yesNo = "Y";
		// do {
		System.out.println("Please enter the product ID of the product you want to order: ");
		int pId = userInput.inputInt();
		double price = productManager.findPrice(pId);
		System.out.println("The product you have chosen to order is: \n" + productManager.readRecord(pId).toString());
		System.out.println("Please enter how many of this product you want to purchase: ");
		int quantity = userInput.inputInt();
		value = value + order.calcValue(price, quantity);
		System.out.println("The value of your order is " + value);

		// Do you want to add another product to your order?
		// yesNo = inputs Y/N
		// if Y: goes back to top
		// } while (yesNo.equalsIgnoreCase("Y"));

		System.out.println("Do you wish to create this order? (Y/N)");
		String check = userInput.input();
		if (check.equalsIgnoreCase("Y")) {
			orderManager.create(new Order(0, ordercId, value));
			// orderProduct.createOrderProduct(oid, pid, quantity);
			System.out.println("Successfully created a new order!");
			viewOrdersMenu();
		} else if (check.equalsIgnoreCase("N")) {
			System.out.println(
					"Do you want to: \n1) Reinput values? \n2) Exit create order menu and go back to the main menu?");
			int check2 = userInput.inputInt();
			if (check2 == 1) {
				createOrderMenu();
			} else if (check2 == 2) {
				shopMenu();
			} else {
				System.out.println("Invalid input! Please enter again.");
				check2 = userInput.inputInt();
			}
		} else {
			System.out.println("Invalid input! Please enter again.");
			check = userInput.input();
		}
	}

	public void viewCustomersMenu() {
		ArrayList<Object> customerList = customerManager.readAll();
		for (Object o : customerList) {
			Customer c = (Customer) o;
			System.out.println(c.toString());
		}
	}

	public void viewProductsMenu() {
		ArrayList<Object> productList = productManager.readAll();
		for (Object o : productList) {
			Product p = (Product) o;
			System.out.println(p.toString());
		}
	}

	public void viewOrdersMenu() {
		ArrayList<Object> orderList = orderManager.readAll();
		for (Object o : orderList) {
			Order ord = (Order) o;
			System.out.println(ord.toString());
		}
	}

	public void updateCustomerMenu() {
		System.out.println("Please enter the Customer ID for the customer you wish to update the details of: ");
		int cId = userInput.inputInt();
		System.out.println("The customer you have chosen to update is: \n");
		System.out.println(customerManager.readRecord(cId).toString());
		System.out
				.println("What details do you wish to update? \n1) First name \n2) Last name \n3) Address \n4) Email");
		int choice = userInput.inputInt();

		switch (choice) {
		case 1:
			System.out.println("You have chosen to update the customers first name.");
			System.out.println("Please enter the new first name of the customer: ");
			String firstName = userInput.input();
			System.out.println(
					"The customers first name will be changed to: " + firstName + "\nDo you wish to continue? (Y/N)");
			String check = userInput.input();
			if (check.equalsIgnoreCase("Y")) {
				customerManager.updateFirstName(cId, firstName);
				System.out.println(customerManager.readRecord(cId).toString());
			} else if (check.equalsIgnoreCase("N")) {
				System.out.println(
						"Do you want to: \n1)Go back to the update customer menu? \n2)Exit update customer menu and go back to the main menu?");
				int check2 = userInput.inputInt();
				if (check2 == 1) {
					updateCustomerMenu();
				} else if (check2 == 2) {
					shopMenu();
				} else {
					System.out.println("Invalid input! Please enter again.");
					check2 = userInput.inputInt();
				}
			} else {
				System.out.println("Invalid input! Please enter again.");
				check = userInput.input();
			}
			break;

		case 2:
			System.out.println("You have chosen to update the customers last name.");
			System.out.println("Please enter the new last name of the customer: ");
			String lastName = userInput.input();
			System.out.println(
					"The customers last name will be changed to: " + lastName + "\nDo you wish to continue? (Y/N)");
			check = userInput.input();
			if (check.equalsIgnoreCase("Y")) {
				customerManager.updateLastName(cId, lastName);
				System.out.println(customerManager.readRecord(cId).toString());
			} else if (check.equalsIgnoreCase("N")) {
				System.out.println(
						"Do you want to: \n1)Go back to the update customer menu? \n2)Exit update customer menu and go back to the main menu?");
				int check2 = userInput.inputInt();
				if (check2 == 1) {
					updateCustomerMenu();
				} else if (check2 == 2) {
					shopMenu();
				} else {
					System.out.println("Invalid input! Please enter again.");
					check2 = userInput.inputInt();
				}
			} else {
				System.out.println("Invalid input! Please enter again.");
				check = userInput.input();
			}
			break;

		case 3:
			System.out.println("You have chosen to update the customers address.");
			System.out.println("Please enter the new first line of the customers address: ");
			String address = userInput.input();
			System.out.println("Please enter the customers new city: ");
			String city = userInput.input();
			System.out.println("Please enter the customers new post code: ");
			String postCode = userInput.input();
			System.out.println("The customers full address will be changed to: " + address + " " + city + " " + postCode
					+ "\nDo you wish to continue? (Y/N)");
			check = userInput.input();
			if (check.equalsIgnoreCase("Y")) {
				customerManager.updateAddress(cId, address, city, postCode);
				System.out.println(customerManager.readRecord(cId).toString());
			} else if (check.equalsIgnoreCase("N")) {
				System.out.println(
						"Do you want to: \n1)Go back to the update customer menu? \n2)Exit update customer menu and go back to the main menu?");
				int check2 = userInput.inputInt();
				if (check2 == 1) {
					updateCustomerMenu();
				} else if (check2 == 2) {
					shopMenu();
				} else {
					System.out.println("Invalid input! Please enter again.");
					check2 = userInput.inputInt();
				}
			} else {
				System.out.println("Invalid input! Please enter again.");
				check = userInput.input();
			}
			break;

		case 4:
			System.out.println("You have chosen to update the customers email.");
			System.out.println("Please enter the new email of the customer: ");
			String email = userInput.input();
			System.out.println("The customers email will be changed to: " + email + "\nDo you wish to continue? (Y/N)");
			check = userInput.input();
			if (check.equalsIgnoreCase("Y")) {
				customerManager.updateEmail(cId, email);
				System.out.println(customerManager.readRecord(cId).toString());
			} else if (check.equalsIgnoreCase("N")) {
				System.out.println(
						"Do you want to: \n1)Go back to the update customer menu? \n2)Exit update customer menu and go back to the main menu?");
				int check2 = userInput.inputInt();
				if (check2 == 1) {
					updateCustomerMenu();
				} else if (check2 == 2) {
					shopMenu();
				} else {
					System.out.println("Invalid input! Please enter again.");
					check2 = userInput.inputInt();
				}
			} else {
				System.out.println("Invalid input! Please enter again.");
				check = userInput.input();
			}
			break;

		default:
			System.out.println("Invalid option!!! Please enter again.");
		}
	}

	public void updateProductMenu() {
		System.out.println("Please enter the Product ID for the product you wish to update the details of: ");
		int pId = userInput.inputInt();
		System.out.println("The product you have chosen to update is: \n");
		System.out.println(productManager.readRecord(pId).toString());
		System.out.println("What details do you wish to update? \n1) Name \n2) Price \n3) Stock");
		int choice = userInput.inputInt();

		switch (choice) {
		case 1:
			System.out.println("You have chosen to update the products name.");
			System.out.println("Please enter the new name of the product: ");
			String name = userInput.input();
			System.out.println("The products name will be changed to: " + name + "\nDo you wish to continue? (Y/N)");
			String check = userInput.input();
			if (check.equalsIgnoreCase("Y")) {
				productManager.updateName(pId, name);
				System.out.println("Successfully updated the product's name!");
				System.out.println(productManager.readRecord(pId).toString());
			} else if (check.equalsIgnoreCase("N")) {
				System.out.println(
						"Do you want to: \n1)Go back to the update product menu? \n2)Exit update product menu and go back to the main menu?");
				int check2 = userInput.inputInt();
				if (check2 == 1) {
					updateProductMenu();
				} else if (check2 == 2) {
					shopMenu();
				} else {
					System.out.println("Invalid input! Please enter again.");
					check2 = userInput.inputInt();
				}
			} else {
				System.out.println("Invalid input! Please enter again.");
				check = userInput.input();
			}
			break;

		case 2:
			System.out.println("You have chosen to update the products price.");
			System.out.println("Please enter the new price of the product: ");
			double price = userInput.inputDouble();
			System.out.println("The products price will be changed to: " + price + "\nDo you wish to continue? (Y/N)");
			check = userInput.input();
			if (check.equalsIgnoreCase("Y")) {
				productManager.updatePrice(pId, price);
				System.out.println("Successfully updated the product's price!");
				System.out.println(productManager.readRecord(pId).toString());
			} else if (check.equalsIgnoreCase("N")) {
				System.out.println(
						"Do you want to: \n1)Go back to the update product menu? \n2)Exit update product menu and go back to the main menu?");
				int check2 = userInput.inputInt();
				if (check2 == 1) {
					updateProductMenu();
				} else if (check2 == 2) {
					shopMenu();
				} else {
					System.out.println("Invalid input! Please enter again.");
					check2 = userInput.inputInt();
				}
			} else {
				System.out.println("Invalid input! Please enter again.");
				check = userInput.input();
			}
			break;

		case 3:
			System.out.println("You have chosen to update the products stock.");
			System.out.println("Please enter the new stock of the product: ");
			int stock = userInput.inputInt();
			System.out.println("The products name will be changed to: " + stock + "\nDo you wish to continue? (Y/N)");
			check = userInput.input();
			if (check.equalsIgnoreCase("Y")) {
				productManager.updateStock(pId, stock);
				System.out.println("Successfully updated the product's stock!");
				System.out.println(productManager.readRecord(pId).toString());
			} else if (check.equalsIgnoreCase("N")) {
				System.out.println(
						"Do you want to: \n1)Go back to the update product menu? \n2)Exit update product menu and go back to the main menu?");
				int check2 = userInput.inputInt();
				if (check2 == 1) {
					updateProductMenu();
				} else if (check2 == 2) {
					shopMenu();
				} else {
					System.out.println("Invalid input! Please enter again.");
					check2 = userInput.inputInt();
				}
			} else {
				System.out.println("Invalid input! Please enter again.");
				check = userInput.input();
			}
			break;

		default:
			System.out.println("Invalid option!!! Please enter again.");
		}
	}

	public void deleteCustomerMenu() {
		System.out.println("Please enter the Customer ID for the customer you wish to delete from the database: ");
		int cId = userInput.inputInt();
		System.out.println("The customer you have chosen to delete is: \n");
		System.out.println(customerManager.readRecord(cId).toString());
		System.out.println("Do you wish to delete this customer? (Y/N)");
		String check = userInput.input();
		if (check.equalsIgnoreCase("Y")) {
			customerManager.delete(cId);
			System.out.println("Successfully deleted customer!");
			viewCustomersMenu();
		} else if (check.equalsIgnoreCase("N")) {
			System.out.println(
					"Do you want to: \n1) Choose a different customer to delete? \n2) Exit delete customer menu and go back to the main menu?");
			int check2 = userInput.inputInt();
			if (check2 == 1) {
				deleteCustomerMenu();
			} else if (check2 == 2) {
				shopMenu();
			} else {
				System.out.println("Invalid input! Please enter again.");
				check2 = userInput.inputInt();
			}
		} else {
			System.out.println("Invalid input! Please enter again.");
			check = userInput.input();
		}
	}

	public void deleteProductMenu() {
		System.out.println("Please enter the Product ID of the product you wish to delete from the database: ");
		int pId = userInput.inputInt();
		System.out.println("The product you have chosen to delete is: \n");
		System.out.println(productManager.readRecord(pId).toString());
		System.out.println("Do you wish to delete this order? (Y/N)");
		String check = userInput.input();
		if (check.equalsIgnoreCase("Y")) {
			productManager.delete(pId);
			System.out.println("Successfully deleted product!");
			viewProductsMenu();
		} else if (check.equalsIgnoreCase("N")) {
			System.out.println(
					"Do you want to: \n1) Choose a different product to delete? \n2) Exit delete product menu and go back to the main menu?");
			int check2 = userInput.inputInt();
			if (check2 == 1) {
				deleteProductMenu();
			} else if (check2 == 2) {
				shopMenu();
			} else {
				System.out.println("Invalid input! Please enter again.");
				check2 = userInput.inputInt();
			}
		} else {
			System.out.println("Invalid input! Please enter again.");
			check = userInput.input();
		}
	}

	public void deleteOrderMenu() {
		System.out.println("Please enter the Order ID of the order you wish to delete from the database: ");
		int oId = userInput.inputInt();
		System.out.println("The order you have chosen to delete is: \n");
		System.out.println(orderManager.readRecord(oId).toString());
		System.out.println("Do you wish to delete this order? (Y/N)");
		String check = userInput.input();
		if (check.equalsIgnoreCase("Y")) {
			orderManager.delete(oId);
			System.out.println("Successfully deleted order!");
			viewOrdersMenu();
		} else if (check.equalsIgnoreCase("N")) {
			System.out.println(
					"Do you want to: \n1) Choose a different order to delete? \n2) Exit delete order menu and go back to the main menu?");
			int check2 = userInput.inputInt();
			if (check2 == 1) {
				deleteOrderMenu();
			} else if (check2 == 2) {
				shopMenu();
			} else {
				System.out.println("Invalid input! Please enter again.");
				check2 = userInput.inputInt();
			}
		} else {
			System.out.println("Invalid input! Please enter again.");
			check = userInput.input();
		}
	}
}
