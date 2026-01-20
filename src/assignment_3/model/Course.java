package assignment_3.model;

import assignment_3.dto.Displayable;
import assignment_3.dto.Validatable;

public class Course extends BaseEntity implements Displayable, Validatable {
    private int credits;

    public Course() {}

    public Course(int id, String name, int credits) {
        super(id, name);
        this.credits = credits;
    }

    @Override
    public String getEntityType() {
        return "COURSE";
    }

    @Override
    public void validate() {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Course name is required");
        if (credits <= 0) throw new IllegalArgumentException("Credits must be > 0");
    }

    @Override
    public String toDisplayString() {
        return "Course{id=" + id + ", name='" + name + "', credits=" + credits + "}";
    }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
}
