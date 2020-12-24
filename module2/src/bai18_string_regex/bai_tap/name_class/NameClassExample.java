package bai18_string_regex.bai_tap.name_class;

public class NameClassExample {
    private static final String CLASS_NAME_REGEX = "[CAP]\\d{4}[GHIKLM]";

    public boolean validate(String regex) {
        return regex.matches(CLASS_NAME_REGEX);
    }
}
