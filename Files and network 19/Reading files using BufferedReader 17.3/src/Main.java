import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data/info.txt"));
            for(;;) {
                String line = bufferedReader.readLine();
                if(line == null) {
                    break;
                }
                builder.append(line + "\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(builder.toString());
    }
}