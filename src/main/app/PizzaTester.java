/**
 * PizzaTester.java (Main Class)
 * Author: KASOGA Justesse
 * Reg No: 11471_2017
 */

package main.app;

import java.util.*;

import main.enums.CrustType;
import main.enums.MeatType;
import main.enums.Size;
import main.enums.Topping;
import main.enums.VeggieType;
import main.model.Customer;
import main.model.InvalidPizzaException;
import main.model.Order;
import main.model.Pizza;

public class PizzaTester {

    public static final String FILE_NAME = "pizza_orders.json";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to Kasoga Pizza Palace ===");

        // Load past orders
        Order.displayAllOrders(FILE_NAME);

        try {
            System.out.print("\nHow many pizzas would you like to order? ");
            int numPizzas = Integer.parseInt(sc.nextLine());
            List<Pizza> pizzas = new ArrayList<>();

            for (int i = 0; i < numPizzas; i++) {
                System.out.println("\n--- Pizza " + (i + 1) + " ---");
                Pizza pizza = createPizzaFromInput(sc);
                pizzas.add(pizza);
            }

            System.out.println("\n--- Customer Details ---");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("Phone Number: ");
            String phone = sc.nextLine();
            Customer customer = new Customer(name, address, phone);

            System.out.print("Is this order for Delivery? (yes/no): ");
            boolean delivery = sc.nextLine().trim().equalsIgnoreCase("yes");

            Order order = new Order(customer, pizzas, delivery);
            order.saveToFile(FILE_NAME);

            System.out.println("\nOrder placed successfully!");
            System.out.println(order);

        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        sc.close();
    }

    private static Pizza createPizzaFromInput(Scanner sc) throws InvalidPizzaException {
        System.out.print("Number of slices: ");
        int slices = Integer.parseInt(sc.nextLine());

        System.out.println("Choose meat (PEPPERONI, CHICKEN, BACON, BEEF, PORK): ");
        MeatType meat = MeatType.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Choose veggie (MUSHROOM, ONION, PEPPER, OLIVES, SPINACH): ");
        VeggieType veg = VeggieType.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Choose crust (THIN, THICK, STUFFED, GLUTEN_FREE): ");
        CrustType crust = CrustType.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Choose size (SMALL, MEDIUM, LARGE): ");
        Size size = Size.valueOf(sc.nextLine().toUpperCase());

        System.out.println(
                "Enter toppings (CHEESE, PINEAPPLE, JALAPENOS, GARLIC, BASIL, PESTO, BBQ_SAUCE, EXTRA_CHEESE)");
        System.out.println("Separate multiple toppings with commas:");
        String[] toppingInputs = sc.nextLine().toUpperCase().split(",");
        Set<Topping> toppings = new HashSet<>();
        for (String t : toppingInputs) {
            toppings.add(Topping.valueOf(t.trim()));
        }

        return new Pizza(slices, meat, veg, crust, toppings, size);
    }
}