package assignment_4.controller;

import java.util.Scanner;

public class AppController {

    private final StudentController studentController = new StudentController();
    private final CourseController courseController = new CourseController();
    private final EnrollmentController enrollmentController = new EnrollmentController();

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1) Students");
            System.out.println("2) Courses");
            System.out.println("3) Enrollments");
            System.out.println("0) Exit");
            System.out.print("Choose: ");

            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1" -> studentController.menu();
                case "2" -> courseController.menu();
                case "3" -> enrollmentController.menu();
                case "0" -> { return; }
                default -> System.out.println("Unknown option");
            }
        }
    }
}
