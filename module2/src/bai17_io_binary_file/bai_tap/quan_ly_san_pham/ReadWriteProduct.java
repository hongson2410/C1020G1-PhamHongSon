package bai17_io_binary_file.bai_tap.quan_ly_san_pham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadWriteProduct {
    static List<Product> list = new ArrayList<>();

    public static void writeFile(String file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file))) {
            for (Product product : list) {
                objectOutputStream.writeObject(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName) {
        File file = new File(fileName);
        list.clear();
        try {
            if (!file.exists()) {
                file.createNewFile();
                return;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Object product;
            while ((product = objectInputStream.readObject()) != null) {
                list.add((Product) product);
            }
            objectInputStream.close();
        } catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter manufacture: ");
        String manufacture = scanner.nextLine();
        System.out.println("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        list.add(new Product(id, name, manufacture, price));
        writeFile("src/bai17_io_binary_file/bai_tap/quan_ly_san_pham/product.io");
    }

    public static void showProduct() {
        for (Product product : list) {
            System.out.println(product);
        }
    }

    private static List<Product> searchProductByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name product you want search: ");
        String name = scanner.nextLine();
        List<Product> listSearchByName = new ArrayList<>();
        if (!list.isEmpty()) {
            for (Product product : list) {
                if (product.getName().contains(name)) {
                    listSearchByName.add(product);
                }
            }
            return listSearchByName;
        }
        return null;
    }

    public static void main(String[] args) {
        readFile("src/bai17_io_binary_file/bai_tap/quan_ly_san_pham/product.io");
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Product." + "\n" +
                    "2. Show Product." + "\n" +
                    "3. Search Product." + "\n" +
                    "0. Exit.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showProduct();
                    break;
                case 3:
                    System.out.println(searchProductByName());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Choice not found!!!");
            }
        } while (choice != 0);
    }
}
