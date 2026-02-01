package assignment_3.service;

import assignment_3.model.Course;
import assignment_3.repository.CourseRepository;

import java.sql.Connection;
import java.util.List;

public class CourseService {

    private final CourseRepository repo = new CourseRepository();

    public List<Course> getAllCourses(Connection conn) throws Exception {
        return repo.findAll(conn);
    }
}