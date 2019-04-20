package lesson11.biginterfeceexample;

public class SimpleReader implements Readable {

    //class object = new
    //object.
    //null - empty object


    static String test;

    public static void main(String[] args) {
        System.out.println(test);

        // null pointer exception
    }

    @Override
    public void readFilesFromStorage(Storage storage) {
        for (File file : storage.getFiles()){    //Считываем все файлы со  storage
            if (file != null)
                System.out.println(file.getName());  // Берем имя каждово файла и печатаем в консоль
            else
                System.out.println(file);
        }
    }
}
