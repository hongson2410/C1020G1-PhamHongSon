package commons.exception;

import java.util.Date;
import java.util.Scanner;

public class Regex {
    Scanner scanner = new Scanner(System.in);
    final double AREA_REGEX = 30;
    final String TYPE_REGEX = "[A-Z][a-z_0-9]+";

    public String regexIdService() {
        final String ID_SERVICE_REGEX = "(SV)(VL|HO|RO)[-]\\d{4}";
        String idService;
        do {
            System.out.println("Id Service: ");
            idService = scanner.nextLine();
            if (!idService.matches(ID_SERVICE_REGEX)) {
                System.err.println("Wrong Input Format!!!");
            }
        } while (!idService.matches(ID_SERVICE_REGEX));
        return idService;
    }

    public String regexNameService() {
        String nameService;
        do {
            System.out.println("Name Service: ");
            nameService = scanner.nextLine();
            if (!nameService.matches(TYPE_REGEX)) {
                System.err.println("Wrong Input Format!!!");
            }
        } while (!nameService.matches(TYPE_REGEX));
        return nameService;
    }

    public double regexAreaUsing() {
        double areaUsing = 0;
        do {
            System.out.println("Area Using: ");
            try {
                areaUsing = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                continue;
            }
            if (areaUsing <= AREA_REGEX) {
                System.err.println("The Area Must Be Greater Than 30!!!");
            }
        } while (areaUsing <= AREA_REGEX);
        return areaUsing;
    }

    public double regexPoolArea() {
        double poolArea = 0;
        do {
            System.out.println("Pool Area: ");
            try {
                poolArea = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                continue;
            }
            if (poolArea <= AREA_REGEX) {
                System.err.println("The Area Must Be Greater Than 30!!!");
            }
        } while (poolArea <= AREA_REGEX);
        return poolArea;
    }

    public int regexPrice() {
        int price = 0;
        do {
            System.out.println("Price: ");
            try {
                price = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                continue;
            }
            if (price <= 0) {
                System.err.println("The Price Must Be A Positive Integer!!!");
            }
        } while (price <= 0);
        return price;
    }

    public int regexNumberTenants() {
        int numberTenants = 0;
        do {
            System.out.println("Number Tenants: ");
            try {
                numberTenants = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                continue;
            }
            if (numberTenants <= 0 | numberTenants >= 20) {
                System.err.println("The maximum number of people must be> 0 and less than <20!!");
            }
        } while (numberTenants <= 0 | numberTenants >= 20);
        return numberTenants;
    }

    public String regexFreeService() {
        final String FREE_SERVICE_REGEX = "(massage|karaoke|food|drink|car)";
        String freeService;
        do {
            System.out.println("Free Service: ");
            freeService = scanner.nextLine();
            if (!freeService.matches(FREE_SERVICE_REGEX)) {
                System.err.println("Wrong Input Format!!!");
            }
        } while (!freeService.matches(FREE_SERVICE_REGEX));
        return freeService;
    }

    public int regexFloors() {
        int floors = 0;
        do {
            System.out.println("Floor: ");
            try {
                floors = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                continue;
            }
            if (floors <= 0) {
                System.err.println("The Floor Must Be A Positive Integer!!!");
            }
        } while (floors <= 0);
        return floors;
    }

    public String regexRentalType() {
        String rentalType;
        do {
            System.out.println("Rental Type: ");
            rentalType = scanner.nextLine();
            if (!rentalType.matches(TYPE_REGEX)) {
                System.err.println("Wrong Input Format!!!");
            }
        } while (!rentalType.matches(TYPE_REGEX));
        return rentalType;
    }

    public String regexRoomStandard() {
        String roomStandard;
        do {
            System.out.println("Room Standard: ");
            roomStandard = scanner.nextLine();
            if (!roomStandard.matches(TYPE_REGEX)) {
                System.err.println("Wrong Input Format!!!");
            }
        } while (!roomStandard.matches(TYPE_REGEX));
        return roomStandard;
    }

