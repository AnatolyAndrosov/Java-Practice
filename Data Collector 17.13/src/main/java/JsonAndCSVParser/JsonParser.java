package JsonAndCSVParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonParser {

    public static String getJsonFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path));
            lines.forEach(stringBuilder::append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public static List<StationDepth> jsonParser(String jsonFile) {
        List<StationDepth> stationDepthList;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            stationDepthList = objectMapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return stationDepthList;
    }
}
