/**
 * Order.java
 * Author: KASOGA Justesse
 * Reg No: 11471_2017
 */

package main.model;

import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

public class Order {

    private static int nextId = 1;
    private String orderId;
    private Customer customer;
    private List<Pizza> pizzas;
    private LocalDateTime orderTime;
    private boolean isDelivery;

    // Constructor
    public Order(Customer customer, List<Pizza> pizzas, boolean isDelivery) {
        this.orderId = generateOrderId();
        this.customer = customer;
        this.pizzas = pizzas;
        this.orderTime = LocalDateTime.now();
        this.isDelivery = isDelivery;
    }

    // Unique ID generator
    private String generateOrderId() {
        return "ORD" + (nextId++) + "-" + System.currentTimeMillis();
    }

    // Total price calculation with discount if > 1 pizza
    public double calculateTotal() {
        double total = 0;
        for (Pizza p : pizzas) {
            total += p.calculatePrice();
        }
        if (pizzas.size() > 1) {
            total *= 0.95; // 5% discount
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public void saveToFile(String filename) {
        try (FileWriter fw = new FileWriter(filename, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {

            out.println(this.toString());
        } catch (IOException e) {
            System.out.println("Error writing order to file: " + e.getMessage());
        }
    }

    public static void displayAllOrders(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No past orders found.");
            return;
        }
        System.out.println("\n=== Past Orders ===");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error reading order file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n==========================\n");
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Delivery: ").append(isDelivery ? "Yes" : "Pickup").append("\n");
        sb.append(customer).append("\n");
        for (int i = 0; i < pizzas.size(); i++) {
            sb.append("Pizza ").append(i + 1).append(": ").append(pizzas.get(i)).append("\n");
        }
        sb.append("Total Price: $").append(calculateTotal()).append("\n");
        sb.append("==========================\n");
        return sb.toString();
    }
}