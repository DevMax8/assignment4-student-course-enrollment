package assignment_3.model;

import java.time.LocalDateTime;

public class Enrollment extends BaseEntity {

    private Student student;   // 🔥 composition
    private Course course;     // 🔥 composition
    private LocalDateTime enrolledAt;

    public Enrollment() {}

    public Enrollment(int id, Student student, Course course, LocalDateTime enrolledAt) {
        super(id, "Enrollment");
        this.student = student;
        this.course = course;
        this.enrolledAt = enrolledAt;
    }

    @Override
    public String getEntityType() {
        return "ENROLLMENT";
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public LocalDateTime getEnrolledAt() { return enrolledAt; }

    public void setStudent(Student student) { this.student = student; }
    public void setCourse(Course course) { this.course = course; }
    public void setEnrolledAt(LocalDateTime enrolledAt) { this.enrolledAt = enrolledAt; }
}
