package assignment_3.model;

import java.time.LocalDateTime;

public class Enrollment extends BaseEntity {

    private Student student;
    private Course course;
    private LocalDateTime enrolledAt;

    public Enrollment(int id, Student student, Course course, LocalDateTime enrolledAt) {
        super(id, "ENROLLMENT");
        this.student = student;
        this.course = course;
        this.enrolledAt = enrolledAt;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String toDisplayString() {
        return "Enrollment{id=" + id +
                ", student=" + student.getName() +
                ", course=" + course.getName() +
                ", enrolledAt=" + enrolledAt + "}";
    }
}
