package software.development.project.draw;

import software.development.project.models.Legend;
import software.development.project.models.Module;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SubjectDrawApi {
    void drawSemester(int number, List<Module> modules, Legend legend);
    void drawLegend(Legend legend);
}
