package assignment_4.controller;

import assignment_4.dto.CourseCreateDto;
import assignment_4.model.Course;
import assignment_4.service.CourseServiceImpl;

import java.util.List;
import java.util.Scanner;

public class CourseController {

    private final CourseServiceImpl service = new CourseServiceImpl();

    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== COURSE MENU ===");
            System.out.println("1) Add course");
            System.out.println("2) List courses");
            System.out.println("0) Back");
            System.out.print("Choose: ");

            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1" -> add(sc);
                case "2" -> list();
                case "0" -> { return; }
                default -> System.out.println("Unknown option");
            }
        }
    }

    private void add(Scanner sc) {
        CourseCreateDto dto = new CourseCreateDto();
        System.out.print("Course name: "); dto.name = sc.nextLine();
        System.out.print("Credits: "); dto.credits = Integer.parseInt(sc.nextLine());

        Course c = service.create(dto);
        System.out.println("CREATED: " + c.toDisplayString());
    }

    private void list() {
        List<Course> list = service.getAll();
        list.forEach(c -> System.out.println(c.toDisplayString()));
    }
}
