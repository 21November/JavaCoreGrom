package lesson19.HomeWork;

import java.util.Arrays;

public class Controller {

    // добавляет файл в хранилище. гарантируется что файл уже есть в условной БД
    public static void put(Storage storage, File file) throws Exception{
        //if (storage == null || file == null)
        //    return;

        if (!checkFormat(storage, file)) {
            throw new Exception(" Error. Format the file = " + file.getFormat() + ", storage id = " +
                    storage.getId() + " for file with id = " + file.getId() + ". The format should be " +
                    Arrays.toString(storage.getFormatsSupported()));
        }

        if ((storage.getStorageSize() - sumSizesFilesInStorage(storage)) < file.getSize()) {
            throw new Exception("Error. No free space in the storage " + storage.getId());
        }

        //File[] files = storage.getFiles();

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                break;
            }//else throw new Exception("Error. The store is full " + storage.getId());
        }
    }

    // - удаляет файл из хранилища
    public static void delete(Storage storage, File file) throws Exception{

        if (!checkIdByName(storage, file)){
            throw new Exception("Error. In storage " + storage.getId() + " file with id " + file.getId() + " not found");
        }

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(file)) {
                    storage.getFiles()[i] = null;
                    break;
            }

        }
    }

    //- трансфер всех файлов из одного хранилища в другое
    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception{

        for (File file : storageFrom.getFiles()) {
            if (file != null) {
                put(storageTo, file);
            }
        }

    }

    //- трансфер файла с хранилища одного хранилища в другое по его айди.
    // гарантируется что файл с таким id точно есть в хранилище storageFrom
    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{

        put(storageTo, checkIdById(storageFrom, id));

    }



    //Проверка формата файла в соответствии с поддерживаемыми форматами
    private static boolean checkFormat(Storage storage, File file){

        String[] formats = storage.getFormatsSupported();
        for (String string : formats){
            if (file.getFormat().equals(string))
                return true;
        }
        return false;
    }
    //Сумировние размеров файлов конкретного хранилища
    private static long sumSizesFilesInStorage(Storage storage) {

        long sum = 0;
        for (File file : storage.getFiles()) {
            if (file != null) {
                sum += file.getSize();
            }
        }
        return sum;
    }

    private static boolean checkIdByName(Storage storage, File file) {

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(file)) {
                return true;
            }
        }
        return false;
    }

    private static File checkIdById(Storage storage, long id) throws Exception {

        for (File file : storage.getFiles()) {
            if (file != null && file.getId() == id)
                return file;
        }
        throw new Exception("Error. In storage " + storage.getId() + " file with id " + id + " not found");
    }
}
