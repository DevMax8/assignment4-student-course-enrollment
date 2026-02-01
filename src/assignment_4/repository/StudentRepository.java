package assignment_4.repository;

import assignment_4.DatabaseConnection;
import assignment_4.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public Student create(Student s) {
        String sql = "INSERT INTO students(name,email,age) VALUES (?,?,?) RETURNING id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setInt(3, s.getAge());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) s.setId(rs.getInt("id"));
            return s;

        } catch (SQLException e) {
            throw new RuntimeException("Student create failed", e);
        }
    }

    public List<Student> findAll() {
        String sql = "SELECT id,name,email,age FROM students ORDER BY id";
        List<Student> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")
                ));
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException("Student findAll failed", e);
        }
    }
}
