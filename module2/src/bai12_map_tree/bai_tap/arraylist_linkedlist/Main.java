package bai12_map_tree.bai_tap.arraylist_linkedlist;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ProductManager manager= new ProductManager();
    private static final Scanner scanner= new Scanner(System.in);
    private static void show(){
        manager.showProduct();
    }

    private static void remove(){
        System.out.println("Enter id you want remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        manager.removeProduct(id);
    }

    private static Product searchById(){
        System.out.println("Enter id you want search:");
        int id = Integer.parseInt(scanner.nextLine());
        return manager.searchProductById(id);
    }

    private static List<Product> searchByName(){
        System.out.println("Enter name you want search:");
        String name = scanner.nextLine();
        return manager.searchProductByName(name);
    }

    private static Product set(){
       return manager.setById();
    }

    private static void priceUp(){
        manager.up();
    }

    private static void priceDown(){
        manager.down();
    }
    public static void main(String[] args) {
        manager.addProduct(new Product(1,"Son",200));
        manager.addProduct(new Product(2,"kon",100));
        manager.addProduct(new Product(23,"Kien",300));
        manager.addProduct(new Product(3,"Vy",50));
//        show();
//        remove();
        show();
//        System.out.println(searchById());
//        System.out.println();
//        System.out.println(searchByName());
//        System.out.println(set());
//        priceUp();
        priceDown();
        show();

    }
}
