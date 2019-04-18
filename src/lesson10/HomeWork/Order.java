package lesson10.HomeWork;

import java.util.Date;

public abstract class Order {

    private String itemName;         //имя элемента
    private Date dateCreated;        //Дата создания
    private Date dateConfirmed;      //дата подтверждена....
    private Date dateShipped;        //дата отправлена....
    private String shipFromCity;     //корабль из города
    private String shipToCity;       //корабль в город
    private int basePrice;           //базовая цена
    private double totalPrice;       //Итоговая цена....
    private Customer customerOwned;  //Клиент владеет

    public Order(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipFromCity = shipFromCity;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;
        this.customerOwned = customerOwned;
    }

    public abstract void validateOrder();  //проверить заказ

    public abstract void calculatePrice(); //рассчитать цену

    public void confirmShipping(){         //подтвердить доставку
        if (dateShipped == null){
            dateShipped = new Date();   //проставляет дату доставки в текущую если она не проставленна
        }
    }

    public String getItemName() {
        return itemName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateConfirmed() {
        return dateConfirmed;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public String getShipFromCity() {
        return shipFromCity;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomerOwned() {
        return customerOwned;
    }

    public void setDateConfirmed(Date dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
