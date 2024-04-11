import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Executor executor = Executors.newSingleThreadExecutor();

        executor.execute(()->{
            for(;;) {
                System.out.println(Math.random());
            }
        });
    }
}
