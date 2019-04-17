package lesson8.HomeWork;

public class Demo {
    public static void main(String[] args) {
        int[] array = {1, 0, 15, 5, 11, 45, 60, 10};

        Adder adder = new Adder();

        System.out.println(adder.check(array));
        System.out.println(adder.add(2147483647,2147483647));
    }
}
