package org.ie.shoppingcart;

import java.util.Comparator;

class CostComparator implements Comparator<Item>{

    @Override
    public int compare(Item item1, Item item2) {
        System.out.println(item1.getPrice());
        System.out.println(item2.getPrice());
   return (item2.getPrice().compareTo(item1.getPrice()));
    }
}
