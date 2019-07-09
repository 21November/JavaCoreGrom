package lesson30.task1;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Bank euBank = new EUBank(1220, "Sweden", Currency.EUR, 100, 1400, 4, 44343434);

        User user1 = new User(1001, "Denis", 12200, 40, "GMD", 1500, euBank);

        UkrainianBankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(user1,150);

        Thread.sleep(2000);

        bankSystem.withdraw(user1,10);
        System.out.println(bankSystem.getTransactions());
    }
}
