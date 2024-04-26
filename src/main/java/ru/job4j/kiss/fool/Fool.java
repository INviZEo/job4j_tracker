package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static boolean checkAnswer(int number, String answer) {
        boolean result;
        if ((number % 3 == 0) && (number % 5 == 0)) {
            result = "FizzBuzz".equals(answer);
        } else if (number % 3 == 0) {
            result = "Fizz".equals(answer);
        } else if (number % 5 == 0) {
            result = "Buzz".equals(answer);
        } else {
            result = String.valueOf(number).equals(answer);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int startAt = 1;
        Scanner input = new Scanner(System.in);
        while (startAt < 100) {
            if (startAt % 3 == 0 && startAt % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (startAt % 3 == 0) {
                System.out.println("Fizz");
            } else if (startAt % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(startAt);
            }
            startAt++;
            String answer = input.nextLine();
            if (!checkAnswer(startAt, answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }
}