package lesson19.HomeWork;

import java.util.Arrays;

public class Controller {

    // добавляет файл в хранилище. гарантируется что файл уже есть в условной БД
    public static void put(Storage storage, File file) throws Exception {
        //if (file == null)


        checkFormat(storage, file);
        fileExists(storage, file.getId());

        if ((storage.getStorageSize() - sumSizesFilesInStorage(storage)) < file.getSize()) {
            throw new Exception("Error. No free space in the storage " + storage.getId());
        }

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                break;
            }
        }
    }

    // - удаляет файл из хранилища
    public static void delete(Storage storage, File file) throws Exception {

        checkIdByName(storage, file);

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(file)) {
                storage.getFiles()[i] = null;
                break;
            }

        }
    }

    //- трансфер всех файлов из одного хранилища в другое
    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        //Возможные проверки:
        //1.Количество свободной памяти storageTo для приема всех файлов от storageFrom
        //2.Существования идентичных файлв в storageTo и storageFrom
        //3.Поддерживаемость форматов storageTo относительно файлов из storageFrom
        //??? 4.Возможное ограничение дли нассива хранилища storageTo, из за которго не возможно перенести все файлы из хранилища storageFrom

        validateAll(storageFrom, storageTo);

        for (File file : storageFrom.getFiles()) {
            if (file != null) {
                put(storageTo, file);
            }
        }

    }

    //- трансфер файла с хранилища одного хранилища в другое по его айди.
    // гарантируется что файл с таким id точно есть в хранилище storageFrom
    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        put(storageTo, checkIdById(storageFrom, id));

    }

    //Проверка формата файла в соответствии с поддерживаемыми форматами
    private static boolean checkFormat(Storage storage, File file) throws Exception {

        //String[] formats = storage.getFormatsSupported();
        for (String string : storage.getFormatsSupported()) {
            if (file.getFormat().equals(string))
                return true;
        }
        throw new Exception(" Error. Format the file = " + file.getFormat() + ", storage id = " +
                storage.getId() + " for file with id = " + file.getId() + ". The format should be " +
                Arrays.toString(storage.getFormatsSupported()));
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

    private static boolean checkIdByName(Storage storage, File file) throws Exception {

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(file)) {
                return true;
            }
        }
        throw new Exception("Error. In storage " + storage.getId() + " file with id " + file.getId() + " not found");
    }

    private static File checkIdById(Storage storage, long id) throws Exception {

        for (File file : storage.getFiles()) {
            if (file != null && file.getId() == id)
                return file;
        }
        throw new Exception("Error. In storage " + storage.getId() + " file with id " + id + " not found");
    }

    private static void validateAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (sumSizesFilesInStorage(storageFrom) > storageTo.getStorageSize() - sumSizesFilesInStorage(storageTo))
            throw new Exception("Error. Storage size " + storageTo.getId() + " size is not enough for transfer");

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            fileExists(storageTo, storageFrom.getFiles()[i].getId());
            checkFormat(storageTo, storageFrom.getFiles()[i]);
        }
    }

    public static void fileExists(Storage storage, long id) throws Exception {
        for (File file : storage.getFiles()) {
            if (file != null && file.getId() == id)
                throw new Exception("Error. File with id " + id + " already exists in the storage" + storage.getId());
        }
    }
}
