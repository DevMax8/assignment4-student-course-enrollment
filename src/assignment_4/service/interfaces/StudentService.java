package assignment_4.service.interfaces;

import assignment_4.dto.StudentCreateDto;
import assignment_4.model.Student;

import java.util.List;

public interface StudentService {
    Student create(StudentCreateDto dto);
    List<Student> getAll();
}
