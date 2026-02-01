package assignment_4.controller;

import assignment_4.dto.StudentCreateDto;
import assignment_4.model.Student;
import assignment_4.service.StudentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class StudentController {

    private final StudentServiceImpl service = new StudentServiceImpl();

    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== STUDENT MENU ===");
            System.out.println("1) Add student");
            System.out.println("2) List students");
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
        StudentCreateDto dto = new StudentCreateDto();
        System.out.print("Name: "); dto.name = sc.nextLine();
        System.out.print("Email: "); dto.email = sc.nextLine();
        System.out.print("Age: "); dto.age = Integer.parseInt(sc.nextLine());

        Student s = service.create(dto);
        System.out.println("CREATED: " + s.toDisplayString());
    }

    private void list() {
        List<Student> list = service.getAll();
        list.forEach(s -> System.out.println(s.toDisplayString()));
    }
}
