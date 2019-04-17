package lesson5;

import java.util.Arrays;

public class BanksPractice {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(Arrays.toString(findClientsByBalance(names, balances,-100)));
        System.out.println(Arrays.toString(findClientsWithNegativeBalance(names, balances)));

        depositMoney(names, balances, "Ann", 2000);
        System.out.println(Arrays.toString(balances));
    }

    // Найти клиентов с балансов > n

    static String[] findClientsByBalance(String[] clients, int[] balances, int n){
        //String[] results = new String[clients.length];

        //1. находим количество результатов
        //2. создаем массив с длинной результатов
        //3. записываем результаты

        //1
        int count = 0;
        for (int balance : balances){
            if (balance >= n)
                count++;
        }

        //2
        String[] results = new String[count];

        //3
        int index = 0;
        int resIndex = 0;
        for (int balance : balances){
            if (balance >= n){
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    // Найти клиентов с отрицательным балансом

    static String[] findClientsWithNegativeBalance(String[] clients, int[] balances){
        //String[] results = new String[clients.length];

        //1. находим количество результатов
        //2. создаем массив с длинной результатов
        //3. записываем результаты

        //1
        int count = 0;
        for (int balance : balances){
            if (balance < 0)
                count++;
        }

        //2
        String[] results = new String[count];

        //3
        int index = 0;
        int resIndex = 0;
        for (int balance : balances){
            if (balance < 0){
                results[resIndex] = clients[index];
                resIndex++;
            }
            index++;
        }
        return results;
    }

    // Пополнение баланса с комисией

    static void depositMoney(String[] clients, int[] balances, String client, int money){
        //1. Найти клиента в базе (в нашем случае в массиве)
        //2. Считаем сумму пополнения с учетом коммисии
        //3. Обновляем баланс (пополняем)

        //1. Поиск индекса клиента (ограничение: имена в массиве не должны повторятся)
        //int clientIndex = findClientIndexByName(clients,client);

        //2. Считаем количество денег
        //int moneyToDeposit = calculateDepositAmountAfterCommission(money);


        //3. Обновляем баланс
        balances[findClientIndexByName(clients,client)] += calculateDepositAmountAfterCommission(money);
        //Просто добавляем выситаную сумму к балансу найденного клиента по индексу
    }

    static int findClientIndexByName(String[] clients, String client){ //метод для поиска индекса клиента
        int clientIndex = 0;
        for (String cl : clients){ //мы будем пробегать по всем существующим клиентам до первого нахождения имени клиента
            if (cl == client) {    //проверка текущего имени клиента == ли он имени клиента счет которого мы хотим пополнить
                break;             //если это так то останавливаем цыкл
            }
            clientIndex++;         //если нет, тогда увеличиваем индекс на 1 и идем к следующему
        }
        return clientIndex;
    }

    //Метод для подсчета количества денег
    static int calculateDepositAmountAfterCommission(int money){
        return money <= 100 ? (int) (money - money * 0.02) : (int) (money - money * 0.01);
        //тут будут образовыватся не целые числа, для избежания ошибки используем округление до целого
    }
}
