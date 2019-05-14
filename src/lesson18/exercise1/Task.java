package lesson18.exercise1;

public class Task {

    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        String[] fileNames = {"test1", "test2"};
        fileStorage.setFiles(fileNames);

        System.out.println("Start printing name");
        printer(fileStorage);
        System.out.println("Done");

        String[] fileNames2 = {"test1", "test2", "test3", "test4", "test5"};
        fileStorage.setFiles(fileNames2);
        printer(fileStorage);

        String[] fileNames3 = {"test1", "test2", "test3", "test4", null};
        fileStorage.setFiles(fileNames3);
        printer(fileStorage);
    }


    public static void printer(Storage storage){
        String [] names = storage.getFiles();

        try {
            System.out.println("5th na,e is " + names[4]);
        }catch (Exception e){
            System.out.println("5h name can not be found...");
            //System.err.println(e.getMessage());
        }

        //solution 2
        //HW



    }
}
