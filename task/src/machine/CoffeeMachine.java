package machine;
import java.util.*;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cups = scanner.nextInt();
        System.out.println(
                "For " + cups + " cups of coffee you will need:\n" +
                (cups * 200) + " ml of water\n" +
                (cups * 50) + " ml of milk\n" +
                (cups * 15) + " g of coffee beans\n");
    }
}
