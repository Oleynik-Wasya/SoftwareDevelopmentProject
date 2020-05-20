package software.development.project.models;

import java.util.*;
import java.util.List;

public class Subject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String semester;
    private String language;
    private String Degree;
    private List<Module> modules;
    private Legend legend;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public Subject(String name, String semester, String language, String degree, List<Module> modules, Set<String> subjects, Legend legend) {
        this.name = name;
        this.semester = semester;
        this.language = language;
        Degree = degree;
        this.modules = modules;
        this.legend = legend;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ",\n semester='" + semester + '\'' +
                ",\n language='" + language + '\'' +
                ",\n Degree='" + Degree + '\'' +
                ",\n modules=" + modules +
                ",\n subjects=" + legend +
                '}';
    }

    public List<Module> getModulesWithSameSemester(Integer semester) {
        List<Module> modules = new ArrayList<>();
        for (Module module : this.modules) {
            if (module.getSemester().equals(semester)) {
                modules.add(module);
            }
        }

        return modules;
    }
}
