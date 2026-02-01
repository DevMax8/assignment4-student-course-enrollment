package assignment_4.service.interfaces;

import assignment_4.dto.CourseCreateDto;
import assignment_4.model.Course;

import java.util.List;

public interface CourseService {
    Course create(CourseCreateDto dto);
    List<Course> getAll();
}
