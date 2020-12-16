package bai12_map_tree.bai_tap.arraylist_linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private List<Product> list;
    private static final Scanner scanner= new Scanner(System.in);
    public ProductManager() {
        list = new ArrayList<>();
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public void showProduct() {
        System.out.println(list.toString());
    }

    public void removeProduct(int id) {
        Product product = searchProductById(id);
        list.remove(product);
    }

    private Product searchProductById(int id) {
        for (Product product : list) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

//    private Product searchName(String name) {
//        for (Product product : list) {
//            if (product.getName().equals(name)) {
//                return product;
//            }
//        }
//        return null;
//    }

    public List<Product> searchProductByName(String name) {
        List<Product> listSearchByName = new ArrayList<>();
        if (!this.list.isEmpty()) {
            for (Product product : this.list) {
                if (product.getName().contains(name)) {
                    listSearchByName.add(product);
                }
            }
            return listSearchByName;
        }
        return null;
    }

    public Product setById() {
        Product product;
        int choice;
        System.out.println("Enter id product you want set:");
        int id = Integer.parseInt(scanner.nextLine());
        product = searchProductById(id);
        do {
            System.out.println(product);
            System.out.println("You want set:" + "\n" + "1. Id." + "\n" + "2. Name." + "\n" + "3. Price."+ "\n"+ "0. Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Set id to: ");
                    product.setId(Integer.parseInt(scanner.nextLine()));
                   break;
                case 2:
                    System.out.println("Set name to: ");
                    product.setName(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Set prime to: ");
                    product.setPrice(Integer.parseInt(scanner.nextLine()));
                   break;
                case 0:
                    break;
                default:
                    System.out.println("Choice not found!!");
            }
        } while (choice!=0);
        return product;
    }

    public void up(){
        Comparator<Product> priceUp = new SortPriceUp();
        list.sort(priceUp);
    }

    public void down(){
        Comparator<Product> priceDown = new SortPriceDown();
        list.sort(priceDown);
    }

}
