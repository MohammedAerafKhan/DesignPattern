// ShoppingCart.java
// created and implemented by Madhur, tasbi and Aeraf

import java.util.List;
import java.util.ArrayList;

public class ShoppingCart {
    private List<Item> toolItems = new ArrayList<>(); // List to store tool items
    private List<Item> groceryItems = new ArrayList<>(); // List to store grocery items

    public List<Item> getToolItems() {
        return toolItems;
    }

    public List<Item> getGroceryItems() {
        return groceryItems;
    }

    double totalToolCost; // Total cost of tool items
    double totalGroceryCost; // Total cost of grocery items
    private double cartCost; // Total cost of items in the shopping cart

    public ShoppingCart() {
        this.totalToolCost = 0.0;
        this.totalGroceryCost = 0.0;
        this.cartCost = 0.0;
    }

    // Add a tool item to the shopping cart
    public void addtoolItemToCart(Item item) {
        toolItems.add(item);
    }

    // Add a grocery item to the shopping cart
    public void addGroceryItemToCart(Item item) {
        groceryItems.add(item);
    }

    // Print the tool items in the shopping cart
    public void printToolItems() {
        System.out.println("Tool Items:");
        for (Item tool : toolItems) {
            tool.display();
        }
    }

    // Print the grocery items in the shopping cart
    public void printGroceryItems() {
        System.out.println("Grocery Items:");
        for (Item grocery : groceryItems) {
            grocery.display();
        }
    }

    // Calculate the total cost of items in the shopping cart
    public void calculateTotalCartCost() {
        for (Item item : toolItems) {
            double tax = (item.getCost() * 0.14); // Calculate 14% tax for tool items
            this.totalToolCost = item.getCost() + tax;
        }
        for (Item item : groceryItems) {
            this.totalGroceryCost += item.getCost(); // Calculate total cost for grocery items
        }
        this.cartCost = totalToolCost + totalGroceryCost; // Calculate the total cost of the shopping cart
    }

    // Get the total cost of items in the shopping cart
    public double getTotalCost() {
        return cartCost;
    }
}
