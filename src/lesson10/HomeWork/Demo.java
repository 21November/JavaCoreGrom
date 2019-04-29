package lesson10.HomeWork;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Tom", "Киев", "мужской");
        Customer customer2 = new Customer("Vita", "Днепр", "Женский");
        Customer customer3 = new Customer("Jack", "Одесса", "Мужской");
        Customer customer4 = new Customer("Тест", "Харьков", "Женский");

        //test Electronics Order
        // 1. пол заказчика Мужской
        ElectronicsOrder eOrder1 = new ElectronicsOrder("phone", new Date(), "Одесса", "Киев", 100, customer1, 12 );
        eOrder1.validateOrder();
        eOrder1.calculatePrice();
        eOrder1.confirmShipping();
        // 2. itemName null - действие не требуеться
        ElectronicsOrder eOrder11 = new ElectronicsOrder(null, new Date(), "Киев", "Киев", 100, customer2, 12 );
        eOrder11.validateOrder();
        eOrder11.calculatePrice();
        eOrder11.confirmShipping();
        // 3. basePrice < 100
        ElectronicsOrder eOrder111 = new ElectronicsOrder(null, new Date(), "Киев", "Киев", -100, customer2, 12 );
        eOrder11.validateOrder();
        eOrder11.calculatePrice();
        eOrder11.confirmShipping();
        // 4. shipFromCity null
        ElectronicsOrder eOrder112 = new ElectronicsOrder("phone", new Date(), null, "Киев", 100, customer2, 12 );
        eOrder111.validateOrder();
        eOrder111.calculatePrice();
        eOrder111.confirmShipping();
        // 5. значение поля shipFromCity выходит за пределы допустимого
        ElectronicsOrder eOrder113 = new ElectronicsOrder("phone", new Date(), "Купянск", "Киев", 100, customer2, 12 );
        eOrder112.validateOrder();
        eOrder112.calculatePrice();
        eOrder112.confirmShipping();

        ElectronicsOrder eOrder2 = new ElectronicsOrder("TV", new Date(), "Киев", "Днепр", 1100, customer2, 12 );
        eOrder2.validateOrder();
        eOrder2.calculatePrice();
        eOrder2.confirmShipping();

        // test Furniture Order

        // basePrice < 500
        FurnitureOrder fOrder1 = new FurnitureOrder("chair", new Date(), "Киев", "Одесса", 400, customer3, "12V2");
        fOrder1.validateOrder();
        fOrder1.calculatePrice();
        fOrder1.confirmShipping();
        // имя клиента "Тест"
        FurnitureOrder fOrder2 = new FurnitureOrder("chair", new Date(), "Львов", "Харьков", 5600, customer4, "12V1");
        fOrder2.validateOrder();
        fOrder2.calculatePrice();
        fOrder2.confirmShipping();

        System.out.println("Confirmation date: " + eOrder1.getDateConfirmed() + " Shipment date: " + eOrder1.getDateShipped() + " Total price: " + eOrder1.getTotalPrice());
        System.out.println("Confirmation date: " + eOrder11.getDateConfirmed() + " Shipment date: " + eOrder11.getDateShipped() + " Total price: " + eOrder11.getTotalPrice());
        System.out.println("Confirmation date: " + eOrder111.getDateConfirmed() + " Shipment date: " + eOrder111.getDateShipped() + " Total price: " + eOrder111.getTotalPrice());
        System.out.println("Confirmation date: " + eOrder112.getDateConfirmed() + " Shipment date: " + eOrder112.getDateShipped() + " Total price: " + eOrder112.getTotalPrice());
        System.out.println("Confirmation date: " + eOrder113.getDateConfirmed() + " Shipment date: " + eOrder113.getDateShipped() + " Total price: " + eOrder113.getTotalPrice());
        System.out.println();

        System.out.println("Confirmation date: " + eOrder2.getDateConfirmed() + " Shipment date: " + eOrder2.getDateShipped() + " Total price: " + eOrder2.getTotalPrice());
        System.out.println("Confirmation date: " + fOrder1.getDateConfirmed() + " Shipment date: " + fOrder1.getDateShipped() + " Total price: " + fOrder1.getTotalPrice());
        System.out.println("Confirmation date: " + fOrder2.getDateConfirmed() + " Shipment date: " + fOrder2.getDateShipped() + " Total price: " + fOrder2.getTotalPrice());

    }
}
