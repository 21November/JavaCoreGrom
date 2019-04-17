package lesson5.HomeWork;

public class HomeWorkUniqueCount {
    public static void main(String[] args) {
        int[] array = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};
        System.out.println(uniqueCount(array));
    }

    public static int uniqueCount(int[] array) {
        int countUnique = 0;
        int countRepeat = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    countRepeat++;
                    break;
                }
            }
        }
        return countUnique = count - countRepeat;
    }
}
