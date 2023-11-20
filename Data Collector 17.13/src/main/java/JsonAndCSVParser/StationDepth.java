package JsonAndCSVParser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static JsonAndCSVParser.JsonParser.getJsonFile;
import static JsonAndCSVParser.JsonParser.jsonParser;

@Data
public class StationDepth {
    @JsonProperty("station_name")
    private String name;
    private Double depth;

    public void setDepth(String depth) {
        depth = depth.replace(",", ".");
        this.depth = depth.equals("?") ? null : Double.valueOf(depth);
    }

    public void setName(String name) {
        this.name = name.replace("ё", "е");
    }

    public static List<StationDepth> getStationDepthList(List<String> foundedFiles) {
        List<StationDepth> stationDepthList = new ArrayList<>();
        for (String file : foundedFiles) {
            if (file.endsWith(".json")) {
                stationDepthList.addAll(jsonParser(getJsonFile(file)));
            }
        }
        return stationDepthList;
    }
}
