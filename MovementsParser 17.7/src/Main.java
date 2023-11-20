import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        String regex = "[^a-zA-Z0-9]([a-zA-Z0-9 ]+)[0-9]{2}" +
                "\\.[0-9]{2}\\.[0-9]{2} [0-9]{2}" +
                "\\.[0-9]{2}\\.[0-9]{2}";
        String path = "data/movementList.csv";
        List<String> lines;
        Pattern pattern = Pattern.compile(regex);
        HashMap<String, Double> expenses = new HashMap<>();
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i < lines.size(); i++) {
            String[] fragments = lines.get(i).split(",");
            if (fragments.length != 8) {
                System.out.println("Wrong data format!");
                continue;
            }
            Matcher matcher = pattern.matcher(fragments[5]);
            if (matcher.find()) {
                int start = matcher.start() + 1;
                int end = matcher.end() - 17;
                String key = fragments[5].substring(start, end).trim();
                Double value = Double.parseDouble(fragments[7]);
                if (!expenses.containsKey(key)) {
                    expenses.put(key, value);
                } else {
                    expenses.put(key, expenses.get(key) + value);
                }
            }
        }
        expenses.forEach((key, value) -> System.out.println(key + "\t" + value));

    }
}