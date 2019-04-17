package lesson5.HomeWork;

import java.util.Arrays;

public class HomeWorkArraySorting {
    public static void main(String[] args) {
        int[] array = {5, -5, 15, -10, 25, 0, 10, -20, -15, 20, -25};
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));
        sortAscending(array);
        sortDescending(array);
    }

    static int[] sortAscending(int[] array) {

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;
                }
            }
        }
        //System.out.println(Arrays.toString(array));
        return array;
    }

    static int[] sortDescending(int[] array) {

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] < array[i+1]){
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;
                }
            }
        }
        //System.out.println(Arrays.toString(array));
        return array;
    }
}
