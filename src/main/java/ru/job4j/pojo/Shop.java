package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Book[] books) {
        int rsl = -1;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if (books[i] == null) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}

