import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConn {
    private Connection connection;

    // Constructor to initialize the database connection
    public DBConn(Connection connection) {
        this.connection = connection;
    }

    // Methods to interact with employees in the database

    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getDepartment());
            statement.executeUpdate();
        }
    }

    public Employee getEmployeeById(String id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String department = resultSet.getString("department");
                    return new Employee(id, name, department);
                }
            }
        }
        return null;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDepartment());
            statement.setString(3, employee.getId());
            statement.executeUpdate();
        }
    }

    public void deleteEmployee(String id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            statement.executeUpdate();
        }
    }

    // Methods to interact with attendance records in the database

    public void addAttendance(Attendance attendance) throws SQLException {
        String sql = "INSERT INTO attendance (id, date, time, status, employee_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, attendance.getId());
            statement.setDate(2, new java.sql.Date(attendance.getDate().getTime()));
            statement.setString(3, attendance.getTime());
            statement.setString(4, attendance.getStatus());
            statement.setString(5, attendance.getEmployeeId());
            statement.executeUpdate();
        }
    }

    public List<Attendance> getAttendanceByEmployeeId(String employeeId) throws SQLException {
        List<Attendance> attendanceList = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    java.util.Date date = resultSet.getDate("date");
                    String time = resultSet.getString("time");
                    String status = resultSet.getString("status");
                    attendanceList.add(new Attendance(id, date, time, status, employeeId));
                }
            }
        }
        return attendanceList;
    }

    // Methods to interact with departments in the database

    public void addDepartment(Department department) throws SQLException {
        String sql = "INSERT INTO departments (name, location, manager_id) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, department.getName());
            statement.setString(2, department.getLocation());
            statement.setString(3, department.getManagerId());
            statement.executeUpdate();
        }
    }

    public Department getDepartmentByName(String name) throws SQLException {
        String sql = "SELECT * FROM departments WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String location = resultSet.getString("location");
                    String managerId = resultSet.getString("manager_id");
                    return new Department(name, location, managerId);
                }
            }
        }
        return null;
    }

    public void updateDepartment(Department department) throws SQLException {
        String sql = "UPDATE departments SET location = ?, manager_id = ? WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, department.getLocation());
            statement.setString(2, department.getManagerId());
            statement.setString(3, department.getName());
            statement.executeUpdate();
        }
    }

    public void deleteDepartment(String name) throws SQLException {
        String sql = "DELETE FROM departments WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.executeUpdate();
        }
    }
}
