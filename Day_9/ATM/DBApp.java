package ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBApp {
    private static final String URL = "jdbc:postgresql://localhost:5432/atm_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public  Connection getConnection(){

        System.out.println("===  Java + PostgreSQL CLI ===");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println(" Connected to PostgreSQL successfully!\n");
            return  conn;
        } catch (SQLException e) {
            System.err.println(" Database Error: " + e.getMessage());
        } finally {
            //scanner.close();
        }
        return null;
    }

    public  void addAccount(Account account) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            String sql = "INSERT INTO account (user_name, password,balance) VALUES (?, ?,?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, account.getUsername());
                pstmt.setInt(2, account.getPassword());
                pstmt.setDouble(3, account.getBalance());
                pstmt.executeUpdate();
                System.out.println("✅ Account added successfully!\n");
            } catch (SQLException e) {
                System.err.println("❌ Error inserting account: " + e.getMessage());
            }
        }catch (SQLException e) {
            System.err.println(" Database Error: " + e.getMessage());
        }
    }

    public Account getAccountByUserName(String userName)
    {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD))
        {
            String sql = "SELECT user_name,password,balance FROM account WHERE user_name = ?";
            try(PreparedStatement pstmt = conn.prepareStatement(sql))
            {
                pstmt.setString(1, userName);

                try(ResultSet rs = pstmt.executeQuery())
                {
                    if (rs.next())
                    {
                        String name = rs.getString("user_name");
                        int password = rs.getInt("password");
                        int balance = rs.getInt("balance");
                        return new Account(name, password,balance);
                    }
                }

            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    public void addTransaction(Transaction transaction)
    {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO transaction (transaction_type,amount,user_name) VALUES (?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, transaction.getTransactionType());
                pstmt.setInt(2, transaction.getAmount());
                pstmt.setString(3,transaction.getUser_name());
                pstmt.executeUpdate();
                System.out.println("✅ Transaction added successfully!\n");
            } catch (SQLException e) {
                System.err.println("❌ Error inserting transaction: " + e.getMessage());
            }


        }catch (SQLException e) {
            System.err.println(" Database Error: " + e.getMessage());
        }
    }

    public void updateBalance(String userName, int newBalance) {
        String sql = "UPDATE account SET balance = ? WHERE user_name = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, newBalance);
            pstmt.setString(2, userName);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("✅ Balance updated successfully!");
                System.out.println("New balance for " + userName + ": " + newBalance);


            } else {
                System.out.println("❌ User not found: " + userName);
            }

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    public static List<Transaction>getTransactionByUserName(String name)
    {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD))
        {
            String sql = "SELECT transaction_id,transaction_type,amount,user_name FROM transaction WHERE user_name = ?";
            try(PreparedStatement pstmt = conn.prepareStatement(sql))
            {
                pstmt.setString(1, name);
                try(ResultSet rs = pstmt.executeQuery())
                {
                    List<Transaction> transactions = new ArrayList<>();
                    while(rs.next())
                    {
                        Transaction transaction = new Transaction();
                        transaction.setTransactionId(rs.getInt("transaction_id"));
                        transaction.setTransactionType(rs.getString("transaction_type"));
                        transaction.setAmount(rs.getInt("amount"));
                        transaction.setUser_name(rs.getString("user_name"));
                        transactions.add(transaction);
                    }
                    return transactions;
                }

            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
        return null;
    }


    /*
    private static void listProducts(Connection conn) {
        String sql = "SELECT id, name, price FROM products ORDER BY id ASC";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- Product List ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %-15s | Price: $%.2f%n",
                        rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
            }
            System.out.println("---------------------\n");

        } catch (SQLException e) {
            System.err.println("❌ Error reading products: " + e.getMessage());
        }
    }*/
}
