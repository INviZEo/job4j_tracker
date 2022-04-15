package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book0 = new Book("bookOne", 13);
        Book book1 = new Book("bookTwo", 42);
        Book book2 = new Book("bookThree", 31);
        Book book3 = new Book("clean code", 25);
        Book[] bok = new Book[4];
        bok[0] = book0;
        bok[1] = book1;
        bok[2] = book2;
        bok[3] = book3;
        for (int i = 0; i < bok.length; i++) {
            Book bk = bok[i];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        bok[0] = book3;
        bok[3] = book0;
        System.out.println(" + ");
        for (int i = 0; i < bok.length; i++) {
            Book bk = bok[i];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println(" + ");
        for (int i = 0; i < bok.length; i++) {
            Book bk = bok[i];
            if ("clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getPages());
            }
        }
    }
}