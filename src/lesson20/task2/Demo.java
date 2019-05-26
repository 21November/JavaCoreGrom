package lesson20.task2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Transaction transaction1 = new Transaction(1001, "Kiev", 10, "pay", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(1002, "Odessa", 10, "pay", TransactionType.OUTCOME, new Date());
        Transaction transaction3 = new Transaction(1003, "Kiev", 20, "pay", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(1004, "Odessa", 20, "pay", TransactionType.OUTCOME, new Date());
        Transaction transaction5 = new Transaction(1005, "Kiev", 10, "pay", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(1006, "Odessa", 20, "pay", TransactionType.OUTCOME, new Date());
        Transaction transaction7 = new Transaction(1007, "Lviv", 10, "pay", TransactionType.INCOME, new Date());
        Transaction transaction8 = new Transaction(1006, null, 20, "pay", TransactionType.OUTCOME, new Date());
        Transaction transaction9 = null;

        Controller controller = new Controller();

        Transaction[] transactions = {transaction1, transaction2, transaction3, transaction4, transaction5, transaction6, transaction7, transaction8, transaction9};

        for (Transaction transaction : transactions) {
            try {
                controller.save(transaction);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(Arrays.toString(controller.transactionList()));
        System.out.println(Arrays.toString(controller.transactionList("Kiev")));
        System.out.println(Arrays.toString(controller.transactionList("Lviv")));
        System.out.println(Arrays.toString(controller.transactionList(10)));
        System.out.println(Arrays.toString(controller.transactionList(null)));
        System.out.println(Arrays.toString(controller.transactionList(900)));


    }
}
