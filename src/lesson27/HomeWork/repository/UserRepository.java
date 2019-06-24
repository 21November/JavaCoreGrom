package lesson27.HomeWork.repository;

import java.util.ArrayList;

public class UserRepository {

    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }


    public  User save(User user) throws Exception {

        if (user == null && users.contains(user))
            throw new Exception("user " + user.toString() + " not found");

        users.add(user);
        return user;
    }


    public User update(User user) throws Exception {

        if (user != null) {
            if (users.contains(user)) {
                users.set(users.indexOf(user), user);
                return users.get(users.indexOf(user));
            }
        }
        throw new Exception("user with id: " + user.toString() + " not found");

    }


    public void delete(long id) throws Exception {

        findById(id);

        if (users.contains(id)) {
            users.remove(users.indexOf(id));
        }

    }

    public User findById(long id) throws Exception {

        if (users.contains(id)) {
            return users.get(users.indexOf(id));
        }

        throw new Exception("user with id: " + id + " not found");

    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                '}';
    }
}
