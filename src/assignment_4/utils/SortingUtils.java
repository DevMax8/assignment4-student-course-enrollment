package assignment_4.utils;

import assignment_4.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingUtils {

    public static List<Student> sortStudentsByAgeAsc(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .collect(Collectors.toList());
    }
}
