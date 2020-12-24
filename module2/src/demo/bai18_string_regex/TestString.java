package demo.bai18_string_regex;

public class TestString {

    public static void main(String[] args) {
//        String str1 = "abc";
//        String str2 = "abc";
//        String str3 = new String("abc");
//        String str4 = new String("abc");
//
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        System.out.println(str3 == str4);


//        System.out.println("abc".equals("Abc"));
//        System.out.println("abc".equalsIgnoreCase("Abc"));

//        String str = "Hello World";
//        System.out.println(str.charAt(4));
//        System.out.println(str.indexOf("world"));
//        System.out.println(str.contains("world"));
//
//
//        int a = 3;
//        Integer b = a; // autoboxing;
//
//        Integer c = 3;
//        int d = c; // unboxing


        String str = "abc";
        StringBuilder stringBuilder = new StringBuilder(str);

        for (int i = 0; i < 5; i++) {
            stringBuilder.append("1");
        }

        str = stringBuilder.toString();
        System.out.println(str);

    }
}
