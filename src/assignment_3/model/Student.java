package assignment_3.model;

import assignment_3.dto.Displayable;
import assignment_3.dto.Validatable;

public class Student extends BaseEntity implements Displayable, Validatable {
    private String email;
    private int age;

    public Student() {}

    public Student(int id, String name, String email, int age) {
        super(id, name);
        this.email = email;
        this.age = age;
    }

    @Override
    public String getEntityType() {
        return "STUDENT";
    }

    @Override
    public void validate() {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email is required");
        if (age <= 0) throw new IllegalArgumentException("Age must be > 0");
    }

    @Override
    public String toDisplayString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', age=" + age + "}";
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
