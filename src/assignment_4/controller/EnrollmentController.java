package assignment_4.controller;

import assignment_4.dto.EnrollmentCreateDto;
import assignment_4.model.Enrollment;
import assignment_4.service.EnrollmentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class EnrollmentController {

    private final EnrollmentServiceImpl service = new EnrollmentServiceImpl();

    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== ENROLLMENT MENU ===");
            System.out.println("1) Enroll student to course");
            System.out.println("2) List enrollments");
            System.out.println("3) Unenroll by enrollment id");
            System.out.println("0) Back");
            System.out.print("Choose: ");

            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1" -> enroll(sc);
                case "2" -> list();
                case "3" -> unenroll(sc);
                case "0" -> { return; }
                default -> System.out.println("Unknown option");
            }
        }
    }

    private void enroll(Scanner sc) {
        EnrollmentCreateDto dto = new EnrollmentCreateDto();
        System.out.print("Student id: "); dto.studentId = Integer.parseInt(sc.nextLine());
        System.out.print("Course id: "); dto.courseId = Integer.parseInt(sc.nextLine());

        Enrollment e = service.enroll(dto);
        System.out.println("ENROLLED: " + e.toDisplayString());
    }

    private void list() {
        List<Enrollment> list = service.getAll();
        list.forEach(e -> System.out.println(e.toDisplayString()));
    }

    private void unenroll(Scanner sc) {
        System.out.print("Enrollment id: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean ok = service.unenroll(id);
        System.out.println("UNENROLL OK: " + ok);
    }
}
