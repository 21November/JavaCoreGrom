package lesson15.HomeWork.UserRepository;

import java.util.Arrays;

public class DemoUserRepository {
    public static void main(String[] args) {

        User user1 = new User(1001, "Jack", "12");
        User user2 = new User(1002, "Jack1", "13");
        User user3 = new User(1003, "Jack2", "14");
        User user4 = new User(1004, "Jack3", "15");
        User user5 = new User(1005, "Jack", "12");
        User user6 = new User(1006, "Jack5", "17");
        User user7 = new User(1002, "Jack100", "1300");
        User user8 = new User(1007, "Jack6", "18");


        User[] users = new User[]{user1, user2, user3, user4, null, null, null, null, null};

        UserRepository userRepository = new UserRepository(users);
        System.out.println(userRepository.toString());
        System.out.println();

        //Тест метода save:

        System.out.println(userRepository.save(null));  //записываем null
        System.out.println(userRepository.save(user6));      // записываем нового user
        System.out.println(userRepository.save(user3));      // записываем существующего юзера
        System.out.println(userRepository.save(user5));      // записываем нового юзера с новым id но с повторяющимися полями name и sessionId
        System.out.println(userRepository.toString());
        System.out.println();

        //Тест метода update:

        System.out.println(userRepository.update(null));  //записываем null
        System.out.println(userRepository.update(user7));      // записываем нового user
        System.out.println(userRepository.update(user3));      // записываем существующего юзера
        System.out.println(userRepository.update(user8));      // записываем нового юзера который отсутствует в массиве
        System.out.println(userRepository.toString());
        System.out.println();

        //Тест метода delete:

        userRepository.delete(1007);
        userRepository.delete(1005);
        System.out.println(userRepository.toString());
    }
}
