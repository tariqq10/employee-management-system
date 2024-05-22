package testing;

import java.sql.SQLException;

public class Register {
    private DBConn dbConn;

    public Register(DBConn dbConn) {
        this.dbConn = dbConn;
    }

    public void createUser(String username, String password) {
        // Check if the username already exists
        if (userExists(username)) {
            System.out.println("User with username '" + username + "' already exists.");
            return; // Exit the method
        }

        // Register the user in the database
        try {
            dbConn.registerUser(username, password);
            System.out.println("User registered successfully: " + username);
        } catch (SQLException e) {
            System.err.println("Failed to register user: " + e.getMessage());
            // Handle the exception (e.g., log it, display an error message, etc.)
        }
    }

    private boolean userExists(String username) {
        try {
            // Query the database to check if the user already exists
            return dbConn.userExists(username);
        } catch (SQLException e) {
            System.err.println("Failed to check user existence: " + e.getMessage());
            // Handle the exception (e.g., log it, display an error message, etc.)
            return false; // Assume user does not exist in case of an error
        }
    }
}
