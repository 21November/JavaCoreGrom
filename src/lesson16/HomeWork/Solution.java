package lesson16.HomeWork;

import static java.lang.Character.isLetter;
import static java.lang.Character.isLetterOrDigit;


public class Solution {
    public static void main(String[] args) {
        String test = "There is Test something new op jot sdf sdf sdf word Test op or";

        System.out.println(countWords(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));
        System.out.println(mostCountedWord(test));

        String test1 = "https://www.google.org";
        System.out.println(validate(test1));
    }


    public static int countWords(String input) {
        if (input == null || input.isEmpty()) //проверка стринга на наявность символов в нем
            return 0;

        int count = 0;

        String[] words = input.split(" "); //создаем массив подстрингов

        for (String testWord : words) {
            if (checkWord(testWord) == true) //проверяем каждый подстринг на наличие буквенных символов
                count++;
        }
        return count;
    }

    private static boolean checkWord(String str) {
        //проверка сиволов массива буквы они или нет


        char[] arr = str.toCharArray();
        boolean checkLetter = false;
        for (Character ch : arr) {
            if (isLetter(ch))   //определяем является ли указаный сивол буквой
                checkLetter = true;
            else {
                checkLetter = false;
                break;
            }
        }
        return checkLetter;
    }

    public static String maxWord(String input){
        if (input == null || input.isEmpty()) //проверка стринга на наявность символов в нем
            return null;

        String longWord = "";
        int l = 0;

        String[] words = input.split(" ");

        for (String word : words){
            if (!checkWord(word))
                continue;

            if(word.length() > l){
                longWord = word;
                l = word.length();
            }
        }
        if (longWord.isEmpty())
            return null;

        return longWord;
    }


    public static String minWord(String input){
        if (input == null || input.isEmpty()) //проверка стринга на наявность символов в нем
            return null;

        String shortWord = "";
        int s = input.length();

        String[] words = input.split(" ");

        for (String word : words){
            if (!checkWord(word))
                continue;

            if (shortWord.isEmpty())
                shortWord = word;

            else if(word.length() < s){
                shortWord = word;
                s = word.length();
            }
        }

        if (shortWord.isEmpty() || shortWord.equals(" "))
            return null;

        return shortWord;
    }

    public static String mostCountedWord(String input){
        if (input == null || input.isEmpty()) //проверка стринга на наявность символов в нем
            return null;

        String[] words = input.split(" "); //создаем массив подстрок

        int maxCount = 0;
        String resultString = "";
        for (int i = 0; i < words.length; i++) {
            if (!checkWord(words[i]))
                continue;
            int count = 1;
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j]))
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                resultString = checkWord(words[i]) ? words[i] : "";
            }
        }
        return resultString.isEmpty() ? null : resultString;
    }

    public static boolean validate(String address){
        //Требования:
        //адресс должен начинаться с названия протокола, допустимые - http:// или https://
        //www не обязательно
        //доменная зона должна разделяться точкой, допустимые - com, org, net
        //другие точки в названии адреса а так же спецчимволы не допускаются

        if (address == null || address.isEmpty())
            return false;

        String[] startWordArr = new String[]{"http://", "https://"}; //адресс должен начинаться с названия протокола, допустимые - http:// или https://
        String[] finishWordArr = new String[]{".com", ".org", ".net"}; //доменная зона должна разделяться точкой, допустимые - com, org, net

        String updateAddress = address.toLowerCase();

        boolean start = false;
        boolean finish = false;

        for (String strStart : startWordArr) {
            if (updateAddress.startsWith(strStart)) {
                start = true;
                updateAddress = updateAddress.replace(strStart, "");
                break;
            }
        }

        for (String strFinish : finishWordArr) {
            if (updateAddress.endsWith(strFinish)) {
                finish = true;
                updateAddress = updateAddress.replace(strFinish, "");
                break;
            }
        }

        String updateTwoWord = updateAddress.replace("www.", "");

        char[] arr = updateTwoWord.toCharArray();
        for (char ch : arr) {
            if (!isLetterOrDigit(ch)) {
                return false;
            }
        }
        return (start && finish);
    }
}
