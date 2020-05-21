#Caving Equipment Store Inventory Management Project
Solo inventory management project due end of week 5 @ QAC RPA Course

#Contents
[`Project Brief`](#Project-Brief)
- [`Constraints`](#Constraints)
[`Plan`](#Plan)
[`Database Structure`](#Database Structure)
[`Risk Assessment`](#Risk Assessment)
[`Future Improvements`](#Future Improvements)
[`Author`](#Author)
[`Acknowledgements`](#Acknowledgements)
________________________________________________________________________________________________________________________________

#Project Brief
To build an application in Java that an end user can interact with via a CLI (Command Line Interface). The application needs to be an inventory management system that needs to be able to perform CRUD SQL statements that interact with a database. This database must have a customer, product and order table.

##Constraints
- A Kanban board with full expansion on user stories and tasks needed to complete the project. It should also provide a record of any issues or risks that you faced creating your project. 
- A relational database used to store data persistently for the project, this database needs to have at least 3 tables in it, to demonstrate your understanding, you are also required to model a relationship.
- A functional application, following best practices and design principles, in Java that meets the requirements set on your Kanban Board. 
- Unit tests and integration tests for validation of the application. You must strive to provide high test coverage.
- Code fully integrated into a Version Control System (GitLab / GitHub). 

________________________________________________________________________________________________________________________________

#Plan
I used a [Kanban Board](https://trello.com/b/lTUWwrPY/inventorymanagementsystem) created in Trello to track my progress throughout this project. 

#Database Structure
![Entity Relationship Diagram](https://github.com/MPottsRPA/Inventory_Management_Project/blob/master/ERD2.PNG)


#Risk Assessment

________________________________________________________________________________________________________________________________

#Future Improvements
Create an orderLine table which would deal with the many to many relationship between the orders and products tables.  
At the moment I can only add one product of a specified quantity to an order, so implementing orderLine would allow for multiple products to be included in an order. I could also specify the quantity of each of these products and have a quantity column in the orderLine table.  
I would also add in the ability to log in as either a customer or an admin. I could then give these users different levels of permissions which would affect what they can do with the application. A customer would only need to be able to create their account for the first time, view all products, view their own details, make an order and update their details. An admin would have access to most features of the application but may not need to be able to create an order or create a customer.  

________________________________________________________________________________________________________________________________

#Author
Melissa Potts

________________________________________________________________________________________________________________________________

#Acknowledgements

(other sections to be added as needed)
