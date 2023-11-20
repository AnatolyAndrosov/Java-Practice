import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
//        try {
//            List<String> lines = Files.readAllLines(Paths.get("data/info.txt"));
//            for(String line : lines) {
//                stringBuilder.append(line + "\n");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            List<String> lines = Files.readAllLines(Paths.get("data/info.txt"));
            lines.forEach(line -> stringBuilder.append(line + "\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringBuilder.toString());
    }
}
