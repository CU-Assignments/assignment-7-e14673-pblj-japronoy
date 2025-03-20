import java.sql.*;

public class StudentController {
    private Connection conn;

    public StudentController() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");
    }

    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO Student (StudentID, Name, Department, Marks) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, student.getStudentID());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getDepartment());
            stmt.setDouble(4, student.getMarks());
            stmt.executeUpdate();
        }
    }

    public void viewStudents() throws SQLException {
        String query = "SELECT * FROM Student";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("StudentID\tName\tDepartment\tMarks");
            while (rs.next()) {
                System.out.println(rs.getInt("StudentID") + "\t" +
                        rs.getString("Name") + "\t" +
                        rs.getString("Department") + "\t" +
                        rs.getDouble("Marks"));
            }
        }
    }
}
