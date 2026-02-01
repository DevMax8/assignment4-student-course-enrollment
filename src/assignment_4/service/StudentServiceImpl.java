package assignment_4.service;

import assignment_4.dto.StudentCreateDto;
import assignment_4.model.Student;
import assignment_4.repository.StudentRepository;
import assignment_4.service.interfaces.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo = new StudentRepository();

    @Override
    public Student create(StudentCreateDto dto) {
        return repo.create(new Student(0, dto.name, dto.email, dto.age));
    }

    @Override
    public List<Student> getAll() {
        return repo.findAll();
    }
}
