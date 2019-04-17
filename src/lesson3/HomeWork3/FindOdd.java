package lesson3.HomeWork3;

public class FindOdd {
    public static void main(String[] args) {
        int sum = 0;
        int sum2 = 0;

        for(int a = 1; a <= 1000; a+=2) {
            System.out.println("Found");
            sum += a;
        }

        sum2 = sum * 5;

        if(sum2 > 5000){
            System.out.println("Bigger");
        }
        else {
            System.out.println("Smaller or equal");
        }

    }
}
