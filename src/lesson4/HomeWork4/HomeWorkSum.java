package lesson4.HomeWork4;

public class HomeWorkSum {
    public static void main(String[] args) {
        System.out.println(compareSums(5, 15,2,10));
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        return sum(a, b) > sum(c, d) ? true : false;
    }

    public static long sum(int from, int to) {
        long sum = 0;
        for (long i = from; i <= to; i++) {
            sum += i;
        }
        return sum;
    }
}
