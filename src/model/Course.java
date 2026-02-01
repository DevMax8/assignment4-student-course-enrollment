package assignment_3.model;

public class Course extends BaseEntity {

    private int credits;

    public Course(int id, String name, int credits) {
        super(id, name);
        this.credits = credits;
    }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    @Override
    public String getEntityType() {
        return "COURSE";
    }

    public String toDisplayString() {
        return "Course{id=" + id + ", name='" + name + "', credits=" + credits + "}";
    }
}
