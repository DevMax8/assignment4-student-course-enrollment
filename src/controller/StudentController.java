package assignment_3.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentController {

    public void printAll(Connection conn) throws Exception {
        String sql = "SELECT id, name, email, age FROM students ORDER BY id";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        "Student{id=" + rs.getInt("id") +
                                ", name='" + rs.getString("name") + "'" +
                                ", email='" + rs.getString("email") + "'" +
                                ", age=" + rs.getInt("age") + "}"
                );
            }
        }
    }
}
