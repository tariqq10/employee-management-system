package testing;

import java.sql.SQLException;
import java.util.List;

public class AttendanceManagementSystem {
    private DBConn dbConn;

    public AttendanceManagementSystem(DBConn dbConn) {
        this.dbConn = dbConn;
    }

    // Methods to interact with employees in the database

    public void addEmployee(Employee employee) throws SQLException {
        try {
            dbConn.addEmployee(employee);
        } catch (SQLException e) {
            System.err.println("Failed to add employee: " + e.getMessage());
            throw e;
        }
    }

    public Employee getEmployeeById(String id) throws SQLException {
        try {
            return dbConn.getEmployeeById(id);
        } catch (SQLException e) {
            System.err.println("Failed to get employee by ID: " + e.getMessage());
            throw e;
        }
    }

    public void updateEmployee(Employee employee) throws SQLException {
        try {
            dbConn.updateEmployee(employee);
        } catch (SQLException e) {
            System.err.println("Failed to update employee: " + e.getMessage());
            throw e;
        }
    }

    public void deleteEmployee(String id) throws SQLException {
        try {
            dbConn.deleteEmployee(id);
        } catch (SQLException e) {
            System.err.println("Failed to delete employee: " + e.getMessage());
            throw e;
        }
    }

    // Methods to interact with attendance records in the database

    public void addAttendance(Attendance attendance) throws SQLException {
        try {
            dbConn.addAttendance(attendance);
        } catch (SQLException e) {
            System.err.println("Failed to add attendance: " + e.getMessage());
            throw e;
        }
    }

    public List<Attendance> getAttendanceByEmployeeId(String employeeId) throws SQLException {
        try {
            return dbConn.getAttendanceByEmployeeId(employeeId);
        } catch (SQLException e) {
            System.err.println("Failed to get attendance by employee ID: " + e.getMessage());
            throw e;
        }
    }

    // Methods to interact with departments in the database

    public void addDepartment(Department department) throws SQLException {
        try {
            dbConn.addDepartment(department);
        } catch (SQLException e) {
            System.err.println("Failed to add department: " + e.getMessage());
            throw e;
        }
    }

    public Department getDepartmentByName(String name) throws SQLException {
        try {
            return dbConn.getDepartmentByName(name);
        } catch (SQLException e) {
            System.err.println("Failed to get department by name: " + e.getMessage());
            throw e;
        }
    }

    public void updateDepartment(Department department) throws SQLException {
        try {
            dbConn.updateDepartment(department);
        } catch (SQLException e) {
            System.err.println("Failed to update department: " + e.getMessage());
            throw e;
        }
    }

    public void deleteDepartment(String name) throws SQLException {
        try {
            dbConn.deleteDepartment(name);
        } catch (SQLException e) {
            System.err.println("Failed to delete department: " + e.getMessage());
            throw e;
        }
    }
}
