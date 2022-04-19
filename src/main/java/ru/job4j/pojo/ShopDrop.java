package ru.job4j.pojo;

public class ShopDrop {
    public static Book[] delete(Book[] products, int index) {
        for (int i = index; i <= products.length - 2; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}
