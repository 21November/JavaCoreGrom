package lesson2.HomeWork2;

public class SumAndDivision {
    public static void main(String[] args) {

        int res = 0;
        for(int a = 1; a <= 1000; a++) {
            res += a;
        }

        int div = res / 1234;
        int mod = res % 1234;

        boolean res1 = mod > div;
        System.out.println(res1);

    }
}
