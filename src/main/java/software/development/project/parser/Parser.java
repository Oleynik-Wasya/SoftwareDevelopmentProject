package software.development.project.parser;

import software.development.project.models.Legend;
import software.development.project.models.Module;
import software.development.project.models.Subject;
import software.development.project.sheet.SheetApi;
import software.development.project.sheet.SheetApiImpl;

import java.util.*;

public class Parser implements Parse {
    public Subject parseFromCsvToSubject(String fileLocation) {
        SheetApi sheetApi = new SheetApiImpl(fileLocation);
        Map<Integer, List<String>> data = sheetApi.read();

        String name = data.get(0).get(0);
        String semester = data.get(0).get(1);
        String language = data.get(0).get(2);
        String degree = data.get(0).get(3);

        List<Module> modules = getModules(data);
        Set<String> subjects = getUniqueSubjects(data);

        Legend legend = new Legend(subjects);

        for (Module module : modules)
        {
            module.setColor(legend.getColor(module.getScience()));
        }

        return new Subject(name, semester, language, degree, modules, subjects, legend);
    }

    private List<Module> getModules(Map<Integer, List<String>> data) {

        List<Module> modules = new ArrayList<>();

        for (int i = 2; data.containsKey(i); i++) {
            List<String> row = data.get(i);
            modules.add(new Module(row.get(0), Integer.valueOf(row.get(1)), Integer.valueOf(row.get(2)), row.get(3)));
        }

        return modules;
    }

    private Set<String> getUniqueSubjects(Map<Integer, List<String>> data) {
        Set<String> uniqueSubjects = new HashSet<>();

        for (int i = 2; data.containsKey(i); i++) {
            List<String> row = data.get(i);
            uniqueSubjects.add(row.get(3));
        }

        return uniqueSubjects;
    }
}
