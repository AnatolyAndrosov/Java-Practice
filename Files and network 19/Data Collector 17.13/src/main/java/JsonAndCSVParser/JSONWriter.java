package JsonAndCSVParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileWriter;
import java.io.IOException;

public class JSONWriter {

    public void writeJSONToFile(Object o, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            String newJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
            FileWriter fileWriter = new FileWriter("data/" + filename);
            fileWriter.write(newJson);
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}