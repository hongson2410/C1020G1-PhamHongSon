package bai18_string_regex.bai_tap.number_phone;

public class NumberPhoneRegex {
    private static final String NUMBER_PHONE_REGEX = "\\d{2}[-][0]\\d{9}";

    public boolean validate(String regex) {
        return regex.matches(NUMBER_PHONE_REGEX);
    }
}
