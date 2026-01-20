package assignment_3.controller;

import assignment_3.model.Enrollment;
import assignment_3.service.EnrollmentService;

import java.sql.Connection;
import java.util.List;

public class EnrollmentController {

    private final EnrollmentService service = new EnrollmentService();

    public void printAll(Connection conn) throws Exception {

        List<Enrollment> list = service.getAllEnrollments(conn);

        System.out.println("\n--- ENROLLMENTS (Student -> Course) ---");

        if (list.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }

        for (Enrollment e : list) {
            System.out.println(
                    "Enrollment#" + e.getId()
                            + " | Student: " + e.getStudent().getId() + " - " + e.getStudent().getName()
                            + " | Course: " + e.getCourse().getId() + " - " + e.getCourse().getName()
                            + " | at: " + e.getEnrolledAt()
            );
        }
    }
}
