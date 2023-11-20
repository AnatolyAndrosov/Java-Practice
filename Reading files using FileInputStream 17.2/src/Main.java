import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;


public class Main {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream inputStream = new FileInputStream("data/info.txt");
            for(;;) {
                int code = inputStream.read();
                if(code < 0) {
                    break;
                }
                char ch = (char) code;
//                System.out.print(ch);
                builder.append(ch);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String string = builder.toString();
        System.out.println(string);

        System.out.println(Charset.defaultCharset());

        String string1;
        try {
            string1 = new String(string.getBytes(), "windows-1251");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(string1);

       
    }

}
