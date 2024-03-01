import java.util.concurrent.atomic.AtomicInteger;

public class ValueStorage {
//    private static int value;

    private static AtomicInteger value = new AtomicInteger();
    public static void incrementValue() {
//        value +=1;
        value.incrementAndGet();
    }

    public static int getValue() {
//        return value;
        return value.intValue();
    }
}
