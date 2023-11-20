package JsonAndCSVParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JSONWriter {

    public String writeJSONToFile(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            String newJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
            return newJson;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}