// Customer.java
// created and implemented by Madhur, tasbi and Aeraf


import java.util.Objects;
import java.util.Scanner;

public class Customer {
    private double cash;
    public ShoppingCart cart;
    private String name;

    public Customer(String name, double cash) {
        this.name = name;
        this.cash = cash;
        this.cart = new ShoppingCart();
    }

    public void spendCash(double cashToSpend) {
        // Decrease customer's cash after spending
        System.out.println("Cash to spend is: ");
        System.out.println(cashToSpend);
        this.cash -= cashToSpend;
    }

    public void addCash(double cashToAdd) {
        // Add cash to the customer's balance
        this.cash = this.cash + cashToAdd;
    }

    public Double getCash() {
        // Get the customer's current cash balance
        return cash;
    }

    public String getName() {
        // Get the customer's name
        return name;
    }

    public ShoppingCart getCart() {
        // Get the customer's shopping cart
        return this.cart;
    }

    public void fillCart(String fillWith, Item toolinterfaceobject, Item groceryinterfaceobject) {
        // Add items to the customer's shopping cart based on the type (tool or grocery)
        if (Objects.equals(fillWith, "tool")) {
            this.cart.addtoolItemToCart(toolinterfaceobject);
        } else if (Objects.equals(fillWith, "grocery")) {
            this.cart.addGroceryItemToCart(groceryinterfaceobject);
        } else {
            System.out.println("What are you trying to do?");
        }
    }

    public void showCustomer() {
        // Display the customer's name and cash balance
        System.out.println(this.name);
        System.out.println(this.cash);
    }

    public void goShopping() {
        Scanner scanner = new Scanner(System.in);
        int stop = 0;
        int choice;
        int count_tool = 0;
        int count_grocery = 0;
        boolean isTrue = true;
        do {
            System.out.print("What would you like to get?\n1) Toolbox\n2) Grocery bag\n3) Or would you like to checkout? ");

            while (!scanner.hasNextInt()) {
                System.out.println("Enter a valid number!");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (count_tool < 2) {
                        ItemFactory factory;
                        factory = new ToolFactory();
                        Item tool = factory.createItem(scanner);
                        fillCart("tool", tool, null);
                        count_tool = count_tool + 1;
                        stop = stop + 1;
                    } else {
                        System.out.println("Invalid choice. Please choose 'grocery bag' or checkout as you can only choose 2 tools.");
                    }
                    break;
                case 2:
                    if (count_grocery < 2) {
                        ItemFactory factory;
                        factory = new GroceryFactory();
                        Item grocery = factory.createItem(scanner);
                        fillCart("grocery", null, grocery);
                        count_grocery = count_grocery + 1;
                        stop = stop + 1;
                    } else {
                        System.out.println("Invalid choice. Please choose 'toolbox' or checkout as you can only choose 2 grocery items.");
                    }
                    break;
                case 3:
                    isTrue = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 'toolbox' or 'grocery bag'.");
            }

        } while (stop < 4 & isTrue);
    }
}
