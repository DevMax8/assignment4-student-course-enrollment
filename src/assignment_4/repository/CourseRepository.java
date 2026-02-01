package assignment_4.repository;

import assignment_4.DatabaseConnection;
import assignment_4.model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    public Course create(Course c) {
        String sql = "INSERT INTO courses(name,credits) VALUES (?,?) RETURNING id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getName());
            ps.setInt(2, c.getCredits());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) c.setId(rs.getInt("id"));
            return c;

        } catch (SQLException e) {
            throw new RuntimeException("Course create failed", e);
        }
    }

    public List<Course> findAll() {
        String sql = "SELECT id,name,credits FROM courses ORDER BY id";
        List<Course> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("credits")
                ));
            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException("Course findAll failed", e);
        }
    }
}
