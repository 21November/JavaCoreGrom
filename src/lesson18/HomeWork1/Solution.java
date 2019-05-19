package lesson18.HomeWork1;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String test = "101 Lesson18 5a 105 911";
        System.out.println(Arrays.toString(findNumbers(test)));

        String test2 = "";
        System.out.println(Arrays.toString(findNumbers(test2)));

        String test3 = new String();
        System.out.println(Arrays.toString(findNumbers(test3)));
    }


    //Напишите метод который будет принимать текст на вход и возвращать массив int[] всех чисел которые в нем содержаться.
    // Для каждого слова которое не является целым числом выводите в консоль “not a number” с новой строки.
    // Под слово подразумевается совокупность символом разделенных пробелом
    //
    //Используйте try-catch конструкцию для решения этой задачи
    public static int[] findNumbers(String text){
        if (text == null || text.isEmpty()){
            return null;
        }

        String[] words = text.split(" ");

        int wordsAmount = 0;
        for (String word : words){
            try {
                Integer.parseInt(word);
                wordsAmount++;

            }catch (Exception e){
                System.out.println("not a number");
            }
        }

        int[] numbers = new int[wordsAmount];

        int index = 0;

        for (String word : words){
            try {
                int number = Integer.parseInt(word);
                numbers[index] = number;
                index++;
            }catch (Exception e){

            }
        }
        return numbers;
    }
}
