package lesson27.HomeWork.repository;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        User user1 = new User(1001, "Daniil", "12as");
        User user2 = new User(1002, "Maxs", "12as");
        User user3 = new User(1003, "Nik", "45qw");
        User user4 = new User(1004, "Say", "45qw");
        User user5 = new User(1005, "Dori", "78zx");

        ArrayList<User> arrayList = new ArrayList<>();

        UserRepository userRepository = new UserRepository(arrayList);


        System.out.println("Method save");
        System.out.println(userRepository.toString());
        System.out.println();
        try {
            userRepository.save(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            userRepository.save(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            userRepository.save(user3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userRepository.toString());
        System.out.println("-------------------------------------");
        System.out.println();

    }
}
