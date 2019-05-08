package lesson16;

import lesson15.HomeWork.UserRepository.User;

public class StringCompare {
    public static void main(String[] args) {

        System.out.println(new String("abc") == new String("abc"));
        System.out.println(new String("abc").equals(new String("abc")));


        System.out.println("abc" == "abc");//
        System.out.println("Abc".equals("abc"));//+

        String s1 = "test";
        String s2 = "test";

        System.out.println(s1 == s2);

//        User user1 = new User();
//        User user2 = new User();


        /*
        test.equals("eeee");
        test.intern();

        test.getBytes();*/
    }
}
