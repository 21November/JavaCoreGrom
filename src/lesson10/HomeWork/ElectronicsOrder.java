package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order{
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        // заказ возможен с городов: Киев, Одесса, Днепр, Харьков и в один из этих городов.
        // Минимальная цена заказа 100. Так же имя клиента который делает заказ может быть любым, а пол только женским
        if (getBasePrice() >= 100 && getCustomerOwned().getGender() == "Женский")
            if (getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Днепр" || getShipFromCity() == "Харьков" )
                if (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков" )
                    setDateConfirmed(new Date());
    }

    @Override
     public void calculatePrice() {
        // Цена может состоит из цены товара и цены за доставку. Так же могут быть скидки.
        // Если доставка производится в любой город, кроме Киева и Одессы, то цена за доставку - 15% от суммы заказа.
        // В других случаях 10%. Так же если цена больше 1000 то скидка на заказ 5% после оплаты комиссии за доставку
        double price;
        double totalPrice;

        price = (getShipToCity() != "Киев" && getShipToCity() != "Одеса") ? (getBasePrice() + (getBasePrice() * 0.15)) : (getBasePrice() + (getBasePrice() * 0.1));

        totalPrice = price > 1000 ? (price - (price * 0.05)) : price;
        setTotalPrice(totalPrice);
    }

}
