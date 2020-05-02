package software.development.project.sheet;

import java.util.List;
import java.util.Map;

public interface SheetApi {
    Map<Integer, List<String>> read();
    void write(Map<Integer, List<String>> date);
}
