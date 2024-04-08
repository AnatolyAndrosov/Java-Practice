import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Main2 {
    public static void main(String[] args) throws Exception {

        Callable task = ()-> "Hello World!";
        FutureTask<String> futureTask = new FutureTask<>(task);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
