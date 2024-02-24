import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.print.DocFlavor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {

        String url = "https://skillbox.ru/";
        Document document = Jsoup.connect(url).get();
        Elements images = document.select("img");
        HashSet<String> links = new HashSet<>();
        images.forEach(i -> links.add(i.attr("abs:src")));

        int number = 1;

        for (String link : links) {
            String extension = link
                    .replaceAll("^.+\\.", "")
                    .replace("?.+$", "");
            String filePath = "data/" + number++ + "." + extension;
            try {
                download(link, filePath);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    private static void download(String link, String filePath) throws Exception {
        URLConnection connection = new URL(link).openConnection();
        InputStream inputStream = connection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        int b;
        while ((b = inputStream.read()) != -1) {
            fileOutputStream.write(b);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();

    }
}