    public String regexRoomFurniture() {
        final String ROOM_FURNITURE_REGEX = "(classic|modern|normal)";
        String roomFurniture;
        do {
            System.out.println("Room Furniture: ");
            roomFurniture = scanner.nextLine();
            if (!roomFurniture.matches(ROOM_FURNITURE_REGEX)) {
                System.err.println("classic or modern or normal");
            }
        } while (!roomFurniture.matches(ROOM_FURNITURE_REGEX));
        return roomFurniture;
    }

    private boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }


    public void validateBirthday(String date) throws BirthdayException {
        String regex = "[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}";
        Date now = new Date();
        int yearNow = now.getYear() + 1900;
        int monthNow = now.getMonth() + 1;
        int dayNow = now.getDate();
        StringBuilder stringBuilder = new StringBuilder(date);
        int yearCustomer;
        int dayCustomer;
        int monthCustomer;
        if (date.matches(regex)) {
            yearCustomer = Integer.parseInt(stringBuilder.substring(6));
            dayCustomer = Integer.parseInt(stringBuilder.substring(0, 2));
            monthCustomer = Integer.parseInt(stringBuilder.substring(3, 5));
            if ((yearNow - yearCustomer) < 18) {
                throw new BirthdayException("Customer > 18 year old");
            }
            if (yearNow - yearCustomer == 18) {
                if (monthNow < monthCustomer) {
                    throw new BirthdayException("Customer > 18 year old");
                } else if (monthCustomer == monthNow) {
                    if (dayNow < dayCustomer) {
                        throw new BirthdayException("Customer > 18 year old");
                    }
                }
            }
            if (yearCustomer < 1901) {
                throw new BirthdayException("Year > 1900");
            }
            if (monthCustomer > 12) {
                throw new BirthdayException("Max month is 12");
            }
            switch (monthCustomer) {
                case 2:
                    if (checkLeapYear(yearCustomer)) {
                        if (dayCustomer > 29) {
                            throw new BirthdayException("Max days is 29");
                        }
                    } else {
                        if (dayCustomer > 28) {
                            throw new BirthdayException("Max days is 28!!");
                        }
                    }
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (dayCustomer > 31) {
                        throw new BirthdayException("Max days is 31!!");
                    }
                    break;
                default:
                    if (dayCustomer > 30) {
                        throw new BirthdayException("Max days is 30!!");
                    }
            }
        } else {
            throw new BirthdayException("Wrong input format");
        }
    }

    public void validateName(String name) throws NameException {
        String regex = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$";
        if (!name.matches(regex)) {
            throw new NameException("Client Name must capitalize first letter of each word");
        }
    }

    public void validateEmail(String email) throws EmailException {
        String regex = "\\w+@[a-z0-9]+.[a-z0-9]+(\\.[a-z0-9]+)*";
        if (!email.matches(regex)) {
            throw new EmailException("Email must be in the correct format abc@abc.abc");
        }
    }

    public String validateGender(String gender) throws GenderException {
        String regex = "(?i)(male|female|unknown)";
        if (gender.matches(regex)) {
            gender = gender.toLowerCase();
            StringBuilder stringBuilder = new StringBuilder(gender);
            stringBuilder.replace(0, 1, stringBuilder.substring(0, 1).toUpperCase());
            gender = stringBuilder.toString();
        } else {
            throw new GenderException("Enter Male, Female, Unknown!!");
        }
        return gender;
    }

    public void validateIdCard(String idCard) throws IdCardException {
        String regex = "\\d{3}\\s\\d{3}\\s\\d{3}";
        if (!idCard.matches(regex)) {
            throw new IdCardException("Id Card must be 9 digits and in XXX XXX XXX format");
        }
    }

    public String validatePhoneNumber() {
        String regex = "(\\+84|0)\\d{9}";
        String phoneNumber;
        do {
            System.out.println("Phone Numbers: ");
            phoneNumber = scanner.nextLine();
            if (!phoneNumber.matches(regex)) {
                System.err.println("The phone number must have 10 numbers!!!");
            }
        } while (!phoneNumber.matches(regex));
        return phoneNumber;
    }

    public String validateCustomerType() {
        String customerType;
        do {
            System.out.println("Customer Type: ");
            customerType = scanner.nextLine();
            if (!customerType.matches(TYPE_REGEX)) {
                System.err.println("Wrong Input Format!!!");
            }
        } while (!customerType.matches(TYPE_REGEX));
        return customerType;
    }
}
