package software.development.project.app;

import software.development.project.models.Subject;
import software.development.project.parser.Parser;
import software.development.project.sheet.SheetApiImpl;

import java.util.List;

public class Main {

    public static final String FILE_LOCATION = "Module_overview_BWI_2020.csv";

    public static void main(String[] args) {
        Parser parser = new Parser();
        Subject subject = parser.parseFromCsvToSubject(FILE_LOCATION);
        System.out.println(subject);
    }
}
