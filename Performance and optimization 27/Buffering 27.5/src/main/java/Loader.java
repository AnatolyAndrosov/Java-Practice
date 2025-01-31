import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Loader {
    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

//        FileOutputStream writer = new FileOutputStream("res/numbers.txt");
        PrintWriter writer = new PrintWriter("res/numbers.txt");

        char[] letters = {'У', 'K', 'E', 'H', 'X', 'B', 'A', 'P', 'O', 'C', 'M', 'T'};
        int regionCode = 199;



        for (regionCode = 1; regionCode < 100; regionCode++) {
            StringBuilder builder = new StringBuilder();
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char socondLatter : letters) {
                        for (char thirdLatter : letters) {

                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(socondLatter);
                            builder.append(thirdLatter);
                            builder.append(padNumber(regionCode, 2));
                            builder.append('\n');
                        }
                    }
                }
            }
            writer.write(builder.toString());
        }
        writer.flush();
        writer.close();
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }
        return numberStr;
    }
}
