package controllers;

import models.*;

import java.util.Scanner;

public class MainController {
    private static VillaManager villaManager = new VillaManager();
    private static HouseManager houseManager = new HouseManager();
    private static RoomManager roomManager = new RoomManager();
    private static Regex regex = new Regex();
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerManager customerManager = new CustomerManager();

    static void displayMainMenu() {
        int choice;
        do {
            System.out.println("1. Add New Services. " + "\n" +
                    "2. Show Services. " + "\n" +
                    "3. Add New Customer. " + "\n" +
                    "4. Show Information of Customer. " + "\n" +
                    "5. Add New Booking. " + "\n" +
                    "6. Show Information. " + "\n" +
                    "7. Exit.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewService();
                    break;
                case 2:
                    showService();
                    break;
                case 3:
                    addNewCustomer();
                    break;
                case 4:
                    showInfoCustomer();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInfoEmployee();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Choice not found!!!");
                    break;
            }
        } while (choice != 7);
    }

    static void addNewService() {
        int choice;
        System.out.println("1. Add New Villa. " + "\n" +
                "2. Add New House. " + "\n" +
                "3. Add New Room. " + "\n" +
                "4. Back To Menu. " + "\n" +
                "5. Exit.");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Choice not found!!!");
        }
    }

    static String idService() {
        return regex.regexIdService();
    }

    static String nameService() {
        return regex.regexNameService();
    }

    static double areaUsing() {
        return regex.regexAreaUsing();
    }

    static int price() {
        return regex.regexPrice();
    }

    static int numberTenants() {
        return regex.regexNumberTenants();
    }

    static String rentalType() {
        return regex.regexRentalType();
    }

    static void addNewVilla() {
        String idService = idService();
        String nameService = nameService();
        double areaUsing = areaUsing();
        double price = price();
        int numberTenants = numberTenants();
        String rentalType = rentalType();
        String roomStandard = regex.regexRoomStandard();
        String roomFurniture = regex.regexRoomFurniture();
        double poolArea = regex.regexPoolArea();
        int floors = regex.regexFloors();

        villaManager.addVilla(new Villa(idService, nameService, areaUsing, price, numberTenants, rentalType, roomStandard, roomFurniture, poolArea, floors));
    }

    static void addNewHouse() {
        String idService = idService();
        String nameService = nameService();
        double areaUsing = areaUsing();
        double price = price();
        int numberTenants = numberTenants();
        String rentalType = rentalType();
        String roomStandard = regex.regexRoomStandard();
        String roomFurniture = regex.regexRoomFurniture();
        int floors = regex.regexFloors();

        houseManager.addHouse(new House(idService, nameService, areaUsing, price, numberTenants, rentalType, roomStandard, roomFurniture, floors));
    }

    static void addNewRoom() {
        String idService = idService();
        String nameService = nameService();
        double areaUsing = areaUsing();
        double price = price();
        int numberTenants = numberTenants();
        String rentalType = rentalType();
        String freeService = regex.regexFreeService();

        roomManager.addRoom(new Room(idService, nameService, areaUsing, price, numberTenants, rentalType, freeService));
    }

    static void showService() {
        int choice;
        System.out.println("1. Show All Villa." + "\n" +
                "2. Show All House. " + "\n" +
                "3. Show All Room. " + "\n" +
                "4. Show All Name Villa Not Duplicate. " + "\n" +
                "5. Show All Name House Not Duplicate. " + "\n" +
                "6. Show All Name Room Not Duplicate. " + "\n" +
                "7. Back To Menu. " + "\n" +
                "8. Exit.");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                showAllVilla();
                break;
            case 2:
                showAllHouse();
                break;
            case 3:
                showAllRoom();
                break;
            case 4:
                showAllNameVillaNotDup();
                break;
            case 5:
                showAllNameHouseNotDup();
                break;
            case 6:
                showAllNameRoomNotDup();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
            default:
                System.out.println("Choice Not Found!!!");
        }
    }

    static void addNewCustomer() {
        String fullName = scanner.nextLine();
        String birthday = scanner.nextLine();
        String gender = scanner.nextLine();
        String cmnd = scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        String email = scanner.nextLine();
        String customerType = scanner.nextLine();
        String address = scanner.nextLine();

        customerManager.addCustomer(new Customer(fullName, birthday, gender, cmnd, phoneNumber, email, customerType, address));
    }

    static void showInfoCustomer() {
        customerManager.showInformationCustomers();
    }

    static void addNewBooking() {

    }

    static void showInfoEmployee() {

    }

    static void showAllVilla() {
        villaManager.showVilla();
    }

    static void showAllHouse() {
        houseManager.showHouse();
    }

    static void showAllRoom() {
        roomManager.showRoom();
    }

    static void showAllNameVillaNotDup() {

    }

    static void showAllNameHouseNotDup() {

    }

    static void showAllNameRoomNotDup() {

    }

    public static void main(String[] args) {
        displayMainMenu();
    }

}
