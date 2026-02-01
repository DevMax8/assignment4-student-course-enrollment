package assignment_3.service;

import assignment_3.model.Enrollment;
import assignment_3.repository.EnrollmentRepository;

import java.sql.Connection;
import java.util.List;

public class EnrollmentService {

    private final EnrollmentRepository repo = new EnrollmentRepository();


    public List<Enrollment> getAllEnrollments(Connection conn) throws Exception {
        return repo.findAll(conn);
    }
}