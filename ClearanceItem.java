package org.ie.shoppingcart;

public class ClearanceItem extends Item {
    ClearanceItem(int ID, String ItemName, double price, int quantity) {

        super(ID, ItemName, price, quantity);
    }

    /**
     * @return double value of discounted price
     */
    @Override
    public Double getPrice() {
        return super.getPrice() * 75 / 100;
    }
}
