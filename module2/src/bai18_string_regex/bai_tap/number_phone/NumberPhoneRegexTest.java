package bai18_string_regex.bai_tap.number_phone;

public class NumberPhoneRegexTest {
    private static NumberPhoneRegex numberPhoneRegex;
    private static String[] phoneNumber = {"03-0135968452", "a5-563498", "88-0569435687", "000968561457", "06-2365978451", "880945368751"};

    public static void main(String[] args) {
        numberPhoneRegex = new NumberPhoneRegex();
        for (String phone : phoneNumber) {
            System.out.println("Number phone is: " + phone + " is valid " + numberPhoneRegex.validate(phone));
        }
    }
}
