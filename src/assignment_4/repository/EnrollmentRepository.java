package assignment_4.repository;

import assignment_4.DatabaseConnection;
import assignment_4.model.Enrollment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    public Enrollment create(Enrollment e) {
        String sql = "INSERT INTO enrollments(student_id,course_id,enrolled_at) VALUES (?,?,?) RETURNING id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getStudentId());
            ps.setInt(2, e.getCourseId());
            ps.setTimestamp(3, Timestamp.valueOf(e.getEnrolledAt()));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) e.setId(rs.getInt("id"));
            return e;

        } catch (SQLException ex) {
            throw new RuntimeException("Enrollment create failed", ex);
        }
    }

    public List<Enrollment> findAll() {
        String sql = "SELECT id,student_id,course_id,enrolled_at FROM enrollments ORDER BY id";
        List<Enrollment> list = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Enrollment(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getTimestamp("enrolled_at").toLocalDateTime()
                ));
            }
            return list;

        } catch (SQLException ex) {
            throw new RuntimeException("Enrollment findAll failed", ex);
        }
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM enrollments WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            throw new RuntimeException("Enrollment delete failed", ex);
        }
    }
}
