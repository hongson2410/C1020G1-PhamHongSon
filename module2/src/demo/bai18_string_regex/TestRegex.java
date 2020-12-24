package demo.bai18_string_regex;

public class TestRegex {

    public static void main(String[] args) {
//        String str = "cd";

//        System.out.println(str.matches("[ab]"));
//        System.out.println(str.matches("(ab|cd)"));

//        String regex = "[\w0-9]+@[a-zA-Z]+(.com|.abc)";
//        System.out.println("123@gmail.com".matches(regex));


        System.out.println("+84".matches("(\\+84|0)[0-9]*"));
    }
}
