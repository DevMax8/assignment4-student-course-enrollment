package assignment_4.service;

import assignment_4.dto.EnrollmentCreateDto;
import assignment_4.model.Enrollment;
import assignment_4.repository.EnrollmentRepository;
import assignment_4.service.interfaces.EnrollmentService;

import java.time.LocalDateTime;
import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository repo = new EnrollmentRepository();

    @Override
    public Enrollment enroll(EnrollmentCreateDto dto) {
        return repo.create(new Enrollment(0, dto.studentId, dto.courseId, LocalDateTime.now()));
    }

    @Override
    public List<Enrollment> getAll() {
        return repo.findAll();
    }

    @Override
    public boolean unenroll(int enrollmentId) {
        return repo.deleteById(enrollmentId);
    }
}
