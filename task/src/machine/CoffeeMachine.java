package machine;
import java.util.*;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    final static int NEEDED_WATER = 200;
    final static int NEEDED_MILK = 50;
    final static int NEEDED_BEANS = 15;
    int water;
    int milk;
    int beans;

    public CoffeeMachine(int water, int milk, int beans){
        this.water = water;
        this.milk = milk;
        this.beans = beans;
    }

    public static void main(String[] args) {
        int water = input("Write how many ml of water the coffee machine has:");
        int milk = input("Write how many ml of milk the coffee machine has:");
        int beans = input("Write how many grams of coffee beans the coffee machine has:");
        CoffeeMachine machine = new CoffeeMachine(water, milk, beans);
        int cups = input("Write how many cups of coffee you will need:");
        machine.makeCoffee(cups);
    }

    public void makeCoffee(int cups){
        int maxCups = maxAmount();
        if (ressourcesAvailable(cups)) {
            StringBuilder message = new StringBuilder();
            message.append("Yes, I can make that amount of coffee");
            if (maxCups > cups) {
                message.append(" (and even " + ( maxCups - cups) + " more than that)");
            }
            System.out.println(message.toString());
        } else {
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        }
    }

    public boolean ressourcesAvailable(int cups){
        return (water >= NEEDED_WATER * cups && milk > NEEDED_MILK * cups && beans > NEEDED_BEANS * cups);
    }

    public int maxAmount() {
        int maxWater = water/NEEDED_WATER ;
        int maxMilk = milk/NEEDED_MILK;
        int maxBeans = beans/NEEDED_BEANS;
        //Which one is empty first?
        return Math.min(Math.min(maxWater, maxMilk), maxBeans);
    }

    public static int input(String question){
        System.out.println(question);
        return scanner.nextInt();
    }
}
