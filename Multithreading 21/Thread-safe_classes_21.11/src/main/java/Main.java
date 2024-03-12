import java.util.ArrayList;
import java.util.Vector;

public class Main {

//    private static Vector<Double> numbers = new Vector<>();
    private static StringBuffer builder = new StringBuffer();

    public static void main(String[] args) {

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
//                    numbers.add(Math.random());
                    builder.append("d");
                }
//                System.out.println(numbers.size());
                System.out.println(builder.length());
            }));
        }
        threads.forEach(Thread::start);

    }
}
