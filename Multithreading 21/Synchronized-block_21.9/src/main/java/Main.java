import java.util.ArrayList;

public class Main {
    private static final ArrayList<Double> numbers = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            threads.add(new Thread(Main::someHeavyMethod));
        }
        threads.forEach(Thread::start);

    }

    private static void someHeavyMethod() {
        for(int i = 0; i < 1000000; i++) {
            Double value = Math.random() / Math.random();
            synchronized (numbers) {
                numbers.add(value);
            }
        }
        System.out.println(numbers.size());
        numbers.clear();
    }
}
