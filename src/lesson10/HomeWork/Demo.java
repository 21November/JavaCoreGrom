package lesson10.HomeWork;

import javax.xml.crypto.Data;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Tom", "Киев", "MALE");
        Customer customer2 = new Customer("Vika", "Харьков", "FEMALE");


        Date dateCreated1 = new Date();

        ElectronicsOrder electronicsOrderCustomer1 = new ElectronicsOrder("phone", new Date(), "Одеса", "Киев", 1000, customer1, 12);
        ElectronicsOrder electronicsOrderCuetomer2 = new ElectronicsOrder("phone", dateCreated1, "Одеса","Харьков", 500, customer2,6);

        FurnitureOrder furnitureOrderCustomer1 = new FurnitureOrder("Table", dateCreated1, "Одеса", "Киев",300, customer1, "123456");
        FurnitureOrder furnitureOrderCustomer2 = new FurnitureOrder("Chair", dateCreated1, "Одеса", "Харьков", 100, customer2, "654321");



    }
}
