package testing;

import java.sql.SQLException;

public class Employee {
    private String id;
    private String name;
    private String department;
    private boolean registered;

    public Employee(String id, String name, String department, boolean registered) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.registered = registered;
    }

    Employee(String id, String name, String department) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    // Method to save the employee to the database
    public void save() throws SQLException {
        DBConn dbConn = new DBConn();
        try {
            dbConn.addEmployee(this);
        } finally {
            dbConn.close(); // Ensure connection is closed after use
        }
    }

    // Method to update the employee in the database
    public void update() throws SQLException {
        DBConn dbConn = new DBConn();
        try {
            dbConn.updateEmployee(this);
        } finally {
            dbConn.close(); // Ensure connection is closed after use
        }
    }

    // Method to delete the employee from the database
    public void delete() throws SQLException {
        DBConn dbConn = new DBConn();
        try {
            dbConn.deleteEmployee(this.getId());
        } finally {
            dbConn.close(); // Ensure connection is closed after use
        }
    }
}
