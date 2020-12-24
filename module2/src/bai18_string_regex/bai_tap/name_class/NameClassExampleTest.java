package bai18_string_regex.bai_tap.name_class;

public class NameClassExampleTest {
    private static NameClassExample nameClassExample;
    public static final String[] nameClass = {"C1020G", "C0318G", "M0318G", "P0323A"};

    public static void main(String[] args) {
        nameClassExample = new NameClassExample();
        for (String name : nameClass) {
            System.out.println("Name class is " + name + " is valid:" + nameClassExample.validate(name));
        }
    }
}
