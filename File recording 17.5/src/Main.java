import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file123 = new File("data/newfile.doc");
        try {
            file123.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            PrintWriter writer = new PrintWriter("data/file.txt");
            for (int i = 0; i < 1000; i++) {
                writer.write(i + "\n");
            }
            writer.flush();
            writer.close();
//            List<String> lines = Files.readAllLines(Paths.get("data/file.txt"));
//            lines.forEach(line -> System.out.println(line));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        folder.delete();
        }

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            strings.add(Integer.toString(i));
        }
        try {
            Files.write(Paths.get("data/file2.txt"), strings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}