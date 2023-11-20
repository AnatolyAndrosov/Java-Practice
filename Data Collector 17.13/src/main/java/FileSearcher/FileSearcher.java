package FileSearcher;

import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
public class FileSearcher {

    private List<String> foundedFiles = new ArrayList<>();
    private final String PATH = "data/stations";


    public boolean checkFileExtension(File file) {
        if (file.isDirectory()) return false;
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".json") || fileName.endsWith(".csv");
    }

    public void fileSearch(String path) {
        File file = new File(path);
        if (file.isFile() && checkFileExtension(file)) {
            foundedFiles.add(file.getPath());
        }
        File[] folders = file.listFiles();
        if (folders != null) {
            for (File folder : folders) {
                fileSearch(folder.getPath());
            }
        }
    }
}
