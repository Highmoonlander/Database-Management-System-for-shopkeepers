import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Customer {
    static Statement stmt = Supermarket.stmt;
    static void buyProducts() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many items do you want to buy?");
            int itemCount = scanner.nextInt();

            for (int i = 0; i < itemCount; i++) {
                System.out.println("Enter the ID of the product you want to buy:");
                int productId = scanner.nextInt();
                System.out.println("Enter the quantity you want to buy:");
                int quantity = scanner.nextInt();

                // Retrieve product details
                String getProductQuery = "SELECT * FROM products WHERE ID = " + productId;
                ResultSet rs = stmt.executeQuery(getProductQuery);
                if (rs.next()) {
                    int availableQuantity = rs.getInt("Quantity");
                    if (availableQuantity >= quantity) {
                        float price = rs.getFloat("Price");
                        float totalCost = price * quantity;
                        System.out.println("You bought " + quantity + " of " + rs.getString("Name") +
                                " for " + totalCost + " units.");
                        // Update quantity in database
                        String updateQuantityQuery = "UPDATE products SET Quantity = Quantity - " + quantity +
                                " WHERE ID = " + productId;
                        stmt.executeUpdate(updateQuantityQuery);
                    } else {
                        System.out.println("Insufficient quantity of " + rs.getString("Name") + " available.");
                    }
                } else {
                    System.out.println("Product with ID " + productId + " is out of stock.");
                }
                rs.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    //return
    static void returnProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How many items do you want to return?");
            int itemCount = scanner.nextInt();

            for (int i = 0; i < itemCount; i++) {
                System.out.println("Enter the ID of the product you want to return:");
                int productId = scanner.nextInt();
                System.out.println("Enter the quantity you want to return:");
                int quantity = scanner.nextInt();

                // Retrieve product details
                String getProductQuery = "SELECT * FROM products WHERE ID = " + productId;
                ResultSet rs = stmt.executeQuery(getProductQuery);
                if (rs.next()) {
                    float price = rs.getFloat("Price");
                    float totalRefund = price * quantity;
                    System.out.println("You returned " + quantity + " of " + rs.getString("Name") +
                            " and received a refund of " + totalRefund + " units.");
                    // Update quantity in database
                    String updateQuantityQuery = "UPDATE products SET Quantity = Quantity + " + quantity +
                            " WHERE ID = " + productId;
                    stmt.executeUpdate(updateQuantityQuery);
                } else {
                    System.out.println("Product with ID " + productId + " not found.");
                }
                rs.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
