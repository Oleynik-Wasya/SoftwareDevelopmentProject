package software.development.project.sheet;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.util.*;

public class SheetApiImpl implements SheetApi {

    private FileReader fileReader;
    ;
    private CSVReader csvReader;

    public SheetApiImpl(String fileLocation) {
        try {
            fileReader = new FileReader(fileLocation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        csvReader = new CSVReader(fileReader);
    }

    public Map<Integer, List<String>> read() {

        Map<Integer, List<String>> data = new HashMap<>();

        String[] values = null;
        int i = 0;
        while (true) {
            try {
                if ((values = csvReader.readNext()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            data.put(i++, Arrays.asList(values[0].split(";")));
        }

        return data;
    }

    public void write(Map<Integer, List<String>> date) {

    }
}
