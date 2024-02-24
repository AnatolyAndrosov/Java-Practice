import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        String json = Files.readString(Paths.get("data/person.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        Person person = objectMapper.readValue(json, Person.class);

//        System.out.println(person.getName());

        person.setChildren(List.of("Ольга", "Петр"));
//        System.out.println(person.getChildren());

        Car car = new Car();
        car.setLicensePlate("333333333333");
        person.setCar(car);

        System.out.println(person.getName());

        String newJson = objectMapper.writeValueAsString(person);

        FileWriter fileWriter = new FileWriter("data/personModifier.json");
        fileWriter.write(newJson);
        fileWriter.flush();
        fileWriter.close();




    }
}
