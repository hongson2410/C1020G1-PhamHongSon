package bai18_string_regex.bai_tap.number_phone;

public class NumberPhoneRegex {
    private static final String NUMBER_PHONE_REGEX = "[0-9]{2}[-][0][0-9]{9}";

    public boolean validate(String regex) {
        return regex.matches(NUMBER_PHONE_REGEX);
    }
}
