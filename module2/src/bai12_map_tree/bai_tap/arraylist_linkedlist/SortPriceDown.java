package bai12_map_tree.bai_tap.arraylist_linkedlist;

import java.util.Comparator;

public class SortPriceDown implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getPrice()-o1.getPrice();
    }
}
