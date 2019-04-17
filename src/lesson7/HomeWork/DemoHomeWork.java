package lesson7.HomeWork;

import lesson6.HomeWork.Order;
import java.util.Date;

public class DemoHomeWork {
    public static void main(String[] args) {
        System.out.println(createOrder());
        System.out.println(createOrderAndCallMethods());
    }

    static Order createOrder(){
        Date date = new Date();
        Order order1 = new Order(100, date, false, null, "Dnepr", "Ukraine", "Buy");
        return order1;
    }

    static Order createOrderAndCallMethods(){
        Date date = new Date();
        Order orderObject = new Order(100, date, true, date, "Kiev", "Ukraine", "SomeValue");

        orderObject.confirmOrder();
        orderObject.checkPrice();
        orderObject.isValidType();

        return orderObject;
    }
}
