import java.io.FileOutputStream;

public class Loader {
    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        FileOutputStream writer = new FileOutputStream("res/numbers.txt");
        char[] letters = {'У', 'K', 'E', 'H', 'X', 'B', 'A', 'P', 'O', 'C', 'M', 'T'};
        for (int number = 1; number < 1000; number++) {
            int regionCode = 199;
            for (char firstLetter : letters) {
                for (char socondLatter : letters) {
                    for (char thirdLatter : letters) {
                        String carNumber = firstLetter + padNumber(number, 3)
                                + socondLatter + thirdLatter + padNumber(regionCode, 2);
                        writer.write(carNumber.getBytes());
                        writer.write('\n');
                    }
                }
            }
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
