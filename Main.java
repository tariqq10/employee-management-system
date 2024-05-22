package testing;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Establish database connection
            DBConn dbConn = new DBConn();

            // Example usage:
            // Add new employee
            Employee employee = new Employee("123", "John Doe", "IT");
            employee.save();

        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}
