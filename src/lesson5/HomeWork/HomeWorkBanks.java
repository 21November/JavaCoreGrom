package lesson5.HomeWork;

import java.util.Arrays;

public class HomeWorkBanks {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, 99, 12000, 54, 0};

       //withdraw(names, balances, "Denis", 1000);
       System.out.println(withdraw(names, balances,"Jack", 1000));
        System.out.println(Arrays.toString(balances));
    }

    static int withdraw(String[] clients, int[] balances, String client, int amount){
        //1. Найти клиента в базе (в нашем случае в массиве)
        //2. проверить количество денег на счету клиента
        //3. вычесть определенную сумму денег со счета
        //4. Обновляем баланс
        int clientIndex = 0;
        for (String cl : clients){
            if (cl == client) {
                break;
            }
            clientIndex++;
        }
        int balance = balances[clientIndex];

        if (balance >= amount) {
            int amountMoney = balance - amount;
            balances[clientIndex] = amountMoney;
            return amountMoney;
        }
        else {
            return -1;
        }
    }
}
