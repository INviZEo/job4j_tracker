package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public int sum(int s) {
        return s + x;
    }

    public int multiply(int m) {
        return m * x;
    }

    public int minus(int a) {
        return a - x;
    }

    public int divide(int d) {
        return d / x;
    }

   public int sumAllOperation(int q) {
        return sum(q) + multiply(q) + minus(q) + divide(q);
   }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(5));
        System.out.println(calculator.multiply(5));
        System.out.println(calculator.minus(5));
        System.out.println(calculator.divide(5));
        System.out.println(calculator.sumAllOperation(5));
    }
}