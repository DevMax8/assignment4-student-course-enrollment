package assignment_4.service;

import assignment_4.dto.CourseCreateDto;
import assignment_4.model.Course;
import assignment_4.repository.CourseRepository;
import assignment_4.service.interfaces.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final CourseRepository repo = new CourseRepository();

    @Override
    public Course create(CourseCreateDto dto) {
        return repo.create(new Course(0, dto.name, dto.credits));
    }

    @Override
    public List<Course> getAll() {
        return repo.findAll();
    }
}
