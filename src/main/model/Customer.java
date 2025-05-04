/**
 * Customer.java
 * Author: KASOGA Justesse
 * Reg No: 11471_2017
 */

package main.model;

public class Customer {
    private String name;
    private String address;
    private String phoneNumber;

    // Default constructor
    public Customer() {
        this.name = "Unknown";
        this.address = "Unknown";
        this.phoneNumber = "0000000000";
    }

    // Parameterized constructor
    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer [Name: " + name +
                ", Address: " + address +
                ", Phone: " + phoneNumber + "]";
    }
}