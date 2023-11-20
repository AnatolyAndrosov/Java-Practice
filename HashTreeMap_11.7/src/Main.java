import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        HashMap<String, Car> cars = new HashMap<>();
//        cars.put("A765MT77", new Car("A765MT77"));
//        cars.put("E637OO97", new Car("E637OO97"));
//        cars.put("E789KX77", new Car("E789KX77"));
//        cars.put("T372MH199", new Car("T372MH199"));
//
//        System.out.println(cars.get("E637OO97"));
        Basket basket = new Basket();
        basket.add(new Product("Хлеб", 50), 10);
        basket.add(new Product("Масло", 75), 20);
        basket.add(new Product("Молоко", 150), 10);
        basket.add(new Product("Молоко", 75), 30);
        System.out.println(basket);

    }


}