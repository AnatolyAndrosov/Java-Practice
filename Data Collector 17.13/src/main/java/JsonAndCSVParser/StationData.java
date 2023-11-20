package JsonAndCSVParser;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static JsonAndCSVParser.CSVParser.csvParser;

@Data
public class StationData {
    private String name;
    private LocalDate data;
    private boolean isUsed;

    public StationData(String name, LocalDate data, boolean isUsed) {
        this.name = name.replace("ё", "е");
        this.data = data;
        this.isUsed = isUsed;
    }
    public static List<StationData> getStationDataList(List<String> foundedFiles) {
        List<StationData> stationDataList = new ArrayList<>();
        for (String file : foundedFiles) {
            if (file.endsWith(".csv")) {
                stationDataList.addAll(csvParser(file));
            }
        }
        return stationDataList;
    }
}
