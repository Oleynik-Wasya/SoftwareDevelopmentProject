package software.development.project.models;

public class Module {
    private String name;
    private Integer credits;
    private String semester;
    private String science;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getScience() {
        return science;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public Module(String name, Integer credits, String semester, String science) {
        this.name = name;
        this.credits = credits;
        this.semester = semester;
        this.science = science;
    }

    @Override
    public String toString() {
        return "Module{" +
                "name='" + name + '\'' +
                ", credits=" + credits +
                ", semester='" + semester + '\'' +
                ", science='" + science + '\'' +
                '}';
    }
}
