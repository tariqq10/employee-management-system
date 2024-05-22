package testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Attendance {
    private String id;
    private Date date;
    private String time;
    private String status;
    private String employeeId;

    public Attendance(String id, Date date, String time, String status, String employeeId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.status = status;
        this.employeeId = employeeId;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // CRUD methods

    // Create
    public void addAttendanceRecord(DBConn dbConn) throws SQLException {
        try (Connection connection = dbConn.getConnection()) {
            String sql = "INSERT INTO attendance (id, date, time, status, employee_id) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, id);
                statement.setDate(2, new java.sql.Date(date.getTime()));
                statement.setString(3, time);
                statement.setString(4, status);
                statement.setString(5, employeeId);
                statement.executeUpdate();
            }
        }
    }

    // Read
    public static List<Attendance> getAllAttendanceRecords(DBConn dbConn) throws SQLException {
        List<Attendance> attendanceRecords = new ArrayList<>();
        try (Connection connection = dbConn.getConnection()) {
            String sql = "SELECT * FROM attendance";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    Date date = resultSet.getDate("date");
                    String time = resultSet.getString("time");
                    String status = resultSet.getString("status");
                    String employeeId = resultSet.getString("employee_id");
                    Attendance attendance = new Attendance(id, date, time, status, employeeId);
                    attendanceRecords.add(attendance);
                }
            }
        }
        return attendanceRecords;
    }

    // Update
    public void updateAttendanceRecord(DBConn dbConn) throws SQLException {
        try (Connection connection = dbConn.getConnection()) {
            String sql = "UPDATE attendance SET date = ?, time = ?, status = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDate(1, new java.sql.Date(date.getTime()));
                statement.setString(2, time);
                statement.setString(3, status);
                statement.setString(4, id);
                statement.executeUpdate();
            }
        }
    }

    // Delete
    public void deleteAttendanceRecord(DBConn dbConn) throws SQLException {
        try (Connection connection = dbConn.getConnection()) {
            String sql = "DELETE FROM attendance WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, id);
                statement.executeUpdate();
            }
        }
    }
}
