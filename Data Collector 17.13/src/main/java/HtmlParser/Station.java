package HtmlParser;

import JsonAndCSVParser.DateTimeSerializer;
import JsonAndCSVParser.StationData;
import JsonAndCSVParser.StationDepth;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "line", "date", "depth", "hasConnection"})
public class Station {

    private String name;
    @JsonIgnore
    private String lineNumber;
    @JsonProperty("line")
    private String lineName;
    @JsonSerialize(using = DateTimeSerializer.class)
    private LocalDate date;
    private Double depth;
    private boolean hasConnection;


    public void setName(String name) {
        this.name = name.replace("ё", "е");
    }

    public static List<Station> getStationList(List<Station> stations,
                                               List<Line> lines,
                                               List<StationData> stationDataList,
                                               List<StationDepth> stationDepthList) {
        for (Station station : stations) {
            for (Line line : lines) {
                if (station.getLineNumber().equals(line.getNumber())) station.setLineName(line.getName());
            }
            for (StationData stationData : stationDataList) {
                if (station.getName().equals(stationData.getName()) && !stationData.isUsed()) {
                    station.setDate(stationData.getData());
                    stationData.setUsed(true);
                    stationDataList.stream().filter(s -> s.getName().equals(station.getName()))
                            .filter(s -> s.getData().equals(station.getDate()))
                            .forEach(s -> s.setUsed(true));
                    break;
                }
            }
            Double stationDepth = stationDepthList.stream().filter(s -> s.getDepth() != null)
                    .filter(s -> s.getName().equalsIgnoreCase(station.getName()))
                    .min(Comparator.comparingDouble(StationDepth::getDepth))
                    .map(StationDepth::getDepth).orElse(null);
            station.setDepth(stationDepth);
        }
        return stations;
    }
}