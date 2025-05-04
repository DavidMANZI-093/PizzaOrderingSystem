/**
 * Pizza.java
 * Author: KASOGA Justesse
 * Reg No: 11471_2017
 */

package main.model;

import java.util.Set;

import main.enums.CrustType;
import main.enums.MeatType;
import main.enums.Size;
import main.enums.Topping;
import main.enums.VeggieType;

 public class Pizza {
 
     private int numSlices;
     private MeatType meatChoice;
     private VeggieType vegChoice;
     private CrustType crustType;
     private Set<Topping> toppings;
     private Size size;
 
     // Default constructor
     public Pizza() {
         this.numSlices = 8;
         this.meatChoice = MeatType.PEPPERONI;
         this.vegChoice = VeggieType.MUSHROOM;
         this.crustType = CrustType.THIN;
         this.toppings = Set.of(Topping.CHEESE);
         this.size = Size.MEDIUM;
     }
 
     // Parameterized constructor
     public Pizza(int numSlices, MeatType meatChoice, VeggieType vegChoice, CrustType crustType,
                  Set<Topping> toppings, Size size) throws InvalidPizzaException {
         if (numSlices <= 0) throw new InvalidPizzaException("Number of slices must be greater than 0.");
         this.numSlices = numSlices;
         this.meatChoice = meatChoice;
         this.vegChoice = vegChoice;
         this.crustType = crustType;
         this.toppings = toppings;
         this.size = size;
     }
 
     // Getters and Setters
     public int getNumSlices() {
         return numSlices;
     }
 
     public void setNumSlices(int numSlices) {
         this.numSlices = numSlices;
     }
 
     public MeatType getMeatChoice() {
         return meatChoice;
     }
 
     public void setMeatChoice(MeatType meatChoice) {
         this.meatChoice = meatChoice;
     }
 
     public VeggieType getVegChoice() {
         return vegChoice;
     }
 
     public void setVegChoice(VeggieType vegChoice) {
         this.vegChoice = vegChoice;
     }
 
     public CrustType getCrustType() {
         return crustType;
     }
 
     public void setCrustType(CrustType crustType) {
         this.crustType = crustType;
     }
 
     public Set<Topping> getToppings() {
         return toppings;
     }
 
     public void setToppings(Set<Topping> toppings) {
         this.toppings = toppings;
     }
 
     public Size getSize() {
         return size;
     }
 
     public void setSize(Size size) {
         this.size = size;
     }
 
     // Method to calculate price
     public double calculatePrice() {
         double base = 10.0;
         base += 2.0; // 1 meat
         base += 1.0; // 1 veggie
         base += toppings.size() * 0.5;
 
         switch (crustType) {
             case THICK -> base += 1;
             case STUFFED -> base += 3;
             case GLUTEN_FREE -> base += 2;
             default -> {} // THIN = +0
         }
 
         switch (size) {
             case SMALL -> base *= 1.0;
             case MEDIUM -> base *= 1.5;
             case LARGE -> base *= 1.8;
         }
 
         return Math.round(base * 100.0) / 100.0; // round to 2 decimals
     }
 
     @Override
     public String toString() {
         return "Pizza [" +
                 "Slices: " + numSlices +
                 ", Meat: " + meatChoice +
                 ", Veggie: " + vegChoice +
                 ", Crust: " + crustType +
                 ", Toppings: " + toppings +
                 ", Size: " + size +
                 ", Price: $" + calculatePrice() +
                 "]";
     }
 } 