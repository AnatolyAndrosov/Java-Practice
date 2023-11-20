package JsonAndCSVParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static List<StationData> csvParser(String path) {
        List<String> lines;
        List<StationData> stationDataList = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(path));
            for (int i = 1; i < lines.size(); i++) {
                String[] fragments = lines.get(i).split(",");
                if (fragments.length != 2) continue;
                LocalDate date = LocalDate.parse(fragments[1], formatter);
                stationDataList.add(new StationData(fragments[0], date, false));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stationDataList;
    }


}
