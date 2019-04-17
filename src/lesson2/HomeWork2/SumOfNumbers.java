package lesson2.HomeWork2;

public class SumOfNumbers {
    public static void main(String[] args) {

        long res = 0;

        for(int a = 0; a <= 10000000; a++) {
            res += a;
        }
        System.out.println("Sum is " + res);

        int s = 0;
        long res1 = 0;

        while(10000001 > s) {
            res1 += s++;
        }

        System.out.println("Sum is " + res1);



    }
}
