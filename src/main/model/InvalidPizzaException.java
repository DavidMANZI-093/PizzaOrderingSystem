/**
 * Custom Exception for Pizza Validation
 * Author: KASOGA Justesse
 * Reg No: 11471_2017
 */

package main.model;

public class InvalidPizzaException extends Exception {
    public InvalidPizzaException(String message) {
        super(message);
    }
}