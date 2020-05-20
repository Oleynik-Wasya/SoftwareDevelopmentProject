package software.development.project.parser;

import software.development.project.models.Subject;

public interface Parse {
    Subject parseFromCsvToSubject(String fileLocation);
}
