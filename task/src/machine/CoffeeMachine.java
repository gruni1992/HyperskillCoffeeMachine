package machine;
import java.util.*;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
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
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        while (true) {
            machine.chooseAction();
        }
    }

    public void chooseAction(){
        String action = input("Write action (buy, fill, take, remaining, exit):");
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
            case "remaining":
                System.out.println(this.toString());
                break;
            case "exit":
                System.exit(1);
            default:
                System.out.println("No such action!");

        }
    }

    public void buy() {
        String choice = input("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        switch (choice.toLowerCase()) {
            case "1":
                if (ressourcesAvailable(250, 0, 16)){
                    makeCoffee(250, 0, 16,4);
                }
                break;
            case "2":
                if (ressourcesAvailable(350, 75, 20)) {
                    makeCoffee(350, 75, 20, 7);
                }
                break;
            case "3":
                if(ressourcesAvailable(200, 100, 12)) {
                    makeCoffee(200, 100, 12, 6);
                }
                break;
            case "back":
                return;
            default:
                System.out.println("You didn't enter a number between 1 and 3 or back. Abort.");
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

    public void makeCoffee(int neededWater, int neededMilk, int neededBeans, int price){
        plasticCups--;
        water -= neededWater;
        milk -= neededMilk;
        beans -= neededBeans;
        money += price;
    }

    public boolean ressourcesAvailable(int neededWater, int neededMilk, int neededBeans){
        if(plasticCups < 1) {
            System.out.println("Sorry not enough disposable cups");
            return false;
        } if(neededWater > water) {
            System.out.println("Sorry not enough water");
            return false;
        } if(neededMilk > milk) {
            System.out.println("Sorry not enough milk");
            return false;
        } if(neededBeans > beans) {
            System.out.println("Sorry not enough coffee beans");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!");
        return true;
    }

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
