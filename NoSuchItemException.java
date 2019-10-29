package org.ie.shoppingcart;

public class NoSuchItemException extends Exception {
    public NoSuchItemException(String message) {
        super(message);
    }
}
