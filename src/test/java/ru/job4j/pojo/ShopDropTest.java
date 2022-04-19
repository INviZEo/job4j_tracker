package ru.job4j.pojo;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ShopDropTest {
    @Test
    public void whenDropFirst() {
        Book[] products = new Book[2];
        products[0] = new Book("Milk", 10);
        products[1] = new Book("Bread", 4);
        Book[] rsl = ShopDrop.delete(products, 0);
        assertThat(rsl[0].getName(), is("Bread"));
        assertThat(rsl[1], is(nullValue()));
    }

    @Test
    public void whenDropLast() {
        Book[] products = new Book[2];
        products[0] = new Book("Milk", 10);
        products[1] = new Book("Bread", 4);
        Book[] rsl = ShopDrop.delete(products, 1);
        assertThat(rsl[0].getName(), is("Milk"));
        assertThat(rsl[1], is(nullValue()));
    }

    @Test
    public void whenArrayLengthIs4AndDeleteElementWithIndex1() {
        Book[] products = new Book[4];
        products[0] = new Book("Bread", 4);
        products[1] = new Book("Egg", 10);
        products[2] = new Book("Milk", 2);
        products[3] = new Book("Fish", 3);
        int index = 1;
        Book[] rsl = ShopDrop.delete(products, index);
        assertThat(rsl[index].getName(), is("Milk"));
        assertThat(rsl[2].getName(), is("Fish"));
        assertThat(rsl[products.length - 1], is(nullValue()));
    }

    @Test
    public void whenArrayLengthIs5AndDeleteElementWithIndex2() {
        Book[] products = new Book[5];
        products[0] = new Book("Bread", 4);
        products[1] = new Book("Egg", 10);
        products[2] = new Book("Milk", 2);
        products[3] = new Book("Fish", 3);
        products[4] = new Book("Fruit", 8);
        int index = 2;
        Book[] rsl = ShopDrop.delete(products, index);
        assertThat(rsl[1].getName(), is("Egg"));
        assertThat(rsl[index].getName(), is("Fish"));
        assertThat(rsl[3].getName(), is("Fruit"));
        assertThat(rsl[products.length - 1], is(nullValue()));
    }
}