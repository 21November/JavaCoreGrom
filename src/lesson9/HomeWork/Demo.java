package lesson9.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User user1 = new User(10, "Tom", "1");
        User user2 = new User(20, "Pit", "2");
        User user3 = new User(30, "Tom", "3");
        User user4 = new User(40,"Alisa", "4");


        User[] users = new User[5];
        users[4] = user1;
        users[1] = user2;
        users[2] = user3;

        UserRepository userRepository = new UserRepository(users);

        System.out.println(Arrays.toString(userRepository.getUserNames()));
        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println(userRepository.getUserNameById(30));

        System.out.println(userRepository.getUserByName("Alisa"));
        //System.out.println(userRepository.getUserById(40));
        System.out.println(userRepository.getUserBySessionId("4"));

        System.out.println(" ");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
        System.out.println(" ");

        System.out.println(userRepository.save(user4));
        System.out.println(" ");

        System.out.println(userRepository.update(user4));
        System.out.println(" ");

        userRepository.delete(20);
        System.out.println(users);

    }
}
