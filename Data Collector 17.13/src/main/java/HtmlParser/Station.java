package HtmlParser;

import JsonAndCSVParser.StationData;
import JsonAndCSVParser.StationDepth;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "line", "data", "depth", "hasConnection" })
//@JsonSerialize(using = DateSerializer.class)
public class Station {

    private String name;
    @JsonIgnore
    private String lineNumber;
    @JsonProperty("line")
    private String lineName;
    private LocalDate data;
    private Double depth;
    private boolean hasConnection;



    public void setName(String name) {
        this.name = name.replace("ё", "е");
    }

    public static List<Station> getStationList(List<Station> stations,
                                               List<Line> lines,
                                               List<StationData> stationDataList,
                                               List<StationDepth> stationDepthList) {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (Station station : stations) {
            for (Line line : lines) {
                if (station.getLineNumber().equals(line.getNumber())) station.setLineName(line.getName());
            }
            for (StationData stationData : stationDataList) {
                if (station.getName().equals(stationData.getName()) && !stationData.isUsed()) {
                    station.setData(stationData.getData());
                    stationData.setUsed(true);
                    stationDataList.stream().filter(s -> s.getName().equals(station.getName()))
                            .filter(s -> s.getData().equals(station.getData()))
                            .peek(s -> s.setUsed(true)).collect(Collectors.toList());
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