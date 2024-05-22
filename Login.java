package testing;

import java.sql.SQLException;

public class Login {
    private DBConn dbConn;

    public Login(DBConn dbConn) {
        this.dbConn = dbConn;
    }

    public boolean authenticate(String username, String password) {
        try {
            // Perform authentication logic here
            boolean authenticated = dbConn.authenticateUser(username, password);

            // If authentication is successful, log the login attempt
            if (authenticated) {
                logLoginAttempt(username);
            }

            return authenticated;
        } catch (SQLException e) {
            System.err.println("Failed to authenticate user: " + e.getMessage());
            // Handle the exception (e.g., log it, display an error message, etc.)
            return false; // Authentication failed due to database error
        }
    }

    private void logLoginAttempt(String username) {
        // Log the login attempt to the database
        try {
            dbConn.logLoginAttempt(username);
        } catch (SQLException e) {
            System.err.println("Failed to log login attempt: " + e.getMessage());
            // Handle the exception (e.g., log it, display an error message, etc.)
        }
    }
}
