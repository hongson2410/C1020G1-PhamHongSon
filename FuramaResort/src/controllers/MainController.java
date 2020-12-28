package controllers;

import models.*;

import java.util.Scanner;

public class MainController {
    private static VillaManager villaManager = new VillaManager();
    private static HouseManager houseManager = new HouseManager();
    private static RoomManager roomManager = new RoomManager();

    private static Scanner scanner = new Scanner(System.in);

    static void displayMainMenu() {
        int choice;
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
    static String nameService(){
        System.out.println("Name Service: ");
        return scanner.nextLine();
    }
    
    static int areaUsing(){
        System.out.println("Area Using: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    static double price(){
        System.out.println("Price: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    static int numberTenants(){
        System.out.println("Number Tenants: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    static String rentalType(){
        System.out.println("Rental Type: ");
        return scanner.nextLine();
    }
    static void addNewVilla() {
        String nameService= nameService();
        int areaUsing= areaUsing();
        double price= price();
        int numberTenants= numberTenants();
        String rentalType= rentalType();
        System.out.println("Room Standard: ");
        String roomStandard= scanner.nextLine();
        System.out.println("Room Furniture: ");
        String roomFurniture=scanner.nextLine();
        System.out.println("Pool Area: ");
        int poolArea=Integer.parseInt(scanner.nextLine());
        System.out.println("Floors: ");
        int floors= Integer.parseInt(scanner.nextLine());

        villaManager.addVilla(new Villa(nameService,areaUsing,price,numberTenants,rentalType,roomStandard,roomFurniture,poolArea,floors));
    }

    static void addNewHouse() {
        String nameService= nameService();
        int areaUsing= areaUsing();
        double price= price();
        int numberTenants= numberTenants();
        String rentalType= rentalType();
        System.out.println("Room Standard: ");
        String roomStandard= scanner.nextLine();
        System.out.println("Room Furniture: ");
        String roomFurniture=scanner.nextLine();
        System.out.println("Floors: ");
        int floors= Integer.parseInt(scanner.nextLine());

        houseManager.addHouse(new House(nameService,areaUsing,price,numberTenants,rentalType,roomStandard,roomFurniture,floors));
    }

    static void addNewRoom() {
        String nameService= nameService();
        int areaUsing= areaUsing();
        double price= price();
        int numberTenants= numberTenants();
        String rentalType= rentalType();
        System.out.println("Free Service: ");
        String freeService=scanner.nextLine();

        roomManager.addRoom(new Room(nameService,areaUsing,price,numberTenants,rentalType,freeService));
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

    }

    static void showInfoCustomer() {

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
