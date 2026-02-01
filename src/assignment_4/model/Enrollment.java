package assignment_4.model;

import java.time.LocalDateTime;

public class Enrollment {
    private int id;
    private final int studentId;
    private final int courseId;
    private final LocalDateTime enrolledAt;

    public Enrollment(int id, int studentId, int courseId, LocalDateTime enrolledAt) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrolledAt = enrolledAt;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }
    public LocalDateTime getEnrolledAt() { return enrolledAt; }

    public String toDisplayString() {
        return "Enrollment{id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", enrolledAt=" + enrolledAt +
                '}';
    }
}
