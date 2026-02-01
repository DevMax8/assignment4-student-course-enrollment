package assignment_4.model;

public class Course {
    private int id;
    private final String name;
    private final int credits;

    public Course(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public int getCredits() { return credits; }

    public String toDisplayString() {
        return "Course{id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
