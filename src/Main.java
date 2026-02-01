package assignment_3;

import assignment_3.controller.StudentController;
import assignment_3.model.BaseEntity;
import assignment_3.model.Student;
import assignment_3.utils.DatabaseConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {


        BaseEntity e = new Student(0, "Test", "test@mail.com", 18);
        Student st = (Student) e;

        System.out.println("POLYMORPHISM: " + e.getEntityType() +
                " -> id=" + e.getId() + ", name=" + e.getName());
        System.out.println("DISPLAY: " + st.toDisplayString());

        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("CONNECTED");
            new StudentController().printAll(conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
