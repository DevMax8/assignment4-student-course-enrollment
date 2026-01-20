package assignment_3.controller;

import assignment_3.model.Course;
import assignment_3.service.CourseService;

import java.sql.Connection;
import java.util.List;

public class CourseController {

    private final CourseService service = new CourseService();

    public void printAll(Connection conn) throws Exception {

        List<Course> list = service.getAllCourses(conn);

        System.out.println("\n--- COURSES ---");

        for (Course c : list) {
            System.out.println(
                    c.getId() + " | " + c.getName() + " | credits=" + c.getCredits()
            );
        }
    }
}

