import java.util.concurrent.*;

public class Main2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Double> future = service.submit(()->{
            double sum = 0;
            for (int i = 0; i < 10000; i++) {
                sum += Math.random();
            }
            return sum;
        });
        try {
            System.out.println(future.get());
            service.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    }
}
