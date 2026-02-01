package assignment_3.repository;

import assignment_3.model.Course;
import assignment_3.model.Enrollment;
import assignment_3.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    public List<Enrollment> findAll(Connection conn) throws Exception {

        String sql =
                "SELECT e.id, e.enrolled_at, " +
                        "s.id AS sid, s.name AS sname, s.email, s.age, " +
                        "c.id AS cid, c.name AS cname, c.credits " +
                        "FROM enrollments e " +
                        "JOIN students s ON e.student_id = s.id " +
                        "JOIN courses c ON e.course_id = c.id";

        List<Enrollment> list = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {


                Student student = new Student(
                        rs.getInt("sid"),
                        rs.getString("sname"),
                        rs.getString("email"),
                        rs.getInt("age")
                );


                Course course = new Course(
                        rs.getInt("cid"),
                        rs.getString("cname"),
                        rs.getInt("credits")
                );


                Enrollment enrollment = new Enrollment(
                        rs.getInt("id"),
                        student,
                        course,
                        rs.getTimestamp("enrolled_at").toLocalDateTime()
                );

                list.add(enrollment);
            }
        }

        return list;
    }
}
