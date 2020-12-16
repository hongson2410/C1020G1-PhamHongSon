package bai12_map_tree.bai_tap.arraylist_linkedlist;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ProductManager manager = new ProductManager();
    private static final Scanner scanner = new Scanner(System.in);

    private static void show() {
        manager.showProduct();
    }

    private static void remove() {
        System.out.println("Enter id you want remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        manager.removeProduct(id);
    }

//    private static Product searchById() {
//        System.out.println("Enter id you want search:");
//        int id = Integer.parseInt(scanner.nextLine());
//        return manager.searchProductById(id);
//    }

    private static List<Product> searchByName() {
        System.out.println("Enter name product you want search:");
        String name = scanner.nextLine();
        return manager.searchProductByName(name);
    }

    private static void add() {
        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        manager.addProduct(new Product(id, name, price));

    }

    private static Product set() {
        return manager.setById();
    }

    private static void priceUp() {
        manager.up();
    }

    private static void priceDown() {
        manager.down();
    }


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Add product." + "\n" +
                    "2. Set product by id." + "\n" +
                    "3. Remove product by id." + "\n" +
                    "4. Show product." + "\n" +
                    "5. Search product by name." + "\n" +
                    "6. Product arrangements." + "\n" +
                    "0. Exit.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    set();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    show();
                    break;
                case 5:
                    System.out.println(searchByName());
                    break;
                case 6:
                    int cc;
                    System.out.println("1. Sort up ascending." + "\n" +
                            "2. Descending arrangement.");
                    cc = Integer.parseInt(scanner.nextLine());
                    switch (cc) {
                        case 1:
                            priceUp();
                            show();
                            break;
                        case 2:
                            priceDown();
                            show();
                            break;
                        default:
                            System.out.println("Not found!");
                            break;
                    }
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Choice not found!!");
            }
        } while (choice != 0);
    }
}
