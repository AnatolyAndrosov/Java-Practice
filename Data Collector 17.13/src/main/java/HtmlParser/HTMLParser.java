package HtmlParser;

import lombok.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class HTMLParser {

    private final String URL = "https://skillbox-java.github.io/";

    public Document getHtmlCode(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Line> lineParser(Document htmlDocument) {
        List<Line> lines = new ArrayList<>();
        Elements elements = htmlDocument.select("span.js-metro-line");
        for (Element element : elements) {
            String lineName = element.text();
            String lineNumber = element.attr("data-line");
            Line line = new Line(lineName, lineNumber);
            lines.add(line);
        }
        return lines;
    }

    public List<Station> stationParser(Document htmlDocument) {
        List<Station> stations = new ArrayList<>();
        Elements lineElements = htmlDocument.select("div.js-metro-stations");
        for (Element lineElement : lineElements) {
            String lineNumber = lineElement.attr("data-line");
            Elements stationElements = lineElement.select("p.single-station");
            for (Element stationElement : stationElements) {
                Station station = new Station();
                String stationName = stationElement.select("span.name").text();
                boolean hasConnection = !stationElement.select("span.t-icon-metroln").isEmpty();
                station.setName(stationName);
                station.setLineNumber(lineNumber);
                station.setHasConnection(hasConnection);
                stations.add(station);
            }
        }
        return stations;
    }
}