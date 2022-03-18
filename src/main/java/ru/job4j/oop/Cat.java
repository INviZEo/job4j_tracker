package ru.job4j.oop;

public class Cat {
    private String name;

    private String food;

    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void nickname(String nick) {
        this.name = nick;

    }

    public static void main(String[] args) {
        System.out.println("There are dar`s name and food");
        Cat dar = new Cat();
        dar.nickname("dar");
        dar.eat("sausage");
        dar.show();

    }
}

