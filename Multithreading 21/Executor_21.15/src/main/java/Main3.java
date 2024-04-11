import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main3 {
    public static void main(String[] args) {
//        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
//        service.schedule(() -> System.out.println("YES"), 1000, TimeUnit.MILLISECONDS);

//        ScheduledExecutorService service2 = Executors.newScheduledThreadPool(5);
//        service2.scheduleAtFixedRate(() -> System.out.println("YES"),
//                1000, 2000, TimeUnit.MILLISECONDS);

        ScheduledExecutorService service3 = Executors.newScheduledThreadPool(5);
        service3.scheduleWithFixedDelay(() -> System.out.println("YES"),
                1000, 2000, TimeUnit.MILLISECONDS);
    }
}