package lesson4.HomeWork4;

public class HomeWorkMultiples {
    public static void main(String[] args) {
        short a = 1;
        short b = 100;
        int n = 3;

        System.out.println(findDivCount(a, b, n));
    }

    public static int findDivCount(short a, short b, int n) {
        int count = 0;

        for (int i = a; i <= b; i++) {
            if (i % n == 0)
                count++;
        }
        return count;
    }

}
