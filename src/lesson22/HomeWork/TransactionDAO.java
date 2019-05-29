package lesson22.HomeWork;

import lesson22.HomeWork.exception.BadRequestException;
import lesson22.HomeWork.exception.InternalServerException;
import lesson22.HomeWork.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];
    private static Utils utils = new Utils();


    public Transaction save (Transaction transaction)throws Exception{
//        Бизнес логика:
//        сумма транзакции больше указаного лимита +
//        сумма транзакции за день больше дневного лимита +
//        количество транзакций за день больше указаного лимита +
//        если город оплаты (совершения транзакции) не разрешен
//        Возможные системные ошибки:
//        не хватило места

        validate(transaction);

        int i = 0;
        for (Transaction t : transactions) {
            if (t == null) {
                transactions[i] = transaction;
                return transactions[i];
            }
            i++;
        }
        // недостаточно места в массиве
        throw new InternalServerException("Not enough space to save transaction " + transaction.getId());
    }

    private void validate(Transaction transaction) throws BadRequestException {
        //        проверка на ноль
        if (transaction == null)
            throw new BadRequestException("Transaction is null. Can't be saved");

        //        сумма транзакции больше указаного лимита
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can`t be saved");

        //        сумма транзакции за день больше дневного лимита
        int sum = 0;
        int count = 0;
        for(Transaction tr : getTransactionsPerDay(transaction.getDateCreated())){
            if (tr != null){
                sum += tr.getAmount();
                count++;
            }
        }

        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()){
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can`t be saved");
        }

        //        количество транзакций за день больше указаного лимита
        if (count >= utils.getLimitTransactionsPerDayCount()){
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can`t be saved");
        }

        //        если город оплаты (совершения транзакции) не разрешен
        for (String city : utils.getCities()) {
            if (city != null && city.equals(transaction.getCity()))
                return;
        }
        throw new BadRequestException("City " + transaction.getCity() + " is not allowed for transactions. Transaction "
                + transaction.getId() + " is not saved.");
    }

    public Transaction[] transactionList(){
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null)
                count++;
        }

        Transaction[] transactionsToReturn = new Transaction[count];

        if (count == 0) return transactionsToReturn;

        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                transactionsToReturn[index] = transaction;
                index++;
            }
        }
        return transactionsToReturn;
    }

    public Transaction[] transactionList(String city){

        int count = 0;
        for (Transaction transaction : transactions){
            if (city != null && transaction != null && city.equals(transaction.getCity())){
                count++;
            }
        }

        Transaction[] transactionsToReturn = new Transaction[count];

        int index = 0;
        for (Transaction transaction : transactions){
            if (transaction != null && city != null && city.equals(transaction.getCity())){
                transactionsToReturn[index] = transaction;
                index++;
            }
        }
        return transactionsToReturn;
    }

    public Transaction[] transactionList(int amount){

        int count = 0;
        for (Transaction transaction : transactions){
            if (transaction != null && transaction.getAmount() == amount){
                count++;
            }
        }

        Transaction[] transactionsToReturn = new Transaction[count];

        int index = 0;
        for (Transaction transaction : transactions){
            if (transaction != null && transaction.getAmount() == amount){
                transactionsToReturn[index] = transaction;
                index++;
            }
        }
        return transactionsToReturn;
    }

    private Transaction[] getTransactionsPerDay (Date dateOfCurTransaction){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions){
            if (transaction != null){
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }
        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions){
            if (transaction != null){
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }
}
