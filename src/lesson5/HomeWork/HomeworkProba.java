package lesson5.HomeWork;

import java.util.Arrays;

public class HomeworkProba {
    public static void main(String[] args) {
        int[] array = {7, 4, 6, 2, 9, 0, 12};
        sortAscending(array);
    }

    public static void sortAscending(int[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }


}

