// RetailStore.java
// created and implemented by Madhur, tasbi and Aeraf

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class RetailStore {
    static Scanner scanner = new Scanner(System.in);
    private static volatile RetailStore instance; // Singleton instance
    private List<Customer> customers = new ArrayList<>(); // List to store customers

    private double totalToolRevenue; // Total revenue from tool items
    private double totalGroceryRevenue; // Total revenue from grocery items

    private RetailStore() {
        totalToolRevenue = 0.0;
        totalGroceryRevenue = 0.0;
    }

    // Singleton pattern: Get or create an instance of the RetailStore
    public static RetailStore getInstance() {
        if (instance == null) {
            instance = new RetailStore();
        }
        return instance;
    }

    // Store a customer in the list of customers
    public void storeCustomerInList(Customer customer) {
        customers.add(customer);
    }

    // Get a list of customers and print their names and cash balances
    public void getListOfCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.getName());
            System.out.println(customer.getCash());
        }
    }

    // Process the checkout for a customer
    public void checkOut(Customer customer) {

        // Check if the customer has enough cash to pay for their purchase.
        if (customer.getCash() < customer.getCart().getTotalCost()) {
            System.out.println("Oh no, you don't have enough cash. How much money would you like to add?");
            while (!scanner.hasNextDouble()) {
                System.out.println("Enter a valid amount of cash!");
                scanner.next();
            }
            double money = scanner.nextDouble();
            customer.addCash(money); // Add more cash if it's not enough
        }

        // Deduct the cost of the purchase from the customer's cash.
        customer.spendCash(customer.getCart().getTotalCost());
        System.out.println("Purchase successful! Your remaining balance is: " + customer.getCash());

        // Update revenue for tool and grocery items
        for (Item tool : customer.getCart().getToolItems()) {
            totalToolRevenue += (tool.getCost() + (tool.getCost() * 0.14)); // Apply 14% tax to tool items
        }
        for (Item grocery : customer.getCart().getGroceryItems()) {
            totalGroceryRevenue += grocery.getCost();
        }
    }

    // Get the total revenue from tool items
    public double getTotalToolRevenue() {
        return totalToolRevenue;
    }

    // Get the total revenue from grocery items
    public double getTotalGroceryRevenue() {
        return totalGroceryRevenue;
    }

    // Calculate the average spending of all customers
    public double getAverageSpending() {
        return (getTotalToolRevenue() + getTotalGroceryRevenue()) / customers.size();
    }

    // Get the total revenue from both tool and grocery items
    public double getTotalRevenue() {
        return (getTotalGroceryRevenue() + getTotalToolRevenue());
    }

    // Calculate the percentage of revenue from tool items
    public double getPercentageToolsRevenue() {
        return (getTotalToolRevenue() / (getTotalToolRevenue() + getTotalGroceryRevenue()) * 100);
    }

    // Calculate the percentage of revenue from grocery items
    public double getPercentageGroceriesRevenue() {
        return (getTotalGroceryRevenue() / (getTotalToolRevenue() + getTotalGroceryRevenue()) * 100);
    }
}
