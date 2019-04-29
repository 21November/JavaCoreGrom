package lesson10.HomeWork;

        import java.util.Date;

public class FurnitureOrder extends Order{
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        // Заказ возможен с городов: Киев, Львов и в любой город.
        // Минимальная цена заказа 500.
        // Так же имя клиента который делает заказ не может быть "Тест", а пол может быть любым
        if (getBasePrice() >= 500 && getCustomerOwned().getName() != "Тест")
            if (getShipFromCity() == "Киев" || getShipFromCity() == "Львов")
                setDateConfirmed(new Date());

    }

    @Override
    public void calculatePrice() {
        // Коммисия за доставку - 5% от суммы заказа если сумма меньше 5000 и 2% в других случаях

        double shippingCost;
        double totalPrice;
        shippingCost = getBasePrice() <= 5000 ? (getBasePrice() * 0.05) : (getBasePrice() * 0.02);
        totalPrice = getBasePrice() + shippingCost;

        setTotalPrice(totalPrice);
    }


}
