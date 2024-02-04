// TestProgramMain.java
// created and implemented by Madhur, tasbi and Aeraf

import java.util.Scanner;

public class TestProgramMain {
    static Scanner scanner = new Scanner(System.in);
    static RetailStore walmart = RetailStore.getInstance();

    public static void main(String[] args) {

        System.out.println("Welcome to the Walmart");
        Customer[] customers = new Customer[3];

        for (int i = 0; i < customers.length; i++) {
            customers[i] = getDetails();
//            customers[i].showCustomer();      // Checking if the customer is being created properly in the customer class
            walmart.storeCustomerInList(customers[i]);
//            walmart.getListOfCustomers();    // Checking if the customer is properly getting stored in the customer list of walmart


            System.out.println("Enjoy shopping with us today");
            customers[i].goShopping();      // Main execution of the customer shopping simulation

//            customers[i].cart.printGroceryItems();    // printing the contents of the grocery list in cart
//            customers[i].cart.printToolItems();       // printing the contents of the tools list in cart

            System.out.println("The total amount is:");
            customers[i].cart.calculateTotalCartCost();
            System.out.println(customers[i].cart.getTotalCost());

            walmart.checkOut(customers[i]);
        }

        System.out.println("The Total Revenue is: ");
        System.out.println(walmart.getTotalRevenue());
        System.out.println("The average spending is: ");
        System.out.println(walmart.getAverageSpending());
        System.out.println("The contribution of groceries in total revenue in percentage is :");
        System.out.println(walmart.getPercentageGroceriesRevenue());
        System.out.println("The contribution of tools in total revenue in percentage is :");
        System.out.println(walmart.getPercentageToolsRevenue());


    }
    public static Customer getDetails() {
        double initialBalance = 0;

        System.out.println("Enter customer name: ");
        String name = scanner.next();
        System.out.println("Enter initial balance: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Enter a valid number!");
            scanner.next();
        }
        initialBalance = scanner.nextDouble();

        Customer customerObject= new Customer(name, initialBalance);
        return customerObject;
    }
}
