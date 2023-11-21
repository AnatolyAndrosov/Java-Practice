import FileSearcher.FileSearcher;
import HtmlParser.HTMLParser;
import HtmlParser.Line;
import HtmlParser.Station;
import JsonAndCSVParser.JSONWriter;
import JsonAndCSVParser.StationData;
import JsonAndCSVParser.StationDepth;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        HTMLParser htmlParser = new HTMLParser();
        Document document = htmlParser.getHtmlCode(htmlParser.getURL());
        List<Line> lines = htmlParser.lineParser(document);
        List<Station> stationList = htmlParser.stationParser(document);
        FileSearcher fileSearcher = new FileSearcher();
        fileSearcher.fileSearch(fileSearcher.getPATH());
        List<String> foundedFiles = fileSearcher.getFoundedFiles();
        List<StationData> stationDataList = StationData.getStationDataList(foundedFiles);
        List<StationDepth> stationDepthList = StationDepth.getStationDepthList(foundedFiles);
        List<Station> stations = Station.getStationList(stationList, lines, stationDataList, stationDepthList);
        Map<String, Object> stationMap = new HashMap<>();
        stationMap.put("stations", stations);
        Map<String, Object> lineMap = new HashMap<>();
        for (Line line : lines) {
            List<String> stationsToLineList = new ArrayList<>();
            for (Station station : stations) {
                if (station.getLineNumber().equals(line.getNumber())) stationsToLineList.add(station.getName());
            }
            lineMap.put(line.getNumber(), stationsToLineList);

        }

        Map<String, Object> mskMetro = new HashMap<>();
        mskMetro.put("stations", lineMap);
        mskMetro.put("lines", lines);

        JSONWriter jsonWriter = new JSONWriter();
        jsonWriter.writeJSONToFile(stationMap, "stations.json");
        jsonWriter.writeJSONToFile(mskMetro, "mosmetro.json");

    }
}
