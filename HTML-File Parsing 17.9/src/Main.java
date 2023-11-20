import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String htmlFile = parserFile("data/dzen.html");
        String htmlFile = parseFile("data/code.html");

        Document document = Jsoup.parse(htmlFile);
//        Elements elements = document.select("a.mg-card__link");
        Elements elements = document.select("div.ui-product-card-main__wrap");   https://skillbox.ru/courses/
        //<div.ui-product-card-main__wrap"
        elements.forEach(e -> System.out.println(e.text()));
        }

    public static String parseFile(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
