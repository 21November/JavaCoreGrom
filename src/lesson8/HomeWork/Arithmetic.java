package lesson8.HomeWork;

public class Arithmetic {

    public boolean check(int[] array){
        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }
        if ((max + min) > 100){
            return true;
        }
        else {
            return false;
        }
    }
}
