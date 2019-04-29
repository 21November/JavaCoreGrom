package lesson9.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User[] users = new User[10];
        users[0] = new User(1001, "Den", "20");
        users[1] = new User(1002, "Tom", "201");
        users[2] = new User(1003, "Debi", "40");
        users[3] = new User(1004, "Jack", "5");
        users[4] = new User(1005, "Jack", "5");


        UserRepository userRepository = new UserRepository(users);
        //System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //    part2 _____________________________________________
        //    getUserNames() - для получения массива имен пользователей
        //    getUserIds() - для получения массива id пользователей
        //    getUserNameById(long id) - для получения имени пользователя, по его id
        System.out.println();
        System.out.println("part2:");
        System.out.println();

        System.out.println(Arrays.toString(userRepository.getUserNames()));
        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println(userRepository.getUserNameById(1004));
        System.out.println(userRepository.getUserNameById(1000));


        //    part3 _____________________________________________
        //  getUserByName(String name) - нахождение юзера по имени
        //  getUserById(long id) - нахождение юзера по id
        //  getUserBySessionId(String sessionId) - нахождение юзера по sessionId
        System.out.println();
        System.out.println("part3:");
        System.out.println();

        System.out.println(userRepository.getUserByName("Debi"));
        System.out.println(userRepository.getUserByName("Jack")); //вариант когда имена повторяются
        System.out.println(userRepository.getUserByName("Maik")); //отсутствующее имя в массиве
        System.out.println(userRepository.getUserByName("null"));
        System.out.println(userRepository.findById(1004));
        System.out.println(userRepository.findById(1000));          //отсутствующее ID в массиве возвращает null
        System.out.println(userRepository.getUserBySessionId("201"));
        System.out.println(userRepository.getUserBySessionId("2012"));//отсутствующее sessionId в массиве возвращает null
        System.out.println(userRepository.getUserBySessionId("null"));



        //    part 4 __________________________________________________
        //    test save

        //  Сохранение юзера
        //  сохранение того же юзера
        //  когда нет места в массиве
        //  когда сохраняем null
        System.out.println();
        System.out.println("part4:");
        System.out.println();

        User user = new User(1010, "Ann", "1w21212");
        userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        int n = 15;
        while (n > 0){
            User user1 = new User(n, "Ann", "1w21212");
            userRepository.save(user1);
            System.out.println(userRepository.save(user1));
            n--;
        }

        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        userRepository.save(null);

        //     part 5 ________________________________________________
        //  test update
        //  обновить юзера
        //  когда нет юзера на обновление
        //  когда обновляем null
        System.out.println();
        System.out.println("part5:");
        System.out.println();

        user = new User(5001, "Ann", "eracte");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        user = new User(9999, "Ann", "eracte");
        System.out.println(userRepository.update(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.update(null);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        // удаление юзера

        userRepository.delete(1010);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        userRepository.delete(100);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
    }
}
