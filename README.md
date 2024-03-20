# Shop Management System

This Java project is a database management system designed for shopkeepers.
Each product in the system is defined by attributes such as ID, Name, Quantity, and Price.
It provides two main options: one for customers and another for shopkeepers.

# Features of Shopkeeper
- ADD new product
- MODIFY existing product
- DELETE existing product

# Features of Customers
- BUY any product
- RETURN product

<pre> Commonly any one can see list of available procducts </pre>


## Database Connection Setup

To establish a connection with MySQL database, you can use the following syntax:

```java
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    DriverManager.getConnection(URL, USERNAME, PASSWORD);
```

Make sure to replace `your_database_name`, `your_username`, and `your_password` with your actual database details.

## Project Background

Initially, the project was implemented in C without any database connection. It utilized a linked list to store data. Later on, the system was rewritten in Java with a database connection to MySQL for efficient data management and retrieval.

For any further information or assistance, feel free to reach out

Happy shopping and managing your shop efficiently! 🛒🔧
