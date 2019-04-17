package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order{
    private int guaranteeMonths; //Месяцы гарантии

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    void validateOrder(){ //проверить заказ
        // заказ возможен с городов: Киев, Одесса, Днепр, Харьков и в один из этих городов. Минимальная цена заказа 100.
        // Так же имя клиента который делает заказ может быть любым, а пол только женским
        String[] cityName = {"Киев", "Одеса", "Днепр", "Харьков"};

        for (int index = 0; index < cityName.length; index++){
            if (getShipFromCity() == cityName[index]){
                if (getShipToCity() == cityName[index]){
                    if (getBasePrice() >= 100){
                        if (getCustomerOwned().getGender() == "FEMALE"){
                            setDateConfirmed(new Date());
                            setDateShipped(new Date());
                        }
                    }
                }
            }
        }
    }

    @Override
    public void calculatePrice(){ //рассчитать цену
        // Цена может состоит из цены товара и цены за доставку. Так же могут быть скидки.
        // Если доставка производится в любой город, кроме Киева и Одессы, то цена за доставку - 15% от суммы заказа.
        // В других случаях 10%. Так же если цена больше 1000 то скидка на заказ 5% после оплаты комиссии за доставку

        //double shippingCharge;
        //double discount;
        double price;
        double totalPrice;
        /*
        if (getShipToCity() != "Киев" && getShipToCity() != "Одеса"){
            shippingCharge = getBasePrice() * 0.15;
        }
        else shippingCharge = getBasePrice() * 0.1;

        totalPrice = getBasePrice() + shippingCharge;*/

        price = (getShipToCity() != "Киев" && getShipToCity() != "Одеса") ? (getBasePrice() + (getBasePrice() * 0.15)) : (getBasePrice() + (getBasePrice() * 0.1));

        totalPrice = price > 1000 ? (price - (price * 0.05)) : price;
        setTotalPrice(totalPrice);
    }


}
