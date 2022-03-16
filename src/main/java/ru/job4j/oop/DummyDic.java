package ru.job4j.oop;

public class DummyDic {

   public String engToRus(String eng) {
       String word = "Неизвестное слово";
       return word + eng;
    }

    public static void main(String[] args) {
       DummyDic jerk = new DummyDic();
       String man = " dude";
        String say = jerk.engToRus(man);
        System.out.println(say);

    }
}
