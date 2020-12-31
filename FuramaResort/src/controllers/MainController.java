package controllers;

import commons.exception.*;
import commons.regular_expression.Regex;
import models.*;

import java.util.Scanner;

public class MainController {
    private static VillaManager villaManager = new VillaManager();
    private static HouseManager houseManager = new HouseManager();
    private static RoomManager roomManager = new RoomManager();
    private static CustomerManager customerManager = new CustomerManager();
    private static BookingManager bookingManager = new BookingManager();
    private static EmployeeManager employeeManager = new EmployeeManager();
    private static CinemaManager cinemaManager= new CinemaManager();
    private static Cabinets cabinets= new Cabinets();
    private static Regex regex = new Regex();
    private static Scanner scanner = new Scanner(System.in);

    static void displayMainMenu() {
        int choice;
        do {
            System.out.println("=/Menu/=");
            System.out.println("1. Add New Services. " + "\n" +
                    "2. Show Services. " + "\n" +
                    "3. Add New Customer. " + "\n" +
                    "4. Show Information of Customer. " + "\n" +
                    "5. Add New Booking. " + "\n" +
                    "6. Show Information of Employee. " + "\n" +
                    "7. Cinema Manager." + "\n" +
                    "8. Find Employee In Cabinets. "+ "\n"+
                    "9. Exit.");
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
                    cinemaManager();
                    break;
                case 8:
                    findEmployeeInCabinets();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Choice not found!!!");
                    break;
            }
        } while (choice != 9);
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
        String birthday = null;
        String fullName = null;
        String email = null;
        String gender = null;
        String idCard = null;
        boolean isValid = true;

        do {
            isValid = true;
            try {
                System.out.println("Full Name Customer: ");
                fullName = scanner.nextLine();
                regex.validateName(fullName);
            } catch (NameException e) {
                isValid = false;
                System.err.println(e.getMessage());
            }
        } while (!isValid);

        do {
            isValid = true;
            try {
                System.out.println("Birthday Customer: ");
                birthday = scanner.nextLine();
                regex.validateBirthday(birthday);
            } catch (BirthdayException e) {
                isValid = false;
                System.err.println(e.getMessage());
            }
        } while (!isValid);

        do {
            isValid = true;
            try {
                System.out.println("Email: ");
                email = scanner.nextLine();
                regex.validateEmail(email);
            } catch (EmailException e) {
                isValid = false;
                System.err.println(e.getMessage());
            }
        } while (!isValid);

        do {
            isValid = true;
            try {
                System.out.println("Gender's Customer:");
                gender = scanner.nextLine();
                gender = regex.validateGender(gender);
            } catch (GenderException e) {
                isValid = false;
                System.err.println(e.getMessage());
            }
        } while (!isValid);

        do {
            isValid = true;
            try {
                System.out.println("Id Card: ");
                idCard = scanner.nextLine();
                regex.validateIdCard(idCard);
            } catch (IdCardException e) {
                isValid = false;
                System.err.println(e.getMessage());
            }
        } while (!isValid);

        String phoneNumber = regex.validatePhoneNumber();
        String customerType = regex.validateCustomerType();
        System.out.println("Address: ");
        String address = scanner.nextLine();

        customerManager.addCustomer(new Customer(fullName, birthday, gender, idCard, phoneNumber, email, customerType, address));
    }

    static void showInfoCustomer() {
        customerManager.showInformationCustomers();
    }

    static void addNewBooking() {
        Customer customer = null;
        do {
            int choice;
            System.out.println("1. Customer Booking." + "\n" +
                    "2. Booking Service." + "\n" +
                    "3. Back To Menu.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerManager.manipulationCustomer();
                    customer = customerManager.findCustomer();
                    break;
                case 2:
                    System.out.println("1. Booking Villa." + "\n" +
                            "2. Booking House." + "\n" +
                            "3. Booking Room.");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            showAllVilla();
                            bookingManager.addBooking(new Booking(villaManager.findVilla(), customer));
                            break;
                        case 2:
                            showAllHouse();
                            bookingManager.addBooking(new Booking(houseManager.findHouse(), customer));
                            break;
                        case 3:
                            showAllRoom();
                            bookingManager.addBooking(new Booking(roomManager.findRoom(), customer));
                            break;
                        default:
                            System.out.println("Choice not found!!");
                    }
                    break;
                case 3:
                    displayMainMenu();
                default:
                    System.out.println("Choice Not Found!");
            }
        }while (true);
    }

    static void showInfoEmployee() {
        employeeManager.showEmployee();
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
        villaManager.showVillaNotDup();
    }

    static void showAllNameHouseNotDup() {
        houseManager.showHouseNotDup();
    }

    static void showAllNameRoomNotDup() {
        roomManager.showRoomNotDup();
    }

    static void cinemaManager(){
        Customer customer;
        do {
            System.out.println("1. Add Customer." + "\n" +
                    "2. Show Queue." + "\n" +
                    "3. Back To Menu.");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerManager.manipulationCustomer();
                    customer = customerManager.findCustomerByIndex();
                    cinemaManager.addCustomer(customer);
                    break;
                case 2:
                    cinemaManager.showCustomerCinema();
                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Choice Not Found!");
            }
        }while (true);
    }

    static void findEmployeeInCabinets(){
        cabinets.showStackEmployee();
    }

    public static void main(String[] args) {
        displayMainMenu();
    }

}
