package lesson30.task1;

public class Main {
    public static void main(String[] args) {
        //Create Main class with main method, where you should create 6 Users: 2 of USBank, 2 of EUBank and 2 of ChinaBank.
        // Run four different operations with every User’s balance and print its objects to console


        Bank usBank = new USBank(1330, "USA", Currency.USD, 150, 1500, 3, 50050050);
        Bank euBank = new EUBank(1220, "Sweden", Currency.EUR, 100, 1400, 4, 44343434);
        Bank chinaBank = new ChinaBank(1440, "China", Currency.USD, 200, 1100, 10, 30050050);

        User user1 = new User(1001, "Denis", 12200, 40, "GMD", 1500, usBank);
        User user2 = new User(1002, "Tom", 1000, 150, "Google", 1500, usBank);
        User user3 = new User(1003, "Jack", 1200, 20, "WaterPro", 1500, euBank);
        User user4 = new User(1004, "Debi", 12500, 50, "Eva", 1500, euBank);
        User user5 = new User(1005, "Sem", 10000, 50, "ALLO", 1500, chinaBank);
        User user6 = new User(1006, "Den", 200, 30, "Vodafon", 1500, chinaBank);

        System.out.println("Bank System US");

        UkrainianBankSystem bankSystem1 = new UkrainianBankSystem();
        bankSystem1.withdraw(user1,150);
        System.out.println(user1.getBalance());
        System.out.println(bankSystem1.getTransactions());
        System.out.println();

        bankSystem1.paySalary(user2);
        System.out.println(user2.getBalance());
        System.out.println(bankSystem1.getTransactions());

        bankSystem1.fund(user2,200);
        System.out.println(user2.getBalance());
        System.out.println(bankSystem1.getTransactions());

        bankSystem1.transferMoney(user2, user1, 500);
        System.out.println(user2.getBalance());
        System.out.println(user1.getBalance());
        System.out.println(bankSystem1.getTransactions());

        System.out.println("Bank System EU");

        BankSystem bankSystem2 = new UkrainianBankSystem();
        bankSystem2.withdraw(user3,500);
        System.out.println(user3.getBalance());
        System.out.println(bankSystem1.getTransactions());
        System.out.println();

        bankSystem2.paySalary(user4);
        System.out.println(user4.getBalance());
        System.out.println(bankSystem1.getTransactions());

        bankSystem2.fund(user4,1200);
        System.out.println(user4.getBalance());
        System.out.println(bankSystem1.getTransactions());

        bankSystem2.transferMoney(user4, user3, 1000);
        System.out.println(user4.getBalance());
        System.out.println(user3.getBalance());
        System.out.println(bankSystem1.getTransactions());

        System.out.println("Bank System China");

        BankSystem bankSystem3 = new UkrainianBankSystem();
        bankSystem3.withdraw(user5,90);
        System.out.println(user5.getBalance());
        System.out.println(bankSystem1.getTransactions());
        System.out.println();

        bankSystem3.paySalary(user6);
        System.out.println(user6.getBalance());

        bankSystem3.fund(user6,1500);
        System.out.println(user6.getBalance());

        bankSystem3.transferMoney(user6, user5, 99);
        System.out.println(user6.getBalance());
        System.out.println(user5.getBalance());
        System.out.println(bankSystem1.getTransactions());
    }
}
