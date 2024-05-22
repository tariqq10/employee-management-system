package testing;

import java.sql.SQLException;

public class Department {
    private String name;
    private String location;
    private String managerId;

    public Department(String name, String location, String managerId) {
        this.name = name;
        this.location = location;
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    // Method to save the department to the database
    public void save() throws SQLException {
        DBConn dbConn = new DBConn();
        try {
            dbConn.addDepartment(this);
        } finally {
            dbConn.close(); // Ensure connection is closed after use
        }
    }

    // Method to update the department in the database
    public void update() throws SQLException {
        DBConn dbConn = new DBConn();
        try {
            dbConn.updateDepartment(this);
        } finally {
            dbConn.close(); // Ensure connection is closed after use
        }
    }

    // Method to delete the department from the database
    public void delete() throws SQLException {
        DBConn dbConn = new DBConn();
        try {
            dbConn.deleteDepartment(this.getName());
        } finally {
            dbConn.close(); // Ensure connection is closed after use
        }
    }
}
