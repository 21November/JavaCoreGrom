package lesson19.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        //Тестовые данные:
        //Гарантрируется что на вход всех метод передаются объекты, которые не равны null

        File[] files1 = new File[1];

        String[] formatsSupported = new String[]{"doc", "txt", "mp3", "jpg", "fb2"};

        Storage storage1 = new Storage(9001, files1, formatsSupported, "Ukraine", 1500);

        File file1 = new File(1001,"Book", "doc", 1000);
        File file2 = new File(1002,"Music", "mp3", 5000);
        File file3 = new File(1003,"Book", "fb2", 500);
        //File file4 = new File(1004,"Future report", "txt", 200);
        File file5 = new File(1005,"Music", "mp3", 15000);
        File file6 = new File(1006,"Book", "doc", 900);
        File file7 = new File(1007,"Video", "mp4", 30000);
        File file8 = new File(1008,"Book", "fb2", 600);

        File[] files2 = new File[]{file3, file5, file6, file8, null, null, null};
        Storage storage2 = new Storage(9002, files2, formatsSupported, "Ukraine", 100000000);

        //--------------------------------------------method put-----------------------------------------
        System.out.println(" method put ");

        try {
            Controller.put(storage1, file1);
            System.out.println("-10- " + Arrays.toString(storage1.getFiles()));
        } catch (Exception e) {
            System.out.println("-10- " + e.getMessage());
        }

        //не подходящий формат файла
        try {
            Controller.put(storage1, file7);
            System.out.println("-11- " + Arrays.toString(storage1.getFiles()));
        } catch (Exception e) {
            System.out.println("-11- " + e.getMessage());
        }

        //недостаточно памяти в хранилище
        try {
            Controller.put(storage1, file2);
            System.out.println("-12- " + Arrays.toString(storage1.getFiles()));
        } catch (Exception e) {
            System.out.println("-12- " + e.getMessage());
        }

        //недостаточно места в хранилища
        //может ли такое быть?
        /*
        try {
            Controller.put(storage1, file3);
            System.out.println("-13- " + Arrays.toString(storage1.getFiles()));
        } catch (Exception e) {
            System.out.println("-13- " + e.getMessage());
        }*/

        System.out.println();
        //--------------------------------------------method delete-----------------------------------------

        System.out.println(" method delete ");
        System.out.println(Arrays.toString(storage2.getFiles()));

        //удаление существующего файла в хранилище
        try {
            Controller.delete(storage2, file8);
            System.out.println("-20- " + Arrays.toString(storage2.getFiles()));
        } catch (Exception e) {
            System.out.println("-20- " + e.getMessage());
        }

        //удаление несуществующего файла в хранилище
        try {
            Controller.delete(storage2, file2);
            System.out.println("-21- " + Arrays.toString(storage2.getFiles()));
        } catch (Exception e) {
            System.out.println("-21- " + e.getMessage());
        }

        System.out.println();
        //--------------------------------------------method transferAll-----------------------------------------
        System.out.println(" method transferAll ");
        System.out.println(Arrays.toString(storage2.getFiles()));
        System.out.println(Arrays.toString(storage1.getFiles()));


        //пересылаем файлы в переполненое хранилище
        try {
            Controller.transferAll(storage2, storage1);
            System.out.println("-30- " + Arrays.toString(storage1.getFiles()));
            System.out.println("-30- " + Arrays.toString(storage2.getFiles()));
        } catch (Exception e) {
            System.out.println("-30- " + e.getMessage());
        }

        //
        try {
            Controller.transferAll(storage1, storage2);
            System.out.println("-31- " + Arrays.toString(storage1.getFiles()));
            System.out.println("-31- " + Arrays.toString(storage2.getFiles()));
        } catch (Exception e) {
            System.out.println("-31- " + e.getMessage());
        }

        System.out.println();
        //--------------------------------------------method transferFile-----------------------------------------

        System.out.println(" method transferFile ");

        try {
            Controller.transferFile(storage1, storage2, 1001);
            System.out.println("-41- " + Arrays.toString(storage1.getFiles()));
            System.out.println("-41- " + Arrays.toString(storage2.getFiles()));
        } catch (Exception e) {
            System.out.println("-41- " + e.getMessage());
        }

        // переполненое хранилище
        try {
            Controller.transferFile(storage2, storage1, 1001);
            System.out.println("-42- " + Arrays.toString(storage1.getFiles()));
            System.out.println("-42- " + Arrays.toString(storage2.getFiles()));
        } catch (Exception e) {
            System.out.println("-42- " + e.getMessage());
        }

        // в тоже хранилище
        // могут ли быть одинаковые файлы в одном хранилище? С одинаковыми именами и id.
        try {
            Controller.transferFile(storage2, storage2, 1005);

            System.out.println("-43- " + Arrays.toString(storage2.getFiles()));
        } catch (Exception e) {
            System.out.println("-43- " + e.getMessage());
        }
    }
}
