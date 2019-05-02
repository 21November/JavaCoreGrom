package lesson15.HomeWork.UserRepository;

import java.util.Arrays;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User save(User user){
        //добавляет юзера и возвращает его
        if (user == null) {
            return null;
        }

        if (findUser(user) != null){
            return null;
        }
        int index = 0;
        for (User us : users) {
            if (us == null) {
                users[index] = user;
                break;
            }
            index++;
        }
        return findUser(user);


    }

    public User update(User user) {
        //обновляет текущего юзера в массиве (перезаписывать) и возвращать его. Если юзера нет, результат метода null

        if (user == null) {
            return null;
        }

        int index = 0;
        for (User us : users) {
            if (users[index] != null && us != null && us.getId() == user.getId()) {
                users[index] = user;
                break;
            }
            index++;
        }
        return findUser(user);

    }

    public void delete(long id) {
        //удаляет юзера с массива, если юзера с таким id нет - возвращает null

        int index = 0;
        for (User us : users) {
            if (users[index] != null && us != null && us.getId() == id) {
                users[index] = null;
                break;
            }
            index++;
        }
    }

    public User findUser(User user){
        //нахождение юзера в условной базе данных
        if (user == null) {
            return null;
        }

        for (User us : users) {
            if (user.equals(us))
                return user;
        }
        return null;

    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}
