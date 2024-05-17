# Car-Dealership-Management-System--CDMS-
Software Engineering Project made by: Tristan Beason, Jovan Tone, Prohor Muchev &amp; Erol Balkan

Overview:

-The Car Dealership Management System (CDMS) is a comprehensive software solution designed to streamline vehicle inventory management, sales processes, and service operations within a car dealership. The system is built using Java Spring Boot and features an H2 in-memory database.

Running COMMANDS.http:

-To use the commands in the COMMANDS.http file:

1.Using IntelliJ:

-After compiling the main application, simply click the green play button next to any command in the COMMANDS.http file to run it.

2.Using Postman:

-Alternatively, you can copy and paste all of the commands into Postman. All commands are fully functional and include exceptions to ensure correct usage. Some commands are customizable, allowing users to input new data as needed.

Accessing the H2 Database Console:

-A key feature of this project is H2 database support, allowing the entire database to be accessed and modified via SQL commands in an H2 console.

-To use the H2 console:

1.Run the application in IntelliJ.

2.Open your browser and type 'localhost:7777/h2-console'.

3.Ensure the JDBC URL field contains: 'jdbc:h2:mem:vehicle'.

4.The user is 'user', and there is no password.

5.Once logged in, you can input SQL commands into the provided text box. For example, 'SELECT * FROM VEHICLE'; - displays all vehicles in the database.

Code Examples:

Example 1: Adding a New Vehicle

-The following command adds a new vehicle to the inventory:

POST /vehicles

Content-Type: application/json

{

  "model": "Toyota Camry",
  
  "brand": "Toyota",
  
  "color": "Blue",
  
  "price": 25000,
  
  "licensePlate": "ABC1234"
  
}

-This command uses the 'POST' method to add a new vehicle with specified attributes such as model, brand, color, price, and license plate.

Example 2: Retrieving All Vehicles

-The following command retrieves a list of all vehicles in the inventory:

GET /vehicles

-This command uses the GET method to fetch and display all vehicle records from the database, allowing users to view the entire inventory.
