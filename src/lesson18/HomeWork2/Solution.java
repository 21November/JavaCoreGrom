package lesson18.HomeWork2;

import java.util.Arrays;
import static java.lang.Character.isDigit;

public class Solution {
    public static void main(String[] args) {
        String test = "101 Lesson18 5a 105 911 (100) 15!%";
        System.out.println(Arrays.toString(findNumbers(test)));

        String test2 = "";
        System.out.println(Arrays.toString(findNumbers(test2)));

        String test3 = new String();
        System.out.println(Arrays.toString(findNumbers(test3)));
    }

    //Напишите метод который будет принимать текст на вход и возвращать массив int[] всех чисел которые в нем содержаться.
    // Для каждого числа которое не является целым числом выводите в консоль “not a number” с новой строки
    //
    //НЕ используйте try-catch конструкцию для решения этой задачи
    public static int[] findNumbers(String text) {
        if (text == null || text.isEmpty()){
            return null;
        }

        String[] words = text.split(" ");

        int index = 0;

        for (String word : words){
            if (checkTheWord(word)){
                index++;

            }else {
                System.err.println("not a number");

            }

        }

        int[] numbers = new int[index];

        int index1 = 0;

        for (String word : words){
            if (checkTheWord(word)) {
                numbers[index1] = Integer.parseInt(word);
                index1++;
            }
        }
        return numbers;


    }
    // Проверка входящего слова посимвольно
    public static boolean checkTheWord(String input){
        char[] inputChars = input.toCharArray(); //создаем массив символов

        boolean checkLitter = false;
        for (Character ch : inputChars){
            if (isDigit(ch)){                    //определяем, является ли указанное значение типа char цифрой
                checkLitter = true;
            }else {                              //если указаное значение типа char цифрой не являеться то:
                checkLitter = false;             //присваеваем переменной значение false и останавливаем цыкл
                break;
            }
        }
        return checkLitter;
    }
}
