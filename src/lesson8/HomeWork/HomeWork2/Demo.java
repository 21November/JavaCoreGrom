package lesson8.HomeWork.HomeWork2;

import java.util.Date;

public class Demo {

    Date date = new Date();
    //Student student1 = new Student("Jack", "Honda", 3, courses);
    //Student student2 = new Student("Maik", "Hous", 3, courses);

    //Student[] student = {};
    //Course course1 = new Course(date, "History", 100, "Wilson", student);

    Course[] courses = {};

    public Student createHighestParent(){
        Student student = new Student("Denis", "Karter", 3, courses);
        return student;
    }

    public SpecialStudent createLowestChild(){
        SpecialStudent specialStudent = new SpecialStudent("Jack", "Smitt", 2, courses, 1001, "@gmail");
        return specialStudent;
    }
}
