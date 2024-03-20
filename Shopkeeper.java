import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Shopkeeper {
    static Connection conn = Supermarket.conn;
    static Statement stmt = Supermarket.stmt;
    static void addProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter product ID:");
            int id = scanner.nextInt();
            System.out.println("Enter product Name:");
            String name = scanner.next();
            System.out.println("Enter product price:");
            float price = scanner.nextFloat();
            System.out.println("Enter product quantity:");
            int quantity = scanner.nextInt();

            String sql = "INSERT INTO products (ID, Name, Price, Quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setFloat(3, price);
            pstmt.setInt(4, quantity);

            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("Product inserted successfully!");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    static void modifyProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter product ID to modify:");
            int id = scanner.nextInt();
            System.out.println("Enter new product Name:");
            String newName = scanner.next();
            System.out.println("Enter new product price:");
            float newPrice = scanner.nextFloat();
            System.out.println("Enter new product quantity:");
            int newQuantity = scanner.nextInt();

            String sql = "UPDATE products SET Name = ?, Price = ?, Quantity = ? WHERE ID = ?";
            PreparedStatement pstmt = stmt.getConnection().prepareStatement(sql);
            pstmt.setString(1, newName);
            pstmt.setFloat(2, newPrice);
            pstmt.setInt(3, newQuantity);
            pstmt.setInt(4, id);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Product modified successfully!");
            } else {
                System.out.println("Product with ID " + id + " not found.");
            }
            pstmt.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    // Method to delete a product
    static void deleteProduct() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter product ID to delete:");
            int id = scanner.nextInt();

            String sql = "DELETE FROM products WHERE ID = ?";
            PreparedStatement pstmt = stmt.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("Product with ID " + id + " not found.");
            }
            pstmt.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
