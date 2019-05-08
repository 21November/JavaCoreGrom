package lesson16;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {

       String test = "someStringExample";

        System.out.println(test.isEmpty());//не пустой стринг, метод возвращает false

        System.out.println("".isEmpty()); //пустой стринг, метод возвращает true

        System.out.println(test.length());

        System.out.println(test.charAt(2));

        String res = test.replace("me","T");
        System.out.println(res);

        System.out.println(test.replaceAll("me","T"));

        //String regex = "{a-Z}";

        System.out.println(test);
        System.out.println(test.contains("mes"));

        System.out.println(test);
        String phase = "Hello there guys";
        System.out.println(Arrays.toString(phase.split(" ")));

        System.out.println(" test a".trim());

        System.out.println(phase.substring(5));
        System.out.println(phase.substring(5, 10).trim());


        System.out.println(test.toUpperCase());
        System.out.println(test.toLowerCase());

        test.equals("eeee");
        test.intern();

        test.getBytes();
    }
}
