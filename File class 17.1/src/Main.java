import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("data/textdoc.txt");

        System.out.println("length: " + file.length());
        System.out.println("lastModified: " + file.lastModified());

        File folder = new File("C:/users/anatoly");
        File folder1 = new File("C:/users/anatoly/folder1");
        System.out.println("isDirectory: " + folder.isDirectory());

        File[] files = folder.listFiles();

        for(File file1 : files) {
            System.out.println(file1.getAbsolutePath());
        }

        System.out.println("isDirectory folder1: " + folder1.isDirectory());

        folder1.mkdir();
        System.out.println("create folder1");
        System.out.println("isDirectory folder1: " + folder1.isDirectory());
        System.out.println("-------------------");

        files = folder.listFiles();

        for(File file1 : files) {
            System.out.println(file1.getAbsolutePath());
        }

        folder1.delete();
        files = folder.listFiles();

        for(File file1 : files) {
            System.out.println(file1.getAbsolutePath());
        }



    }
}