package lesson5;

import java.util.Arrays;

public class FirstArray {
    public static void main(String[] args) {

        int a;    //declaration
        a = 10;   //initialisation

        // Первый метод создания массива
        //type of array [] name of array = new type of array [length of array]
        int[] firstArray = new int[4];   //declaration

        System.out.println(Arrays.toString(firstArray));

        //array name [index]  -  get array element
        firstArray [0] = 11;  //initialisation
        firstArray [1] = 200;
        firstArray [2] = -10;

        for(int i = 0; i < firstArray.length; i++) { // Метод получения длины массива .length
            System.out.println(firstArray[i]);
        }

        System.out.println(Arrays.toString(firstArray)); // Метод для красивого вывода массива Arrays.toString

        // Второй метод создания массива
        int b = 10;
        int[] secondArray = {1, 10, 15, 20, -50};
        System.out.println(Arrays.toString(secondArray));


        for(int element : secondArray) { // for-each - пробижатся по каждому элементу
            System.out.println(element);
        }

        for(int i = 0; i < firstArray.length; i++) {
            int element = firstArray[i];
            System.out.println(element);

        }
    }
}
