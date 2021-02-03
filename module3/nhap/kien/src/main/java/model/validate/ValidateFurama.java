package model.validate;

public class ValidateFurama {

    private static final String NAME_CUSTOMER = "^(KH-)\\d{4}$";

    private static final String NAME_SERVICE = "^(DV-)\\d{4}$";

    private static final String PHONE_REGEX = "^(090|091|[(]84[+][)]90|[(]84+[)]91)\\d{7}$";

    private static final String ID_REGEX = "^\\d{9}";

    private static final String EMAIL_REGEX = "^[a-z]+@[a-z]+([.][a-z]{2,})+$";

    private static final String NUMBER_REGEX = "^\\d[.]*$";

    public static boolean nameCustomer(String name){
        return name.matches(NAME_CUSTOMER);
    }

    public static boolean nameService(String name){
        return name.matches(NAME_SERVICE);
    }

    public static boolean phoneRegex(String phone){ return phone.matches(PHONE_REGEX);}

    public static boolean idRegex(String idCard){ return idCard.matches(ID_REGEX);}

    public static boolean emailRegex(String email){ return email.matches(EMAIL_REGEX);}

    public static boolean numberRegex(String number){
        return number.matches(number);
    }
}
