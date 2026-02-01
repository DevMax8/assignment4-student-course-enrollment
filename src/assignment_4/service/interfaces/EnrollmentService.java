package assignment_4.service.interfaces;

import assignment_4.dto.EnrollmentCreateDto;
import assignment_4.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment enroll(EnrollmentCreateDto dto);
    List<Enrollment> getAll();
    boolean unenroll(int enrollmentId);
}
