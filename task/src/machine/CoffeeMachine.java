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
    int plasticCups;
    int money;

    public CoffeeMachine(int water, int milk, int beans, int plasticCups, int money){
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.plasticCups = plasticCups;
        this.money = money;
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(1200, 540, 120, 9, 550);
        System.out.println(machine);
        machine.chooseAction();
        System.out.println(machine);
    }

    public void chooseAction(){
        String action = input("Write action (buy, fill, take):");
        switch (action.toLowerCase()) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            default:
                System.out.println("No such action!");
        }
    }

    public void buy() {
        int choice;
        try {
            choice = Integer.parseInt(
                    input("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:"));
        } catch (NumberFormatException e) {
            System.out.println("You didn't enter a number. Abort.");
            return;
        }
        switch (choice) {
            case 1:
                makeEspresso();
                break;
            case 2:
                makeLatte();
                break;
            case 3:
                makeCappuccino();
                break;
            default:
                System.out.println("You didn't enter a number between 1 and 3. Abort.");
                return;
        }
    }

    public void fill() {
        try{
            water += Integer.parseInt(input("Write how many ml of water do you want to add:"));
            milk += Integer.parseInt(input("Write how many ml of milk do you want to add:"));
            beans += Integer.parseInt(input("Write how many grams of coffee beans do you want to add:"));
            plasticCups += Integer.parseInt(input("Write how many disposable cups of coffee do you want to add:"));
        } catch (NumberFormatException e){
            System.out.println("That was not a valid number. Abort.");
            return;
        }
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void makeEspresso() {
        plasticCups--;
        water -= 250;
        beans -= 16;
        money += 4;
    }

    public void makeLatte() {
        plasticCups--;
        water -= 350;
        milk -= 75;
        beans -= 20;
        money += 7;
    }

    public void makeCappuccino() {
        plasticCups--;
        water -= 200;
        milk -= 100;
        beans -= 12;
        money += 6;
    }

    //Legacy Code from prvious exercises that might be needed again
    /*
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
     */

    public static String input(String question){
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public String toString(){
        return "The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                plasticCups + " of disposable cups\n" +
                money + " of money";
    }
}
