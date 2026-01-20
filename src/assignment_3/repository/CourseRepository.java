package assignment_3.repository;

import assignment_3.model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    public List<Course> findAll(Connection conn) throws Exception {
        String sql = "SELECT id, name, credits FROM courses ORDER BY id";
        List<Course> list = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("credits")
                ));
            }
        }
        return list;
    }
}
