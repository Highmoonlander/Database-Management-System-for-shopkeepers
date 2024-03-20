import java.sql.*;
import java.util.Scanner;

public class Supermarket {
    // Database connection details
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/supermarket";
    static final String USER = "username";
    static final String PASS = "password";

    static Connection conn = null;
    public static Statement stmt = null;

    // Method to establish database connection
    static void connectToDB() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
    }

    // Method to close database connection
    static void closeDB() {
        try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    // Method to display available products
    static void displayProducts() {
        try {
            String sql = "SELECT * FROM products";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID") +
                        ", Name: " + rs.getString("Name") +
                        ", Price: " + rs.getFloat("Price") +
                        ", Quantity: " + rs.getInt("Quantity"));
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver and connect to database
            connectToDB();

            // Main loop
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nEnter 1 for Shopkeeper portal");
                System.out.println("Enter 2 for Customer portal");
                System.out.println("Enter 0 to exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Shopkeeper portal (already implemented)
                        int shopkeeperChoice;
                        while (true) {
                            System.out.println("\nShopkeeper Portal");
                            System.out.println("1. Add a new product");
                            System.out.println("2. Display all products");
                            System.out.println("3. Modify a product");
                            System.out.println("4. Delete a product");
                            System.out.println("0. Back");
                            System.out.print("Enter choice: ");
                            shopkeeperChoice = scanner.nextInt();

                            switch (shopkeeperChoice) {
                                case 1:
                                    Shopkeeper.addProduct();
                                    break;
                                case 2:
                                    displayProducts();
                                    break;
                                case 3:
                                    Shopkeeper.modifyProduct();
                                    break;
                                case 4:
                                    Shopkeeper.deleteProduct();
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                            if (shopkeeperChoice == 0)
                                break;
                        }
                        break;
                    case 2:
                        // Customer portal
                        System.out.println("\nCustomer Portal");
                        System.out.println("1. View available products");
                        System.out.println("2. Buy products");
                        System.out.println("3. Return products");
                        System.out.println("0. Back");
                        System.out.print("Enter choice: ");
                        int customerChoice = scanner.nextInt();
                        switch (customerChoice) {
                            case 1:
                                displayProducts();
                                break;
                            case 2:
                                Customer.buyProducts();
                                break;
                            case 3:    
                                Customer.returnProduct();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                        break;
                    case 0:
                        closeDB();
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
