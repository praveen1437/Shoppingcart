package org.ie.shoppingcart;

public abstract class Item {
    private int ID;
    private String name;
    private Double price;
    private int quantity;

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    int getQuantity() {
        return quantity;
    }

    Item(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    //setter getter methods to retrieve and set the data to variables
    int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price * quantity;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + quantity +
                '}';
    }
}
