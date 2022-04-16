package ru.job4j.pojo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class ShopTest {
    @Test
    public void whenLastNull() {
        Book[] books = new Book[5];
        books[0] = new Book("Milk", 10);
        books[1] = new Book("Bread", 4);
        books[2] = new Book("Egg", 19);
        int rsl = Shop.indexOfNull(books);
        assertThat(rsl, is(3));
    }

    @Test
    public void whenFirstNull() {
        Book[] books = new Book[5];
        books[1] = new Book("Milk", 10);
        int rsl = Shop.indexOfNull(books);
        assertThat(rsl, is(0));
    }

    @Test
    public void whenHasNotNull() {
        Book[] books = new Book[1];
        books[0] = new Book("Milk", 10);
        int rsl = Shop.indexOfNull(books);
        assertThat(rsl, is(-1));
    }
}