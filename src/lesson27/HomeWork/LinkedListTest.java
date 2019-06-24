package lesson27.HomeWork;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println(useList().toString());
    }

    public static LinkedList<Order> useList(){

        LinkedList<Order> list1 = new LinkedList<>();
        LinkedList<Order> list2 = new LinkedList<>();

        Order order0 = new Order(1001, 100, "UA", "book", "12ab");
        Order order1 = new Order(1002, 200, "USD", "pen", "23bc");
        Order order2 = new Order(1003, 300, "EUR", "notebook", "34cd");
        Order order3 = new Order(1004, 200, "USD", "pen", "23bc");
        Order order4 = new Order(1005, 100, "UA", "book", "12ab");

        // 1й
        list1.add(order0);
        list1.add(order2);
        list1.add(order4);

        list2.add(order2);
        list2.add(order3);


        // 2й
        list1.add(2,order1);
        System.out.println("Добавление элемента по индексу в колекцию list1 " + list1.toString());
        System.out.println();

        // 3й
        list1.remove(1);
        System.out.println("Удаление элемента по индексу из колекции list1 " + list1.toString());
        System.out.println();

        // 4й
        list1.remove(order1);
        System.out.println("Удаление конкретного обьекта из колекции list1 " + list1.toString());
        System.out.println();

        // 5й
        list2.addAll(list1);
        System.out.println("Добавление колекции list1 в конец колекции list2 " + list2.toString());
        System.out.println();

        // 6й
        System.out.println("Проверка колекции list2 на наявность конкретных обьектов в ней на определенном участке колекции.");
        System.out.println("обьект с id 1001 на участке с индексами 0 - 3 не включительно - " + list2.subList(0, 3).contains(order0));
        System.out.println("обьект с id 1002 на участке с индексами 0 - 3 не включительно - " + list2.subList(0, 3).contains(order1));
        System.out.println("обьект с id 1003 на участке с индексами 0 - 3 не включительно - " + list2.subList(0, 3).contains(order2));
        System.out.println();
        list2.subList(0,2).clear();
        System.out.println("Удаляем из колекции list2 обьекты под индексами 0 и 1 " + list2.toString());
        System.out.println();

        // 7й
        list2.set(0, order2);
        System.out.println("Заменяем конкретный обьект колекции list2 по индексу другим обьектом" + list2.toString());
        System.out.println();

        // 8й
        list1.clear();
        System.out.println("Чистим колекцию list1 " + list1.toString());
        System.out.println();

        // 9й
        System.out.println("Проверка колекции list2 на наявность конкретных обьектов в ней.");
        System.out.println("обьект с id 1001 - " + list2.contains(order0));
        System.out.println("обьект с id 1003 - " + list2.contains(order2));
        System.out.println("обьект с id 1005 - " + list2.contains(order4));
        System.out.println();

        // 10й
        Object[] objects = list2.toArray();
        System.out.println(Arrays.toString(objects));
        System.out.println();

        list2.add(order0);
        list2.add(order4);
        list2.add(order2);

        return list2;
    }
}
