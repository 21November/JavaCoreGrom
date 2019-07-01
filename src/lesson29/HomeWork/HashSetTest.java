package lesson29.HomeWork;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {

        System.out.println(useHashSet().toString());
        //useHashSet();
    }

    public static HashSet useHashSet(){

        HashSet<Order> set = new HashSet<>();
        HashSet<Order> set1 = new HashSet<>();

        Order order1 = new Order(1001, 100, "USD", "book", "b101");
        Order order2 = new Order(1002, 1000, "UAH", "book", "b102");
        Order order3 = new Order(1003, 50, "EUR", "book", "b103");
        Order order4 = new Order(1004, 110, "USD", "book", "b104");
        Order order5 = new Order(1005, 1100, "UAH", "book", "b105");
        Order order6 = new Order(1006, 55, "EUR", "book", "b106");

        // 1й ----- add(E e) Дщбавление элементов в колекцию
        set.add(order1);
        set.add(order2);
        set.add(order3);
        set.add(order4);
        System.out.println(set.toString());
        System.out.println();

        set1.add(order6);
        set1.add(order5);
        set1.add(order4);
        set1.add(order1);

        // 2й ----- remove(E e) Удаление элемента из колекции по его имени
        set.remove(order3);
        System.out.println(set.toString());
        //System.out.println();

        // 3й ----- retailAll(Collection c)
        System.out.println(set1.toString());
        set.retainAll(set1);            // Метод удаляет из первой колекции все элементы кроме общих со второй колекцией

        //System.out.println("set" + set.toString());
        //set1.removeAll(set);         //Метод удаляет из первой колекции все общие элементы со второй колекцией

        System.out.println("set" + set.toString());
        System.out.println();

        // 4й Object[] toArray()
        Object[] objects = set1.toArray();
        System.out.println(Arrays.toString(objects));
        System.out.println();

        // 5й size() Вщозвращает количество элементов в колекции
        System.out.println(set.size());
        System.out.println(set1.size());
        System.out.println();

        // 6й Iterator
        Iterator <Order> iteratorOrder = set.iterator();
        while (iteratorOrder.hasNext()) {
            System.out.println(iteratorOrder.next().toString());
        }

        System.out.println();

        Iterator <Order> iteratorOrder1 = set1.iterator();
        while (iteratorOrder1.hasNext()) {
            System.out.println(iteratorOrder1.next().toString());
        }

        set1.add(order2);

        return set1;
    }
}
