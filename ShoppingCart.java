package org.ie.shoppingcart;


import java.util.*;

public class ShoppingCart {
    private HashMap<Integer, Item> items = new HashMap<>();
    //private int itemCount;


    /**
     * It adds an item into the ItemBasket.
     * argument is Item object.
     * It stores in <key,value> pair.
     * item ID as key , item object as value
     *
     * @param item represents an Item which is to be added into the shopping cart
     * @return true if item is added to cart
     */
    private boolean addItem(Item item) {

        if (items.containsKey(item.getID())) {

            // item.setQuantity(item.getQuantity()+1);
            Item previousItem = items.get(item.getID());
            items.get(item.getID()).setQuantity(previousItem.getQuantity() + item.getQuantity());

        } else {
            items.put(item.getID(), item);

        }
        return true;
    }

    /**
     * This method removes given item completely irrespective of quantity of the item
     *
     * @param item Name of the item to be removed from the cart
     * @return boolean
     * true if item is successfully removed
     */
    private boolean remove(Item item) {
        if (!items.containsKey(item.getID())) {
            return false;
        }
        items.remove(item.getID());
        return true;
    }


    /**
     * It is an overloading method of remove method
     * it reduces the particular item quantity as supplied in the method argument
     *
     * @param item     item to be removed from cart
     * @param quantity quantity of the item which will be removed
     * @return boolean
     * true if removes successfully
     * @throws NoSuchItemException      when item is not present in the cart
     * @throws IllegalArgumentException if quantity to be removed is greater than the current quantity
     *                                  and if value of quantity passed in argument is less than or equal to zero
     */
    public boolean remove(Item item, int quantity) throws NoSuchItemException, IllegalArgumentException {
        if (quantity > item.getQuantity()) {
            throw new IllegalArgumentException("Operation failed.\n Item Quantity is: " + item.getQuantity() + "  but passed value is: " + quantity);
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity should be more than Zero");
        } else {
            if (items.get(item.getID()) == null) {
                throw new NoSuchItemException("There is no item with " + item.getName() + " in your cart");
            }
            if (items.get(item.getID()).getQuantity() == quantity) {
                items.remove(item.getID());
                return true;

            } else {
                int newQty = items.get(item.getID()).getQuantity() - quantity;
                items.get(item.getID()).setQuantity(newQty);
                return true;
            }
        }
    }

    /**
     * Returns the total cost of the items present in the cart.
     * Empties the shopping cart
     *
     * @return total cost of all items in the shopping cart as double value
     */
    private double checkout() {
        double totalCost = 0;
        List<Item> totalCostList = new ArrayList<>(items.values());
        for (Item item : totalCostList
        ) {
            totalCost += (item.getPrice()) * item.getQuantity();
        }
        items.clear();
        return totalCost;
    }

    /**
     * Prints the all items in the shopping cart descending order
     * prints every item name and price
     */
    private void listContents() {
        List<Item> totalCostList = new ArrayList<>(items.values());
        if (totalCostList.size() == 0) {
            System.out.println(" Cart is Empty");
            totalCostList = null;
        } else {


            // totalCostList.sort((item1, item2) -> (item2.getPrice().compareTo(item1.getPrice())));
            totalCostList.sort(Comparator.comparingDouble(Item::getPrice).reversed());
            // System.out.println("Name  \t\t"+"Price   \t\t"+"ItemQuantity  \t\t"+"TotalCost");
            for (Item item : totalCostList
            ) {


                System.out.println("name:: " + item.getName() + "\tprice:: " + item.getPrice() / item.getQuantity() + "\t\tquantity:: " + item.getQuantity() + "\t\ttotal cost::" + item.getPrice());
            }
        }
    }

    public static void main(String[] args){


        Item beer = new ClearanceItem(1, "Beer", 5, 2);
        Item iceCream = new RetailItem(2, "ice Cream", 4.5, 1);
        Item tofu = new RetailItem(4, "Tofu", 1.5, 1);
        Item magazine = new RetailItem(3, "Magazine", 3, 1);


        ShoppingCart cart = new ShoppingCart();
        cart.addItem(beer);
        cart.addItem(iceCream);
        cart.addItem(tofu);
        cart.addItem(magazine);
        cart.listContents();
        System.out.println("============================================================================================================");
        cart.remove(tofu);
        System.out.println("After removing tofu item list contents are::");
        cart.listContents();

        System.out.println("==============================================================================================================");
        double totalcost = cart.checkout();
        System.out.println("total price of items in the Shoppingcart::");
        System.out.println(totalcost);
        System.out.println("================================================================================================================");
        System.out.println("After clearing Shoppingcart::");
        cart.listContents();


    }
}
