// ItemFactory.java
// created and implemented by Madhur, tasbi and Aeraf.

import java.util.Scanner;

public interface ItemFactory {
    Item createItem(Scanner scanner);
}

interface Item {
    double getCost();
    void display();
}

class Tool implements Item {
    private String name;
    private double cost;

    public Tool(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void display() {
        System.out.printf("%s is a tool and costs $%.2f.%n", name, cost);
    }
}

class Grocery implements Item {
    private String name;
    private double cost;
    private double calories;

    public Grocery(String name, double cost, double calories) {
        this.name = name;
        this.cost = cost;
        this.calories = calories;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void display() {
        System.out.printf("%s is a grocery. It has %.2f calories and costs $%.2f.%n", name, calories, cost);
    }
}

class ToolFactory implements ItemFactory {
    @Override
    public Item createItem(Scanner scanner) {
    Item tool = null;
    int select = 0;
    String name = null;
    double cost;

    do {
        System.out.println();
        System.out.println("Enter 1 for a hammer, or");
        System.out.println("Enter 2 for a screwdriver.");
        System.out.print("Selection: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Enter a valid number!");
            scanner.next();
        }
        select = scanner.nextInt();
        scanner.nextLine();

        switch (select) {
            case 1:
                System.out.print("What is the hammer's name? ");
                name = scanner.nextLine();
                System.out.print("How much does this hammer cost? $");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Enter a valid cost!");
                    scanner.next();
                }
                cost = scanner.nextDouble();
                tool = new Hammer(name, cost);
                break;
            case 2:
                System.out.print("What is the screwdriver's name? ");
                name = scanner.nextLine();
                System.out.print("How much does this screwdriver cost? $");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Enter a valid cost!");
                    scanner.next();
                }
                cost = scanner.nextDouble();
                tool = new Screwdriver(name, cost);
                break;
            default:
                System.out.println("Invalid selection, try again!");
        }
    } while (select < 1 || select > 2); // Repeat for an invalid selection

    return tool;
    }
}


class GroceryFactory implements ItemFactory {
    @Override
    public Item createItem(Scanner scanner) {
    Item grocery = null;
    int select = 0;
    String name = null;
    double cost;
    double calories;
    do {
        System.out.println();
        System.out.println("Enter 1 for an apple, or");
        System.out.println("Enter 2 for an orange.");
        System.out.print("Selection: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Enter a valid number!");
            scanner.next();
        }
        select = scanner.nextInt();
        scanner.nextLine();

        switch (select) {
            case 1:
                System.out.print("What is the apple's name? ");
                name = scanner.nextLine();
                System.out.print("How many calories does this apple have? ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Enter a valid number of calories!");
                    scanner.next();
                }
                calories = scanner.nextDouble();
                System.out.print("How much does this apple cost? $");
                while (!scanner.hasNextInt()) {
                    System.out.println("Enter a valid cost!");
                    scanner.next();
                }
                cost = scanner.nextDouble();
                grocery = new Apple(name, cost, calories);
                grocery.getCost();
                break;
            case 2:
                System.out.print("What is the orange's name? ");
                name = scanner.nextLine();
                System.out.print("How many calories does this orange have? ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Enter a valid number of calories!");
                    scanner.next();
                }
                calories = scanner.nextDouble();
                System.out.print("How much does this orange cost? $");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Enter a valid cost!");
                    scanner.next();
                }
                cost = scanner.nextDouble();
                grocery = new Orange(name, cost, calories);
                break;
            default:
                System.out.println("Invalid selection, try again!");
        }
    } while (select < 1 || select > 2); // Repeat for an invalid selection

    return grocery;
    }
}

class Hammer implements Item {
    private String name;
    private double cost;

    public Hammer(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void display() {
        System.out.printf("%s is a hammer and costs $%.2f.%n", name, cost);
    }
}

class Screwdriver implements Item {
    private String name;
    private double cost;

    public Screwdriver(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void display() {
        System.out.printf("%s is a screwdriver and costs $%.2f.%n", name, cost);
    }
}


class Apple implements Item {
    private String name;
    private double cost;
    private double calories;

    public Apple(String name, double cost, double calories) {
        this.name = name;
        this.cost = cost;
        this.calories = calories;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void display() {
        System.out.printf("%s is an apple. It has %.2f calories and costs $%.2f.%n", name, calories, cost);
    }
}

class Orange implements Item {
    private String name;
    private double cost;
    private double calories;

    public Orange(String name, double cost, double calories) {
        this.name = name;
        this.cost = cost;
        this.calories = calories;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void display() {
        System.out.printf("%s is an orange. It has %.2f calories and costs $%.2f.%n", name, calories, cost);
    }
}