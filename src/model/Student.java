package assignment_3.model;

public class Student extends BaseEntity {

    private String email;
    private int age;

    public Student(int id, String name, String email, int age) {
        super(id, name);
        this.email = email;
        this.age = age;
    }

    public String getEmail() { return email; }
    public int getAge() { return age; }

    public void setEmail(String email) { this.email = email; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String getEntityType() {
        return "STUDENT";
    }

    public String toDisplayString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "', age=" + age + "}";
    }
}
