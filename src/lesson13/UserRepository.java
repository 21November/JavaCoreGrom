package lesson13;

public class UserRepository {
    private User[] users = new  User[10];

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames(){
        int length = getUsers().length;
        int counter = 0;

        for (int index1 = 0; index1 < length; index1++){
            if (getUsers()[index1] != null){
                counter++;
            }
        }

        String[] names = new String[counter];
        int index3 = 0;

        for (int index2 = 0; index2 < length; index2++){
            if (getUsers()[index2] != null){
                names[index3] = getUsers()[index2].getName();
                index3++;
            }
        }
        return names;
    }

    public long[] getUserIds(){
        int length = getUsers().length;
        int counter = 0;

        for (int index1 = 0; index1 < length; index1++){
            if (getUsers()[index1] != null){
                counter++;
            }
        }

        long[] userIds = new long[counter];
        int index3 = 0;

        for (int index2 = 0; index2 < length; index2++){
            if (getUsers()[index2] != null){
                userIds[index3] = getUsers()[index2].getId();
                index3++;
            }
        }
        return userIds;
    }

    public String getUserNameById(long id){
        int index = 0;

        for (long userId : getUserIds()){
            if (userId == id) {
                return getUserNames()[index];
            }
            index++;
        }
        return null;
    }

    public User getUserByName(String name){

        for (int index = 0; index < getUsers().length; index++){
            if (getUsers()[index] != null && getUsers()[index].getName() == name) {
                return getUsers()[index];
            }

        }
        return null;
    }

    private User findById(long id){

        for (int index = 0; index < getUsers().length; index++){
            if (getUsers()[index] != null && getUsers()[index].getId() == id) {
                return getUsers()[index];
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId){

        for (int index = 0; index < getUsers().length; index++){
            if (getUsers()[index] != null && getUsers()[index].getSessionId() == sessionId) {
                return getUsers()[index];
            }
        }
        return null;
    }

    public User save(User user){

        User oldUser = findById(user.getId());

        for (int index = 0; index < getUsers().length; index++){
            if (user != null && oldUser != user && getUsers()[index] == null){
                getUsers()[index] = user;
                return getUsers()[index];
            }
        }
        return null;
    }

    public User update(User user){

        User oldUser = findById(user.getId());

        for (int index = 0; index < getUsers().length; index++){
            if (oldUser != null && oldUser.getId() == user.getId()){
                getUsers()[index] = user;
                return getUsers()[index];
            }
        }
        return null;
    }

    public void delete(long id){

        for (int index = 0; index < getUsers().length; index++){
            if (findById(id) == getUsers()[index]){
                getUsers()[index] = null;
            }
        }
    }


}
