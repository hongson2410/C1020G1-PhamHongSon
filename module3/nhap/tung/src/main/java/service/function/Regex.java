package service.function;

import java.util.Date;

public class Regex {
//    private Input input = new Input();
//    private boolean status;
//
//    public String regexIdService() {
//        String regex = "(SV)(VL|HO|RO)-[0-9]{4}";
//        String idService;
//        do {
//            idService = input.inputString();
//            status = idService.matches(regex);
//            if (!status) {
//                System.err.println("Wrong format, Input again:");
//            }
//        } while (!status);
//        return idService;
//    }
//
//    public String regexServiceName() {
//        String regex = "[A-Z][a-z_0-9]+";
//        String serviceName;
//        do {
//            serviceName = input.inputString();
//            status = serviceName.matches(regex);
//            if (!status) {
//                System.err.println("Wrong format, Input again:");
//            }
//        } while (!status);
//        return serviceName;
//    }
//
//    public double regexAreaAndPoolArea() {
//        double area;
//        do {
//            if (!status) {
//                System.err.println("Value must > 30, Input again:");
//            }
//            area = input.inputDouble();
//            status = area > 30;
//        } while (!status);
//        return area;
//    }
//
//    public double regexPrice() {
//        double price;
//        do {
//            if (!status) {
//                System.err.println("Value must > 0, Input again:");
//            }
//            price = input.inputDouble();
//            status = price > 0;
//        } while (!status);
//        return price;
//    }
//
//    public int regexMaxPeople() {
//        int maxPeople;
//        do {
//            if (!status) {
//                System.err.println("Value must > 0 and < 20, Input again:");
//            }
//            maxPeople = input.inputInt();
//            status = maxPeople > 0 && maxPeople < 20;
//        } while (!status);
//        return maxPeople;
//    }
//
//    public String regexRentType() {
//        String regex = "(Year|Month|Day|Hour)";
//        String rentType;
//        do {
//            rentType = input.inputString();
//            status = rentType.matches(regex);
//            if (!status) {
//                System.err.println("Wrong format, Input again:");
//            }
//        } while (!status);
//        return rentType;
//    }
//
//    public String regexRoomStandard() {
//        String regex = "(Vip|Business|Normal)";
//        String roomStandard;
//        do {
//            roomStandard = input.inputString();
//            status = roomStandard.matches(regex);
//            if (!status) {
//                System.err.println("Wrong format, Input again:");
//            }
//        } while (!status);
//        return roomStandard;
//    }
//
//    public String regexRoomFurniture() {
//        String regex = "(Classic|Modern|Normal)";
//        String roomFurniture;
//        do {
//            roomFurniture = input.inputString();
//            status = roomFurniture.matches(regex);
//            if (!status) {
//                System.err.println("Wrong format, Input again:");
//            }
//        } while (!status);
//        return roomFurniture;
//    }
//
//    public int regexFloors() {
//        int floors;
//        do {
//            if (!status) {
//                System.err.println("Value must > 0, Input again:");
//            }
//            floors = input.inputInt();
//            status = floors > 0;
//        } while (!status);
//        return floors;
//    }

//    public String regexFreeService() {
//        String regex = "(Massage|Karaoke|Food|Drink|Car)";
//        System.out.println("Free Service:");
//        String freeService;
//        do {
//            freeService = input.inputString();
//            if (!freeService.matches(regex)) {
//                status = false;
//                System.err.println("Wrong format, Input again:");
//            }
//        } while (!status);
//        return freeService;
//    }
//
    public boolean regexName(String name){
        String regex = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$";
        if (!name.matches(regex)) {
            return false;
        }
        return true;
    }

    private boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean regexBirthday(String date) {
        String regex = "[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}";
        Date now = new Date();
        int yearNow = now.getYear() + 1900;
        int monthNow = now.getMonth() + 1;
        int dayNow = now.getDate();
        StringBuilder stringBuilder = new StringBuilder(date);
        int yearCustomer;
        int dayCustomer;
        int monthCustomer;
        if (date.matches(regex)) {
            yearCustomer = Integer.parseInt(stringBuilder.substring(0, 4));
            dayCustomer = Integer.parseInt(stringBuilder.substring(8));
            monthCustomer = Integer.parseInt(stringBuilder.substring(5, 7));
            if ((yearNow - yearCustomer) < 18) {
                return false;
            }
            if (yearNow - yearCustomer == 18) {
                if (monthNow < monthCustomer) {
                    return false;
                } else if (monthCustomer == monthNow) {
                    if (dayNow < dayCustomer) {
                        return false;
                    }
                }
            }
            if (yearCustomer < 1901) {
                return false;
            }
            if (monthCustomer > 12) {
                return false;
            }
            switch (monthCustomer) {
                case 2:
                    if (checkLeapYear(yearCustomer)) {
                        if (dayCustomer > 29) {
                            return false;
                        }
                    } else {
                        if (dayCustomer > 28) {
                            return false;
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
                        return false;
                    }
                    break;
                default:
                    if (dayCustomer > 30) {
                        return false;
                    }
            }
        } else {
            return false;
        }
        return true;
    }
//
//    public String regexGender() throws GenderException {
//        String regex = "(?i)(male|female|unknown)";
//        String string = input.inputString();
//        if (string.matches(regex)) {
//            string = string.toLowerCase();
//            string = string.substring(0, 1).toUpperCase() + string.substring(1);
//        } else {
//            throw new GenderException("Wrong format input, Input again:");
//        }
//        return string;
//    }

    public boolean regexIdNumber(String idNumber) {
        String regex = "[0-9]{9}";
        return idNumber.matches(regex);
    }

    public boolean regexPhoneNumber(String phoneNumber) {
        String regex = "(0|(\\+84))[0-9]{9}";
        return phoneNumber.matches(regex);
    }

    public boolean regexEmail(String email){
        String regex = "\\w+@\\w+(\\.\\w+){1,5}";
        return email.matches(regex);
    }
//
//    public String regexCustomerType() throws CustomerTypeException {
//        String regex = "(Diamond|Platinum|Gold|Silver|Member)";
//        String customerType = input.inputString();
//        if (!customerType.matches(regex)) {
//            throw new CustomerTypeException("Wrong format input, Input again:");
//        }
//        return customerType;
//    }
}
