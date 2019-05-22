package lesson19.HomeWork;

import java.util.Objects;
import static java.lang.Character.isLetterOrDigit;

public class File {
    private long id;
    private String name;    //Имя файла не может быть больше 10 символов, то есть файл с таким именем не может быть создан
    private String format;
    private long size;      //размер файла в байтах

    public File(long id, String name, String format, long size) {
        if (!testLengthNameFile(name))
            throw new RuntimeException("Error. Filename cannot be more than 10 characters");

        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;
    }
    private static boolean testLengthNameFile(String name){
        char[] chArr = name.toCharArray();
        if (chArr.length > 10)
            return false;

        for (char c : chArr) {
            if (!isLetterOrDigit(c))
                return false;
        }
        return true;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return id == file.id && name.equals(file.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                '}';
    }
}
