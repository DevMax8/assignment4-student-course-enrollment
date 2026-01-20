package assignment_3.controller;

import assignment_3.model.Student;
import assignment_3.service.StudentService;

import java.sql.Connection;
import java.util.List;

public class StudentController {
    private final StudentService service = new StudentService();

    public void printAll(Connection conn) throws Exception {
        List<Student> students = service.getAllStudents(conn);
        for (Student s : students) {
            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail() + " | " + s.getAge());
        }
    }
}
