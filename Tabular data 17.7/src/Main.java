import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String staffPaths = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {

        ArrayList<Employee> staff = loadStaffFromFile();
        staff.forEach(System.out::println);


    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffPaths));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
                staff.add(new Employee(fragments[0], Integer.parseInt(fragments[1]),
                        LocalDate.parse(fragments[2], formatter)));
            }
            return staff;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

