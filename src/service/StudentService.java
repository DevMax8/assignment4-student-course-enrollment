package assignment_3.service;

import assignment_3.model.Student;
import assignment_3.repository.StudentRepository;

import java.sql.Connection;
import java.util.List;

public class StudentService {
    private final StudentRepository repo = new StudentRepository();

    public List<Student> getAllStudents(Connection conn) throws Exception {
        return repo.findAll(conn);
    }
}